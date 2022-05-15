package m.tests;
import m.exceptions.InsufficientComponentsException;
import m.exceptions.NegativeNumberFoundException;
import m.files.*;
import m.matrices.*;
import m.vectors.*;
import m.operators.MatrixTranspose;
import m.operators.UnaryOperator;

public class TestMatrix {
	
	public static void main(String[] args) throws NegativeNumberFoundException, InsufficientComponentsException {
		
		/*
		// Test de Loader/Saver de CSV
				Matrix m1 = new Matrix(3);
				m1.setValue(0,0,5555.5);
				m1.setValue(2, 2, 1);
				System.out.println("m1: ");
				System.out.println(m1);
				

				MatrixSaver savercsv = new CSVSaver();
				m1.save(savercsv, "m1.csv");
				System.out.println("m1 se guardó en m1.csv");

				Matrix m2 = new Matrix(3);
				MatrixLoader loadercsv = new CSVLoader();
				m2.load(loadercsv, "m1.csv");
				System.out.println("m2 se cargó con m1");
				System.out.println(m2);
				
				System.out.println("\n---------------------------------------------");
				System.out.println("m3: ");
				Matrix m3 = new Matrix(4,5);
				m3.setValue(0,0,1);
				m3.setValue(3,4,3.666);
				System.out.println(m3);
				
				MatrixSaver savejson = new JSonSaver();
				m3.save(savejson, "m3.json");
				System.out.println("m3 se cargó a m3.json");
				
				System.out.println("Cargar m3.json a m4: ");
				Matrix m4 = new Matrix(4,5);
				MatrixLoader loaderjson = new JSonLoader();
				m4.load(loaderjson, "m3.json");
				System.out.println("m4: ");
				System.out.println(m4);
				
				m4.addRow();
				System.out.println("m4 + 1 fila:");
				System.out.println(m4);
				UnaryOperator transpose = new MatrixTranspose();
				Matrix m5 = transpose.calc(m4);
				System.out.println("m4 traspuesta");
				System.out.println(m5);
				*/
		/*
		Vector v3 = new Vector(6);
		v3.setComponent(0, -7);
		v3.setComponent(1, -8);
		v3.setComponent(2, -4);
		v3.setComponent(3, 10);
		v3.setComponent(4, 11.45);
		v3.setComponent(5, 45.2);
		System.out.println("v3: "+v3);
		System.out.println("v3, |A|: "+v3.magnitude());
		
		
		MatrixLoader loadv = new CSVLoader();
		Vector v4 = new Vector(7);
		//v4.load(loadv, "vector.csv");
		//System.out.println("v4 con vector.csv: "+v4);
		//v4.setComponent(0, 666);
		//System.out.println("Ahora i[0] de v4 es 666: "+v4);
		
		MatrixSaver savev = new CSVSaver();
		System.out.println("Guardando v4 en v4.csv:");
		v4.save(savev, "v4.csv");
		*/
		Vector va=new Vector(3);
		Vector vb=new Vector(3);
		va.setComponent(0, 1);
		va.setComponent(1, 2);
		va.setComponent(2, 3);
		System.out.println("**");
		vb.setComponent(0, 1);
		vb.setComponent(1, 5);
		vb.setComponent(2, 7);
		System.out.println(va);
		System.out.println(vb);
		System.out.println(va.cross(vb));
		
		
		
		
	}

}
