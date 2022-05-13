package m.exceptions;

/**
 * La clase NegativeNumberFoundException extiende a Exception de java.lang
 * Esta excepción indica que un número negativo no puede ser 
 * recibido/ejecutado
 * Por ejemplo, esta excepción seria lanzada
 * si se crea una matriz con un valor de fila/columna negativo
 * son los suficinetes  para realizar una operación.
 * @author Cinthya G, Iker J, Valeria R
 *
 *
 */
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
