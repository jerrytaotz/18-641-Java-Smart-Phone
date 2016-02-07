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

public class OptionSet implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2128108917538379917L;
	private Option[] opt;
	private String name;
	
	protected OptionSet(String name, int size) {
		this.opt = new Option[size];
		this.name = name;
	}
	
	protected OptionSet() {
		
	}
	
	protected String getName() {
		return this.name;
	}
	
	protected Option[] getAllOpt() {
		return this.opt;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected void setOpt(int index, String name, float price) {
		if(this.CheckIndex(index)) {
			opt[index] = new Option(name, price);
		}
	}
	
	protected void setOpt(String name, float price) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i] == null) {
				opt[i] = new Option(name, price);
				return;
			}
		}
	}
	
	protected void setAllOpt(Option[] opt) {
		this.opt = opt;
	}
	
	protected void deleteOpt(int index) {
		if(this.CheckIndex(index)) {
			this.opt[index] = null;
		}
	}
	
	protected void deleteOpt(String name) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i] != null) {
				if(opt[i].getOptName().equals(name)) {
					opt[i] = null;
				}
			}
		}
	}
	
//	protected void updateOpt(int index, String name, float price) {
//		Option temp = this.findOpt(index);
//		if(temp != null) {
//			temp.setOptName(name);
//			temp.setOptPrice(price);
//		}
//	}
//	
//	protected void updateOpt(String old_name, String new_name, float price) {
//		Option temp = this.findOpt(old_name);
//		if(temp != null) {
//			temp.setOptName(new_name);
//			temp.setOptPrice(price);
//		}
//	}
	
	protected void updateOptName(int index, String name) {
		Option temp = this.findOpt(index);
		if(temp != null) {
			temp.setOptName(name);
		}
	}
	
	protected void updateOptName(String old_name, String new_name) {
		Option temp = this.findOpt(old_name);
		if(temp != null) {
			temp.setOptName(new_name);
		}
	}
	
	protected void updateOptPrice(int index, float price) {
		Option temp = this.findOpt(index);
		if(temp != null) {
			temp.setOptPrice(price);
		}
	}
	
	protected void updateOptPrice(String name, float price) {
		Option temp = this.findOpt(name);
		if(temp != null) {
			temp.setOptPrice(price);
		}
	} 
	
	protected Option findOpt(int index) {
		if(this.CheckIndex(index)){
			return this.opt[index];
		}
		else {
			return null;
		}
	}
	
	protected Option findOpt(String name) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i] != null) {
				if(opt[i].getOptName().equals(name)) {
					return opt[i];
				}
			}
		}
		return null;
	}
	
	protected void printAllOptions() {
		for(int i=0; i<this.opt.length; i++) {
			if(this.opt[i] != null) {
				System.out.println("  " + (i+1) + ". " + this.opt[i].getOptName() + ": $" + this.opt[i].getOptPrice());
			}
			else {
				System.out.println("  " + (i+1) + ". This option has been deleted or hasn't been set!");
			}
		}
	}
	
	private boolean CheckIndex(int index) {
		if(index<opt.length && index>=0) {
			return true;
		}
		else {
			return false;
		}
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