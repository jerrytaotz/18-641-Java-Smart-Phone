CMU 18-641 Java for Smart Phone Development
Spring 2016

Project1 Unit4
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
|—/Audio-A8.txt  *****************************  Normal source file records the Audio car’s configuration items
|—/ClassDiagram.png  *************************  The diagram of the project
|—/ExceptionLog.txt  *************************  The exception information logged
|—/file_format.txt  **************************  Show how the source file “.txt” make up
|—/FordZTW.txt  ******************************  Normal source file records the Ford car’s configuration items
|—/model-Audio-A8.properties  ****************  Properties file, contains the option of car
|—/model-FordZTW.properties  *****************  Properties file, contains the option of car
|—/README.txt  *******************************  The read me file that describe the whole file
|—/output-client1.txt  ***********************  The text file records the output results, upload ‘.properties’ file, configuration
|—/output-client2.txt  ***********************  The text file records the output results, upload ‘.txt’ file
|—/bin/  *************************************  The compiled binary file
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
|    |—/util/  *******************************  The file contains the package util
|    |     |—/FileIO.java  *******************  Implements reading and writing to the file

Using Guide
1. Import this project into Eclipse
2. Open the java document: StartClient.java (Need open the server first)
3. Run the file

Code Design
Implement all the requirements in handout.
Based on the implementation on project1 unit3
1. User can chose to upload a new model. Can read both the ‘.txt’ file and the ‘.properties’ file, transform the content in ‘.txt’ file to Properties object, transmit properties object to server in serialization. 
2. User can chose to configure a car store in the server
3. User can close the socket