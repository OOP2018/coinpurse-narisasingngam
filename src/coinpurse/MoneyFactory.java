package coinpurse;
/**
 * MoneyFactory is an abstract class that instance is attribute
 * @author Narisa Singngam
 *
 */

public abstract class MoneyFactory {
	/**
	 * singleton instance of MoneyFactory
	 */
	private static MoneyFactory instance;
	/**
	 * get an instance of MoneyFactory
	 * @return instance
	 */
	public static MoneyFactory getInstance() {
		return instance;
	}

	/**
	 * New money object in the local currency.
	 * @param value in double
	 */
public abstract Valuable createMoney(double value) ;
	
/**
 * Accept money value as String
 * @param value in String
 * @return the method createMoney which is parameter to a double
 */
public Valuable createMoney(String value){
	double valueD = 0;
	try{
		valueD = Double.parseDouble(value);
	}catch( NumberFormatException ex){
		System.out.println("not a number");
	}
	return createMoney(valueD);
}

/**
 * Set MoneyFactory object to test.
 * @param f object of MoneyFactory
 */

public static void setFactory(MoneyFactory f){
	instance = f;
}
	
	
}
