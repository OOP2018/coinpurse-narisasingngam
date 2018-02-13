package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A  purse contains List of Valuable. You can insert money, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Narisa Singngam
 */
public class Purse {
	/** Collection of objects in the purse. */

	private List<Valuable> money;
	private Comparator<Valuable> comp = new ValueComparator();

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of Money you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>(capacity);
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * money, not their value.
	 * 
	 * @return the number of money in the purse
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
	 * Return the capacity of the purse.
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
	 * Insert a value into the purse. The value is only inserted if the purse has
	 * space for it and the value has positive value. No worthless coins!
	 * 
	 * @param value
	 *            is a Valuable object to insert into purse
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
	 * Withdraw the amount, using only items that have the same currency as the parameter(amount).
	 * amount must not be null and amount.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Money objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	
	public Valuable[] withdraw(Valuable amount) {
		double amountV = amount.getValue();
		if (amountV < 0 || amountV > getBalance()) return null;
		
		Collections.sort(money,comp);
		Collections.reverse(money);
		List<Valuable> temp = new ArrayList<Valuable>();
		
		List<Valuable> tempCurrency = new ArrayList<Valuable>();
		for(Valuable v : money){
			if(v.getCurrency().equals(amount.getCurrency())){
				tempCurrency.add(v);
			}
		}

		for (Valuable value : tempCurrency) {
			if (value.getValue() <= amountV) {
				amountV -= value.getValue();
				temp.add(value);
			}
		}

		if (amountV != 0) return null;

		for (Valuable value : temp) money.remove(value);
		

		Valuable[] array = new Valuable[temp.size()];
		return temp.toArray(array);
	}
	
	/**
	 * Withdraw amount using the default currency, which is "Bath".
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Money objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		Money moneyA = new Money(amount,"Baht");
		return withdraw(moneyA);
		
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return String.format("%d money with value %.1f", count(), getBalance());
	}

}
