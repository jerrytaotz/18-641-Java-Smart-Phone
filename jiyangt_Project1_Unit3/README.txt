CMU 18-641 Java for Smart Phone Development
Spring 2016

Project1 Unit3
Car Configuration Application

Author: Jiyang Tao
Andrew ID: jiyangt
Date: Feb 14, 2016

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
|—/README.txt  *******************************  The read me file that describe the whole file
|—/output.txt  *******************************  The text file records the output results
|—/bin/  *************************************  The compiled binary file
|—/src/  *************************************  The file contains source code
|    |—/adapter/  ****************************  The package adapter
|    |     |—/BuildAuto.java  ****************  The class BuildAuto
|    |     |—/CreateAuto.java  ***************  The CreateAuto interface
|    |     |—/EditAuto.java  *****************  The EditAuto interface, define the method edit
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
|    |     |—/CarModels.java  ****************  This class uses linkedHashMap to store the multiple car models.
|    |     |—/OptionSet.java  ****************  Class defines the details of car’s configuration
|    |—/scale/  ******************************  The file contains the package scale
|    |     |—/EditOptions.java  **************  Implements the methods that modify Option price and OptionSet name
|    |—/util/  *******************************  The file contains the package util
|    |     |—/FileIO.java  *******************  Implements reading and writing to the file

Using Guide
1. Import this project into Eclipse
2. Open the java document: Driver.java
3. Run the file

Code Design
Implement all the requirements in handout.
Based on the implementation on project1 unit2, add the edit method, the edit method using multi-thread to realize, just for testing, each thread may update the model 4 to 5 times, using synchronized, only one thread can modify the same model at the same time, the threads modify different models can work parallel (just as shows the result in output.txt).