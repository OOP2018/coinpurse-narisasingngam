package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

/**
 * Withdraw money in purse.
 * 
 * @author Narisa Singngam
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {

	private Comparator<Valuable> comp = new ValueComparator();

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuable) {

		double getBalance = 0;
		double amountD = amount.getValue();

		for (Valuable value : valuable) {
			getBalance += value.getValue();
		}

		if (amount == null)
			return null;
		if (amountD < 0 || amountD > getBalance)
			return null;

		Collections.sort(valuable, comp);
		Collections.reverse(valuable);

		List<Valuable> tempCurrency = new ArrayList<Valuable>();
		List<Valuable> temp = new ArrayList<Valuable>();

		for (Valuable value : valuable) {
			if (value.getCurrency().equals(amount.getCurrency())) {
				tempCurrency.add(value);
			}
		}

		for (Valuable value : tempCurrency) {
			if (value.getValue() <= amountD) {
				amountD -= value.getValue();
				temp.add(value);
			}

		}

		if (amountD != 0)
			return null;
		return temp;
		

	}

}
