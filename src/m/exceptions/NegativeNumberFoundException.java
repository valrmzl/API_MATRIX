package m.exceptions;

public class NegativeNumberFoundException extends Exception {
	private double negativeNumber;
	public NegativeNumberFoundException(double negativeNumber) {
		super("NegativeNumberFoundException");  
		this.negativeNumber=negativeNumber;
		
	}
	
	
	public String toString() {
		return String.format("%s\nNegative number found: %f\n Matrix can't be created with a negative number. ",getMessage(), negativeNumber );
	}

}
