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

/**
 * Clase que representa un zoológico.
 */
public class Zoologico
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa la cantidad de jaulas del zoológico.
     */
    // TODO Parte3 PuntoA: Agregue la constante CANT_JAULAS que determina el número de jaulas en el zoológico. 
    // En el modelo del mundo (ModeloConceptual.jpg) se encuentra el tipo y valor exacto de la constante.

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Lista de jaulas del zoológico.
     */
    //TODO Parte3 PuntoB: Declare la asociación jaulas como una contenedora de tamaño fijo.

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Construye un zoológico. <br>
     * <b> post: </b> La lista de jaulas quedó inicializada con los siguientes valores y posiciones: <br>
     * pos 0) Jaula pequeña en el sector norte. <br>
     * pos 1) Jaula pequeña en el sector norte. <br>
     * pos 2) Jaula mediana en el sector norte. <br>
     * pos 3) Jaula grande en el sector norte. <br>
     * pos 4) Jaula grande en el sector norte. <br>
     * pos 5) Jaula grande en el sector sur. <br>
     * pos 6) Jaula grande en el sector sur. <br>
     * pos 7) Jaula grande en el sector sur. <br>
     * pos 8) Jaula mediana en el sector sur. <br>
     * pos 9) Jaula pequeña en el sector sur.
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

        // TODO Parte4 PuntoD: Asigne las posiciones 6, 7, 8 y 9 según la documentación dada

    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna la lista de jaulas del zoológico <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Arreglo de jaulas.
     */
    public Jaula[] darJaulas( )
    {
        return jaulas;
    }

    /**
     * Retorna la jaula con el número dado por parámetro. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNumJaula Número de la jaula deseada. pNumJaula >= 0 && pNumJaula < CANT_JAULAS.
     * @return Jaula con el número dado.
     */
    public Jaula darJaula( int pNumJaula )
    {
        //TODO Parte3 PuntoE: Complete el método según la documentación dada.
    }

    /**
     * Retorna la cantidad total de animales que tiene el zoológico. <br>
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
        //TODO Parte3 PuntoF: Complete el método según la documentación dada.
    }

    /**
     * Agrega un animal en la primera jaula que cumpla con los requerimientos. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNombre Nombre del animal a agregar. pNombre != null && pNombre != "".
     * @param pEspecie Especie del animal a agregar. pEspecie != null && pEspecie != "".
     * @param pTipo Tipo del animal a agregar. pTipo != null && pTipo != "" && (pTipo == HERBIVORO || pTipo == CARNIVORO).
     * @param pHabitat Hábitat del animal a agregar. pHabitat != null && pHabitat != "" && (pHabitat == ACUATICO || pHabitat == TERRESTRE).
     * @param pImagen Imagen del animal a agregar. pImagen != null && pImagen != "".
     * @return Número de la jaula en la que se agregó el animal, -1 si no pudo agregar el animal.
     */
    public int agregarAnimal( String pNombre, String pEspecie, String pTipo, String pHabitat, String pImagen )
    {
        //TODO Parte3 PuntoG: Complete el método según la documentación dada.
        // Recuerde seguir las reglas de hábitat y especie especificadas en el documento de descripción.
    }

    /**
     * Elimina el primer animal que encuentra con el nombre dado por parámetro. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNombreAnimal Nombre del animal a eliminar. pNombre != null && pNombre != "".
     * @return True si pudo eliminar el animal, false si no encontró un animal con el nombre dado.
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
     * Retorna el número de la jaula en la que se encuentra el primer animal con el nombre dado por parámetro. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNombreAnimal Nombre del animal buscado. pNombreAnimal != null && pNombreAnimal != "".
     * @return Número de la jaula donde se encuentra el animal, -1 si no encontró ningún animal con ese nombre.
     */
    public int buscarJaulaAnimalPorNombre( String pNombreAnimal )
    {
        //TODO Parte3 PuntoH: Complete el método según la documentación dada.
    }

    /**
     * Retorna la jaula que tiene más animales.<br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Número de la jaula que tiene más animales, -1 si todas las jaulas están desocupadas.
     */
    public int buscarJaulaMayorCantidadAnimales( )
    {
        //TODO Parte3 PuntoI: Complete el método según la documentación dada.
    }

    /**
     * Retorna el porcentaje de ocupación de la jaula con respecto a su capacidad total. <br>
     * El porcentaje se calcula teniendo en cuenta la cantidad total de animales del zoológico y la capacidad total de las jaulas del zoológico.<br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Porcentaje de ocupación.
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
        //TODO Parte3 PuntoJ: Complete el método según la documentación dada.
    }

    // -------------------------------------------------------------
    // Extensión
    // -------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * Método para la extensión 2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }
}