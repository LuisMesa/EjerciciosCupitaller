package uniandes.cupi2.cupiDamas.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.cupiDamas.mundo.Casilla;
import uniandes.cupi2.cupiDamas.mundo.CupiDamas;



public class Interfaz extends JFrame
{
	private CupiDamas mundo;
	private PanelImagen pImagen;
	private PanelOpciones pOpciones;
	private PanelTablero pTablero;
	private JPanel aux1;
	private JPanel aux2;
	
	public Interfaz()
	{
		setSize(800,600);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("CupiDamas");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mundo = null;
		
		pImagen = new PanelImagen();
		add(pImagen, BorderLayout.NORTH);
		
		pTablero = new PanelTablero(this);
		add(pTablero, BorderLayout.CENTER);
		
		JLabel lblim= new JLabel();
		ImageIcon i= new ImageIcon("./data/imagenes/izquierda.png");
		lblim.setIcon(i);
		aux1 = new JPanel();
		aux1.setLayout(new GridLayout(1,1));
		aux2 = new JPanel();
		aux1.setLayout(new GridLayout(1,1));
		aux1.add(lblim);
		JLabel lblimi= new JLabel();
		ImageIcon i2= new ImageIcon("./data/imagenes/derecha.png");
		lblimi.setIcon(i2);
		aux2.add(lblimi);
		aux1.setPreferredSize(new Dimension(200,500));
		aux2.setPreferredSize(new Dimension(200,500));
		aux1.setBackground(Color.white);
		aux2.setBackground(Color.white);
		add(aux1, BorderLayout.WEST);
		add(aux2,BorderLayout.EAST);
		
		pOpciones = new PanelOpciones(this);
		add(pOpciones, BorderLayout.SOUTH);
	}

	public void cargar()
	{
		  JFileChooser fc = new JFileChooser("./data");
		  fc.setDialogTitle("Seleccion ");
		  
		  File archivoDamas = null;
		  int resultado =fc.showOpenDialog(this);
		  if(resultado==JFileChooser.APPROVE_OPTION)
		  {
			 try
			 {
				 archivoDamas = fc.getSelectedFile();
				 mundo = new CupiDamas(archivoDamas);
				 actualizarTablero();
				 
				 validate();
			 }
			 catch (Exception e)
			 {
				 JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				 e.printStackTrace();
			 }
		  }
	}
	
	public void actualizarTablero()
	{
		pTablero.actualizarTabla(mundo.darTamanio());
		aux1.setPreferredSize(new Dimension((800-(mundo.darTamanio()*50))/2,0));
		aux2.setPreferredSize(new Dimension((800-(mundo.darTamanio()*50))/2,0));
		setSize(800,200+mundo.darTamanio()*50);
		setLocationRelativeTo(null);
	}
	public Casilla darCasilla(int f,int c)
	{
		return mundo.darCasillaPosicion(f, c);
	}
	public void valida1(int f,int c) throws Exception
	{
		Casilla a = mundo.darCasillaPosicion(f, c);
		if(a.darColor()==1||a.darColor()==2)
			{
			JOptionPane.showMessageDialog(this, "Error casilla vacia");
			throw new Exception("Error");
			}
		
	}
	public void mover(int f,int c,int cv, int fv)
	{
		int colorV =mundo.darCasillaPosicion(fv,cv ).darColor();
		boolean valido = mundo.moverValido(c, f, cv, fv, colorV);
		int color = 1;
		System.out.println(valido);
		if(valido)
		{
			color =mundo.mover(c, f, cv, fv);
			pTablero.actualizarCasilla(c, f, color, cv, fv);
		}
			
		System.out.println(mundo.darCasillaPosicion(fv,cv ).darColor());
		System.out.println(mundo.darCasillaPosicion(f,c ).darColor());
		
		
		
		//esto va al final del metodo comer
				String a=mundo.termino();
				if(!a.equals("b"))
				{
					mostrarError(a);
				}
	}
	public void mostrarError(String b)
	{
		//omite esto tu ya lo tienes
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
