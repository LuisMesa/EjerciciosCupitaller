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
package uniandes.cupi2.parqueDiversiones.test;

import junit.framework.TestCase;
import uniandes.cupi2.parqueDiversiones.mundo.Atraccion;

/**
 * Clase usada para verificar que los métodos de la clase Atraccion están correctamente implementados.
 */
public class AtraccionTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Atraccion atraccion;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva Atracción.
     */
    private void setupEscenario1( )
    {
        try
        {
            atraccion = new Atraccion( "atracción", 1000.0, Atraccion.ACUATICA );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * Atraccion<br>
     * darNombre<br>
     * darPrecio<br>
     * darTipo<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente la atracción, cada uno de los valores corresponde al esperado.<br>
     */
    public void testAtraccionOK( )
    {
        setupEscenario1( );
        assertEquals( "Error al inicializar el nombre de la atracción.", "atracción", atraccion.darNombre( ) );
        assertEquals( "Error al inicializar el precio de la atracción.", 1000.0, atraccion.darPrecio( ) );
        assertEquals( "Error al inicializar el tipo de la atracción.", Atraccion.ACUATICA, atraccion.darTipo( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método constructor de la clase en caso de error.<br>
     * <b> Métodos a probar: </b> <br>
     * Atraccion<br>
     * <b> Caso de prueba 1:</b><br>
     * No construye la atracción porque el precio es negativo y lanza excepción.<br>
     */
    public void testAtraccionError( )
    {
        try
        {
            atraccion = new Atraccion( "atracción", -1000.0, Atraccion.ACUATICA );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertNull( "No debería existir la atracción.", atraccion );
        }
    }
    
    /**
     * Prueba 3: Se encarga de verificar el método toString de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * toString<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracción existe.<br>
     */
    public void testToString( )
    {
        setupEscenario1( );
        assertEquals( "El toString no corresponde al nombre de la atracción.", "atracción", atraccion.toString( ) );
    }
}