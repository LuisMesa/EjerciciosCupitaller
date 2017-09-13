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
import uniandes.cupi2.cupiAppStore.mundo.Juego;

/**
 * Clase usada para verificar que los m�todos de la clase Juego est�n correctamente implementados.
 */
public class JuegoTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Juego juego;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo Juego.
     */
    private void setupEscenario1( )
    {
        juego = new Juego( );
        juego.inicializar( "Candy Crush", "Acci�n", 35000, 2000, 45 );
    }

    /**
     * Prueba 1: verifica el m�todo constructor.<br>
     * <b> M�todos a probar: </b> <br>
     * Juego<br>
     * darNombre<br>
     * darCategoria<br>
     * darCantidadActual<br>
     * darTamanio<br>
     * darPrecio<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Creaci�n de una instancia v�lida del juego.<br>
     */
    public void testJuego( )
    {
        setupEscenario1( );
        assertEquals( "Nombre no iniciado correctamente", "Candy Crush", juego.darNombre( ) );
        assertEquals( "Categor�a no iniciada correctamente", "Acci�n", juego.darCategoria( ) );
        assertEquals( "Cantidad actual no iniciada correctamente", 45, juego.darCantidadActual( ) );
        assertEquals( "Tama�o en KB no iniciada correctamente", 2000, juego.darTamanio( ) );
        assertEquals( "Precio no iniciado correctamente", 35000, juego.darPrecio( ) );
    }

    /**
     * Prueba 2: verifica el m�todo venderUnidades.<br>
     * <b> M�todos a probar: </b> <br>
     * venderUnidades<br>
     * darCantidadVendidas<br>
     * darCantidadActual<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se modifica correctamente la cantidad actual del Juego.<br>
     * 2. Se modifica correctamente la cantidad vendidas del Juego.<br>
     */
    public void testVenderUnidades( )
    {
        setupEscenario1( );
        assertEquals( "La cantidad de Juegos restantes no coincide", 45, juego.darCantidadActual( ) );
        assertEquals( "La cantidad de Juegos restantes no coincide", 0, juego.darCantidadVendidas( ) );
        juego.venderUnidades( 10 );
        assertEquals( "La cantidad de Juegos restantes no coincide", 35, juego.darCantidadActual( ) );
        assertEquals( "La cantidad de Juegos restantes no coincide", 10, juego.darCantidadVendidas( ) );
        juego.venderUnidades( 35 );
        assertEquals( "La cantidad de Juegos restantes no coincide", 0, juego.darCantidadActual( ) );
        assertEquals( "La cantidad de Juegos restantes no coincide", 45, juego.darCantidadVendidas( ) );
    }

}
