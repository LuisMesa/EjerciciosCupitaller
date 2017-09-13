package uniandes.cupi2.cupiDamas.interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.cupi2.cupiDamas.mundo.Casilla;

public class PanelTablero extends JPanel implements ActionListener 
{
	private int ancho=8;
	private int alto = 8;
	private ArrayList lista;
	private JButton[][] botones;
	private Interfaz interfaz;
	private ImageIcon n,b,r,am;
	private int accion=0;
	private int cvieja;
	private int fvieja;
	public PanelTablero(Interfaz pinterfaz)
	{
		interfaz = pinterfaz;
		
		setPreferredSize(new Dimension(50*ancho,50*alto));
		n= new ImageIcon("./data/imagenes/negro.png");
		b= new ImageIcon("./data/imagenes/blanco.png");
		r= new ImageIcon("./data/imagenes/rojo.png");
		am= new ImageIcon("./data/imagenes/fichaBlanco.png");
		
		
	}

	public void actualizarTabla(int tamanio )
	{
		removeAll( );
		ancho=tamanio;
		alto=tamanio;
		setPreferredSize(new Dimension(50*ancho,50*alto));
		setLayout(new GridLayout(ancho,alto));
		botones = new JButton[alto][ancho];
		for(int i =0;i<alto;i++)
		{
			for(int j = 0;j<ancho;j++)
			{
				
				botones[i][j] = new JButton();
				botones[i][j].addActionListener(this);
				botones[i][j].setActionCommand(i+"."+j);
				Casilla a =interfaz.darCasilla(i, j);
				if(a.darColor()==1)
					botones[i][j].setIcon(n);
				else if(a.darColor()==2)
					botones[i][j].setIcon(b);
				else if(a.darColor()==3)
					botones[i][j].setIcon(r);
				else if(a.darColor()==4)
					botones[i][j].setIcon(am);
					
				botones[i][j].setPreferredSize(new Dimension(50,50));
				add(botones[i][j]);
			}
		}
		
	}
	public void actualizarCasilla(int c, int f,int color,int cv,int fv)
	{
		
		botones[fv][cv].setIcon(n);
		if(color==1)
			botones[f][c].setIcon(n);
		else if(color==2)
			botones[f][c].setIcon(b);
		else if(color==3)
			botones[f][c].setIcon(r);
		else if(color==4)
			botones[f][c].setIcon(am);
	}
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String msj=e.getActionCommand();
		
		//String[] comando = new String[3]; 
		//comando =msj.split(msj);
		//Sfstem.out.println(msj);
		//Sfstem.out.println(comando.length);
		
		int f=Integer.parseInt(msj.charAt(0)+"");
		int  c=Integer.parseInt(msj.charAt(2)+"");
		//Sfstem.out.println(accion);
		accion+=1;
		if(accion==1)
		{
			cvieja=c;
			fvieja=f;
			try
			{	
				interfaz.valida1(f, c);
			}
			catch (Exception ex )
			{
				accion=-1;
			}
		accion++;
		
		}
		else 
		{
			
			interfaz.mover(f,c,cvieja,fvieja);
			accion=0;
		}
		
		
		
		
		
	}

}
