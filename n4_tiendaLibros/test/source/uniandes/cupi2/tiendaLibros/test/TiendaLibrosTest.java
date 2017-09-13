/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
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
import uniandes.cupi2.tiendaLibros.mundo.TiendaLibros;

/**
 * Clase usada para verificar que los m�todos de la clase TiendaLibros est�n correctamente implementados.
 */
public class TiendaLibrosTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase de pruebas.
     */
    private TiendaLibros tiendaLibros;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva TiendaLibros vac�a.
     */
    private void setupEscenario1( )
    {
        tiendaLibros = new TiendaLibros( );
    }

    /**
     * Escenario 2: Construye una nueva TiendaLibros con 6 libros y 2 carros de compras.<br>
     * El primer carro de compras tiene 5 items compra y su estado es vendido.<br>
     * El segundo carro de compras tiene 3 items compra y su estado es en elaboraci�n.<br>
     */
    private void setupEscenario2( )
    {
        try
        {
            tiendaLibros = new TiendaLibros( );
            tiendaLibros.agregarLibroACatalogo( "titulo1", "isbn1", 1000 );
            tiendaLibros.agregarLibroACatalogo( "titulo2", "isbn2", 2000 );
            tiendaLibros.agregarLibroACatalogo( "titulo3", "isbn3", 3000 );
            tiendaLibros.agregarLibroACatalogo( "titulo4", "isbn4", 4000 );
            tiendaLibros.agregarLibroACatalogo( "titulo5", "isbn5", 5000 );
            tiendaLibros.agregarLibroACatalogo( "titulo6", "isbn6", 6000 );
            tiendaLibros.agregarCarroCompras( "nombre1", "1111" );
            tiendaLibros.agregarCarroCompras( "nombre2", "2222" );
            tiendaLibros.agregarItemCompraACarro( "1111", "isbn1", 5 );
            tiendaLibros.agregarItemCompraACarro( "1111", "isbn2", 7 );
            tiendaLibros.agregarItemCompraACarro( "1111", "isbn3", 1 );
            tiendaLibros.agregarItemCompraACarro( "1111", "isbn4", 10 );
            tiendaLibros.agregarItemCompraACarro( "1111", "isbn5", 3 );
            tiendaLibros.venderCarroCompras( "1111" );
            tiendaLibros.agregarItemCompraACarro( "2222", "isbn2", 2 );
            tiendaLibros.agregarItemCompraACarro( "2222", "isbn3", 5 );
            tiendaLibros.agregarItemCompraACarro( "2222", "isbn4", 1 );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * TiendaLibros<br>
     * darCatalogo<br>
     * darCarrosCompras<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente la tienda de libros, el cat�logo y los carros de compras son listas vac�as.<br>
     */
    public void testTiendaLibros( )
    {
        setupEscenario1( );
        assertNotNull( "El cat�logo no deber�a ser nulo.", tiendaLibros.darCatalogo( ) );
        assertNotNull( "Los carros de compras no deber�an ser nulos.", tiendaLibros.darCarrosCompras( ) );
        assertEquals( "El cat�logo deber�a estar vac�o.", 0, tiendaLibros.darCatalogo( ).size( ) );
        assertEquals( "Los carros de compras deber�an estar vac�os.", 0, tiendaLibros.darCarrosCompras( ).size( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo darCarroComprasEnElaboracion de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darCarroComprasEnElaboracion<br>
     * <b> Caso de prueba 1:</b><br>
     * La tienda tiene 1 carro de compras en elaboraci�n.<br>
     */
    public void testDarCarrosComprasEnElaboracion( )
    {
        setupEscenario2( );
        assertNotNull( "La lista no deber�a ser nula.", tiendaLibros.darCarrosComprasEnElaboracion( ) );
        assertEquals( "La tienda deber�a tener 1 carro de compras en elaboraci�n.", 1, tiendaLibros.darCarrosComprasEnElaboracion( ).size( ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el m�todo darCarroComprasVendidos de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darCarroComprasVendidos<br>
     * <b> Caso de prueba 1:</b><br>
     * La tienda tiene 1 carro de compras vendido.<br>
     */
    public void testDarCarrosComprasVendidos( )
    {
        setupEscenario2( );
        assertNotNull( "La lista no deber�a ser nula.", tiendaLibros.darCarrosComprasVendidos( ) );
        assertEquals( "La tienda deber�a tener 1 carro de compras vendido.", 1, tiendaLibros.darCarrosComprasVendidos( ).size( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el m�todo buscarLibro de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarLibro<br>
     * <b> Casos de prueba:</b><br>
     * 1. Existe el libro con el ISBN dado.<br>
     * 2. No existe el libro con el ISBN dado.<br>
     */
    public void testBuscarLibro( )
    {
        setupEscenario2( );

        // 1
        assertNotNull( "Deber�a existir el libro.", tiendaLibros.buscarLibro( "isbn1" ) );

        // 2
        assertNull( "No deber�a existir el libro.", tiendaLibros.buscarLibro( "isbn9" ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el m�todo buscarCarroCompras de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarCarroCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. Existe el carro de compras con la c�dula dada.<br>
     * 2. No existe el carro de compras con la c�dula dada.<br>
     */
    public void testBuscarCarroCompras( )
    {
        setupEscenario2( );

        // 1
        assertNotNull( "Deber�a existir el libro.", tiendaLibros.buscarCarroCompras( "1111" ) );

        // 2
        assertNull( "No deber�a existir el libro.", tiendaLibros.buscarLibro( "9999" ) );
    }

    /**
     * Prueba 6: Se encarga de verificar el m�todo existeLibroCarrosCompras de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * existeLibroCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El libro est� presente en por lo menos 1 carro de compras.<br>
     * 2. El libro no est� presente en ning�n carro de compras.<br>
     */
    public void testExisteLibroCarrosCompras( )
    {
        setupEscenario2( );

        // 1
        assertTrue( "Deber�a ser verdadero que el libro est� en alg�n carro de compras.", tiendaLibros.existeLibroCarrosCompras( "isbn3" ) );

        // 2
        assertFalse( "Deber�a ser falso que el libro est� en alg�n carro de compras.", tiendaLibros.existeLibroCarrosCompras( "isbn6" ) );
    }

    /**
     * Prueba 7: Se encarga de verificar el m�todo agregarLibroACatalogo de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLibroACatalogo<br>
     * darCatalogo<br>
     * <b> Casos de prueba:</b><br>
     * 1. El libro cumple las condiciones para ser agregado.<br>
     */
    public void testAgregarLibroACatalogoOK( )
    {
        setupEscenario1( );
        try
        {
            tiendaLibros.agregarLibroACatalogo( "titulo", "isbn", 1000 );
            assertEquals( "La tienda deber�a tener 1 libro.", 1, tiendaLibros.darCatalogo( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 8: Se encarga de verificar el m�todo agregarLibroACatalogo de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLibroACatalogo<br>
     * darCatalogo<br>
     * <b> Casos de prueba:</b><br>
     * 1. Ya existe en al tienda un libro con el ISBN dado.<br>
     */
    public void testAgregarLibroACatalogoError1( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.agregarLibroACatalogo( "titulo", "isbn1", 1000 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "La tienda deber�a tener 6 libros.", 6, tiendaLibros.darCatalogo( ).size( ) );
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el m�todo agregarLibroACatalogo de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLibroACatalogo<br>
     * darCatalogo<br>
     * <b> Casos de prueba:</b><br>
     * 1. El libro va a ser agregado con un precio negativo.<br>
     */
    public void testAgregarLibroACatalogoError2( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.agregarLibroACatalogo( "titulo7", "isbn7", -1000 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "La tienda deber�a tener 7 libros.", 7, tiendaLibros.darCatalogo( ).size( ) );
        }
    }

    /**
     * Prueba 10: Se encarga de verificar el m�todo agregarCarroCompras de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarCarroCompras<br>
     * darCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro de compras cumple las condiciones para ser agregado.<br>
     */
    public void testAgregarCarroComprasOK( )
    {
        setupEscenario1( );
        try
        {
            tiendaLibros.agregarCarroCompras( "nombre1", "1111" );
            assertEquals( "La tienda deber�a tener 1 carro de compras.", 1, tiendaLibros.darCarrosCompras( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 11: Se encarga de verificar el m�todo agregarCarroCompras de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarCarroCompras<br>
     * darCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. Ya existe un carro de compras con la c�dula dada.<br>
     */
    public void testAgregarCarroComprasError( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.agregarCarroCompras( "nombre1", "1111" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "La tienda deber�a tener 2 carros de compras.", 2, tiendaLibros.darCarrosCompras( ).size( ) );
        }
    }

    /**
     * Prueba 12: Se encarga de verificar el m�todo agregarItemCompraACarro de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarItemCompraACarro<br>
     * buscarCarroCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El �tem de compras cumple las condiciones necesarias para ser agregado al carro.<br>
     */
    public void testAgregarItemCompraACarroOK( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.agregarItemCompraACarro( "2222", "isbn5", 10 );
            assertEquals( "El carro de compras deber�a tener 4 items.", 4, tiendaLibros.buscarCarroCompras( "2222" ).darItemsCompra( ).size( ) );
            assertEquals( "La cantidad solicitada del item compras no corrsponde.", 10, tiendaLibros.buscarCarroCompras( "2222" ).buscarItemCompra( "isbn5" ).darCantidadSolicitada( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 13: Se encarga de verificar el m�todo agregarItemCompraACarro de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarItemCompraACarro<br>
     * buscarCarroCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. No existe un libros con el ISBN dado.<br>
     */
    public void testAgregarItemCompraACarroError1( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.agregarItemCompraACarro( "2222", "isbn9", 10 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "El carro de compras deber�a tener 3 items.", 3, tiendaLibros.buscarCarroCompras( "2222" ).darItemsCompra( ).size( ) );
        }
    }

    /**
     * Prueba 14: Se encarga de verificar el m�todo agregarItemCompraACarro de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarItemCompraACarro<br>
     * buscarCarroCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. No existe un carro de compras con la c�dula dada.<br>
     */
    public void testAgregarItemCompraACarroError2( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.agregarItemCompraACarro( "3333", "isbn1", 10 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertNull( "No deber�a existir el carro de compras.", tiendaLibros.buscarCarroCompras( "3333" ) );
        }
    }

    /**
     * Prueba 15: Se encarga de verificar el m�todo agregarItemCompraACarro de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarItemCompraACarro<br>
     * buscarCarroCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro de compras ya tiene un �tem compra con el ISBN dado.<br>
     */
    public void testAgregarItemCompraACarroError3( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.agregarItemCompraACarro( "2222", "isbn3", 10 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "El carro de compras deber�a tener 3 items.", 3, tiendaLibros.buscarCarroCompras( "2222" ).darItemsCompra( ).size( ) );
        }
    }

    /**
     * Prueba 16: Se encarga de verificar el m�todo agregarItemCompraACarro de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarItemCompraACarro<br>
     * buscarCarroCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro compras tiene estado vendido.<br>
     */
    public void testAgregarItemCompraACarroError4( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.agregarItemCompraACarro( "1111", "isbn6", 10 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "El carro de compras deber�a tener 5 items.", 5, tiendaLibros.buscarCarroCompras( "1111" ).darItemsCompra( ).size( ) );
        }
    }

    /**
     * Prueba 17: Se encarga de verificar el m�todo eliminarLibroDeCatalogo de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarLibroDeCatalogo<br>
     * darCatalogo<br>
     * <b> Casos de prueba:</b><br>
     * 1. El libro a eliminar existe en el cat�logo y no est� presente en ning�n carro de compras.<br>
     */
    public void testEliminarLibroDeCatalogoOK( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.eliminarLibroDeCatalogo( "isbn6" );
            assertEquals( "El cat�logo deber�a tener 5 libros.", 5, tiendaLibros.darCatalogo( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 18: Se encarga de verificar el m�todo eliminarLibroDeCatalogo de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarLibroDeCatalogo<br>
     * darCatalogo<br>
     * <b> Casos de prueba:</b><br>
     * 1. El libro a eliminar existe en el cat�logo y est� presente en alg�n carro de compras.<br>
     */
    public void testEliminarLibroDeCatalogoError1( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.eliminarLibroDeCatalogo( "isbn3" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "El cat�logo deber�a tener 6 libros.", 6, tiendaLibros.darCatalogo( ).size( ) );
        }
    }

    /**
     * Prueba 19: Se encarga de verificar el m�todo eliminarLibroDeCatalogo de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarLibroDeCatalogo<br>
     * darCatalogo<br>
     * <b> Casos de prueba:</b><br>
     * 1. El libro a eliminar no existe en el cat�logo.<br>
     */
    public void testEliminarLibroDeCatalogoError2( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.eliminarLibroDeCatalogo( "isbn7" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "El cat�logo deber�a tener 6 libros.", 6, tiendaLibros.darCatalogo( ).size( ) );
        }
    }

    /**
     * Prueba 20: Se encarga de verificar el m�todo eliminarCarroCompras de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarCarroCompras<br>
     * darCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro a eliminar existe y tiene estado en elaboraci�n.<br>
     */
    public void testEliminarCarroComprasOK( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.eliminarCarroCompras( "2222" );
            assertEquals( "La tienda deber�a tener 1 carro de compras.", 1, tiendaLibros.darCarrosCompras( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 21: Se encarga de verificar el m�todo eliminarCarroCompras de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarCarroCompras<br>
     * darCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro a eliminar no existe.<br>
     */
    public void testEliminarCarroComprasError1( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.eliminarCarroCompras( "3333" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "La tienda deber�a tener 2 carros de compras.", 2, tiendaLibros.darCarrosCompras( ).size( ) );
        }
    }

    /**
     * Prueba 22: Se encarga de verificar el m�todo eliminarCarroCompras de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarCarroCompras<br>
     * darCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro a eliminar existe y tiene estado vendido.<br>
     */
    public void testEliminarCarroComprasError2( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.eliminarCarroCompras( "1111" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "La tienda deber�a tener 2 carros de compras.", 2, tiendaLibros.darCarrosCompras( ).size( ) );
        }
    }

    /**
     * Prueba 23: Se encarga de verificar el m�todo eliminarItemCompraDeCarro de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarItemCompraDeCarro<br>
     * buscarCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro a eliminar existe y tiene un item de compras con el ISBN dado.<br>
     */
    public void testEliminarItemCompraDeCarroOK( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.eliminarItemCompraDeCarro( "2222", "isbn3" );
            assertEquals( "El carro de comrpas deber�a tener 2 items compras.", 2, tiendaLibros.buscarCarroCompras( "2222" ).darItemsCompra( ).size( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 24: Se encarga de verificar el m�todo eliminarItemCompraDeCarro de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarItemCompraDeCarro<br>
     * buscarCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro a eliminar existe y no tiene un item de compras con el ISBN dado.<br>
     */
    public void testEliminarItemCompraDeCarroError1( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.eliminarItemCompraDeCarro( "2222", "isbn6" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "El carro de comrpas deber�a tener 3 items compras.", 3, tiendaLibros.buscarCarroCompras( "2222" ).darItemsCompra( ).size( ) );
        }
    }

    /**
     * Prueba 25: Se encarga de verificar el m�todo eliminarItemCompraDeCarro de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarItemCompraDeCarro<br>
     * buscarCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro a eliminar no existe.<br>
     */
    public void testEliminarItemCompraDeCarroError2( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.eliminarItemCompraDeCarro( "3333", "isbn6" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertNull( "No deber�a existir el carro de compras.", tiendaLibros.buscarCarroCompras( "3333" ) );
        }
    }

    /**
     * Prueba 26: Se encarga de verificar el m�todo eliminarItemCompraDeCarro de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarItemCompraDeCarro<br>
     * buscarCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro a eliminar existe y su estado es vendido.<br>
     */
    public void testEliminarItemCompraDeCarroError3( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.eliminarItemCompraDeCarro( "1111", "isbn5" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "El carro de comrpas deber�a tener 5 items compras.", 5, tiendaLibros.buscarCarroCompras( "1111" ).darItemsCompra( ).size( ) );
        }
    }

    /**
     * Prueba 27: Se encarga de verificar el m�todo venderCarroCompras de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * venderCarroCompras<br>
     * buscarCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro a vender existe, tiene 4 items compra y su estado es en elaboraci�n.<br>
     */
    public void testVenderCarroComprasOK( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.agregarItemCompraACarro( "2222", "isbn6", 5 );
            int precio = tiendaLibros.venderCarroCompras( "2222" );
            assertEquals( "El precio no coincide.", 53000, precio );
            assertEquals( "El estado del carro deber�a ser vendido.", CarroCompras.VENDIDO, tiendaLibros.buscarCarroCompras( "2222" ).darEstado( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }

    /**
     * Prueba 28: Se encarga de verificar el m�todo venderCarroCompras de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * venderCarroCompras<br>
     * buscarCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro a vender no existe.<br>
     */
    public void testVenderCarroComprasError1( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.venderCarroCompras( "3333" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertNull( "No deber�a existir el carro de compras.", tiendaLibros.buscarCarroCompras( "3333" ) );
        }
    }

    /**
     * Prueba 29: Se encarga de verificar el m�todo venderCarroCompras de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * venderCarroCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro a vender existe y su estado vendido.<br>
     */
    public void testVenderCarroComprasError2( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.venderCarroCompras( "1111" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�.
        }
    }

    /**
     * Prueba 30: Se encarga de verificar el m�todo venderCarroCompras de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * venderCarroCompras<br>
     * buscarCarrosCompras<br>
     * <b> Casos de prueba:</b><br>
     * 1. El carro a vender existe, tiene 3 items compra y su estado es en elaboraci�n.<br>
     */
    public void testVenderCarroComprasError3( )
    {
        setupEscenario2( );
        try
        {
            tiendaLibros.venderCarroCompras( "2222" );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "El estado del carro deber�a ser en elaboraci�n.", CarroCompras.ELABORACION, tiendaLibros.buscarCarroCompras( "2222" ).darEstado( ) );
        }
    }
}