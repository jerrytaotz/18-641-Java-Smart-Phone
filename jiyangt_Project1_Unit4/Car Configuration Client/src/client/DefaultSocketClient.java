package client;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 19, 2016
 * 
 * The default socket client, realize the main function of the client
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;

import adapter.BuildAuto;
import exception.AutoException;
import util.FileIO;

public class DefaultSocketClient implements Runnable, SocketClientInterface, SocketClientConstant {
    private Socket socket;
    private String server_HOST;
    private int server_PORT;
    private ObjectInputStream objectInputStream = null;
	private ObjectOutputStream objectOutputStream = null;
	private BufferedReader type_in = new BufferedReader(new InputStreamReader(System.in));

    public DefaultSocketClient(Socket clientSocket, String server_HOST, int server_PORT) {
    	this.socket = clientSocket;
    	this.server_HOST = server_HOST;
    	this.server_PORT = server_PORT;
    }//constructor

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(this.openConnection()) {
			this.handleSession();
			this.closeSession();
		}
	}

	@Override
	public boolean openConnection() {
		try {
//			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			this.objectInputStream = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e){
			if (DEBUG) 
				System.err.println("[Connection Error] Unable to obtain stream to/from " + this.server_HOST + ":" + this.server_PORT);
		    return false;
		}
		return true;
	}

	
	@Override
	public void handleSession() {
		// TODO Auto-generated method stub
		String inputString = null;
		inputString = this.inputDetect().toString();
		if(inputString.startsWith("Connected to Port")) {
			System.out.println(inputString);
			System.out.println("Start working with " + this.server_HOST + ":" + this.server_PORT);
		}
		while(true) {
			inputString = this.inputDetect().toString();
			System.out.println(inputString);
			if(inputString.equals(CHOOSE_REQUIRE)) {
				try {
					String client_choice = type_in.readLine();
					this.outputObject(client_choice);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(inputString.equals(FILE_REQUIRE)) {
//				Properties prop = this.getModelFile(inputString);
				Properties prop = new CarModelOptionsIO().getModelFile(inputString);
				this.outputObject(prop);
			}
			else if(inputString.equals(CAR_CONFIGURATION)) {
				Properties prop = (Properties) this.inputDetect();
				SelectCarOption select = new SelectCarOption(prop);
				ArrayList<String> my_configuration = select.Configuration();
				this.outputObject(my_configuration);
			}
			else if(inputString.equals(CLOSE_SOCKET)) {
				System.out.println("The scoket close");
				break;
			}
		}
	}

	
	@Override
	public void closeSession() {
		// TODO Auto-generated method stub
		try {
			this.objectInputStream = null;
	        this.objectOutputStream = null;
	        this.socket.close();
	    } catch (IOException e){
	    	if (DEBUG) System.err.println
	        ("Error closing socket to " + this.server_HOST);
	    }
	}
	
	
	private void outputObject(Object obj) {
		try {
			this.objectOutputStream.writeObject(obj);
			this.objectOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Object inputDetect() {
		Object result = null;
		try {
			result = this.objectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
//	private Properties getModelFile(String inputString) {
//		Properties prop = null;
//		try {
//			String filename;
//			String fileType;
//			while(true){
//				filename = type_in.readLine();
//				if(filename.endsWith("properties")) {
//					fileType = "properties";
//					break;
//				}
//				if(filename.endsWith("txt")) {
//					fileType = "txt";
//					break;
//				}
//				System.out.println("Wrong Input!");
//				System.out.print(inputString);
//			}
//			prop = new FileIO().getObject(filename, fileType);
//		} catch (IOException | AutoException e) {
//			System.out.println("The File Is Not Exist!");
//			System.out.print(inputString);
//			this.getModelFile(inputString);
//		}
//		return prop;
//	}


	
//	public void setServerPort(int server_port) {
//		this.server_port = server_port;
//	}
//	
//	public void setServerHost() {
//		try {
//			this.server_host = InetAddress.getLocalHost().getHostAddress();
//		} catch (UnknownHostException e) {
//			System.err.println ("Unable to find local host");
//		}
//	}
	
}