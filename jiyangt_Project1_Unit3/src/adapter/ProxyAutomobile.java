package adapter;
import model.CarModels;
import scale.EditOptions;
import scale.EditOptions.EditOptionEnumerator;
import exception.*;
import model.*;
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