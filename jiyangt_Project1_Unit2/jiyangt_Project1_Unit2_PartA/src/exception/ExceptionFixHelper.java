package exception;

import model.*;

import java.util.Scanner;

public class ExceptionFixHelper {
	@SuppressWarnings("resource")
	public String fixWrongFileName() {
		System.out.print("Please input file name again:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixMissingModelName() {
		System.out.print("Please input the model name to continue:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixMissingBasePrice() {
		System.out.print("Please input the base price to continue:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixMissingSize() {
		System.out.print("Please input the number of OptionSet to continue:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixMissingOptionSetName() {
		System.out.print("Please input the name of OptionSet to continue:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixMissingOptionSetSize(String name) {
		System.out.print("Please input the number of Options in OptionSet '"+ name +"' to continue:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixMissingOptionName(String name) {
		System.out.print("Please input the name of Option in OptionSet '"+ name +"' to continue:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixMissingOptionPrice(String name) {
		System.out.print("Please input the price of the Option '"+ name +"' to continue:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public Automobile fixExceedingOptionSet(Automobile auto, String OptionSetName, int OptionSetSize) {
		System.out.print("Do you want to keep the exceeding OptionSet? (Y/N)");
		String input = new Scanner(System.in).next();
		if("Y".equals(input)) {
			String name = auto.getName();
			float base_price = auto.getBasePrice();
			OptionSet[] opset = auto.getAllOpset();
			int number = opset.length;
			auto = new Automobile(name, base_price, number+1);
			for(int i=0; i<number; i++) {
				auto.getAllOpset()[i] = opset[i];
			}
			auto.setOpset(OptionSetName, OptionSetSize);
		}
		return auto;
	}
	
	@SuppressWarnings("resource")
	public Automobile fixMissingOptionSet(Automobile auto, int OptionSetCount, int Size) {
		while(OptionSetCount < Size) {
			System.out.print("Do you want to add more OptionSet? (Y/N)");
			String input = new Scanner(System.in).next();
			if("Y".equals(input)) {
				System.out.print("Please input the OptionSet name: ");
				String opset_name = new Scanner(System.in).next();
				System.out.print("Please input the option price: ");
				int opset_size = new Scanner(System.in).nextInt();
				auto.setOpset(opset_name, opset_size);
				auto = this.fixMissingOption(auto, OptionSetCount, 0, opset_size);
				OptionSetCount ++;
			}
			else {
				break;
			}
		}
		return auto;
	}
	
	@SuppressWarnings("resource")
	public Automobile fixExceedingOption(Automobile auto, String opset_name, int OptionSetCount, int OptionCount, String option_name, float option_price) {
		System.out.print("Do you want to keep the exceeding Option? (Y/N)");
		String input = new Scanner(System.in).next();
		if("Y".equals(input)) {
			auto.updateOpsetSize_Add(OptionSetCount-1, OptionCount);
			auto.setOption(OptionSetCount-1, option_name, option_price);
		}
		return auto;
	}
	
	@SuppressWarnings("resource")
	public Automobile fixMissingOption(Automobile auto, int OptionSetCount, int OptionCount, int OptionSetSize) {
		while(OptionCount < OptionSetSize) {
			System.out.print("Do you want to add more Option to '"+ auto.getOptionSetName(OptionSetCount-1) +"'? (Y/N)");
			String input = new Scanner(System.in).next();
			if("Y".equals(input)) {
				System.out.print("Please input the option name: ");
				String option_name = new Scanner(System.in).next();
				System.out.print("Please input the option price: ");
				float option_price = new Scanner(System.in).nextFloat();
				auto.setOption(OptionSetCount-1, option_name, option_price);
				OptionCount ++;
			}
			else {
				break;
			}
		}
		return auto;
	}
}