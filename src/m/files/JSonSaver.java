package m.files;

import m.matrices.*;
import org.json.*;
import java.io.*;

/**
 * Guarda un archivo .json que encapsula un JSONArray bidimensional dentro
 * de un JSONObject con ayuda de la librería externa org.json.
 * @author Cinthya G, Iker J, Valeria R
 *
 */

public class JSonSaver extends MatrixSaver {

	private JSONArray j2D;
	private JSONObject jObj;
	
	/**
	 * Implementación abstracta de toSave para tipo .JSON
	 */
	public void toSave(String file, Matrix m) {
		setFile(file);
		BufferedWriter writer = null;
		
		jObj = new JSONObject();
		j2D = new JSONArray();
	
		try {
			for(int i = 0; i < m.getRow(); i++) {
				JSONArray jArr = new JSONArray();
				for(int j = 0; j < m.getColumn(); j++) {
					double mValue = m.getValue(i, j);
					jArr.put(mValue);
				}
				
				j2D.put(jArr);
			}
			
			jObj.put("matrix", j2D);
			
			writer = new BufferedWriter(new FileWriter(getFullPath()));
			writer.write(jObj.toString());
			
			writer.close();
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
