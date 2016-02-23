package client;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 19, 2016
 * 
 * This interface defines the function of socket
 */
public interface SocketClientInterface {
	public boolean openConnection();
    public void handleSession();
    public void closeSession();
}