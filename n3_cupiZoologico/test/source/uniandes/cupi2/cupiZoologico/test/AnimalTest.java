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
import uniandes.cupi2.cupiZoologico.mundo.Animal;

/**
 * Clase usada para verificar la correcta implementaci�n de Animal.
 */
public class AnimalTest extends TestCase
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Animal animal;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo animal.
     */
    public void setupEscenario1( )
    {
        animal = new Animal( "Dumbo", "Elefante", Animal.HERBIVORO, Animal.ACUATICO, "imagenElefante" );
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * Animal<br>
     * darNombre<br>
     * darEspecie<br>
     * darHabitat<br>
     * darImagen<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el animal, cada uno de los valores corresponde al esperado.<br>
     */
    public void testAnimal( )
    {
        setupEscenario1( );

        assertEquals( "Nombre inicializado incorrectamente.", "Dumbo", animal.darNombre( ) );
        assertEquals( "Especie inicializada incorrectamente.", "Elefante", animal.darEspecie( ) );
        assertEquals( "Tipo inicializado incorrectamente.", "Herb�voro", animal.darTipo( ) );
        assertEquals( "H�bitat inicializado incorrectamente.", "Acu�tico", animal.darHabitat( ) );
        assertEquals( "Imagen inicializada incorrectamente.", "imagenElefante", animal.darImagen( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo toString de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * toString<br>
     * <b> Casos de prueba:</b><br>
     * 1.Representaci�n del animal.<br>
     */
    public void testToString( )
    {
        setupEscenario1( );
        assertEquals( "La representaci�n String del animal no es correcta.", "Dumbo (Elefante)", animal.toString( ) );
    }
}