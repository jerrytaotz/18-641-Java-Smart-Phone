package servlet;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 27, 2016
 * 
 * 1. Get option list of the select model from server
 * 2. Let user to select configuration options
 * 3. HTTP POST to result.jsp
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.DefaultSocketClient;
import client.SelectCarOption;

/**
 * Servlet implementation class OptionSelectServelt
 */
@WebServlet("/OptionSelectServlet")
public class OptionSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DefaultSocketClient client;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) {
		String localhost = "";
    	try {
		localhost = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			System.err.println ("Unable to find local host");
		}
    	int port = 8080;
    	Socket Socket = null;
		try {
			Socket = new Socket(localhost, port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("[Connect Attention] Can Not Connect To The Server: " + localhost + ":" + port);
		}
		client = new DefaultSocketClient(Socket, localhost, port);
		client.openConnection();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectOutputStream objectOutputStream = this.client.getObjectOutputStream();
		ObjectInputStream objectInputStream = this.client.getObjectInputStream();
		String from_server = "";
		from_server= client.inputDetect(objectInputStream).toString();
		System.out.println(from_server);
		from_server= client.inputDetect(objectInputStream).toString();
		System.out.println(from_server);
		from_server= client.inputDetect(objectInputStream).toString();
		System.out.println(from_server);
		
//		Choose the configuration method
		objectOutputStream.writeObject("2");
		objectOutputStream.flush();
		
		String ModelList = "";
		try {
			ModelList = (String) objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] temp = ModelList.split("[.\n]");
		ArrayList<String> models = new ArrayList<>();
		for(int i=1; i<temp.length; i=i+2) {
			models.add(temp[i]);
		}
		
		String modelNum = request.getParameter("model");
		client.outputObject(modelNum);
		
		from_server= client.inputDetect(objectInputStream).toString();
		System.out.println(from_server);
		
		from_server= client.inputDetect(objectInputStream).toString();
		System.out.println(from_server);
		
//		Get the automobile properties
		Properties prop = (Properties) client.inputDetect(objectInputStream);
		SelectCarOption select_option = new SelectCarOption(prop);
		String name = select_option.getName();
		String base_price = "" + select_option.getBasePrice();
		ArrayList<String> opset_names = select_option.getOptionSet();
		ArrayList<ArrayList<String[]>> optionSet_detail = select_option.getOption();
		
//		Close the socket first
		client.outputObject("0");
		
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType);
		out.println("<HTML>");
		out.println("<head>");
		out.println("<title>Option Selection</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Basic Car Choice</h1>");
		out.println("<form action='result.jsp' method='POST'>");
		out.println("<input type='hidden' name='totalOptionNum' value='" + opset_names.size() + "'>");
		out.println("<input type='hidden' name='name' value='" + name + "'>");
		out.println("<input type='hidden' name='baseprice' value='" + base_price + "'>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>Make/Model</td>");
		out.println("<td>"+ name +"</td>");
		out.println("</tr>");
		for(int i=0; i<opset_names.size(); i++) {
			out.println("<tr>");
			out.println("<td>" + opset_names.get(i) + "</td>");
			out.println("<td>");
			ArrayList<String[]> one_opset_detail = optionSet_detail.get(i);
			out.println("<select name='optionSet"+i+"'>");
			for(int j=0; j<one_opset_detail.size(); j++) {
//				String[] option_pair
				out.println("<option value='" + opset_names.get(i) + "," + one_opset_detail.get(j)[0] + "," + one_opset_detail.get(j)[1]+"'>"+one_opset_detail.get(j)[0]+"</option>");
			}
			out.println("</select>");
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("<tr>");
		out.println("<td colspan='2' style='text-align: right'><input type='submit' value='Done'></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</select>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</HTML>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
