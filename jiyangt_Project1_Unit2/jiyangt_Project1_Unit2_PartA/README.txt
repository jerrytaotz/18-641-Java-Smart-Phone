CMU 18-641 Java for Smart Phone Development
Spring 2016

Project1 Unit2
Part A 
Car Configuration Application

Author: Jiyang Tao
Andrew ID: jiyangt
Date: Feb 6, 2016

Operating System: OS X EI Capitan 10.11.3
Platform: Eclipse Mars Release (4.5.0)
JavaSE 1.8

Directory
./
|—/ClassDiagram.png  *************************  The diagram of the project
|—/ExceptionLog.txt  *************************  The exception information logged
|—/file_format.txt  **************************  Show how the source file “.txt” make up
|—/FordZTW-Wrong.txt  ************************  The abnormal source file records the car’s configuration items
|—/FordZTW.txt  ******************************  Normal source file records the car’s configuration items
|—/README.txt  *******************************  The read me file that describe the whole file
|—/output.txt  *******************************  The text file records the output results
|—/bin/  *************************************  The compiled binary file
|—/src/  *************************************  The file contains source code
|    |—/adapter/  ****************************  The package adapter
|    |     |—/BuildAuto.java  ****************  The class BuildAuto
|    |     |—/CreateAuto.java  ***************  The CreateAuto interface
|    |     |—/ProxyAutoMobile.java  **********  The abstract realize almost all the functions
|    |     |—/UpdateAuto.java  ***************  The update interface
|    |—/driver/  *****************************  The file contains the package driver
|    |     |—/Driver.java  *******************  Simulate the test and print the result
|    |—/exception/  **************************  The file contains the package exception
|    |     |—/AutoException.java  ************  Exception for illegal content in text source
|    |     |—/EnumerationAutoException.java  *  Store the error number
|    |     |—/ExceptionFixHelper.java  *******  Self-Healing
|    |—/model/  ******************************  The file contains the package model
|    |     |—/Automotive.java  ***************  Class defines the car’s basic information
|    |     |—/OptionSet.java  ****************  Class defines the details of car’s configuration
|    |—/util/  *******************************  The file contains the package util
|    |     |—/FileIO.java  *******************  Implements reading and writing to the file

Using Guide
1. Import this project into Eclipse
2. Open the java document: Driver.java
3. Run the file

Code Design
Implement all the requirements in handout.
When the system reads an abnormal source file (like lost some keywords, records missing or records exceeding), he system will recognize the problem and remind the user to modify.