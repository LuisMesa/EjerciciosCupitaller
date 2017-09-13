/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_inscripcionCedulas
 * Autor: Equipo Cupi2 - 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.inscripcionCedulas.test;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import uniandes.cupi2.inscripcionCedulas.mundo.Ciudadano;

/**
 * Clase que verifica la correcta implementación de los métodos de la clase Ciudadano.
 */
public class CiudadanoTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Ciudadano ciudadano;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo ciudadano.
     */
    private void setupEscenario1( )
    {
        Calendar calendar = Calendar.getInstance( );
        int anioActual = calendar.get( Calendar.YEAR );
        int mesActual = calendar.get( Calendar.MONTH );
        int diaActual = calendar.get( Calendar.DAY_OF_MONTH );
        calendar.set( anioActual - 22, mesActual, diaActual );
        Date fechaNacimiento = calendar.getTime( );

        calendar.set( anioActual - 3, mesActual, 15 );
        Date fechaExpedicion = calendar.getTime( );

        ciudadano = new Ciudadano( "123", "Pérez", "Carlos", fechaNacimiento, "Bogotá", Ciudadano.MASCULINO, fechaExpedicion, "Bogotá" );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darCedula<br>
     * darApellidos<br>
     * darNombres<br>
     * darFechaNacimiento<br>
     * darLugarNacimiento<br>
     * darSexo<br>
     * darEdad<br>
     * darFechaExpedicion<br>
     * darLugarExpedicion<br>
     * Ciudadano<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el ciudadano, cada uno de los valores corresponde al esperado.<br>
     */
    public void testCiudadano( )
    {
        setupEscenario1( );

        Calendar calendar = Calendar.getInstance( );
        int anioActual = calendar.get( Calendar.YEAR );
        int mesActual = calendar.get( Calendar.MONTH );
        int diaActual = calendar.get( Calendar.DAY_OF_MONTH );
        calendar.set( anioActual - 22, mesActual, diaActual );
        Date fechaNacimiento = calendar.getTime( );

        calendar.set( anioActual - 3, mesActual, 15 );
        Date fechaExpedicion = calendar.getTime( );

        assertEquals( "La cédula del ciudadano no es la esperada.", "123", ciudadano.darCedula( ) );
        assertEquals( "Los apellidos del ciudadanos no son los esperados.", "Pérez", ciudadano.darApellidos( ) );
        assertEquals( "Los nombres del ciudadano no son los esperados.", "Carlos", ciudadano.darNombres( ) );
        assertEquals( "El año de nacimiento del ciudadano no es el esperado.", fechaNacimiento.getYear( ), ciudadano.darFechaNacimiento( ).getYear( ) );
        assertEquals( "El mes de nacimiento del ciudadano no es el esperado.", fechaNacimiento.getMonth( ), ciudadano.darFechaNacimiento( ).getMonth( ) );
        assertEquals( "El día de nacimiento del ciudadano no es el esperado.", fechaNacimiento.getDay( ), ciudadano.darFechaNacimiento( ).getDay( ) );
        assertEquals( "El lugar de nacimiento del ciudadano no es el esperado.", "Bogotá", ciudadano.darLugarNacimiento( ) );
        assertEquals( "El sexo del ciudadano no es el esperado.", Ciudadano.MASCULINO, ciudadano.darSexo( ) );
        assertTrue( "La fecha de expedición de la cédula del ciudadano no es la esperada.", fechaExpedicion.compareTo( ciudadano.darFechaExpedicion( ) ) == 0 );
        assertEquals( "El lugar de expedición de la cédula del ciudadano no es el esperado.", "Bogotá", ciudadano.darLugarExpedicion( ) );
        assertEquals( "La edad del ciudadano no es la esperada.", 22, ciudadano.darEdad( ) );
    }
    /**
     * Prueba 2: Se encarga de verificar el método toString de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * toString<br>
     * <b> Casos de prueba:</b><br>
     * 1. El formato de texto es el correcto.<br>
     */
    public void testToString( )
    {
        setupEscenario1( );
        assertEquals( "El formato del toString no es el esperado.", ciudadano.darNombres( ) + " " + ciudadano.darApellidos( ) + " - " + ciudadano.darCedula( ), ciudadano.toString( ) );
    }

}