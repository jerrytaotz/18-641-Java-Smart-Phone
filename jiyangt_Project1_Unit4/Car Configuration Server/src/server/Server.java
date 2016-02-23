package server;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 19, 2016
 * 
 * Code to let begin listening the port
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements SocketServerConstant {
	private int Port;
	
	public Server() {
		this.Port = SERVER_PORT;
		this.runServer();
	}
	
	public void runServer() {
		System.out.println("Starting A New Server ...");
		ServerSocket Server_Socket = null;
		try {
			Server_Socket = new ServerSocket(this.Port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("[Listen Attention] Can Not Listen To The Port: " + this.Port);
		}
		if(Server_Socket != null) {
			System.out.println("Server build successfully!");
			System.out.println("Begin listening to the port: " + this.Port);
			while(true) {
				try {
					Socket Client_Socket = Server_Socket.accept();
					DefaultSocketClient default_client = new DefaultSocketClient(Client_Socket, this.Port);
					new Thread(default_client).start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.err.println("[Accept Attention] Accept Failed");
					System.exit(1);
				}
				
			}
		}
	}
}