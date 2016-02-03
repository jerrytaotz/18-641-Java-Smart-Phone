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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO {
	private final int OptionSetEleNum = 3;
	private final int OptionEleNum = 3;
	
	public Automotive buildAutoObject(String filename, Automotive auto) throws IOException,WrongContentException{
		try {
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			String[] autoInfo = new String[3];
			/**
			 * Get Automotive Information
			 */
			for(int i=0; i<autoInfo.length; i++) {
				String line = buff.readLine();
				if(line != null) {
					String[] elements = this.splitString(line);
					if(elements[0].equals("Auto")) {
						autoInfo[i] = elements[1];
					}
					else {
						buff.close();
						throw new WrongContentException("Here should have automotive information!");
					}
				}
				else {
					buff.close();
					throw new WrongContentException("Lack of automotive information!");
				}
			}
			String name = autoInfo[0];
			float basePrice = Float.parseFloat(autoInfo[1]);
			int OptionSetSize = Integer.parseInt(autoInfo[2]);
			auto = new Automotive(name, basePrice, OptionSetSize);
			/**
			 * Set values of OptionSet
			 * Set values of Option
			 */
			boolean eof = false;
			int OptionSize = 0;
			int OptionSetCount = 0;
			int OptionCount = 0;
			String msg = "";
			while(!eof) {
				String line = buff.readLine();
				if(line == null) {
					eof = true;
				}
				else {
					String[] elements = this.splitString(line);
					if("Item".equals(elements[0])) {
						if(OptionCount != OptionSize) {
							msg += "Before content '" + line + "' should have more 'Option' items\n";
						}
						if(OptionSetCount < OptionSetSize) {
							if(elements.length == this.OptionSetEleNum) {
								String opset_name = elements[1];
								OptionSize = Integer.parseInt(elements[2]);
								auto.setOpest(OptionSetCount, opset_name, OptionSize);
								OptionSetCount ++;
								OptionCount = 0;
							}
							else {
								msg += "Content '" + line + "' should include 'Item>>Name>>Number'\n";
							}
						}
						else {
							msg += "Item content '" + line + "' is out of the boundary\n";
						}
					}
					else if("Option".equals(elements[0])) {
						if(OptionCount < OptionSize) {
							if(elements.length == this.OptionEleNum) {
								String option_name = elements[1];
								float option_price = Float.parseFloat(elements[2]);
								auto.setOption(OptionSetCount-1, OptionCount, option_name, option_price);
								OptionCount ++;
							}
						}
						else {
							msg += "Option content '" + line + "' is out of the boundary\n";
						}
					}
					else {
						msg += "Content '" + line + "' is illegal\n";
					}
				}
			}
			if(OptionSetCount < OptionSetSize) {
				msg += "Should have more \"OptionSet\" items";
			}
			buff.close();
			if(!"".equals(msg)) {
				throw new WrongContentException(msg);
			}
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
		catch(WrongContentException wce) {
			wce.printStackTrace();
		}
		return auto;
	}
	
	public void serializeAuto(Automotive auto, String filename) throws Exception {
		ObjectOutputStream out;
		out = new ObjectOutputStream(new FileOutputStream(filename));
		out.writeObject(auto);
		out.close();
	}
	
	public Automotive deserializeAuto(String filename, Automotive auto) throws Exception {
		ObjectInputStream input= new ObjectInputStream(new FileInputStream(filename));
		auto = (Automotive) input.readObject();
		input.close();
		return auto;
	}
	
	private String[] splitString(String str) {
		return str.split(">>");
	}
}