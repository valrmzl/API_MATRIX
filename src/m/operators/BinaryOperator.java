

package m.operators;
import m.exceptions.*;
import m.matrices.*;
/** Clase abstracta BinaryOperator, de la cual dependen todas aquellas
 * operaciones en la que se encuentran involcuradas 2 matrices
 * @author Cinthya G, Iker J, Valeria R
 * *
 */
public abstract class BinaryOperator extends Matrix {
	
	public BinaryOperator() {
			
		}
	
	/**
	 * Este método es invocado para crear un objeto cuando se desea ejecutar un cálculo entre 2 matrices
	 * (MatrixAdditon, MatrixSubstraction, MatrixMultiplication)
	 * @param m1 (Matrix 1)
	 * @param m2 (Matrix 2)
	 * @return  Una nueva matriz resultante
	 * @throws NegativeNumberFoundException  (La creación de una nueva matriz fue con un número negativo)
	 * @throws IllegalMatrixCalcException  (El cálculo entre operaciones no es posible debido a las características propias de 
	 * cada cálculo)
	 */


	public  abstract Matrix calc(Matrix m1, Matrix m2) throws NegativeNumberFoundException, IllegalMatrixCalcException;

}
