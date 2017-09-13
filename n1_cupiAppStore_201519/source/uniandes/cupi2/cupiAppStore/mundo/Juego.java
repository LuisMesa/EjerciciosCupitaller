/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
     * Categor�a del juego.
     */
    private String categoria;

    /**
     * Precio del juego.
     */
    private int precio;

    /**
     * Tama�o en KB del juego.
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
     * Asigna a los atributos los valores dados por par�metro.
     * @param pNombre Nombre del juego. pNombre != null && pNombre != "".
     * @param pCategoria Categor�a del juego. pCategoria != null && pCategoria != "".
     * @param pPrecio Precio que tiene el juego. pPrecio > 0.
     * @param pTamanio Tama�o en KB del juego. pTamanio > 0.
     * @param pCantidadActual Cantidad de unidades de juego disponibles. pCantidadActual >= 0.
     */
    public void inicializar( String pNombre, String pCategoria, int pPrecio, int pTamanio, int pCantidadActual )
    {
        nombre = pNombre;
        categoria = pCategoria;
        precio = pPrecio;
        tamanio = pTamanio;
        // TODO Parte2 PuntoC: Completar el m�todo seg�n la documentaci�n. Las cantidad de licencias vendidas deben inicializarse en cero.
        cantidadActual=pCantidadActual;
        cantidadVendidas=0;
    }

    // -----------------------------------------------------------------
    // M�todos
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
     * Retorna la categor�a del juego.
     * @return Categor�a del juego.
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
     * Retorna el tama�o en KB del juego.
     * @return Tama�o en KB del juego.
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
        // TODO Parte2 PuntoD: Completar el m�todo seg�n la documentaci�n.
    	return cantidadActual;
    }

    /**
     * Retorna la cantidad de unidades vendidas del juego.
     * @return Cantidad de unidades vendidas del juego.
     */
    public int darCantidadVendidas( )
    {
        // TODO Parte2 PuntoE: Completar el m�todo seg�n la documentaci�n.
    	return cantidadVendidas;
    }

    /**
     * Compra una cantidad dada de unidades. Aumenta la cantidad actual de unidades de juego.
     * @param pCantidad Cantidad de unidades que se quieren comprar. pCantidad > 0.
     */
    public void comprarUnidades( int pCantidad )
    {
        // TODO Parte2 PuntoF: Completar el m�todo seg�n la documentaci�n.
    	cantidadActual+=pCantidad;
    }
    /**
     * Vende una cantidad dada de unidades. Disminuye la cantidad actual de unidades del juego. Aumenta la cantidad de unidades vendidas del juego.
     * @param pCantidad Cantidad de unidades que se quieren vender. pCantidad > 0.
     */
    public void venderUnidades( int pCantidad )
    {
        // TODO Parte2 PuntoG: Completar el m�todo seg�n la documentaci�n.
    	cantidadActual-=pCantidad;
    	cantidadVendidas+=pCantidad;
    }
}