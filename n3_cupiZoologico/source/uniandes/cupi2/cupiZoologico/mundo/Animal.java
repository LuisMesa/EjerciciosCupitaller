package uniandes.cupi2.cupiZoologico.mundo;

public class Animal 
{
	public final static String HERBIVORO ="Herbívoro";
	public final static String CARNIVORO ="Carnivoro";
	public final static String ACUATICO ="Acuático";
	public final static String TERRESTRE ="Terrestre";
	
	
	private String nombre,especie,tipo,habitat,imagen;
	
	
	public Animal(String pNombre,String pEspecie,String pTipo, String pHabitat, String pImagen )
	{
		nombre=pNombre;
		especie=pEspecie;
		tipo=pTipo;
		habitat=pHabitat;
		imagen=pImagen;
	}
	public String darNombre()
	{
		return nombre;
	}
	public String darEspecie() 
	{
		return especie;
	}
	
	public String darTipo() 
	{
		return tipo;
	}
	
	public String darHabitat() 
	{
		return habitat;
	}
	
	public String darImagen() 
	{
		return imagen;
	}
	public String toString()
	{
		return nombre + " " + "(" + especie + ")" ;
	}
	
}
