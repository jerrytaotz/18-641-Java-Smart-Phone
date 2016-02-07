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
	public Automobile buildAutoObject(String filename, Automobile auto) throws AutoException, IOException{
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
					throw new AutoException(EnumerationAutoException.MissingModelName);
				}
			} catch(AutoException e) {
				ExceptionFixHelper fix = new ExceptionFixHelper();
				autoInfo[0] = fix.fixMissingModelName();
			}
			try {
				if(0 == autoInfo[1].length()) {
					throw new AutoException(EnumerationAutoException.MissingBasePrice);
				}
			} catch(AutoException e) {
				ExceptionFixHelper fix = new ExceptionFixHelper();
				autoInfo[1] = fix.fixMissingBasePrice();
			}
			try {
				if(0 == autoInfo[2].length()) {
					throw new AutoException(EnumerationAutoException.MissingSize);
				}
			} catch(AutoException e) {
				ExceptionFixHelper fix = new ExceptionFixHelper();
				autoInfo[2] = fix.fixMissingSize();
			}
			String name = autoInfo[0];
			float basePrice = Float.parseFloat(autoInfo[1]);
			int Size = Integer.parseInt(autoInfo[2]);
			auto = new Automobile(name, basePrice, Size);
			/**
			 * Set values of OptionSet
			 * Set values of Option
			 */
			boolean eof = false;
			int OptionSetSize = 0;
			int OptionSetCount = 0;
			int OptionCount = 0;
			while(!eof) {
				String line = buff.readLine();
				if(line == null) {
					eof = true;
				}
				else {
					String[] elements = this.splitString(line);
					if("Item".equals(elements[0])) {
						try {
							if(OptionCount != OptionSetSize) {
								throw new AutoException(EnumerationAutoException.MissingOption);
								//msg += "Before content '" + line + "' should have more 'Option' items\n";
							}
						} catch(AutoException e) {
							System.out.println(line);
							ExceptionFixHelper fix = new ExceptionFixHelper();
							auto = fix.fixMissingOption(auto, OptionSetCount, OptionCount, OptionSetSize);
						}
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
						try {
							if(0 == elements[2].length()) {
								throw new AutoException(EnumerationAutoException.MissingOptionSetSize);
							}
						} catch(AutoException e) {
							System.out.println(line);
							ExceptionFixHelper fix = new ExceptionFixHelper();
							elements[2] = fix.fixMissingOptionSetSize(OptionSetName);
						}
						OptionSetSize = Integer.parseInt(elements[2]);
						try {
							if(OptionSetCount < Size) {
								auto.setOpest(OptionSetCount, OptionSetName, OptionSetSize);
								OptionSetCount ++;
								OptionCount = 0;
							}
							else {
								throw new AutoException(EnumerationAutoException.ExceedingOptionSet);
								//msg += "Item content '" + line + "' is out of the boundary\n";
							}
						} catch(AutoException e) {
							ExceptionFixHelper fix = new ExceptionFixHelper();
							auto = fix.fixExceedingOptionSet(auto, OptionSetName, OptionSetSize);
							if(Size == auto.getAllOpset().length) {
								break;
							}
							else {
								Size = auto.getAllOpset().length;
								OptionSetCount ++;
								OptionCount = 0;
							}
						}
						
					}
					else if("Option".equals(elements[0])) {
						try {
							if(0 == elements[2].length()) {
								throw new AutoException(EnumerationAutoException.MissingOptionName);
							}
						} catch(AutoException e) {
							System.out.println(line);
							ExceptionFixHelper fix = new ExceptionFixHelper();
							elements[2] = fix.fixMissingOptionName(elements[1]);
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
						try {
							if(OptionCount < OptionSetSize) {
								auto.setOption(OptionSetCount-1, OptionCount, option_name, option_price);
							}
							else {
								throw new AutoException(EnumerationAutoException.ExceedingOption);
								//msg += "Option content '" + line + "' is out of the boundary\n";
							}
						} catch(AutoException e) {
							ExceptionFixHelper fix = new ExceptionFixHelper();
							auto= fix.fixExceedingOption(auto, elements[1], OptionSetCount, OptionCount, option_name, option_price);
							OptionSetSize = auto.getOptionSetSize(elements[1]);
							OptionCount = OptionSetSize - 1;
						}
						OptionCount ++;
					}
				}
			}
			try {
				if(OptionCount < OptionSetSize) {
					throw new AutoException(EnumerationAutoException.MissingOption);
				}
			} catch(AutoException e) {
				ExceptionFixHelper fix = new ExceptionFixHelper();
				auto = fix.fixMissingOption(auto, OptionSetCount, OptionCount, OptionSetSize);
			}
			try {
				if(OptionSetCount < Size) {
					throw new AutoException(EnumerationAutoException.MissingOptionSet);
					//msg += "Should have more \"OptionSet\" items";
				}
			} catch(AutoException e) {
				ExceptionFixHelper fix = new ExceptionFixHelper();
				auto = fix.fixMissingOptionSet(auto, OptionSetCount, Size);
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