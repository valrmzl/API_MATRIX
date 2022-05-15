package m.matrices;
import m.files.*;
import m.exceptions.*;
import m.operators.*;


/**
 *  Esta clase describe el funcionamiento de matrices a trav�s de arreglos bidimensionales
 * @author Cinthya G, Iker J, Valeria R
 *
 */
public class Matrix {
	
public Matrix() {
		
	}
	
	private int row;
	private int column;
	private double[][] arrayM;
	private boolean isSquare;

	/**
	 * Crea una matriz  de 2 dimensiones (cuadrada) inicializada en ceros 
	 * @param row  (N�mero de filas en la matriz; tambi�n corresponde al de columnas)
	 * @throws NegativeNumberFoundException (Si la dimensi�n de la matriz no es positiva)
	 */
	public Matrix(int row) throws NegativeNumberFoundException  {
		if(row<0)
			throw new NegativeNumberFoundException(row);
		isSquare = true;
		this.arrayM = new double [row][row];
		this.row = row;
		this.column = row;
		
	}
	
	/**
	 * Crea una matriz de 2 dimensiones inicializada en ceros
	 * @param row (N�mero de filas en la matriz)
	 * @param column (N�mero de columnas en la matriz)
	 * @throws NegativeNumberFoundException (Si la dimensi�n de la matriz no es positiva)
	 */
	
	public Matrix(int row, int column) throws NegativeNumberFoundException {
		if(row<0)
			throw new NegativeNumberFoundException(row);
		if(column<0)
			throw new NegativeNumberFoundException(column);
		this.arrayM = new double [row][column];
		if(row == column) isSquare = true;
		this.row = row;
		this.column = column;
		addZeros();
		
	}
	
	/**
	 * Inserta un valor en la matriz a partir de la coordenada brindada
	 * @param row (Posici�n fila)
	 * @param column (Posici�n columna)
	 * @param value (Valor a insertar)
	 */


	public  void setValue(int row, int column,double value)   {
		this.arrayM[row][column]= value;
		
	}
	
	/**
	 * Regresa el valor solicitado de una matriz a partir de su coordenada
	 * @param row (Posici�n fila)
	 * @param column (Posici�n columna)
	 * @return Valor indicado a partir de la fila y columna
	 */

	
	public double getValue(int row, int column) {
		return arrayM[row][column];
	}

	/**
	 * Verifica si se trata de una Matriz Sim�trica (Deebe de ser una matriz cuadrada y es 
	 * id�ntica a la matriz despu�s de haber cambiado las filas por columnas)
	 * @return <b>true</b> si se trata de una matriz sim�trica 
	 * <b>false</b> en otro caso
	 */

	public boolean isSimmetric() {
		if(!isSquare)
			return false;
        else
	    	for (int i = 0; i < row; i++)
	            for (int j = 0; j < column; j++)
	                if(arrayM[i][j] != arrayM[j][i])
	                    return false;     
		return true;
	}
	
	/**
	 * Verifica si se trata de una Matriz Identidad (Debe de ser una matriz cuadrada, donde todos sus eleentos
	 * son ceros (0) menos los elementos de la diganolas principal que son unos (1))
	 * @return <b>true</b> si se trata de una matriz identidad 
	 * <b>false</b> en otro caso
	 */


	public boolean isIdentity() {
		 if(!isSquare)    
	            return false;  
	        else
	            for(int i = 0; i < row; i++)   
	                for(int j = 0; j < column; j++) {    
	                  if(i == j && arrayM[i][j] != 1)   
	                      return false;    
	                  if(i != j && arrayM[i][j] != 0)   
	                      return false;  
	                }
		 return true;         
	}
	
	/**
	 * Verifica si se trata de una Matriz Triangular Superior (Debe de ser
	 * una matriz cuadrada que tiene un tri�ngulo de ceros (0) por debaho de la diagonal principal)
	 * @return <b>true</b> si se trata de una matriz triangular superior 
	 * <b>false</b> en otro caso
	 */


	public boolean isTriangularSup() {
		if(!isSquare) 
            return false;
        else {  
	        for (int i = 0; i < row; i++) 
	            for (int j = 0; j < column; j++) 
	                if (i > j)  
	                	if(arrayM[i][j] != 0)
	                		return false;
        }
		return true;
	}
	
	/**
	 * Verifica si se trata de una Matriz Triangular Inferior (Debe de ser una matriz cuadrada
	 *  que tiene un tri�ngulo de ceros (0) por encima de la diagonal principal)
	 * @return <b>true</b> si se trata de una matriz triangular inferior 
	 * <b>false</b> en otro caso
	 */


	public boolean isTriangularInf() {
		if(!isSquare) 
            return false;
        else {  
	        for (int i = 0; i < row; i++) 
	            for (int j = 0; j < column; j++) 
	                if (i < j)  
	                	if(arrayM[i][j] != 0)
	                		return false;
        }
		return true;
	}
	
	/**
	 * Verifica si se trata de una Matriz Nula (Debe de ser una matriz donde todos sus elemenos 
	 * son igual a cero (0))
	 * @return <b>true</b> si se trata de una matriz nula 
	 * <b>false</b> en otro caso
	 */

	public boolean isNull() {
		
		for (int i = 0; i < row; i++) 
            for (int j = 0; j < column; j++) 
                	if(arrayM[i][j] != 0)
                		return false;
	return true;
	}
	
	/**
	 * Obtiene el n�mero de filas contenidas en la Matriz
	 * @return el n�mero de filas contenidas en la Matriz
	 */

	public int getRow() {

		return this.row;
	}
	
