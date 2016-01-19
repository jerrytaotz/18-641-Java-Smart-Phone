CMU 18-641 Java for Smart Phone Development
Spring 2016

Assignment 1
Part b Parking Ticket Simulator

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
|    |-/ParkSimulation.java  ********  Simulate the test and print the result
|    |—/parkinfo/  ******************  The file contains the package parking
|    |     |—/ParkedCar.java  *******  The class to define the car’s information
|    |     |—/ParkingMeter.java  ****  The class to define the parking meter
|    |     |—/ParkingTicket.java  ***  The class to define the tickets issued by police
|    |     |-/ParkSimulation.java  ********  Simulate the test and print the result
|    |     |—/PoliceOfficer.java  ***  The class to define the describe the police’s information

Using Guide
1. Import this project into Eclipse
2. Open the java document: ParkSimulation.java
3. Run the file

Code Design
1. Implement a car, that is a Blue Passat build by Volkswagen, car number is PA18641, has parked 180 minutes.
2. Implement a police, named: Jiyang Tao, the badge number is 11140614.
3. Test 6 cases:
   Case 1. Purchased time (190 minutes) bigger then parked time.
   Case 2. Purchased time (180 minutes) just the same as parked time.
   Case 3. Purchased time (150 minutes) smaller then parked time, within an hour.
   Case 4. Purchased time (120 minutes) smaller then parked time, just an hour.
   Case 5. Purchased time (60 minutes) smaller then as parked time, just 2 hours.
   Case 6. Purchased time (48 minutes) smaller then as parked time, more then 2 hours but less then 3 hours.