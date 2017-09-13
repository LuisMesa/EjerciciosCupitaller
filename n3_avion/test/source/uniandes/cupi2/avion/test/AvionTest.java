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

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.avion.mundo.Avion;
import uniandes.cupi2.avion.mundo.Pasajero;
import uniandes.cupi2.avion.mundo.Equipaje;
import uniandes.cupi2.avion.mundo.Silla;

/**
 * Clase usada para verificar que los m�todos de la clase Avion est�n correctamente implementados.
 */
public class AvionTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Avion avion;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo avi�n.
     */
    private void setupEscenario1( )
    {
        // Crea el avi�n
        avion = new Avion( );

        Pasajero p1 = new Pasajero( 12345, "Camilo P�rez" );
        Pasajero p2 = new Pasajero( 23456, "Fernando Santander" );

        // Asigna el primer pasajero en una silla ejecutiva de la ventana
        avion.asignarSilla( Silla.CLASE_EJECUTIVA, Silla.VENTANA, 12345, "Camilo P�rez" );

        // Asigna al segundo pasajero en una silla econ�mica del pasillo
        avion.asignarSilla( Silla.CLASE_ECONOMICA, Silla.PASILLO, 23456, "Fernando Santander" );
        Silla sillaPasajero1 = avion.buscarSillaPasajero( 12345 );
        Silla sillaPasajero2 = avion.buscarSillaPasajero( 23456 );
        sillaPasajero1.darPasajero( ).agregarEquipaje( Equipaje.EQUIPAJE_DE_MANO, 111, "d1", 1, 1, 1 );
        sillaPasajero1.darPasajero( ).agregarEquipaje( Equipaje.EQUIPAJE_MUSICAL, 222, "d2", 1, 1, 1 );
        sillaPasajero1.darPasajero( ).agregarEquipaje( Equipaje.EQUIPAJE_DEPORTIVO, 333, "d3", 1, 1, 1 );
        sillaPasajero2.darPasajero( ).agregarEquipaje( Equipaje.EQUIPAJE_ESPECIAL, 444, "d4", 1, 1, 1 );
        sillaPasajero2.darPasajero( ).agregarEquipaje( Equipaje.EQUIPAJE_DE_MANO, 555, "d5", 1, 1, 1 );
        sillaPasajero2.darPasajero( ).agregarEquipaje( Equipaje.EQUIPAJE_MUSICAL, 111, "d6", 1, 1, 1 );

    }

    /**
     * Escenario 2: Construye un nuevo avi�n sin sillas asignadas.
     */
    private void setupEscenario2( )
    {
        // Crea el avi�n
        avion = new Avion( );

        Pasajero p1 = new Pasajero( 12345, "Camilo P�rez" );
        Pasajero p2 = new Pasajero( 23456, "Fernando Santander" );

    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo darPesoTotalEquipajes de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darPesoTotalEquipajes<br>
     * <b> Caso de prueba 1:</b><br>
     * Se calcula el peso total de equipajes dentro del avi�n.<br>
     */
    public void testDarPesoTotalEquipajes( )
    {
        setupEscenario1( );
        assertEquals( "El peso total de los equipajes del avi�n debe ser 1776 Kg.", 1776, avion.darPesoTotalEquipajes( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo darEquipajesPasajero de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darEquipajesPasajero<br>
     * <b> Caso de prueba 1:</b><br>
     * Se obtienen los equipajes del pasajero.<br>
     */
    public void testDarEquipajesPasajero( )
    {
        setupEscenario1( );
        ArrayList equipajesPasajeros = avion.darEquipajesPasajero( 12345 );
        assertEquals( "La cantidad de equipajes del pasajero es 3.", 3, equipajesPasajeros.size( ) );
    }
    /**
     * Prueba 3: Se encarga de verificar el m�todo darEquipajesCategoriaPasajero de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darEquipajesCategoriaPasajero<br>
     * <b> Caso de prueba 1:</b><br>
     * Se calcula el peso total de equipajes dentro del avi�n.<br>
     */
    public void testDarEquipajesCategoriaPasajero( )
    {
        setupEscenario1( );
        ArrayList equipajesPasajeros = avion.darEquipajesCategoriaPasajero( 12345, Equipaje.EQUIPAJE_DE_MANO );
        assertEquals( "La cantidad de equipajes del pasajero es 1.", 1, equipajesPasajeros.size( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el m�todo darEquipajeMasPesado de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darEquipajeMasPesado<br>
     * <b> Caso de prueba 1:</b><br>
     * Se calcula el equipaje m�s pesado del avi�n.<br>
     */
    public void testDarEquipajeMasPesado( )
    {
        setupEscenario1( );
        assertEquals( "El equipaje m�s pesado es 555.0.", 555.0, avion.darEquipajeMasPesado( ).darPeso( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el m�todo asignarSilla de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * asignarSilla<br>
     * buscarSillaPasajero<br>
     * darClase<br>
     * darUbicacion<br>
     * darNumero<br>
     * <b> Caso de prueba 1:</b><br>
     * Se asigna una silla ejecutiva al pasajero.<br>
     */
    public void testAsignarSilla1( )
    {
        setupEscenario2( );
        // Configura los datos de prueba
        Silla sillaP1;

        // Asigna el primer pasajero en una silla ejecutiva de la ventana
        avion.asignarSilla( Silla.CLASE_EJECUTIVA, Silla.VENTANA, 12345, "Clara Mart�nez" );

        sillaP1 = avion.buscarSillaPasajero( 12345 );

        // El pasajero 1 viaja en ejecutivo
        assertEquals( Silla.CLASE_EJECUTIVA, sillaP1.darClase( ) );

        // El pasajero 1 viaja en ventana
        assertEquals( Silla.VENTANA, sillaP1.darUbicacion( ) );

        // La primera silla ejecutiva en ventana es la n�mero 1
        assertEquals( 1, sillaP1.darNumero( ) );

    }

    /**
     * Prueba 6: Se encarga de verificar el m�todo asignarSilla de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * asignarSilla<br>
     * buscarSillaPasajero<br>
     * darClase<br>
     * darUbicacion<br>
     * darNumero<br>
     * <b> Caso de prueba 1:</b><br>
     * Se asigna una silla econ�mica al pasajero.<br>
     */
    public void testAsignarSilla2( )
    {
        setupEscenario2( );
        // Configura los datos de prueba
        Silla sillaP2;
        // Asigna al segundo pasajero en una silla econ�mica del pasillo
        avion.asignarSilla( Silla.CLASE_ECONOMICA, Silla.PASILLO, 23456, "Fernando Santander" );

        sillaP2 = avion.buscarSillaPasajero( 23456 );

        // El pasajero 2 viaja en econ�mica
        assertEquals( Silla.CLASE_ECONOMICA, sillaP2.darClase( ) );

        // El pasajero 2 viaja en pasillo
        assertEquals( Silla.PASILLO, sillaP2.darUbicacion( ) );

        // La primera silla econ�mica en pasillo es la n�mero 11
        assertEquals( 11, sillaP2.darNumero( ) );

    }

    /**
     * Prueba 7: Se encarga de verificar el m�todo buscarSillaDePasajeroEconomico de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarSillaDePasajeroEconomico<br>
     * darNombre<br>
     * darCedula<br>
     * <b> Caso de prueba 1:</b><br>
     * Se busca un pasajero existente con silla econ�mica asignada.<br>
     */
    public void testBuscarSillaDePasajeroEconomico1( )
    {
        // Configura los datos de prueba
        setupEscenario1( );
        Pasajero p;
        Silla s = avion.buscarSillaDePasajeroEconomico( 23456 );

        if( s == null )
        {
            fail( "El pasajero deber�a existir." );
        }
        else
        {
            p = s.darPasajero( );
            assertEquals( 23456, p.darCedula( ) );
            assertEquals( "Fernando Santander", p.darNombre( ) );
        }
    }

    /**
     * Prueba 8: Se encarga de verificar el m�todo buscarSillaDePasajeroEconomico de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarSillaDePasajeroEconomico<br>
     * <b> Caso de prueba 1:</b><br>
     * Se busca un pasajero no existente con silla econ�mica.<br>
     */
    public void testBuscarSillaDePasajeroEconomico2( )
    {
        // Configura los datos de prueba
        setupEscenario1( );

        Silla s = avion.buscarSillaDePasajeroEconomico( 12345 );

        if( s == null )
            assertTrue( true );
        else
        {
            fail( "El pasajero NO deber�a existir" );
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el m�todo buscarSillaDePasajeroEjecutivo de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarSillaDePasajeroEjecutivo<br>
     * darNombre<br>
     * darCedula<br>
     * <b> Caso de prueba 1:</b><br>
     * Se busca un pasajero existente con silla ejecutiva asignada.<br>
     */
    public void testBuscarSillaDePasajeroEjecutivo1( )
    {
        // Configura los datos de prueba
        setupEscenario1( );
        Pasajero p;
        Silla s = avion.buscarSillaDePasajeroEjecutivo( 12345 );

        if( s == null )
            fail( "El pasajero deber�a existir" );
        else
        {
            p = s.darPasajero( );
            assertEquals( 12345, p.darCedula( ) );
            assertEquals( "Camilo P�rez", p.darNombre( ) );
        }
    }

    /**
     * Prueba 10: Se encarga de verificar el m�todo buscarSillaDePasajeroEjecutivo de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarSillaDePasajeroEjecutivo<br>
     * <b> Caso de prueba 1:</b><br>
     * Se busca un pasajero no existente con silla econ�mica.<br>
     */
    public void testBuscarSillaDePasajeroEjecutivo2( )
    {

        // Configura los datos de prueba
        setupEscenario1( );
        Silla s = avion.buscarSillaDePasajeroEjecutivo( 23456 );

        if( s == null )
            assertTrue( true );
        else
        {
            fail( "El pasajero NO deber�a existir" );
        }
    }

    /**
     * Prueba 11: Se encarga de verificar el m�todo buscarSillaEconomicaLibre de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarSillaEconomicaLibre<br>
     * darNumero<br>
     * <b> Caso de prueba 1:</b><br>
     * Se busca una silla econ�mica libre.<br>
     */
    public void testBuscarSillaEconomicaLibre( )
    {
        Silla s;

        // Configura los datos de prueba
        setupEscenario1( );

        // La siguiente silla econ�mica de pasillo libre es la 12
        s = avion.buscarSillaEconomicaLibre( Silla.PASILLO );
        assertEquals( 12, s.darNumero( ) );

        // La siguiente silla econ�mica de ventana libre es la 9
        s = avion.buscarSillaEconomicaLibre( Silla.VENTANA );
        assertEquals( 9, s.darNumero( ) );

        // La siguiente silla econ�mica de central libre es la 10
        s = avion.buscarSillaEconomicaLibre( Silla.PASILLO );
        assertEquals( 12, s.darNumero( ) );
    }

    /**
     * Prueba 12: Se encarga de verificar el m�todo buscarSillaEjecutivaLibre de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarSillaEjecutivaLibre<br>
     * darNumero<br>
     * <b> Caso de prueba 1:</b><br>
     * Se busca una silla ejecutiva libre.<br>
     */
    public void testBuscarSillaEjecutivaLibre( )
    {
        Silla s;

        // Configura los datos de prueba
        setupEscenario1( );

        // La siguiente silla ejecutiva de pasillo libre es la 2
        s = avion.buscarSillaEjecutivaLibre( Silla.PASILLO );
        assertEquals( 2, s.darNumero( ) );

        // La siguiente silla ejecutiva de ventana libre es la 4
        s = avion.buscarSillaEjecutivaLibre( Silla.VENTANA );
        assertEquals( 4, s.darNumero( ) );

    }

    /**
     * Prueba 13: Se encarga de verificar el m�todo calcularPorcentajeOcupacion de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * calcularPorcentajeOcupacion<br>
     * asignarSilla<br>
     * darCedula<br>
     * darNombre<br>
     * <b> Caso de prueba 1:</b><br>
     * Se calcula porcentaje de ocupaci�n del avi�n.<br>
     */
    public void testCalcularPorcentajeOcupacion( )
    {
        double porcentajeEsperado, porcentaje;

        // Configura los datos de prueba
        setupEscenario1( );
        // Crea los pasajeros
        Pasajero p3 = new Pasajero( 34567, "Clara Mart�nez" );

        Pasajero p4 = new Pasajero( 56789, "Sonia Osorio" );

        // inicialmente el porcentaje de ocupaci�n es igual a 2*100/50
        porcentajeEsperado = ( 2 * 100 ) / 50;
        porcentaje = avion.calcularPorcentajeOcupacion( );
        assertEquals( porcentajeEsperado, porcentaje, 0 );

        // Asigno otros dos pasajeros
        avion.asignarSilla( Silla.CLASE_ECONOMICA, Silla.CENTRAL, p3.darCedula( ), p3.darNombre( ) );
        avion.asignarSilla( Silla.CLASE_EJECUTIVA, Silla.VENTANA, p4.darCedula( ), p4.darNombre( ) );

        // Ahora el porcentaje es 4*100/50
        porcentajeEsperado = ( 4 * 100 ) / 50;
        porcentaje = avion.calcularPorcentajeOcupacion( );
        assertEquals( porcentajeEsperado, porcentaje, 0 );
    }

    /**
     * Prueba 14: Se encarga de verificar el m�todo contarSillasEconomicasOcupadas de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * contarSillasEconomicasOcupadas<br>
     * asignarSilla<br>
     * darCedula<br>
     * darNombre<br>
     * <b> Caso de prueba 1:</b><br>
     * Se calcula la cantidad de sillas econ�micas ocupadas en el avi�n.<br>
     */
    public void testContarSillasEconomicasOcupadas( )
    {

        // Configura los datos de prueba
        setupEscenario1( );

        Pasajero p3 = new Pasajero( 34567, "Clara Mart�nez" );

        Pasajero p4 = new Pasajero( 56789, "Sonia Osorio" );
        // Inicialmente las sillas econ�micas ocupadas son 1
        assertEquals( 1, avion.contarSillasEconomicasOcupadas( ) );

        // Asigno otros dos pasajeros
        avion.asignarSilla( Silla.CLASE_ECONOMICA, Silla.CENTRAL, p3.darCedula( ), p3.darNombre( ) );
        avion.asignarSilla( Silla.CLASE_ECONOMICA, Silla.VENTANA, p4.darCedula( ), p4.darNombre( ) );

        // Ahora el numero de sillas ocupadas es 3
        assertEquals( 3, avion.contarSillasEconomicasOcupadas( ) );
    }

    /**
     * Prueba 15: Se encarga de verificar el m�todo contarSillasEjecutivasOcupadas de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * contarSillasEjecutivasOcupadas<br>
     * asignarSilla<br>
     * darCedula<br>
     * darNombre<br>
     * <b> Caso de prueba 1:</b><br>
     * Se calcula la cantidad de sillas ejecutivas ocupadas en el avi�n.<br>
     */
    public void testContarSillasEjecutivasOcupadas( )
    {

        // Configura los datos de prueba
        setupEscenario1( );

        Silla s;

        Pasajero p3 = new Pasajero( 34567, "Clara Mart�nez" );

        Pasajero p4 = new Pasajero( 56789, "Sonia Osorio" );
        // Inicialmente las sillas econ�micas ocupadas son 1
        assertEquals( 1, avion.contarSillasEjecutivasOcupadas( ) );

        // Asigno otros dos pasajeros
        s = avion.asignarSilla( Silla.CLASE_EJECUTIVA, Silla.PASILLO, p3.darCedula( ), p3.darNombre( ) );
        if( s == null )
        {
            fail( "Debi� asignar alguna silla 1" );
        }
        s = avion.asignarSilla( Silla.CLASE_EJECUTIVA, Silla.VENTANA, p4.darCedula( ), p4.darNombre( ) );
        if( s == null )
        {
            fail( "Debi� asignar alguna silla 2" );
        }
        // Ahora el numero de sillas ocupadas es 3
        assertEquals( 3, avion.contarSillasEjecutivasOcupadas( ) );
    }

    /**
     * Prueba 16: Se encarga de verificar el m�todo desasignarSilla de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * desasignarSilla<br>
     * darCedula<br>
     * <b> Caso de prueba 1:</b><br>
     * Se desasigna una silla del avi�n.<br>
     */
    public void testDesasignarSilla( )
    {
        // Configura los datos de prueba
        setupEscenario1( );
        Silla s;
        Pasajero p1 = new Pasajero( 12345, "Clara Mart�nez" );

        avion.desasignarSilla( p1.darCedula( ) );

        // Ya el pasajero no debe estar en el avi�n
        s = avion.buscarSillaPasajero( p1.darCedula( ) );

        if( s == null )
        {
            assertTrue( true );
        }
        else
        {
            fail( "El pasajero no deber�a estar" );
        }
    }

}