package coin;
/**
 * This is the main entrance of the program.
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 15, 2016
 *
 */
public class CoinSimulator {
	public static void main(String[] args){
		Coin coin_instance = new Coin();
		System.out.println("The side that is initially facing up: " + coin_instance.getSideUp());
		int countHeads = 0;
		int countTails = 0;
		
		/**
		 * Simulation toss action 20 times
		 * Print the side that is facing up every time
		 * Count each result
		 */
		for(int i = 0; i < 20; i ++){
			coin_instance.toss();
			System.out.println(i+1 + ". The side that is facing up: " + coin_instance.getSideUp());
			if (coin_instance.getSideUp().equals("heads")) {
				countHeads ++;
			}
			else {
				countTails ++;
			}
		}
		System.out.println("-------------------Statistics-------------------");
		System.out.println(countHeads + " times that heads is facing up");
		System.out.println(countTails + " times that tails is facing up");
	}
}