package coinpurse;

/**
 * 
 * @author Narisa Singngam
 *
 */
public interface Valuable {

	/**
	 * Get the monetary value of this object, in its own currency.
	 * @return the value of this object
	 */
	public  double getValue();
	public  String getCurrency();
	
}
