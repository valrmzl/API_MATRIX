package m.vectors;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Linea {
	private Punto punto1;
	private Punto punto2;
	
	public Linea(){
		
	}

	public Linea(Punto punto1, Punto punto2){
		this.punto1 = punto1;
		this.punto2 = punto2;
		
	}
	

	public Linea(double x1, double y1, double x2, double y2,boolean texto){
		if(texto){
			this.punto1 = new Punto(x1, y1,true);
			this.punto2 = new Punto(x2, y2,true);
		}else{
			this.punto1 = new Punto(x1, y1,false);
			this.punto2 = new Punto(x2, y2,false);
		}
	}
	

	public Linea(double x1, double y1, double x2, double y2){
		
			this.punto1 = new Punto(x1, y1,false);
			this.punto2 = new Punto(x2, y2,false);
	}
	

	public void dibujar(Graphics2D g, Color c){
		g.setColor(c);
		g.setFont(new Font( "SansSerif", Font.PLAIN, 10 ));
		g.drawString(punto1.toString(), (int)punto1.get_x()+2,(int) punto1.get_y() -2);
		g.drawString(punto2.toString(), (int)punto2.get_x()+2,(int) punto2.get_y() -2);
		g.setColor(c);
		Line2D linea = new Line2D.Double(punto1.get_x(),punto1.get_y(),punto2.get_x(),punto2.get_y());
		g.draw(linea);
	}

}
