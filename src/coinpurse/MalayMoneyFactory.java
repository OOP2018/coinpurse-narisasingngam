package coinpurse;
/**
 * The Factory create Money in Malay currency
 * @author Narisa Singngam
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	private long serialNumber = 1000000;
	/**
	 * Create Malay money to distinguish Coin and BankNote
	 * @param value in double
	 * @return Coin and BankNote in Ringgit
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException{
		double v[] = {0.05,0.1,0.2,0.5, 1, 2, 5, 10, 50, 100 };

		if (value < 1) {
			for (int i = 0; i < 4; i++) {
				if (v[i] == value)
					return new Coin(v[i], "Ringgit");
			}
		} else {
			for (int i = 4; i < v.length; i++) {
				if (v[i] == value)
					return new BankNote(v[i], "Ringgit",serialNumber++);
			}
		}
		throw new IllegalArgumentException();
	}

}
