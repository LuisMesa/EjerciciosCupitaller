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
import uniandes.cupi2.inscripcionCedulas.mundo.Municipio;
import uniandes.cupi2.inscripcionCedulas.mundo.PuestoVotacion;

/**
 * Clase que verifica correcta implementación de la clase Municipio.
 */
public class MunicipioTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Municipio municipio;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo municipio vacío.
     */
    private void setupEscenario1( )
    {
        municipio = new Municipio( "municipio" );
    }

    /**
     * Escenario 2: Construye un nuevo municipio con puestos de votación y ciudadanos inscritos.
     */
    private void setupEscenario2( )
    {
        municipio = new Municipio( "municipio" );

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

        municipio.agregarPuestoVotacion( "puesto1", "dir1" );
        municipio.agregarPuestoVotacion( "puesto2", "dir2" );
        municipio.agregarPuestoVotacion( "puesto3", "dir3" );

        PuestoVotacion p1 = municipio.buscarPuestoVotacion( "puesto1" );
        PuestoVotacion p2 = municipio.buscarPuestoVotacion( "puesto2" );
        PuestoVotacion p3 = municipio.buscarPuestoVotacion( "puesto3" );

        p1.inscribirCiudadano( c1 );
        p2.inscribirCiudadano( c2 );
        p3.inscribirCiudadano( c3 );

    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darNombre<br>
     * darNumInscritos<br>
     * darPuestosVotacion<br>
     * Municipio<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el municipio, cada uno de los valores corresponde al esperado.<br>
     */
    public void testMunicipio( )
    {
        setupEscenario1( );

        assertEquals( "El nombre del municipio no es el esperado.", "municipio", municipio.darNombre( ) );
        assertEquals( "El número de ciudadanos inscritos no es el esperado.", 0, municipio.darNumInscritos( ) );
        assertNotNull( "No se ha inicializado la lista de puesto de votación.", municipio.darPuestosVotacion( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método agregarPuestoVotacion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarPuestoVotacion<br>
     * darPuestosVotacion<br>
     * <b> Caso de prueba 1:</b><br>
     * No hay puestos de votación en el municipio.<br>
     */
    public void testAgregarPuestoVotacion( )
    {
        setupEscenario1( );

        PuestoVotacion p1 = new PuestoVotacion( "puesto1", "dir1" );
        municipio.agregarPuestoVotacion( p1.darNombre( ), p1.darDireccion( ) );

        assertFalse( "No se ha agregado el puesto de votación al municipio.", municipio.darPuestosVotacion( ).isEmpty( ) );
        PuestoVotacion p = ( PuestoVotacion )municipio.darPuestosVotacion( ).get( 0 );
        assertNotNull( "El puesto de votación no fue agregado al municipio.", p );
    }

    /**
     * Prueba 3: Se encarga de verificar el método buscarPuestoVotacion de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarPuestoVotacion<br>
     * <b> Casos de prueba:</b><br>
     * 1. El municipio no está vacío y tiene puestos de votación.<br>
     * 2. El municipio está vacío y no posee puestos de votación.<br>
     */
    public void testBuscarPuestoVotacion( )
    {

        setupEscenario2( );
        // 1
        PuestoVotacion puesto = municipio.buscarPuestoVotacion( "puesto1" );
        assertNotNull( "El puesto de votación debería ser encontrado.", puesto );

        // 2
        PuestoVotacion puesto2 = municipio.buscarPuestoVotacion( "puesto" );
        assertNull( "No se debería encontrar el puesto de votación.", puesto2 );

    }

    /**
     * Prueba 4: Se encarga de verificar el método inscribirCiudadano de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * inscribirCiudadano<br>
     * agregarPuestoVotacion<br>
     * existeCiudadano<br>
     * darCedula<br>
     * darApellidos<br>
     * darNombres<br>
     * darFechaNacimiento<br>
     * darLugarNacimiento<br>
     * darSexo<br>
     * darEdad<br>
     * darFechaExpedicion<br>
     * darLugarExpedicion<br>
     * darNumInscritos<br>
     * <b> Caso de prueba 1:</b><br>
     * No hay ciudadanos en el municipio.<br>
     */
    public void testInscribirCiudadano( )
    {
        setupEscenario1( );

        Calendar calendar = Calendar.getInstance( );
        int anioActual = calendar.get( Calendar.YEAR );
        int mesActual = calendar.get( Calendar.MONTH );
        int diaActual = calendar.get( Calendar.DAY_OF_MONTH );

        calendar.set( anioActual - 50, mesActual, diaActual );
        Date fechaNacimiento = calendar.getTime( );
        calendar.set( anioActual, 2, 1 );
        Date fechaExpedicion = calendar.getTime( );
        Ciudadano c1 = new Ciudadano( "123", "apellidos1", "nombre1", fechaNacimiento, "nacimiento1", Ciudadano.MASCULINO, fechaExpedicion, "expedicion1" );

        municipio.agregarPuestoVotacion( "puesto1", "dir1" );
        municipio.inscribirCiudadano( "puesto1", c1 );

        assertTrue( "El ciudadano no se encuentra registrado en el municipio.", municipio.existeCiudadano( c1.darCedula( ) ) );
        assertEquals( "El número de ciudadanos inscritos no es el esperado.", 1, municipio.darNumInscritos( ) );
        assertEquals( "El número de ciudadanos inscritos es el puesto puesto1 no es el esperado.", 1, municipio.buscarPuestoVotacion( "puesto1" ).darNumInscritos( ) );
    }

    /**
     * Prueba 5: Se encarga de verificar el método existeCiudadano de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * existeCiudadano<br>
     * darCedula<br>
     * <b> Casos de prueba:</b><br>
     * 1. El municipio está vacío por ende, no tiene ciudadanos.<br>
     */
    public void testExisteCiudadanoError1( )
    {
        setupEscenario1( );

        Calendar calendar = Calendar.getInstance( );
        int anioActual = calendar.get( Calendar.YEAR );
        int mesActual = calendar.get( Calendar.MONTH );
        int diaActual = calendar.get( Calendar.DAY_OF_MONTH );

        calendar.set( anioActual - 50, mesActual, diaActual );
        Date fechaNacimiento = calendar.getTime( );
        calendar.set( anioActual, 2, 1 );
        Date fechaExpedicion = calendar.getTime( );
        Ciudadano c1 = new Ciudadano( "123", "apellidos1", "nombre1", fechaNacimiento, "nacimiento1", Ciudadano.MASCULINO, fechaExpedicion, "expedicion1" );

        boolean existe = municipio.existeCiudadano( c1.darCedula( ) );
        assertFalse( "No se debería encontrar al ciudadano.", existe );
    }

    /**
     * Prueba 6: Se encarga de verificar el método existeCiudadano de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * existeCiudadano<br>
     * darCedula<br>
     * <b> Casos de prueba:</b><br>
     * 1. El municipio no está vacío y no tiene ciudadanos.<br>
     */
    public void testExisteCiudadanoError2( )
    {
        setupEscenario2( );

        Calendar calendar = Calendar.getInstance( );
        int anioActual = calendar.get( Calendar.YEAR );
        int mesActual = calendar.get( Calendar.MONTH );
        int diaActual = calendar.get( Calendar.DAY_OF_MONTH );

        calendar.set( anioActual - 50, mesActual, diaActual );
        Date fechaNacimiento = calendar.getTime( );
        calendar.set( anioActual, 2, 1 );
        Date fechaExpedicion = calendar.getTime( );
        Ciudadano c1 = new Ciudadano( "234", "apellidos1", "nombre1", fechaNacimiento, "nacimiento1", Ciudadano.MASCULINO, fechaExpedicion, "expedicion1" );

        boolean existe = municipio.existeCiudadano( c1.darCedula( ) );
        assertFalse( "No se debería encontrar al ciudadano.", existe );
    }

    /**
     * Prueba 7: Se encarga de verificar el método existeCiudadano de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * existeCiudadano<br>
     * darCedula<br>
     * <b> Casos de prueba:</b><br>
     * 1. El departamento no está vacío y tiene ciudadanos.<br>
     */
    public void testExisteCiudadanoOK( )
    {
        setupEscenario2( );

        Calendar calendar = Calendar.getInstance( );
        int anioActual = calendar.get( Calendar.YEAR );
        int mesActual = calendar.get( Calendar.MONTH );
        int diaActual = calendar.get( Calendar.DAY_OF_MONTH );

        calendar.set( anioActual - 50, mesActual, diaActual );
        Date fechaNacimiento = calendar.getTime( );
        calendar.set( anioActual, 2, 1 );
        Date fechaExpedicion = calendar.getTime( );
        Ciudadano c1 = new Ciudadano( "123", "apellidos1", "nombre1", fechaNacimiento, "nacimiento1", Ciudadano.MASCULINO, fechaExpedicion, "expedicion1" );

        boolean existe = municipio.existeCiudadano( c1.darCedula( ) );
        assertTrue( "Se debería encontrar al ciudadano.", existe );
    }

    /**
     * Prueba 8: Se encarga de verificar el método calcularNumeroHombresInscritos de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularNumeroHombresInscritos<br>
     * <b> Casos de prueba:</b><br>
     * 1. El municipio tiene ciudadanos hombres inscritos.<br>
     */
    public void testCalcularNumeroHombresInscritos( )
    {
        setupEscenario2( );

        int hombres = municipio.calcularNumeroHombresInscritos( );
        assertEquals( "El número de hombres no es el esperado.", 2, hombres );
    }

    /**
     * Prueba 9: Se encarga de verificar el método calcularNumeroMujeresInscritas de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularNumeroMujeresInscritas<br>
     * <b> Casos de prueba:</b><br>
     * 1. El municipio tiene ciudadanos mujeres inscritas.<br>
     */
    public void testCalcularNumeroMujeresInscritas( )
    {
        setupEscenario2( );

        int mujeres = municipio.calcularNumeroMujeresInscritas( );
        assertEquals( "El número de mujeres no es el esperado.", 1, mujeres );
    }

    /**
     * Prueba 10: Se encarga de verificar el método toString de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * toString<br>
     * <b> Casos de prueba:</b><br>
     * 1. El formato de texto es el correcto.<br>
     */
    public void testToString( )
    {
        setupEscenario1( );
        assertEquals( "El formato del toString no es el esperado.", municipio.darNombre( ), municipio.toString( ) );
    }
}