package m.vectors;



import m.exceptions.*;
//import m.matrices.*;
import m.files.*;
public class Vector {
	
	
	/*
	 * magnitud, direccion (angulo) y sentido (pos, neg)
	 * magnitud: sqrt(x^2+y^2+z^2+...n^2)
	 * direccion (a. directores): alfa (vector con x), beta (vector con y), 
	 * gama (vector con z)
	 * 	-> cos(alpha) = x/magnitud
	 *  -> cos(beta) = y/magnitud
	 *  -> cos(gama) = z/magnitud 
	 *  (sacar arcs) y v. unitario = (cos(a), cos(b), cos(y))
	 *  
	 *  sentido: 
	 *  
	 */
	private int n = 2;	
	private double[] arrayV;
	private static Vector[] arrayOfVectors;
	
	/**
	 * Crea un vector de n elementos
	 * @param n (Número de elementos en el vector)
	 * @throws NegativeNumberFoundException  (Si la dimensión del vector no es positiva)
	 * @throws InsufficientComponentsException (Si la dimensiín sigue siendo insuficiente)
	 */
	public Vector(int n) throws NegativeNumberFoundException, InsufficientComponentsException {
		if(n < 0) 
			throw new NegativeNumberFoundException(n);
		if(n < 2)
			throw new InsufficientComponentsException(n);
		else {
			arrayV = new double[n];
			this.n = n;
			addZeros();
		}
		
	}
	
	/**
	 * Regresa la cantidad de elementos en un Vector
	 * @return  (n, tamaño del vector)
	 */
	public int getN() {
		return this.n;
	}
	
	/**
	 * Asignación de los valores reales del vector a partir de la posición brindada
	 * @param n 
	 * @param value
	 */
	public void setComponent(int n, double value) {
		arrayV[n] = value;
		
	}
	
	/**
	 * Regresa el componente de un Vector a partir de una posición brindada
	 * @param n
	 * @return
	 */
	public double getComponent(int n) {
		return arrayV[n];
	}
	
	/**
	 * Asignación de ceros (0) 
	 * a cada uno de los elementos del vector
	 */
	public void addZeros() {
		for(int i = 0; i < this.n; i++) {
			setComponent(i, 0);
		}
	}
	
	/**
	 * Permite calcular la magnitud de un Vector (
	 * Distancia entre el punto inicial y punto final)
	 * @return Magnitud
	 */
	public double magnitude() {
		double m = 0;
		for(int i = 0; i < this.n; i++)
			m += Math.pow(getComponent(i), 2);
		return Math.sqrt(m);
	}
	
	/**
	 * Regresa el Vector en su implementación original
	 * (Arreglo)
	 * @return arrayOfVectors
	 */
	public static Vector[] getArrayOfVectors() {
		return Vector.arrayOfVectors;
	}
	
	/**
	 * Formato de imprsión de un Vector
	 */
	@Override
	public String toString() {
		String vStr = "<";
		for(int i = 0; i < this.n; i++) {
			vStr += String.format(" %.2f", getComponent(i));
			if(i<n-1)
				vStr += ",";
			}
		vStr += " >";
		return vStr;
	}
	
