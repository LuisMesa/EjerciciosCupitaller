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
import uniandes.cupi2.cupiZoologico.mundo.Jaula;

/**
 * Clase usada para verificar la correcta implementaci�n de Jaula.
 */
public class JaulaTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Jaula jaula;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea una nueva jaula vac�a en el sector sur.
     */
    public void setupEscenario1( )
    {
        jaula = new Jaula( Jaula.SUR, Jaula.GRANDE );
    }

    /**
     * Escenario 2: Crea una nueva jaula vac�a en el sector norte.
     */
    public void setupEscenario2( )
    {
        jaula = new Jaula( Jaula.NORTE, Jaula.PEQUENIA );
    }

    /**
     * Escenario 3: Crea una nueva jaula con 2 animales.
     */
    public void setupEscenario3( )
    {
        jaula = new Jaula( Jaula.SUR, Jaula.MEDIANA );
        jaula.agregarAnimal( "Dumbo", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" );
        jaula.agregarAnimal( "Rafa", "Girafa", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenGirafa" );
        jaula.asignarGuardia( "Guardia", 2 );
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * Jaula<br>
     * darSector<br>
     * darTamanio<br>
     * darAnimales<br>
     * darCantidadAnimales<br>
     * <b> Caso de prueba 1:</b><br>
     * 1. Construye correctamente la jaula: 1 jaula en sector sur, 2 animales y un guardia.<br>
     */
    public void testJaula( )
    {
        setupEscenario3( );

        assertNotNull( jaula );
        assertEquals( "Sector de la jaula inicializado incorrectamente.", Jaula.SUR, jaula.darSector( ) );
        assertEquals( "Tama�o de la jaula inicializado incorrectamente.", Jaula.MEDIANA, jaula.darTamanio( ) );
        assertNotNull( "La lista de animales deber�a ser inicializada.", jaula.darAnimales( ) );
        assertTrue( "El n�mero de animales deber�a ser dos.", jaula.darCantidadAnimales( ) == 2 );
        assertNotNull( "El guardia fue creado incorrectamente.", jaula.darGuardia( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo darCapacidadJaula de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darCapacidadJaula<br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye una jaula grande (es decir, con capacidad 10).<br>
     */
    public void testDarCapacidadJaula1( )
    {
        setupEscenario1( );
        assertEquals( "No retorna la capacidad correcta.", 10, jaula.darCapacidadJaula( ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el m�todo darCapacidadJaula de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darCapacidadJaula<br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye una jaula peque�a (es decir, con capacidad 2).<br>
     */
    public void testDarCapacidadJaula2( )
    {
        setupEscenario2( );
        assertEquals( "No retorna la capacidad correcta.", 2, jaula.darCapacidadJaula( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el m�todo darCapacidadJaula de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darCapacidadJaula<br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye una jaula mediana (es decir, con capacidad 6).<br>
     */
    public void testDarCapacidadJaula3( )
    {
        setupEscenario3( );
        assertEquals( "No retorna la capacidad correcta.", 6, jaula.darCapacidadJaula( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el m�todo darCantidadAnimales de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darCantidadAnimales<br>
     * agregarAnimal<br>
     * eliminarAnimal<br>
     * <b> Casos de prueba:</b><br>
     * 1. La jaula tiene animales.<br>
     * 2. La jaula no tiene animales.<br>
     */
    public void testDarCantidadAnimales( )
    {
        setupEscenario2( );
        
        // Caso de prueba 2.
        assertEquals( "No retorna la cantidad de animales correcta.", 0, jaula.darCantidadAnimales( ) );
        jaula.agregarAnimal( "Simba", "Le�n", Animal.CARNIVORO, Animal.TERRESTRE, "Imagenle�n" );
        
        // Caso de prueba 1.
        assertEquals( "No retorna la cantidad de animales correcta.", 1, jaula.darCantidadAnimales( ) );
        jaula.agregarAnimal( "Mufasa", "Le�n", Animal.CARNIVORO, Animal.TERRESTRE, "Imagenle�n" );
        
        // Caso de prueba 1.
        assertEquals( "No retorna la cantidad de animales correcta.", 2, jaula.darCantidadAnimales( ) );
        jaula.agregarAnimal( "Nala", "Le�n", Animal.CARNIVORO, Animal.TERRESTRE, "Imagenle�n" );
        
        // Caso de prueba 1.
        assertEquals( "No retorna la cantidad de animales correcta.", 3, jaula.darCantidadAnimales( ) );
        jaula.eliminarAnimal( "Mufasa" );
        
        // Caso de prueba 1.
        assertEquals( "No retorna la cantidad de animales correcta.", 2, jaula.darCantidadAnimales( ) );
        jaula.eliminarAnimal( "Simba" );
        
        // Caso de prueba 1.
        assertEquals( "No retorna la cantidad de animales correcta.", 1, jaula.darCantidadAnimales( ) );
        jaula.eliminarAnimal( "Nala" );
        
        // Caso de prueba 2.
        assertEquals( "No retorna la cantidad de animales correcta.", 0, jaula.darCantidadAnimales( ) );
    }

    /**
     * Prueba 6: Se encarga de verificar el m�todo agregarAnimal de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarAnimal<br>
     * darCantidadAnimales<br>
     * darAnimales<br>
     * darNombre<br>
     * darEspecie<br>
     * darTipo<br>
     * darHabitat<br>
     * darImagen<br>
     * <b> Casos de prueba:</b><br>
     * 1. Agrega correctamente el animal.<br>
     */
    public void testAgregarAnimal( )
    {
        setupEscenario1( );

        assertEquals( "El n�mero de animales es incorrecto.", 0, jaula.darCantidadAnimales( ) );

        jaula.agregarAnimal( "Dumbo", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" );

        assertEquals( "El n�mero de animales es incorrecto.", 1, jaula.darCantidadAnimales( ) );

        Animal a = ( Animal )jaula.darAnimales( ).get( 0 );
        assertEquals( "Error al crear el animal.", "Dumbo", a.darNombre( ) );
        assertEquals( "Error al crear el animal.", "Elefante", a.darEspecie( ) );
        assertEquals( "Error al crear el animal.", Animal.HERBIVORO, a.darTipo( ) );
        assertEquals( "Error al crear el animal.", Animal.TERRESTRE, a.darHabitat( ) );
        assertEquals( "Error al crear el animal.", "ImagenElefante", a.darImagen( ) );

        jaula.agregarAnimal( "Rafa", "Girafa", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenGirafa" );

        a = ( Animal )jaula.darAnimales( ).get( 1 );
        assertEquals( "Error al crear el animal.", "Rafa", a.darNombre( ) );
        assertEquals( "Error al crear el animal.", "Girafa", a.darEspecie( ) );
        assertEquals( "Error al crear el animal.", Animal.HERBIVORO, a.darTipo( ) );
        assertEquals( "Error al crear el animal.", Animal.TERRESTRE, a.darHabitat( ) );
        assertEquals( "Error al crear el animal.", "ImagenGirafa", a.darImagen( ) );
    }

    /**
     * Prueba 7: Se encarga de verificar el m�todo darGuardia de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darGuardia<br>
     * <b> Casos de prueba:</b><br>
     * 1. No se tiene guardia asignado a la jaula.<br>
     */
    public void testAsignarGuardia( )
    {
        setupEscenario1( );
        assertNull( "No deber�a haber un guardia asignado.", jaula.darGuardia( ) );
        
        // Caso de prueba 1.
        jaula.asignarGuardia( "Guardia1", 2 );
        assertNotNull( "El guardia fue creado incorrectamente.", jaula.darGuardia( ) );
        
    }

    /**
     * Prueba 8: Se encarga de verificar el m�todo eliminarAnimal de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * eliminarAnimal<br>
     * darCantidadAnimales<br>
     * existeAnimalEnJaula<br>
     * <b> Casos de prueba:</b><br>
     * 1. Elimina un animal de la jaula.<br>
     * 2. No hay animal para ser eliminado de la jaula.<br>
     */
    public void testEliminarAnimal( )
    {
        setupEscenario3( );
        // Caso de prueba 1.
        assertTrue( "Deber�a poder eliminar el animal.", jaula.eliminarAnimal( "Dumbo" ) );
        assertEquals( "El n�mero de animales es incorrecto.", 1, jaula.darCantidadAnimales( ) );
        assertFalse( "El animal no deberia estar en la jaula.", jaula.existeAnimalEnJaula( "Dumbo" ) );
        
        // Caso de prueba 2.
        assertFalse( "No deberia poder eliminar ningun animal.", jaula.eliminarAnimal( "Rafiqui" ) );
        assertEquals( "El n�mero de animales es incorrecto.", 1, jaula.darCantidadAnimales( ) );
    }

    /**
     * Prueba 9: Se encarga de verificar el m�todo hayAnimalCarnivoro de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * hayAnimalCarnivoro<br>
     * agregarAnimal<br>
     * eliminarAnimal<br>
     * <b> Casos de prueba:</b><br>
     * 1. No hay animales carn�voras en la jaula.<br>
     * 2. Hay animales carn�voras en la jaula.<br>
     */
    public void testHayAnimalCarnivoro( )
    {
        setupEscenario1( );
        // Caso de prueba 1.
        assertFalse( "No hay ning�n animal carn�voro en la jaula.", jaula.hayAnimalCarnivoro( ) );
        
        // Caso de prueba 2.
        jaula.agregarAnimal( "Simba", "Leon", Animal.CARNIVORO, Animal.TERRESTRE, "ImagenLeon" );
        assertTrue( "S� hay un animal carn�voro en la jaula.", jaula.hayAnimalCarnivoro( ) );

        jaula.agregarAnimal( "Mufasa", "Leon", Animal.CARNIVORO, Animal.TERRESTRE, "ImagenLeon" );
        assertTrue( "S� hay un animal carn�voro en la jaula.", jaula.hayAnimalCarnivoro( ) );

        jaula.eliminarAnimal( "Simba" );
        assertTrue( "S� hay un animal carn�voro en la jaula.", jaula.hayAnimalCarnivoro( ) );
        
        // Caso de prueba 1.
        jaula.eliminarAnimal( "Mufasa" );
        assertFalse( "No hay ning�n animal carn�voro en la jaula.", jaula.hayAnimalCarnivoro( ) );

        jaula.agregarAnimal( "Dumbo", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" );
        assertFalse( "No hay ning�n animal carn�voro en la jaula.", jaula.hayAnimalCarnivoro( ) );
    }

    /**
     * Prueba 10: Se encarga de verificar el m�todo hayEspacionEnJaula de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * hayEspacionEnJaula<br>
     * agregarAnimal<br>
     * <b> Casos de prueba:</b><br>
     * 1.La jaula es de tama�o grande (capacidad: 10).
     */
    public void testHayEspacionEnJaula1( )
    {
        setupEscenario1( );
        assertTrue( "La jaula deber�a tener espacio.", jaula.hayEspacioEnJaula( ) );
        
        jaula.agregarAnimal( "Dumbo", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" );
        jaula.agregarAnimal( "Melvin", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" );
        assertTrue( "La jaula deber�a tener espacio.", jaula.hayEspacioEnJaula( ) );
        
        jaula.agregarAnimal( "Rafa", "Girafa", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenGirafa" );
        jaula.agregarAnimal( "Bugs", "Conejo", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenConejo" );
        jaula.agregarAnimal( "Po", "Panda", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenPanda" );
        jaula.agregarAnimal( "Bambi", "Venado", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenVenado" );
        assertTrue( "La jaula deber�a tener espacio.", jaula.hayEspacioEnJaula( ) );
        
        jaula.agregarAnimal( "Koki", "Koala", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenKoala" );
        jaula.agregarAnimal( "Jackie", "Cebra", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenCebra" );
        jaula.agregarAnimal( "Marti", "Cebra", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenCebra" );
        jaula.agregarAnimal( "Moose", "Alce", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenAlce" );
        assertFalse( "La jaula no deber�a tener espacio.", jaula.hayEspacioEnJaula( ) );
    }

    /**
     * Prueba 11: Se encarga de verificar el m�todo hayEspacionEnJaula de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * hayEspacionEnJaula<br>
     * agregarAnimal<br>
     * <b> Casos de prueba:</b><br>
     * 1.La jaula es de tama�o peque�o (capacidad: 2).
     */
    public void testHayEspacionEnJaula2( )
    {
        setupEscenario2( );
        assertTrue( "La jaula deber�a tener espacio.", jaula.hayEspacioEnJaula( ) );
        jaula.agregarAnimal( "Dumbo", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" );
        jaula.agregarAnimal( "Melvin", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" );
        assertFalse( "La jaula no deber�a tener espacio.", jaula.hayEspacioEnJaula( ) );
    }

    /**
     * Prueba 12: Se encarga de verificar el m�todo hayEspacionEnJaula de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * hayEspacionEnJaula<br>
     * agregarAnimal<br>
     * <b> Casos de prueba:</b><br>
     * 1.La jaula es de tama�o mediano (capacidad: 6).
     */
    public void testHayEspacionEnJaula3( )
    {
        setupEscenario3( );
        assertTrue( "La jaula deber�a tener espacio.", jaula.hayEspacioEnJaula( ) );
        jaula.agregarAnimal( "Dumbo", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" );
        jaula.agregarAnimal( "Melvin", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" );
        jaula.agregarAnimal( "Rafa", "Girafa", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenGirafa" );
        jaula.agregarAnimal( "Bugs", "Conejo", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenConejo" );
        assertFalse( "La jaula no deber�a tener espacio.", jaula.hayEspacioEnJaula( ) );
    }

    /**
     * Prueba 13: Se encarga de verificar el m�todo existeAnimalEnJaula de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * existeAnimalEnJaula<br>
     * <b> Casos de prueba:</b><br>
     * 1.La jaula es de tama�o mediano.
     */
    public void testExisteAnimalEnJaula( )
    {
        setupEscenario3( );
        assertFalse( "El animal no existe en la jaula.", jaula.existeAnimalEnJaula( "Simba" ) );
        assertTrue( "El animal existe en la jaula.", jaula.existeAnimalEnJaula( "Dumbo" ) );
        assertTrue( "El animal existe en la jaula.", jaula.existeAnimalEnJaula( "Rafa" ) );
    }

    /**
     * Prueba 14: Se encarga de verificar el m�todo puedeAgregarPorHabitat de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * puedeAgregarPorHabitat<br>
     * <b> Casos de prueba:</b><br>
     * 1.La jaula est� en el sector sur.
     */
    public void testPuedeAgregarPorHabitat1( )
    {
        setupEscenario1( );
        assertTrue( "Deber�a poder agregar el animal.", jaula.puedeAgregarPorHabitat( Animal.TERRESTRE ) );
        assertFalse( "No deber�a poder agregar el animal.", jaula.puedeAgregarPorHabitat( Animal.ACUATICO ) );
    }

    /**
     * Prueba 15: Se encarga de verificar el m�todo puedeAgregarPorHabitat de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * puedeAgregarPorHabitat<br>
     * <b> Casos de prueba:</b><br>
     * 1.La jaula est� en el sector norte.
     */
    public void testPuedeAgregarPorHabitat2( )
    {
        setupEscenario2( );
        assertFalse( "No deber�a poder agregar el animal.", jaula.puedeAgregarPorHabitat( Animal.TERRESTRE ) );
        assertTrue( "Deber�a poder agregar el animal.", jaula.puedeAgregarPorHabitat( Animal.ACUATICO ) );
    }

    /**
     * Prueba 16: Se encarga de verificar el m�todo puedeAgregarPorTipoYEspecie de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * puedeAgregarPorTipoYEspecie<br>
     * agregarAnimal<br>
     * <b> Casos de prueba:</b><br>
     * 1.Existe un carn�voro en la jaula.
     */
    public void testPuedeAgregarPorTipoYEspecie1( )
    {
        setupEscenario2( );
        assertTrue( "Deber�a poder agregar el animal.", jaula.puedeAgregarPorTipoYEspecie( "Ballena", Animal.CARNIVORO ) );
        jaula.agregarAnimal( "Willy", "Ballena", Animal.CARNIVORO, Animal.ACUATICO, "Imagen" );

        assertTrue( "Deber�a poder agregar el animal.", jaula.puedeAgregarPorTipoYEspecie( "Ballena", Animal.CARNIVORO ) );
        jaula.agregarAnimal( "Keiko", "Ballena", Animal.CARNIVORO, Animal.ACUATICO, "Imagen" );

        assertFalse( "No deber�a poder agregar el animal.", jaula.puedeAgregarPorTipoYEspecie( "Tortuga Marina", Animal.HERBIVORO ) );

        assertFalse( "No deber�a poder agregar el animal.", jaula.puedeAgregarPorTipoYEspecie( "Tibur�n", Animal.CARNIVORO ) );
    }

    /**
     * Prueba 17: Se encarga de verificar el m�todo puedeAgregarPorTipoYEspecie de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * puedeAgregarPorTipoYEspecie<br>
     * agregarAnimal<br>
     * <b> Casos de prueba:</b><br>
     * 1.Existe un herb�voro en la jaula.
     */
    public void testPuedeAgregarPorTipoYEspecie3( )
    {
        setupEscenario2( );
        assertTrue( "Deber�a poder agregar el animal.", jaula.puedeAgregarPorTipoYEspecie( "Elefante", Animal.HERBIVORO ) );
        jaula.agregarAnimal( "Dumbo", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "Imagen" );

        assertTrue( "Deber�a poder agregar el animal.", jaula.puedeAgregarPorTipoYEspecie( "Gazela", Animal.HERBIVORO ) );
        jaula.agregarAnimal( "Bambi", "Gazela", Animal.HERBIVORO, Animal.TERRESTRE, "Imagen" );

        assertFalse( "No deber�a poder agregar el animal.", jaula.puedeAgregarPorTipoYEspecie( "Tigre", Animal.CARNIVORO ) );
    }

    /**
     * Prueba 18: Se encarga de verificar el m�todo puedeAgregarAnimal de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * puedeAgregarAnimal<br>
     * agregarAnimal<br>
     * <b> Casos de prueba:</b><br>
     * 1.La jaula tiene un animal carn�voro.
     */
    public void testPuedeAgregarAnimal1( )
    {
        setupEscenario1( );
        assertTrue( "Deber�a poder agregar el animal.", jaula.puedeAgregarAnimal( "Leon", Animal.CARNIVORO, Animal.TERRESTRE ) );
        jaula.agregarAnimal( "Simba", "Leon", Animal.CARNIVORO, Animal.TERRESTRE, "ImagenLeon" );

        assertTrue( "Deber�a poder agregar el animal.", jaula.puedeAgregarAnimal( "Leon", Animal.CARNIVORO, Animal.TERRESTRE ) );
        jaula.agregarAnimal( "Mufasa", "Leon", Animal.CARNIVORO, Animal.TERRESTRE, "ImagenLeon" );

        assertFalse( "Hay un carn�voro de otra especie. No deber�a poder agregar el animal.", jaula.puedeAgregarAnimal( "Tigre", Animal.CARNIVORO, Animal.TERRESTRE ) );
        assertFalse( "Hay un carn�voro. No deber�a poder agregar el animal.", jaula.puedeAgregarAnimal( "Elefante", Animal.HERBIVORO, Animal.TERRESTRE ) );
    }

    /**
     * Prueba 19: Se encarga de verificar el m�todo puedeAgregarAnimal de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * puedeAgregarAnimal<br>
     * agregarAnimal<br>
     * <b> Casos de prueba:</b><br>
     * 1.La jaula tiene un animal herb�voro.
     */
    public void testPuedeAgregarAnimal2( )
    {
        setupEscenario1( );
        assertTrue( "Deber�a poder agregar el animal.", jaula.puedeAgregarAnimal( "Elefante", Animal.HERBIVORO, Animal.TERRESTRE ) );
        jaula.agregarAnimal( "Dumbo", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" );

        assertTrue( "Deber�a poder agregar el animal.", jaula.puedeAgregarAnimal( "Elefante", Animal.HERBIVORO, Animal.TERRESTRE ) );
        assertTrue( "Deber�a poder agregar el animal.", jaula.puedeAgregarAnimal( "Venado", Animal.HERBIVORO, Animal.TERRESTRE ) );
        jaula.agregarAnimal( "Bambi", "Venado", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenVenado" );
        assertTrue( "Deber�a poder agregar el animal.", jaula.puedeAgregarAnimal( "Cebra", Animal.HERBIVORO, Animal.TERRESTRE ) );
        assertFalse( "No deber�a poder agregar el animal.", jaula.puedeAgregarAnimal( "Tigre", Animal.CARNIVORO, Animal.TERRESTRE ) );
    }

}