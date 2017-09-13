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
import uniandes.cupi2.parqueDiversiones.mundo.Pasaporte;

/**
 * Clase usada para verificar que los métodos de la clase Pasaporte están correctamente implementados.
 */
public class PasaporteTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Pasaporte pasaporte;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo Pasaporte bronce sin atracciones.
     */
    private void setupEscenario1( )
    {
        pasaporte = new Pasaporte( "Josué", 123456, Pasaporte.BRONCE );
    }

    /**
     * Escenario 2: Construye un nuevo Pasaporte plata con 2 atracciones de velocidad y 1 atracción infantil.
     */
    private void setupEscenario2( )
    {
        pasaporte = new Pasaporte( "Josué", 123456, Pasaporte.PLATA );
        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion1", 1000, Atraccion.VELOCIDAD ) );
            pasaporte.agregarAtraccion( new Atraccion( "atraccion2", 2000, Atraccion.VELOCIDAD ) );
            pasaporte.agregarAtraccion( new Atraccion( "atraccion3", 3000, Atraccion.INFANTIL ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }

    }

    /**
     * Escenario 3: Construye un nuevo Pasaporte oro con 1 atracción de terror.
     */
    private void setupEscenario3( )
    {
        pasaporte = new Pasaporte( "Josué", 123456, Pasaporte.ORO );
        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion1", 1000, Atraccion.TERROR ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }

    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * Pasaporte<br>
     * darNombre<br>
     * darCedula<br>
     * darCategoria<br>
     * darEstado<br>
     * darAtraccionesIncluidas<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el pasaporte, cada uno de los valores corresponde al esperado.<br>
     */
    public void testPasaporte( )
    {
        setupEscenario1( );
        assertEquals( "Error al inicializar el nombre del cliente dueño del pasaporte.", "Josué", pasaporte.darNombreDuenio( ) );
        assertEquals( "Error al inicializar la cédula del cliente dueño del pasaporte.", 123456, pasaporte.darCedulaDuenio( ) );
        assertEquals( "Error al inicializar la categoría del pasaporte.", Pasaporte.BRONCE, pasaporte.darCategoria( ) );
        assertEquals( "Error al inicializar el estado del pasaporte.", Pasaporte.ELABORACION, pasaporte.darEstado( ) );
        assertNotNull( "La lista de atracciones incluidas no debería ser nula.", pasaporte.darAtraccionesIncluidas( ) );
        assertEquals( "La lista de atracciones incluidas no debería tener atracciones.", 0, pasaporte.darAtraccionesIncluidas( ).size( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método existeAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * existeAtraccion<br>
     * <b> Casos de prueba:</b><br>
     * 1) El pasaporte tiene una atracción con el nombre dado. <br>
     * 2) El pasaporte no tiene una atracción con el nombre dado.
     */
    public void testExisteAtraccion( )
    {
        setupEscenario2( );
        // 1
        assertTrue( "Debería ser verdadero que hay una atracción con el nombre dado.", pasaporte.existeAtraccion( "atraccion1" ) );
    
        // 2
        assertFalse( "Debería ser falso que hay una atracción con el nombre dado.", pasaporte.existeAtraccion( "atraccion5" ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el método cuantasAtraccionesTipo de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * cuantasAtraccionesTipo<br>
     * <b> Caso de prueba1:</b><br>
     * El pasaporte tiene 2 atracciones de velocidad y 1 infantil.
     */
    public void testCuantasAtraccionesTipo()
    {
        setupEscenario2( );
        assertEquals( "La cantidad de atracciones tipo velocidad no corresponde.", 2, pasaporte.cuantasAtraccionesTipo( Atraccion.VELOCIDAD ) );
        assertEquals( "La cantidad de atracciones tipo infantil no corresponde.", 1, pasaporte.cuantasAtraccionesTipo( Atraccion.INFANTIL ) );
        assertEquals( "La cantidad de atracciones tipo terror no corresponde.", 0, pasaporte.cuantasAtraccionesTipo( Atraccion.TERROR ) );
        assertEquals( "La cantidad de atracciones tipo acuática no corresponde.", 0, pasaporte.cuantasAtraccionesTipo( Atraccion.ACUATICA ) );
    }
    
    /**
     * Prueba 4: Se encarga de verificar el método calcularPrecio de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularPrecio<br>
     * agregarAtraccion<br>
     * <b> Casos de prueba:</b><br>
     * 1) El pasaporte no tiene atracciones y la categoría es bronce. <br>
     * 2) El pasaporte tiene atracciones y la categoría es bronce.
     */
    public void testCalcularPrecio1( )
    {
        setupEscenario1( );
        // 1
        assertEquals( "El precio calculado debería ser 0.", 0.0, pasaporte.calcularPrecio( ) );
    
        // 2
        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion1", 10000, Atraccion.ACUATICA ) );
            assertEquals( "El precio calculado debería ser 9500.0.", 9500.0, pasaporte.calcularPrecio( ) );
            pasaporte.agregarAtraccion( new Atraccion( "atraccion2", 10000, Atraccion.ACUATICA ) );
            assertEquals( "El precio calculado debería ser 19000.0.", 19000.0, pasaporte.calcularPrecio( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    
    }

    /**
     * Prueba 5: Se encarga de verificar el método calcularPrecio de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularPrecio<br>
     * agregarAtraccion<br>
     * <b> Casos de prueba:</b><br>
     * 1) El pasaporte no tiene atracciones y la categoría es plata. <br>
     * 2) El pasaporte tiene atracciones y la categoría es plata.
     */
    public void testCalcularPrecio2( )
    {
        // 1
        pasaporte = new Pasaporte( "Josué", 123456, Pasaporte.PLATA );
        assertEquals( "El precio calculado debería ser 0.", 0.0, pasaporte.calcularPrecio( ) );
    
        // 2
        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion1", 10000, Atraccion.ACUATICA ) );
            assertEquals( "El precio calculado debería ser 9000.0.", 9000.0, pasaporte.calcularPrecio( ) );
            pasaporte.agregarAtraccion( new Atraccion( "atraccion2", 10000, Atraccion.ACUATICA ) );
            assertEquals( "El precio calculado debería ser 18000.0.", 18000.0, pasaporte.calcularPrecio( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    
    }

    /**
     * Prueba 6: Se encarga de verificar el método calcularPrecio de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularPrecio<br>
     * agregarAtraccion<br>
     * <b> Casos de prueba:</b><br>
     * 1) El pasaporte no tiene atracciones y la categoría es oro. <br>
     * 2) El pasaporte tiene atracciones y la categoría es oro.
     */
    public void testCalcularPrecio3( )
    {
        // 1
        pasaporte = new Pasaporte( "Josué", 123456, Pasaporte.ORO );
        assertEquals( "El precio calculado debería ser 0.", 0.0, pasaporte.calcularPrecio( ) );
    
        // 2
        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion1", 10000, Atraccion.ACUATICA ) );
            assertEquals( "El precio calculado debería ser 8500.0.", 8500.0, pasaporte.calcularPrecio( ) );
            pasaporte.agregarAtraccion( new Atraccion( "atraccion2", 10000, Atraccion.ACUATICA ) );
            assertEquals( "El precio calculado debería ser 17000.0.", 17000.0, pasaporte.calcularPrecio( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    
    }

    /**
     * Prueba 7: Se encarga de verificar el método agregarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAtraccion<br>
     * darAtraccionesIncluidas<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte no tiene atracciones, por lo que se agrega cualquier tipo de atracción, si se agrega infantil no se puede agregar terror.
     */
    public void testAgregarAtraccionOK( )
    {
        setupEscenario1( );
        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion1", 1000, Atraccion.VELOCIDAD ) );
            assertEquals( "La lista de atracciones incluidas debería tener 1 atracción.", 1, pasaporte.darAtraccionesIncluidas( ).size( ) );
            pasaporte.agregarAtraccion( new Atraccion( "atraccion2", 1000, Atraccion.ACUATICA ) );
            assertEquals( "La lista de atracciones incluidas debería tener 2 atracciones.", 2, pasaporte.darAtraccionesIncluidas( ).size( ) );
            pasaporte.agregarAtraccion( new Atraccion( "atraccion3", 1000, Atraccion.INFANTIL ) );
            assertEquals( "La lista de atracciones incluidas debería tener 3 atracciones.", 3, pasaporte.darAtraccionesIncluidas( ).size( ) );
        }
        catch( Exception e )
        {
            e.printStackTrace();fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 8: Se encarga de verificar el método agregarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAtraccion<br>
     * darAtraccionesIncluidas<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte tiene 2 atracciones de velocidad y no se puede agregar otra atracción de velocidad.
     */
    public void testAgregarAtraccionError1( )
    {
        setupEscenario2( );
        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion4", 1000, Atraccion.VELOCIDAD ) );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "La lista de atracciones incluidas debería tener 3 atracciones.", 3, pasaporte.darAtraccionesIncluidas( ).size( ) );
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el método agregarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAtraccion<br>
     * darAtraccionesIncluidas<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte tiene 1 atracción infantil y no se puede agregar una atracción de terror.
     */
    public void testAgregarAtraccionError2( )
    {
        setupEscenario2( );
        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion4", 1000, Atraccion.TERROR ) );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "La lista de atracciones incluidas debería tener 3 atracciones.", 3, pasaporte.darAtraccionesIncluidas( ).size( ) );
        }
    }

    /**
     * Prueba 10: Se encarga de verificar el método agregarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAtraccion<br>
     * darAtraccionesIncluidas<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte tiene 1 atracción de terror y no se puede agregar una atracción infantil.
     */
    public void testAgregarAtraccionError3( )
    {
        setupEscenario3( );
        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion4", 1000, Atraccion.INFANTIL ) );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "La lista de atracciones incluidas debería tener 1 atracción.", 1, pasaporte.darAtraccionesIncluidas( ).size( ) );
        }
    }
    
    /**
     * Prueba 11: Se encarga de verificar el método agregarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAtraccion<br>
     * vender<br>
     * darAtraccionesIncluidas<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte tiene estado VENDIDO.
     */
    public void testAgregarAtraccionError4( )
    {
        setupEscenario2( );
        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion3", 3000, Atraccion.INFANTIL ) );
            pasaporte.agregarAtraccion( new Atraccion( "atraccion3", 3000, Atraccion.INFANTIL ) );
            pasaporte.vender( );
            pasaporte.agregarAtraccion( new Atraccion( "atraccion3", 3000, Atraccion.INFANTIL ) );
        }
        catch( Exception e )
        {
            assertEquals( "La lista de atracciones incluidas debería tener 5 atracciones.", 5, pasaporte.darAtraccionesIncluidas( ).size( ) );
        }
    }

    /**
     * Prueba 12: Se encarga de verificar el método eliminarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAtraccion<br>
     * darAtraccionesIncluidas<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracción que se desea eliminar está en la lista de atracciones incluidas.
     */
    public void testEliminarAtraccionOK( )
    {
        setupEscenario2( );
        try
        {
            pasaporte.eliminarAtraccion( "atraccion2" );
            assertEquals( "La lista de atracciones incluidas debería tener 2 atracciones.", 2, pasaporte.darAtraccionesIncluidas( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 13: Se encarga de verificar el método eliminarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAtraccion<br>
     * darAtraccionesIncluidas<br>
     * <b> Caso de prueba 1:</b><br>
     * La atracción que se desea eliminar no está en la lista de atracciones incluidas.
     */
    public void testEliminarAtraccionError1( )
    {
        setupEscenario2( );
        try
        {
            pasaporte.eliminarAtraccion( "atraccion5" );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "La lista de atracciones incluidas debería tener 3 atracciones.", 3, pasaporte.darAtraccionesIncluidas( ).size( ) );
        }
    }
    
    /**
     * Prueba 14: Se encarga de verificar el método eliminarAtraccion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAtraccion<br>
     * vender<br>
     * darAtraccionesIncluidas<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte tiene estado VENDIDO y no se puede eliminar.
     */
    public void testEliminarAtraccionError2( )
    {
        setupEscenario2( );
        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion3", 3000, Atraccion.INFANTIL ) );
            pasaporte.agregarAtraccion( new Atraccion( "atraccion3", 3000, Atraccion.INFANTIL ) );
            pasaporte.vender( );
            pasaporte.eliminarAtraccion( "atraccion3" );
        }
        catch( Exception e )
        {
            assertEquals( "La lista de atracciones incluidas debería tener 5 atracciones.", 5, pasaporte.darAtraccionesIncluidas( ).size( ) );
        }
    }

    /**
     * Prueba 15: Se encarga de verificar el método vender de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * vender<br>
     * agregarAtraccion<br>
     * darEstado<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte tiene suficientes atracciones para realizar la venta.
     */
    public void testVenderOK( )
    {
        setupEscenario2( );
        // 2
        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion4", 10000, Atraccion.ACUATICA ) );
            pasaporte.agregarAtraccion( new Atraccion( "atraccion5", 10000, Atraccion.ACUATICA ) );
            pasaporte.vender( );
            assertEquals( "El estado debería ser vendido.", Pasaporte.VENDIDO, pasaporte.darEstado( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }

    }

    /**
     * Prueba 16: Se encarga de verificar el método vender de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * vender<br>
     * darEstado<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte no tiene suficientes atracciones para realizar la venta.
     */
    public void testVenderError1( )
    {
        setupEscenario2( );

        try
        {
            pasaporte.vender( );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "El estado debería ser en elaboración.", Pasaporte.ELABORACION, pasaporte.darEstado( ) );
        }

    }

    /**
     * Prueba 17: Se encarga de verificar el método vender de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * vender<br>
     * darEstado<br>
     * <b> Caso de prueba 1:</b><br>
     * El pasaporte tiene suficientes atracciones para realizar la venta, pero el estado es vendido.
     */
    public void testVenderError2( )
    {
        setupEscenario2( );

        try
        {
            pasaporte.agregarAtraccion( new Atraccion( "atraccion4", 10000, Atraccion.ACUATICA ) );
            pasaporte.agregarAtraccion( new Atraccion( "atraccion5", 10000, Atraccion.ACUATICA ) );
            pasaporte.vender( );
            assertEquals( "El estado debería ser vendido.", Pasaporte.VENDIDO, pasaporte.darEstado( ) );
            pasaporte.vender( );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí.
        }

    }

}