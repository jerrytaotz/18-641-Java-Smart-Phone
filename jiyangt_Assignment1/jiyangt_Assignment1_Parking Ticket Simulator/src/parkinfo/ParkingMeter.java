package parkinfo;
/**
 * This class simulate a parking meter,
 * it describes a the minutes that the car has purchased
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 15, 2016
 *
 */
public class ParkingMeter {
	private int parkingMinutes;
	public int getParkingMinutes() {
		return this.parkingMinutes;
	}
	
	/**
	 * Constructor that initialize the parking meter
	 * @param parkingMinutes minutes the car has purchased
	 */
	public ParkingMeter(int parkingMinutes) {
		this.parkingMinutes = parkingMinutes;
	}
}