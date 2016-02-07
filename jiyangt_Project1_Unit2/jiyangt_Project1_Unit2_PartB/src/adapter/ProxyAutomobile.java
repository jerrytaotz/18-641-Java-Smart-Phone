package adapter;
import java.io.IOException;

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
	private static Automobile a1;
	
	public void BuildAuto(String fileName) {
		FileIO fio = new FileIO();
		try {
			a1 = fio.buildAutoObject(fileName, a1);
		} catch(AutoException e) {
			this.fix(e.getExceptionIndex());
		} catch(IOException e) {
			System.out.println(e.toString());
		}
	}
	
	public void printAuto(String Modelname) {
		a1.printAll();
	}
	
	public void updateOptionSetName(String ModelName, String OptionSetName, String newName) {
		a1.updateOpsetName(OptionSetName, newName);
	}
	
	public void updateOptionPrice(String ModelName, String OptionName, String Option, float newPrice) {
		a1.updateOptionPrice(OptionName, Option, newPrice);
	}
	
	public void fix(int errno) {
		ExceptionFixHelper fix = new ExceptionFixHelper();
		switch(errno) {
		case 1:
			String filename = fix.fixWrongFileName();
			this.BuildAuto(filename);
			break;
		case 2:
			break;
		default:
			break;
		}
	}
}