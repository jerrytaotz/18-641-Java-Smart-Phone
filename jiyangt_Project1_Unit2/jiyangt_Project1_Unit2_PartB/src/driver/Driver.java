package driver;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 28, 2016
 * 
 * Implements the three test cases
 * 1. Read the normal file, setting the Automotive object
 * 2. Serialized and De-serialized the method
 * 3. Test the delete, setting and update method
 * 4. Read the unnormal file
 */

import adapter.BuildAuto;

public class Driver {
	public static void main(String[] args) {
		/**
		 * Read the normal source file
		 */
		System.out.println("==========================================================");
		System.out.println("||      Read the Normal file, wrong file name first     ||");
		System.out.println("||                Test the Update Method                ||");
		System.out.println("==========================================================");
		BuildAuto auto = new BuildAuto();
		auto.BuildAuto("FordZTW1.txt");
		auto.printAuto("FordZTW1.txt");
		System.out.println("1. Update the price of Pitch Black Clearcoat in Color from 0 to 100");
		auto.updateOptionPrice("Focus Wagon ZTW", "Color", "Pitch Black Clearcoat", 100);
		System.out.println("2. Update the name of OptionSet 'Color' to 'Car's Body Color'");
		auto.updateOptionSetName("Focus Wagon ZTW", "Color", "Car's Body Color");
		auto.printAuto("FordZTW.txt");
		
		/**
		 * Read the abnormal source file
		 */
		System.out.println("==========================================================");
		System.out.println("||                 Read the abnormal file               ||");
		System.out.println("||            Test Exception and Self-Healing           ||");
		System.out.println("||              1. Missing Base Price                   ||");
		System.out.println("||              2. Missing an Option Price              ||");
		System.out.println("||              3. Missing an Option Name               ||");
		System.out.println("||              4. Exceeding OptionSet                  ||");
		System.out.println("||              5. Missing Option                       ||");
		System.out.println("==========================================================");
		BuildAuto auto1 = new BuildAuto();
		auto1.BuildAuto("FordZTW-Wrong.txt");
		auto1.printAuto("FordZTW-Wrong.txt");
	}
}