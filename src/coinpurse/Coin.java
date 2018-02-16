package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Narisa Singngam
 *
 */

public class Coin extends Money  {
	/**
	 * Initialize a value and currency
	 * @param value 
	 * @param currency
	 */
	public Coin(double value, String currency) {
		super(value,currency);
	}


	@Override
	public String toString() {
		if(this.currency.equals("Ringgit")){
			return this.getValue() + "-" + "Sen";
		}
		return this.getValue() + "-" + this.getCurrency();
	}

}
