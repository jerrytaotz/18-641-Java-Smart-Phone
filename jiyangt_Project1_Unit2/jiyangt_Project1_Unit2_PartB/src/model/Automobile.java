package model;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 28, 2016
 * 
 * Automotive class defines car's basic property
 */

import java.io.Serializable;
import java.util.ArrayList;

import exception.AutoException;
import exception.EnumerationAutoException;
import model.OptionSet.Option;

public class Automobile implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6975652196033983624L;
	private String name;
	private String make;
	private String model;
	private float basePrice;
	private ArrayList<OptionSet> OptionSet;
	private ArrayList<Option> choice;
	
	/**
	 * Constructor
	 */
	public Automobile() {
		
	}
	
	public Automobile(String make, String model, float basePrice) {
		this.name = make + " " + model;
		this.make = make;
		this.model = model;
		this.basePrice = basePrice;
		this.OptionSet = new ArrayList<OptionSet>();
		this.choice = new ArrayList<Option>();
	}
	
	/**
	 * Getter
	 * 1. Get Name of Automotive
	 * 2. Get Automotive Base Price
	 * 3. Get OptionSet (by index value)
	 */
	public String getName() {
		return this.name;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public float getBasePrice() {
		return this.basePrice;
	}
	
	public ArrayList<OptionSet> getAllOpset() {
		return this.OptionSet;
	}
	
	public int getSize() {
		return this.OptionSet.size();
	}
	
	public int getOptionSetSize(String opset_name) throws AutoException {
		return this.findOpset(opset_name).getAllOpt().size();
	}
	
	public Option getOption(String opsetName, String optionName) throws AutoException {
		if(findOpset(opsetName) != null) {
			return this.findOpset(opsetName).findOpt(optionName);
		}
		return null;
	}
	
	public float getOptionPrice(String opsetName, String optionName) throws AutoException {
		if(findOpset(opsetName) != null) {
			return this.getOption(opsetName, optionName).getOptPrice();
		}
		return 0;
	}
	
	/**
	 * Setter
	 * 1. Set Name
	 * 2. Set Base Price
	 * 3. Set values of OptionSet
	 * 4. Set values of Option (in context of OptionSet)
	 */
	/**
	 * OptionSet Part
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	
	public void setOpest(String name) {
		this.OptionSet.add(new OptionSet(name));
	}
	
	public void setAllOpset(ArrayList<OptionSet> opset) {
		this.OptionSet = opset;
	}
	
	/**
	 * Option Part
	 * @throws AutoException 
	 */
	public void setOption(String opset_name, String name, float price) throws AutoException {
		OptionSet temp = this.findOpset(opset_name);
		if(temp != null) {
			temp.setOpt(name, price);
		}
	}
	
	/**
	 * Find
	 * Find OptionSet with name
	 * @throws AutoException 
	 */
	
	public OptionSet findOpset(String name) throws AutoException {
		for(OptionSet opset: this.OptionSet) {
			if(opset.getName().equals(name)) {
				return opset;
			}
		}
		throw new AutoException(EnumerationAutoException.WrongOptionSetName);
	}
	
	/**
	 * Delete
	 * 1. Delete an OptionSet
	 * 2. Delete an Option
	 */
	/**
	 * OptionSet Part
	 * @throws AutoException 
	 */
	public void deleteOpset(String name) throws AutoException {
		OptionSet temp = this.findOpset(name);
		this.OptionSet.remove(temp);
	}
	
	/**
	 * Option Part
	 * @throws AutoException 
	 */
	public void deleteOption(String opsetName, String optionName) throws AutoException {
		Option opt = this.getOption(opsetName, optionName);
		this.findOpset(opsetName).deleteOpt(optionName);
	}
	
	
	
	/**
	 * Update
	 * Update values of OptionSet
	 */
	/**
	 * OptionSet Part
	 * @throws AutoException 
	 */
	public void updateOpset(String old_name, String name) throws AutoException {
		OptionSet temp = this.findOpset(old_name);
		if(temp != null) {
			temp = new OptionSet(name);
		}
	}
	
	public void updateOpsetName(String old_name, String name) throws AutoException {
		OptionSet temp = this.findOpset(old_name);
		if(temp != null) {
			temp.setName(name);
		}
	}
	public void updateOpsetSize_Add(String name) {
		this.OptionSet.add(new OptionSet(name));
	}
	
	/**
	 * Option Part
	 * @throws AutoException 
	 */
	public void updateOptionName(String opset_name, String old_name, String name) throws AutoException {
		OptionSet temp = this.findOpset(opset_name);
		temp.updateOptName(old_name, name);
	}
	
	public void updateOptionPrice(String opset_name, String option_name, float price) throws AutoException {
		OptionSet temp = this.findOpset(opset_name);
		temp.updateOptPrice(option_name, price);
	}
	
	/**
	 * Choice Part
	 * @throws AutoException 
	 *  
	 */
	public String getOptionChoice(String setName) throws AutoException {
		return this.findOpset(setName).getOptionChoiceName();
	}
	
	public float getOptionChoicePrice(String setName) throws AutoException {
		return this.findOpset(setName).getOptionChoicePrice();
	}
	
	public void setOptionChoice(String setName, String optionName) throws AutoException {
		OptionSet opset = this.findOpset(setName);
		this.choice.add(opset.getOption(optionName));
		opset.setOptionChoice(optionName);
	}
	
	public float getTotalPrice() {
		float total = this.basePrice;
		for(Option ch: this.choice) {
			total += ch.getOptPrice();
		}
		return total;
	}
	
	
	/**
	 * Print Part
	 */
	public void printAll() {
		this.printBasic();
		this.printOptions();
	}
	
	public void printBasic() {
		System.out.println("*************************************************************");
		System.out.println("*             Car's Model And Basic Information             *");
		System.out.println("*************************************************************");
		System.out.println("Model: " + this.getName());
		System.out.println("Base Price: $" + this.getBasePrice());
	}
	
	public void printOptions() {
		System.out.println("*************************************************************");
		System.out.println("*                       Car's Options                       *");
		System.out.println("*************************************************************");
		int i = 1;
		for(OptionSet opt: this.OptionSet) {
			System.out.println("" + i + ". " + opt.getName() + ":");
			opt.printAllOptions();
			i++;
		}
	}
	
	public void printOneOption(String name) throws AutoException {
		OptionSet opset_find = this.findOpset(name);
		if(opset_find != null) {
			System.out.println(opset_find.getName() + ":");
			opset_find.printAllOptions();
		}
		else {
			System.out.println("Have no item named:" + name);
		}
	}
	
	public void printTotalPrice() {
		System.out.println("Total Price：" + this.getTotalPrice());
	}
	
	public void printChoice() {
		for(Option ch: this.choice) {
			System.out.println("Option: "+ ch.getOptName() + "-> Price: " + ch.getOptPrice());
		}
	}
	
}