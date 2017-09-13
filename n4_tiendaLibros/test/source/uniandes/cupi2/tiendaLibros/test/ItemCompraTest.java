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
import uniandes.cupi2.tiendaLibros.mundo.ItemCompra;
import uniandes.cupi2.tiendaLibros.mundo.Libro;

/**
 * Clase usada para verificar que los métodos de la clase ItemCompra estén correctamente implementados.
 */
public class ItemCompraTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    /**
     * Clase de pruebas.
     */
    private ItemCompra itemCompra;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo ItemCompra.
     */
    private void setupEscenario1( )
    {
        Libro libroIncluido;
        try
        {
            libroIncluido = new Libro( "titulo", "isbn", 1000 );
            itemCompra = new ItemCompra( libroIncluido, 5 );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }
    
    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * ItemCompra<br>
     * darLibro<br>
     * darCantidadSolicitada<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el item de compra, cada uno de los valores corresponde al esperado.<br>
     */
    public void testItemCompra( )
    {
        setupEscenario1( );
        
        assertNotNull( "No debería ser nulo.", itemCompra );
        assertEquals( "El isbn del libro no corresponde.", "isbn", itemCompra.darLibro( ).darISBN( ) );
        assertEquals( "La cantidad solicitada no corresponde.", 5, itemCompra.darCantidadSolicitada( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método calcularSubtotalItem de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularSubtotalItem<br>
     * <b> Caso de prueba 1:</b><br>
     * El valor calculado corresponde al esperado.<br>
     */
    public void testItemsIguales( )
    {
        setupEscenario1( );
        assertEquals( "El valor subtotal no es el esperado.", 5000, itemCompra.calcularSubtotalItem( ) );
    }
}