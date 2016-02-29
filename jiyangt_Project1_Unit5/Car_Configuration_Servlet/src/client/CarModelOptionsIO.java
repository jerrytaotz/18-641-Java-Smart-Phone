package client;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 19, 2016
 * 
 * Load the automobile file
 * 1. '.txt' file is available
 * 2. '.properties' file is available
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import exception.AutoException;
import util.FileIO;

public class CarModelOptionsIO {
	private BufferedReader type_in = new BufferedReader(new InputStreamReader(System.in));
	
	public CarModelOptionsIO() {
		
	}
	
	public Properties getModelFile(String inputString) {
		Properties prop = null;
		try {
			String filename;
			String fileType;
			while(true){
				filename = type_in.readLine();
				if(filename.endsWith("properties")) {
					fileType = "properties";
					break;
				}
				if(filename.endsWith("txt")) {
					fileType = "txt";
					break;
				}
				System.out.println("Wrong Input!");
				System.out.print(inputString);
			}
			prop = new FileIO().getObject(filename, fileType);
		} catch (IOException | AutoException e) {
			System.out.println("The File Is Not Exist!");
			System.out.print(inputString);
			this.getModelFile(inputString);
		}
		return prop;
	}
}