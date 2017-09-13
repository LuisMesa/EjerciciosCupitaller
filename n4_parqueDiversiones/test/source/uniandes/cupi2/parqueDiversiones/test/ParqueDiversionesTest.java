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
import uniandes.cupi2.parqueDiversiones.mundo.ParqueDiversiones;
import uniandes.cupi2.parqueDiversiones.mundo.Pasaporte;

/**
 * Clase usada para verificar que los métodos de la clase ParqueDiversiones están correctamente implementados.
 */
public class ParqueDiversionesTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private ParqueDiversiones parqueDiversiones;

    // -----------------------------------------------------------------
    // Métodos
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
            parqueDiversiones.agregarPasaporte( "Germán", 1234, Pasaporte.ORO );
            parqueDiversiones.agregarPasaporte( "Josué", 5678, Pasaporte.BRONCE );
            parqueDiversiones.agregarAtraccion( "atraccion1", 10000, Atraccion.ACUATICA );
            parqueDiversiones.agregarAtraccion( "atraccion2", 15000, Atraccion.VELOCIDAD );
            parqueDiversiones.agregarAtraccion( "atraccion3", 20000, Atraccion.TERROR );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
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
            parqueDiversiones.agregarPasaporte( "Germán", 1234, Pasaporte.ORO );
            parqueDiversiones.agregarPasaporte( "Josué", 5678, Pasaporte.BRONCE );
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
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
        assertNotNull( "Las atracciones no deberías ser nulas.", parqueDiversiones.darAtracciones( ) );
        assertEquals( "Las atracciones no deberían tener elementos.", 0, parqueDiversiones.darAtracciones( ).size( ) );
        assertNotNull( "Los pasaportes no deberías ser nulas.", parqueDiversiones.darPasaportes( ) );
        assertEquals( "Los pasaportes no deberían tener elementos.", 0, parqueDiversiones.darPasaportes( ).size( ) );
        assertEquals( "El dinero en caja debería ser 0.", 0.0, parqueDiversiones.darDineroCaja( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método darPasaportesEnElaboracion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darPasaportesEnElaboracion<br>
     * <b> Caso de prueba 1:</b><br>
     * Existe por lo menos un pasaporte en elaboración.
     */
    public void testDarPasaportesEnElaboracion( )
    {
        setupEscenario2( );
        assertNotNull( "No debería dar una lista nula.", parqueDiversiones.darPasaportesEnElaboracion( ) );
        assertEquals( "La lista debería tener 2 elementos.", 2, parqueDiversiones.darPasaportesEnElaboracion( ).size( ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el método darPasaportesVendidos de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darPasaportesVendidos<br>
     * <b> Caso de prueba 1:</b><br>
     * Existe por lo menos un pasaporte vendido.
     */
    public void testDarPasaportesVendidos( )
    {
        setupEscenario3( );
        assertNotNull( "No debería dar una lista nula.", parqueDiversiones.darPasaportesVendidos( ) );
        assertEquals( "La lista debería tener 1 elemento.", 1, parqueDiversiones.darPasaportesVendidos( ).size( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el método buscarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarAtraccion<br>
     * <b> Casos de prueba:</b><br>
     * 1) La atracción buscada si existe en el parque.<br>
     * 2) La atracción buscada no existe en el parque.<br>
     */
    public void testBuscarAtraccion( )
    {
        setupEscenario2( );

        // 1
        assertNotNull( "Debería encontrar la atracción.", parqueDiversiones.buscarAtraccion( "atraccion1" ) );

        // 2
        assertNull( "No debería encontrar la atracción.", parqueDiversiones.buscarAtraccion( "atraccion4" ) );

    }

    /**
     * Prueba 5: Se encarga de verificar el método buscarPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarPasaporte<br>
     * <b> Casos de prueba:</b><br>
     * 1) El pasaporte existe en el parque. <br>
     * 2) El pasaporte no existe en el parque.
     */
    public void testBuscarPasaporte( )
    {
        setupEscenario2( );

        // 1
        assertNotNull( "El pasaporte debería existir.", parqueDiversiones.buscarPasaporte( 1234 ) );

        // 2
        assertNull( "El pasaporte no debería existir.", parqueDiversiones.buscarPasaporte( 4321 ) );
    }

    /**
     * Prueba 6: Se encarga de verificar el método existeAtraccionPasaportes de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * existeAtraccionPasaportes<br>
     * <b> Casos de prueba:</b><br>
     * 1) La atracción si está en algún pasaporte. <br>
     * 2) La atracción no está en ningún pasaporte.
     */
    public void testExisteAtraccionPasaportes( )
    {
        setupEscenario3( );
        // 1
        assertTrue( "Debería ser verdadero que la atracción está en algún pasaporte.", parqueDiversiones.existeAtraccionPasaportes( "atraccion2" ) );
        assertTrue( "Debería ser verdadero que la atracción está en algún pasaporte.", parqueDiversiones.existeAtraccionPasaportes( "atraccion3" ) );

        // 2
        assertFalse( "Debería ser falso que la atracción está en algún pasaporte.", parqueDiversiones.existeAtraccionPasaportes( "atraccion1" ) );
    }

    /**
     * Prueba 7: Se encarga de verificar el método agregarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAtraccion<br>
     * darAtracciones<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracción es agregada al parque sin ningún problema.
     */
    public void testAgregarAtraccionOK1( )
    {
        setupEscenario1( );
        try
        {
            parqueDiversiones.agregarAtraccion( "atraccion1", 10000, Atraccion.ACUATICA );
            assertEquals( "El tamaño de las atracciones debería ser 1.", 1, parqueDiversiones.darAtracciones( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 8: Se encarga de verificar el método agregarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAtraccion<br>
     * darAtracciones<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracción que se intenta agregar tiene un precio negativo, por lo que lo cambia a positivo pero igualmente agrega la atracción.
     */
    public void testAgregarAtraccionOK2( )
    {
        setupEscenario1( );
        try
        {
            parqueDiversiones.agregarAtraccion( "atraccion1", -10000, Atraccion.ACUATICA );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "El tamaño de las atracciones debería ser 1.", 1, parqueDiversiones.darAtracciones( ).size( ) );
            Atraccion agregada = ( Atraccion )parqueDiversiones.darAtracciones( ).get( 0 );
            assertEquals( "El precio no cambió a positivo.", 10000.0, agregada.darPrecio( ) );
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el método agregarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAtraccion<br>
     * darAtracciones<br>
     * <b> Caso de prueba 1:</b><br>
     * Ya existe una atracción con el nombre de la que se quiere agregar.
     */
    public void testAgregarAtraccionError( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.agregarAtraccion( "atraccion1", 10000, Atraccion.ACUATICA );
            fail( "Debería lanzar excepción" );
        }
        catch( Exception e )
        {
            assertEquals( "El tamaño de las atracciones debería ser 3.", 3, parqueDiversiones.darAtracciones( ).size( ) );
        }
    }

    /**
     * Prueba 10: Se encarga de verificar el método agregarPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
            assertEquals( "El tamaño de la lista de pasaportes debería ser 3.", 3, parqueDiversiones.darPasaportes( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 11: Se encarga de verificar el método agregarPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarPasaporte<br>
     * darPasaportes<br>
     * <b> Caso de prueba 1:</b><br>
     * Ya existe un pasaporte en el parque con la cédula del que se quiere agregar.
     */
    public void testAgregarPasaporteError( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.agregarPasaporte( "Juan", 1234, Pasaporte.PLATA );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "El tamaño de la lista de pasaportes debería ser 2.", 2, parqueDiversiones.darPasaportes( ).size( ) );
        }
    }

    /**
     * Prueba 12: Se encarga de verificar el método agregarAtraccionAPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAtraccionAPasaporte<br>
     * buscarPasaporte<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte y la atracción existen, la atracción cumple las normas.
     */
    public void testAgregarAtraccionAPasaporteOK( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion1", 1234 );
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 1234 );
            assertEquals( "El pasaporte debería tener 1 atracción.", 1, actual.darAtraccionesIncluidas( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 13: Se encarga de verificar el método agregarAtraccionAPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAtraccionAPasaporte<br>
     * buscarPasaporte<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte existe pero la atracción no existe.
     */
    public void testAgregarAtraccionAPasaporteError1( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion4", 1234 );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 1234 );
            assertEquals( "El pasaporte no debería tener atracciones.", 0, actual.darAtraccionesIncluidas( ).size( ) );
        }
    }

    /**
     * Prueba 14: Se encarga de verificar el método agregarAtraccionAPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAtraccionAPasaporte<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracción existe pero el pasaporte no existe.
     */
    public void testAgregarAtraccionAPasaporteError2( )
    {
        setupEscenario2( );
        try
        {
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion2", 6543 );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí.
        }
    }

    /**
     * Prueba 15: Se encarga de verificar el método agregarAtraccionAPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAtraccionAPasaporte<br>
     * buscarPasaporte<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Casos de prueba:</b><br>
     * 1) La atracción a agregar no cumple con la norma de 2 atracciones de velocidad. <br>
     * 2) La atracción a agregar no cumple con la norma de terror e infantil. <br>
     * 3) La atracción a agregar no cumple con la norma de atracción vendida.
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
            assertEquals( "El pasaporte debería tener 3 atracciones.", 3, actual.darAtraccionesIncluidas( ).size( ) );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion2", 5678 );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El pasaporte debería tener 3 atracciones.", 3, actual.darAtraccionesIncluidas( ).size( ) );
        }

        // 2
        try
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El pasaporte debería tener 3 atracciones.", 3, actual.darAtraccionesIncluidas( ).size( ) );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion4", 5678 );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El pasaporte debería tener 3 atracciones.", 3, actual.darAtraccionesIncluidas( ).size( ) );
        }

        // 3
        try
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 1234 );
            assertEquals( "El pasaporte debería tener 5 atracciones.", 5, actual.darAtraccionesIncluidas( ).size( ) );
            parqueDiversiones.agregarAtraccionAPasaporte( "atraccion1", 1234 );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 1234 );
            assertEquals( "El pasaporte debería tener 5 atracciones.", 5, actual.darAtraccionesIncluidas( ).size( ) );
        }

    }

    /**
     * Prueba 16: Se encarga de verificar el método eliminarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAtraccion<br>
     * darAtracciones<br>
     * <b> Caso de prueba 1:</b><br>
     * Elimina la atracción con el nombre dado.
     */
    public void testEliminarAtraccionOK( )
    {
        setupEscenario2( );

        try
        {
            parqueDiversiones.eliminarAtraccion( "atraccion1" );
            assertEquals( "El tamaño de las atracciones debería ser 2.", 2, parqueDiversiones.darAtracciones( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 17: Se encarga de verificar el método eliminarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAtraccion<br>
     * darAtracciones<br>
     * <b> Caso de prueba 1:</b><br>
     * No existe una atracción con el nombre de la atracción que se quiere eliminar.
     */
    public void testEliminarAtraccionError1( )
    {
        setupEscenario2( );

        try
        {
            parqueDiversiones.eliminarAtraccion( "atraccion4" );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "El tamaño de las atracciones debería ser 3.", 3, parqueDiversiones.darAtracciones( ).size( ) );
        }
    }

    /**
     * Prueba 18: Se encarga de verificar el método eliminarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAtraccion<br>
     * darAtracciones<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracción que se desea eliminar está presente en algún pasaporte.
     */
    public void testEliminarAtraccionError2( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.eliminarAtraccion( "atraccion3" );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "El tamaño de las atracciones debería ser 4.", 4, parqueDiversiones.darAtracciones( ).size( ) );
        }
    }

    /**
     * Prueba 19: Se encarga de verificar el método eliminarPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
            assertEquals( "La lista de pasaportes debería tener solo 1 elemento.", 1, parqueDiversiones.darPasaportes( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 20: Se encarga de verificar el método eliminarPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "La lista de pasaportes debería tener 2 elementos.", 2, parqueDiversiones.darPasaportes( ).size( ) );
        }
    }

    /**
     * Prueba 21: Se encarga de verificar el método eliminarPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "La lista de pasaportes debería tener 2 elementos.", 2, parqueDiversiones.darPasaportes( ).size( ) );
        }
    }

    /**
     * Prueba 22: Se encarga de verificar el método eliminarAtraccionDePasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAtraccionDePasaporte<br>
     * buscarPasaporte<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * Se elimina la atracción del pasaporte.
     */
    public void testEliminarAtraccionDePasaporteOK( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.eliminarAtraccionDePasaporte( "atraccion3", 5678 );
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El pasaporte no debería tener atracciones.", 0, actual.darAtraccionesIncluidas( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción" );
        }
    }

    /**
     * Prueba 23: Se encarga de verificar el método eliminarAtraccionDePasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAtraccionDePasaporte<br>
     * buscarPasaporte<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte existe pero la atracción no.
     */
    public void testEliminarAtraccionDePasaporteError1( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.eliminarAtraccionDePasaporte( "atraccion5", 5678 );
            fail( "Debería lanzar excepción" );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El pasaporte debería tener 1 atracción.", 1, actual.darAtraccionesIncluidas( ).size( ) );
        }
    }

    /**
     * Prueba 24: Se encarga de verificar el método eliminarAtraccionDePasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAtraccionDePasaporte<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracción existe pero el pasaporte no.
     */
    public void testEliminarAtraccionDePasaporteError2( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.eliminarAtraccionDePasaporte( "atraccion1", 6543 );
            fail( "Debería lanzar excepción" );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí.
        }
    }

    /**
     * Prueba 25: Se encarga de verificar el método eliminarAtraccionDePasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAtraccionDePasaporte<br>
     * buscarPasaporte<br>
     * darAtraccionesIncluidas (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte del que se quiere eliminar la atracción tiene estado VENDIDO.
     */
    public void testEliminarAtraccionDePasaporteError3( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.eliminarAtraccionDePasaporte( "atraccion2", 1234 );
            fail( "Debería lanzar excepción" );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 1234 );
            assertEquals( "El pasaporte debería tener 5 atracciones.", 5, actual.darAtraccionesIncluidas( ).size( ) );
        }
    }

    /**
     * Prueba 26: Se encarga de verificar el método venderPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
            assertEquals( "El pasaporte debería tener 5 atracciones.", 5, actual.darAtraccionesIncluidas( ).size( ) );
            assertEquals( "El dinero en caja no corresponde.", 171500.0, parqueDiversiones.darDineroCaja( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 27: Se encarga de verificar el método venderPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
            fail( "Debería lanzar excepción" );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí.
        }
    }

    /**
     * Prueba 28: Se encarga de verificar el método venderPasaporte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * venderPasaporte<br>
     * buscarPasaporte<br>
     * darEstado (clase Pasaporte)<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte no cumple con las normas mínimas para ser vendido.
     */
    public void testVenderPasaporteError2( )
    {
        setupEscenario3( );
        try
        {
            parqueDiversiones.venderPasaporte( 5678 );
            fail( "Debería lanzar excepción" );
        }
        catch( Exception e )
        {
            Pasaporte actual = parqueDiversiones.buscarPasaporte( 5678 );
            assertEquals( "El estado del pasaporte debería ser elaboración.", Pasaporte.ELABORACION, actual.darEstado( ) );
        }
    }

}
