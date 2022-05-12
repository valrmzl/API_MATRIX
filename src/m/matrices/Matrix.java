package m.matrices;
import m.files.*;
import m.exceptions.*;
import m.operators.*;

public class Matrix {
	
public Matrix() {
		
	}
	
	private int row;
	private int column;
	private double[][] arrayM;
	private boolean isSquare;

	public Matrix(int row) throws NegativeNumberFoundException  {
		if(row<0)
			throw new NegativeNumberFoundException(row);
		isSquare = true;
		this.arrayM = new double [row][row];
		this.row = row;
		this.column = row;
		
	}
	
	
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


	public void setValue(int row, int column,double value)   {
		this.arrayM[row][column]= value;
		
	}

	
	public double getValue(int row, int column) {
		return arrayM[row][column];
	}


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

	public boolean isNull() {
		
		for (int i = 0; i < row; i++) 
            for (int j = 0; j < column; j++) 
                	if(arrayM[i][j] != 0)
                		return false;
	return true;
	}


	public int getRow() {

		return this.row;
	}


	public int getColumn() {

		return this.column;
	}
	
	public boolean getIsSquare() {
		return this.isSquare;
	}
	
	public double[][] getArrayM(){
		return this.arrayM;
	}
	
	public void addColumn() {

	}
	
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
	
	
	private void setRow(int row) {
		this.row = row;
	}

	public void deleteColumn() {
		
	}
	
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
	
	public void addZeros()  {
		for (int i = 0; i < getRow(); i++)
            for (int j = 0; j < getColumn(); j++) {
            	setValue(i, j, 0);
            }
	}

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
	
	public boolean equalsSize(Matrix m) {
		for(int i=0; i<this.arrayM.length;i++) {
			if(this.arrayM.length!= m.arrayM.length ||
				this.arrayM[i].length!= m.arrayM[i].length
					) return false;
		}
		return true;
	}
	
	public void load(MatrixLoader loader, String file) {
		if(loader instanceof CSVLoader) {
			CSVLoader loadedCSV = new CSVLoader();
			loadedCSV.toLoad(file, this);
			
		}
		else if(loader instanceof JSonLoader) {
			System.out.println("Es json");
		}
	}
	
	public void save(MatrixSaver saver, String file) {
		if(saver instanceof CSVSaver) {
			CSVSaver savedCSV = new CSVSaver();
			savedCSV.toSave(file, this);
		}

	}

}
