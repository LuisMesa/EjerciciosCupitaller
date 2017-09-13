/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_cupiZoologico
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.cupiZoologico.mundo;

import java.util.ArrayList;

/**
 * Clase que representa a la jaula del zoológico.
 */
public class Jaula
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa la ubicación de la jaula en el sector norte del zoológico.
     */
    public static String NORTE = "Norte";

    /**
     * Constante que representa la ubicación de la jaula en el sector sur del zoológico.
     */
    public static String SUR = "Sur";

    /**
     * Constante que representa el tamaño de jaula grande.
     */
    public static String GRANDE = "Grande";

    /**
     * Constante que representa el tamaño de jaula mediana.
     */
    public static String MEDIANA = "Mediana";

    /**
     * Constante que representa el tamaño de jaula pequeña.
     */
    public static String PEQUENIA = "Pequeña";

    /**
     * Constante que representa la capacidad de una jaula grande.
     */
    public static int CAPACIDAD_GRANDE = 10;

    /**
     * Constante que representa la capacidad de una jaula mediana.
     */
    public static int CAPACIDAD_MEDIANA = 6;

    /**
     * Constante que representa la capacidad de una jaula pequeña.
     */
    public static int CAPACIDAD_PEQUEÑA = 2;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El sector donde se encuentra ubicada la jaula.
     */
    private String sector;

    /**
     * El tamaño de la jaula.
     */
    private String tamanio;

    /**
     * Vector de animales que se encuentran en jaula.
     */
    //TODO Parte2 PuntoA: Declare la asociación animales como una contenedora de tipo variable.
    private ArrayList<Animal> animales;

    /**
     * Guardia de la jaula.
     */
    private Guardia guardia;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Inicializa la jaula usando los valores dados por parámetro. <br>
     * <b> post: </b> La jaula se inicializó con los valores de sector y tamanio dados por parámetro. El vector de animales quedó inicializado y el guardia se inicializó como null. 
     * @param pSector Sector donde está ubicada la jaula. pSector != null && pSector != "" && (pSector = NORTE || pSector = SUR ).
     * @param pTamanio Tamaño de la jaula. pTamanio != null && pTamanio && (pTamanio = GRANDE || pTamanio = MEDIANA || pTamanio = PEQUEÑA).
     */
    public Jaula( String pSector, String pTamanio )
    {
        sector = pSector;
        tamanio = pTamanio;

        //TODO Parte2 PuntoB: Inicialice la contenedora de animales y el guardia según la documentación dada.
        guardia = null;
        //Inicializar el vector
        animales = new ArrayList<Animal>();
        
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna el sector donde se ubica la jaula.
     * @return Sector de la jaula.
     */
    public String darSector( )
    {
        return sector;
    }

    /**
     * Retorna el guardia de la jaula.
     * @return Guardia de la jaula.
     */
    public Guardia darGuardia( )
    {
        return guardia;
    }

    /**
     * Retorna el tamaño de la jaula.
     * @return Tamaño de la jaula.
     */
    public String darTamanio( )
    {
        return tamanio;
    }

    /**
     * Retorna la lista de los animales que se encuentran en la jaula. <br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @return Animales que se encuentran en la jaula.
     */
    public ArrayList darAnimales( )
    {
        //TODO Parte2 PuntoC: Complete el método según la documentación dada.
    	return animales;
    }

    /**
     * Retorna la capacidad de la jaula dependiendo del tamaño de la jaula. <br>
     * @return Capacidad de la jaula.
     */
    public int darCapacidadJaula( )
    {
        int capacidad = 0;
        if( tamanio.equals( GRANDE ) )
        {
            capacidad = CAPACIDAD_GRANDE;
        }
        else if( tamanio.equals( MEDIANA ) )
        {
            capacidad = CAPACIDAD_MEDIANA;
        }
        else
        {
            capacidad = CAPACIDAD_PEQUEÑA;
        }
        return capacidad;

    }

    /**
     * Retorna la cantidad de animales que hay en la jaula. <br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @return Cantidad de animales en la jaula.
     */
    public int darCantidadAnimales( )
    {
        return animales.size( );
    }

    /**
     * Agrega un animal en la jaula. <br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * <b> post: </b> Se agregó un nuevo animal a la lista de animales. <br>
     * @param pNombre Nombre del animal a agregar. pNombre != null && pNombre != "".
     * @param pEspecie Especie del animal a agregar. pEspecie != null && pEspecie != "".
     * @param pTipo Tipo del animal a agregar. pTipo != null && pTipo != "" && (pTipo == HERBIVORO || pTipo == CARNIVORO).
     * @param pHabitat Hábitat del animal a agregar. pHabitat != null && pHabitat != "" && (pHabitat == ACUATICO || pHabitat == TERRESTRE).
     * @param pImagen Imagen del animal a agregar. pImagen != null && pImagen != "".
     */
    public void agregarAnimal( String pNombre, String pEspecie, String pTipo, String pHabitat, String pImagen )
    {
        //TODO Parte2 PuntoD: Complete el método según la documentación dada.
    	
    	Animal nuevoAnimal = new Animal(pNombre, pEspecie, pTipo, pHabitat, pImagen);
    	
    	animales.add(nuevoAnimal);
    	
    	
    }

    /**
     * Asigna un guardia a la jaula actual. <br>
     * <b> post: </b> Se asignó un nuevo guardia a la jaula. <br>
     * @param pNombreGuardia Nombre del guardia. pNombreGuardia != "" && pNombreGuardia != null.
     * @param pAnhosExperiencia Años de experiencia como guardia.
     */
    public void asignarGuardia( String pNombreGuardia, int pAnhosExperiencia )
    {
        //TODO Parte2 PuntoE: Complete el método según la documentación dada.
    	Guardia guardian = new Guardia(pNombreGuardia, pAnhosExperiencia);
    	guardia = guardian;
    	
    }

    /**
     * Elimina el primer animal encontrado con el nombre dado por parámetro. <br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @param pNombre Nombre del animal a eliminar. pNombre != null && pNombre != "".
     * @return True si eliminó el animal, false si no encontró un animal con ese nombre para eliminar.
     */
    public boolean eliminarAnimal( String pNombre )
    {
        //TODO Parte2 PuntoF: Complete el método según la documentación dada.
    	//Recorrido parcial
    	boolean rta =false;
    	for(int c=0;c<animales.size()&&rta==false;c++)
    	{
    		
    		Animal animalActual = animales.get(c);
    		if(animalActual.darNombre().equals(pNombre) )
    		{
    			animales.remove(c);
    			rta= true;
    		}
    	}
    	
    	//Recorrido total
    	int contador =0;
    	for(int c=0;c<animales.size();c++)
    	{
    		
    		Animal animalActual = animales.get(c);
    		if(animalActual.darTipo().equals(Animal.CARNIVORO)&&animalActual.darTipo().equals(Animal.ACUATICO) )
    		{
    			contador++;
    			
    		}
    	}
    	//return contador
    	String  a = "El numero de voladores es: ";
    	String rta1 = a+contador;
    	return rta;
    }

    /**
     * Indica si hay algún animal carnívoro en la jaula. <br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @return True si hay algún carnívoro en la jaula, false de lo contrario.
     */
    public boolean hayAnimalCarnivoro( )
    {
        //TODO Parte2 PuntoG: Complete el método según la documentación dada.
    	
    	for(int c=0;c<animales.size();c++)
    	{
    		
    		Animal animalActual = animales.get(c);
    		if(animalActual.darTipo().equals(Animal.CARNIVORO) )
    		{
    			return true;
    		}
    	}
    	return false;
    }

    /**
     * Indica si hay espacio en la jaula para un animal más.<br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @return True si hay espacio en la jaula, false de lo contrario.
     */
    public boolean hayEspacioEnJaula( )
    {
        boolean hayEspacio = false;
        if( animales.size( ) < darCapacidadJaula( ) )
        {
            hayEspacio = true;
        }
        return hayEspacio;
    }

    /**
     * Indica si en la jaula existe algún animal con el nombre dado. <br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @param pNombre Nombre del animal a buscar. pNombre != null && pNombre != "".
     * @return True si encontró el animal, false de lo contrario.
     */
    public boolean existeAnimalEnJaula( String pNombre )
    {
        //TODO Parte2 PuntoH: Complete el método según la documentación dada.
    	for(int c=0;c<animales.size();c++)
    	{
    		
    		Animal animalActual = animales.get(c);
    		if(animalActual.darNombre().equals(pNombre) )
    		{
    			return true;
    		}
    	}
    	return false;
    }

    /**
     * Indica si un hábitat dado por parámetro es el indicado para la jaula, teniendo en cuenta las siguientes condiciones:<br>
     * Si la jaula está en el sector norte, sólo puede agregar animales de hábitat acuático.<br>
     * Si la jaula está en el sector sur, sólo puede agregar animales de hábitat terrestre.<br>
     * @param pHabitat Hábitat del animal a verificar. pHabitat != null && pHabitat != "" && (pHabitat == ACUATICO || pHabitat == TERRESTRE).
     * @return True si la jaula cumple con las condiciones indicadas, false de lo contrario.
     */
    public boolean puedeAgregarPorHabitat( String pHabitat )
    {
        boolean cumple = false;
        if( ( pHabitat.equals( Animal.ACUATICO ) && sector.equals( Jaula.NORTE ) ) || ( pHabitat.equals( Animal.TERRESTRE ) && sector.equals( Jaula.SUR ) ) )
        {
            cumple = true;
        }
        return cumple;
    }

    /**
     * Indica si se puede agregar un animal de cierto tipo y especie a la jaula teniendo en cuenta las siguientes condiciones: <br>
     * Si el tipo es herbívoro, sólo lo puede agregar si no hay ningún animal carnívoro en la jaula o si la jaula está vacía.<br>
     * Si el tipo es carnívoro, sólo lo puede agregar si hay un animal de la misma especie en la jaula o si la jaula está vacía.<br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @param pEspecie Especie del animal a agregar. pEspecie != null y pEspecie != "".
     * @param pTipo Tipo del animal a agregar. pTipo != null && pTipo != "" && (pTipo == CARNIVORO || pTipo == HERBIVORO).
     * @return True si se puede agregar, false de lo contrario.
     */
    public boolean puedeAgregarPorTipoYEspecie( String pEspecie, String pTipo )
    {
        //TODO Parte2 PuntoI: Complete el método según la documentación dada.
    	if(pTipo.equals(Animal.HERBIVORO))
    	{
    		if(animales.size()==0)
    		{
    			return true;
    		}
    		if(hayAnimalCarnivoro()==true)
    		{
    			return false;
    		}
    		else
    		{
    			return true;
    		}
    	}
    	else if(pTipo.equals(Animal.CARNIVORO))
    	{
    		if(animales.size()==0)
    		{
    			return true;
    		}
    		if(hayAnimalCarnivoro()==true)
    		{
    			int contador =0;
    			for(int c=0;c<animales.size();c++)
    	    	{
    	    		
    	    		Animal animalActual = animales.get(c);
    	    		if(animalActual.darTipo().equals(Animal.CARNIVORO) )
    	    		{
    	    			contador++;
    	    		}
    	    	}
    			if(contador==1)
    			{
    				return true;
    			}
    		}
    		else
    		{
    			return false;
    		}
    	}
    	return false;
    }

    /**
     * Indica si el animal con las características dadas puede ser agregado a la jaula teniendo en cuenta las restricciones enunciadas en el documento de descripción.<br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @param pEspecie Especie del animal a verificar - especie != null y especie != "".
     * @param pTipo Tipo del animal a verificar. pTipo != null && pTipo != "".
     * @param pHabitat Hábitat del animal a verificar. pHabitat != null && pHabitat != "".
     * @return true si se puede agregar al animal, false de lo contrario.
     */
    public boolean puedeAgregarAnimal( String pEspecie, String pTipo, String pHabitat )
    {
        boolean puede = puedeAgregarPorTipoYEspecie( pEspecie, pTipo ) && puedeAgregarPorHabitat( pHabitat ) && hayEspacioEnJaula( );
        return puede;
    }
}