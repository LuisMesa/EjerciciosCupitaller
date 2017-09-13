/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_cupiZoologico
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.cupiZoologico.mundo;

/**
 * Clase que representa un zool�gico.
 */
public class Zoologico
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa la cantidad de jaulas del zool�gico.
     */
    // TODO Parte3 PuntoA: Agregue la constante CANT_JAULAS que determina el n�mero de jaulas en el zool�gico. 
    // En el modelo del mundo (ModeloConceptual.jpg) se encuentra el tipo y valor exacto de la constante.

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Lista de jaulas del zool�gico.
     */
    //TODO Parte3 PuntoB: Declare la asociaci�n jaulas como una contenedora de tama�o fijo.

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Construye un zool�gico. <br>
     * <b> post: </b> La lista de jaulas qued� inicializada con los siguientes valores y posiciones: <br>
     * pos 0) Jaula peque�a en el sector norte. <br>
     * pos 1) Jaula peque�a en el sector norte. <br>
     * pos 2) Jaula mediana en el sector norte. <br>
     * pos 3) Jaula grande en el sector norte. <br>
     * pos 4) Jaula grande en el sector norte. <br>
     * pos 5) Jaula grande en el sector sur. <br>
     * pos 6) Jaula grande en el sector sur. <br>
     * pos 7) Jaula grande en el sector sur. <br>
     * pos 8) Jaula mediana en el sector sur. <br>
     * pos 9) Jaula peque�a en el sector sur.
     */
    public Zoologico( )
    {
        //TODO Parte3 PuntoC: Inicialice la contenedora de jaulas.

    	Animal nombre = new Animal("s", "s", "d", "d", "d");
    	int a =0;
    	
    	
        jaulas[ 0 ] = new Jaula( Jaula.NORTE, Jaula.PEQUENIA );
        jaulas[ 1 ] = new Jaula( Jaula.NORTE, Jaula.PEQUENIA );
        jaulas[ 2 ] = new Jaula( Jaula.NORTE, Jaula.MEDIANA );
        jaulas[ 3 ] = new Jaula( Jaula.NORTE, Jaula.GRANDE );
        jaulas[ 4 ] = new Jaula( Jaula.NORTE, Jaula.GRANDE );
        jaulas[ 5 ] = new Jaula( Jaula.SUR, Jaula.GRANDE );

        // TODO Parte4 PuntoD: Asigne las posiciones 6, 7, 8 y 9 seg�n la documentaci�n dada

    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna la lista de jaulas del zool�gico <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Arreglo de jaulas.
     */
    public Jaula[] darJaulas( )
    {
        return jaulas;
    }

    /**
     * Retorna la jaula con el n�mero dado por par�metro. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNumJaula N�mero de la jaula deseada. pNumJaula >= 0 && pNumJaula < CANT_JAULAS.
     * @return Jaula con el n�mero dado.
     */
    public Jaula darJaula( int pNumJaula )
    {
        //TODO Parte3 PuntoE: Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Retorna la cantidad total de animales que tiene el zool�gico. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Cantidad total de animales.
     */
    public int darCantidadAnimales( )
    {
        Jaula jaulaActual = null;
        int i = 0;
        int cantidad = 0;
        while( i < CANT_JAULAS )
        {
            jaulaActual = jaulas[ i ];
            cantidad += jaulaActual.darCantidadAnimales( );
            i++;
        }

        return cantidad;
    }

    /**
     * Retorna la cantidad de jaulas ubicadas en el sector sur. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Cantidad de jaulas en el sur.
     */
    public int darCantidadJaulasSur( )
    {
        int cantidad = 0;
        Jaula jaulaActual = null;
        for( int i = 0; i < CANT_JAULAS; i++ )
        {
            jaulaActual = jaulas[ i ];
            if( jaulaActual.darSector( ).equals( Jaula.SUR ) )
            {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Retorna la cantidad de jaulas ubicadas en el sector norte. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Cantidad de jaulas en el norte.
     */
    public int darCantidadJaulasNorte( )
    {
        //TODO Parte3 PuntoF: Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Agrega un animal en la primera jaula que cumpla con los requerimientos. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNombre Nombre del animal a agregar. pNombre != null && pNombre != "".
     * @param pEspecie Especie del animal a agregar. pEspecie != null && pEspecie != "".
     * @param pTipo Tipo del animal a agregar. pTipo != null && pTipo != "" && (pTipo == HERBIVORO || pTipo == CARNIVORO).
     * @param pHabitat H�bitat del animal a agregar. pHabitat != null && pHabitat != "" && (pHabitat == ACUATICO || pHabitat == TERRESTRE).
     * @param pImagen Imagen del animal a agregar. pImagen != null && pImagen != "".
     * @return N�mero de la jaula en la que se agreg� el animal, -1 si no pudo agregar el animal.
     */
    public int agregarAnimal( String pNombre, String pEspecie, String pTipo, String pHabitat, String pImagen )
    {
        //TODO Parte3 PuntoG: Complete el m�todo seg�n la documentaci�n dada.
        // Recuerde seguir las reglas de h�bitat y especie especificadas en el documento de descripci�n.
    }

    /**
     * Elimina el primer animal que encuentra con el nombre dado por par�metro. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNombreAnimal Nombre del animal a eliminar. pNombre != null && pNombre != "".
     * @return True si pudo eliminar el animal, false si no encontr� un animal con el nombre dado.
     */
    public boolean eliminarAnimal( String pNombreAnimal )
    {
        Jaula jaulaActual = null;
        boolean eliminado = false;
        for( int i = 0; i < CANT_JAULAS && !eliminado; i++ )
        {
            jaulaActual = jaulas[ i ];
            if( jaulaActual.eliminarAnimal( pNombreAnimal ) )
            {
                eliminado = true;
            }
        }
        return eliminado;
    }

    /**
     * Retorna el n�mero de la jaula en la que se encuentra el primer animal con el nombre dado por par�metro. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNombreAnimal Nombre del animal buscado. pNombreAnimal != null && pNombreAnimal != "".
     * @return N�mero de la jaula donde se encuentra el animal, -1 si no encontr� ning�n animal con ese nombre.
     */
    public int buscarJaulaAnimalPorNombre( String pNombreAnimal )
    {
        //TODO Parte3 PuntoH: Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Retorna la jaula que tiene m�s animales.<br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return N�mero de la jaula que tiene m�s animales, -1 si todas las jaulas est�n desocupadas.
     */
    public int buscarJaulaMayorCantidadAnimales( )
    {
        //TODO Parte3 PuntoI: Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Retorna el porcentaje de ocupaci�n de la jaula con respecto a su capacidad total. <br>
     * El porcentaje se calcula teniendo en cuenta la cantidad total de animales del zool�gico y la capacidad total de las jaulas del zool�gico.<br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Porcentaje de ocupaci�n.
     */
    public double calcularPorcentajeOcupacionJaulas( )
    {
        int cantidadOcupado = 0;
        int capacidadTotalJaulas = 0;
        Jaula jaulaActual = null;
        for( int i = 0; i < CANT_JAULAS; i++ )
        {
            jaulaActual = jaulas[ i ];
            cantidadOcupado += jaulaActual.darCantidadAnimales( );
            capacidadTotalJaulas += jaulaActual.darCapacidadJaula( );
        }
        return ( ( double )cantidadOcupado / ( double )capacidadTotalJaulas ) * 100;
    }

    /**
     * Indica si hay dos jaulas con la misma cantidad (diferente a 0) de animales. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return True si existen dos jaulas con la misma cantidad de animales, false de lo contrario.
     */
    public boolean existenJaulasConMismaCantidadAnimales( )
    {
        //TODO Parte3 PuntoJ: Complete el m�todo seg�n la documentaci�n dada.
    }

    // -------------------------------------------------------------
    // Extensi�n
    // -------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * M�todo para la extensi�n 2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }
}