package m.vectors;

public class Punto {
	
	private double x; //_x
	private double y; //_y
	private double v_x;
	private double v_y;
	private boolean texto;
	
	public Punto(){
		
	}
	
	public Punto(double x, double y, boolean texto) {
		super();
		this.v_x = x;
		this.v_y = y;
		this.x = ((double)Ventana.ALTO/2) + x;
		this.y = ((double) Ventana.ANCHO/2) + ((-1)* (y));
		this.texto = texto;
	}

	public double get_x() {
		return x;
	}
	public void set_x(double x) {
		this.x = x;
	}
	public double get_y() {
		return y;
	}
	public void set_y(double y) {
		this.y = y;
	}

}
