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
 * Clase usada para verificar que los métodos de la clase PortafolioEstudiantil estén correctamente implementados.
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
    // Métodos
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
            fail( "No debería lanzar excepción." );
        }

    }

    /**
     * Prueba 1: Se encarga de verificar el método darPrimerEstudiante de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            // Debe pasar por acá
        }

    }

    /**
     * Prueba 2: Se encarga de verificar el método darPrimerEstudiante de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
            assertEquals( "El nombre del estudiante debería ser Rafael ALK", "Rafael ALK", estudiante.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }

    }

    /**
     * Prueba 3: Se encarga de verificar el método darEstudianteAnterior de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            // Debe pasar por acá
        }

    }

    /**
     * Prueba 4: Se encarga de verificar el método darEstudianteAnterior de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
            assertEquals( "El nombre del estudiante debería ser Rafael ALK", "Rafael ALK", estudiante.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }

    }

    /**
     * Prueba 5: Se encarga de verificar el método darEstudianteSiguiente de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
            assertEquals( "El nombre de la mitología debería ser Jaime Carvajal", "Jaime Carvajal", estudiante.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }

    }

    /**
     * Prueba 6: Se encarga de verificar el método darEstudianteSiguiente de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darEstudianteSiguiente<br>
     * darUltimoEstudiante<br>
     * <b> Caso de prueba 1:</b><br>
     * Se encuentra en el último estudiante.
     */
    public void testDarEstudianteSiguiente2( )
    {
        setupEscenario1( );

        try
        {
            portafolioEstudiantil.darUltimoEstudiante( );
            Estudiante estudiante = portafolioEstudiantil.darEstudianteSiguiente( );
            fail( "Debería generar excepción" );
        }
        catch( Exception e )
        {
            // Debe pasar por aquí
        }

    }

    /**
     * Prueba 7: Se encarga de verificar el método darUltimoEstudiante de la clase.<br>
     * <b> Métodos a probar: </b> <br>
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
            assertEquals( "El nombre de la mitología debería ser Sergio González.", "Sergio González", estudiante.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }

    }

    /**
     * Prueba 8: Se encarga de verificar el método darUltimoEstudiante de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darUltimoEstudiante<br>
     * <b> Caso de prueba 1:</b><br>
     * Ya se encuentra en el último estudiante.
     */
    public void testDarUltimoEstudiante2( )
    {
        setupEscenario1( );

        try
        {
            portafolioEstudiantil.darUltimoEstudiante( );
            Estudiante estudiante = portafolioEstudiantil.darUltimoEstudiante( );
            fail( "Debería generar excepción" );
        }
        catch( Exception e )
        {
            // Debe pasar por aquí
        }

    }

    /**
     * Prueba 9: Se encarga de verificar el método buscarEstudiante de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarEstudiante<br>
     * darCodigo<br>
     * <b> Caso de prueba 1:</b><br>
     * No existe estudiante con el código dado.<br>
     * <b> Caso de prueba 2:</b><br>
     * Existe estudiante con código dado.
     */
    public void testBuscarEstudiante( )
    {
        setupEscenario1( );

        Estudiante estudiante = portafolioEstudiantil.buscarEstudiante( 20993434 );
        assertNull( "No debería existir un estudiante con el código 20993434.", estudiante );

        estudiante = portafolioEstudiantil.buscarEstudiante( 201123456 );
        assertNotNull( "Debe existir un estudiante con el codigo 201123456.", estudiante );
        assertEquals( "El código de la estudiante debería ser 201123456.", 201123456, estudiante.darCodigo( ) );

    }
    

}