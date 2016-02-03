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
import java.io.IOException;

import exception.WrongContentException;
import model.*;
import util.*;

public class Driver {
	public static void main(String[] args) {
		/**
		 * Read the normal source file
		 */
		String filename = "FordZTW.txt";
		FileIO fio = new FileIO();
		Automotive auto = null;
		System.out.println("Read data from txt file: " + filename);
		try {
			auto = fio.buildAutoObject(filename, auto);
			auto.printAll();
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
		catch(WrongContentException wce) {
			System.out.println(wce.toString());
		}
		/**
		 * Write to the serialized file
		 */
		System.out.println();
		System.out.println();
		System.out.println("==========================================================");
		System.out.println("||     Test the Serializing and Deserializing method    ||");
		System.out.println("==========================================================");
		String serialize_file = "auto.ser";
		System.out.println("Serializing Automotive: " + auto.getName() + " to " + serialize_file);
		try {
			fio.serializeAuto(auto, serialize_file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Serializing done");
		/**
		 * Read the serialized file
		 */
		System.out.println();
		System.out.println();
		System.out.println("Deerializing Automotive from " + serialize_file);
		try {
			Automotive newaut = null;
			newaut = fio.deserializeAuto(serialize_file, newaut);
			newaut.printAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * Test delete, setting and update method
		 */
		System.out.print("\n\n\n");
		System.out.println("==========================================================");
		System.out.println("||      Test the delete, setting and update method      ||");
		System.out.println("==========================================================");
		// delete an OptionSet
		String deleteOptionSet = "Color";
		System.out.println("Delete the OptionSet: " + deleteOptionSet);
		auto.deleteOpset(deleteOptionSet);
		auto.printAll();
		// Also test find method here
		if(auto.findOpset(deleteOptionSet) == null) {
			System.out.println("OptionSet: " + deleteOptionSet + " has been deleted");
		}
		// set a new OptionSet
		System.out.println();
		String setOptionSet = "Sunroof";
		System.out.println("Set a new OptionSet: " + setOptionSet);
		auto.setOpset(setOptionSet, 2);
		// set two new Options
		String setOption1 = "None";
		String setOption2 = "Selected";
		System.out.println("Set two new Options: "+ setOption1 +" & " + setOption2);
		auto.setOption(setOptionSet, setOption1, 0);
		auto.setOption(setOptionSet, setOption2, 400);
		auto.printAll();
		if(auto.findOpset(setOptionSet) != null) {
			System.out.println("OptionSet: " + setOptionSet + "has been setted");
		}
		// update a the price of "Selected" Option in OptionSet "Sunroof"
		String updateOptionSet = "Sunroof";
		String updateOption = "Selected";
		System.out.println();
		System.out.println("Update the price of \"" + updateOption + "\" in OptionSet \"" + updateOptionSet + "\"");
		auto.updateOptionPrice(updateOptionSet, updateOption, 300);
		auto.printOneOption(updateOptionSet);
		
		System.out.print("\n\n\n");
		System.out.println("==========================================================");
		System.out.println("||              Test incorrect text source              ||");
		System.out.println("==========================================================");
		// Example1: first said there are 2 OptionSet, but the file only consists 1 OptionSet
		System.out.println("Example1: first said there are 2 OptionSet, but the file only consists 1 OptionSet");
		String unnormal_file1 = "FordZTW-Less-OptionSet.txt";
		FileIO unnormal_fio1 = new FileIO();
		Automotive unnormal_auto1 = null;
		System.out.println("Read data from txt file: " + unnormal_file1);
		try {
			unnormal_auto1 = unnormal_fio1.buildAutoObject(unnormal_file1, unnormal_auto1);
			unnormal_auto1.printAll();
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
		catch(WrongContentException wce) {
			System.out.println(wce.toString());
		}
		System.out.println();
		// Example2: first said there are 2 Option, but the file consists 3 OptionSet
		System.out.println("Example2: first said there are 2 Option, but the file consists 3 OptionSet");
		String unnormal_file2 = "FordZTW-More-Option.txt";
		FileIO unnormal_fio2 = new FileIO();
		Automotive unnormal_auto2 = null;
		System.out.println("Read data from txt file: " + unnormal_file2);
		try {
			unnormal_auto2 = unnormal_fio2.buildAutoObject(unnormal_file2, unnormal_auto2);
			unnormal_auto2.printAll();
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
		catch(WrongContentException wce) {
			System.out.println(wce.toString());
		}		
	}
}