package uniandes.cupi2.cupiDamas.interfaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelImagen extends JPanel
{
	public PanelImagen()
	{
		setLayout(new BorderLayout());
		
		JLabel lblim= new JLabel();
		ImageIcon i= new ImageIcon("./data/imagenes/encabezado.png");
		lblim.setIcon(i);
		
		add(lblim,BorderLayout.CENTER);
	}

}
