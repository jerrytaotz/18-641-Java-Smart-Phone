package exception;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 20, 2016
 *
 * Class ExcessiveStudent implements the exception handler for the cases 
 * that students' number is larger then required
 */
public class ExcessiveStudent extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ExcessiveStudent(String msg) {
		super(msg);
	}
}