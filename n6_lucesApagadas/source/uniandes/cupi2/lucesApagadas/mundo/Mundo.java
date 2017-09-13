package uniandes.cupi2.lucesApagadas.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class Mundo 
{
	private File archivo;
	private int filas;
	private int columnas;
	private Ventana[][] ventanas;
	
	public Mundo(File pArch) throws Exception
	{
		filas =7;
		columnas=7;
		archivo = pArch;
		ventanas = new Ventana[filas][columnas];
		Properties pr=cargarArchivo();
		inicializar(pr);
		
		
	}
	
	public Properties cargarArchivo() throws Exception
	{
		Properties rta = new Properties();
		FileInputStream lector = new FileInputStream(archivo);
		try
		{
			rta.load(lector);
			lector.close();
		}
		catch(Exception e)
		{
			throw new Exception("Error al cargar");
		}
		
		return rta;
	}
	
	public void inicializar(Properties propiedades)
	{
		for (int i = 0; i <ventanas.length; i++) 
		{
			String cadena = propiedades.getProperty("cupiCastillo.fila"+(i+1));
			for (int j = 0; j < ventanas[0].length; j++) 
			{
				int posicion = Integer.parseInt(cadena.charAt(j)+"");
				boolean estado = posicion==1;
				
				ventanas[i][j] = new Ventana(estado) ;
			}
		}
	}
	
	public Ventana[][] darVentanas()
	{
		return ventanas;
	}
	public void reiniciar()
	{
		try
		{
			Properties p = cargarArchivo();
			inicializar(p);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void activarVentana(int pF,int pC)
	{
		ventanas[pF][pC].cambiarEncendida();
		if(pF+1<filas)
		ventanas[pF+1][pC].cambiarEncendida();
		if(pF-1>-1)
		ventanas[pF-1][pC].cambiarEncendida();
		if(pC+1<columnas)
		ventanas[pF][pC+1].cambiarEncendida();
		if(pC-1>-1)
		ventanas[pF][pC-1].cambiarEncendida();
	}
	public String estadisticas()
	{
		return "Cantidad de ventanas encendidas: "+encendidas()+". \n"+"La fila con más ventanas encendidas es: "+filaMasEncendidas()+".";
	}
	public int encendidas()
	{
		int contador = 0;
		for (int i = 0; i < ventanas.length; i++) 
		{
			for (int j = 0; j < ventanas[0].length; j++) 
			{
				contador +=(ventanas[i][j].estaEncendida())?1:0;
			}
		}
		return contador;
	}
	public int filaMasEncendidas()
	{
		int rta =0;
		int mayor = 0;
		for (int i = 0; i < ventanas.length; i++) 
		{
			int contador = 0;
			for (int j = 0; j < ventanas[0].length; j++) 
			{
				contador +=(ventanas[i][j].estaEncendida())?1:0;
			}
			mayor=contador>mayor?contador:mayor;
			rta=contador==mayor?i:rta;
		}
		return rta;
	}
	public String op1()
	{
		return "Respuesta 1";
	}
	public String op2()
	{
		return "Respuesta 2";
	}
	
}
