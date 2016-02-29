package client;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Feb 19, 2016
 * 
 * This interface define several constant parameters of client
 */
public interface SocketClientConstant {
	int SERVER_PORT = 8080;
    boolean DEBUG = true;
    String MENU = "What To Do: \n" +
      	  "1. Upload A New Car\n" +
      	  "2. Configure An Existing Car\n" +
      	  "0. Quit\n";
    String CHOOSE_REQUIRE = "Your Choice: ";
    String FILE_REQUIRE = "Please input the name of model file: ";
    String CAR_CONFIGURATION = "Your Configuration";
    String CLOSE_SOCKET = "Close the Socke";
    String BUILD_SUCCESS = "File upload success";
    String BUILD_FALSE = "File upload failed";
    String CHOOSE_MODEL_REQUIRE = "Select A Model: ";
}