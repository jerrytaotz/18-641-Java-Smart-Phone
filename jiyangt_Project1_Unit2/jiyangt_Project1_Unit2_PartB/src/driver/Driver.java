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
import exception.AutoException;
import model.Automobile;
import util.FileIO;

public class Driver {
	public static void main(String[] args) throws AutoException {
		/**
		 * Read the normal source file
		 */
		System.out.println("==========================================================");
		System.out.println("||      Read the Normal file, wrong file name first     ||");
		System.out.println("==========================================================");
		BuildAuto auto = new BuildAuto();
		auto.BuildAuto("FordZTW1.txt");
		auto.BuildAuto("Audio-A8.txt");
		auto.printAuto("Volkswagen Audio A8");
		auto.printAuto("Ford Focus Wagon ZTW");
		
		System.out.println("\n\n");
		System.out.println("==========================================================");
		System.out.println("||                Test the Update Method                ||");
		System.out.println("==========================================================");
		System.out.println("Update the price of selected power moonroof from 595 to 650");
		auto.updateOptionPrice("Ford Focus Wagon ZTW", "Power Moonroof", "Selected", 650);
		System.out.println("Update the 'Color' to 'Body Color'");
		auto.updateOptionSetName("Ford Focus Wagon ZTW", "Color", "Body Color");
		auto.printAuto("Ford Focus Wagon ZTW");
		
		System.out.println("\n\n");
		System.out.println("==========================================================");
		System.out.println("||                Test the Delete Method                ||");
		System.out.println("==========================================================");
		System.out.println("Delete the OptionSet 'Body Color' I just updated");
		auto.deleteOptionSet("Ford Focus Wagon ZTW", "Body Color");
		auto.printAuto("Ford Focus Wagon ZTW");
		
		/**
		 * Read the abnormal source file
		 */
		System.out.println("\n\n");
		System.out.println("==========================================================");
		System.out.println("||                 Read the abnormal file               ||");
		System.out.println("||            Test Exception and Self-Healing           ||");
		System.out.println("||              1. Missing an Option Price              ||");
		System.out.println("||              2. Missing an Option Name               ||");
		System.out.println("==========================================================");
		BuildAuto auto1 = new BuildAuto();
		auto1.BuildAuto("FordZTW-Wrong.txt");
		auto1.printAuto("Ford Focus 2016");
		
		/**
		 * Test Choice
		 */
		System.out.println("\n\n");
		System.out.println("==========================================================");
		System.out.println("||                   Test the Choice                    ||");
		System.out.println("==========================================================");
		Automobile autochoice = null;
		autochoice = new FileIO().buildAutoObject("Audio-A8.txt", autochoice);
		autochoice.setOptionChoice("Color", "Sky Gray");
		autochoice.setOptionChoice("Transmission", "Automatic");
		autochoice.setOptionChoice("Brakes/Traction Control", "ABS with Advance Trac");
		autochoice.setOptionChoice("Side Impact Air Bags", "Selected");
		autochoice.setOptionChoice("Seats", "Normal");
		autochoice.printChoice();
		autochoice.printTotalPrice();
	}
}