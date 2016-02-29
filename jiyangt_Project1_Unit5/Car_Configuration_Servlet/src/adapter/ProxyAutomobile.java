package adapter;
import model.CarModels;
import scale.EditOptions;
import scale.EditOptions.EditOptionEnumerator;

import java.util.Properties;

import exception.*;
import model.*;
import util.FileIO;
/**
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 3, 2016
 * 
 * This class implements the methods declared in the interface:
 * BuildAuto, printAuto, updateOptionSetName, updateOptionPrice
 */
public abstract class ProxyAutomobile {
	private static CarModels autoLists = new CarModels();
	private static int threadID = 1;
	
	public void parseAuto(Properties prop) {
		try {
			autoLists.setAutomobile(prop);
		} catch (AutoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Properties getAutoFile(String fileName, String fileType) {
		Properties prop = null;
		try {
			prop = autoLists.getAutoFile(fileName, fileType);
		} catch (AutoException e) {
			this.fix(e.getExceptionIndex());
		}
		return prop;
	}
	
	public void BuildAuto(String fileName, String fileType) {
		Properties prop = this.getAutoFile(fileName, fileType);
		try {
			autoLists.setAutomobile(prop);
		} catch (AutoException e) {
			System.err.println(e.toString());
		}
	}
	
	public void printAuto(String Modelname) {
		try {
			autoLists.getAutomobile(Modelname).printAll();
		} catch (AutoException e) {
			this.fix(e.getExceptionIndex());
		}
	}
	
	public void updateOptionSetName(String ModelName, String OptionSetName, String newName) {
		try {
			autoLists.getAutomobile(ModelName).updateOpsetName(OptionSetName, newName);
		} catch (AutoException e) {
			this.fix(e.getExceptionIndex());
		}
	}
	
	public void updateOptionPrice(String ModelName, String OptionName, String Option, float newPrice) {
		try {
			autoLists.getAutomobile(ModelName).updateOptionPrice(OptionName, Option, newPrice);
		} catch (AutoException e) {
			this.fix(e.getExceptionIndex());
		}
	}
	
	public void deleteOptionSet(String ModelName, String OptionName) {
		try {
			autoLists.deleteOptionSet(ModelName, OptionName);
		} catch (AutoException e) {
			this.fix(e.getExceptionIndex());
		}
	}
	
	public void fix(int errno) {
		ExceptionFixHelper fix = new ExceptionFixHelper();
		switch(errno) {
		case 1:
			String filename = fix.fixWrongFileName();
			String fileType = fix.fixWrongFileType();
			this.getAutoFile(filename, fileType);
			break;
		default:
			break;
		}
	}
	
	public void edit(EditOptionEnumerator editOptionEnumerator, String[] args) {
		Automobile auto;
		try {
			auto = autoLists.getAutomobile(args[0]);
			EditOptions edit_option = new EditOptions(threadID++, auto, editOptionEnumerator, args);
			new Thread(edit_option).start();
		} catch (AutoException e) {
			// TODO Auto-generated catch block
			this.fix(e.getExceptionIndex());
		}
	}
}