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

public class Automobile implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6975652196033983624L;
	private String name;
	private float basePrice;
	private OptionSet[] opset;
	
	/**
	 * Constructor
	 */
	public Automobile() {
		
	}
	
	public Automobile(String name, float basePrice, int Size) {
		this.name = name;
		this.basePrice = basePrice;
		this.opset = new OptionSet[Size];
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
	
	public float getBasePrice() {
		return this.basePrice;
	}
	
	public OptionSet[] getAllOpset() {
		return this.opset;
	}
	
	public int getOptionSetSize(String opset_name) {
		return this.findOpset(opset_name).getAllOpt().length;
	}
	
	public String getOptionSetName(int index) {
		return this.findOpset(index).getName();
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
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	public void setOpest(int index, String name, int OptionSetSize) {
		if(this.CheckIndex(index)) {
			opset[index] = new OptionSet(name, OptionSetSize);
		}
	}
	public void setOpset(String name, int OptionSetSize) {
		for(int i=0; i<opset.length; i++) {
			if(opset[i] == null) {
				opset[i] = new OptionSet(name, OptionSetSize);
			}
		}
	}
	public void setAllOpset(OptionSet[] opset) {
		this.opset = opset;
	}
	
	/**
	 * Option Part
	 */
	public void setOption(int opset_index, String name, float price) {
		OptionSet temp = this.findOpset(opset_index);
		if(temp != null) {
			temp.setOpt(name, price);
		}
	}
	public void setOption(String opset_name, String name, float price) {
		OptionSet temp = this.findOpset(opset_name);
		if(temp != null) {
			temp.setOpt(name, price);
		}
	}
	public void setOption(int opset_index, int option_index, String name, float price) {
		OptionSet temp = this.findOpset(opset_index);
		if(temp != null) {
			temp.setOpt(option_index, name, price);
		}
	}
	public void setOption(String opset_name, int option_index, String name, float price) {
		OptionSet temp = this.findOpset(opset_name);
		if(temp != null) {
			temp.setOpt(option_index, name, price);
		}
	}
	
	/**
	 * Find
	 * Find OptionSet with name
	 */
	public OptionSet findOpset(int index) {
		if(index < this.opset.length && index >= 0){
			return this.opset[index];
		}
		else{
			return null;
		}
	}
	
	public OptionSet findOpset(String name) {
		for(int i=0; i<opset.length; i++) {
			if(opset[i] != null) {
				if(opset[i].getName().equals(name)) {
					return opset[i];
				}
			}
		}
		return null;
	}
	
	/**
	 * Delete
	 * 1. Delete an OptionSet
	 * 2. Delete an Option
	 */
	/**
	 * OptionSet Part
	 */
	public void deleteOpset(int index) {
		if(this.CheckIndex(index)) {
			this.opset[index] = null;
		}
	}
	public void deleteOpset(String name) {
		for(int i=0; i<this.opset.length; i++) {
			if(this.opset[i] != null) {
				if(this.opset[i].getName().equals(name)) {
					this.opset[i] = null;
				}
			}
		}
	}
	
	/**
	 * Option Part
	 */
	public void deleteOption(int opset_index, int option_index) {
		OptionSet temp = this.findOpset(opset_index);
		if(temp != null) {
			temp.deleteOpt(option_index);
		}
	}
	public void deleteOption(int opset_index, String option_name) {
		OptionSet temp = this.findOpset(opset_index);
		if(temp != null) {
			temp.deleteOpt(option_name);
		}
	}
	public void deleteOption(String opset_name, int option_index) {
		OptionSet temp = this.findOpset(opset_name);
		if(temp != null) {
			temp.deleteOpt(option_index);
		}
	}
	public void deleteOption(String opset_name, String option_name) {
		OptionSet temp = this.findOpset(opset_name);
		if(temp != null) {
			temp.deleteOpt(option_name);
		}
	}
	
	
	
	/**
	 * Update
	 * Update values of OptionSet
	 */
	/**
	 * OptionSet Part
	 */
	public void updateOpset(int index, String name, int OptionSetSize) {
		if(index < this.opset.length && index >= 0){
			this.opset[index] = new OptionSet(name, OptionSetSize);
		}
	}
	public void updateOpset(String old_name, String name, int OptionSetSize) {
		for(int i=0; i<opset.length; i++) {
			if(opset[i] != null) {
				if(opset[i].getName().equals(old_name)) {
					this.opset[i] = new OptionSet(name, OptionSetSize);
				}
			}
		}
	}
	
	public void updateOpsetName(int index, String name) {
		OptionSet temp = this.findOpset(index);
		if(temp != null) {
			temp.setName(name);
		}
	}
	public void updateOpsetName(String old_name, String name) {
		OptionSet temp = this.findOpset(old_name);
		if(temp != null) {
			temp.setName(name);
		}
	}
	
	public void updateOpsetSize_Add(int index, int OptionSetSize) {
		if(index < this.opset.length && index >= 0){
			OptionSet old_opset = this.opset[index];
			this.opset[index] = new OptionSet(this.opset[index].getName(), OptionSetSize);
			for(int j=0; j<old_opset.getAllOpt().length; j++) {
				if(j<OptionSetSize) {
					this.opset[index].getAllOpt()[j] = old_opset.getAllOpt()[j];
				}
			}
		}
	}
	public void updateOpsetSize_Add(String name, int OptionSetSize) {
		for(int i=0; i<opset.length; i++) {
			if(opset[i] != null) {
				if(opset[i].getName().equals(name)) {
					OptionSet old_opset = this.opset[i];
					this.opset[i] = new OptionSet(name, OptionSetSize);
					for(int j=0; j<old_opset.getAllOpt().length; j++) {
						if(j<OptionSetSize) {
							this.opset[i].getAllOpt()[j] = old_opset.getAllOpt()[j];
						}
					}
				}
			}
		}
	}
	
	/**
	 * Option Part
	 */
	public void updateOptionName(int opset_index, int option_index, String name) {
		OptionSet temp = this.findOpset(opset_index);
		if(temp != null) {
			temp.updateOptName(option_index, name);
		}
	}
	public void updateOptionName(int opset_index, String old_name, String name) {
		OptionSet temp = this.findOpset(opset_index);
		if(temp != null) {
			temp.updateOptName(name, name);
		}
	}
	public void updateOptionName(String opset_name, int option_index, String name) {
		OptionSet temp = this.findOpset(opset_name);
		if(temp != null) {
			temp.updateOptName(option_index, name);
		}
	}
	public void updateOptionName(String opset_name, String old_name, String name) {
		OptionSet temp = this.findOpset(opset_name);
		if(temp != null) {
			temp.updateOptName(old_name, name);
		}
	}
	
	public void updateOptionPrice(int opset_index, int option_index, float price) {
		OptionSet temp = this.findOpset(opset_index);
		if(temp != null) {
			temp.updateOptPrice(option_index, price);
		}
	}
	public void updateOptionPrice(int opset_index, String option_name, float price) {
		OptionSet temp = this.findOpset(opset_index);
		if(temp != null) {
			temp.updateOptPrice(option_name, price);
		}
	}
	public void updateOptionPrice(String opset_name, int option_index, float price) {
		OptionSet temp = this.findOpset(opset_name);
		if(temp != null) {
			temp.updateOptPrice(option_index, price);
		}
	}
	public void updateOptionPrice(String opset_name, String option_name, float price) {
		OptionSet temp = this.findOpset(opset_name);
		if(temp != null) {
			temp.updateOptPrice(option_name, price);
		}
	}
	
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
		for(int i=0; i<this.opset.length; i++) {
			if(this.opset[i] != null) {
				System.out.println("" + (i+1) + ". " + this.opset[i].getName() + ":");
				this.opset[i].printAllOptions();
			}
			else {
				System.out.println("" + (i+1) + ". This item has been deleted or hasn't been set!");
			}
		}
	}
	
	public void printOneOption(String name) {
		OptionSet opset_find = this.findOpset(name);
		if(opset_find != null) {
			System.out.println(opset_find.getName() + ":");
			opset_find.printAllOptions();
		}
		else {
			System.out.println("Have no item named:" + name);
		}
	}
	
	private boolean CheckIndex(int index) {
		if(index<this.opset.length && index>=0) {
			return true;
		}
		else {
			return false;
		}
	}
}