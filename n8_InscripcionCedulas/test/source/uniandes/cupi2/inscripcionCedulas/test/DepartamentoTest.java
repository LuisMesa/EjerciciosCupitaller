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
import uniandes.cupi2.inscripcionCedulas.mundo.Departamento;
import uniandes.cupi2.inscripcionCedulas.mundo.Municipio;
import uniandes.cupi2.inscripcionCedulas.mundo.PuestoVotacion;

/**
 * Clase que verifica la correcta implementación de la clase Departamento.
 */
public class DepartamentoTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Departamento departamento;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo departamento vacío.
     */
    private void setupEscenario1( )
    {
        departamento = new Departamento( "departamento" );
    }

    /**
     * Escenario 2: Construye un nuevo departamento con municipios, puestos de votación y ciudadanos inscritos.
     */
    private void setupEscenario2( )
    {
        departamento = new Departamento( "departamento" );

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

        departamento.agregarMunicipio( "municipio1" );
        departamento.agregarMunicipio( "municipio2" );
        departamento.agregarMunicipio( "municipio3" );

        Municipio m1 = departamento.buscarMunicipio( "municipio1" );
        Municipio m2 = departamento.buscarMunicipio( "municipio2" );
        Municipio m3 = departamento.buscarMunicipio( "municipio3" );

        m1.agregarPuestoVotacion( "puesto1", "dir1" );
        m2.agregarPuestoVotacion( "puesto2", "dir2" );
        m3.agregarPuestoVotacion( "puesto3", "dir3" );

        m1.buscarPuestoVotacion( "puesto1" ).inscribirCiudadano( c1 );
        m2.buscarPuestoVotacion( "puesto2" ).inscribirCiudadano( c2 );
        m3.buscarPuestoVotacion( "puesto3" ).inscribirCiudadano( c3 );

    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * darMunicipios<br>
     * darNombre<br>
     * darNumInscritos<br>
     * Departamento<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el departamento, cada uno de los valores corresponde al esperado.<br>
     */
    public void testDepartamento( )
    {
        setupEscenario1( );

        assertNotNull( "La lista de municipios no ha sido inicializada.", departamento.darMunicipios( ) );
        assertEquals( "El nombre del departamento no es el esperado.", "departamento", departamento.darNombre( ) );
        assertEquals( "El número de ciudadanos inscritos no es el esperado.", 0, departamento.darNumInscritos( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método agregarMunicipio de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarMunicipio<br>
     * darMunicipios<br>
     * <b> Caso de prueba 1:</b><br>
     * No hay municipios en el departamento.<br>
     */
    public void testAgregarMunicipio( )
    {
        setupEscenario1( );

        Municipio m1 = new Municipio( "municipio1" );
        departamento.agregarMunicipio( m1.darNombre( ) );

        assertFalse( "No se ha agregado el municipio al departamento.", departamento.darMunicipios( ).isEmpty( ) );
        Municipio m = ( Municipio )departamento.darMunicipios( ).get( 0 );
        assertNotNull( "El municipio no fue agregado al departamento.", m );
    }

    /**
     * Prueba 3: Se encarga de verificar el método buscarMunicipio de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarMunicipio<br>
     * <b> Casos de prueba:</b><br>
     * 1. El departamento no está vacío y tiene municipios.<br>
     * 2. El departamento está vacío y no posee municipios.<br>
     */
    public void testBuscarMunicipioOK( )
    {
        setupEscenario2( );

        // 1
        Municipio municipio = departamento.buscarMunicipio( "municipio2" );
        assertNotNull( "Se debería encontrar el municipio.", municipio );

        // 2
        Municipio municipio2 = departamento.buscarMunicipio( "municipio" );
        assertNull( "No se debería encontrar el municipio.", municipio2 );

    }

    /**
     * Prueba 4: Se encarga de verificar el método inscribirCiudadano de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * inscribirCiudadano<br>
     * agregarMunicipio<br>
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
     * No hay municipios ni ciudadanos en el departamento.<br>
     */
    public void testInscribirCiudadano( )
    {
        setupEscenario1( );

        //TODO Parte4 PuntoD Complete el método según la documentación dada.
    }

    /**
     * Prueba 5: Se encarga de verificar el método existeCiudadano de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * existeCiudadano<br>
     * darCedula<br>
     * <b> Casos de prueba:</b><br>
     * 1. El departamento está vacío por ende, no tiene ciudadanos.<br>
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

        boolean existe = departamento.existeCiudadano( c1.darCedula( ) );
        assertFalse( "No se debería encontrar al ciudadano.", existe );
    }

    /**
     * Prueba 6: Se encarga de verificar el método existeCiudadano de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * existeCiudadano<br>
     * darCedula<br>
     * <b> Casos de prueba:</b><br>
     * 1. El departamento no está vacío y no tiene ciudadanos.<br>
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

        boolean existe = departamento.existeCiudadano( c1.darCedula( ) );
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

        boolean existe = departamento.existeCiudadano( "123" );
        assertTrue( "Se debería encontrar al ciudadano.", existe );
    }

    /**
     * Prueba 8: Se encarga de verificar el método calcularNumeroHombresInscritos de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularNumeroHombresInscritos<br>
     * <b> Casos de prueba:</b><br>
     * 1. El departamento tiene ciudadanos hombres inscritos.<br>
     */
    public void testCalcularNumeroHombresInscritos( )
    {
        setupEscenario2( );

        int hombres = departamento.calcularNumeroHombresInscritos( );
        assertEquals( "El número de hombres no es el esperado.", 2, hombres );
    }

    /**
     * Prueba 9: Se encarga de verificar el método calcularNumeroMujeresInscritas de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * calcularNumeroMujeresInscritas<br>
     * <b> Casos de prueba:</b><br>
     * 1. El departamento tiene ciudadanos mujeres inscritas.<br>
     */
    public void testCalcularNumeroMujeresInscritas( )
    {
        setupEscenario2( );

        int mujeres = departamento.calcularNumeroMujeresInscritas( );
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
        assertEquals( "El formato del toString no es el esperado.", departamento.darNombre( ), departamento.toString( ) );
    }
}