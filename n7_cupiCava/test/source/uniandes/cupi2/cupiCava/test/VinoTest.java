/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.test;

import junit.framework.TestCase;
import uniandes.cupi2.cupiCava.mundo.Vino;

/**
 * Clase usada para verificar que los métodos de la clase Vino estén correctamente implementados.
 */
public class VinoTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Vino vino1;

    /**
     * Clase donde se harán las pruebas.
     */
    private Vino vino2;

    /**
     * Clase donde se harán las pruebas.
     */
    private Vino vino3;

    /**
     * Clase donde se harán las pruebas.
     */
    private Vino vino4;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Construye dos vinos
     */
    public void setupEscenario1( )
    {
        vino1 = new Vino( "nombre1", Vino.BARRIL, 1991, 10, Vino.ABOCADO, Vino.BLANCO, "lugar1", "imagen1" );
        vino2 = new Vino( "nombre2", Vino.BOTELLA, 1992, 20, Vino.DULCE, Vino.ROSADO, "lugar2", "imagen2" );
        vino3 = new Vino( "nombre3", Vino.BOTELLA, 1993, 30, Vino.SEMI_DULCE, Vino.TINTO, "lugar3", "imagen3" );
        vino4 = new Vino( "nombre1", Vino.BARRIL, 1991, 10, Vino.ABOCADO, Vino.BLANCO, "lugar1", "imagen1" );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * Vino<br>
     * darNombre<br>
     * darPresentacion<br>
     * darAnhoElaboracion<br>
     * darContenidoAzucar<br>
     * darTipo<br>
     * darColor<br>
     * darImagen<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el vino, cada uno de los valores corresponde al esperado.<br>
     */
    public void testVino( )
    {
        setupEscenario1( );

        assertNotNull( "El nombre del vino no fue inicializado.", vino1.darNombre( ) );
        assertEquals( "El nombre del vino no corresponde.", "nombre1", vino1.darNombre( ) );

        assertNotNull( "La presentación del vino no fue inicializada.", vino1.darPresentacion( ) );
        assertEquals( "La presentación del vino no corresponde.", Vino.BARRIL, vino1.darPresentacion( ) );

        assertNotNull( "El año de elaboración del vino no fue inicializado.", vino1.darAnhoElaboracion( ) );
        assertEquals( "El año de elaboración del vino no corresponde.", 1991, vino1.darAnhoElaboracion( ) );

        assertNotNull( "El contenido en azúcar del vino no fue inicializado.", vino1.darContenidoAzucar( ) );
        assertEquals( "El contenido en azúcar del vino no corresponde.", 10.0, vino1.darContenidoAzucar( ) );

        assertNotNull( "El tipo del vino no fue inicializado.", vino1.darTipo( ) );
        assertEquals( "El tipo del vino no corresponde.", Vino.ABOCADO, vino1.darTipo( ) );

        assertNotNull( "El color del vino no fue inicializado.", vino1.darColor( ) );
        assertEquals( "El color del vino no corresponde.", Vino.BLANCO, vino1.darColor( ) );

        assertNotNull( "El lugar de origen del vino no fue inicializado.", vino1.darLugarOrigen( ) );
        assertEquals( "El lugar de origen del vino no corresponde.", "lugar1", vino1.darLugarOrigen( ) );

        assertNotNull( "La imagen del vino no fue inicializado.", vino1.darImagen( ) );
        assertEquals( "La imagen del vino no corresponde.", "imagen1", vino1.darImagen( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método compararPorNombre de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * compararPorNombre<br>
     * <b> Casos de prueba:</b><br>
     * 1. El vino1 es igual al vino4 con respecto al nombre.<br>
     * 2. El vino1 es menor al vino2 con respecto al nombre.<br>
     * 3. El vino3 es mayor al vino2 con respecto al nombre.
     */
    public void testCompararPorNombre( )
    {
        //TODO Parte2 PuntoE Complete el método según la documentación dada.
    	setupEscenario1();
    	
    	assertEquals ("El nombre no es igual", 0,vino1.compararPorNombre(vino4));
    	assertEquals ("El nombre no es menor",-1,vino1.compararPorNombre(vino2));
    	assertEquals ("El nombre no es mayor",1,vino3.compararPorNombre(vino2));
    }

    /**
     * Prueba 4: Se encarga de verificar el método compararPorAnhoElaboracion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * compararPorAnhoElaboracion<br>
     * <b> Casos de prueba:</b><br>
     * 1. El vino1 es igual al vino4 con respecto al año de elaboración.<br>
     * 2. El vino1 es menor al vino2 con respecto al año de elaboración.<br>
     * 3. El vino3 es mayor al vino1 con respecto al año de elaboración.
     */
    public void testCompararPorAnhoElaboracion( )
    {
        setupEscenario1( );

        //TODO Parte2 PuntoF Complete el método según la documentación dada.
        assertTrue ("Deberia ser igual",0==vino1.compararPorAnhoElaboracion(vino4));
        assertTrue ("El vino1 es menor al vino2",-1>=vino1.compararPorAnhoElaboracion(vino2));
        assertTrue("El vino3 es mayor al vino1",1<=vino3.compararPorAnhoElaboracion(vino1));
    }

    /**
     * Prueba 4: Se encarga de verificar el método compararPorLugarOrigen de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * compararPorLugarOrigen<br>
     * <b> Casos de prueba:</b><br>
     * 1. El vino1 es igual al vino4 con respecto al lugar de origen.<br>
     * 2. El vino1 es menor al vino2 con respecto al lugar de origen.<br>
     * 3. El vino3 es mayor al vino1 con respecto al lugar de origen.
     */
    public void testCompararPorLugarOrigen( )
    {
        setupEscenario1( );

        //TODO Parte2 PuntoG Complete el método según la documentación dada.
        assertEquals("El vino1 deberia ser igual al vino 4",0,vino1.compararPorLugarOrigen(vino4));
        assertEquals("El vino1 deberia ser menor al vino 2",-1,vino1.compararPorLugarOrigen(vino2));
        assertEquals("El vino3 deberia ser mayor al vino 1",1,vino3.compararPorLugarOrigen(vino1));
        
    }

    /**
     * Prueba 5: Se encarga de verificar el método compararPorContenidoAzucar de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * compararPorContenidoAzucar<br>
     * <b> Casos de prueba:</b><br>
     * 1. El vino1 es igual al vino4 con respecto al contenido en azúcar.<br>
     * 2. El vino1 es menor al vino2 con respecto al contenido en azúcar.<br>
     * 3. El vino3 es mayor al vino1 con respecto al contenido en azúcar.
     */
    public void testCompararPorContenidoAzucar( )
    {
        setupEscenario1( );

        //TODO Parte2 PuntoH Complete el método según la documentación dada.
        assertEquals("El vino1 deberia ser igual al vino 4",0,vino1.compararPorContenidoAzucar(vino4));
        assertEquals("El vino1 deberia ser menor al vino 2",-1,vino1.compararPorContenidoAzucar(vino2));
        assertEquals("El vino3 deberia ser mayor al vino 1",1,vino3.compararPorContenidoAzucar(vino1));
    }
}