	/**
	 * Obtiene el n�mero de columnas contenidas en la matriz
	 * @return el n�mero de columnas contenidas en la matriz
	 */


	public int getColumn() {

		return this.column;
	}
	
	/**
	 *  Verifica si se trata de una Matriz Cuadrada
	 * @return <b>true</b> si se trata de una matriz cudrada 
	 * <b>false</b> en otro caso
	 */
	
	public boolean getIsSquare() {
		return this.isSquare;
	}
	
	/**
	 * Obtiene la matriz bidemensional correspondiente a la matriz
	 * @return matriz bidemensional
	 */
	public double[][] getArrayM(){
		return this.arrayM;
	}
	
	/**
	 * A�ade una nueva columna a la matriz
	 * @throws NegativeNumberFoundException (Si la dimensi�n de la matriz no es positiva)
	 */
	public void addColumn() throws NegativeNumberFoundException{
		Matrix temp = new Matrix(getRow(),getColumn()+1);
		for(int i =0;i<getRow();i++)
			for(int j=0;j<getColumn();j++) {
				temp.setValue(i, j, arrayM[i][j]);
			}
		this.arrayM=temp.arrayM;
        this.setColumn(getColumn()+1);
        if(getRow()!=getColumn())
            this.isSquare=false;
        else 
            this.isSquare=true;
	     

	}
	
	/**
	 * Establece el n�mero de columnas para una matriz
	 * @param column (cantidad de columnas)
	 */
	
	private void setColumn(int column) {
		this.column = column;
	}
	
	public void addRow() throws NegativeNumberFoundException {
		Matrix temp = new Matrix(getRow()+1,getColumn());
		for(int i =0;i<getRow();i++)
			for(int j=0;j<getColumn();j++) {
				temp.setValue(i, j, arrayM[i][j]);
			}
		
			this.arrayM=temp.arrayM;
			this.setRow(getRow()+1);
			if(getRow()!=getColumn())
				this.isSquare=false;
			else 
				this.isSquare=true;
	}
	
	/**
	 * Establece el n�mero de filas para una matriz
	 * @param row (cantidad de filas)
	 */
	private void setRow(int row) {
		this.row = row;
	}

	
	/**
	 * Elimina toda la columna de una matriz
	 * @throws NegativeNumberFoundException (Si se trata de eliminar una columna con un n�mero negativo)
	 */
	public void deleteColumn() throws NegativeNumberFoundException {
		Matrix temp = new Matrix(getRow(),getColumn()-1);
		for(int i =0;i<getRow();i++)
			for(int j=0;j<getColumn()-1;j++) {
                temp.setValue(i, j, arrayM[i][j]);
            }
		
		this.arrayM=temp.arrayM;
        this.setColumn(getColumn()-1);

        if(getRow()!=getColumn())
            this.isSquare=false;
        else
            this.isSquare=true;

	}
	
	/**
	 * Elimina toda la fila de una matriz 
	 * @throws NegativeNumberFoundException (Si se trata de eliminar una columna con un n�mero negativo)
	 */
	public void deleteRow() throws NegativeNumberFoundException {
			
		Matrix temp = new Matrix(getRow()-1,getColumn());
		for(int i =0;i<getRow()-1;i++)
			for(int j=0;j<getColumn();j++) {
				temp.setValue(i, j, arrayM[i][j]);
			}
		
			this.arrayM=temp.arrayM;
			this.setRow(getRow()-1);
			
			if(getRow()!=getColumn())
				this.isSquare=false;
			else
				this.isSquare=true;
	}
	
	/**
	 * Inserta el valor cero (0) en cada posici�n de la matriz 
	 */
	
	public void addZeros()  {
		for (int i = 0; i < getRow(); i++)
            for (int j = 0; j < getColumn(); j++) {
            	setValue(i, j, 0);
            }
	}

	
	/**
	 * Formato de impresi�n para una Matriz
	 */
	@Override
	public String toString() {
		String matrixStr = "";

		for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getColumn(); j++) 
            	matrixStr += String.format("%8.1f ",getValue(i, j));
            matrixStr += "\n";
		}
		return matrixStr;
	}
	
	/**
	 * Verifica las dimensiones de dos (2) matrices
	 * @param m (Matriz m2)
	 * @return <b>true</b> si ambas matrices son de las mismas dimensiones 
	 * <b>false</b> en otro caso
	 */
	 
	
	public  boolean equalsSize(Matrix m) {
		for(int i=0; i<this.arrayM.length;i++) {
			if(this.arrayM.length!= m.arrayM.length ||
				this.arrayM[i].length!= m.arrayM[i].length
					) return false;
		}
		return true;
	}
	
	
	/**
	 * Permite cargar una Matriz a partir de un formato .CSV
	 * @param loader (Tipo del archivo)
	 * @param file (Nombre del archivo)
	 */
	public void load(MatrixLoader loader, String file) {
		if(loader instanceof CSVLoader) {
			CSVLoader loadedCSV = new CSVLoader();
			loadedCSV.toLoad(file, this);
		}
		else if(loader instanceof JSonLoader) {
			JSonLoader loadedJSon = new JSonLoader();
			loadedJSon.toLoad(file, this);
		}
	}
	
	/***
	 * Permite guardar una Matriz en formato .CSV
	 * @param saver (Tipo del archivo)
	 * @param file (Nombre del archivo)
	 */
	public void save(MatrixSaver saver, String file) {
		if(saver instanceof CSVSaver) {
			CSVSaver savedCSV = new CSVSaver();
			savedCSV.toSave(file, this);
		}
		else if(saver instanceof JSonSaver) {
			JSonSaver savedJSon = new JSonSaver();
			savedJSon.toSave(file, this);
		}

	}

}
