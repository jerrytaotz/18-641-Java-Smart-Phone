CMU 18-641 Java for Smart Phone Development
Spring 2016

Assignment 1
Part a Coin Toss

Author: Jiyang Tao
Andrew ID: jiyangt
Date: Jan 17, 2016

Operating System: OS X EI Capitan 10.11.2
Platform: Eclipse Mars Release (4.5.0)
JavaSE 1.8

Directory
./
|—/ClassDiagram.png  ****************  The diagram shows the relationship between classes
|—/README.txt  **********************  The read me file that describe the whole file
|—/test_output.txt  *****************  The text file records the output results
|—/bin/  ****************************  The compiled binary file
|—/src/  ****************************  The file contains source code
|    |—/coin/  **********************  The file contains the package coin
|    |     |—/Coin.java  ************  Implement the Coin class and toss method
|    |     |-/CoinSimulator.java  *********  Simulate the test and print the result

Using Guide
1. Import this project into Eclipse
2. Open the java document: CoinSimulator.java
3. Run the file

Code Design
This code create an instance of the class and implement the toss 20 times, finally count the times the heads side and tails side face up separately, and shows the result.