package m.operators;
import m.exceptions.*;
import m.matrices.*;

/**
 * MatrixMultiplication extiende a la clase abstracta BinaryOperation
 * (Se calcula la multiplicación de ambas matrices si sus dimensiones son compatibles. 
 * El número de columnas de en la Matriz1 es igual al número de filas de Matriz2
 * sumando los elementos que ocupan la misma posición) 
 * @author Cinthya G, Iker J, Valeria R
 *
 */
public class MatrixMultiplication extends BinaryOperator {
public MatrixMultiplication() {
		
	}

	@Override
	public Matrix calc(Matrix m1, Matrix m2) throws NegativeNumberFoundException, IllegalMatrixCalcException {
		
		if(m1.getColumn()!=m2.getRow())
			throw new IllegalMatrixCalcException();
		
		Matrix result = new Matrix(m1.getRow(),m2.getColumn());
		
		for(int i=0; i<m1.getRow();i++) {
			for(int j=0;j<m2.getColumn(); j++) {
				for(int l=0; l<m1.getColumn();l++) {
					result.setValue(i, j, result.getValue(i, j)+(m1.getValue(i, l)*m2.getValue(l, j)));
					
				}
			}
			
		}
		
		
		return result;
	}

}
