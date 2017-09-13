/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
 * Clase usada para verificar la correcta implementación de Guardia.
 */
public class GuardiaTest extends TestCase
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Guardia guardia;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo guardia.
     */
    public void setupEscenario1( )
    {
        guardia = new Guardia( "GuardiaPrueba", 2 );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
        assertEquals( "Años de experiencia inicializada incorrectamente.", 2, guardia.darAnhosExperiencia( ) );
    }

}