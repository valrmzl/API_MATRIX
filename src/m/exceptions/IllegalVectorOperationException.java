package m.exceptions;

/**
 * La clase IllegalVectorOperationException extiende a la clase Exception.
 * Esta excepción puede aparecer cuando se solicita realizar una operación
 * entre vectores y sus dimensiones no son las mismas, por lo tanto, no se puede realizar.
 * @author Cinthya G, Iker J, Valeria R
 *
 */
public class IllegalVectorOperationException extends Exception {
	public IllegalVectorOperationException() {
		super("IllegalVectorOperationException");  
	}
	
	
	@Override
	public String toString() {
		return String.format("%s\nVectorial operation can't be performed, they have different sizes",getMessage());
	}

}
