package m.vectors;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Plano {
	
	private double ancho;
	private double alto;
	
	public Plano(double ancho, double alto){
		this.ancho = ancho;
		this.alto = alto;
		
	}
	
	public void dibujar(Graphics2D g){
		
		// Lineas verticales
		for(int i = 0; i < alto; i++){
			Line2D  linea = new Line2D.Double(i,0,i,ancho);
			if(i % 10 == 0){
				g.setColor(new Color(204,204,204));
				g.draw(linea);
			}
		}
		
		// Lineas horizontales
		for(int i = 0; i < ancho; i++){
			Line2D  linea = new Line2D.Double(0,i,alto,i);
			if(i % 10 == 0){
				g.setColor(new Color(204,204,204));
				g.draw(linea);
			}
		}
		
		// Ejes
		g.setColor(Color.BLACK);
		Line2D linea_y = new Line2D.Double(alto/2,0,alto/2,ancho);
		Line2D  linea_x = new Line2D.Double(0,ancho/2,alto,ancho/2);
		g.draw(linea_x);
		g.draw(linea_y);
		
	}

}
