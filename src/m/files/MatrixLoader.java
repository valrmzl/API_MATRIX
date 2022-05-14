package m.files;

import m.matrices.Matrix;

/**
 * Establece una ruta predeterminada en donde se almacenarán los archivos
 * .csv y .json que se generen con su respectivo nombre (file); 
 *  se guardarán en la carpeta "savedfiles" dentro del proyecto.
 * @author Cinthya G, Iker J, Valeria R
 *
 */

public abstract class MatrixLoader {

	private static String fullPath;
	private String file;
	private String directory = "savedfiles\\";

	
	/**
	 * Especifica el nombre del archivo a leer.
	 * @param file Nombre del archivo (tiene que terminar en .csv o .json).
	 */
	public void setFile(String file) {
		this.file = file;
	}
	
	/**
	 * Especifica el directorio de recuperación de archivos en caso de cambiar el predeterminado.
	 * @param directory Ruta relativa de la carpeta de lectura.
	 */
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	
	/**
	 * Retorna el string con el nombre del archivo que se lee.
	 * @return El nombre del archivo  (.csv / .json
	 */
	public String getFile() {
		return this.file;
	}
	
	/**
	 * Retorna el string con el nombre de la ruta relativa de lectura.
	 * @return Ruta relativa de la ruta leida
	 */
	public String getDirectory() {
		return this.directory;
	}
	
	/**
	 * Retorna el string con la totalidad de la ruta relativa de lectura (directorio + nombre archivo).
	 * @return Ruta relativa y archivo del archivo leido
	 */
	public String getFullPath() {
		fullPath = null;
		fullPath = this.directory + this.file;
		return fullPath;
	}
	
	/**
	 * Método heredado por las subclases que cargan un archivo dependiendo de su formato.
	 * @param file Nombre del archivo (tiene que terminar en .csv o .json).
	 * @param m Matriz en la cual se cargará (objeto Matrix).
	 */
	public abstract void toLoad(String file, Matrix m);
	
}