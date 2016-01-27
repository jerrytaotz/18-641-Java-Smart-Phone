package model;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 20, 2016
 *
 * Class Statistics implements the methods to find the highest, lowest and average score for each quiz,
 * and print the results
 */
import prototype.*;
public class Statistics extends State implements Printer,Constant {
	private int[] high = new int[QUIZ_NUM];
	private int[] low = new int[QUIZ_NUM];
	private float[] ave = new float[QUIZ_NUM];
	
	private void findlow(Student[] a) {
		for(int i=0; i<QUIZ_NUM; i++) {
			low[i] = 100;
		}
		for(Student student: a) {
			if(student == null) {
				break;
			}
			for(int i=0; i<QUIZ_NUM; i++) {
				if(low[i] > student.getScores()[i]) {
					low[i] = student.getScores()[i];
				}
			}
		}
		low_score = low;
	}
	
	private void findhigh(Student[] a) {
		for(int i=0; i<QUIZ_NUM; i++) {
			high[i] = 0;
		}
		for(Student student: a) {
			if(student == null) {
				break;
			}
			for(int i=0; i<QUIZ_NUM; i++) {
				if(high[i] < student.getScores()[i]) {
					high[i] = student.getScores()[i];
				}
			}
		}
		high_score = high;
	}
	
	private void findavg(Student[] a) {
		int count_student = 0;
		for(int i=0; i<QUIZ_NUM; i++) {
			ave[i] = 0;
		}
		for(Student student: a) {
			if(student == null) {
				break;
			}
			for(int i=0; i<QUIZ_NUM; i++) {
				ave[i] += student.getScores()[i];
			}
			count_student ++;
		}
		for(int i=0; i<QUIZ_NUM; i++) {
			ave[i] = ave[i]/count_student;
		}
		average = ave;
	}
	
	@Override
	public void getState(Student[] stu) {
		// TODO Auto-generated method stub
		this.findhigh(stu);
		this.findlow(stu);
		this.findavg(stu);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("High Score ");
		for (int i=0; i<QUIZ_NUM; i++) {
			System.out.print(String.format("%03d", high_score[i]) + "      ");
		}
		System.out.println("");
		
		System.out.print("Low Score  ");
		for (int i=0; i<QUIZ_NUM; i++) {
			System.out.print(String.format("%03d", low_score[i]) + "      ");
		}
		System.out.println("");
		
		System.out.print("Average    ");
		for (int i=0; i<QUIZ_NUM; i++) {
			System.out.print(String.format("%.1f", average[i]) + "     ");
		}
		System.out.println("");
		
	}
}