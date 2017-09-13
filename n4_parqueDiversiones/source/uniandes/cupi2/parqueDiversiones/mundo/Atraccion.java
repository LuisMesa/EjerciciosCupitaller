/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_parqueDiversiones
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.parqueDiversiones.mundo;

/**
 * Clase que representa una atracción del parque.
 */
public class Atraccion
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Tipo de atracción infantil.
     */
    public final static String INFANTIL = "Infantil";

    /**
     * Tipo de atracción terror.
     */
    public final static String TERROR = "Terror";

    /**
     * Tipo de atracción acuática.
     */
    public final static String ACUATICA = "Acuática";

    /**
     * Tipo de atracción velocidad.
     */
    public final static String VELOCIDAD = "Velocidad";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Nombre de la atracción.
     */
    // TODO Parte1 PuntoA: Declare el atributo nombre como cadena de texto.
    private String nombre;

    /**
     * Precio de la entrada a la atracción.
     */
    // TODO Parte1 PuntoB: Declare el atributo precio como número real.
    private double precio;

    /**
     * Tipo de atracción.
     */
    // TODO Parte1 PuntoC: Declare el atributo tipo como cadena de texto.
    private String tipo;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva atracción. <br>
     * <b> post: </b> Se inicializaron los atributos nombre, precio y tipo con los valores dados por parámetro.
     * @param pNombre Nombre de la atracción. pNombre != null && pNombre != "".
     * @param pPrecio Precio de la entrada a la atracción.
     * @param pTipo Tipo de atracción. pTipo != null && pTipo != "" && (pTipo == INFANTIL || pTipo == TERROR || pTipo == ACUATICA || pTipo == VELOCIDAD).
     * @throws Exception Si el precio de la atracción dado por parámetro es menor o igual a cero.
     */
    public Atraccion( String pNombre, double pPrecio, String pTipo ) throws Exception
    {
        // TODO Parte1 PuntoD: Complete el método constructor de la clase.
    	if(pPrecio<0)
    		throw new Exception("El precio de la atracción debe ser positivo");
    	
    	nombre = pNombre;
    	precio =pPrecio;
    	tipo = pTipo;

        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:

        // Error si el precio es negativo.
        // Mensaje de error: El precio de la atracción deber ser positivo.
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre de la atracción.
     * @return Nombre de la atracción.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el precio de la entrada de la atracción.
     * @return Precio de la entrada de la atracción.
     */
    public double darPrecio( )
    {
        return precio;
    }

    /**
     * Retorna el tipo de atracción.
     * @return Tipo de atracción.
     */
    public String darTipo( )
    {
        return tipo;
    }
    
    /**
     * Retorna una cadena de texto con el nombre de la atracción.
     */
    public String toString()
    {
        return nombre;
    }
}
