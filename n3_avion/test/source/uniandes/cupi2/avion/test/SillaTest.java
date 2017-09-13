/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
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
 * Clase usada para verificar que los métodos de la clase Silla estén correctamente implementados.
 */
public class SillaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Silla silla;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva silla.
     */
    private void setupEscenario1( )
    {
        silla = new Silla( 1, silla.CLASE_EJECUTIVA, silla.VENTANA );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
        assertEquals( "El númro de silla debería ser 1.", 1, silla.darNumero( ) );
        assertEquals( "La clase debería ser <CLASE_EJECUTIVA>.", silla.CLASE_EJECUTIVA, silla.darClase( ) );
        assertEquals( "La ubicación debería ser <VENTANA>", silla.VENTANA, silla.darUbicacion( ) );
        assertNull( "El pasajero debería ser null.", silla.darPasajero( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método asignarSilla de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * asignarAPasajero<br>
     * darPasajero<br>
     * <b> Caso de prueba 1:</b><br>
     * Se asigna a un pasajero a la silla.<br>
     */
    public void testAsignarAPasajero( )
    {
        setupEscenario1( );
        silla.asignarAPasajero( 1, "RALK" );
        assertEquals( "El pasajero asignado debería ser <RALK>", "RALK", silla.darPasajero( ).darNombre( ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el método desasignarSilla de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * desasignarSilla<br>
     * <b> Caso de prueba 1:</b><br>
     * Se desasigna al pasajero de la silla.<br>
     */
    public void testdesasignarSilla( )
    {
        setupEscenario1( );
        silla.asignarAPasajero( 1, "RALK" );
        silla.desasignarSilla( );
        assertNull( "El pasajero debería ser null.", silla.darPasajero( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el método sillaAsignada de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * asignarAPasajero<br>
     * sillaAsignada<br>
     * <b> Caso de prueba 1:</b><br>
     * Verifica si la silla está asignada o no.<br>
     */
    public void testSillaAsignada( )
    {
        setupEscenario1( );
        silla.asignarAPasajero( 1, "RALK" );
        assertTrue( "La silla debería estar asignada.", silla.sillaAsignada( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el método sillaAsignada de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * asignarAPasajero<br>
     * sillaAsignada<br>
     * <b> Caso de prueba 1:</b><br>
     * Verifica si la silla está no está asignada por el pasajero dado por parámetro.<br>
     * <b> Caso de prueba 2:</b><br>
     * Verifica si la silla está asignada por el pasajero dado por parámetro.<br>
     */
    public void testSillaAsignadaPasajero( )
    {
        setupEscenario1( );
        silla.asignarAPasajero( 1, "RALK" );
        
        // 1
        assertFalse( "La silla debería estar asignada por el pasajero 2.", silla.sillaAsignadaPasajero( 2 ) );

        // 2
        assertTrue( "La silla debería estar asignada por el pasajero 1.", silla.sillaAsignadaPasajero( 1 ) );
    }

}
