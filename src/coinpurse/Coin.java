package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Narisa Singngam
 *
 */

public class Coin implements Valuable {
	/** The value of money */
	private double value;
	/** The currency of money */
	private String currency;

	/**
	 * Initialize a value and currency
	 * @param value 
	 * @param currency
	 */
	public Coin(double value, String currency) {
		if (value >= 0) {
			this.value = value;
		}
		this.currency = currency;
	}

	/**
	 * get value in coin
	 * @return value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * get currency in coin
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * check the value and currency 
	 * @param arg 
	 * @return true if it equal
	 */
	@Override
	public boolean equals(Object arg) {
		if (arg == null) {
			return false;
		}
		if (this.getClass() != arg.getClass()) {
			return false;
		}
		Coin other = (Coin) arg;
		if (this.getValue() != other.getValue()) {
			return false;
		}
		if (!this.getCurrency().equals(other.getCurrency())) {
			return false;
		}
		return true;
	}

	/**
	 * Compare the value of coin
	 * @param coin is the object 
	 * @return -1 if the first less than the second
	 * @return 1 if the first more than the second
	 * @return 0 if it the same value
	 */
	public int compareTo(Coin coin) {
		if (this.getValue() < coin.getValue()) {
			return -1;
		} else if (this.getValue() > coin.getValue()) {
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public String toString() {
		return value + "-" + currency;
	}

}
