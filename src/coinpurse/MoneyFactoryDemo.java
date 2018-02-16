package coinpurse;
/**
 * 
 * @author Narisa Singngam
 *
 */
public class MoneyFactoryDemo {
	
	public static void main(String[] args) {
		System.out.println("#Thai money");
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable v2 = factory.createMoney(50);
		System.out.println(v2);
		System.out.println("#Malay money");
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory factoryM = MoneyFactory.getInstance();
		Valuable v3 = factoryM.createMoney(50);
		System.out.println(v3);
		MoneyFactory Malay = new MalayMoneyFactory();
		System.out.println(Malay.createMoney(0.5));
		
		
	
		
		
		
	}

}
