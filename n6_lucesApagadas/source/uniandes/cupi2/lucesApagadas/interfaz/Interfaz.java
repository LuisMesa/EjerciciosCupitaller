package uniandes.cupi2.lucesApagadas.interfaz;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import uniandes.cupi2.lucesApagadas.mundo.Mundo;

public class Interfaz extends JFrame
{
	public static final String RUTA = "data/imagenes/titulo.jpg";
	
	private String rutaA = "./data/cupiCastillo1.properties"; 
	private PanelBotones panelBotones;
	private PanelVentanas panelVentanas;
	
	private JLabel lblImagen;
	
	private Mundo mundo;
	
	public Interfaz() 
	{
		try
		{
			mundo = new Mundo(new File(rutaA));
		}
		catch (Exception e)
		{
			
			mostrarMensaje(e.getMessage());
		}
		setLayout(new BorderLayout());
		setSize(800,700);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("CupiVentanas o algo así");
		
		lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon(RUTA));
		add(lblImagen, BorderLayout.NORTH);
		
		panelVentanas = new PanelVentanas(this);
		add(panelVentanas, BorderLayout.CENTER);
		
		panelBotones = new PanelBotones(this);
		add(panelBotones, BorderLayout.SOUTH);
		
		actualizar();
		validate();
	}
	
	public void actualizar()
	{
		panelVentanas.actualizar(mundo.darVentanas());
		validate();
	}
	public void cargar()
	{
		JFileChooser exploradorArchivos = new JFileChooser("data");
		exploradorArchivos.setDialogTitle("a");
		File archivo = null;
		int resultado = exploradorArchivos.showOpenDialog(this);
		if  ( resultado == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				archivo = exploradorArchivos.getSelectedFile();
				mundo =new Mundo(archivo);
				panelVentanas.reiniciar();
				actualizar();
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}
	public void reiniciar()
	{
		mundo.reiniciar();
		panelVentanas.reiniciar();
		actualizar();
	}
	public void mostrarMensaje(String m)
	{
		JOptionPane.showMessageDialog(this, m);
	}
	
	public static void main(String[] args)
	{
		Interfaz a = new Interfaz();

	}
	public void activarVentana(int pF,int pC)
	{
		try
		{
			mundo.activarVentana(pF,pC);
			actualizar();
		}
		catch(Exception e)
		{
			mostrarMensaje(e.getMessage());
		}
	}
	public void op1()
	{
		mostrarMensaje(mundo.op1());
	}
	public void op2()
	{
		mostrarMensaje(mundo.op2());
	}
	public void estadisticas()
	{
		mostrarMensaje(mundo.estadisticas());
	}
	public void ponerFantasma(int pF, int pC)
	{
		
	}
}
