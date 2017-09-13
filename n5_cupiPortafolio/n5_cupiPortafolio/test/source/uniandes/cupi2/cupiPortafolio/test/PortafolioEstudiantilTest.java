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
 * Clase usada para verificar que los m�todos de la clase PortafolioEstudiantil est�n correctamente implementados.
 */
public class PortafolioEstudiantilTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * PortafolioEstudiantil de prueba.
     */
    private PortafolioEstudiantil portafolioEstudiantil;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea el portafolio estudiantil con el archivo de propiedades.
     */
    public void setupEscenario1( )
    {
        try
        {
            portafolioEstudiantil = new PortafolioEstudiantil( );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }

    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo darPrimerEstudiante de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darPrimerEstudiante<br>
     * <b> Caso de prueba 1:</b><br>
     * Ya se encuentra en el primer estudiante.
     */
    public void testDarPrimerEstudiante1( )
    {
        setupEscenario1( );

        try
        {
            portafolioEstudiantil.darPrimerEstudiante( );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            // Debe pasar por ac�
        }

    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo darPrimerEstudiante de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darPrimerEstudiante<br>
     * darEstudianteSiguiente<br>
     * darNombre<br>
     * <b> Caso de prueba 1:</b><br>
     * No se encuentra en el primer estudiante.
     */
    public void testDarPrimerEstudiante2( )
    {
        setupEscenario1( );

        try
        {
            portafolioEstudiantil.darEstudianteSiguiente( );
            Estudiante estudiante = portafolioEstudiantil.darPrimerEstudiante( );
            assertEquals( "El nombre del estudiante deber�a ser Rafael ALK", "Rafael ALK", estudiante.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }

    }

    /**
     * Prueba 3: Se encarga de verificar el m�todo darEstudianteAnterior de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darEstudianteAnterior<br>>
     * <b> Caso de prueba 1:</b><br>
     * Se encuentra en el primer estudiante.
     */
    public void testDarEstudianteAnterior1( )
    {
        setupEscenario1( );

        try
        {
            portafolioEstudiantil.darEstudianteAnterior( );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            // Debe pasar por ac�
        }

    }

    /**
     * Prueba 4: Se encarga de verificar el m�todo darEstudianteAnterior de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darEstudianteAnterior<br>
     * darEstudianteSiguiente<br>
     * darNombre<br>
     * <b> Caso de prueba 1:</b><br>
     * Se encuentra en el primer estudiante.
     */
    public void testDarEstudianteAnterior2( )
    {
        setupEscenario1( );

        try
        {
            portafolioEstudiantil.darEstudianteSiguiente( );
            Estudiante estudiante = portafolioEstudiantil.darEstudianteAnterior( );
            assertEquals( "El nombre del estudiante deber�a ser Rafael ALK", "Rafael ALK", estudiante.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }

    }

    /**
     * Prueba 5: Se encarga de verificar el m�todo darEstudianteSiguiente de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darEstudianteSiguiente<br>
     * darNombre<br>
     * <b> Caso de prueba 1:</b><br>
     * Existe estudiante siguiente.
     */
    public void testDarEstudianteSiguiente1( )
    {
        setupEscenario1( );

        try
        {
            Estudiante estudiante = portafolioEstudiantil.darEstudianteSiguiente( );
            assertEquals( "El nombre de la mitolog�a deber�a ser Jaime Carvajal", "Jaime Carvajal", estudiante.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }

    }

    /**
     * Prueba 6: Se encarga de verificar el m�todo darEstudianteSiguiente de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darEstudianteSiguiente<br>
     * darUltimoEstudiante<br>
     * <b> Caso de prueba 1:</b><br>
     * Se encuentra en el �ltimo estudiante.
     */
    public void testDarEstudianteSiguiente2( )
    {
        setupEscenario1( );

        try
        {
            portafolioEstudiantil.darUltimoEstudiante( );
            Estudiante estudiante = portafolioEstudiantil.darEstudianteSiguiente( );
            fail( "Deber�a generar excepci�n" );
        }
        catch( Exception e )
        {
            // Debe pasar por aqu�
        }

    }

    /**
     * Prueba 7: Se encarga de verificar el m�todo darUltimoEstudiante de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darUltimoEstudiante<br>
     * darNombre<br>
     * <b> Caso de prueba 1:</b><br>
     * Se encuentra en el primer estudiante.
     */
    public void testDarUltimoEstudiante1( )
    {
        setupEscenario1( );

        try
        {
            Estudiante estudiante = portafolioEstudiantil.darUltimoEstudiante( );
            assertEquals( "El nombre de la mitolog�a deber�a ser Sergio Gonz�lez.", "Sergio Gonz�lez", estudiante.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }

    }

    /**
     * Prueba 8: Se encarga de verificar el m�todo darUltimoEstudiante de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darUltimoEstudiante<br>
     * <b> Caso de prueba 1:</b><br>
     * Ya se encuentra en el �ltimo estudiante.
     */
    public void testDarUltimoEstudiante2( )
    {
        setupEscenario1( );

        try
        {
            portafolioEstudiantil.darUltimoEstudiante( );
            Estudiante estudiante = portafolioEstudiantil.darUltimoEstudiante( );
            fail( "Deber�a generar excepci�n" );
        }
        catch( Exception e )
        {
            // Debe pasar por aqu�
        }

    }

    /**
     * Prueba 9: Se encarga de verificar el m�todo buscarEstudiante de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarEstudiante<br>
     * darCodigo<br>
     * <b> Caso de prueba 1:</b><br>
     * No existe estudiante con el c�digo dado.<br>
     * <b> Caso de prueba 2:</b><br>
     * Existe estudiante con c�digo dado.
     */
    public void testBuscarEstudiante( )
    {
        setupEscenario1( );

        Estudiante estudiante = portafolioEstudiantil.buscarEstudiante( 20993434 );
        assertNull( "No deber�a existir un estudiante con el c�digo 20993434.", estudiante );

        estudiante = portafolioEstudiantil.buscarEstudiante( 201123456 );
        assertNotNull( "Debe existir un estudiante con el codigo 201123456.", estudiante );
        assertEquals( "El c�digo de la estudiante deber�a ser 201123456.", 201123456, estudiante.darCodigo( ) );

    }
    

}