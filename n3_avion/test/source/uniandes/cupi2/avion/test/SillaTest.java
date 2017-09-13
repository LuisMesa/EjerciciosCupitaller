/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n3_avion
 * Autor: Equipo Cupi2.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.avion.test;

import uniandes.cupi2.avion.mundo.Pasajero;
import uniandes.cupi2.avion.mundo.Silla;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los m�todos de la clase Silla est�n correctamente implementados.
 */
public class SillaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Silla silla;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva silla.
     */
    private void setupEscenario1( )
    {
        silla = new Silla( 1, silla.CLASE_EJECUTIVA, silla.VENTANA );
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darNumero<br>
     * darClase<br>
     * darUbicacion<br>
     * darPasajero<br>
     * sillaAsignada<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente la silla, cada uno de los valores corresponde al esperado.<br>
     */
    public void testSilla( )
    {
        setupEscenario1( );
        assertEquals( "El n�mro de silla deber�a ser 1.", 1, silla.darNumero( ) );
        assertEquals( "La clase deber�a ser <CLASE_EJECUTIVA>.", silla.CLASE_EJECUTIVA, silla.darClase( ) );
        assertEquals( "La ubicaci�n deber�a ser <VENTANA>", silla.VENTANA, silla.darUbicacion( ) );
        assertNull( "El pasajero deber�a ser null.", silla.darPasajero( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo asignarSilla de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * asignarAPasajero<br>
     * darPasajero<br>
     * <b> Caso de prueba 1:</b><br>
     * Se asigna a un pasajero a la silla.<br>
     */
    public void testAsignarAPasajero( )
    {
        setupEscenario1( );
        silla.asignarAPasajero( 1, "RALK" );
        assertEquals( "El pasajero asignado deber�a ser <RALK>", "RALK", silla.darPasajero( ).darNombre( ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el m�todo desasignarSilla de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * desasignarSilla<br>
     * <b> Caso de prueba 1:</b><br>
     * Se desasigna al pasajero de la silla.<br>
     */
    public void testdesasignarSilla( )
    {
        setupEscenario1( );
        silla.asignarAPasajero( 1, "RALK" );
        silla.desasignarSilla( );
        assertNull( "El pasajero deber�a ser null.", silla.darPasajero( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el m�todo sillaAsignada de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * asignarAPasajero<br>
     * sillaAsignada<br>
     * <b> Caso de prueba 1:</b><br>
     * Verifica si la silla est� asignada o no.<br>
     */
    public void testSillaAsignada( )
    {
        setupEscenario1( );
        silla.asignarAPasajero( 1, "RALK" );
        assertTrue( "La silla deber�a estar asignada.", silla.sillaAsignada( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el m�todo sillaAsignada de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * asignarAPasajero<br>
     * sillaAsignada<br>
     * <b> Caso de prueba 1:</b><br>
     * Verifica si la silla est� no est� asignada por el pasajero dado por par�metro.<br>
     * <b> Caso de prueba 2:</b><br>
     * Verifica si la silla est� asignada por el pasajero dado por par�metro.<br>
     */
    public void testSillaAsignadaPasajero( )
    {
        setupEscenario1( );
        silla.asignarAPasajero( 1, "RALK" );
        
        // 1
        assertFalse( "La silla deber�a estar asignada por el pasajero 2.", silla.sillaAsignadaPasajero( 2 ) );

        // 2
        assertTrue( "La silla deber�a estar asignada por el pasajero 1.", silla.sillaAsignadaPasajero( 1 ) );
    }

}
