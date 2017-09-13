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
import uniandes.cupi2.inscripcionCedulas.mundo.PuestoVotacion;

/**
 * Clase que verifica correcta implementación de la clase PuestoVotacion.
 */
public class PuestoVotacionTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private PuestoVotacion puestoVotacion;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo puesto de votación vacío.
     */
    private void setupEscenario1( )
    {
        puestoVotacion = new PuestoVotacion( "puesto", "dir" );
    }

    /**
     * Escenario 2: Construye un nuevo puesto de votación con ciudadanos inscritos.
     */
    private void setupEscenario2( )
    {
        puestoVotacion = new PuestoVotacion( "puesto", "dir" );

        Calendar calendar = Calendar.getInstance( );
        int anioActual = calendar.get( Calendar.YEAR );
        int mesActual = calendar.get( Calendar.MONTH );
        int diaActual = calendar.get( Calendar.DAY_OF_MONTH );

        calendar.set( anioActual - 50, mesActual, diaActual );
        Date fechaNacimiento = calendar.getTime( );
        calendar.set( anioActual, 2, 1 );
        Date fechaExpedicion = calendar.getTime( );
        Ciudadano c1 = new Ciudadano( "123", "apellidos1", "nombre1", fechaNacimiento, "nacimiento1", Ciudadano.MASCULINO, fechaExpedicion, "expedicion1" );

        calendar.set( anioActual - 30, mesActual, diaActual );
        fechaNacimiento = calendar.getTime( );
        Ciudadano c2 = new Ciudadano( "456", "apellidos2", "nombre2", fechaNacimiento, "nacimiento2", Ciudadano.FEMENINO, fechaExpedicion, "expedicion2" );

        calendar.set( anioActual - 20, mesActual, diaActual );
        fechaNacimiento = calendar.getTime( );
        Ciudadano c3 = new Ciudadano( "789", "apellidos3", "nombre3", fechaNacimiento, "nacimiento3", Ciudadano.MASCULINO, fechaExpedicion, "expedicion3" );

        puestoVotacion.inscribirCiudadano( c1 );
        puestoVotacion.inscribirCiudadano( c2 );
        puestoVotacion.inscribirCiudadano( c3 );

    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darNombre<br>
     * darDireccion<br>
     * darInscritos<br>
     * darNumInscritos<br>
     * PuestoVotacion<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el puesto de votación, cada uno de los valores corresponde al esperado.<br>
     */
    public void testPuestoVotacion( )
    {
        setupEscenario1( );

        assertEquals( "El nombre del puesto de votación no es el esperado.", "puesto", puestoVotacion.darNombre( ) );
        assertEquals( "La dirección del puesto de votación es la esperada.", "dir", puestoVotacion.darDireccion( ) );
        assertNotNull( "La lista de ciudadanos inscritos no ha sido inicializada.", puestoVotacion.darInscritos( ) );
        assertEquals( "El número de ciudadanos inscritos no es el esperado.", 0, puestoVotacion.darNumInscritos( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método inscribirCiudadano de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * inscribirCiudadano<br>
     * darCedula<br>
     * darApellidos<br>
     * darNombres<br>
     * darInscritos<br>
     * darFechaNacimiento<br>
     * darLugarNacimiento<br>
     * darSexo<br>
     * darEdad<br>
     * darFechaExpedicion<br>
     * darLugarExpedicion<br>
     * darNumInscritos<br>
     * <b> Caso de prueba 1:</b><br>
     * No hay ciudadanos en el puesto de votación.<br>
     */
    public void testInscribirCiudadano( )
    {
        setupEscenario1( );

        Calendar calendar = Calendar.getInstance( );
        calendar.set( 1900, 1, 1 );
        Date fechaNacimiento = calendar.getTime( );

        calendar.set( 1918, 2, 1 );
        Date fechaExpedicion = calendar.getTime( );

        Ciudadano c1 = new Ciudadano( "123", "apellidos1", "nombre1", fechaNacimiento, "nacimiento1", Ciudadano.MASCULINO, fechaExpedicion, "expedicion1" );
        puestoVotacion.inscribirCiudadano( c1 );

        assertFalse( "La lista de inscritos no debería estar vacía.", puestoVotacion.darInscritos( ).isEmpty( ) );
        assertEquals( "El número de ciudadanos inscritos no es el esperado.", 1, puestoVotacion.darNumInscritos( ) );

        Ciudadano c = ( Ciudadano )puestoVotacion.darInscritos( ).get( 0 );
        assertNotNull( "El ciudadano no fue agregado a la lista de inscritos.", c );
        assertTrue( "El ciudadano no fue agregado correctamente a la lista de inscritos.", c.darCedula( ).equals( c1.darCedula( ) ) );
    }

    /**
     * Prueba 3: Se encarga de verificar el método existeCiudadano de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * existeCiudadano<br>
     * darCedula<br>
     * <b> Casos de prueba:</b><br>
     * 1. El puesto de votación no está vacío y tiene ciudadanos.<br>
     */
    public void testExisteCiudadanoOK( )
    {
        setupEscenario2( );

        Calendar calendar = Calendar.getInstance( );
        calendar.set( 1900, 1, 1 );
        Date fechaNacimiento = calendar.getTime( );

        calendar.set( 1918, 2, 1 );
        Date fechaExpedicion = calendar.getTime( );

        Ciudadano c1 = new Ciudadano( "123", "apellidos1", "nombre1", fechaNacimiento, "nacimiento1", Ciudadano.MASCULINO, fechaExpedicion, "expedicion1" );

        boolean existe = puestoVotacion.existeCiudadano( c1.darCedula( ) );
        assertTrue( "Se debería encontrar al ciudadano.", existe );
    }

    /**
     * Prueba 4: Se encarga de verificar el método existeCiudadano de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * existeCiudadano<br>
     * darCedula<br>
     * <b> Casos de prueba:</b><br>
     * 1. El puesto de votación está vacío por ende, no tiene ciudadanos.<br>
     */
    public void testExisteCiudadanoError1( )
    {
        setupEscenario1( );

        Calendar calendar = Calendar.getInstance( );
        calendar.set( 1900, 1, 1 );
        Date fechaNacimiento = calendar.getTime( );

        calendar.set( 1918, 2, 1 );
        Date fechaExpedicion = calendar.getTime( );

        Ciudadano c1 = new Ciudadano( "123", "apellidos1", "nombre1", fechaNacimiento, "nacimiento1", Ciudadano.MASCULINO, fechaExpedicion, "expedicion1" );

        boolean existe = puestoVotacion.existeCiudadano( c1.darCedula( ) );
        assertFalse( "No se debería encontrar al ciudadano.", existe );
    }

    /**
     * Prueba 5: Se encarga de verificar el método existeCiudadano de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * existeCiudadano<br>
     * darCedula<br>
     * <b> Casos de prueba:</b><br>
     * 1. El puesto de votación no está vacío y no tiene ciudadanos.<br>
     */
    public void testExisteCiudadanoError2( )
    {
        setupEscenario2( );

        Calendar calendar = Calendar.getInstance( );
        calendar.set( 1900, 1, 1 );
        Date fechaNacimiento = calendar.getTime( );

        calendar.set( 1918, 2, 1 );
        Date fechaExpedicion = calendar.getTime( );

        Ciudadano c1 = new Ciudadano( "234", "apellidos1", "nombre1", fechaNacimiento, "nacimiento1", Ciudadano.MASCULINO, fechaExpedicion, "expedicion1" );

        boolean existe = puestoVotacion.existeCiudadano( c1.darCedula( ) );
        assertFalse( "No se debería encontrar al ciudadano.", existe );
    }

    /**
     * Prueba 6: Se encarga de verificar el método calcularNumeroHombresInscritos de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularNumeroHombresInscritos<br>
     * <b> Casos de prueba:</b><br>
     * 1. El puesto de votación tiene ciudadanos hombres inscritos.<br>
     */
    public void testCalcularNumeroHombresInscritos( )
    {
        setupEscenario2( );

        int hombres = puestoVotacion.calcularNumeroHombresInscritos( );
        assertEquals( "El número de hombres no es el esperado.", 2, hombres );
    }

    /**
     * Prueba 7: Se encarga de verificar el método calcularNumeroMujeresInscritas de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularNumeroMujeresInscritas<br>
     * <b> Casos de prueba:</b><br>
     * 1. El puesto de votación tiene ciudadanos mujeres inscritas.<br>
     */
    public void testCalcularNumeroMujeresInscritas( )
    {
        setupEscenario2( );

        int mujeres = puestoVotacion.calcularNumeroMujeresInscritas( );
        assertEquals( "El número de mujeres no es el esperado.", 1, mujeres );
    }

    /**
     * Prueba 8: Se encarga de verificar el método toString de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * toString<br>
     * <b> Casos de prueba:</b><br>
     * 1. El formato de texto es el correcto.<br>
     */
    public void testToString( )
    {
        setupEscenario1( );
        assertEquals( "El formato del toString no es el esperado.", puestoVotacion.darNombre( ), puestoVotacion.toString( ) );
    }
}
