package server;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 19, 2016
 * 
 * Implement the functions
 */
import java.util.ArrayList;
import java.util.Properties;

import adapter.BuildAuto;

public class BuildCarModelOptions implements AutoServer {
	private AutoServer buildAuto;
	
	public BuildCarModelOptions() {
		this.buildAuto = new BuildAuto();
	}

	@Override
	public boolean parseAuto(Properties prop) {
		// TODO Auto-generated method stub
		return buildAuto.parseAuto(prop);
	}
	
	public ArrayList<String> getModelList() {
		return buildAuto.getModelList();
	}
	
	public Properties getAutoProperty(String modelname) {
		return buildAuto.getAutoProperty(modelname);
	}
	
}