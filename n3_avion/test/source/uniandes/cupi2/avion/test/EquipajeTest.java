/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
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
 * Clase usada para verificar que los métodos de la clase Equipaje estén correctamente implementados.
 */
public class EquipajeTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Equipaje equipaje;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo Equipaje.
     */
    private void setupEscenario1( )
    {
        equipaje = new Equipaje( Equipaje.EQUIPAJE_DE_MANO, 111, "d1", 1, 2, 3 );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
        assertEquals( "La categoría debería ser <Equipaje de mano>.", Equipaje.EQUIPAJE_DE_MANO, equipaje.darCategoria( ) );
        assertEquals( "La peso del equipaje debería ser 111.0.", 111.0, equipaje.darPeso( ) );
        assertEquals( "La ciudad destino debería ser d1", "d1", equipaje.darCiudadDestino( ) );
        assertEquals( "El ancho debería ser 1.0.", 1.0, equipaje.darAncho( ) );
        assertEquals( "El largo debería ser 2.0.", 2.0, equipaje.darLargo( ) );
        assertEquals( "El alto debería ser 3.0.", 3.0, equipaje.darAlto( ) );
    }

}
