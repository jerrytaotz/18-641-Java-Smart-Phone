import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import model.Automobile;
import model.OptionSet;

public class Test {
	public static void main(String[] arg) {
		String test = "Option>Brakes/Traction Control>ABS>>123";
		String[] result = test.split(">");
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
		System.out.println(result[3]);
		System.out.println(result[4]);
		System.out.println(result[5]);
		try {
			FileReader file = new FileReader("FordZTW.txt");
			BufferedReader buff = new BufferedReader(file);
			String line = buff.readLine();
			BufferedReader buff2 = buff;
			System.out.println(buff.readLine());
			System.out.println(buff.readLine());
			System.out.println(buff.readLine());
			System.out.println(buff.readLine());
			System.out.println(buff.readLine());
			System.out.println(buff.readLine());
			System.out.println("**********************");
			buff = buff2;
			System.out.println(buff2.readLine());
			System.out.println(buff2.readLine());
			System.out.println(buff2.readLine());
			System.out.println(buff2.readLine());
		}
		catch(FileNotFoundException e) {
			
		}
		catch(IOException e) {
			
		}
	}
}