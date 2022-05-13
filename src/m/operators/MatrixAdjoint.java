package m.operators;
import m.exceptions.NegativeNumberFoundException;
import m.matrices.Matrix;

/**
 * MatrixAdjoint extiende a la clase abstracta UnaryOperator
 * (Una matriz adjunta es el resultado de cambiar el signo
 * del determinante de cada uno de los menores de la matriz 
 * original en función de la posiicón del menor dentrp de la matriz)
 * @author Cinthya G, Iker J, Valeria R
 *
 */
public class MatrixAdjoint extends UnaryOperator {
	
	public MatrixAdjoint() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Matrix calc(Matrix m) throws NegativeNumberFoundException {
		
		Matrix adj = getDeterminantOfMinors(m);
        int i = 1;
        for (int row = 0; row < m.getRow(); row++) {
            for(int col = 0; col < m.getColumn(); col++) {
            	double buffer=adj.getValue(row, col);
            	buffer*=i;
            	//System.out.println(buffer);
                adj.setValue(row,col,buffer);
                i *= -1;
            }
        }

        return getTranspose(adj);
	}
	
	private  Matrix arrayOfRange(Matrix mat, int n, int m) throws NegativeNumberFoundException {

        Matrix matrix = new Matrix(mat.getRow()-1,mat.getColumn()-1);
        int row_sub = 0;

        for (int row = 0; row < mat.getRow(); row++) {

            int col_sub = 0;
            if (row != n) {

                for (int col = 0; col < mat.getColumn(); col++) {

                    if (col != m) {
                        matrix.setValue(row - row_sub, col - col_sub, mat.getValue(row, col));
                    } else {
                        col_sub = 1;
                    }

                }

            } else {
                row_sub = 1;
            }

        }
        
        return matrix;
    }
	
	private  double getDeterminant(Matrix mat) throws NegativeNumberFoundException {

		
        	if (mat.getRow() == 2) {
            return ((mat.getValue(0, 0) * mat.getValue(1, 1)) - (mat.getValue(0, 1) * mat.getValue(1, 0))); 
        } else {

            int total = 0;

            for (int n = 0; n < mat.getRow(); n++) {
                
                // Get the array excluding the first row and current column (n)
                Matrix matrix = arrayOfRange(mat, 0, n);
                if (n % 2 == 0) {
                    total += mat.getValue(0, n) * getDeterminant(matrix);
                } else {
                    total -= mat.getValue(0, n) * getDeterminant(matrix);
                }
                
            }
            
            return total;
        }
    }
	
	private  Matrix getTranspose(Matrix mat) throws NegativeNumberFoundException {
        // Transposing a matrix simply means to make the columns of the original matrix the rows in the transposed matrix.
        // A 2x3, when transposed, turns into a 3x2. A 1x5, when transposed, turns into a 5x1.
        Matrix solve = new Matrix(mat.getColumn(),mat.getRow());

        for (int row = 0; row < mat.getRow(); row++) {
            for (int col = 0; col < mat.getColumn(); col++) {
                solve.setValue(col, row,mat.getValue(row, col));

            }

        }
        

        return solve;
    }
	
	private  Matrix getDeterminantOfMinors(Matrix ma) throws NegativeNumberFoundException {
        // Matrix of Minors. Read more here https://en.wikipedia.org/wiki/Minor_(linear_algebra)
        Matrix mat = new Matrix();
		mat = getTranspose(ma);
        Matrix matrix;
        Matrix solve = new Matrix(mat.getRow(),mat.getColumn());

        for (int n = 0; n < ma.getRow(); n++) {
            for (int m = 0; m < ma.getColumn(); m++) {
                matrix = arrayOfRange(ma, n, m);
                solve.setValue(n, m, getDeterminant(matrix));
            }            
        }

        return solve;
    }

}
