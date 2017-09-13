package uniandes.cupi2.cupiTablaPeriodica.interfaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelImagen extends JPanel
{

	public static final String RUTA = "./data/imagenes/Encabezado.png";
	
	private JLabel imagen;
	public PanelImagen()
	{
		setLayout(new BorderLayout());
		
		imagen= new JLabel();
		ImageIcon icono= new ImageIcon(RUTA);
		imagen.setIcon(icono);
		add(imagen,BorderLayout.NORTH);
	}
}
