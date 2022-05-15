package m.exceptions;

/**
 * La clase InsufficientComponentsException extiende a la clase Exception.
 * Esta excepción puede aparecer cuando se necesita crear un Vcetor pero la cnatidad de 
 * elementos proporcionada no es la suficiente para ejecutarlo.
 * 
 
 * @author Cintya G, Iker J, Valeria R
 *
 */
public class InsufficientComponentsException extends Exception {
	
private int componentsNumber;
	
	public InsufficientComponentsException(int componentsNumber) {
		super("InsufficientComponentsException");
		this.componentsNumber = componentsNumber;
	}
	
	public String toString() {
		return String.format("%s\nNot enough components to create vector."
				+ "			\nVector can't be created with %d components.", getMessage(), componentsNumber);
	}

}
