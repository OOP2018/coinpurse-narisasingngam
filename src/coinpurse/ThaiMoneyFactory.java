package coinpurse;

/**
 * The Factory create Money in Thai currency
 * @author Narisa Singngam
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	
	private long serialNumber = 1000000;
	
	/**
	 * Create Thai money to distinguish Coin and BankNote
	 * @param value in double
	 * @return Coin and BankNote in Baht
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException{
		double v[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

		if (value < 20) {
			for (int i = 0; i < 4; i++) {
				if (v[i] == value)
					return new Coin(v[i], "Baht");
			}

		} else {
			for (int i = 4; i < v.length; i++) {
				if (v[i] == value)
					return new BankNote(v[i], "Baht",serialNumber++);
			}
		}
		throw new IllegalArgumentException();

	}

}
