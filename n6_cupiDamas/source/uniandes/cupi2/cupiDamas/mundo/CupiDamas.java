package uniandes.cupi2.cupiDamas.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

public class CupiDamas 
{
	private int filas,columnas;
	private Casilla[][] casillas;
	private int numRojas, numBlancas;
	public CupiDamas(File a) throws Exception
	{
		filas=0;
		columnas=0;
		inicializarAtributos(cargarInfo(a));
		
		
	}
	public Properties cargarInfo(File pArchivo) throws Exception
	{
		Properties datos = new Properties();
		FileInputStream in = new FileInputStream(pArchivo);
		try
		{
			datos.load(in);
			in.close();
		}
		catch (Exception e)
		{
			throw new Exception("Formato invalido.");
		}
		return datos;
	}
	
	public void inicializarAtributos(Properties pDatos)
	{
		Properties datos = pDatos;
		columnas = Integer.parseInt(datos.getProperty("tablero.tamanho"));
		filas = Integer.parseInt(datos.getProperty("tablero.tamanho"));
		casillas = new Casilla[filas][columnas];
		for(int i = 0;i<filas;i++)
		{
			for(int j =0;j<columnas ;j++)
			{
				int x = j;
				int y=i;
				int color = Integer.parseInt(datos.getProperty("casilla."+i+"."+j));
				casillas[i][j] = new Casilla(color,x,y);
			}
		}
		
	}

	public ArrayList darCasillas()
	{
		ArrayList lista = new ArrayList();
		
		for (int i = 0; i < filas; i++) 
		{
			for(int j =0;j<columnas;j++)
			{
				lista.add(casillas[i][j]);
			}
			
		}
		return lista;
	}
	public Casilla darCasillaPosicion(int f,int c)
	{
		return casillas[f][c];
	}
	public int darTamanio()
	{
		return filas;
	}
	public void seleccionar(int x,int y)
	{
		casillas[x][y].cambiarEstado(true);
	}
	public int mover(int c,int f,int cv, int fv)
	{
		Casilla a = darCasillaPosicion(f, c);
		Casilla ficha = darCasillaPosicion(fv, cv);
		String asda ="b";
		System.out.println(!asda.equals("b")+"adasdad");
				
			if(a.darColor()==1&&ficha.darColor()==3)
			{
				boolean bien = darCasillaPosicion(f, c).darColor()==1;
				if(bien)
				{
					//pTablero.actualizarCasilla(c, f, 3,cv,fv);
					Casilla b =darCasillaPosicion(fv, cv);
					Casilla d =darCasillaPosicion(f, c);
					d.cambiarColor(3);
					b.cambiarColor(1);
					return 3;
				}
			}
			if(a.darColor()==1&&ficha.darColor()==4)
			{
				boolean bien = darCasillaPosicion(f, c).darColor()==1;
				if(bien)
				{
					//pTablero.actualizarCasilla(c, f, 4,cv,fv);
					Casilla b =darCasillaPosicion(fv, cv);
					Casilla d =darCasillaPosicion(f, c);
					d.cambiarColor(4);
					b.cambiarColor(1);
					return 4;
				}
			}
			return 2;
		
	}
	public boolean moverValido(int c,int f, int cv, int fv, int color)
	{
		System.out.println((color==3)+"color==3");
		System.out.println((c==cv+1||c==cv-1)+"(c==cv+1||c==cv-1)");
		System.out.println((fv-1==f)+"fv-1==f");
		//System.out.println();
		System.out.println("columna vieja:"+cv);
		System.out.println("columna nueva:"+c);
		
		if(color==4&&(c==cv+1||c==cv-1)&&fv+1==f)
		{
			System.out.println("retorno true 4");
			return true;
		}
		if(color==3&&(c==cv+1||c==cv-1)&&fv-1==f)
		{
			System.out.println("retorno true 3");
			return true;
		}
		return false;
		
		
	}
	public void contar()
	{
		//esta bien como lo tienes
	}
	public String termino()
	{
		contar();
		if(numRojas==0)
		{
			return "Ganador Blancoo";
		}
		else if(numBlancas==0)
		{
			return "Ganador Rojo";
		}
		return "b";
	}
}
