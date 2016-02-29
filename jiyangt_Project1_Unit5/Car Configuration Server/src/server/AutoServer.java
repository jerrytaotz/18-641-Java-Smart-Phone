package server;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 19, 2016
 * 
 * Define several function for server
 */
import java.util.ArrayList;
import java.util.Properties;

public interface AutoServer {
	
	public boolean parseAuto(Properties prop);
	public ArrayList<String> getModelList();
	public Properties getAutoProperty(String modelname);
}