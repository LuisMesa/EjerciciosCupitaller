/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiZoologico
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiZoologico.test;

import junit.framework.TestCase;
import uniandes.cupi2.cupiZoologico.mundo.Guardia;

/**
 * Clase usada para verificar la correcta implementaci�n de Guardia.
 */
public class GuardiaTest extends TestCase
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Guardia guardia;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo guardia.
     */
    public void setupEscenario1( )
    {
        guardia = new Guardia( "GuardiaPrueba", 2 );
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * Guardia<br>
     * darNombre<br>
     * darAnhosExperiencia<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el guardia, cada uno de los valores corresponde al esperado.<br>
     */
    public void testGuardia( )
    {
        setupEscenario1( );

        assertEquals( "Nombre inicializado incorrectamente.", "GuardiaPrueba", guardia.darNombre( ) );
        assertEquals( "A�os de experiencia inicializada incorrectamente.", 2, guardia.darAnhosExperiencia( ) );
    }

}