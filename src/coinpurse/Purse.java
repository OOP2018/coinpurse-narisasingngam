package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Narisa Singngam
 */
public class Purse {
	/** Collection of objects in the purse. */

	private List<Valuable> money;
//	Valuable[] array = new Valuable[20];

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>(capacity);

	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double total = 0;
		for (Valuable value : money) {
			total += value.getValue();
		}
		return total;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {

		return capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {

		if (count() >= this.capacity) {
			return true;
		}
		return false;

	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable value) {
		if (!isFull() && value.getValue() > 0) {
			money.add(value);
			return true;
		}
		return false;

	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	Comparator<Valuable> comp = new ValueComparator();
	//fix
	public Valuable[] withdraw(double amount) {
		if (amount < 0 || amount > getBalance()) {
			return null;
		}

		double amountNeededToWithdraw = amount;
		Collections.sort(money,comp);
		Collections.reverse(money);
		List<Valuable> temp = new ArrayList<Valuable>();

		for (Valuable value : money) {
			if (value.getValue() <= amountNeededToWithdraw) {
				amountNeededToWithdraw -= value.getValue();
				temp.add(value);
			}
		}

		if (amountNeededToWithdraw != 0) {

			return null;

		}

		for (Valuable value : temp) {
			money.remove(value);
		}

		Valuable[] array = new Valuable[temp.size()];
		return temp.toArray(array);
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return String.format("%d money with value %.1f", count(), getBalance());
	}

}
