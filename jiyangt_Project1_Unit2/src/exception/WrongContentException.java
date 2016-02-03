package exception;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 28, 2016
 * 
 * WrongContentException gives an exception that there is anything wrong in the source file
 */
public class WrongContentException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5341289329643801379L;
	public WrongContentException(String msg) {
		super("[Content Wrong]: " + msg);
	}
}