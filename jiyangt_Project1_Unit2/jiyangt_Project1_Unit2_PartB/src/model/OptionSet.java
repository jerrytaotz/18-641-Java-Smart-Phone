package model;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 28, 2016
 * 
 * OptionSet class defines car's configuration items
 * Here is an inner class in this class
 */

import java.io.Serializable;
import java.util.ArrayList;

import exception.AutoException;
import exception.EnumerationAutoException;

public class OptionSet implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2128108917538379917L;
	private ArrayList<Option> option;
	private String name;
	private String option_choiced;
	
	protected OptionSet(String name) {
		this.name = name;
		this.option = new ArrayList<Option>();
	}
	
	protected OptionSet() {
		
	}
	
	protected String getName() {
		return this.name;
	}
	
	protected ArrayList<Option> getAllOpt() {
		return this.option;
	}
	
	protected Option getOption(String optname) throws AutoException {
		return this.findOpt(optname);
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected void setOpt(String name, float price) {
		this.option.add(new Option(name, price));
	}
	
	protected void setAllOpt(ArrayList<Option> opt) {
		this.option = opt;
	}
	
	protected void deleteOpt(String name) throws AutoException {
		Option temp = this.findOpt(name);
		if(temp != null) {
			this.option.remove(temp);
		}
	}
	
	protected void updateOptName(String old_name, String new_name) throws AutoException {
		Option temp = this.findOpt(old_name);
		temp.setOptName(new_name);
	}
	
	protected void updateOptPrice(String name, float price) throws AutoException {
		Option temp = this.findOpt(name);
		temp.setOptPrice(price);
	}
	
	protected Option findOpt(String name) throws AutoException {
		for(Option op: option) {
			if(op.getOptName().equals(name)) {
				return op;
			}
		}
		throw new AutoException(EnumerationAutoException.WrongOptionName);
	}
	
	protected void printAllOptions() {
		int i = 1;
		for(Option opt : this.option) {
			System.out.println("  " + i + ". " + opt.getOptName() + ": $" + opt.getOptPrice());
			i++;
		}
	}
	
	/**
	 * Choice Part
	 * @throws AutoException 
	 */
	protected void setOptionChoice(String optionName) throws AutoException {
		Option opt = this.findOpt(optionName);
		this.option_choiced = optionName;
	}
	
	protected Option getOptionChoice() throws AutoException {
		return this.findOpt(this.option_choiced);
	}
	
	protected String getOptionChoiceName() {
		return this.option_choiced;
	}
	
	protected float getOptionChoicePrice() throws AutoException {
		return this.findOpt(this.option_choiced).getOptPrice();
	}

	
	/**
	 * Class Option, an inner class of OptionSet class
	 */
	protected class Option implements Serializable {
		/**
		 * serialVersionUID
		 */
		private static final long serialVersionUID = 1705624780796096260L;
		String OptName;
		float OptPrice;
		protected String getOptName() {
			return this.OptName;
		}
		protected void setOptName(String OptName) {
			this.OptName = OptName;
		}
		
		protected float getOptPrice() {
			return this.OptPrice;
		}
		protected void setOptPrice(float OptPrice) {
			this.OptPrice = OptPrice;
		}
		
		protected Option(String OptName, float OptPrice) {
			this.OptName = OptName;
			this.OptPrice = OptPrice;
		}
	}
	
}