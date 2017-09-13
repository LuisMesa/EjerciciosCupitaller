/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.test;

import java.util.ArrayList;
import uniandes.cupi2.cupiCava.mundo.CupiCava;
import uniandes.cupi2.cupiCava.mundo.Vino;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los m�todos de la clase Cava est�n correctamente implementados.
 */
public class CupiCavaTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private CupiCava cupiCava;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva cava vac�a.
     */
    public void setupEscenario1( )
    {
        cupiCava = new CupiCava( );
    }

    /**
     * Escenario 2: Construye una nueva cava con 3 vinos.
     */
    public void setupEscenario2( )
    {
        cupiCava = new CupiCava( );

        cupiCava.agregarVino( "Alamos Chardonnay", Vino.BOTELLA, 2006, 35, Vino.SEMI_DULCE, Vino.BLANCO, "Mendoza, Argentina", "imagen1" );
        cupiCava.agregarVino( "Marqu�s de Gri�on Reserva", Vino.BARRIL, 2000, 7, Vino.ABOCADO, Vino.TINTO, "Toledo, Espa�a", "imagen2" );
        cupiCava.agregarVino( "Castillo de Javier", Vino.BOTELLA, 2006, 20, Vino.SEMI_SECO, Vino.ROSADO, "Navarra, Espa�a", "imagen3" );
    }

    /**
     * Escenario 3: Construye una nueva cava con 7 vinos.
     */
    public void setupEscenario3( )
    {
        cupiCava = new CupiCava( );

        cupiCava.agregarVino( "Alamos Chardonnay", Vino.BOTELLA, 2006, 35, Vino.SEMI_DULCE, Vino.BLANCO, "Mendoza, Argentina", "imagen1" );
        cupiCava.agregarVino( "Mont-Ferrant Brut Nature Vintage", Vino.BARRIL, 2010, 2, Vino.SECO, Vino.BLANCO, "Espa�a", "imagen2" );
        cupiCava.agregarVino( "Marqu�s de Gri�on Reserva", Vino.BARRIL, 2000, 7, Vino.ABOCADO, Vino.TINTO, "Toledo, Espa�a", "imagen3" );
        cupiCava.agregarVino( "Camino Real", Vino.BOTELLA, 2008, 15, Vino.SEMI_SECO, Vino.TINTO, "Chile", "imagen4" );
        cupiCava.agregarVino( "Conde de Rioja", Vino.BOTELLA, 2010, 25, Vino.SEMI_SECO, Vino.BLANCO, "Colombia", "imagen5" );
        cupiCava.agregarVino( "Castillo de Javier", Vino.BOTELLA, 2006, 20, Vino.SEMI_SECO, Vino.ROSADO, "Navarra, Espa�a", "imagen6" );
        cupiCava.agregarVino( "Tavel Aoc", Vino.BOTELLA, 2008, 55, Vino.DULCE, Vino.ROSADO, "Francia", "imagen7" );
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darVinos<br>
     * Cava<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente la cava, cada uno de los valores corresponde al esperado.<br>
     */
    public void testCava( )
    {
        setupEscenario1( );
        assertNotNull( "La lista de vinos no puede ser nula.", cupiCava.darVinos( ) );
        assertEquals( "La lista de vinos debi� crearse vac�a.", 0, cupiCava.darVinos( ).size( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo agregarVino de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarVino<br>
     * darVinos<br>
     * <b> Caso de prueba 1:</b><br>
     * No hay vinos en la cava.<br>
     */
    public void testAgregarVino1( )
    {
        setupEscenario1( );

        // Verificar que se haya agregado el vino
        boolean vinoAgregado = cupiCava.agregarVino( "Alamos Chardonnay", Vino.BOTELLA, 2006, 35, Vino.SEMI_DULCE, Vino.BLANCO, "Mendoza, Argentina", "imagen1" );
        assertTrue( "Siempre se debe poder agregar el primer vino.", vinoAgregado );

        ArrayList vinos = cupiCava.darVinos( );
        assertEquals( "El vino no se agreg� a la lista de vinos.", 1, vinos.size( ) );

        // Datos del vino que se agreg� en la lista
        Vino vino = ( Vino )vinos.get( 0 );
        assertEquals( "El nombre del vino no es el esperado.", "Alamos Chardonnay", vino.darNombre( ) );
        assertEquals( "La presentaci�n del vino no es la esperada.", Vino.BOTELLA, vino.darPresentacion( ) );
        assertEquals( "El a�o de elaboraci�n del vino no es el esperado.", 2006, vino.darAnhoElaboracion( ) );
        assertEquals( "El contenido en az�car del vino no es el esperado.", 35.0, vino.darContenidoAzucar( ) );
        assertEquals( "El tipo del vino no es el esperado.", Vino.SEMI_DULCE, vino.darTipo( ) );
        assertEquals( "El color del vino no es el esperado.", Vino.BLANCO, vino.darColor( ) );
        assertEquals( "El lugar de origen del vino no es el esperado.", "Mendoza, Argentina", vino.darLugarOrigen( ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el m�todo agregarVino de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarVino<br>
     * darVinos<br>
     * <b> Caso de prueba 1:</b><br>
     * Hay vinos en la cava.<br>
     */
    public void testAgregarVino2( )
    {
        setupEscenario2( );

        // Verificar que se haya ingresado el vino
        boolean vinoAgregado = cupiCava.agregarVino( "Mont-Ferrant", Vino.BARRIL, 2010, 2, Vino.SECO, Vino.BLANCO, "Espa�a", "imagen4" );
        assertTrue( "Error al agregar el vino", vinoAgregado );

        ArrayList vinos = cupiCava.darVinos( );
        assertEquals( "El vino no se agreg� a la lista de vinos", 4, vinos.size( ) );

        // Datos del vino que se agreg� en la lista
        Vino vino = ( Vino )vinos.get( 3 );
        assertEquals( "El nombre del vino no es el esperado.", "Mont-Ferrant", vino.darNombre( ) );
        assertEquals( "La presentaci�n del vino no es la esperada.", Vino.BARRIL, vino.darPresentacion( ) );
        assertEquals( "El a�o de elaboraci�n del vino no es el esperado.", 2010, vino.darAnhoElaboracion( ) );
        assertEquals( "El contenido en az�car del vino no es el esperado.", 2.0, vino.darContenidoAzucar( ) );
        assertEquals( "El tipo del vino no es el esperado.", Vino.SECO, vino.darTipo( ) );
        assertEquals( "El color del vino no es el esperado.", Vino.BLANCO, vino.darColor( ) );
        assertEquals( "El lugar de origen del vino no es el esperado.", "Espa�a", vino.darLugarOrigen( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el m�todo agregarVino de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarVino<br>
     * darVinos<br>
     * <b> Caso de prueba 1:</b><br>
     * Ya existe un vino en la cava con el nombre del que se quiere agregar.<br>
     */
    public void testAgregarVinoError( )
    {
        setupEscenario2( );

        // Verificar que no se haya agregado el vino
        boolean vinoAgregado = cupiCava.agregarVino( "Alamos Chardonnay", Vino.BOTELLA, 2006, 35, Vino.SEMI_DULCE, Vino.BLANCO, "Mendoza, Argentina", "nombre" );
        assertFalse( "No debi� haber agregado el vino.", vinoAgregado );
        assertEquals( "El n�mero de vinos de la cava no debi� cambiar.", 3, cupiCava.darVinos( ).size( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el m�todo buscarVino de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarVino<br>
     * <b> Casos de prueba:</b><br>
     * 1. El vino existe.<br>
     * 2. El vino no existe.
     */
    public void testBuscarVino( )
    {
        setupEscenario2( );

        Vino buscado = cupiCava.buscarVino( "Castillo de Javier" );
        assertNotNull( "Debi� haber encontrado un vino con el nombre dado.", buscado );

        assertNull( "No debi� haber encontrado un vino con el nombre dado.", cupiCava.buscarVino( "inexistente" ) );
    }

    /**
     * Prueba 6: Se encarga de verificar el m�todo ordenarPorNombre de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * ordenarVinosPorNombre<br>
     * compararPorNombre<br>
     * darVinos<br>
     * <b> Casos de prueba:</b><br>
     * 1. Los vinos no est�n ordenados.<br>
     */
    public void testOrdenarVinosPorNombre( )
    {
        //TODO Parte3 PuntoD Complete el m�todo seg�n la documentaci�n dada.
    	int a =2;
    	--a;
    	System.out.println(a);
    	//System.out.println(++a);
    	//System.out.println(a--);
    	//System.out.println(--a);
    }

    /**
     * Prueba 7: Se encarga de verificar el m�todo ordenarPorAnhoElaboracion de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * ordenarVinosPorAnhoElaboracion<br>
     * compararPorAnhoElaboracion<br>
     * darVinos<br>
     * <b> Casos de prueba:</b><br>
     * 1. Los vinos no est�n ordenados.<br>
     */
    public void testOrdenarPorAnhoElaboracion( )
    {
        //TODO Parte3 PuntoE Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Prueba 8: Se encarga de verificar el m�todo ordenarPorLugarOrigen de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * ordenarVinosPorLugarOrigen<br>
     * compararPorLugarOrigen<br>
     * darVinos<br>
     * <b> Casos de prueba:</b><br>
     * 1. Los vinos no est�n ordenados.<br>
     */
    public void testOrdenarVinosPorLugarOrigen( )
    {
        //TODO Parte3 PuntoF Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Prueba 9: Se encarga de verificar el m�todo buscarBinarioPorNombre de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * ordenarVinosPorNombre<br>
     * buscarBinarioPorNombre<br>
     * darNombre<br>
     * <b> Casos de prueba:</b><br>
     * 1. El vino existe.<br>
     * 2. El vino no existe.<br>
     */
    public void testBuscarBinarioPorNombre( )
    {
        //TODO Parte4 PuntoE Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Prueba 10: Se encarga de verificar el m�todo buscarVinoMasDulce de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarVinoMasDulce<br>
     * darVinos<br>
     * darNombre<br>
     * <b> Casos de prueba:</b><br>
     * 1. El vino m�s dulce existe.<br>
     */
    public void testBuscarVinoMasDulce( )
    {
        //TODO Parte4 PuntoF Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Prueba 11: Se encarga de verificar el m�todo buscarVinoMasSeco de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarVinoMasSeco<br>
     * darVinos<br>
     * darNombre<br>
     * <b> Casos de prueba:</b><br>
     * 1. El vino m�s seco existe.<br>
     */
    public void testBuscarVinoMasSeco( )
    {
        //TODO Parte4 PuntoG Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Prueba 12: Se encarga de verificar el m�todo buscarVinosDeTipo de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarVinosDeTipo<br>
     * darTipo<br>
     * <b> Casos de prueba:</b><br>
     * 1. Existen vinos con el tipo dado.<br>
     */
    public void testBuscarVinosDeTipo( )
    {
        setupEscenario3( );

        ArrayList vinos = cupiCava.buscarVinosDeTipo( Vino.DULCE );
        assertEquals( "No se realiz� la b�squeda correctamente.", 1, vinos.size( ) );

        for( int i = 0; i < vinos.size( ); i++ )
        {
            Vino vino = ( Vino )vinos.get( i );
            assertEquals( "No se buscaron correctamente los vinos.", vino.darTipo( ), Vino.DULCE );
        }

        vinos = cupiCava.buscarVinosDeTipo( Vino.SEMI_SECO );
        assertEquals( "No se realiz� la b�squeda correctamente.", 3, vinos.size( ) );

        for( int i = 0; i < vinos.size( ); i++ )
        {
            Vino vino = ( Vino )vinos.get( i );
            assertEquals( "No se buscaron correctamente los vinos.", vino.darTipo( ), Vino.SEMI_SECO );
        }
    }
}