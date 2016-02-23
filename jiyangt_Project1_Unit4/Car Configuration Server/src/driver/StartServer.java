package driver;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 13, 2016
 * 
 * Implements the test case
 * four threads to modify same model
 * (Each time, only one thread can modify the same model)
 * threads modify different models can work parallelly
 */

import server.Server;

public class StartServer {
	public static void main(String[] args) {
		Server new_Server = new Server();
	}
}