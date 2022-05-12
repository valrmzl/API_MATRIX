package m.files;

import java.io.*;
import m.matrices.*;

public class CSVLoader extends MatrixLoader {
public void toLoad(String file, Matrix m) {
		
		int c = 0, r = 0;
		
		setFile(file);
		BufferedReader reader = null;
		String line = null;

		try {
			reader = new BufferedReader(new FileReader(getFullPath()));

			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				
				for(String index : row) {
					double dblValue = Double.parseDouble(index);
					m.setValue(r, c, dblValue);
				
					c++;
					if(c >= m.getColumn()) c = 0;
				}
				
				r++;
				if(r >= m.getRow()) r = 0;
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
