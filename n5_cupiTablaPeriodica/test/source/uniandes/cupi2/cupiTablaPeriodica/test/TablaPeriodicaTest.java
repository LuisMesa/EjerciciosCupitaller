/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_cupiTablaPeriodica
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupiTablaPeriodica.test;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;
import uniandes.cupi2.cupiTablaPeriodica.mundo.Elemento;
import uniandes.cupi2.cupiTablaPeriodica.mundo.TablaPeriodica;

/**
 * Clase usada para verificar que los métodos de la clase TablaPeriodica estén correctamente implementados.
 */
public class TablaPeriodicaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private TablaPeriodica tablaPeriodica;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva TablaPeriodica.
     */
    private void setupEscenario1( )
    {
        try
        {
            tablaPeriodica = new TablaPeriodica( );
        }
        catch( Exception e )
        {
            fail( "Error en el constructor de la clase: " + e.getMessage( ) );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * TablaPeriodica<br>
     * darElementosPorPeriodo<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente la tabla periódica, cada uno de los valores corresponde al esperado.<br>
     */
    public void testTablaPeriodica( )
    {
        setupEscenario1( );

        assertNotNull( "No inicializa correctamente los elementos de la tabla", tablaPeriodica.darElementosPorPeriodo( ) );
        assertEquals( "El tamaño de los elementos no es el esperado del archivo", 56, tablaPeriodica.darElementosPorPeriodo( ).size( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método darElementosPorPeriodo de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darElementosPorPeriodo<br>
     * darPeriodo<br>
     * darGrupo<br>
     * <b> Caso de prueba 1:</b><br>
     * Existe por lo menos un elemento en la tabla periódica.<br>
     * <b> Caso de prueba 2:</b><br>
     * Los elementos se encuentran ordenados.
     */
    public void testDarElementosPorPeriodo( )
    {
        setupEscenario1( );

        ArrayList elementos = tablaPeriodica.darElementosPorPeriodo( );

        assertEquals( "No se retorna correctamente el número de elementos, incluyendo las posiciones nulas en donde no hay elemento.", TablaPeriodica.NUMERO_GRUPOS * TablaPeriodica.NUMERO_PERIODOS, elementos.size( ) );

        Iterator it = elementos.iterator( );

        Elemento anterior = null;
        for( int i = 1; i < elementos.size( ); i++ )
        {
            Elemento actual = ( Elemento )elementos.get( i );
            try
            {
                anterior = ( Elemento )elementos.get( i - 1 );
            }
            catch( Exception e )
            {

            }
            if( anterior != null && actual != null )
            {
                assertTrue( "No se retornan ordenadamente los elementos.", anterior.darPeriodo( ) <= actual.darPeriodo( ) );
                if( anterior.darPeriodo( ) == actual.darPeriodo( ) )
                {
                    assertTrue( "No se retornan ordenadamente el elemento: " + anterior.darNombre( ), anterior.darGrupo( ) < actual.darGrupo( ) );
                }
                else
                {
                    assertTrue( "No se retornan ordenadamente el elemento: " + anterior.darNombre( ), anterior.darGrupo( ) > actual.darGrupo( ) );
                }
            }
            anterior = actual;
        }
    }

    /**
     * Prueba 3: Se encarga de verificar el método darElementoPorPeriodoGrupo de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darElementoPorPeriodoGrupo<br>
     * darSimboloQuimico<br>
     * <b> Caso de prueba 1:</b><br>
     * El elemento existe.<br>
     * <b> Caso de prueba 2:</b><br>
     * El elemento no existe.
     */
    public void testDarElementoGrupoPeriodo( )
    {
        setupEscenario1( );

        assertEquals( "No se retorna correctamente el elemento de busqueda.", "Sb", ( ( Elemento )tablaPeriodica.darElementoPorPeriodoGrupo( 5, 5 ) ).darSimboloQuimico( ) );
        assertEquals( "No se retorna correctamente el elemento de busqueda.", "Ba", ( ( Elemento )tablaPeriodica.darElementoPorPeriodoGrupo( 6, 2 ) ).darSimboloQuimico( ) );
        assertEquals( "No se retorna correctamente el elemento de busqueda.", "Ar", ( ( Elemento )tablaPeriodica.darElementoPorPeriodoGrupo( 3, 8 ) ).darSimboloQuimico( ) );

        assertNull( "No se retorna correctamente un elemento no existente.", tablaPeriodica.darElementoPorPeriodoGrupo( 3, 9 ) );
        assertNull( "No se retorna correctamente un elemento no existente.", tablaPeriodica.darElementoPorPeriodoGrupo( 1, 3 ) );
        assertNull( "No se retorna correctamente un elemento no existente.", tablaPeriodica.darElementoPorPeriodoGrupo( 8, 8 ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el método buscarElementoPorNombre de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarElementoPorNombre<br>
     * darSimboloQuimico<br>
     * <b> Caso de prueba 1:</b><br>
     * El elemento existe.<br>
     * <b> Caso de prueba 2:</b><br>
     * El elemento no existe.
     */
    public void testBuscarElementoPorNombre( )
    {
        setupEscenario1( );

        String nombre = "Radón";
        String simbolo = "Rn";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", simbolo, tablaPeriodica.buscarElementoPorNombre( nombre ).darSimboloQuimico( ) );

        nombre = "Bismuto";
        simbolo = "Bi";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", simbolo, tablaPeriodica.buscarElementoPorNombre( nombre ).darSimboloQuimico( ) );

        nombre = "Potasio";
        simbolo = "K";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", simbolo, tablaPeriodica.buscarElementoPorNombre( nombre ).darSimboloQuimico( ) );

        nombre = "Francio";
        simbolo = "Fr";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", simbolo, tablaPeriodica.buscarElementoPorNombre( nombre ).darSimboloQuimico( ) );

        nombre = "Helio";
        simbolo = "He";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", simbolo, tablaPeriodica.buscarElementoPorNombre( nombre ).darSimboloQuimico( ) );

        nombre = "Nombre";
        assertNull( "No se retorna correctamente la busqueda de un elemento no existente.", tablaPeriodica.buscarElementoPorNombre( nombre ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el método buscarElementoPorSimboloQuimico de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarElementoPorSimboloQuimico<br>
     * darNombre<br>
     * <b> Caso de prueba 1:</b><br>
     * El elemento existe.<br>
     * <b> Caso de prueba 2:</b><br>
     * El elemento no existe.
     */
    public void testBuscarElementoPorSimbolo( )
    {
        setupEscenario1( );

        String nombre = "Xenón";
        String simbolo = "Xe";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", nombre, tablaPeriodica.buscarElementoPorSimboloQuimico( simbolo ).darNombre( ) );

        nombre = "Carbono";
        simbolo = "C";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", nombre, tablaPeriodica.buscarElementoPorSimboloQuimico( simbolo ).darNombre( ) );

        nombre = "Calcio";
        simbolo = "Ca";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", nombre, tablaPeriodica.buscarElementoPorSimboloQuimico( simbolo ).darNombre( ) );

        nombre = "Fluor";
        simbolo = "F";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", nombre, tablaPeriodica.buscarElementoPorSimboloQuimico( simbolo ).darNombre( ) );

        nombre = "Hidrógeno";
        simbolo = "H";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", nombre, tablaPeriodica.buscarElementoPorSimboloQuimico( simbolo ).darNombre( ) );

        simbolo = "Sim";
        assertNull( "No se retorna correctamente la busqueda de un elemento no existente.", tablaPeriodica.buscarElementoPorNombre( simbolo ) );
    }

    /**
     * Prueba 6: Se encarga de verificar el método buscarPorNumeroAtomico de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarElementoPorNumeroAtomico<br>
     * darSimboloQuimico<br>
     * darNombre<br>
     * <b> Caso de prueba 1:</b><br>
     * Existe por lo menos un elemento en la tabla periódica.
     */
    public void testBuscarElementoPorNumeroAtomico( )
    {
        setupEscenario1( );

        int numero = 1;
        String simbolo = "H";
        String nombre = "Hidrógeno";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", nombre, tablaPeriodica.buscarElementoPorNumeroAtomico( numero ).darNombre( ) );
        assertEquals( "No se retorna correctamente el elemento de busqueda.", simbolo, tablaPeriodica.buscarElementoPorNumeroAtomico( numero ).darSimboloQuimico( ) );

        numero = 16;
        nombre = "Azufre";
        simbolo = "S";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", nombre, tablaPeriodica.buscarElementoPorNumeroAtomico( numero ).darNombre( ) );
        assertEquals( "No se retorna correctamente el elemento de busqueda.", simbolo, tablaPeriodica.buscarElementoPorNumeroAtomico( numero ).darSimboloQuimico( ) );

        numero = 88;
        nombre = "Radio";
        simbolo = "Ra";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", nombre, tablaPeriodica.buscarElementoPorNumeroAtomico( numero ).darNombre( ) );
        assertEquals( "No se retorna correctamente el elemento de busqueda.", simbolo, tablaPeriodica.buscarElementoPorNumeroAtomico( numero ).darSimboloQuimico( ) );

        numero = 32;
        nombre = "Germanio";
        simbolo = "Ge";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", nombre, tablaPeriodica.buscarElementoPorNumeroAtomico( numero ).darNombre( ) );
        assertEquals( "No se retorna correctamente el elemento de busqueda.", simbolo, tablaPeriodica.buscarElementoPorNumeroAtomico( numero ).darSimboloQuimico( ) );

        numero = 36;
        nombre = "Kriptón";
        simbolo = "Kr";
        assertEquals( "No se retorna correctamente el elemento de busqueda.", nombre, tablaPeriodica.buscarElementoPorNumeroAtomico( numero ).darNombre( ) );
        assertEquals( "No se retorna correctamente el elemento de busqueda.", simbolo, tablaPeriodica.buscarElementoPorNumeroAtomico( numero ).darSimboloQuimico( ) );

        numero = 25;
        assertNull( "No se retorna correctamente la busqueda de un elemento no existente.", tablaPeriodica.buscarElementoPorNumeroAtomico( numero ) );
        numero = 89;
        assertNull( "No se retorna correctamente la busqueda de un elemento no existente.", tablaPeriodica.buscarElementoPorNumeroAtomico( numero ) );
    }
}