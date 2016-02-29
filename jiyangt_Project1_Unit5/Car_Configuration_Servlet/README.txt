CMU 18-641 Java for Smart Phone Development
Spring 2016

Project1 Unit5
Car Configuration Application
Client

Author: Jiyang Tao
Andrew ID: jiyangt
Date: Feb 21, 2016

Operating System: OS X EI Capitan 10.11.3
Platform: Eclipse Mars Release (4.5.0)
JavaSE 1.8

Directory
./
|—/ClassDiagram.png  *************************  The diagram of the project
|—/README.txt  *******************************  The read me file that describe the whole file
|—/build/  ***********************************  The compiled binary file
|—/src/  *************************************  The file contains source code
|    |—/adapter/  ****************************  The package adapter
|    |     |—/BuildAuto.java  ****************  The class BuildAuto
|    |     |—/CreateAuto.java  ***************  The CreateAuto interface
|    |     |—/EditAuto.java  *****************  The EditAuto interface, define the method edit
|    |     |—/FixAuto.java  ******************  The FixAuto interface, define the method to fix some problem its self
|    |     |—/ProxyAutoMobile.java  **********  The abstract realize almost all the functions
|    |     |—/UpdateAuto.java  ***************  The update interface
|    |—/client/  *****************************  The package client
|    |     |—/CarModelOptionsIO.java  ********  The class CarModelOptionsIO
|    |     |—/Client.java  *******************  The class Client, build a socket to server
|    |     |—/DefaultSocketClient.java  ******  The default client to realize the functions of client
|    |     |—/SelectCarOption.java  **********  The class SelectCarOption, used to select configuration of a car
|    |     |—/SocketClientConstant.java  *****  The interface, define several parameters
|    |     |—/SocketClientInterface.java  ****  The interface, define several method of client
|    |—/driver/  *****************************  The file contains the package driver
|    |     |—/StartClient.java  **************  Start an client
|    |—/exception/  **************************  The file contains the package exception
|    |     |—/AutoException.java  ************  Exception for illegal content in text source
|    |     |—/EnumerationAutoException.java  *  Store the error number
|    |     |—/ExceptionFixHelper.java  *******  Self-Healing
|    |—/model/  ******************************  The file contains the package model
|    |     |—/Automotive.java  ***************  Class defines the car’s basic information
|    |     |—/CarModels.java  ****************  This class uses linkedHashMap to store the multiple car models.
|    |     |—/OptionSet.java  ****************  Class defines the details of car’s configuration
|    |—/scale/  ******************************  The file contains the package scale
|    |     |—/EditOptions.java  **************  Implements the methods that modify Option price and OptionSet name
|    |—/servlet/  ****************************  The servlet package
|    |     |—/ModelSelectServlet.java  *******  Realize the servlet function that ask user to choose model
|    |     |—/OptionSelectServlet.java  ******  Realize the servlet function that let user to select options
|    |—/util/  *******************************  The file contains the package util
|    |     |—/FileIO.java  *******************  Implements reading and writing to the file
|—/WebContent/  ******************************  The web page source package
|    |     |—/result.jsp  ********************  Show the configuration and total price in final

Using Guide
1. Import this project into Eclipse
2. Open the java document: StartServer.java (In directory ‘Car Configuration Server’)
3. Open the java document: StartClient.java (In directory ‘Car Configuration Client’)
4. Submit several models, and store them in server
5. Add the project to TomCat7 server
6. Run the server
7. Open the browser and type in “Http://localhost:8888/Car_Configuration_Servlet/ModelSelectServlet”

Code Design
Implement all the requirements in handout.
Based on the implementation on project1 unit4
There are three web pages:
1st. Let user to choose one model
2nd. Let user to select configuration options
3rd. Show the final result