package driver;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 20, 2016
 * 
 * Implements the three test cases
 * Case 1. The records is less then 40 lines (less then 40 students totally).
 * Case 2. The records has 40 lines (Just 40 students totally).
 * Case 3. The records is more then 40 lines (more then 40 students totally).
 */
import java.io.IOException;

import exception.*;
import model.*;
import prototype.Constant;
import util.*;
public class Driver implements Constant {
	public static void main(String [] args) {
		Cases("Case 1: Student Number is Less then 40", "student_below40.txt");
		Cases("Case 2: Student Number is Equal to 40", "student_equal40.txt");
		Cases("Case 3: Student Number is Larger then 40", "student_above40.txt");
	}
	
	public static void Cases (String msg, String filename) {
		System.out.println("******************************************************");
		System.out.println(msg);
		Student lab2 [] = new Student[MAX_STUDENT]; //Populate the student array
		try {
			lab2 = Util.readFile(filename, lab2);
		} catch (IOException | ExcessiveStudent e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statistics statlab2 = new Statistics();
		statlab2.getState(lab2);
		
		System.out.println("Stud        Q1       Q2       Q3       Q4       Q5");
		for(Student student: lab2) {
			if(student == null) {
				break;
			}
			student.print();
		}
		
		System.out.println("");
		statlab2.print();
		
		System.out.println("");
	}
}