package servlet;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 27, 2016
 * 
 * 1. Get model list from server
 * 2. Let user to select a model
 * 3. HTTP GET Request to OptionSelectServlet
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.DefaultSocketClient;

/**
 * Servlet implementation class ModelSelectSevlet
 */
@WebServlet("/ModelSelectServlet")
public class ModelSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DefaultSocketClient client;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModelSelectServlet() {
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
		
		String ModelList = client.inputDetect(objectInputStream).toString();
		String[] temp = ModelList.split("[.\n]");
		ArrayList<String> models = new ArrayList<>();
		for(int i=1; i<temp.length; i=i+2) {
			models.add(temp[i]);
		}
		objectOutputStream.writeObject("0");
		objectOutputStream.flush();
		
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType);
		out.println("<HTML>");
		out.println("<head>");
		out.println("<title>Model Selection</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Choose One Available Car Model</h1>");
		out.println("<form action='OptionSelectServlet' method='GET'>");
		out.println("<select name='model'>");
		for(int i=0; i<models.size(); i++) {
			out.println("<option value='"+(i+1)+"'>"+models.get(i)+"</option>");
		}
		out.println("</select>");
		out.println("<input type='submit' value='Done'>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</HTML>");
//		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
