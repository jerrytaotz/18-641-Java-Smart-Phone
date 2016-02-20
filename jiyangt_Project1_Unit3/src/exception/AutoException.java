package exception;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.util.Date;

public class AutoException extends Exception {
	private static final long serialVersionUID = 4464712018613675439L;
	private int exceptionIndex;
	private String exceptionName;
	
	public AutoException(EnumerationAutoException enu) {
		this.exceptionIndex = enu.getExceptionIndex();
		this.exceptionName = "Exception: #" + this.exceptionIndex + ". " + enu;
		this.logException();
	}
	
	/**
	 * Get the index of exception
	 */
	public int getExceptionIndex() {
		return this.exceptionIndex;
	}
	
	public void logException() {
		Date date = new Date();
		Timestamp stamp = new Timestamp(date.getTime());
		String log_info = "***************************************************\n"+
		                  this.exceptionName + "\n" + stamp.toString() + "\n" +
		                  "***************************************************\n";
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("ExceptionLog.txt",true)));
			bw.write(log_info);
			bw.flush();
			bw.close();
		} catch(IOException e) {
			System.out.println(e.toString());
		}
	}
}