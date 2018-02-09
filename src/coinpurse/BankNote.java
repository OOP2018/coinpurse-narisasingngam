package coinpurse;

/**
 * Each BankNote has a different serial number.
 * @author Narisa singngam
 *
 */

public class BankNote extends Money  {

	private long nextSerialNumber = 1000000;
	private long serialNumber; 
	
	/**
	 * Initialize a value and currency
	 * @param value 
	 * @param currency
	 */
	public BankNote( double value ,String currency){
		super(value,currency);
		this.serialNumber = nextSerialNumber++;
	}

	
	/**
	 * get serialNumber in BankNote
	 * @return serialNumber
	 */
	public long getSerial(){
		return serialNumber;
	}
	
	@Override
	public String toString(){
		return String.format("%.0f - %s note [%d]" , this.getValue(),this.getCurrency(),serialNumber);
				
	}
	

}
