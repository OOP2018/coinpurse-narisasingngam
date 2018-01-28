package coinpurse;

public class BankNote implements Valuable {
	
	private double value;
	private String currency;
	private long nextSerialNumber = 1000000;
	private long serialNumber; 
	
	public BankNote( double value ,String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public String getCurrency() {
		return currency;
	}
	public long getserialNumber(){
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
	
	public String toStirng(){
		return value+ "-" + currency +"note [ " + serialNumber + " ]";
	}
	

}
