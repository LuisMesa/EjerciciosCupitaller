/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_cupiPortafolio
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiPortafolio.test;


import junit.framework.*;
import uniandes.cupi2.cupiPortafolio.mundo.*;

/**
 * Clase usada para verificar que los métodos de la clase Estudiante estén correctamente implementados.
 */
public class EstudianteTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Estudiante de prueba.
     */
    private Estudiante estudiante;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea una mitología sin dioses.
     */
    public void setupEscenario1( )
    {
        estudiante = new Estudiante( "EstudiantePrueba", 100, 5, 4.5, 105, true, "RutaImagen" );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * Estudiante<br>
     * darNombre<br>
     * darCodigo<br>
     * darSemestre<br>
     * darPromedio<br>
     * darCreditosVistos<br>
     * darEstadoEstudiante<br>
     * darRutaImagen<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el elemento, cada uno de los valores corresponde al esperado.<br>
     */
    public void testEstudiante( )
    {
        setupEscenario1( );

        assertEquals( "El nombre del estudiante debería ser EstudiantePrueba.", "EstudiantePrueba", estudiante.darNombre( ) );
        assertEquals( "El código del estudiante debería ser 100.", 100, estudiante.darCodigo( ) );
        assertEquals( "El semestre del estudiante debería ser 5.", 5, estudiante.darSemestre( ) );
        assertEquals( "El promedio del estudiante debería ser 4.5.", 4.5, estudiante.darPromedio( ) );
        assertEquals( "El número de créditos vistos por el estudiante debería ser 105.", 105.0, estudiante.darCreditosVistos( ) );
        assertTrue( "El estado del estudiante debería ser true.", estudiante.darEstadoEstudiante( ) );
        assertEquals( "La ruta de la imagen debería ser RutaImagen.", "RutaImagen", estudiante.darRutaImagen( ) );

    }
    
    /**
     * Prueba 2: Se encarga de verificar el método cambiarPromedio de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * cambiarPromedio<br>
     * darPromedio<br>
     * <b> Caso de prueba 1:</b><br>
     *  Se cambia el promedio del estudiante.
     */
    public void testDarPrimerEstudiante2( )
    {
        setupEscenario1( );

        try
        {
            estudiante.cambiarPromedio( 3 );
            assertEquals( "El promedio del estudiante debería ser 3.0.", 3.0, estudiante.darPromedio( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }

    }

}