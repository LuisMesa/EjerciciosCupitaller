/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_cupiAppStore
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupiAppStore.test;

import junit.framework.TestCase;
import uniandes.cupi2.cupiAppStore.mundo.AppStore;

/**
 * Clase usada para verificar que los m�todos de la clase AppStore est�n correctamente implementados.
 */
public class AppStoreTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private AppStore appStore;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye una nueva AppStore con 3 juegos.
     */
    private void setupEscenario1( )
    {
        appStore = new AppStore( );
        appStore.inicializar( );

    }

    /**
     * Prueba 1: verifica el m�todo constructor.<br>
     * <b> M�todos a probar: </b> <br>
     * darJuego1<br>
     * darJuego2<br>
     * darJuego3<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Creaci�n de una instancia v�lida de EmpresaJuegos, que tiene 4 juegos v�lidos.<br>
     */
    public void testEmpresaJuegos( )
    {
        setupEscenario1( );
        assertNotNull( "Al crear el juego 1, este deber�a ser v�lido", appStore.darJuego1( ) );
        assertNotNull( "Al crear el juego 2, este deber�a ser v�lido", appStore.darJuego2( ) );
        assertNotNull( "Al crear el juego 3, este deber�a ser v�lido", appStore.darJuego3( ) );

    }

    /**
     * Prueba 2: verifica el m�todo darCantidadActualJuego1.<br>
     * <b> M�todos a probar: </b> <br>
     * darCantidadActualJuego1<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego tiene la cantidad correcta al ser creado.<br>
     */
    public void testDarCantidadActualJuego1( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad actual del juego deber�a ser 50", 50, appStore.darCantidadActualJuego1( ) );
    }
    /**
     * Prueba 3: verifica el m�todo darCantidadActualJuego2.<br>
     * <b> M�todos a probar: </b> <br>
     * darCantidadActualJuego2<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego tiene la cantidad correcta al ser creado.<br>
     */
    public void testDarCantidadActualJuego2( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad actual del juego deber�a ser 15", 15, appStore.darCantidadActualJuego2( ) );
    }
    /**
     * Prueba 4: verifica el m�todo darCantidadActualJuego3.<br>
     * <b> M�todos a probar: </b> <br>
     * darCantidadActualJuego3<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego tiene la cantidad correcta al ser creado.<br>
     */
    public void testDarCantidadActualJuego3( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad actual del juego deber�a ser 22", 22, appStore.darCantidadActualJuego3( ) );
    }

    /**
     * Prueba 5: verifica el m�todo darJuego1.<br>
     * <b> M�todos a probar: </b> <br>
     * darJuego1<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Los juegos han creado correctamente.<br>
     * 2. Se obtienen los juegos por su nombre.<br>
     */
    public void testDarJuego1( )
    {
        setupEscenario1( );
        assertNotNull( "Al crear el Juego 1, este deber�a ser v�lido", appStore.darJuego1( ) );

        assertEquals( "Al crear el Juego 1, este deber�a ser valido", "Candy Crush", appStore.darJuego1( ).darNombre( ) );

    }
    /**
     * Prueba 6: verifica el m�todo darJuego2.<br>
     * <b> M�todos a probar: </b> <br>
     * darJuego2<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Los juegos han creado correctamente.<br>
     * 2. Se obtienen los juegos por su nombre.<br>
     */
    public void testDarJuego2( )
    {
        setupEscenario1( );

        assertNotNull( "Al crear el Juego 2, este deber�a ser v�lido", appStore.darJuego2( ) );

        assertEquals( "Al crear el Juego 2, este deber�a ser valido", "Clash Of Clans", appStore.darJuego2( ).darNombre( ) );

    }
    /**
     * Prueba 7: verifica el m�todo darJuego3.<br>
     * <b> M�todos a probar: </b> <br>
     * darJuego3<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Los juegos han creado correctamente.<br>
     * 2. Se obtienen los juegos por su nombre.<br>
     */
    public void testDarJuego3( )
    {
        setupEscenario1( );

        assertNotNull( "Al crear el Juego 3, este deber�a ser v�lido", appStore.darJuego3( ) );

        assertEquals( "Al crear el Juego 3, este deber�a ser valido", "Fifa 15", appStore.darJuego3( ).darNombre( ) );

    }

    /**
     * Prueba 8: verifica el m�todo comprarUnidadesJuego1.<br>
     * <b> M�todos a probar: </b> <br>
     * darCantidadActualJuego1<br>
     * comprarUnidadesJuego1<br>
     * venderUnidadesJuego1<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego tiene la cantidad correcta antes de comprar.<br>
     * 2. El juego tiene la cantidad correcta despu�s de comprar.<br>
     */
    public void testComprarUnidadesJuego1( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad actual del juego 1 deber�a ser 50", 50, appStore.darCantidadActualJuego1( ) );
        appStore.comprarUnidadesJuego1( 13 );
        assertEquals( "La cantidad actual del juego 1 deber�a ser 63", 63, appStore.darCantidadActualJuego1( ) );
        appStore.venderUnidadesJuego1( 3 );
        appStore.comprarUnidadesJuego1( 5 );
        assertEquals( "La cantidad actual del juego 1 deber�a ser 65", 65, appStore.darCantidadActualJuego1( ) );

    }
    /**
     * Prueba 9: verifica el m�todo comprarUnidadesJuego2.<br>
     * <b> M�todos a probar: </b> <br>
     * darCantidadActualJuego2<br>
     * comprarUnidadesJuego2<br>
     * venderUnidadesJuego2<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego tiene la cantidad correcta antes de comprar.<br>
     * 2. El juego tiene la cantidad correcta despu�s de comprar.<br>
     */
    public void testComprarUnidadesJuego2( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad actual del juego 2 deber�a ser 15", 15, appStore.darCantidadActualJuego2( ) );
        appStore.comprarUnidadesJuego2( 10 );
        assertEquals( "La cantidad actual del juego 2 deber�a ser 25", 25, appStore.darCantidadActualJuego2( ) );
        appStore.venderUnidadesJuego2( 5 );
        appStore.comprarUnidadesJuego2( 5 );
        assertEquals( "La cantidad actual del juego 2 deber�a ser 25", 25, appStore.darCantidadActualJuego2( ) );

    }
    /**
     * Prueba 10: verifica el m�todo comprarUnidadesJuego3.<br>
     * <b> M�todos a probar: </b> <br>
     * darCantidadActualJuego3<br>
     * comprarUnidadesJuego3<br>
     * venderUnidadesJuego3<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego tiene la cantidad correcta antes de comprar.<br>
     * 2. El juego tiene la cantidad correcta despu�s de comprar.<br>
     */
    public void testComprarUnidadesJuego( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad actual del juego 3 deber�a ser 22", 22, appStore.darCantidadActualJuego3( ) );
        appStore.comprarUnidadesJuego3( 20 );
        assertEquals( "La cantidad actual del juego 3 deber�a ser 42", 42, appStore.darCantidadActualJuego3( ) );
        appStore.venderUnidadesJuego3( 10 );
        appStore.comprarUnidadesJuego3( 5 );
        assertEquals( "La cantidad actual del juego 3 deber�a ser 37", 37, appStore.darCantidadActualJuego3( ) );

    }

    /**
     * Prueba 11: verificar el m�todo venderUnidadesJuego1.<br>
     * <b> M�todos a probar: </b> <br>
     * darJuego1<br>
     * comprarUnidadesJuego1<br>
     * venderUnidadesJuego1<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se obtiene el juego sin haber sido ser vendido.<br>
     * 2. Se obtiene el juego despu�s de vender ciertas unidades.<br>
     * 3. Se obtiene null despu�s de vender todas las unidades.<br>
     */
    public void testVenderUnidadesJuego1( )
    {
        setupEscenario1( );
        assertNotNull( "Hay existencia del juego 1. No deber�a ser null", appStore.darJuego1( ) );
        appStore.venderUnidadesJuego1( 45 );
        assertNotNull( "Hay existencia del juego 1. No deber�a ser null", appStore.darJuego1( ) );
        appStore.venderUnidadesJuego1( 5 );
        assertNotNull( "No hay existencia del juego 1. No deber�a ser null", appStore.darJuego1( ) );
        appStore.comprarUnidadesJuego1( 10 );
        assertNotNull( "Hay existencia del juego 1. No deber�a ser null", appStore.darJuego1( ) );
        assertEquals( "La cantidad actual del juego 1 deber�a ser 10", 10, appStore.darCantidadActualJuego1( ) );

    }

    /**
     * Prueba 12: verificar el m�todo venderUnidadesJuego2.<br>
     * <b> M�todos a probar: </b> <br>
     * darJuego2<br>
     * comprarUnidadesJuego2<br>
     * venderUnidadesJuego2<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se obtiene el juego sin haber sido ser vendido.<br>
     * 2. Se obtiene el juego despu�s de vender ciertas unidades.<br>
     * 3. Se obtiene null despu�s de vender todas las unidades.<br>
     */
    public void testVenderUnidadesJuego2( )
    {
        setupEscenario1( );
        assertNotNull( "Hay existencia del juego 2. No deber�a ser null", appStore.darJuego2( ) );
        appStore.venderUnidadesJuego2( 10 );
        assertNotNull( "Hay existencia del juego 2. No deber�a ser null", appStore.darJuego2( ) );
        appStore.venderUnidadesJuego2( 5 );
        assertNotNull( "No hay existencia del juego 2. No deber�a ser null", appStore.darJuego2( ) );
        appStore.comprarUnidadesJuego2( 5 );
        assertNotNull( "Hay existencia del juego 2. No deber�a ser null", appStore.darJuego2( ) );
        assertEquals( "La cantidad actual del juego 2 deber�a ser 5", 5, appStore.darCantidadActualJuego2( ) );

    }
    /**
     * Prueba 13: verificar el m�todo venderUnidadesJuego3.<br>
     * <b> M�todos a probar: </b> <br>
     * darJuego3<br>
     * comprarUnidadesJuego3<br>
     * venderUnidadesJuego3<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se obtiene el juego sin haber sido ser vendido.<br>
     * 2. Se obtiene el juego despu�s de vender ciertas unidades.<br>
     * 3. Se obtiene null despu�s de vender todas las unidades.<br>
     */
    public void testVenderUnidadesJuego3( )
    {
        setupEscenario1( );
        assertNotNull( "Hay existencia del juego 3. No deber�a ser null", appStore.darJuego3( ) );
        appStore.venderUnidadesJuego3( 20 );
        assertNotNull( "Hay existencia del juego 3. No deber�a ser null", appStore.darJuego3( ) );
        appStore.venderUnidadesJuego3( 2 );
        assertNotNull( "No hay existencia del juego 3. No deber�a ser null", appStore.darJuego3( ) );
        appStore.comprarUnidadesJuego3( 15 );
        assertNotNull( "Hay existencia del juego 3. No deber�a ser null", appStore.darJuego3( ) );
        assertEquals( "La cantidad actual del juego 3 deber�a ser 15", 15, appStore.darCantidadActualJuego3( ) );
    }
    /**
     * Prueba 14: verificar el m�todo darDineroPromedio.<br>
     * <b> M�todos a probar: </b> <br>
     * darDineroPromedio<br>
     * venderUnidadesJuego1<br>
     * venderUnidadesJuego2<br>
     * venderUnidadesJuego3<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El dinero promedio es de los 3 juegos vendidos.<br>
     */
    public void testDarDineroPromedio( )
    {
        setupEscenario1( );

        appStore.venderUnidadesJuego1( 15 );
        appStore.venderUnidadesJuego2( 10 );
        appStore.venderUnidadesJuego3( 5 );

        assertEquals( "El dinero promedio de los juegos vendidos no es el esperado.", 35833.333333333336, appStore.darDineroPromedio( ) );
    }
    /**
     * Prueba 15: verificar el m�todo calcularDescuento.<br>
     * <b> M�todos a probar: </b> <br>
     * calcularDescuento<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se obtiene el descuento de la cantidad de juegos ingresados.<br>
     */
    public void testCalcularDescuento( )
    {
        setupEscenario1( );
        assertEquals( "El descuento realizado no es el esperado.", 507500.0, appStore.calcularDescuento( 10, 5, 10 ) );

    }

}