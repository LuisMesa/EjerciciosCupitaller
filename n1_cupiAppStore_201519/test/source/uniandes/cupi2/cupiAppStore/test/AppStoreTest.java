/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
 * Clase usada para verificar que los métodos de la clase AppStore estén correctamente implementados.
 */
public class AppStoreTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private AppStore appStore;

    // -----------------------------------------------------------------
    // Métodos
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
     * Prueba 1: verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * darJuego1<br>
     * darJuego2<br>
     * darJuego3<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Creación de una instancia válida de EmpresaJuegos, que tiene 4 juegos válidos.<br>
     */
    public void testEmpresaJuegos( )
    {
        setupEscenario1( );
        assertNotNull( "Al crear el juego 1, este debería ser válido", appStore.darJuego1( ) );
        assertNotNull( "Al crear el juego 2, este debería ser válido", appStore.darJuego2( ) );
        assertNotNull( "Al crear el juego 3, este debería ser válido", appStore.darJuego3( ) );

    }

    /**
     * Prueba 2: verifica el método darCantidadActualJuego1.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadActualJuego1<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego tiene la cantidad correcta al ser creado.<br>
     */
    public void testDarCantidadActualJuego1( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad actual del juego debería ser 50", 50, appStore.darCantidadActualJuego1( ) );
    }
    /**
     * Prueba 3: verifica el método darCantidadActualJuego2.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadActualJuego2<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego tiene la cantidad correcta al ser creado.<br>
     */
    public void testDarCantidadActualJuego2( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad actual del juego debería ser 15", 15, appStore.darCantidadActualJuego2( ) );
    }
    /**
     * Prueba 4: verifica el método darCantidadActualJuego3.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadActualJuego3<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego tiene la cantidad correcta al ser creado.<br>
     */
    public void testDarCantidadActualJuego3( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad actual del juego debería ser 22", 22, appStore.darCantidadActualJuego3( ) );
    }

    /**
     * Prueba 5: verifica el método darJuego1.<br>
     * <b> Métodos a probar: </b> <br>
     * darJuego1<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Los juegos han creado correctamente.<br>
     * 2. Se obtienen los juegos por su nombre.<br>
     */
    public void testDarJuego1( )
    {
        setupEscenario1( );
        assertNotNull( "Al crear el Juego 1, este debería ser válido", appStore.darJuego1( ) );

        assertEquals( "Al crear el Juego 1, este debería ser valido", "Candy Crush", appStore.darJuego1( ).darNombre( ) );

    }
    /**
     * Prueba 6: verifica el método darJuego2.<br>
     * <b> Métodos a probar: </b> <br>
     * darJuego2<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Los juegos han creado correctamente.<br>
     * 2. Se obtienen los juegos por su nombre.<br>
     */
    public void testDarJuego2( )
    {
        setupEscenario1( );

        assertNotNull( "Al crear el Juego 2, este debería ser válido", appStore.darJuego2( ) );

        assertEquals( "Al crear el Juego 2, este debería ser valido", "Clash Of Clans", appStore.darJuego2( ).darNombre( ) );

    }
    /**
     * Prueba 7: verifica el método darJuego3.<br>
     * <b> Métodos a probar: </b> <br>
     * darJuego3<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Los juegos han creado correctamente.<br>
     * 2. Se obtienen los juegos por su nombre.<br>
     */
    public void testDarJuego3( )
    {
        setupEscenario1( );

        assertNotNull( "Al crear el Juego 3, este debería ser válido", appStore.darJuego3( ) );

        assertEquals( "Al crear el Juego 3, este debería ser valido", "Fifa 15", appStore.darJuego3( ).darNombre( ) );

    }

    /**
     * Prueba 8: verifica el método comprarUnidadesJuego1.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadActualJuego1<br>
     * comprarUnidadesJuego1<br>
     * venderUnidadesJuego1<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego tiene la cantidad correcta antes de comprar.<br>
     * 2. El juego tiene la cantidad correcta después de comprar.<br>
     */
    public void testComprarUnidadesJuego1( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad actual del juego 1 debería ser 50", 50, appStore.darCantidadActualJuego1( ) );
        appStore.comprarUnidadesJuego1( 13 );
        assertEquals( "La cantidad actual del juego 1 debería ser 63", 63, appStore.darCantidadActualJuego1( ) );
        appStore.venderUnidadesJuego1( 3 );
        appStore.comprarUnidadesJuego1( 5 );
        assertEquals( "La cantidad actual del juego 1 debería ser 65", 65, appStore.darCantidadActualJuego1( ) );

    }
    /**
     * Prueba 9: verifica el método comprarUnidadesJuego2.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadActualJuego2<br>
     * comprarUnidadesJuego2<br>
     * venderUnidadesJuego2<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego tiene la cantidad correcta antes de comprar.<br>
     * 2. El juego tiene la cantidad correcta después de comprar.<br>
     */
    public void testComprarUnidadesJuego2( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad actual del juego 2 debería ser 15", 15, appStore.darCantidadActualJuego2( ) );
        appStore.comprarUnidadesJuego2( 10 );
        assertEquals( "La cantidad actual del juego 2 debería ser 25", 25, appStore.darCantidadActualJuego2( ) );
        appStore.venderUnidadesJuego2( 5 );
        appStore.comprarUnidadesJuego2( 5 );
        assertEquals( "La cantidad actual del juego 2 debería ser 25", 25, appStore.darCantidadActualJuego2( ) );

    }
    /**
     * Prueba 10: verifica el método comprarUnidadesJuego3.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadActualJuego3<br>
     * comprarUnidadesJuego3<br>
     * venderUnidadesJuego3<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego tiene la cantidad correcta antes de comprar.<br>
     * 2. El juego tiene la cantidad correcta después de comprar.<br>
     */
    public void testComprarUnidadesJuego( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad actual del juego 3 debería ser 22", 22, appStore.darCantidadActualJuego3( ) );
        appStore.comprarUnidadesJuego3( 20 );
        assertEquals( "La cantidad actual del juego 3 debería ser 42", 42, appStore.darCantidadActualJuego3( ) );
        appStore.venderUnidadesJuego3( 10 );
        appStore.comprarUnidadesJuego3( 5 );
        assertEquals( "La cantidad actual del juego 3 debería ser 37", 37, appStore.darCantidadActualJuego3( ) );

    }

    /**
     * Prueba 11: verificar el método venderUnidadesJuego1.<br>
     * <b> Métodos a probar: </b> <br>
     * darJuego1<br>
     * comprarUnidadesJuego1<br>
     * venderUnidadesJuego1<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se obtiene el juego sin haber sido ser vendido.<br>
     * 2. Se obtiene el juego después de vender ciertas unidades.<br>
     * 3. Se obtiene null después de vender todas las unidades.<br>
     */
    public void testVenderUnidadesJuego1( )
    {
        setupEscenario1( );
        assertNotNull( "Hay existencia del juego 1. No debería ser null", appStore.darJuego1( ) );
        appStore.venderUnidadesJuego1( 45 );
        assertNotNull( "Hay existencia del juego 1. No debería ser null", appStore.darJuego1( ) );
        appStore.venderUnidadesJuego1( 5 );
        assertNotNull( "No hay existencia del juego 1. No debería ser null", appStore.darJuego1( ) );
        appStore.comprarUnidadesJuego1( 10 );
        assertNotNull( "Hay existencia del juego 1. No debería ser null", appStore.darJuego1( ) );
        assertEquals( "La cantidad actual del juego 1 debería ser 10", 10, appStore.darCantidadActualJuego1( ) );

    }

    /**
     * Prueba 12: verificar el método venderUnidadesJuego2.<br>
     * <b> Métodos a probar: </b> <br>
     * darJuego2<br>
     * comprarUnidadesJuego2<br>
     * venderUnidadesJuego2<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se obtiene el juego sin haber sido ser vendido.<br>
     * 2. Se obtiene el juego después de vender ciertas unidades.<br>
     * 3. Se obtiene null después de vender todas las unidades.<br>
     */
    public void testVenderUnidadesJuego2( )
    {
        setupEscenario1( );
        assertNotNull( "Hay existencia del juego 2. No debería ser null", appStore.darJuego2( ) );
        appStore.venderUnidadesJuego2( 10 );
        assertNotNull( "Hay existencia del juego 2. No debería ser null", appStore.darJuego2( ) );
        appStore.venderUnidadesJuego2( 5 );
        assertNotNull( "No hay existencia del juego 2. No debería ser null", appStore.darJuego2( ) );
        appStore.comprarUnidadesJuego2( 5 );
        assertNotNull( "Hay existencia del juego 2. No debería ser null", appStore.darJuego2( ) );
        assertEquals( "La cantidad actual del juego 2 debería ser 5", 5, appStore.darCantidadActualJuego2( ) );

    }
    /**
     * Prueba 13: verificar el método venderUnidadesJuego3.<br>
     * <b> Métodos a probar: </b> <br>
     * darJuego3<br>
     * comprarUnidadesJuego3<br>
     * venderUnidadesJuego3<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se obtiene el juego sin haber sido ser vendido.<br>
     * 2. Se obtiene el juego después de vender ciertas unidades.<br>
     * 3. Se obtiene null después de vender todas las unidades.<br>
     */
    public void testVenderUnidadesJuego3( )
    {
        setupEscenario1( );
        assertNotNull( "Hay existencia del juego 3. No debería ser null", appStore.darJuego3( ) );
        appStore.venderUnidadesJuego3( 20 );
        assertNotNull( "Hay existencia del juego 3. No debería ser null", appStore.darJuego3( ) );
        appStore.venderUnidadesJuego3( 2 );
        assertNotNull( "No hay existencia del juego 3. No debería ser null", appStore.darJuego3( ) );
        appStore.comprarUnidadesJuego3( 15 );
        assertNotNull( "Hay existencia del juego 3. No debería ser null", appStore.darJuego3( ) );
        assertEquals( "La cantidad actual del juego 3 debería ser 15", 15, appStore.darCantidadActualJuego3( ) );
    }
    /**
     * Prueba 14: verificar el método darDineroPromedio.<br>
     * <b> Métodos a probar: </b> <br>
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
     * Prueba 15: verificar el método calcularDescuento.<br>
     * <b> Métodos a probar: </b> <br>
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