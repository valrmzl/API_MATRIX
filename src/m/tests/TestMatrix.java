package m.tests;
import m.exceptions.NegativeNumberFoundException;
import m.files.*;
import m.matrices.*;
import m.operators.MatrixTranspose;
import m.operators.UnaryOperator;

public class TestMatrix {
	
	public static void main(String[] args) throws NegativeNumberFoundException {
		
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
				
		
	}

}
