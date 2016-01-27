package exception;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 20, 2016
 *
 * Class WrongNumScore implements the exception handler for the cases 
 * that the total number of scores is not equal to the requirements
 */
public class WrongNumScore extends Exception {
	private static final long serialVersionUID = 1L;
	
	public WrongNumScore(String msg) {
		super(msg);
	}
}