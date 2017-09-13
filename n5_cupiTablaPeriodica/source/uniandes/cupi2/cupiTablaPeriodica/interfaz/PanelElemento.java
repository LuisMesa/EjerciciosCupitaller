package uniandes.cupi2.cupiTablaPeriodica.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiTablaPeriodica.mundo.Elemento;

public class PanelElemento extends JPanel implements ItemListener
{

	private JLabel masa,simbolo,nAtomico,energia,nombre;
	private JCheckBox detalles;
	private JPanel panelAux;
	
	public PanelElemento()
	{
		setPreferredSize(new Dimension(300,500));
		TitledBorder borde= BorderFactory.createTitledBorder("Elemento");
		setBorder(borde);
		setLayout(new BorderLayout());
		
		JPanel PArriba= new JPanel();
		PArriba.setLayout(new GridLayout(1,1));
		PArriba.setPreferredSize(new Dimension(0,50));
		//PArriba.setBorder(borde);
		PArriba.add(new JLabel());
		add(PArriba,BorderLayout.NORTH);
		
		
		JPanel pElemento = new JPanel();
		pElemento.setPreferredSize(new Dimension(0,320));
		pElemento.setLayout(new BorderLayout());
		
		masa=new JLabel();
		masa.setForeground(new Color(124 ,252, 0));
		pElemento.add(masa,BorderLayout.NORTH);
		
		JPanel panelAux2=new JPanel();
		
		Font fuente = new Font("Times New Roman",Font.BOLD,100);
		simbolo = new JLabel();
		simbolo.setFont(fuente);
		panelAux2.setLayout(new BorderLayout());panelAux2.add(new JLabel("     "),BorderLayout.EAST);panelAux2.add(simbolo,BorderLayout.CENTER);panelAux2.add(new JLabel("                                 "),BorderLayout.WEST);
		pElemento.add(panelAux2,BorderLayout.CENTER);
		
		panelAux = new JPanel();
		panelAux.setLayout(new GridLayout(3,1));
		Font fuente2 = new Font("Times New Roman",Font.BOLD,30);
		nombre = new JLabel();
		nombre.setFont(fuente2);
		panelAux2=new JPanel();panelAux2.setLayout(new BorderLayout());panelAux2.add(new JLabel("        "),BorderLayout.EAST);panelAux2.add(nombre,BorderLayout.CENTER);panelAux2.add(new JLabel("                       "),BorderLayout.WEST);
		panelAux.add(panelAux2);
		nAtomico = new JLabel();
		nAtomico.setForeground(new Color(124 ,252, 0));
		panelAux.add(nAtomico);
		panelAux2=new JPanel();panelAux2.setLayout(new GridLayout(1,3));panelAux2.add(new JLabel());panelAux2.add(new JLabel());
		energia=new JLabel();
		energia.setForeground(new Color(124 ,252, 0));
		panelAux2.add(energia);
		panelAux.add(panelAux2);
		
		pElemento.add(panelAux,BorderLayout.SOUTH);
		
		add(pElemento,BorderLayout.CENTER);
		
		detalles= new JCheckBox("Ver detalles");
		detalles.setSelected(true);
		detalles.addItemListener(this);
		add(detalles,BorderLayout.SOUTH);
		
	}
	
	public void refrescarPanel(double pMasa,String pSimbolo,int pNAtomico,double pEnergia,String pNombre)
	{
		masa.setText(pMasa+"");
		simbolo.setText(pSimbolo);
		nAtomico.setText(pNAtomico+"");
		energia.setText(pEnergia+"");
		nombre.setText(pNombre);
		
	}

	public void itemStateChanged(ItemEvent pEvento) 
	{
		boolean seleccionado=pEvento.getStateChange()==ItemEvent.SELECTED;
		if(seleccionado==false)
		{
			masa.setVisible(false);
			panelAux.setVisible(false);
			
		}
		else
		{
			masa.setVisible(true);
			panelAux.setVisible(true);
		}
		
	}
}
