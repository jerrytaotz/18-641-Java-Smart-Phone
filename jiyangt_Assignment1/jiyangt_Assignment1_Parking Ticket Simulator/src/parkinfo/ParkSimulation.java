package parkinfo;
/**
 * This class is the main entrance of the program.
 * It implements several different cases.
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 15, 2016
 *
 */
import java.util.ArrayList;
public class ParkSimulation {
	public static void main(String[] args) {
		PoliceOfficer police = new PoliceOfficer("Jiyang Tao", "11140614");
		ParkedCar car = new ParkedCar("Volkswagen", "Passat", "Blue", "PA18641", 180);
		ArrayList<ParkingMeter> meters = new ArrayList<ParkingMeter>();
		//Case 1. Purchased time (190 minutes) bigger then parked time.
		ParkingMeter meter1 = new ParkingMeter(190);
		meters.add(meter1);
		//Case 2. Purchased time (180 minutes) just the same as parked time.
		ParkingMeter meter2 = new ParkingMeter(180);
		meters.add(meter2);
		//Case 3. Purchased time (150 minutes) smaller then parked time, within an hour.
		ParkingMeter meter3 = new ParkingMeter(150);
		meters.add(meter3);
		//Case 4. Purchased time (120 minutes) smaller then parked time, just an hour.
		ParkingMeter meter4 = new ParkingMeter(120);
		meters.add(meter4);
		//Case 5. Purchased time (60 minutes) smaller then as parked time, just 2 hours.
		ParkingMeter meter5 = new ParkingMeter(60);
		meters.add(meter5);
		//Case 6. Purchased time (48 minutes) smaller then as parked time, more then 2 hours but less then 3 hours.
		ParkingMeter meter6 = new ParkingMeter(48);
		meters.add(meter6);
		for(int i = 0; i < meters.size(); i++){
			System.out.println("--------------------Case " + (i+1) + "--------------------");
			if(police.isExpired(car, meters.get(i))){
				ParkingTicket ticket = new ParkingTicket();
				police.issuedTicket(car, meters.get(i), ticket);
			}
		}
	}
}