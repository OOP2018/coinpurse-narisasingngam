package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * To demonstrate the compareTo method in Coin object
 * 
 * @author Narisa Singngam
 *
 */

public class MoneyUtil {
	private static long serialNumber = 1000000;

	/**
	 * Return the larger argument, based on sort order, using the objects' own
	 * compareTo method for comparing.
	 * 
	 * @param args
	 *            one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException
	 *             if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E... arg) {
		E max = arg[0];
		for (E e : arg)
			if (e.compareTo(max) > 0)
				max = e;
		return max;
	}

	/**
	 * To print the Coin in List
	 * 
	 * @param value
	 *            is a list in Coin
	 */
	public static void printMoney(List<? extends Valuable> value) {
		for (Valuable values : value) {
			System.out.println(values);
		}
	}

	/**
	 * To filter the coin that contain the same currency
	 * 
	 * @param value
	 *            is the object
	 * @param currency
	 * @return the list of the Coin which have same currency.
	 */

	public static <E extends Valuable> List<E> filterByCurrency(List<E> value, String currency) {
		List<E> sameCurrency = new ArrayList<>();
		for (E values : value) {
			if (values.getCurrency().equals(currency)) {
				sameCurrency.add(values);
			}
		}
		return sameCurrency;
	}

	/**
	 * Sort any list of comparable object
	 * 
	 * @param value
	 *            is a list in Coin
	 */
	public static void sortMoney(List<? extends Valuable> value) {
		Comparator<Valuable> comp = new ValueComparator();
		java.util.Collections.sort(value, comp);

	}

	public static void main(String[] args) {

		List<Coin> valueable = new ArrayList<Coin>();
		valueable.add(new Coin(30.0, "Bath"));
		valueable.add(new Coin(30.0, "pound"));
		valueable.add(new Coin(1.0, "Bath"));
		valueable.add(new Coin(0.5, "Bath"));
		// valueable.add(new BankNote (30.0,"Bath",serialNumber));
		printMoney(valueable);
		sortMoney(valueable);
		Money m1 = new BankNote(100, "Baht", serialNumber);
		Money m2 = new BankNote(500, "Baht", serialNumber);
		Money m3 = new Coin(20, "Baht");
		Money max = MoneyUtil.max(m1, m2, m3);
		System.out.println(max);

	}
}
