package m.files;

import m.matrices.Matrix;

/**
 * Establece una ruta predeterminada en donde se almacenarán los archivos
 * .csv y .json que se generen con su respectivo nombre (file); 
 *  se guardarán en la carpeta "savedfiles" dentro del proyecto.
 * @author Cinthya G, Iker J, Valeria R
 *
 */

public abstract class MatrixSaver {

	private static String fullPath;
	private String file;
	private String directory = "savedfiles\\";

	
	
	/**
	 * Guarda el nombre del archvio a generar
	 * @param file Nombre del archivo (tiene que terminar en .csv o .json)
	 */
	public void setFile(String file) {
		this.file = file;
	}
	
	
	
	/**
	 * Guarda el directorio de guardaddo en caso de cambiar el predeterminado
	 * @param directory Ruta relativa de la carpeta de guardado
	 */
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	/**
	 * Retorna el string con el nombre del archivo guardado.
	 * @return El nombre del archivo  (.csv / .json)
	 */
	public String getFile() {
		return this.file;
	}
	
	/**
	 * Retorna el string con el nombre de la ruta relativa de guardado.
	 * @return Ruta relativa de la ruta de guardado
	 */
	public String getDirectory() {
		return this.directory;
	}
	
	/**
	 * Retorna el string con la totalidad de la ruta relativa de guardado (directorio + nombre archivo).
	 * @return Ruta relativa y archivo
	 */
	public String getFullPath() {
		fullPath = null;
		fullPath = this.directory + this.file;
		return fullPath;
	}
	
	
	/**
	 * Método heredado por las subclases que guardan dependiendo del formato del archivo.
	 * @param file Nombre del archivo (tiene que terminar en .csv o .json).
	 * @param m Matriz a guardar (objeto Matrix).
	 */
	public abstract void toSave(String file, Matrix m);
	
}