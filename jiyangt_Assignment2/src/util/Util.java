package util;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 20, 2016
 * 
 * Class Util implements the method to read the records from ".txt" file
 * and save the information.
 */
import java.io.*;
import java.util.*;

import model.Student;
import prototype.*;
import exception.*;
public class Util implements Constant{
	/**
	 * 
	 * @param filename define which file need to be read
	 * @param stu the student array to store the records
	 * @return the array that stores the records
	 * @throws IOException
	 * @throws ExcessiveStudent
	 * 
	 */
	public static Student[] readFile (String filename, Student[] stu) throws IOException,ExcessiveStudent{
		try {
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			int count_student = 0;
			while (!eof) {
				String line = buff.readLine();
				if (line == null) {
					eof = true;
				}
				else {
					if (count_student < MAX_STUDENT) {
						String msg = "";
						StringTokenizer temp = new StringTokenizer(line);
						String first_item = temp.nextToken();
						if(first_item.contains("Stud")){
							continue;
						}
						int SID = Integer.parseInt(first_item);
						int[] scores = new int[QUIZ_NUM];
						int count_score = 0;
						while (temp.hasMoreTokens()) {
							if(count_score < QUIZ_NUM){
								scores[count_score] = Integer.parseInt(temp.nextToken());
								count_score ++;
							}
//							else {
//								msg = "Thre are more then 5 quizes";
//								break;
//							}
						}
//						if(count_score != QUIZ_NUM){
//							msg = "Thre are less then 5 quizes";
//						}
						stu[count_student] = new Student(SID, scores);
						count_student ++;
					}
					else {
						String msg = "Number of students excess, more then " + MAX_STUDENT;
						throw new ExcessiveStudent(msg);
					}
				}
			}
			buff.close();
		}
		catch (IOException e) {
			System.out.println("IO Error: " + e.toString());
		}
//		catch (WrongNumberScoresException e) {
//			System.out.println("Wrong Number of Scores: " + e.toString());
//		}
		catch (ExcessiveStudent e) {
			System.out.println("Excessive Number of Student: " + e.toString());
		}
		return stu;
	}
}