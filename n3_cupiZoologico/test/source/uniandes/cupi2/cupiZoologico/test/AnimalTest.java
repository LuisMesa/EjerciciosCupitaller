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
import uniandes.cupi2.cupiZoologico.mundo.Animal;

/**
 * Clase usada para verificar la correcta implementación de Animal.
 */
public class AnimalTest extends TestCase
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Animal animal;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo animal.
     */
    public void setupEscenario1( )
    {
        animal = new Animal( "Dumbo", "Elefante", Animal.HERBIVORO, Animal.ACUATICO, "imagenElefante" );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
        assertEquals( "Tipo inicializado incorrectamente.", "Herbívoro", animal.darTipo( ) );
        assertEquals( "Hábitat inicializado incorrectamente.", "Acuático", animal.darHabitat( ) );
        assertEquals( "Imagen inicializada incorrectamente.", "imagenElefante", animal.darImagen( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método toString de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * toString<br>
     * <b> Casos de prueba:</b><br>
     * 1.Representación del animal.<br>
     */
    public void testToString( )
    {
        setupEscenario1( );
        assertEquals( "La representación String del animal no es correcta.", "Dumbo (Elefante)", animal.toString( ) );
    }
}