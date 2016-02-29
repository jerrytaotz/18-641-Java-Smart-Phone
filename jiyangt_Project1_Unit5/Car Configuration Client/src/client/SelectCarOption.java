package client;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 19, 2016
 * 
 * Realize the function of configuration
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

import exception.AutoException;
import model.Automobile;
import util.FileIO;

public class SelectCarOption {
	private Properties prop = null;
	private BufferedReader type_in = new BufferedReader(new InputStreamReader(System.in));
	
	public SelectCarOption(Properties prop) {
		this.prop = prop;
	}
	
	public ArrayList<String> Configuration() {
		ArrayList<String> new_choice = new ArrayList<String>();
		Automobile auto = null;
		try {
			auto = new FileIO().buildAutoObject(prop, auto);
			System.out.println("Car Make: " + auto.getMake());
			System.out.println("Car Model: " + auto.getModel());
			System.out.println("Car Base Price: $" + auto.getBasePrice());
			ArrayList<String> opset_names = auto.getAllOpsetName();
			int i=1;
			for(String opset_name: opset_names) {
				System.out.println("==================================");
				System.out.println("OptionSet" + i + ": " + opset_name);
				ArrayList<String> option_name = auto.getAllOptionName(opset_name);
				ArrayList<String> option_price = auto.getAllOptionPrice(opset_name);
				for(int j=0; j<option_name.size(); j++) {
					System.out.println(""+(j+1)+". "+option_name.get(j)+": $"+option_price.get(j));
				}
				while(true) {
					System.out.println("Your Choice (Number Only):");
					String input = this.type_in.readLine();
					int choice = Integer.parseInt(input);
					if(choice>=1 && choice<=option_name.size()) {
						auto.setOptionChoice(opset_name, option_name.get(choice-1));
						new_choice.add(opset_name+"->"+option_name.get(choice-1)+"\n");
						break;
					}
					else {
						System.out.println("Illegal Input, Need Type in Again!");
					}
				}
				i ++;
			}
			auto.printBasic();
			auto.printChoice();
			auto.printTotalPrice();
		} catch (AutoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new_choice;
	}
}