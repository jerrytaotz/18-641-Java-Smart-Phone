package parkinfo;
/**
 * This class define the parking ticket,
 * the ticket has parameter fine, 
 * this class will calculate the fine, knows the car's information and police's information
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 15, 2016
 *
 */
public class ParkingTicket {
	private int fine;
	
	public void reportMake(ParkedCar car) {
		System.out.println("The illegally parked car's make: " + car.getMake());
	}
	public void reportModel(ParkedCar car) {
		System.out.println("The illegally parked car's model: " + car.getModel());
	}
	public void reportColor(ParkedCar car) {
		System.out.println("The illegally parked car's color: " + car.getColor());
	}
	public void reportLicenseNumber(ParkedCar car) {
		System.out.println("The illegally parked car's license number: " + car.getLicenseNumber());
	}
	
	/**
	 * This method can calculate the fine
	 * @param car contains car's information
	 * @param meter contains meter's information
	 */
	public void reportFine(ParkedCar car, ParkingMeter meter) {
		int exceedingTime = car.getParkedTime() - meter.getParkingMinutes();
		if(exceedingTime <= 0) {
			fine = 0;
		}
		else if(exceedingTime <= 60){
			fine = 25;
		}
		else {
			fine = 25;
			exceedingTime -= 60;
			while(exceedingTime > 0){
				exceedingTime -= 60;
				fine += 10;
			}
		}
		System.out.println("The fine (dollar): " + fine);
	}
	
	public void reportPoliceName(PoliceOfficer officer) {
		System.out.println("This ticket issued by: " + officer.getName());
	}
	public void reportPoliceBadgeNumber(PoliceOfficer officer) {
		System.out.println("The badge number: " + officer.getBadgeNumber());
	}
}