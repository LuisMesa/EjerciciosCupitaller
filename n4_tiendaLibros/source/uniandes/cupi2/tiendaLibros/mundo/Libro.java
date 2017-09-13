/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
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
     * T�tulo del libro.
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
    // TODO Parte1 PuntoB: Declare el atributo precio como n�mero entero.
    private int precio;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea el libro con su informaci�n b�sica: t�tulo, ISBN y precio.
     * @param pTitulo T�tulo del libro. pTitulo!= null && pTitulo != "".
     * @param pISBN ISBN del libro. pISBN != null && pISBN != "".
     * @param pPrecio Precio del libro.
     * @throws Exception Si el precio del libro es menor o igual a 0.
     */
    public Libro( String pTitulo, String pISBN, int pPrecio ) throws Exception
    {
     // TODO Parte1 PuntoC: Complete el m�todo constructor de la clase.

        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:

        // Error si el precio es negativo.
        // Mensaje de error: El precio del libro debe ser positivo.
    	if(pPrecio<=0)
    		throw new Exception("El precio del libro deber ser positivo");
    	titulo =pTitulo;
    	isbn = pISBN;
    	precio =pPrecio;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el t�tulo del libro.
     * @return T�tulo del libro.
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