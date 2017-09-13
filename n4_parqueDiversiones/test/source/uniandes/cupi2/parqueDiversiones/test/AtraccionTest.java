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
package uniandes.cupi2.parqueDiversiones.test;

import junit.framework.TestCase;
import uniandes.cupi2.parqueDiversiones.mundo.Atraccion;

/**
 * Clase usada para verificar que los m�todos de la clase Atraccion est�n correctamente implementados.
 */
public class AtraccionTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Atraccion atraccion;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva Atracci�n.
     */
    private void setupEscenario1( )
    {
        try
        {
            atraccion = new Atraccion( "atracci�n", 1000.0, Atraccion.ACUATICA );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * Atraccion<br>
     * darNombre<br>
     * darPrecio<br>
     * darTipo<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente la atracci�n, cada uno de los valores corresponde al esperado.<br>
     */
    public void testAtraccionOK( )
    {
        setupEscenario1( );
        assertEquals( "Error al inicializar el nombre de la atracci�n.", "atracci�n", atraccion.darNombre( ) );
        assertEquals( "Error al inicializar el precio de la atracci�n.", 1000.0, atraccion.darPrecio( ) );
        assertEquals( "Error al inicializar el tipo de la atracci�n.", Atraccion.ACUATICA, atraccion.darTipo( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo constructor de la clase en caso de error.<br>
     * <b> M�todos a probar: </b> <br>
     * Atraccion<br>
     * <b> Caso de prueba 1:</b><br>
     * No construye la atracci�n porque el precio es negativo y lanza excepci�n.<br>
     */
    public void testAtraccionError( )
    {
        try
        {
            atraccion = new Atraccion( "atracci�n", -1000.0, Atraccion.ACUATICA );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertNull( "No deber�a existir la atracci�n.", atraccion );
        }
    }
    
    /**
     * Prueba 3: Se encarga de verificar el m�todo toString de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * toString<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracci�n existe.<br>
     */
    public void testToString( )
    {
        setupEscenario1( );
        assertEquals( "El toString no corresponde al nombre de la atracci�n.", "atracci�n", atraccion.toString( ) );
    }
}