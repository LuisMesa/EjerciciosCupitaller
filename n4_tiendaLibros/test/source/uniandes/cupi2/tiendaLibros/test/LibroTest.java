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
package uniandes.cupi2.tiendaLibros.test;

import junit.framework.TestCase;
import uniandes.cupi2.tiendaLibros.mundo.Libro;

/**
 * Clase usada para verificar que los métodos de la clase Libro estén correctamente implementados.
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
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo Libro.
     */
    private void setupEscenario1( )
    {
        try
        {
            libro = new Libro( "título", "isbn", 1000 );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
        assertNotNull( "El libro debería existir.", libro );
        assertEquals( "El título no corresponde.", "título", libro.darTitulo( ) );
        assertEquals( "El ISBN no corresponde.", "isbn", libro.darISBN( ) );
        assertEquals( "El precio no corresponde.", 1000, libro.darPrecio( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método constructor de la clase en caso de error.<br>
     * <b> Métodos a probar: </b> <br>
     * Libro<br>
     * <b> Caso de prueba 1:</b><br>
     * No construye el libro porque el precio es negativo y lanza excepción.<br>
     */
    public void testLibroError( )
    {
        try
        {
            libro = new Libro( "título", "isbn", -1000 );
            fail("Debería lanzar excepción.");
        }
        catch( Exception e )
        {
            assertNull( "El libro no debería existir.", libro );
        }
    }


}