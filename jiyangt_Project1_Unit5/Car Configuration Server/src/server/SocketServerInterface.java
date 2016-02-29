package server;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 19, 2016
 * 
 * The interface define several function of server
 */
public interface SocketServerInterface {
	public boolean openConnection();
    public void handleSession();
    public void closeSession();
}