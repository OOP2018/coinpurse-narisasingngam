package coinpurse;

/**
 * 
 * @author Narisa Singngam
 *
 */

public class Money implements Valuable{

	/** The value of money */
	protected double value;
	/** The currency of money */
	protected String currency;

	/**
	 * Initialize a value and currency.
	 * @param value of money
	 * @param currency of money
	 */
	public Money(double value, String currency) {
		if (value >= 0) {
			this.value = value;
		}
		this.currency = currency;
	}

	/**
	 * get value in money
	 * @return value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * get currency in money
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * Compare two objects that implement Valuable. First compare them by
	 * currency, so that "Baht" < "Dollar". If both objects have the same
	 * currency, order them by value.
	 */
	@Override
	public int compareTo(Valuable o){
		if (this.getCurrency().equals(o.getCurrency())) {
			if (this.getValue() < o.getValue()) {
				return -1;
			} else if (this.getValue() > o.getValue()) {
				return 1;
			} else if (this.getValue() == o.getValue()) {
				return 0;
			}
		}
		return this.getCurrency().compareTo(o.getCurrency());
		
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
		Money other = (Money) arg;
		if (this.getValue() != other.getValue()) {
			return false;
		}
		if (!this.getCurrency().equals(other.getCurrency())) {
			return false;
		}
		return true;
	}
	
	

}