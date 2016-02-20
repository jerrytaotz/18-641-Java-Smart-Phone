package scale;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 14, 2016
 * 
 * This class implements the methods that using thread and synchronized
 * 1. Update the OptionSet Name
 * 2. Update the Option Price
 * 
 * For Testing, each time update, it may need to modify the same item 4 to 5 times
 * between each time modify, a thread may wait for 1 to 2 seconds
 */

import exception.AutoException;
import model.Automobile;

public class EditOptions implements Runnable {
	private boolean print_or_not = true;
	
	private Automobile editAutomobile;
	
	private int threadID;
	private String[] args;
	
	public enum EditOptionEnumerator{
		EditOptionSetName,
		EditOptionPrice;
	}
	private EditOptionEnumerator editOptionEnumerator;
	
	public EditOptions(int threadID, Automobile editAutomobile, EditOptionEnumerator editOptionEnumerator, String[] args) {
		this.threadID = threadID;
		this.editAutomobile = editAutomobile;
		this.editOptionEnumerator = editOptionEnumerator;
		this.args = args;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		switch(editOptionEnumerator) {
		case EditOptionSetName:
			try {
				this.threadUpdateOptionSetName();
			} catch (AutoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case EditOptionPrice:
			try {
				this.threadUpdateOptionPrice();
			} catch (AutoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
	
	private void threadUpdateOptionSetName() throws AutoException {
		synchronized(this.editAutomobile) {
			String opset_name = this.args[1];
			String opset_name_new = this.args[2];
			String[] opset_name_array = {opset_name, opset_name_new+"#1", opset_name_new+"#2",
					opset_name_new+"#3", opset_name_new+"#4", opset_name_new};
			for(int i=1; i<opset_name_array.length; i++) {
				this.waiting();
				this.editAutomobile.updateOpsetName(opset_name_array[i-1], opset_name_array[i]);
				if(this.print_or_not) {
					System.out.println();
					System.out.println("Thread #"+this.threadID);
					System.out.println("[Model Name] "+ this.editAutomobile.getName());
					System.out.println("[OptionSet Name] " + this.editAutomobile.getOptionSetName(opset_name_array[i]));
				}
			}
		}
	}
	
	private void threadUpdateOptionPrice() throws AutoException {
		synchronized(this.editAutomobile) {
			String opset_name = this.args[1];
			String option_name = this.args[2];
			float price = Float.parseFloat(args[3]);
			for(int i=3; i>=0; i--) {
				this.waiting();
				this.editAutomobile.updateOptionPrice(opset_name, option_name, price+i);
				if(this.print_or_not) {
					System.out.println();
					System.out.println("Thread #"+this.threadID);
					System.out.println("[Model Name] "+ this.editAutomobile.getName());
					System.out.println("[OptionSet Name] " + opset_name);
					System.out.println("["+option_name+"] "+ this.editAutomobile.getOptionPrice(opset_name, option_name));;
				}
			}
		}
	}
	
	/**
	 * Simulate wait for 1 to 2 seconds randomly
	 */
	void waiting() {
		try {
			Thread.currentThread();
			Thread.sleep((long) (1000 * (Math.random()+1)));
		} catch(InterruptedException iex) {
			/* ignore it */
		}
	}
}