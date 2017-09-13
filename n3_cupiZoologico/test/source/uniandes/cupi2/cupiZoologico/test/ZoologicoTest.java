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
import uniandes.cupi2.cupiZoologico.mundo.Jaula;
import uniandes.cupi2.cupiZoologico.mundo.Zoologico;

/**
 * Clase usada para verificar que los métodos de la clase Zoologico estén correctamente implementados.
 */
public class ZoologicoTest extends TestCase
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Zoologico zoologico;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo zoológico vacío.
     */
    public void setupEscenario1( )
    {
        zoologico = new Zoologico( );
    }

    /**
     * Escenario 2: Construye un nuevo Zoológico y le agrega algunos animales.
     */
    public void setupEscenario2( )
    {
        zoologico = new Zoologico( );
        zoologico.agregarAnimal( "Dumbo", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" );
        zoologico.agregarAnimal( "Rafa", "Girafa", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenGirafa" );
        zoologico.agregarAnimal( "Bugs", "Conejo", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenConejo" );
        zoologico.agregarAnimal( "Po", "Panda", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenPanda" );
        zoologico.agregarAnimal( "Bambi", "Venado", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenVenado" );
        zoologico.agregarAnimal( "Jackie", "Cebra", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenCebra" );
        zoologico.agregarAnimal( "Simba", "Leon", Animal.CARNIVORO, Animal.TERRESTRE, "ImagenLeon" );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * Zoologico<br>
     * darJaulas<br>
     * darCantidadJaulasNorte<br>
     * darCantidadJaulasSur<br>
     * darSector<br>
     * darTamanio<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el zoológico, cada uno de los valores corresponde al esperado.<br>
     */
    public void testZoologico( )
    {
        setupEscenario1( );

        assertNotNull( "El arreglo de jaulas no debe ser nulo.", zoologico.darJaulas( ) );
        assertEquals( "El arreglo de jaulas no tiene el tamaño adecuado.", Zoologico.CANT_JAULAS, zoologico.darJaulas( ).length );

        for( int i = 0; i < Zoologico.CANT_JAULAS; i++ )
        {
            assertNotNull( "No inicializa la jaula " + ( i + 1 )+".", zoologico.darJaula( i ) );
        }

        assertEquals( "Cantidad incorrecta.", 5, zoologico.darCantidadJaulasNorte( ) );
        assertEquals( "Cantidad incorrecta.", 5, zoologico.darCantidadJaulasSur( ) );

        assertEquals( "Sector de la jaula 1 incorrecto.", Jaula.NORTE, zoologico.darJaula( 0 ).darSector( ) );
        assertEquals( "Tamaño de la jaula 1 incorrecto.", Jaula.PEQUENIA, zoologico.darJaula( 0 ).darTamanio( ) );

        assertEquals( "Sector de la jaula 2 incorrecto.", Jaula.NORTE, zoologico.darJaula( 1 ).darSector( ) );
        assertEquals( "Tamaño de la jaula 2 incorrecto.", Jaula.PEQUENIA, zoologico.darJaula( 1 ).darTamanio( ) );

        assertEquals( "Sector de la jaula 3 incorrecto.", Jaula.NORTE, zoologico.darJaula( 2 ).darSector( ) );
        assertEquals( "Tamaño de la jaula 3 incorrecto.", Jaula.MEDIANA, zoologico.darJaula( 2 ).darTamanio( ) );

        assertEquals( "Sector de la jaula 4 incorrecto.", Jaula.NORTE, zoologico.darJaula( 3 ).darSector( ) );
        assertEquals( "Tamaño de la jaula 4 incorrecto.", Jaula.GRANDE, zoologico.darJaula( 3 ).darTamanio( ) );

        assertEquals( "Sector de la jaula 5 incorrecto.", Jaula.NORTE, zoologico.darJaula( 4 ).darSector( ) );
        assertEquals( "Tamaño de la jaula 5 incorrecto.", Jaula.GRANDE, zoologico.darJaula( 4 ).darTamanio( ) );

        assertEquals( "Sector de la jaula 6 incorrecto.", Jaula.SUR, zoologico.darJaula( 5 ).darSector( ) );
        assertEquals( "Tamaño de la jaula 6 incorrecto.", Jaula.GRANDE, zoologico.darJaula( 5 ).darTamanio( ) );

        assertEquals( "Sector de la jaula 7 incorrecto.", Jaula.SUR, zoologico.darJaula( 6 ).darSector( ) );
        assertEquals( "Tamaño de la jaula 7 incorrecto.", Jaula.GRANDE, zoologico.darJaula( 6 ).darTamanio( ) );

        assertEquals( "Sector de la jaula 8 incorrecto.", Jaula.SUR, zoologico.darJaula( 7 ).darSector( ) );
        assertEquals( "Tamaño de la jaula 8 incorrecto.", Jaula.GRANDE, zoologico.darJaula( 7 ).darTamanio( ) );

        assertEquals( "Sector de la jaula 9 incorrecto.", Jaula.SUR, zoologico.darJaula( 8 ).darSector( ) );
        assertEquals( "Tamaño de la jaula 9 incorrecto.", Jaula.MEDIANA, zoologico.darJaula( 8 ).darTamanio( ) );

        assertEquals( "Sector de la jaula 10 incorrecto.", Jaula.SUR, zoologico.darJaula( 9 ).darSector( ) );
        assertEquals( "Tamaño de la jaula 10 incorrecto.", Jaula.PEQUENIA, zoologico.darJaula( 9 ).darTamanio( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método darJaula de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darJaula<br>
     * darJaulas<br>
     * <b> Casos de prueba:</b><br>
     * 1.Se encuentra la jaula.<br>
     */
    public void testDarJaula( )
    {
        setupEscenario1( );
        Jaula jaula = zoologico.darJaula( 0 );
        assertNotNull( "La jaula no está inicializada.", jaula );
        assertEquals( "No retornó la jaula correcta.", zoologico.darJaulas( )[ 0 ], jaula );
    
        jaula = zoologico.darJaula( 9 );
        assertNotNull( "La jaula no está inicializada.", jaula );
        assertEquals( "No retornó la jaula correcta.", zoologico.darJaulas( )[ 9 ], jaula );
    }

    /**
     * Prueba 3: Se encarga de verificar el método darCantidadAnimales de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadAnimales<br>
     * <b> Casos de prueba:</b><br>
     * 1.Se encuentra la cantidad de animales esperada.<br>
     */
    public void testDarCantidadAnimales( )
    {
        setupEscenario2( );
        assertEquals( "No retorna la cantidad de animales correcta.", 7, zoologico.darCantidadAnimales( ) );
        zoologico.agregarAnimal( "Rafiqui", "Mono", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenMono" );
        zoologico.agregarAnimal( "Tony", "Tigre", Animal.CARNIVORO, Animal.TERRESTRE, "ImagenTigre" );
        assertEquals( "No retorna la cantidad de animales correcta.", 9, zoologico.darCantidadAnimales( ) );
    
        zoologico.agregarAnimal( "Puck", "Foca", Animal.CARNIVORO, "Aéreo", "ImagenFoca" );
        assertEquals( "No retorna la cantidad de animales correcta.", 9, zoologico.darCantidadAnimales( ) );
    
        zoologico.agregarAnimal( "Willy", "Ballena", Animal.CARNIVORO, Animal.ACUATICO, "Imagen Ballena" );
        assertEquals( "No retorna la cantidad de animales correcta.", 10, zoologico.darCantidadAnimales( ) );
    }

    /**
     * Prueba 4: Se encarga de verificar el método darCantidadJaulasNorte de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadJaulasNorte<br>
     * <b> Casos de prueba:</b><br>
     * 1.Se encuentra la cantidad esperada de animales de la jaula del sector norte .<br>
     */
    public void testDarCantidadJaulasNorte( )
    {
        setupEscenario1( );
        assertEquals( "No retorna la cantidad de jaulas correcta.", 5, zoologico.darCantidadJaulasNorte( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el método darCantidadJaulasSur de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darCantidadJaulasSur<br>
     * <b> Casos de prueba:</b><br>
     * 1.Se encuentra la cantidad esperada de animales de la jaula del sector sur .<br>
     */
    public void testDarCantidadJaulasSur( )
    {
        setupEscenario1( );
        assertEquals( "No retorna la cantidad de jaulas correcta.", 5, zoologico.darCantidadJaulasSur( ) );
    }

    /**
     * Prueba 6: Se encarga de verificar el método agregarAnimal de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarAnimal<br>
     * buscarJaulaAnimalPorNombre<br>
     * darCantidadAnimales<br>
     * <b> Casos de prueba:</b><br>
     * 1. Agrega correctamente el animal: Los animales terrestres se agregan a jaulas del sector sur y los acuáticos al sector norte<br>
     * 2. Se prueba que no agregue un animal cuando no hay jaula donde se puede agregar.<br>
     */
    public void testAgregarAnimal( )
    {
        setupEscenario1( );
        
        // Caso de prueba 1.
        assertEquals( "Debería poder agregar el animal.", 5, zoologico.agregarAnimal( "Dumbo", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" ) );
        assertEquals( "Agregó en la jaula incorrecta.", 5, zoologico.buscarJaulaAnimalPorNombre( "Dumbo" ) );
        assertEquals( "La cantidad de animales no es correcta.", 1, zoologico.darCantidadAnimales( ) );

        assertEquals( "Debería poder agregar el animal.", 6, zoologico.agregarAnimal( "Tony", "Tigre", Animal.CARNIVORO, Animal.TERRESTRE, "ImagenTigre" ) );
        assertEquals( "Agregó en la jaula incorrecta.", 6, zoologico.buscarJaulaAnimalPorNombre( "Tony" ) );
        assertEquals( "La cantidad de animales no es correcta.", 2, zoologico.darCantidadAnimales( ) );

        assertEquals( "Debería poder agregar el animal.", 7, zoologico.agregarAnimal( "Simba", "Leon", Animal.CARNIVORO, Animal.TERRESTRE, "ImagenLeon" ) );
        assertEquals( "Agregó en la jaula incorrecta.", 7, zoologico.buscarJaulaAnimalPorNombre( "Simba" ) );
        assertEquals( "La cantidad de animales no es correcta.", 3, zoologico.darCantidadAnimales( ) );

        assertEquals( "Debería poder agregar el animal.", 5, zoologico.agregarAnimal( "Rafa", "Jirafa", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenJirafa" ) );
        assertEquals( "Agregó en la jaula incorrecta.", 5, zoologico.buscarJaulaAnimalPorNombre( "Rafa" ) );
        assertEquals( "La cantidad de animales no es correcta.", 4, zoologico.darCantidadAnimales( ) );

        assertEquals( "Debería poder agregar el animal.", 0, zoologico.agregarAnimal( "Homero", "Manati", Animal.HERBIVORO, Animal.ACUATICO, "ImagenManati" ) );
        assertEquals( "Agregó en la jaula incorrecta.", 0, zoologico.buscarJaulaAnimalPorNombre( "Homero" ) );
        assertEquals( "La cantidad de animales no es correcta.", 5, zoologico.darCantidadAnimales( ) );

        assertEquals( "Debería poder agregar el animal.", 1, zoologico.agregarAnimal( "Keiko", "Ballena", Animal.CARNIVORO, Animal.ACUATICO, "ImagenBallena" ) );
        assertEquals( "Agregó en la jaula incorrecta.", 1, zoologico.buscarJaulaAnimalPorNombre( "Keiko" ) );
        assertEquals( "La cantidad de animales no es correcta.", 6, zoologico.darCantidadAnimales( ) );

        // Caso de prueba 2.
        assertEquals( "Debería poder agregar el animal.", 2, zoologico.agregarAnimal( "Bruce", "Tiburón", Animal.CARNIVORO, Animal.ACUATICO, "ImagenTiburón" ) );
        assertEquals( "Debería poder agregar el animal.", 3, zoologico.agregarAnimal( "Don", "Pez Martillo", Animal.CARNIVORO, Animal.ACUATICO, "ImagenPezMartillo" ) );
        assertEquals( "Debería poder agregar el animal.", 4, zoologico.agregarAnimal( "Tim", "Barracuda", Animal.CARNIVORO, Animal.ACUATICO, "ImagenBarracuda" ) );
        assertEquals( "No debería poder agregar el animal.", -1, zoologico.agregarAnimal( "Chung", "Cachalote", Animal.CARNIVORO, Animal.ACUATICO, "ImagenCachalote" ) );

        assertEquals( "Debería poder agregar el animal.", 0, zoologico.agregarAnimal( "Sebastián", "Cangrejo", Animal.HERBIVORO, Animal.ACUATICO, "ImagenCangrejo" ) );
        assertEquals( "No debería poder agregar el animal.", -1, zoologico.agregarAnimal( "Crunch", "Tortuga Marina", Animal.HERBIVORO, Animal.ACUATICO, "ImagenTortuga" ) );

        assertEquals( "Debería poder agregar el animal.", 5, zoologico.agregarAnimal( "Bambi", "Venado", Animal.HERBIVORO, Animal.TERRESTRE, "imagenVenado" ) );
        assertEquals( "Debería poder agregar el animal.", 8, zoologico.agregarAnimal( "Ed", "Hiena", Animal.CARNIVORO, Animal.TERRESTRE, "imagenHiena" ) );

        assertEquals( "Debería poder agregar el animal.", 9, zoologico.agregarAnimal( "Manchitas", "Leopardo", Animal.CARNIVORO, Animal.TERRESTRE, "imagenLeopardo" ) );
        assertEquals( "Debería poder agregar el animal.", 9, zoologico.agregarAnimal( "Manchitas", "Leopardo", Animal.CARNIVORO, Animal.TERRESTRE, "imagenLeopardo" ) );
        assertEquals( "No debería poder agregar el animal.", -1, zoologico.agregarAnimal( "Manchitas", "Leopardo", Animal.CARNIVORO, Animal.TERRESTRE, "imagenLeopardo" ) );
        assertEquals( "No debería poder agregar el animal.", -1, zoologico.agregarAnimal( "Manchitas", "Leopardo", Animal.CARNIVORO, Animal.TERRESTRE, "imagenLeopardo" ) );

        assertEquals( "Debería poder agregar el animal.", 5, zoologico.agregarAnimal( "Phanty", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" ) );
        assertEquals( "Debería poder agregar el animal.", 5, zoologico.agregarAnimal( "Elmer", "Elefante", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" ) );
        assertEquals( "Debería poder agregar el animal.", 5, zoologico.agregarAnimal( "Tomasa", "Cebra", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenCebra" ) );
        assertEquals( "Debería poder agregar el animal.", 5, zoologico.agregarAnimal( "Enrique", "Rinoceronte", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenRinoceronte" ) );
        assertEquals( "Debería poder agregar el animal.", 5, zoologico.agregarAnimal( "Dida", "Hipopótamo", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenHipopotamo" ) );
        assertEquals( "Debería poder agregar el animal.", 5, zoologico.agregarAnimal( "Elie", "Cebra", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" ) );
        assertEquals( "Debería poder agregar el animal.", 5, zoologico.agregarAnimal( "Panda", "Po", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" ) );
        assertEquals( "No debería poder agregar el animal.", -1, zoologico.agregarAnimal( "Loopy", "Po", Animal.HERBIVORO, Animal.TERRESTRE, "ImagenElefante" ) );

    }

    /**
     * Prueba 7: Se encarga de verificar el método eliminarAnimal de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAnimal<br>
     * buscarJaulaAnimalPorNombre<br>
     * darCantidadAnimales<br>
     * <b> Casos de prueba:</b><br>
     * 1. Elimina correctamente el animal.<br>
     * 2. No puede eliminar un animal inexistente.<br>
     */
    public void testEliminarAnimal( )
    {
        setupEscenario2( );
        // Caso de prueba 1.
        assertTrue( "Debería poder eliminar el animal.", zoologico.eliminarAnimal( "Dumbo" ) );
        assertEquals( "El animal no debería encontrarse en ninguna jaula.", -1, zoologico.buscarJaulaAnimalPorNombre( "Dumbo" ) );
        assertEquals( "El número de animales debería haber disminuido.", 6, zoologico.darCantidadAnimales( ) );
        
        // Caso de prueba 2.
        assertFalse( "No debería encontrar el animal.", zoologico.eliminarAnimal( "Mufasa" ) );
        assertEquals( "El número de animales no debería haber disminuido.", 6, zoologico.darCantidadAnimales( ) );

    }

    /**
     * Prueba 8: Se encarga de verificar el método buscarJaulaAnimalPorNombre de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarJaulaAnimalPorNombre<br>
     * <b> Casos de prueba:</b><br>
     * 1. Se encuentran los animales buscados.<br>
     */
    public void testBuscarJaulaAnimalPorNombre1( )
    {
        setupEscenario2( );
        assertEquals( "No se encontró el animal correctamente.", 5, zoologico.buscarJaulaAnimalPorNombre( "Dumbo" ) );
        assertEquals( "No se encontró el animal correctamente.", 6, zoologico.buscarJaulaAnimalPorNombre( "Simba" ) );
    }

    /**
     * Prueba 9: Se encarga de verificar el método buscarJaulaAnimalPorNombre de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarJaulaAnimalPorNombre<br>
     * <b> Casos de prueba:</b><br>
     * 1. No se encuentran los animales buscados.<br>
     */
    public void testBuscarJaulaAnimalPorNombre2( )
    {
        setupEscenario2( );
        assertEquals( "No debería encontrar el animal.", -1, zoologico.buscarJaulaAnimalPorNombre( "Dumbozz" ) );
        assertEquals( "No debería encontrar el animal.", -1, zoologico.buscarJaulaAnimalPorNombre( "Rafiqui" ) );
    }

    /**
     * Prueba 10: Se encarga de verificar el método buscarJaulaMayorCantidadAnimales de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarJaulaMayorCantidadAnimales<br>
     * <b> Casos de prueba:</b><br>
     * 1. No puede buscar correctamente la jaula con mayor cantidad de animales ya que no hay animales.<br>
     * 2. Busca correctamente la jaula con mayor cantidad de animales.<br>
     */
    public void testBuscarJaulaMayorCantidadAnimales( )
    {
        setupEscenario1( );
        
        // Caso de prueba 1.
        assertEquals( "No debería haber encontrado ninguna jaula.", -1, zoologico.buscarJaulaMayorCantidadAnimales( ) );
        
        // Caso de prueba 2.
        zoologico.agregarAnimal( "Homero", "Manati", Animal.HERBIVORO, Animal.ACUATICO, "ImagenManati" );
        assertEquals( "La jaula encontrada es incorrecta.", 0, zoologico.buscarJaulaMayorCantidadAnimales( ) );

        setupEscenario2( );
        // Caso de prueba 2.
        assertEquals( "La jaula encontrada es incorrecta.", 5, zoologico.buscarJaulaMayorCantidadAnimales( ) );

    }

    /**
     * Prueba 11: Se encarga de verificar el método calcularPorcentajeOcupacionJaulas de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularPorcentajeOcupacionJaulas<br>
     * <b> Casos de prueba:</b><br>
     * 1. El promedio es el esperado.<br>
     */
    public void testCalcularPorcentajeOcupacionJaula( )
    {
        setupEscenario2( );
        assertEquals( "El promedio calculado es incorrecto.", 10.30, zoologico.calcularPorcentajeOcupacionJaulas( ), 0.2 );
    }

    /**
     * Prueba 12: Se encarga de verificar el método existenJaulasConMismaCantidadAnimales de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * exitenJaulasConMismaCantidadAnimales<br>
     * <b> Casos de prueba:</b><br>
     * 1. No hay jaulas con la misma cantidad de animales.<br>
     * 2. Encuentra la jaula con la misma cantidad de animales.<br>
     */
    public void testExistenJaulasConMismaCantidadAnimales( )
    {
        setupEscenario2( );
        // Caso de prueba 1.
        assertFalse( "No hay dos jaulas con la misma cantidad.", zoologico.existenJaulasConMismaCantidadAnimales( ) );
        zoologico.agregarAnimal( "Tony", "Tigre", Animal.CARNIVORO, Animal.TERRESTRE, "ImagenTigre" );
        
        // Caso de prueba 2.
        assertTrue( "Hay dos jaulas con la misma cantidad.", zoologico.existenJaulasConMismaCantidadAnimales( ) );
    }
}