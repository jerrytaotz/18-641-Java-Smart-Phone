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

import client.Client;

public class StartClient {
	public static void main(String[] args) {
		Client new_client = new Client();
		new_client.runClient();
	}
}