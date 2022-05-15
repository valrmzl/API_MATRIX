package m.vectors;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	public static final int ANCHO = 800;
	public static final int ALTO = 800;
	private PanelDibujo pd;
	
	public Ventana(){
		this.configuracionVentana();
		PanelDibujo pd = new PanelDibujo();
		super.add(pd);
	}
	
	public void configuracionVentana(){
		super.setTitle("Plano cartesiano - Operaciones vectoriales");
		super.setBounds(200,20, Ventana.ANCHO, Ventana.ALTO);
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setResizable(false);
	}

}
