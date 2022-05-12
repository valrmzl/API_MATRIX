package m.files;
import java.io.*;
import m.matrices.*;

public class CSVSaver extends MatrixSaver {
	
private String[][] doubleToStr;
	
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

}
