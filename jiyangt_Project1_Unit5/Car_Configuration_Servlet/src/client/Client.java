package client;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 19, 2016
 * 
 * The client side code, that can connect with server
 */
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements SocketClientConstant {
	private int server_Port;
	private String server_Host;
	public DefaultSocketClient default_client;
	
	public Client() {
		this.server_Port = SERVER_PORT;
		try {
			this.server_Host = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			System.err.println ("Unable to find local host");
		}
	}
	
	public void runClient() {
		System.out.println("Connecting To Server " + this.server_Host + ":" + this.server_Port + "...");
		Socket Socket = null;
		try {
			Socket = new Socket(this.server_Host, this.server_Port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("[Connect Attention] Can Not Connect To The Server: " + this.server_Host + ":" + this.server_Port);
		}
		if(Socket != null) {
			default_client = new DefaultSocketClient(Socket, this.server_Host, this.server_Port);
			new Thread(default_client).start();
		}
	}
}