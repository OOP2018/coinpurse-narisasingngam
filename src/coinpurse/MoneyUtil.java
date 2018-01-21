package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {

	public static void main(String[] args) {
		
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin (30.0,"Bath"));
		coins.add(new Coin (30.0,"pound"));
		coins.add(new Coin (1.0,"Bath"));
		coins.add(new Coin (0.5,"Bath"));
		printCoin( coins );
		sortCoins( coins );
	
		
	}
	
	public static void printCoin(List<Coin> coins){
		for (Coin coin : coins) {
			System.out.println(coins );
		}
	}
	
	public static void sortCoins(List<Coin> coins){
			java.util.Collections.sort( coins );
			
			
		}
}
