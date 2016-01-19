package coin;
/**
 * class Coin implement a coin with 2 sides, the heas and tails.
 * Simulation the toss to get the side that facing up
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 15, 2016
 *
 */
public class Coin {
	private String sideUp = new String();
	
	/**
	 * Simulation the toss action to show which side is up facing.
	 * Math.random() is used to get a random num in (0,1).
	 * If the random number is bigger then 0.5, consider as heads facing up
	 * If the random number is smaller then 0.5, consider as tails facing up
	 */
	public void toss() {
		double x = Math.random();
		if(x > 0.5) {
			this.sideUp = "heads";
		}
		else {
			this.sideUp = "tails";
		}
	}
	
	public String getSideUp() {
		return this.sideUp;
	}
	
	/**
	 * Initial an implement of the coin, and get the side randomly 
	 */
	public Coin() {
		this.toss();
	}
}