package uniandes.cupi2.cupiPortafolio.interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelIzquierda extends JPanel
{

	private ImageIcon imagen;
	private JLabel lblImagen;
	private String ruta; 
	
	public PanelIzquierda(Interfaz interfaz)
	{
		setLayout(new GridLayout(1,1));
		setPreferredSize(new Dimension(300,0));
		ruta = interfaz.darRutaImagen();
		
		imagen = new ImageIcon(ruta);
		lblImagen=new JLabel();
		lblImagen.setIcon(imagen);
		add(lblImagen);
	}
	public void cambiarImagen(String pRuta)
	{
		ImageIcon nImagen = new ImageIcon(pRuta);
		lblImagen.setIcon(nImagen);
	}
}
