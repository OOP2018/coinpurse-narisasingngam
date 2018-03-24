package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;

/**
 * Withdraw money in purse with recursive strategy.
 * @author Narisa Singngam
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy{

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuable) {
		if(amount.getValue() < 0) return null;
		if(amount.getValue() != 0 && valuable.size() == 0) return null;
		if(amount.getValue() == 0) return new ArrayList<>();
	
		Valuable money1 = new Money(amount.getValue() - valuable.get(0).getValue(), amount.getCurrency());
		List<Valuable> left = withdraw(money1, valuable.subList(1, valuable.size()));
		List<Valuable> right = withdraw(amount,valuable.subList(1, valuable.size()));
		if(left != null){
			left.add(valuable.get(0));
			return left;
		}
		return right;
	}

}
