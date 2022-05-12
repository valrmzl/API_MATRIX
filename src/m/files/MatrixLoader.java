package m.files;

public class MatrixLoader {
	private static String fullPath;
	private String file;
	private String directory = "savedfiles\\";

	
	public void setFile(String file) {
		this.file = file;
	}
	
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	public String getFile() {
		return this.file;
	}
	
	public String getDirectory() {
		return this.directory;
	}
	
	public String getFullPath() {
		fullPath = null;
		fullPath = this.directory + this.file;
		return fullPath;
	}

}
