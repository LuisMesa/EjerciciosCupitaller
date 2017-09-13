/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_cupiAppStore
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupiAppStore.mundo;

/**
 * Clase que representa un juego.
 */
public class Juego
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del juego.
     */
    private String nombre;

    /**
     * Categoría del juego.
     */
    private String categoria;

    /**
     * Precio del juego.
     */
    private int precio;

    /**
     * Tamaño en KB del juego.
     */
    private int tamanio;

    /**
     * Cantidad de unidades del juego que se tienen actualmente.
     */
    // TODO Parte2 PuntoA: Declarar el atributo para modelar la cantidad de licencias del juego que se tienen actualmente (valor entero).
    private int cantidadActual;

    /**
     * Cantidad de unidades del juego que se han vendido.
     */
    // TODO Parte2 PuntoB: Declarar el atributo para modelar la cantidad de licencias del juego que se han vendido (valor entero).
    private int cantidadVendidas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Asigna a los atributos los valores dados por parámetro.
     * @param pNombre Nombre del juego. pNombre != null && pNombre != "".
     * @param pCategoria Categoría del juego. pCategoria != null && pCategoria != "".
     * @param pPrecio Precio que tiene el juego. pPrecio > 0.
     * @param pTamanio Tamaño en KB del juego. pTamanio > 0.
     * @param pCantidadActual Cantidad de unidades de juego disponibles. pCantidadActual >= 0.
     */
    public void inicializar( String pNombre, String pCategoria, int pPrecio, int pTamanio, int pCantidadActual )
    {
        nombre = pNombre;
        categoria = pCategoria;
        precio = pPrecio;
        tamanio = pTamanio;
        // TODO Parte2 PuntoC: Completar el método según la documentación. Las cantidad de licencias vendidas deben inicializarse en cero.
        cantidadActual=pCantidadActual;
        cantidadVendidas=0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del juego.
     * @return Nombre del juego.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la categoría del juego.
     * @return Categoría del juego.
     */
    public String darCategoria( )
    {
        return categoria;
    }

    /**
     * Retorna el precio del juego.
     * @return Precio del juego.
     */
    public int darPrecio( )
    {
        return precio;
    }

    /**
     * Retorna el tamaño en KB del juego.
     * @return Tamaño en KB del juego.
     */
    public int darTamanio( )
    {
        return tamanio;
    }

    /**
     * Retorna la cantidad de unidades del juego.
     * @return Cantidad de unidades del juego.
     */
    public int darCantidadActual( )
    {
        // TODO Parte2 PuntoD: Completar el método según la documentación.
    	return cantidadActual;
    }

    /**
     * Retorna la cantidad de unidades vendidas del juego.
     * @return Cantidad de unidades vendidas del juego.
     */
    public int darCantidadVendidas( )
    {
        // TODO Parte2 PuntoE: Completar el método según la documentación.
    	return cantidadVendidas;
    }

    /**
     * Compra una cantidad dada de unidades. Aumenta la cantidad actual de unidades de juego.
     * @param pCantidad Cantidad de unidades que se quieren comprar. pCantidad > 0.
     */
    public void comprarUnidades( int pCantidad )
    {
        // TODO Parte2 PuntoF: Completar el método según la documentación.
    	cantidadActual+=pCantidad;
    }
    /**
     * Vende una cantidad dada de unidades. Disminuye la cantidad actual de unidades del juego. Aumenta la cantidad de unidades vendidas del juego.
     * @param pCantidad Cantidad de unidades que se quieren vender. pCantidad > 0.
     */
    public void venderUnidades( int pCantidad )
    {
        // TODO Parte2 PuntoG: Completar el método según la documentación.
    	cantidadActual-=pCantidad;
    	cantidadVendidas+=pCantidad;
    }
}