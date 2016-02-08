package adapter;
import java.io.IOException;

import model.CarModels;
import exception.*;
/**
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 3, 2016
 * 
 * This class implements the methods declared in the interface:
 * BuildAuto, printAuto, updateOptionSetName, updateOptionPrice
 */
import model.*;
import util.*;
public abstract class ProxyAutomobile {
	private static CarModels autoLists = new CarModels();
	
	public void BuildAuto(String fileName) {
		try {
			autoLists.setAutomobile(fileName);
		} catch(AutoException e) {
			this.fix(e.getExceptionIndex());
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
			this.BuildAuto(filename);
			break;
		default:
			break;
		}
	}
}