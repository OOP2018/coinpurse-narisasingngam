package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * To demonstrate the compareTo method in Coin object
 * @author Narisa Singngam
 *
 */

public class MoneyUtil {

	/**
	 * To print the Coin in List
	 * @param value is a list in Coin
	 */
	public static void printCoin(List<Valuable> value){
		for (Valuable values : value) {
			System.out.println(values );
		}
	}
	
	/**
	 * To filter the coin that contain the same currency
	 * @param value is the object
	 * @param currency
	 * @return the list of the Coin which have same currency.
	 */
	
	public static List<Valuable> filterByCurrency(List<Valuable> value, String currency){
		List<Valuable> sameCurrency = new ArrayList<>();
				for (Valuable values : value) {
					if(values.getCurrency().equals(currency)){
						sameCurrency.add(values);
					}
				}
		return sameCurrency;
	}
	
	/**
	 * Sort any list of comparable object
	 * @param value is a list in Coin
	 */
	public static void sortCoins(List<Valuable> value){
		Comparator<Valuable> comp = new ValueComparator();
			java.util.Collections.sort( value,comp );
			
			
		}
	
	public static void main(String[] args) {
		
		List<Valuable> coins = new ArrayList<Valuable>();
		coins.add(new Coin (30.0,"Bath"));
		coins.add(new Coin (30.0,"pound"));
		coins.add(new Coin (1.0,"Bath"));
		coins.add(new Coin (0.5,"Bath"));
		printCoin( coins );
		sortCoins(coins);
		
	
		
	}
}
