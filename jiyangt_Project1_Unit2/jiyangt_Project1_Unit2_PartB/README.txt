CMU 18-641 Java for Smart Phone Development
Spring 2016

Project1 Unit1 
Car Configuration Application

Author: Jiyang Tao
Andrew ID: jiyangt
Date: Jan 30, 2016

Operating System: OS X EI Capitan 10.11.3
Platform: Eclipse Mars Release (4.5.0)
JavaSE 1.8

Directory
./
|—/auto.ser  ******************************  Serialized file recording the Automotive Object
|—/file_format.txt  ***********************  Show how the source file “.txt” make up
|—/FordZTW-Less-OptionSet.txt  ************  Source file contains less OptionSet then it was defined
|—/FordZTW-More-Option.txt  ***************  Source file contains more Option then it was defined
|—/FordZTW.txt  ***************************  Normal source file records the car’s configuration items
|—/README.txt  ****************************  The read me file that describe the whole file
|—/output.txt  ****************************  The text file records the output results
|—/bin/  **********************************  The compiled binary file
|—/src/  **********************************  The file contains source code
|    |—/driver/  **************************  The file contains the package driver
|    |     |—/Driver.java  ****************  Simulate the test and print the result
|    |—/exception/  ***********************  The file contains the package exception
|    |     |—/WrongContentException.java  *  Exception for illegal content in text source
|    |—/model/  ***************************  The file contains the package model
|    |     |—/Automotive.java  ************  Class defines the car’s basic information
|    |     |—/OptionSet.java  *************  Class defines the details of car’s configuration
|    |—/util/  ****************************  The file contains the package util
|    |     |—/FileIO.java  ****************  Implements reading and writing to the file

Using Guide
1. Import this project into Eclipse
2. Open the java document: Driver.java
3. Run the file

Code Design
Implement all the requirements in handout.
Users can find/update/delete configuration details by both the serial number and the configuration name.