	/**
	 * Permite crear un vector con los mismos
	 * atributos que el vector original (Clonación)
	 */
	@Override
	public Vector clone() {
		try {
			Vector copy = new Vector(this.n);
			for(int i = 0; i < this.n; i++)
				copy.setComponent(i, this.getComponent(i));	
			return copy;
		} catch (NegativeNumberFoundException | InsufficientComponentsException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Permite verificar si 2 Vectores son iguales 
	 * a partir de la compración de cada uno de sus atributos
	 *  *  @return <b>true</b> si se trata de 2 vectores igaules 
	 * <b>false</b> en otro caso
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Vector)) return false;
		else {
			Vector cmp = (Vector) o;
			boolean size = this.n == cmp.n;
			if(!size) return false;
			else {
				for(int i = 0; i < this.n; i++) {
					if(this.getComponent(i) != cmp.getComponent(i)) return false;
				}
			}
		} 
		return true;
	}
	
	/**
	 * Permite calcular el producto punto de 2 vectores
	 * @param vd Vector (segundo vector)
	 * @return Producto punto (pdot)
	 * @throws IllegalVectorOperationException (En caso de que los elementos en el Vector
	 * no sean los suficientes para realizar la operacipon)
	 */
	public double dot(Vector vd) throws IllegalVectorOperationException{
		if(this.getN() != vd.getN()) {
			throw new IllegalVectorOperationException();
		}
		double pdot = 0;
		for(int i = 0; i < getN(); i++ ) {
			pdot += (this.getComponent(i) * vd.getComponent(i));
		}
		return pdot;
	}
	
	
	/**
	 * Permite calcular el producto cruz de 2 vecstores siempre y cuando
	 * cumplan con la cantidad de elementos establecida
	 * @param vc Vector (segundo vector)
	 * @return Producto cruz (Nuevo Vector)
	 * @throws IllegalVectorOperationException (Si la cantidad de elementos en el vector es dieferente de 3  )
	 */
	public Vector cross(Vector vc) throws IllegalVectorOperationException{
		if(this.getN() != 3 && vc.getN() != 3) {
			throw new IllegalVectorOperationException();
		}
		Vector cross = this.clone();
		if(this.getN() == 3) {
			cross.setComponent(0, (this.getComponent(1)*vc.getComponent(2))-(this.getComponent(2)*vc.getComponent(1)));
			cross.setComponent(1, (this.getComponent(2)*vc.getComponent(0))-(this.getComponent(0)*vc.getComponent(2)));
			cross.setComponent(2, (this.getComponent(0)*vc.getComponent(1))-(this.getComponent(1)*vc.getComponent(0)));
		}
		return cross;
	}
	
	/**
	 * Permite calcular la suma de 2 vectores 
	 * @param vc Vector (Segundo vector)
	 * @return Suma de vectores (Nuevo Vector)
	 * @throws IllegalVectorOperationException (Si la cantidad de elementos en los vectores son distintas)
	 */
	public Vector sum(Vector vc) throws IllegalVectorOperationException{
		if(this.getN() != vc.getN()) {
			throw new IllegalVectorOperationException();
		}
		else {
			Vector sum = this.clone();
			for(int i =0; i < getN(); i++)
				sum.setComponent(i, this.getComponent(i)+vc.getComponent(i)); 
			return sum;
		}
	}
	
	
     /**
      * Permite calcular una resta entre 2 vectores
      * @param vc Vector (Segundo vector)
      * @return Resta de vectors (Nuevo Vector)
      * @throws IllegalVectorOperationException (Si la cantidad de elementos en los vectores son distintas)
      */
	public Vector substraction(Vector vc) throws IllegalVectorOperationException{
		if(this.getN() != vc.getN()) {
			throw new IllegalVectorOperationException();
		}
		else {
			Vector sub = this.clone();
			for(int i =0; i < getN(); i++)
				sub.setComponent(i, this.getComponent(i)-vc.getComponent(i)); 
			return sub;
		}
	}
	
	/**
	 * Permite cargar un Vector a partir de un formato .CSV
	 * @param loader (Tipo del archivo)
	 * @param file (Nombre del archivo)
	 */
	public void load(MatrixLoader loader, String file) {
		if(loader instanceof CSVLoader) {
			CSVLoader loadedCSV = new CSVLoader();
			loadedCSV.toLoad(file, this);
		}
	}
	
	/**
	 * Permite guardar un Vector en formato .CSV
	 * @param saver (Tipo del archivo)
	 * @param file (Nombre del archivo)
	 */
	public void save(MatrixSaver saver, String file) {
		if(saver instanceof CSVSaver) {
			CSVSaver savedCSV = new CSVSaver();
			savedCSV.toSave(file, this);
		}
	}
	
	/**
	 * Permite graficar la suma de 2 vectores
	 * @param v1 (Vector 1)
	 * @param v2 (Vector 2)
	 * @throws IllegalVectorOperationException (Si la cantidad de elementos en los vectores son distintas)
	 */
	public static void graphSum(Vector v1, Vector v2) throws IllegalVectorOperationException {
		if(!(v1.getN() == 2 && v2.getN() == 2)) 
			throw new IllegalVectorOperationException();
		else {
			arrayOfVectors = new Vector[3];
			arrayOfVectors[0] = v1;
			arrayOfVectors[1] = v2;
			arrayOfVectors[2] = v1.sum(v2);
			new Ventana();
		}
	}
	
	/**
	 * Permite graficar la resta de 2 vectores 
	 * @param v1 (Vector 1)
	 * @param v2 (Vector 2)
	 * @throws IllegalVectorOperationException (Si la cantidad de elementos en los vectores son distintas)
	 */
	public static void graphSubstraction(Vector v1, Vector v2) throws IllegalVectorOperationException {
		if(!(v1.getN() == 2 && v2.getN() == 2)) 
			throw new IllegalVectorOperationException();
		else {
			arrayOfVectors = new Vector[3];
			arrayOfVectors[0] = v1;
			arrayOfVectors[1] = v2;
			arrayOfVectors[2] = v1.substraction(v2);
			new Ventana();
		}
	}
	
	/**
	 * Permite sumar dos vecyores a partir de su representación gráfica
	 * @param v1 (Vector 1)
	 * @param v2 (Vector 2)
	 * @throws IllegalVectorOperationException (Si la cantidad de elementos en los vectores son distintas)
	 */
	public static void graphParallelogramRule(Vector v1, Vector v2) throws IllegalVectorOperationException {
		if(!(v1.getN() == 2 && v2.getN() == 2)) 
			throw new IllegalVectorOperationException();
		else {
			
			Vector s = v1.sum(v2);
			Vector v3 = v1.clone();
			v3.setComponent(0, s.getComponent(0));
			v3.setComponent(1, s.getComponent(1));
			
			arrayOfVectors = new Vector[4];
			arrayOfVectors[0] = v1;
			arrayOfVectors[1] = v2;
			arrayOfVectors[2] = v3;
			arrayOfVectors[3] = v1;
			new Ventana();
			
		}
	}
	
	/**
	 * Permite realizar una multplicación escalar a un vector
	 * @param v (Vector)
	 * @param c (Constante para escalar)
	 * @throws IllegalVectorOperationException (Si la cantidad de elementos en los vectores son distintas)
	 */
	public static void graphScalarMultiplication(Vector v, double c) throws IllegalVectorOperationException{
		System.out.println("s");
		if(v.getN() != 2) 
			throw new IllegalVectorOperationException();
		else {
			
			Vector scalar = v.clone();
			for(int i = 0; i < scalar.getN(); i++)
				scalar.setComponent(i, scalar.getComponent(i)*c);
			
			arrayOfVectors = new Vector[2];
			arrayOfVectors[0] = v;
			arrayOfVectors[1] = scalar;
			new Ventana();
		}
	
	
	}


}
