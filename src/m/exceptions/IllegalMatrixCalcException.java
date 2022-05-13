package m.exceptions;
/**
 * La clase IllegalMatrixCalcException extiende a Exception de java.lang
 * Esta excepción indica que una operación no puede
 * ser calculada. Por ejemplo, esta excepción seria lanzada
 * si los indices de una matriz no
 * son los suficinetes  para realizar una operación.
 * @author Cinthya G, Iker J, Valeria R
 *
 */
public class IllegalMatrixCalcException extends Exception {
	public IllegalMatrixCalcException() {
		super("IllegalMatrixCalcException");  
	}
	
	@Override
	public String toString() {
		return String.format("%s\nMatrixCalc can't be performed, they have different sizes",getMessage());
	}

}
