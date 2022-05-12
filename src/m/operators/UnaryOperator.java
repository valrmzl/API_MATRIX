package m.operators;
import m.matrices.Matrix;
import m.exceptions.*;

public abstract class UnaryOperator extends Matrix {
	public UnaryOperator() {
		super();
	}

	public abstract Matrix calc(Matrix m) throws NegativeNumberFoundException;

}
