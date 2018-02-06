package coinpurse;

import java.util.Comparator;

/**
 * Compare the two valuable.
 * 
 * @author Narisa Singngam
 *
 */
public class ValueComparator implements Comparator<Valuable> {
	/**
	 * Compare two objects that implement Valuable. First compare them by
	 * currency, so that "Baht" < "Dollar". If both objects have the same
	 * currency, order them by value.
	 */
	@Override
	public int compare(Valuable o1, Valuable o2) {
		if (o1.getCurrency().equals(o2.getCurrency())) {
			if (o1.getValue() < o2.getValue()) {
				return -1;
			} else if (o1.getValue() > o2.getValue()) {
				return 1;
			} else if (o1.getValue() == o2.getValue()) {
				return 0;
			}
		}
		return o1.getCurrency().compareTo(o2.getCurrency());

	}

}
