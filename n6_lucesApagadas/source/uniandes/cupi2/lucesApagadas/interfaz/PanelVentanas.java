package uniandes.cupi2.lucesApagadas.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.cupi2.lucesApagadas.mundo.Ventana;

public class PanelVentanas extends JPanel implements ActionListener 
{
	private Interfaz principal;
	private int pF,pC;
	
	private JButton btnVentanas[][];

	public PanelVentanas(Interfaz pP)
	{
		principal=pP;
		pF=pC=-1;
		
		setPreferredSize(new Dimension(800,700-185-50));
		GridLayout layout = new GridLayout(7,7);
		layout.setVgap( 1 );
		layout.setHgap( 1 );
		setLayout(layout);
		
	}
	public void actualizar(Ventana[][] ventanas)
	{
		removeAll();
		btnVentanas = new JButton[7][7];
		for (int i = 0; i < btnVentanas.length; i++) 
		{
			
			for (int j = 0; j < btnVentanas[0].length; j++) 
			{
				btnVentanas[i][j] = new JButton();
				String ruta = (ventanas[i][j]).estaEncendida()?"./data/imagenes/ventana_encendida2.png":"./data/imagenes/ventana_apagada.png";
				btnVentanas[i][j].setIcon(new ImageIcon(ruta));
				btnVentanas[i][j].setActionCommand(i+","+j);
				btnVentanas[i][j].addActionListener(this);
				btnVentanas[i][j].setBackground(new Color(46,32,210));
				
				add(btnVentanas[i][j]);
			}
		}
		if(pF!=-1)
		{
			String ruta = (ventanas[pF][pC]).estaEncendida()?"./data/imagenes/ventana_encendida_fantasma.png":"./data/imagenes/ventana_apagada_fantasma.png";
			btnVentanas[pF][pC].setIcon(new ImageIcon(ruta));
		}
		
	}
	public void reiniciar()
	{
		pC=pF=-1;
	}
	public void actionPerformed(ActionEvent evento)
	{
		String comando = evento.getActionCommand();
		pF = Integer.parseInt(comando.split(",")[0]);
		pC = Integer.parseInt(comando.split(",")[1]);
		principal.activarVentana(pF, pC);
	}
}
