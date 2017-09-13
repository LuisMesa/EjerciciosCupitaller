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
import uniandes.cupi2.parqueDiversiones.mundo.ParqueDiversiones;
import uniandes.cupi2.parqueDiversiones.mundo.Pasaporte;

/**
 * Clase usada para verificar que los m�todos de la clase ParqueDiversiones est�n correctamente implementados.
 */
public class ParqueDiversionesTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private ParqueDiversiones parqueDiversiones;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo ParqueDiversiones sin atracciones y sin pasaportes.
     */
    private void setupEscenario1( )
    {
        parqueDiversiones = new ParqueDiversiones( );
    }

    /**
     * Escenario 2: Construye un nuevo ParqueDiversiones con 2 pasaportes y 3 atracciones.
     */
    private void setupEscenario2( )
    {
        parqueDiversiones = new ParqueDiversiones( );
        try
        {
            parqueDiversiones.agregarPasaporte( "Germ�n", 1234, Pasaporte.ORO );
            parqueDiversiones.agregarPasaporte( "Josu�", 5678, Pasaporte.BRONCE );
            parqueDiversiones.agregarAtraccion( "atraccion1", 10000, Atraccion.ACUATICA );
            parqueDiversiones.agregarAtraccion( "atraccion2", 15000, Atraccion.VELOCIDAD );
            parqueDiversiones.agregarAtraccion( "atraccion3", 20000, Atraccion.TERROR );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Escenario 3: Construye un nuevo ParqueDiversiones con 2 pasaportes y 3 atracciones. Los pasaportes tienen atracciones.
     */
    private void setupEscenario3( )
    {
        parqueDiversiones = new ParqueDiversiones( );
        try
        {
            parqueDiversiones.agregarPasaporte( "Germ�n", 1234, Pasaporte.ORO );
            parqueDiversiones.agregarPasaporte( "Josu�", 5678, Pasaporte.BRONCE );
            parqueDiversiones.agregarAtraccion( "atraccion1", 10000, Atraccion.ACUATICA );
            parqueDiversiones.agregarAtraccion( "atraccion2", 15000, Atraccion.VELOCIDAD );
            parqueDiversiones.agregarAtraccion( "atraccion3", 20000, Atraccion.TERROR );
            parqueDiversiones.agregarAtraccion( "atraccion4", 25000, Atraccion.INFANTIL );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion2", 1234 );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion2", 1234 );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion3", 1234 );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion3", 1234 );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion3", 1234 );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion3", 5678 );
            parqueDiversiones.venderPasaporte( 1234 );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * ParqueDiversiones<br>
     * darAtracciones<br>
     * darPasaportes<br>
     * darDineroCaja<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el parque de diversiones, cada uno de los valores corresponde al esperado.<br>
     */
    public void testParqueDiversiones( )
    {
        setupEscenario1( );
        assertNotNull( "Las atracciones no deber�as ser nulas.", parqueDiversiones.darAtracciones( ) );
        assertEquals( "Las atracciones no deber�an tener elementos.", 0, parqueDiversiones.darAtracciones( ).size( ) );
        assertNotNull( "Los pasaportes no deber�as ser nulas.", parqueDiversiones.darPasaportes( ) );
        assertEquals( "Los pasaportes no deber�an tener elementos.", 0, parqueDiversiones.darPasaportes( ).size( ) );
        assertEquals( "El dinero en caja deber�a ser 0.", 0.0, parqueDiversiones.darDineroCaja( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo darPasaportesEnElaboracion de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darPasaportesEnElaboracion<br>
     * <b> Caso de prueba 1:</b><br>
     * Existe por lo menos un pasaporte en elaboraci�n.
     */
    public void testDarPasaportesEnElaboracion( )
    {
        setupEscenario2( );
        assertNotNull( "No deber�a dar una lista nula.", parqueDiversiones.darPasaportesEnElaboracion( ) );
        assertEquals( "La lista deber�a tener 2 elementos.", 2, parqueDiversiones.darPasaportesEnElaboracion( ).size( ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el m�todo darPasaportesVendidos de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darPasaportesVendidos<br>
     * <b> Caso de prueba 1:</b><br>
     * Existe por lo menos un pasaporte vendido.
     */
    public void testDarPasaportesVendidos( )
    {
        setupEscenario3( );
        assertNotNull( "No deber�a dar una lista nula.", parqueDiversiones.darPasaportesVendidos( ) );
        assertEquals( "La lista deber�a tener 1 elemento.", 1, parqueDiversiones.darPasaportesVendidos( ).size( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el m�todo buscarAtraccion de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarAtraccion<br>
     * <b> Casos de prueba:</b><br>
     * 1) La atracci�n buscada si existe en el parque.<br>
     * 2) La atracci�n buscada no existe en el parque.<br>
     */
    public void testBuscarAtraccion( )
    {
        setupEscenario2( );

        // 1
        assertNotNull( "Deber�a encontrar la atracci�n.", parqueDiversiones.buscarAtraccion( "atraccion1" ) );

        // 2
        assertNull( "No deber�a encontrar la atracci�n.", parqueDiversiones.buscarAtraccion( "atraccion4" ) );

    }

    /**
     * Prueba 5: Se encarga de verificar el m�todo buscarPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarPasaporte<br>
     * <b> Casos de prueba:</b><br>
     * 1) El pasaporte existe en el parque. <br>
     * 2) El pasaporte no existe en el parque.
     */
    public void testBuscarPasaporte( )
    {
        setupEscenario2( );

        // 1
        assertNotNull( "El pasaporte deber�a existir.", parqueDiversiones.buscarPasaporte( 1234 ) );

        // 2
        assertNull( "El pasaporte no deber�a existir.", parqueDiversiones.buscarPasaporte( 4321 ) );
    }

    /**
     * Prueba 6: Se encarga de verificar el m�todo existeAtraccionPasaportes de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * existeAtraccionPasaportes<br>
     * <b> Casos de prueba:</b><br>
     * 1) La atracci�n si est� en alg�n pasaporte. <br>
     * 2) La atracci�n no est� en ning�n pasaporte.
     */
    public void testExisteAtraccionPasaportes( )
    {
        setupEscenario3( );
        // 1
        assertTrue( "Deber�a ser verdadero que la atracci�n est� en alg�n pasaporte.", parqueDiversiones.existeAtraccionPasaportes( "atraccion2" ) );
        assertTrue( "Deber�a ser verdadero que la atracci�n est� en alg�n pasaporte.", parqueDiversiones.existeAtraccionPasaportes( "atraccion3" ) );

        // 2
        assertFalse( "Deber�a ser falso que la atracci�n est� en alg�n pasaporte.", parqueDiversiones.existeAtraccionPasaportes( "atraccion1" ) );
    }

    /**
     * Prueba 7: Se encarga de verificar el m�todo agregarAtraccion de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarAtraccion<br>
     * darAtracciones<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracci�n es agregada al parque sin ning�n problema.
     */
    public void testAgregarAtraccionOK1( )
    {
        setupEscenario1( );
        try
        {
            parqueDiversiones.agregarAtraccion( "atraccion1", 10000, Atraccion.ACUATICA );
            assertEquals( "El tama�o de las atracciones deber�a ser 1.", 1, parqueDiversiones.darAtracciones( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 8: Se encarga de verificar el m�todo agregarAtraccion de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarAtraccion<br>
     * darAtracciones<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracci�n que se intenta agregar tiene un precio negativo, por lo que lo cambia a positivo pero igualmente agrega la atracci�n.
     */
    public void testAgregarAtraccionOK2( )
    {
        setupEscenario1( );
        try
        {
            parqueDiversiones.agregarAtraccion( "atraccion1", -10000, Atraccion.ACUATICA );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "El tama�o de las atracciones deber�a ser 1.", 1, parqueDiversiones.darAtracciones( ).size( ) );
            Atraccion agregada = ( Atraccion )parqueDiversiones.darAtracciones( ).get( 0 );
            assertEquals( "El precio no cambi� a positivo.", 10000.0, agregada.darPrecio( ) );
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el m�todo agregarAtraccion de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarAtraccion<br>
     * darAtracciones<br>
     * <b> Caso de prueba 1:</b><br>
     * Ya existe una atracci�n con el nombre de la que se quiere agregar.
     */
    public void testAgregarAtraccionError( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.agregarAtraccion( "atraccion1", 10000, Atraccion.ACUATICA );
            fail( "Deber�a lanzar excepci�n" );
        }
        catch( Exception e )
        {
            assertEquals( "El tama�o de las atracciones deber�a ser 3.", 3, parqueDiversiones.darAtracciones( ).size( ) );
        }
    }

    /**
     * Prueba 10: Se encarga de verificar el m�todo agregarPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarPasaporte<br>
     * darPasaportes<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte que se quiere agregar no existe en el parque.
     */
    public void testAgregarPasaporteOK( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.agregarPasaporte( "Juan", 9876, Pasaporte.PLATA );
            assertEquals( "El tama�o de la lista de pasaportes deber�a ser 3.", 3, parqueDiversiones.darPasaportes( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 11: Se encarga de verificar el m�todo agregarPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarPasaporte<br>
     * darPasaportes<br>
     * <b> Caso de prueba 1:</b><br>
     * Ya existe un pasaporte en el parque con la c�dula del que se quiere agregar.
     */
    public void testAgregarPasaporteError( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.agregarPasaporte( "Juan", 1234, Pasaporte.PLATA );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "El tama�o de la lista de pasaportes deber�a ser 2.", 2, parqueDiversiones.darPasaportes( ).size( ) );
        }
    }

    /**
     * Prueba 12: Se encarga de verificar el m�todo agregarAtraccionAPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarAtraccionAPasaporte<br>
     * buscarPasaporte<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte y la atracci�n existen, la atracci�n cumple las normas.
     */
    public void testAgregarAtraccionAPasaporteOK( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion1", 1234 );
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 1234 );
            assertEquals( "El pasaporte deber�a tener 1 atracci�n.", 1, actual.darAtraccionesIncluidas( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 13: Se encarga de verificar el m�todo agregarAtraccionAPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarAtraccionAPasaporte<br>
     * buscarPasaporte<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte existe pero la atracci�n no existe.
     */
    public void testAgregarAtraccionAPasaporteError1( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion4", 1234 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 1234 );
            assertEquals( "El pasaporte no deber�a tener atracciones.", 0, actual.darAtraccionesIncluidas( ).size( ) );
        }
    }

    /**
     * Prueba 14: Se encarga de verificar el m�todo agregarAtraccionAPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarAtraccionAPasaporte<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracci�n existe pero el pasaporte no existe.
     */
    public void testAgregarAtraccionAPasaporteError2( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion2", 6543 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�.
        }
    }

    /**
     * Prueba 15: Se encarga de verificar el m�todo agregarAtraccionAPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarAtraccionAPasaporte<br>
     * buscarPasaporte<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Casos de prueba:</b><br>
     * 1) La atracci�n a agregar no cumple con la norma de 2 atracciones de velocidad. <br>
     * 2) La atracci�n a agregar no cumple con la norma de terror e infantil. <br>
     * 3) La atracci�n a agregar no cumple con la norma de atracci�n vendida.
     */
    public void testAgregarAtraccionAPasaporteError3( )
    {
        setupEscenario3( );
        // 1
        try
        {
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion2", 5678 );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion2", 5678 );
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El pasaporte deber�a tener 3 atracciones.", 3, actual.darAtraccionesIncluidas( ).size( ) );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion2", 5678 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El pasaporte deber�a tener 3 atracciones.", 3, actual.darAtraccionesIncluidas( ).size( ) );
        }

        // 2
        try
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El pasaporte deber�a tener 3 atracciones.", 3, actual.darAtraccionesIncluidas( ).size( ) );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion4", 5678 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El pasaporte deber�a tener 3 atracciones.", 3, actual.darAtraccionesIncluidas( ).size( ) );
        }

        // 3
        try
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 1234 );
            assertEquals( "El pasaporte deber�a tener 5 atracciones.", 5, actual.darAtraccionesIncluidas( ).size( ) );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion1", 1234 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 1234 );
            assertEquals( "El pasaporte deber�a tener 5 atracciones.", 5, actual.darAtraccionesIncluidas( ).size( ) );
        }

    }

    /**
     * Prueba 16: Se encarga de verificar el m�todo eliminarAtraccion de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarAtraccion<br>
     * darAtracciones<br>
     * <b> Caso de prueba 1:</b><br>
     * Elimina la atracci�n con el nombre dado.
     */
    public void testEliminarAtraccionOK( )
    {
        setupEscenario2( );

        try
        {
            parqueDiversiones.eliminarAtraccion( "atraccion1" );
            assertEquals( "El tama�o de las atracciones deber�a ser 2.", 2, parqueDiversiones.darAtracciones( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 17: Se encarga de verificar el m�todo eliminarAtraccion de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarAtraccion<br>
     * darAtracciones<br>
     * <b> Caso de prueba 1:</b><br>
     * No existe una atracci�n con el nombre de la atracci�n que se quiere eliminar.
     */
    public void testEliminarAtraccionError1( )
    {
        setupEscenario2( );

        try
        {
            parqueDiversiones.eliminarAtraccion( "atraccion4" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "El tama�o de las atracciones deber�a ser 3.", 3, parqueDiversiones.darAtracciones( ).size( ) );
        }
    }

    /**
     * Prueba 18: Se encarga de verificar el m�todo eliminarAtraccion de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarAtraccion<br>
     * darAtracciones<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracci�n que se desea eliminar est� presente en alg�n pasaporte.
     */
    public void testEliminarAtraccionError2( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.eliminarAtraccion( "atraccion3" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "El tama�o de las atracciones deber�a ser 4.", 4, parqueDiversiones.darAtracciones( ).size( ) );
        }
    }

    /**
     * Prueba 19: Se encarga de verificar el m�todo eliminarPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarPasaporte<br>
     * darPasaportes<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte que se quiere eliminar existe y no tiene atracciones.
     */
    public void testEliminarPasaporteOK( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.eliminarPasaporte( 5678 );
            assertEquals( "La lista de pasaportes deber�a tener solo 1 elemento.", 1, parqueDiversiones.darPasaportes( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 20: Se encarga de verificar el m�todo eliminarPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarPasaporte<br>
     * darPasaportes<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte que se quiere eliminar no existe.
     */
    public void testEliminarPasaporteError1( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.eliminarPasaporte( 9876 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "La lista de pasaportes deber�a tener 2 elementos.", 2, parqueDiversiones.darPasaportes( ).size( ) );
        }
    }

    /**
     * Prueba 21: Se encarga de verificar el m�todo eliminarPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarPasaporte<br>
     * darPasaportes<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte que se quiere eliminar tiene estado VENDIDO.
     */
    public void testEliminarPasaporteError2( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.eliminarPasaporte( 1234 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "La lista de pasaportes deber�a tener 2 elementos.", 2, parqueDiversiones.darPasaportes( ).size( ) );
        }
    }

    /**
     * Prueba 22: Se encarga de verificar el m�todo eliminarAtraccionDePasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarAtraccionDePasaporte<br>
     * buscarPasaporte<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * Se elimina la atracci�n del pasaporte.
     */
    public void testEliminarAtraccionDePasaporteOK( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.eliminarAtraccionDePasaporte( "atraccion3", 5678 );
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El pasaporte no deber�a tener atracciones.", 0, actual.darAtraccionesIncluidas( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n" );
        }
    }

    /**
     * Prueba 23: Se encarga de verificar el m�todo eliminarAtraccionDePasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarAtraccionDePasaporte<br>
     * buscarPasaporte<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte existe pero la atracci�n no.
     */
    public void testEliminarAtraccionDePasaporteError1( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.eliminarAtraccionDePasaporte( "atraccion5", 5678 );
            fail( "Deber�a lanzar excepci�n" );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El pasaporte deber�a tener 1 atracci�n.", 1, actual.darAtraccionesIncluidas( ).size( ) );
        }
    }

    /**
     * Prueba 24: Se encarga de verificar el m�todo eliminarAtraccionDePasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarAtraccionDePasaporte<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracci�n existe pero el pasaporte no.
     */
    public void testEliminarAtraccionDePasaporteError2( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.eliminarAtraccionDePasaporte( "atraccion1", 6543 );
            fail( "Deber�a lanzar excepci�n" );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�.
        }
    }

    /**
     * Prueba 25: Se encarga de verificar el m�todo eliminarAtraccionDePasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarAtraccionDePasaporte<br>
     * buscarPasaporte<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte del que se quiere eliminar la atracci�n tiene estado VENDIDO.
     */
    public void testEliminarAtraccionDePasaporteError3( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.eliminarAtraccionDePasaporte( "atraccion2", 1234 );
            fail( "Deber�a lanzar excepci�n" );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 1234 );
            assertEquals( "El pasaporte deber�a tener 5 atracciones.", 5, actual.darAtraccionesIncluidas( ).size( ) );
        }
    }

    /**
     * Prueba 26: Se encarga de verificar el m�todo venderPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * venderPasaporte<br>
     * buscarPasaporte<br>
     * darDineroCaja<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * Se realiza la venta del pasaporte.
     */
    public void testVenderPasaporteOK( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion3", 5678 );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion3", 5678 );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion3", 5678 );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion3", 5678 );
            parqueDiversiones.venderPasaporte( 5678 );
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El pasaporte deber�a tener 5 atracciones.", 5, actual.darAtraccionesIncluidas( ).size( ) );
            assertEquals( "El dinero en caja no corresponde.", 171500.0, parqueDiversiones.darDineroCaja( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 27: Se encarga de verificar el m�todo venderPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * venderPasaporte<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte que quiere ser vendido no existe.
     */
    public void testVenderPasaporteError1( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.venderPasaporte( 6543 );
            fail( "Deber�a lanzar excepci�n" );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�.
        }
    }

    /**
     * Prueba 28: Se encarga de verificar el m�todo venderPasaporte de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * venderPasaporte<br>
     * buscarPasaporte<br>
     * darEstado (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte no cumple con las normas m�nimas para ser vendido.
     */
    public void testVenderPasaporteError2( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.venderPasaporte( 5678 );
            fail( "Deber�a lanzar excepci�n" );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El estado del pasaporte deber�a ser elaboraci�n.", Pasaporte.ELABORACION, actual.darEstado( ) );
        }
    }

}
