package uniandes.cupi2.lucesApagadas.mundo;

public class Ventana 
{
	private boolean encendida ;
	
	public Ventana(boolean pE)
	{
		encendida = pE;
	}

	public boolean estaEncendida() 
	{
		return encendida;
	}

	public void cambiarEncendida() 
	{
		encendida = !encendida;
	}
	
}
