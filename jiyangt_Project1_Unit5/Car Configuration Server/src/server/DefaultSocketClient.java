package server;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 19, 2016
 * 
 * the DefaultSocketClient,
 * Realize the main function of the server, handle the incoming properties and store them,
 * select the specific automobile, send back to client
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;

import adapter.BuildAuto;
import exception.AutoException;
import model.Automobile;

public class DefaultSocketClient implements Runnable, SocketServerInterface, SocketServerConstant {
    private Socket socket;
    private String host;
    private int port;
    private ObjectInputStream objectInputStream = null;
	private ObjectOutputStream objectOutputStream = null;
	private BuildCarModelOptions carModels = new BuildCarModelOptions();

    public DefaultSocketClient(Socket clientSocket, int port) {
    	this.socket = clientSocket;
    	this.port = port;
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
			this.objectInputStream = new ObjectInputStream(socket.getInputStream());
			this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		} catch (Exception e){
			if (DEBUG) {
				System.err.println("Unable to obtain stream to/from " + this.port);
			}
		    return false;
		}
		return true;
	}

	
	@Override
	public void handleSession() {
		// TODO Auto-generated method stub
		System.out.println("Starting working on Port " + this.port);
		this.outputObject("Connected to Port " + this.port);
		while(true) {
			this.outputObject(MENU);
			this.outputObject(CHOOSE_REQUIRE);
			String choice_index = this.inputObject().toString();
			if("0".equals(choice_index)) {
				this.outputObject(CLOSE_SOCKET);
				System.out.println("Close one socket");
				break;
			}
			if("1".equals(choice_index)) {
				this.outputObject(FILE_REQUIRE);
				Object obj = this.inputObject();
				Properties prop = (Properties) obj;
				if(this.carModels.parseAuto(prop)) {
					System.out.println("Model upload success!");
					this.outputObject(BUILD_SUCCESS);
				}
				else {
					System.out.println("Model upload fail!");
					this.outputObject(BUILD_FALSE);
				}
			}
			else if("2".equals(choice_index)) {
				ArrayList<String> models = this.carModels.getModelList();
				int i = 1;
				String model_list = "";
				for(String model: models) {
					model_list += "" + i + ". " + model + "\n";
					i ++;
				}
				this.outputObject(model_list);
				this.outputObject(CHOOSE_REQUIRE);
				choice_index = this.inputObject().toString();
				int choice_num = Integer.parseInt(choice_index);
				String choice_model_name = models.get(choice_num-1);
				System.out.println("User Chose " + choice_model_name);
				Properties prop = this.carModels.getAutoProperty(choice_model_name);
				this.outputObject(CAR_CONFIGURATION);
				this.outputObject(prop);
				System.out.println(this.inputObject().toString());
			}
			else {
				this.outputObject("An Illegal Input, Please Choose 0,1,2");
				continue;
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
	        ("Error closing socket to " + this.host);
	    }
	}
	
	private void outputObject(Object obj) {
		try {
			this.objectOutputStream.writeObject(obj);
//			this.objectOutputStream.flush();
		} catch (IOException e) {
			System.err.println(e.toString());
			e.printStackTrace();
		}
	}
	
	private Object inputObject() {
		Object result = null;
		try {
			result = this.objectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
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