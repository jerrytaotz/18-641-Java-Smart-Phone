package util;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 28, 2016
 * 
 * FileIO class include read file, serialized and deserialized object
 */
import model.*;
import exception.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO {
//	private final int OptionSetEleNum = 3;
//	private final int OptionEleNum = 3;
	
	@SuppressWarnings("resource")
	public Automobile buildAutoObject(String filename, Automobile auto) throws AutoException {
		try {
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			String[] autoInfo = new String[3];
			/**
			 * Get Automotive Information
			 */
			for(int i=0; i<autoInfo.length; i++) {
				String line = buff.readLine();
				String[] elements = this.splitString(line);
				autoInfo[i] = elements[1];
			}
			try {
				if(0 == autoInfo[0].length()) {
					throw new AutoException(EnumerationAutoException.MissingMake);
				}
			} catch(AutoException e) {
				ExceptionFixHelper fix = new ExceptionFixHelper();
				autoInfo[0] = fix.fixMissingMake();
			}
			try {
				if(0 == autoInfo[1].length()) {
					throw new AutoException(EnumerationAutoException.MissingModel);
				}
			} catch(AutoException e) {
				ExceptionFixHelper fix = new ExceptionFixHelper();
				autoInfo[1] = fix.fixMissingModel();
			}
			try {
				if(0 == autoInfo[2].length()) {
					throw new AutoException(EnumerationAutoException.MissingBasePrice);
				}
			} catch(AutoException e) {
				ExceptionFixHelper fix = new ExceptionFixHelper();
				autoInfo[2] = fix.fixMissingBasePrice();
			}
			String make = autoInfo[0];
			String model = autoInfo[1];
			float basePrice = Float.parseFloat(autoInfo[2]);
			String name = make + " " + model;
			auto = new Automobile(make, model, basePrice);
			/**
			 * Set values of OptionSet
			 * Set values of Option
			 */
			boolean eof = false;
			while(!eof) {
				String line = buff.readLine();
				if(line == null) {
					eof = true;
				}
				else {
					String[] elements = this.splitString(line);
					if("Item".equals(elements[0])) {
						try {
							if(0 == elements[1].length()) {
								throw new AutoException(EnumerationAutoException.MissingOptionSetName);
							}
						} catch(AutoException e) {
							System.out.println(line);
							ExceptionFixHelper fix = new ExceptionFixHelper();
							elements[1] = fix.fixMissingOptionSetName();
						}
						String OptionSetName = elements[1];
						auto.setOpest(OptionSetName);
					}
					else if("Option".equals(elements[0])) {
						try {
							if(0 == elements[1].length()) {
								throw new AutoException(EnumerationAutoException.MissingOptionSetName);
							}
						} catch(AutoException e) {
							System.out.println(line);
							ExceptionFixHelper fix = new ExceptionFixHelper();
							elements[1] = fix.fixMissingOptionSetName();
						}
						String opsetName = elements[1];
						try {
							if(0 == elements[2].length()) {
								throw new AutoException(EnumerationAutoException.MissingOptionName);
							}
						} catch(AutoException e) {
							System.out.println(line);
							ExceptionFixHelper fix = new ExceptionFixHelper();
							elements[2] = fix.fixMissingOptionName(opsetName);
						}
						String option_name = elements[2];
						try {
							if(0 == elements[3].length()) {
								throw new AutoException(EnumerationAutoException.MissingOptionPrice);
							}
						} catch(AutoException e) {
							System.out.println(line);
							ExceptionFixHelper fix = new ExceptionFixHelper();
							elements[3] = fix.fixMissingOptionPrice(option_name);
						}
						float option_price = Float.parseFloat(elements[3]);
						auto.setOption(opsetName, option_name, option_price);
					}
				}
			}
			buff.close();
		}
		catch(FileNotFoundException e) {
			throw new AutoException(EnumerationAutoException.WrongFileName);
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
		return auto;
	}
	
	public void serializeAuto(Automobile auto, String filename) throws Exception {
		ObjectOutputStream out;
		out = new ObjectOutputStream(new FileOutputStream(filename));
		out.writeObject(auto);
		out.close();
	}
	
	public Automobile deserializeAuto(String filename, Automobile auto) throws Exception {
		ObjectInputStream input= new ObjectInputStream(new FileInputStream(filename));
		auto = (Automobile) input.readObject();
		input.close();
		return auto;
	}
	
	private String[] splitString(String str) {
		return str.split(">>");
	}
}