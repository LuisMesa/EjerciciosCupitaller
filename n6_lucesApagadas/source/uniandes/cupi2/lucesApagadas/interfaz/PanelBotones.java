package uniandes.cupi2.lucesApagadas.interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel implements ActionListener 
{
	
	
	private Interfaz principal;
	
	
	private JButton cargar,reiniciar,estadisticas,op1,op2;
	
	public PanelBotones(Interfaz pP)
	{
		principal = pP;
		
		setPreferredSize(new Dimension(800,50));
		setLayout(new GridLayout(1,5));
		
		setBorder(BorderFactory.createTitledBorder("Opciones"));
		
		cargar= new JButton("Cargar");
		cargar.setActionCommand("Cargar");
		cargar.addActionListener(this);
		add(cargar);
		
		reiniciar= new JButton("Reiniciar");
		reiniciar.setActionCommand("reiniciar");
		reiniciar.addActionListener(this);
		add(reiniciar);
		
		estadisticas= new JButton("Estadisticas");
		estadisticas.setActionCommand("estadisticas");
		estadisticas.addActionListener(this);
		add(estadisticas);
		
		op1= new JButton("Opción 1");
		op1.setActionCommand("op1");
		op1.addActionListener(this);
		add(op1);
		
		op2= new JButton("Opción 2");
		op2.setActionCommand("op2");
		op2.addActionListener(this);
		add(op2);
		
	}

	public void actionPerformed(ActionEvent evento)
	{
		String comando = evento.getActionCommand(); 

		if(comando.equals(cargar.getActionCommand()))
		{
			principal.cargar();
		}
		if(comando.equals(reiniciar.getActionCommand()))
		{
			principal.reiniciar();
		}
		if(comando.equals(estadisticas.getActionCommand()))
		{
			principal.estadisticas();
		}
		if(comando.equals(op1.getActionCommand()))
		{
			principal.op1();
		}
		if(comando.equals(op2.getActionCommand()))
		{
			principal.op2();
		}
		
		//validate();
	}
}

