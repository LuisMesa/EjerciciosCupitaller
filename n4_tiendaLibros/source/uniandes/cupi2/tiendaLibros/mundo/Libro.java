/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n4_tiendaLibros
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.tiendaLibros.mundo;

/**
 * Clase que representa un libro.
 */
public class Libro
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Título del libro.
     */
    private String titulo;

    /**
     * ISBN del libro.
     */
    // TODO Parte1 PuntoA: Declare el atributo ISBN como cadena de texto.
    private String isbn;

    /**
     * Precio del libro.
     */
    // TODO Parte1 PuntoB: Declare el atributo precio como número entero.
    private int precio;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea el libro con su información básica: título, ISBN y precio.
     * @param pTitulo Título del libro. pTitulo!= null && pTitulo != "".
     * @param pISBN ISBN del libro. pISBN != null && pISBN != "".
     * @param pPrecio Precio del libro.
     * @throws Exception Si el precio del libro es menor o igual a 0.
     */
    public Libro( String pTitulo, String pISBN, int pPrecio ) throws Exception
    {
     // TODO Parte1 PuntoC: Complete el método constructor de la clase.

        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:

        // Error si el precio es negativo.
        // Mensaje de error: El precio del libro debe ser positivo.
    	if(pPrecio<=0)
    		throw new Exception("El precio del libro deber ser positivo");
    	titulo =pTitulo;
    	isbn = pISBN;
    	precio =pPrecio;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el título del libro.
     * @return Título del libro.
     */
    public String darTitulo( )
    {
        return titulo;
    }

    /**
     * Retorna el ISBN del libro.
     * @return ISBN del libro.
     */
    public String darISBN( )
    {
        return isbn;
    }

    /**
     * Retorna el precio del libro.
     * @return Precio del libro.
     */
    public int darPrecio( )
    {
        return precio;
    }

}