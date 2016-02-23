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
	public String fixWrongFileType() {
		System.out.print("Please input file type again:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixMissingMake() {
		System.out.print("Please input the 'Make' to continue:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixMissingModel() {
		System.out.print("Please input the 'Model' to continue:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixMissingBasePrice() {
		System.out.print("Please input the base price to continue:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixMissing() {
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
	public String fixWrongCarModel() {
		System.out.print("Please input the correct Car Model to continue:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixWrongOptionSetName() {
		System.out.print("Please input the correct OptionSet Name to continue:");
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("resource")
	public String fixWrongOptionName() {
		System.out.print("Please input the correct Option Name to continue:");
		return new Scanner(System.in).next();
	}
}