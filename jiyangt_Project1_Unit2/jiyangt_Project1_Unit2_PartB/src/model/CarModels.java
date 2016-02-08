package model;

import util.FileIO;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import exception.*;
import model.OptionSet.Option;

public class CarModels {
	private static LinkedHashMap<String, Automobile> carsLists;
	
	public CarModels() {
		carsLists = new LinkedHashMap<String, Automobile>();
	}
	/**
	 * Setter
	 */
	public void setAutomobile(Automobile auto) {
		carsLists.put(auto.getName(), auto);
	}
	
	public void setAutomobile(String filename) throws AutoException {
		Automobile auto = null;
		auto = new FileIO().buildAutoObject(filename, auto);
		carsLists.put(auto.getName(), auto);
	}
	
	/**
	 * Getter
	 */
	public Automobile getAutomobile(String name) throws AutoException {
		Iterator<Entry<String, Automobile>> iterator = carsLists.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, Automobile> entry = iterator.next();
			if(entry.getKey().equals(name)) {
				return entry.getValue();
			}
		}
		throw new AutoException(EnumerationAutoException.WrongCarModel);
	}
	
	public OptionSet getOptionSet(String name, String opsetName) throws AutoException {
		Automobile auto = this.getAutomobile(name);
		OptionSet opset = auto.findOpset(opsetName);
		if(opset != null) {
			return opset;
		}
		throw new AutoException(EnumerationAutoException.WrongOptionSetName);
	}
	
	public Option getOption(String name, String opsetName, String optionName) throws AutoException {
		OptionSet opset = this.getOptionSet(name, opsetName);
		Option opt = opset.getOption(optionName);
		if(opt != null) {
			return opt;
		}
		throw new AutoException(EnumerationAutoException.WrongOptionName);
	}
	
	/**
	 * Update
	 */
    public void updateBasePrice(String name, float newPrice) throws AutoException {
		Automobile auto = this.getAutomobile(name);
		auto.setBasePrice(newPrice);
	}
    
    public void updateMake(String name, String make) throws AutoException {
    	Automobile auto = this.getAutomobile(name);
		auto.setMake(make);
		String model = auto.getModel();
		auto.setName(make + " " + model);
    }
    
    public void updateModel(String name, String model) throws AutoException {
    	Automobile auto = this.getAutomobile(name);
		auto.setMake(model);
		String make = auto.getMake();
		auto.setName(make + " " + model);
    }
    
    public void updateMakeAndModel(String name, String make, String model) throws AutoException {
    	Automobile auto = this.getAutomobile(name);
		auto.setMake(make);
		auto.setModel(model);
		auto.setName(make + " " + model);
    }
    
	public void updateOptionSetName(String name, String opsetName, String newName) throws AutoException {
		OptionSet opset = this.getOptionSet(name, opsetName);
		opset.setName(newName);
	}
	
	public void updateOptionName(String name, String opsetName, String optionName, String newName) throws AutoException {
		Option opt = this.getOption(name, opsetName, optionName);
		opt.setOptName(newName);
	}
	
	public void updateOptionPrice(String name, String opsetName, String optionName, float optionPrice) throws AutoException {
		Option opt = this.getOption(name, opsetName, optionName);
		opt.setOptPrice(optionPrice);
	}
	
	
	/**
	 * Deleter
	 * @throws AutoException 
	 */
	public void deleteAutomobil(String name) throws AutoException {
		Automobile auto = this.getAutomobile(name);
		carsLists.remove(name);
	}
	
	public void deleteOptionSet(String name, String opsetName) throws AutoException {
		OptionSet opset = this.getOptionSet(name, opsetName);
		carsLists.get(name).deleteOpset(opsetName);
	}
	
	public void deleteOption(String name, String opsetName, String optionName) throws AutoException {
		Option opt = this.getOption(name, opsetName, optionName);
		carsLists.get(name).findOpset(opsetName).deleteOpt(optionName);
	}
	
	/**
	 * Choice
	 * @throws AutoException 
	 */
	public void setChoice(String name, String opsetName, String optionName) throws AutoException {
		OptionSet opset = this.getOptionSet(name, opsetName);
		opset.setOptionChoice(optionName);
	}
}