/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_parqueDiversiones
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.parqueDiversiones.mundo;

/**
 * Clase que representa una atracci�n del parque.
 */
public class Atraccion
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Tipo de atracci�n infantil.
     */
    public final static String INFANTIL = "Infantil";

    /**
     * Tipo de atracci�n terror.
     */
    public final static String TERROR = "Terror";

    /**
     * Tipo de atracci�n acu�tica.
     */
    public final static String ACUATICA = "Acu�tica";

    /**
     * Tipo de atracci�n velocidad.
     */
    public final static String VELOCIDAD = "Velocidad";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Nombre de la atracci�n.
     */
    // TODO Parte1 PuntoA: Declare el atributo nombre como cadena de texto.
    private String nombre;

    /**
     * Precio de la entrada a la atracci�n.
     */
    // TODO Parte1 PuntoB: Declare el atributo precio como n�mero real.
    private double precio;

    /**
     * Tipo de atracci�n.
     */
    // TODO Parte1 PuntoC: Declare el atributo tipo como cadena de texto.
    private String tipo;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva atracci�n. <br>
     * <b> post: </b> Se inicializaron los atributos nombre, precio y tipo con los valores dados por par�metro.
     * @param pNombre Nombre de la atracci�n. pNombre != null && pNombre != "".
     * @param pPrecio Precio de la entrada a la atracci�n.
     * @param pTipo Tipo de atracci�n. pTipo != null && pTipo != "" && (pTipo == INFANTIL || pTipo == TERROR || pTipo == ACUATICA || pTipo == VELOCIDAD).
     * @throws Exception Si el precio de la atracci�n dado por par�metro es menor o igual a cero.
     */
    public Atraccion( String pNombre, double pPrecio, String pTipo ) throws Exception
    {
        // TODO Parte1 PuntoD: Complete el m�todo constructor de la clase.
    	if(pPrecio<0)
    		throw new Exception("El precio de la atracci�n debe ser positivo");
    	
    	nombre = pNombre;
    	precio =pPrecio;
    	tipo = pTipo;

        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:

        // Error si el precio es negativo.
        // Mensaje de error: El precio de la atracci�n deber ser positivo.
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre de la atracci�n.
     * @return Nombre de la atracci�n.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el precio de la entrada de la atracci�n.
     * @return Precio de la entrada de la atracci�n.
     */
    public double darPrecio( )
    {
        return precio;
    }

    /**
     * Retorna el tipo de atracci�n.
     * @return Tipo de atracci�n.
     */
    public String darTipo( )
    {
        return tipo;
    }
    
    /**
     * Retorna una cadena de texto con el nombre de la atracci�n.
     */
    public String toString()
    {
        return nombre;
    }
}
