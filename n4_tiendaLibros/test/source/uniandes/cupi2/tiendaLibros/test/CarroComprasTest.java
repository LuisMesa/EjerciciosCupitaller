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
import uniandes.cupi2.tiendaLibros.mundo.CarroCompras;
import uniandes.cupi2.tiendaLibros.mundo.Libro;

/**
 * Clase usada para verificar que los métodos de la clase CarroCompras estén correctamente implementados.
 */
public class CarroComprasTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase de pruebas.
     */
    private CarroCompras carroCompras;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo CarroCompras vacío.
     */
    private void setupEscenario1( )
    {
        carroCompras = new CarroCompras( "nombre", "12345" );
    }

    /**
     * Escenario 2: Construye un nuevo CarroCompras con items de compra y estado en elaboración.
     */
    private void setupEscenario2( )
    {
        carroCompras = new CarroCompras( "nombre", "12345" );
        try
        {
            Libro libro1 = new Libro( "titulo1", "isbn1", 1000 );
            Libro libro2 = new Libro( "titulo2", "isbn2", 2000 );
            Libro libro3 = new Libro( "titulo3", "isbn3", 3000 );
            carroCompras.agregarItemCompra( libro1, 11 );
            carroCompras.agregarItemCompra( libro2, 5 );
            carroCompras.agregarItemCompra( libro3, 7 );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }

    }

    /**
     * Escenario 3: Construye un nuevo CarroCompras con items de compra y estado vendido.
     */
    private void setupEscenario3( )
    {
        carroCompras = new CarroCompras( "nombre", "12345" );
        try
        {
            Libro libro1 = new Libro( "titulo1", "isbn1", 1000 );
            Libro libro2 = new Libro( "titulo2", "isbn2", 2000 );
            Libro libro3 = new Libro( "titulo3", "isbn3", 3000 );
            Libro libro4 = new Libro( "titulo4", "isbn4", 4000 );
            Libro libro5 = new Libro( "titulo5", "isbn5", 5000 );
            carroCompras.agregarItemCompra( libro1, 11 );
            carroCompras.agregarItemCompra( libro2, 5 );
            carroCompras.agregarItemCompra( libro3, 7 );
            carroCompras.agregarItemCompra( libro4, 10 );
            carroCompras.agregarItemCompra( libro5, 2 );
            carroCompras.vender( );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * CarroCompras<br>
     * darNombreDuenio<br>
     * darCedulaDuenio<br>
     * darEstado<br>
     * darItemsCompra<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el libro, cada uno de los valores corresponde al esperado.<br>
     */
    public void testCarroCompras( )
    {
        setupEscenario1( );

        assertNotNull( "El carro no debería ser nulo.", carroCompras );
        assertEquals( "El nombre del dueño no corresponde.", "nombre", carroCompras.darNombreDuenio( ) );
        assertEquals( "La cédula del dueño no corresponde.", "12345", carroCompras.darCedulaDuenio( ) );
        assertEquals( "El estado del carro debería ser en elaboración.", CarroCompras.ELABORACION, carroCompras.darEstado( ) );
        assertNotNull( "Los items de compra no deberían ser nulos.", carroCompras.darItemsCompra( ) );
        assertEquals( "El carro no debería tener ningún item de compra.", 0, carroCompras.darItemsCompra( ).size( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método buscarItemCompra de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarItemCompra<br>
     * <b> Casos de prueba:</b><br>
     * 1. Existe un item compra con el ISBN dado.<br>
     * 2. No existe un item compra con el ISBN dado.<br>
     */
    public void testBuscarItemCompra( )
    {
        setupEscenario2( );
        // 1
        assertNotNull( "Debería encontrar el ítem compra.", carroCompras.buscarItemCompra( "isbn3" ) );
        assertEquals( "La cantidad solicitada del item compra no es la esperada.", 7, carroCompras.buscarItemCompra( "isbn3" ).darCantidadSolicitada( ) );

        // 2
        assertNull( "No debería existir el ítem compra.", carroCompras.buscarItemCompra( "isbn9" ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el método calcularValorTotalCompra de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularValorTotalCompra<br>
     * <b> Casos de prueba:</b><br>
     * 1. Hay 3 items compra y el valor total es la suma de los subtotales de cada item.<br>
     */
    public void testCalcularValorTotalCompra1( )
    {
        setupEscenario2( );
        assertEquals( "El valor total de la compra no es el esperado.", 42000, carroCompras.calcularValorTotalCompra( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el método calcularValorTotalCompra de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularValorTotalCompra<br>
     * <b> Casos de prueba:</b><br>
     * 1. Hay 5 items compra y el valor total es la suma de los subtotales de cada item.<br>
     */
    public void testCalcularValorTotalCompra2( )
    {
        setupEscenario3( );
        assertEquals( "El valor total de la compra no es el esperado.", 92000, carroCompras.calcularValorTotalCompra( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el método agregarItemCompra de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarItemCompra<br>
     * darItemsCompra<br>
     * <b> Casos de prueba:</b><br>
     * 1. Hay 3 items compra y el nuevo item compra tiene un ISBN distinto a los existentes.<br>
     */
    public void testAgregarItemCompraOK( )
    {
        setupEscenario2( );
        try
        {
            Libro libro4 = new Libro( "titulo4", "isbn4", 4000 );
            carroCompras.agregarItemCompra( libro4, 4 );
            assertEquals( "El carro debería tener 4 items compra.", 4, carroCompras.darItemsCompra( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 6: Se encarga de verificar el método agregarItemCompra de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarItemCompra<br>
     * darItemsCompra<br>
     * <b> Casos de prueba:</b><br>
     * 1. Hay 3 items compra y el nuevo item compra tiene un ISBN igual a uno de los ISBNs existentes.<br>
     */
    public void testAgregarItemCompraError1( )
    {
        setupEscenario2( );
        try
        {
            Libro libro3 = new Libro( "tituloNuevo", "isbn3", 1000 );
            carroCompras.agregarItemCompra( libro3, 10 );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "El carro debería tener solo 3 items compra.", 3, carroCompras.darItemsCompra( ).size( ) );
        }
    }

    /**
     * Prueba 7: Se encarga de verificar el método agregarItemCompra de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarItemCompra<br>
     * darItemsCompra<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro de compras ya está vendido y no se puede agregar el nuevo item compra.<br>
     */
    public void testAgregarItemCompraError2( )
    {
        setupEscenario3( );
        try
        {
            Libro libroNuevo = new Libro( "tituloNuevo", "isbnNuevo", 1000 );
            carroCompras.agregarItemCompra( libroNuevo, 10 );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "El carro debería tener solo 5 items compra.", 5, carroCompras.darItemsCompra( ).size( ) );
        }
    }

    /**
     * Prueba 8: Se encarga de verificar el método eliminarItemCompra de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarItemCompra<br>
     * darItemsCompra<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro de compras tiene un item compra con el ISBN dado y su estado es en elaboración.<br>
     */
    public void testEliminarItemCompraOK( )
    {
        setupEscenario2( );
        try
        {
            carroCompras.eliminarItemCompra( "isbn3" );
            assertEquals( "El carro debería tener 2 items compra.", 2, carroCompras.darItemsCompra( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el método eliminarItemCompra de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarItemCompra<br>
     * darItemsCompra<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro de compras no tiene un item compra con el ISBN dado y su estado es en elaboración.<br>
     */
    public void testEliminarItemCompraError1( )
    {
        setupEscenario2( );
        try
        {
            carroCompras.eliminarItemCompra( "isbn9" );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "El carro debería tener 3 items compra.", 3, carroCompras.darItemsCompra( ).size( ) );
        }
    }

    /**
     * Prueba 10: Se encarga de verificar el método eliminarItemCompra de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarItemCompra<br>
     * darItemsCompra<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro de compras tiene un item compra con el ISBN dado y su estado es vendido.<br>
     */
    public void testEliminarItemCompraError2( )
    {
        setupEscenario3( );
        try
        {
            carroCompras.eliminarItemCompra( "isbn3" );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertEquals( "El carro debería tener 5 items compra.", 5, carroCompras.darItemsCompra( ).size( ) );
        }
    }

    /**
     * Prueba 11: Se encarga de verificar el método vender de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * vender<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro de compras cumple con las condiciones para ser vendido.<br>
     */
    public void testVenderOK( )
    {
        setupEscenario2( );
        try
        {
            Libro libro4 = new Libro( "titulo4", "isbn4", 4000 );
            carroCompras.agregarItemCompra( libro4, 4 );
            int precio = carroCompras.vender( );
            assertEquals( "El precio vendido no corresponde.", 58000, precio );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }

    /**
     * Prueba 12: Se encarga de verificar el método vender de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * vender<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro de compras no tiene suficientes items compra para ser vendido.<br>
     */
    public void testVenderError1( )
    {
        setupEscenario2( );
        try
        {
            carroCompras.vender( );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí.
        }
    }

    /**
     * Prueba 13: Se encarga de verificar el método vender de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * vender<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro de compras ya tiene estado vendido.<br>
     */
    public void testVenderError2( )
    {
        setupEscenario3( );
        try
        {
            carroCompras.vender( );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí.
        }
    }

}