package parkinfo;
/**
 * This class include police's information, name and badge number
 * This class will also exam the parking car to know whether it is illegal or not,
 * and issues ticket to illegally car
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 15, 2016
 *
 */
public class PoliceOfficer {
	private String name = new String();
	private String badgeNumber = new String();
	public void setName(String name) {
		this.name = name;
	}
	public void setBadgeNumber(String badgeNumber) {
		this.badgeNumber = badgeNumber;
	}
	public String getName() {
		return this.name;
	}
	public String getBadgeNumber() {
		return this.badgeNumber;
	}
	
	/**
	 * This method can test whether the car's parking time is expired
	 * @param car
	 * @param meter
	 * @return
	 */
	public boolean isExpired(ParkedCar car, ParkingMeter meter) {
		System.out.println("Checking a parked car...");
		if(car.getParkedTime() > meter.getParkingMinutes()) {
			System.out.println("The parked car is illegal!");
			return true;
		}
		else {
			System.out.println("Parked Time (Minutes): " + car.getParkedTime());
			System.out.println("Purchased Time (Minutes): " + meter.getParkingMinutes());
			System.out.println("The parked car is in legal!");
			return false;
		}
	}
	
	/**
	 * This method is used for issuing the ticket to the illegally car
	 * @param car the car's information
	 * @param meter the meter's information
	 * @param ticket the ticket's information
	 */
	public void issuedTicket(ParkedCar car, ParkingMeter meter, ParkingTicket ticket) {
		System.out.println("The Ticket");
		ticket.reportMake(car);
		ticket.reportModel(car);
		ticket.reportColor(car);
		ticket.reportLicenseNumber(car);
		System.out.println("Parked Time (Minutes): " + car.getParkedTime());
		System.out.println("Purchased Time (Minutes): " + meter.getParkingMinutes());
		ticket.reportFine(car, meter);
		ticket.reportPoliceName(this);
		ticket.reportPoliceBadgeNumber(this);
	}
	
	/**
	 * Constructor that initialize the police
	 * @param name the police's name
	 * @param badgeNumber the police's badge number
	 */
	public PoliceOfficer(String name, String badgeNumber){
		this.name = name;
		this.badgeNumber = badgeNumber;
	}
}