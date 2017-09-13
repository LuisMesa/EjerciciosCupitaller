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
package uniandes.cupi2.tiendaLibros.test;

import junit.framework.TestCase;
import uniandes.cupi2.tiendaLibros.mundo.Libro;

/**
 * Clase usada para verificar que los m�todos de la clase Libro est�n correctamente implementados.
 */
public class LibroTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase de pruebas.
     */
    private Libro libro;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo Libro.
     */
    private void setupEscenario1( )
    {
        try
        {
            libro = new Libro( "t�tulo", "isbn", 1000 );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * Libro<br>
     * darTitulo<br>
     * darPrecio<br>
     * darISBN<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el libro, cada uno de los valores corresponde al esperado.<br>
     */
    public void testLibroOK( )
    {
        setupEscenario1( );
        assertNotNull( "El libro deber�a existir.", libro );
        assertEquals( "El t�tulo no corresponde.", "t�tulo", libro.darTitulo( ) );
        assertEquals( "El ISBN no corresponde.", "isbn", libro.darISBN( ) );
        assertEquals( "El precio no corresponde.", 1000, libro.darPrecio( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo constructor de la clase en caso de error.<br>
     * <b> M�todos a probar: </b> <br>
     * Libro<br>
     * <b> Caso de prueba 1:</b><br>
     * No construye el libro porque el precio es negativo y lanza excepci�n.<br>
     */
    public void testLibroError( )
    {
        try
        {
            libro = new Libro( "t�tulo", "isbn", -1000 );
            fail("Deber�a lanzar excepci�n.");
        }
        catch( Exception e )
        {
            assertNull( "El libro no deber�a existir.", libro );
        }
    }


}