package coinpurse;

/**
 * Each BankNote has a different serial number.
 * @author narissingngam
 *
 */

public class BankNote implements Valuable {

	private double value;
	private String currency;
	private long nextSerialNumber = 1000000;
	private long serialNumber; 
	
	/**
	 * Initialize a value and currency
	 * @param value 
	 * @param currency
	 */
	public BankNote( double value ,String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
	}

	/**
	 * get value in BankNote
	 * @return value
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * get currency in BankNote
	 * @return currency
	 */
	@Override
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * get serialNumber in BankNote
	 * @return serialNumber
	 */
	public long getSerial(){
		return serialNumber;
	}
	/**
	 * check the value and currency 
	 * @param obj 
	 * @return true if it equal
	 */
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj.getClass() != this.getClass()){
			return false;
		}
		BankNote other = (BankNote) obj;
		if(other.getValue() != this.getValue()){
			return false;
		}
		if(!other.getCurrency().equals(this.getCurrency())){
			return false;
		}
		return true;
		
	}
	
	@Override
	public String toString(){
		return String.format("%.0f - %s note [%d]" , value,currency,serialNumber);
				
	}
	

}
