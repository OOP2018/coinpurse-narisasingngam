package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * To demonstrate the compareTo method in Coin object
 * @author Narisa Singngam
 *
 */

public class MoneyUtil {

	public static void main(String[] args) {
		
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin (30.0,"Bath"));
		coins.add(new Coin (30.0,"pound"));
		coins.add(new Coin (1.0,"Bath"));
		coins.add(new Coin (0.5,"Bath"));
		printCoin( coins );
		sortCoins( coins );
		printCoin( coins );
	
		
	}
	/**
	 * To print the Coin in List
	 * @param coins is a list in Coin
	 */
	public static void printCoin(List<Coin> coins){
		for (Coin coin : coins) {
			System.out.println(coins );
		}
	}
	/**
	 * Sort any list of comparable object
	 * @param coins is a list in Coin
	 */
	public static void sortCoins(List<Coin> coins){
			java.util.Collections.sort( coins );
			
			
		}
}
