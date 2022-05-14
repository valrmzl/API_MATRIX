package m.files;

import m.matrices.*;
import java.io.*;

/**
 * Carga un archivo .json al convertir su contenido de JSONObject en un arreglo de tipo String eventualmente convertido a valores de números reales.
 * @author Cinthya G, Iker J, Valeria R
 *
 */
public class JSonLoader extends MatrixLoader {
	
	/**
	 * Implementación abstracta de toLoad para tipo .JSON
	 */
	public void toLoad(String file, Matrix m) {
		setFile(file);
		BufferedReader reader = null;
		String line = null;
		
		int r = m.getRow();
		int c = m.getColumn();
		int v = 0;
		
		try {
			reader = new BufferedReader(new FileReader(getFullPath()));
			line = reader.readLine();
			
			String newLine = line.replace("{","").replace("}","").replace("[", "").replace("]", "").replace("\"matrix\":", "");
			String[] newLineArr = newLine.split(",");
			int arrSize = newLineArr.length;
			
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					double dblValue = Double.parseDouble(newLineArr[v]);
					m.setValue(i, j, dblValue);
					v++;
				}
				
			}
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
