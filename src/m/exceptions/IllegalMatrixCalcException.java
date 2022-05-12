package m.exceptions;

public class IllegalMatrixCalcException extends Exception {
	public IllegalMatrixCalcException() {
		super("IllegalMatrixCalcException");  
	}
	
	
	public String toString() {
		return String.format("%s\nMatrixCalc can't be performed, they have different sizes",getMessage());
	}

}
