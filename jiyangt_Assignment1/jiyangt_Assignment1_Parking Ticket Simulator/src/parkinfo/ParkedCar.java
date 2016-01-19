package parkinfo;
/**
 * This class define the car's information,
 * the car's information includes, make, model, color, license number and parked time.
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 15, 2016
 *
 */
public class ParkedCar {
	private String make = new String();
	private String model = new String();
	private String color = new String();
	private String licenseNumber = new String();
	private int parkedTime;
	public String getMake() {
		return this.make;
	}
	public String getModel() {
		return this.model;
	}
	public String getColor() {
		return this.color;
	}
	public String getLicenseNumber() {
		return this.licenseNumber;
	}
	public int getParkedTime() {
		return this.parkedTime;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public void setParkedTime(int parkedTime ) {
		this.parkedTime = parkedTime;
	}
	
	/**
	 * Constructor that initialize a new car
	 * @param make: car's make
	 * @param model car's model
	 * @param color car's color
	 * @param licenseNumber car's licenseNumber
	 * @param parkedTime the time (minutes) the car has parked
	 */
	public ParkedCar(String make, String model, String color, String licenseNumber, int parkedTime) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.licenseNumber = licenseNumber;
		this.parkedTime = parkedTime;
	}
}