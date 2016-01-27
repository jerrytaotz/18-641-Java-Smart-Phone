package prototype;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 20, 2016
 * 
 * Class State implements an abstract that extends by the Statistics.
 */
import model.Student;

public abstract class State implements Constant {
	protected int[] high_score = new int[QUIZ_NUM];
	protected int[] low_score = new int[QUIZ_NUM];
	protected float[] average = new float[QUIZ_NUM];
	public abstract void getState(Student[] stu);
}