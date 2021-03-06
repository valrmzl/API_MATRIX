package m.files;
import java.io.*;
import m.matrices.*;
import m.vectors.*;


/**
 * Guarda un archivo .csv separando los valores por comas.
 * @author Cinthya G, Iker J, Valeria R
 *
 */
public class CSVSaver extends MatrixSaver {
	
private String[][] doubleToStr;
	

/**
 * Implementación abstracta de toSave para tipo .CSV
 */
	public void toSave(String file, Matrix m) {
		
		setFile(file);
		BufferedWriter writer = null;
		//doubleToStr = new String[m.getRow()][m.getColumn()];
		
		
		try {
			writer = new BufferedWriter(new FileWriter(getFullPath()));
			
			
			for(int i = 0; i < m.getRow(); i++) {
				for(int j = 0; j < m.getColumn(); j++) {
					double vDbl = m.getValue(i, j);
					String vStr = String.valueOf(vDbl);
					writer.write(vStr+",");
				}
				writer.write("\n");
			}
			
			writer.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void toSave(String file, Vector v) {
		setFile(file);
		try {
		
			BufferedWriter writer = new BufferedWriter(new FileWriter(getFullPath()));
			for(int i = 0; i < v.getN(); i++) {
				String vStr = String.valueOf(v.getComponent(i));
				writer.write(vStr+",");
			}
			writer.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
