package coinpurse;

import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {

	@Override
	public int compare(Valuable o1, Valuable o2) {
		if (o1.getCurrency().equals(o2.getCurrency())) {
			if (o1.getValue() < o2.getValue()) {
				return -1;
			} else if (o1.getValue() > o2.getValue()) {
				return 1;
			} else if (o1.getValue() == o2.getValue()) {
				return 0;
			} else {
				if (o1.getCurrency().charAt(0) < o2.getCurrency().charAt(0)) {
					return -1;
				} else if (o1.getCurrency().charAt(0) > o2.getCurrency().charAt(0)) {
					return 1;
				}
			}
		}
		return 0;
	}

}
