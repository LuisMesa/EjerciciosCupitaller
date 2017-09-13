package uniandes.cupi2.avion.mundo;

public class Equipaje 
{
	public static final String EQUIPAJE_MUSICAL ="Equipaje musical";
	public static final String EQUIPAJE_DE_MANO ="Equipaje de mano";
	public static final String EQUIPAJE_DEPORTIVO ="Equipaje deportivo";
	public static final String EQUIPAJE_ESPECIAL="Equipaje especial";

	private String categoria, ciudadDestino;
	private double peso, ancho, largo, alto;
	
	public Equipaje(String pCategoria, double pPeso, String pCiudadDestino, double pAncho, double pLargo, double pAlto)
	{
		categoria = pCategoria;
		peso = pPeso;
		ciudadDestino=pCiudadDestino;
		ancho =pAncho;
		alto = pAlto;
		largo = pLargo;
		
	}
	public String darCategoria()
	{
		return categoria;
	}
	public double darPeso()
	{
		return peso;
	}
	public String darCiudadDestino()
	{
		return ciudadDestino;
	}
	public double darAncho()
	{
		return ancho;
	}
	public double darAlto()
	{
		return alto;
	}
	public double darLargo()
	{
		return largo;
	}
	public String toString()
	{
		return categoria+"-"+peso+"(kg)-"+ciudadDestino;
	}
}
