package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

public class GreedyWithdraw implements WithdrawStrategy {

	private Comparator<Valuable> comp = new ValueComparator();
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuable) {
		
			double getBalance = 0;
			double amountV = amount.getValue();
			for (Valuable value : valuable) {
				getBalance += value.getValue();
			}
			if(amount == null) return null;
			if (amountV < 0 || amountV > getBalance) return null;
			
			Collections.sort(valuable,comp);
			Collections.reverse(valuable);
			List<Valuable> temp = new ArrayList<Valuable>();
			
			List<Valuable> tempCurrency = new ArrayList<Valuable>();
			for(Valuable v : valuable){
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
			for (Valuable value : temp) valuable.remove(value);
			if (amountV != 0) return null;		
			return temp;
		
	}



	

}
