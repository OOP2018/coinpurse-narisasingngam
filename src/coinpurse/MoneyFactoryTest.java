package coinpurse;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Test MoneyFactory
 * @author Narisa Singngam
 *
 */
public class MoneyFactoryTest {
	
	@Test
	public void testSingleton(){
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory m = MoneyFactory.getInstance();
		MoneyFactory n = MoneyFactory.getInstance();
		assertTrue(m == n);
	}
	
	@Test
	public void testSet(){
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory m = MoneyFactory.getInstance(); 
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory n = MoneyFactory.getInstance();
		assertFalse(m == n);
	}
	
	@Test
	public void testThaiMoney(){
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory m = MoneyFactory.getInstance();
		Valuable n = m.createMoney(10);
		assertTrue(n.equals(new Coin(10,"Baht")));
		Valuable j = m.createMoney(50);
		assertTrue(j.equals(new BankNote(50,"Baht",1000000)));
	}
	
	@Test
	public void testMalayMoney(){
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory m = MoneyFactory.getInstance();
		Valuable n = m.createMoney(0.1);
		assertTrue(n.equals(new Coin(0.1, "Ringgit")));
		Valuable j = m.createMoney(10);
		assertTrue(j.equals(new BankNote(10, "Ringgit",1000000)));
		
	}
	
	
}

