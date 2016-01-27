CMU 18-641 Java for Smart Phone Development
Spring 2016

Assignment 2
Object relationship And File IO

Author: Jiyang Tao
Andrew ID: jiyangt
Date: Jan 24, 2016

Operating System: OS X EI Capitan 10.11.2
Platform: Eclipse Mars Release (4.5.0)
JavaSE 1.8

Directory
./
|—/ClassDiagram.png  ****************  The diagram shows the relationship between classes
|—/README.txt  **********************  The read me file that describe the whole file
|—/student_above40.txt  *************  Data file records more then 40 students
|—/student_below40.txt  *************  Data file records less then 40 students
|—/student_equal40.txt  *************  Data file records 40 students
|—/test_output.txt  *****************  The text file records the output results
|—/bin/  ****************************  The compiled binary file
|—/src/  ****************************  The file contains source code
|    |—/driver/  ********************  The file contains the package driver
|    |    |-/Driver.java  ***********  Simulate the test and print the result
|    |—/exception/  *****************  The file contains the package exception
|    |    |-/ExcessiveStu.java  *****  Exception for too many students
|    |    |-/WrongNumScore.java  ****  Exception for wrong number of scores
|    |—/model/  *********************  The file contains the package model
|    |    |-/Statistics.java  *******  Class that calculate and print the statistics
|    |    |-/Student.java  **********  Class that contains
|    |—/prototype/  *****************  The file contains the package prototype
|    |    |-/Constant.java  *********  Constant interface that include constants
|    |    |-/People.java  ***********  People abstract
|    |    |-/Printer.java  **********  The printer interface, include print method
|    |    |-/State.java  ************  State abstract define 3 states and get method
|    |—/util/  **********************  The file contains the package util
|    |    |-/Util.java  *************  Class implements reading the text file


Using Guide
1. Import this project into Eclipse
2. Open the java document: Driver.java
3. Run the file

Code Design
Flowing the rules and requirements in handout, implements some classes extends the abstract and implements the interface.
Tests include three cases:
   Case 1. The records is less then 40 lines (less then 40 students totally).
   Case 2. The records has 40 lines (Just 40 students totally).
   Case 3. The records is more then 40 lines (more then 40 students totally).