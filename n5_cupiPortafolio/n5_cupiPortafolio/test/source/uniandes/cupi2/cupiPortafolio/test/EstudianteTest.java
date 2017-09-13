/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Clase usada para verificar que los m�todos de la clase Estudiante est�n correctamente implementados.
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
    // M�todos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea una mitolog�a sin dioses.
     */
    public void setupEscenario1( )
    {
        estudiante = new Estudiante( "EstudiantePrueba", 100, 5, 4.5, 105, true, "RutaImagen" );
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
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

        assertEquals( "El nombre del estudiante deber�a ser EstudiantePrueba.", "EstudiantePrueba", estudiante.darNombre( ) );
        assertEquals( "El c�digo del estudiante deber�a ser 100.", 100, estudiante.darCodigo( ) );
        assertEquals( "El semestre del estudiante deber�a ser 5.", 5, estudiante.darSemestre( ) );
        assertEquals( "El promedio del estudiante deber�a ser 4.5.", 4.5, estudiante.darPromedio( ) );
        assertEquals( "El n�mero de cr�ditos vistos por el estudiante deber�a ser 105.", 105.0, estudiante.darCreditosVistos( ) );
        assertTrue( "El estado del estudiante deber�a ser true.", estudiante.darEstadoEstudiante( ) );
        assertEquals( "La ruta de la imagen deber�a ser RutaImagen.", "RutaImagen", estudiante.darRutaImagen( ) );

    }
    
    /**
     * Prueba 2: Se encarga de verificar el m�todo cambiarPromedio de la clase.<br>
     * <b> M�todos a probar: </b> <br>
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
            assertEquals( "El promedio del estudiante deber�a ser 3.0.", 3.0, estudiante.darPromedio( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }

    }

}