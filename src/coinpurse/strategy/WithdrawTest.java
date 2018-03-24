package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Money;
import coinpurse.Valuable;

public class WithdrawTest {
	
	private WithdrawStrategy strategy;
	private List<Valuable> value;
	private static final double TOL = 1.0E-6;
	
	@Before
	public void setUp(){
		strategy = new GreedyWithdraw();
		value = new ArrayList<>();
	}
	
	@Before
	public void init(){
		value.clear();
	}
	
	public Money makeMoney(double value){
		return new Money(value, "Baht");
	}

	@Test
	public void testWithdrawAll() {
		value.add(makeMoney(20));
		strategy.withdraw(makeMoney(20), value);
		assertTrue(value.isEmpty());
		
	}
	
	@Test
	public void testWithdraw(){
		value.add(makeMoney(5));
		value.add(makeMoney(10));
		strategy.withdraw(makeMoney(10), value);
		assertTrue(value.size() == 1);
	}
	
	
	@Test
	public void testOverWithdraw(){
		value.add(makeMoney(10));
		value.add(makeMoney(5));
		value.add(makeMoney(5));
		strategy.withdraw(makeMoney(30), value);
		assertTrue(value.size() == 3);
	}
	
	@Test
	public void testWithdrawAdvance(){
		value.add(makeMoney(5));
		value.add(makeMoney(2));
		value.add(makeMoney(2));
		value.add(makeMoney(2));
		strategy.withdraw(makeMoney(6), value);
		assertTrue(value.size()==1);
		
	}
	
	@Test
	public void testImpossibleWithdraw(){
		value.add(makeMoney(10));
		strategy.withdraw(makeMoney(30), value);
		assertTrue(value.size() == 1);
	}
	
	@Test
	public void testWithdrawStrategy(){
		value.add(makeMoney(5));
		value.add(makeMoney(2));
		value.add(makeMoney(10));
		strategy.withdraw(makeMoney(17), value);
		assertTrue(value.size() == 0);
	}
	

}
