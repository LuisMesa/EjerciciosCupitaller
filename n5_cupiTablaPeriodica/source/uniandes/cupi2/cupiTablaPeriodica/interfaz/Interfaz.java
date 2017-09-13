package uniandes.cupi2.cupiTablaPeriodica.interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sun.security.krb5.internal.PAEncTSEnc;
import uniandes.cupi2.cupiTablaPeriodica.mundo.Elemento;
import uniandes.cupi2.cupiTablaPeriodica.mundo.TablaPeriodica;

public class Interfaz extends JFrame 
{
	private PanelImagen panelImagen;
	private PanelBotones panelBotones;
	private PanelElemento panelElemento;
	private PanelTabla panelTabla;
	
	
	private TablaPeriodica mundo;
	
	
	public Interfaz() throws Exception
	{
		setSize(852,700);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		setTitle("Tabla Periodica");
		
		mundo = new TablaPeriodica();
		
		
		
		panelImagen = new PanelImagen();
		add(panelImagen,BorderLayout.NORTH);
		
		panelBotones = new PanelBotones(this);
		add(panelBotones, BorderLayout.SOUTH);
		
		panelElemento=new PanelElemento();
		add(panelElemento,BorderLayout.WEST);
		
		panelTabla = new PanelTabla(this,mundo.darElementosPorPeriodo());
		add(panelTabla, BorderLayout.CENTER);
	}

	public void refrescarPanelElemento(String sElemento)
	{
		Elemento e =mundo.buscarElementoPorSimboloQuimico(sElemento);
		panelElemento.refrescarPanel(e.darMasa(),e.darSimboloQuimico(),e.darNumeroAtomico(),e.darEnergiaDeIonizacion(),e.darNombre());
	}
	public void buscarPorNombre()
	{
		String nombre =JOptionPane.showInputDialog(this,"Nombre del elemento");
		if(!nombre.equals("")&&nombre!=null)
		{
			Elemento a =mundo.buscarElementoPorNombre(nombre.trim());
			if(a!=null)
			{
				String simbolo = a.darSimboloQuimico();
				refrescarPanelElemento(simbolo);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "No existe el elemento con nombre "+nombre );
			}
			
		}
		
		
	}
	public void buscarPorSimbolo()
	{
		String nombre =JOptionPane.showInputDialog(this,"Simbolo del elemento");
		if(!nombre.equals("")&&nombre!=null)
		{
			Elemento a =mundo.buscarElementoPorSimboloQuimico(nombre.trim());
			if(a!=null)
			{
				String simbolo = a.darSimboloQuimico();
				refrescarPanelElemento(simbolo);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "No existe el elemento con el simbolo "+nombre );
			}
			
		}
		
	}
	public void buscarPorNumero()
	{
		try
		{
		int nombre =Integer.parseInt((JOptionPane.showInputDialog(panelBotones,"Número del elemento")));
		
			Elemento a =mundo.buscarElementoPorNumeroAtomico(nombre);
			if(a!=null)
			{
				String simbolo = a.darSimboloQuimico();
				refrescarPanelElemento(simbolo);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "No existe el elemento con el número "+nombre );
			}
			
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Error: "+e.getMessage() );
		}
		
	}
	/**
     * Método para la extensión 1.
     */
	public void reqFuncionOpcion1()
	{
		
		String resultado = mundo.metodo1();
		JOptionPane.showMessageDialog(this, resultado, "Respuesta",JOptionPane.INFORMATION_MESSAGE);
	}
	/**
     * Método para la extensión 2.
     */
	public void reqFuncionOpcion2()
	{
		String resultado = mundo.metodo2();
		JOptionPane.showMessageDialog(this,resultado,"Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			Interfaz a = new Interfaz();
			a.setVisible(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
