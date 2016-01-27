package model;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 20, 2016
 * 
 * Class Student contains students' information
 * Students' information includes SID and scores.
 * Also Implements the methods to set and get the SID and scores, print the student's information
 */
import prototype.*;

public class Student extends People implements Printer,Constant {

	private int SID;
	private int scores[] = new int[QUIZ_NUM];
	
	public void setSID(int SID) {
		this.SID = SID;
	}
	
	public int getSID() {
		return this.SID;
	}
	
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	public int[] getScores() {
		return this.scores;
	}
	
	public Student (int SID, int[] scores) {
		this.setSID(SID);
		this.setScores(scores);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print(String.format("%04d", this.SID) + " ");
		for (int i = 0; i < scores.length; i++) {
			System.out.print("      " + String.format("%03d", scores[i]));
		}
		System.out.println();
	}
	
}