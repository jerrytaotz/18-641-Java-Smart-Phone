CMU 18-641 Java for Smart Phone Development
Spring 2016

Project1 Unit4
Car Configuration Application
Server

Author: Jiyang Tao
Andrew ID: jiyangt
Date: Feb 21, 2016

Operating System: OS X EI Capitan 10.11.3
Platform: Eclipse Mars Release (4.5.0)
JavaSE 1.8

Directory
./
|—/ClassDiagram.png  *************************  The diagram of the project
|—/ExceptionLog.txt  *************************  The exception information logged
|—/file_format.txt  **************************  Show how the source file “.txt” make up
|—/README.txt  *******************************  The read me file that describe the whole file
|—/output.txt  *******************************  The text file records the output results
|—/bin/  *************************************  The compiled binary file
|—/src/  *************************************  The file contains source code
|    |—/adapter/  ****************************  The package adapter
|    |     |—/BuildAuto.java  ****************  The class BuildAuto
|    |     |—/CreateAuto.java  ***************  The CreateAuto interface
|    |     |—/EditAuto.java  *****************  The EditAuto interface, define the method edit
|    |     |—/FixAuto.java  ******************  The FixAuto interface, define the method to fix some problem its self
|    |     |—/ProxyAutoMobile.java  **********  The abstract realize almost all the functions
|    |     |—/UpdateAuto.java  ***************  The update interface
|    |—/driver/  *****************************  The file contains the package driver
|    |     |—/StartServer.java  **************  Start the server
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
|    |—/server/  *****************************  The package client
|    |     |—/AutoServer.java  ***************  The class AutoServer
|    |     |—/BuildCarModelOptions.java  *****  The class Client, build a socket to server
|    |     |—/DefaultSocketClient.java  ******  The default client to realize the functions of server
|    |     |—/Server.java  *******************  The class Server, build a socket to listen on one port
|    |     |—/SocketServerConstant.java  *****  The interface, define several parameters
|    |     |—/SocketServerInterface.java  ****  The interface, define several method of client
|    |—/util/  *******************************  The file contains the package util
|    |     |—/FileIO.java  *******************  Implements reading and writing to the file

Using Guide
1. Import this project into Eclipse
2. Open the java document: StartServer.java (This part need to open first)
3. Run the file

Code Design
Implement all the requirements in handout.
Based on the implementation on project1 unit3
1. Receive the transmit auto properties from client, and store it.
2. Select the specific automobile, set to properties object, send to client