package uniandes.cupi2.cupiTablaPeriodica.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiTablaPeriodica.mundo.Elemento;

public class PanelTabla extends JPanel implements ActionListener
{

	public static final String RUTA="./data/imagenes/Convension.png";
	
	private JLabel lblImagen;
	
	private Interfaz interfaz;
	
	public PanelTabla(Interfaz pInterfaz,ArrayList pVector)
	{
		interfaz=pInterfaz;
		setPreferredSize(new Dimension(545,500));
		TitledBorder borde= BorderFactory.createTitledBorder("Tabla Periodica");
		setBorder(borde);
		
		setLayout(new BorderLayout());
		
		
		
		lblImagen = new JLabel();
		ImageIcon icono = new ImageIcon(RUTA);
		lblImagen.setIcon(icono);
		lblImagen.setPreferredSize(new Dimension(545,86));
		JPanel a= new JPanel();
		a.setLayout(new BorderLayout());
		a.add(new JLabel("                                  "),BorderLayout.WEST);
		a.add(lblImagen, BorderLayout.CENTER);
		add(a,BorderLayout.NORTH);
		
		JPanel tabla = new JPanel();
		tabla.setPreferredSize(new Dimension(545,545-86));
		
		GridLayout layout = new GridLayout(7,8);
		layout.setVgap( 1 );
		layout.setHgap( 1 );
		tabla.setLayout( layout );
		
		ArrayList vector = pVector;
		
		for(int i =0;i<vector.size();i++)
		{
			Elemento elemento = (Elemento)vector.get(i);
			if(elemento!=null)
			{
				JButton boton = new JButton(elemento.darSimboloQuimico());
				boton.addActionListener(this);
				boton.setActionCommand(elemento.darSimboloQuimico());
				
				if(elemento.esMetal())
					boton.setBackground(new Color(255,99,71));
				else
					boton.setBackground(new Color(144,238,144));
				
				Border b= BorderFactory.createLineBorder(Color.WHITE);
				boton.setBorder(b);
				boton.setBorderPainted(true);
				tabla.add(boton);
				
			}
			else
				tabla.add(new JLabel());
				
			
		}
		add(tabla,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent pEvent)
	{
		String comando = pEvent.getActionCommand();
		
		interfaz.refrescarPanelElemento(comando);
		//System.out.println(comando);
	}

	
	
}