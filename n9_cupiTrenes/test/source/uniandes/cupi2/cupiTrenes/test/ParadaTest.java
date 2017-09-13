/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_cupiTrenes
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiTrenes.test;

import java.util.Date;

import uniandes.cupi2.cupiTrenes.mundo.Parada;
import junit.framework.TestCase;

/**
 * Clase usada para verificar la correcta implementaci�n de Parada.
 */
public class ParadaTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Parada parada;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea una nueva parada.
     */
    public void setupEscenario1( )
    {
        Date horario = new Date( );
        horario.setHours( 2 );
        horario.setMinutes( 0 );
        parada = new Parada( "Munich", horario );
    }
    
    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * Parada <br>
     * darNombre <br>
     * darHorario <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Construye correctamente la parada del escenario 1, cada uno de los valores corresponde al esperado.
     */
    public void testParada( )
    {
        setupEscenario1( );
        
        assertEquals( "No inicializ� el nombre de la parada correctamente.", "Munich", parada.darNombre( ) );
        assertEquals( "No inicializ� el horario de la parada correctamente.", "02:00", parada.darHorario( ) );
    }

}
