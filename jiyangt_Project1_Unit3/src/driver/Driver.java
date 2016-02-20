package driver;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 13, 2016
 * 
 * Implements the test case
 * four threads to modify same model
 * (Each time, only one thread can modify the same model)
 * threads modify different models can work parallelly
 */

import adapter.BuildAuto;
import exception.AutoException;
import model.Automobile;
import scale.EditOptions.EditOptionEnumerator;
import util.FileIO;

public class Driver {
	public static void main(String[] args) throws AutoException {
		/**
		 * Read the normal source file
		 */
		System.out.println("==========================================================");
		System.out.println("||              Read the Normal file first              ||");
		System.out.println("==========================================================");
		BuildAuto auto = new BuildAuto();
		auto.BuildAuto("FordZTW.txt");
		auto.BuildAuto("Audio-A8.txt");
//		auto.printAuto("Volkswagen Audio A8");
		auto.printAuto("Ford Focus Wagon ZTW");
		
		String[] arg1 = {"Ford Focus Wagon ZTW", "Color", "New_Color"};
		String[] arg2 = {"Ford Focus Wagon ZTW", "Transmission", "Standard", "-700"};
		String[] arg3 = {"Ford Focus Wagon ZTW", "Power Moonroof", "New Power Moonroof"};
		String[] arg4 = {"Ford Focus Wagon ZTW", "Brakes/Traction Control", "ABS", "200"};
		String[] arg5 = {"Volkswagen Audio A8", "Seats", "Dermis", "233"};
		
		editTest[] editTest = {
				new editTest(EditOptionEnumerator.EditOptionSetName, arg1),
				new editTest(EditOptionEnumerator.EditOptionPrice,arg2),
				new editTest(EditOptionEnumerator.EditOptionSetName, arg3),
				new editTest(EditOptionEnumerator.EditOptionPrice,arg4),
				new editTest(EditOptionEnumerator.EditOptionPrice,arg5),
		};
		
		for(int i=0; i<editTest.length; i++) {
			auto.edit(editTest[i].getEditOptionEnumerator(), editTest[i].getArgs());
		}
	}
	
	public static class editTest {
		private EditOptionEnumerator editOptionEnumerator;
		private String[] args;
		
		public editTest(EditOptionEnumerator editOptionEnumerator, String args[]) {
			this.editOptionEnumerator = editOptionEnumerator;
			this.args = args;
		}
		
		public EditOptionEnumerator getEditOptionEnumerator() {
			return this.editOptionEnumerator;
		}
		
		public String[] getArgs() {
			return this.args;
		}
	}
}