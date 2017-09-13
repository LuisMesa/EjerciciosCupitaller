package uniandes.cupi2.cupiDamas.mundo;

public class Casilla 
{
	private int nColor;
	private int x,y;
	private boolean estado;
	public Casilla(int pNColor,int px,int py)
	{
		nColor = pNColor;
		x=px;
		y=py;
		estado = false;
		
	}
	
	public int darColor()
	{
		return nColor;
	}
	public boolean darEstado()
	{
		return estado;
	}
	public void cambiarEstado(boolean a)
	{
		estado = a;
	}
	public void cambiarColor(int color)
	{
		nColor = color;
	}

}
