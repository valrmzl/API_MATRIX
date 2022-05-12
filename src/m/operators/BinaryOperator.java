package m.operators;
import m.exceptions.*;
import m.matrices.*;

public abstract class BinaryOperator extends Matrix {
	
public BinaryOperator() {
		
	}
	
	public abstract Matrix calc(Matrix m1, Matrix m2) throws NegativeNumberFoundException, IllegalMatrixCalcException;

}
