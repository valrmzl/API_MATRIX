package m.tests;
import m.exceptions.NegativeNumberFoundException;
import m.files.*;
import m.matrices.*;

public class TestMatrix {
	
	public static void main(String[] args) throws NegativeNumberFoundException {
		
		// Test de Loader/Saver de CSV
		Matrix m1 = new Matrix(3,4);
		System.out.println(m1);

		MatrixLoader loader1 = new CSVLoader();
		m1.load(loader1, "data.csv");
		System.out.println("con csv:");
		System.out.println(m1);
		m1.setValue(0, 0, 78.8);
		m1.setValue(1, 2, 111.9);
		m1.setValue(2, 1, 5555);
		System.out.println(m1);
		System.out.println(m1.getRow());
		
		System.out.println();
		MatrixSaver saver1 = new CSVSaver();
		m1.save(saver1, "firstSaved.csv");
		
	}

}
