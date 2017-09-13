/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n3_avion
 * Autor: Equipo Cupi2.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.avion.test;

import uniandes.cupi2.avion.mundo.Equipaje;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los m�todos de la clase Equipaje est�n correctamente implementados.
 */
public class EquipajeTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Equipaje equipaje;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo Equipaje.
     */
    private void setupEscenario1( )
    {
        equipaje = new Equipaje( Equipaje.EQUIPAJE_DE_MANO, 111, "d1", 1, 2, 3 );
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darCategoria<br>
     * darPeso<br>
     * darCiudadDestino<br>
     * darAncho<br>
     * darLargo<br>
     * darAlto<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el equipaje, cada uno de los valores corresponde al esperado.<br>
     */
    public void testEquipaje( )
    {
        setupEscenario1( );
        assertEquals( "La categor�a deber�a ser <Equipaje de mano>.", Equipaje.EQUIPAJE_DE_MANO, equipaje.darCategoria( ) );
        assertEquals( "La peso del equipaje deber�a ser 111.0.", 111.0, equipaje.darPeso( ) );
        assertEquals( "La ciudad destino deber�a ser d1", "d1", equipaje.darCiudadDestino( ) );
        assertEquals( "El ancho deber�a ser 1.0.", 1.0, equipaje.darAncho( ) );
        assertEquals( "El largo deber�a ser 2.0.", 2.0, equipaje.darLargo( ) );
        assertEquals( "El alto deber�a ser 3.0.", 3.0, equipaje.darAlto( ) );
    }

}
