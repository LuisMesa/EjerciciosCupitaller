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

import java.util.ArrayList;

import uniandes.cupi2.avion.mundo.Pasajero;
import uniandes.cupi2.avion.mundo.Equipaje;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los métodos de la clase Pasajero estén correctamente implementados.
 */
public class PasajeroTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Pasajero pasajero;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea un pasajero sin equipajes.
     */
    private void setupEscenario1( )
    {
        pasajero = new Pasajero( 123456, "Radamel Falcao" );
    }

    /**
     * Escenario 2: Crea un pasajero con equipajes.
     */
    private void setupEscenario2( )
    {
        pasajero = new Pasajero( 123456, "Radamel Falcao" );
        pasajero.agregarEquipaje( Equipaje.EQUIPAJE_DE_MANO, 111, "d1", 1, 1, 1 );
        pasajero.agregarEquipaje( Equipaje.EQUIPAJE_MUSICAL, 222, "d2", 1, 1, 1 );
        pasajero.agregarEquipaje( Equipaje.EQUIPAJE_DEPORTIVO, 333, "d3", 1, 1, 1 );
        pasajero.agregarEquipaje( Equipaje.EQUIPAJE_ESPECIAL, 444, "d4", 1, 1, 1 );
        pasajero.agregarEquipaje( Equipaje.EQUIPAJE_DE_MANO, 555, "d5", 1, 1, 1 );
        pasajero.agregarEquipaje( Equipaje.EQUIPAJE_MUSICAL, 111, "d6", 1, 1, 1 );
    }

    /**
     * Escenario 3: Crea un pasajero con equipajes.
     */
    private void setupEscenario3( )
    {
        pasajero = new Pasajero( 123456, "Radamel Falcao" );
        pasajero.agregarEquipaje( Equipaje.EQUIPAJE_DE_MANO, 111, "d1", 1, 1, 1 );
        pasajero.agregarEquipaje( Equipaje.EQUIPAJE_MUSICAL, 222, "d2", 1, 1, 1 );
        pasajero.agregarEquipaje( Equipaje.EQUIPAJE_DEPORTIVO, 333, "d3", 1, 1, 1 );
        pasajero.agregarEquipaje( Equipaje.EQUIPAJE_ESPECIAL, 444, "d4", 1, 1, 1 );
        pasajero.agregarEquipaje( Equipaje.EQUIPAJE_DE_MANO, 678, "d5", 1, 1, 1 );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darNombre<br>
     * darCedula<br>
     * darEquipajes<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente al pasajero, cada uno de los valores corresponde al esperado.<br>
     */
    public void testPasajero( )
    {
        setupEscenario1( );
        assertEquals( "El nombre debería ser Radamel Falcao.", "Radamel Falcao", pasajero.darNombre( ) );
        assertEquals( "La cédula debería ser 123456.", 123456, pasajero.darCedula( ) );
        assertNotNull( "No debería ser nulo.", pasajero.darEquipajes( ) );
        assertEquals( "La lista no debería tener nada.", 0, pasajero.darEquipajes( ).size( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método agregarEquipaje de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarEquipaje<br>
     * darEquipajes<br>
     * <b> Caso de prueba 1:</b><br>
     * Se agrega un equipaje al pasajero.<br>
     */
    public void testAgregarEquipaje( )
    {
        setupEscenario1( );
        assertEquals( "La lista no debería tener nada.", 0, pasajero.darEquipajes( ).size( ) );
        pasajero.agregarEquipaje( Equipaje.EQUIPAJE_DE_MANO, 111, "d1", 1, 1, 1 );
        assertEquals( "La lista debería ser tamaño 1.", 1, pasajero.darEquipajes( ).size( ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el método darPesoTotalEquipajes de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarEquipaje<br>
     * darEquipajes<br>
     * <b> Caso de prueba 1:</b><br>
     * Pasajeros sin equipajes.<br>
     * <b> Caso de prueba 2:</b><br>
     * Pasajeros con equipajes.<br>
     */
    public void testDarPesoTotalEquipajes( )
    {
        setupEscenario1( );
        assertEquals( "El peso debería ser 0 Kg.", 0, pasajero.darPesoTotalEquipajes( ) );

        setupEscenario2( );
        assertEquals( "El peso debería ser 1776 Kg.", 1776, pasajero.darPesoTotalEquipajes( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el método darEquipajesCategoria de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darEquipajesCategoria<br>
     * <b> Caso de prueba 1:</b><br>
     * Pasajeros con equipajes.<br>
     */
    public void testDarEquipajesCategoria( )
    {
        setupEscenario2( );
        ArrayList lista1 = pasajero.darEquipajesCategoria( Equipaje.EQUIPAJE_DE_MANO );
        ArrayList lista2 = pasajero.darEquipajesCategoria( Equipaje.EQUIPAJE_MUSICAL );
        ArrayList lista3 = pasajero.darEquipajesCategoria( Equipaje.EQUIPAJE_DEPORTIVO );
        ArrayList lista4 = pasajero.darEquipajesCategoria( Equipaje.EQUIPAJE_ESPECIAL );

        assertEquals( "El tamaño de la lista debería ser 2.", 2, lista1.size( ) );
        assertEquals( "El tamaño de la lista debería ser 2.", 2, lista2.size( ) );
        assertEquals( "El tamaño de la lista debería ser 1.", 1, lista3.size( ) );
        assertEquals( "El tamaño de la lista debería ser 1.", 1, lista4.size( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el método darEquipajeMasPesado de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darEquipajeMasPesado<br>
     * <b> Caso de prueba 1:</b><br>
     * Pasajeros con equipajes.<br>
     */
    public void testDarEquipajeMasPesado( )
    {
        setupEscenario2( );
        assertEquals( "El peso del equipaje más pesado debe ser 555.0 Kg.", 555.0, pasajero.darEquipajeMasPesado( ).darPeso( ) );
    }

}
