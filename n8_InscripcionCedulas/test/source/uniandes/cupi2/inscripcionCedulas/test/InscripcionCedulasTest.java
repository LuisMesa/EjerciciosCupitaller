/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_inscripcionCedulas
 * Autor: Equipo Cupi2 - 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.inscripcionCedulas.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import uniandes.cupi2.inscripcionCedulas.mundo.Ciudadano;
import uniandes.cupi2.inscripcionCedulas.mundo.CiudadanoRegistradoException;
import uniandes.cupi2.inscripcionCedulas.mundo.Departamento;
import uniandes.cupi2.inscripcionCedulas.mundo.FormatoArchivoException;
import uniandes.cupi2.inscripcionCedulas.mundo.InscripcionCedulas;
import uniandes.cupi2.inscripcionCedulas.mundo.Municipio;
import uniandes.cupi2.inscripcionCedulas.mundo.PersistenciaException;
import uniandes.cupi2.inscripcionCedulas.mundo.PuestoVotacion;

/**
 * Clase usada para verificar que los m�todos de la clase InscripcionCedulas est�n correctamente implementados.
 */
public class InscripcionCedulasTest extends TestCase
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa la ruta al archivo donde se guarda y se carga la informaci�n del sistema.
     */
    private final static String DATA = "./test/data/inscripcionCedulas.data";

    /**
     * Constante que representa la ruta del archivo .csv del que se importan los datos de departamentos, municipios y puesto de votaci�n.
     */
    private final static String DATA_I = "./test/data/inscripcionCedulas.csv";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private InscripcionCedulas inscripcionCedulas;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo sistema InscripcionCedulas vac�o.
     */
    private void setupEscenario1( )
    {
        try
        {
            inscripcionCedulas = new InscripcionCedulas( "" );
        }
        catch( PersistenciaException e )
        {
            fail( "No se deber�a presentar el error: " + e.getMessage( ) );
        }
    }

    /**
     * Escenario 2: Construye un nuevo sistema InscripcionCedulas con departamentos, municipios, puesto de votaci�n y ciudadanos.
     */
    private void setupEscenario2( )
    {
        try
        {
            inscripcionCedulas = new InscripcionCedulas( "" );
            inscripcionCedulas.importarDatos( DATA_I );

            Calendar calendar = Calendar.getInstance( );
            int anioActual = calendar.get( Calendar.YEAR );
            int mesActual = calendar.get( Calendar.MONTH );
            int diaActual = calendar.get( Calendar.DAY_OF_MONTH );

            calendar.set( anioActual - 50, mesActual, diaActual );
            Date fechaNacimiento = calendar.getTime( );
            calendar.set( anioActual, 2, 1 );
            Date fechaExpedicion = calendar.getTime( );
            Ciudadano c1 = new Ciudadano( "123", "apellidos1", "nombre1", fechaNacimiento, "nacimiento1", Ciudadano.MASCULINO, fechaExpedicion, "expedicion1" );
            calendar.set( anioActual - 20, mesActual, diaActual );
            fechaNacimiento = calendar.getTime( );
            Ciudadano c2 = new Ciudadano( "234", "apellidos2", "nombre2", fechaNacimiento, "nacimiento2", Ciudadano.MASCULINO, fechaExpedicion, "expedicion2" );
            calendar.set( anioActual - 35, mesActual, diaActual );
            fechaNacimiento = calendar.getTime( );
            Ciudadano c3 = new Ciudadano( "345", "apellidos3", "nombre3", fechaNacimiento, "nacimiento3", Ciudadano.FEMENINO, fechaExpedicion, "expedicion3" );

            inscripcionCedulas.inscribirCiudadano( "ANTIOQUIA", "MEDELLIN", "LA ESPERAZA", c1.darCedula( ), c1.darApellidos( ), c1.darNombres( ), c1.darFechaNacimiento( ), c1.darLugarNacimiento( ), c1.darSexo( ), c1.darFechaExpedicion( ),
                    c1.darLugarExpedicion( ) );
            inscripcionCedulas.inscribirCiudadano( "ANTIOQUIA", "MEDELLIN", "LA ESPERAZA", c2.darCedula( ), c2.darApellidos( ), c2.darNombres( ), c2.darFechaNacimiento( ), c2.darLugarNacimiento( ), c2.darSexo( ), c2.darFechaExpedicion( ),
                    c2.darLugarExpedicion( ) );
            inscripcionCedulas.inscribirCiudadano( "BOGOTA D.C.", "BOGOTA, D.C.", "KENNEDY", c3.darCedula( ), c3.darApellidos( ), c3.darNombres( ), c3.darFechaNacimiento( ), c3.darLugarNacimiento( ), c3.darSexo( ), c3.darFechaExpedicion( ),
                    c3.darLugarExpedicion( ) );
        }
        catch( PersistenciaException e )
        {
            fail( "No se deber�a presentar el error: " + e.getMessage( ) + "." );
        }
        catch( FormatoArchivoException e )
        {
            fail( "No se deber�a presentar el error: " + e.getMessage( ) + "." );
        }
        catch( CiudadanoRegistradoException e )
        {
            fail( "No se deber�a presentar el error: " + e.getMessage( ) + "." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * darDepartamentos<br>
     * darNumInscritos<br>
     * PuestoVotacion<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el sistema de inscripci�n de c�dulas, cada uno de los valores corresponde al esperado.<br>
     */
    public void testInscripcionCedulas( )
    {
        setupEscenario1( );

        assertNotNull( "La lista de departamento no ha sido inicializada.", inscripcionCedulas.darDepartamentos( ) );
        assertEquals( "El n�mero de ciudadanos inscritos no es el esperado.", 0, inscripcionCedulas.darNumInscritos( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo buscarDepartamento de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarDepartamento<br>
     * <b> Casos de prueba:</b><br>
     * 1. El sistema no est� vac�o y tiene departamentos.<br>
     */
    public void testBuscarDepartamentoOK( )
    {
        setupEscenario2( );

        Departamento departamento = inscripcionCedulas.buscarDepartamento( "BOYACA" );
        assertNotNull( "Se deber�a encontrar el departamento.", departamento );
    }

    /**
     * Prueba 3: Se encarga de verificar el m�todo buscarDepartamento de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarDepartamento<br>
     * <b> Casos de prueba:</b><br>
     * 1. El sistema est� vac�a por ende, no tiene departamentos.<br>
     */
    public void testBuscarDepartamentoError1( )
    {
        setupEscenario1( );
        Departamento departamento = inscripcionCedulas.buscarDepartamento( "departamento1" );
        assertNull( "No se deber�a encontrar el departamento.", departamento );
    }

    /**
     * Prueba 4: Se encarga de verificar el m�todo buscarDepartamento de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarDepartamento<br>
     * <b> Casos de prueba:</b><br>
     * 1. El sistema no est� vac�a y no tiene departamentos.<br>
     */
    public void testBuscarDepartamentoError2( )
    {
        setupEscenario2( );

        Departamento departamento = inscripcionCedulas.buscarDepartamento( "departamento" );
        assertNull( "No se deber�a encontrar el departamento.", departamento );
    }

    /**
     * Prueba 5: Se encarga de verificar el m�todo existeCiudadano de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * existeCiudadano<br>
     * darCedula<br>
     * <b> Casos de prueba:</b><br>
     * 1. El sistema no est� vac�a y el ciudadano se encuentra inscrito.<br>
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

        boolean existe = inscripcionCedulas.existeCiudadano( c1.darCedula( ) );
        assertTrue( "Se deber�a encontrar al ciudadano.", existe );
    }

    /**
     * Prueba 6: Se encarga de verificar el m�todo existeCiudadano de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * existeCiudadano<br>
     * darCedula<br>
     * <b> Casos de prueba:</b><br>
     * 1. El sistema est� vac�a por ende, no tiene ciudadanos.<br>
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

        boolean existe = inscripcionCedulas.existeCiudadano( c1.darCedula( ) );
        assertFalse( "No se deber�a encontrar al ciudadano.", existe );
    }

    /**
     * Prueba 7: Se encarga de verificar el m�todo existeCiudadano de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * existeCiudadano<br>
     * darCedula<br>
     * <b> Casos de prueba:</b><br>
     * 1. El sistema no est� vac�a y el ciudadano no se encuentra inscrito.<br>
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
        Ciudadano c1 = new Ciudadano( "987", "apellidos", "nombre", fechaNacimiento, "nacimiento", Ciudadano.MASCULINO, fechaExpedicion, "expedicion" );

        boolean existe = inscripcionCedulas.existeCiudadano( c1.darCedula( ) );
        assertFalse( "No se deber�a encontrar al ciudadano.", existe );
    }

    /**
     * Prueba 8: Se encarga de verificar el m�todo inscribirCiudadano de la clase.<br>
     * <b> M�todos a probar: </b> <br>
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
     * existeCiudadano<br>
     * darNumInscritos<br>
     * buscarDepartamento<br>
     * <b> Caso de prueba 1:</b><br>
     * No hay ciudadanos en el sistema.<br>
     */
    public void testInscribirCiudadanoOK( )
    {
        //TODO Parte4 PuntoB Complete el m�todo seg�n la documentaci�n dada. Verifica el ciudadano  haya sido inscrito correctamente.
        
    }

    /**
     * Prueba 9: Se encarga de verificar el m�todo inscribirCiudadano de la clase.<br>
     * <b> M�todos a probar: </b> <br>
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
     * <b> Caso de prueba 1:</b><br>
     * Ya existe el ciudadano en el sistema.<br>
     */
    public void testInscribirCiudadanoError( )
    {
        //TODO Parte4 PuntoC Complete el m�todo seg�n la documentaci�n dada. Verifica que el ciudadano no sea repetido.
    }

    /**
     * Prueba 10: Se encarga de verificar el m�todo calcularNumeroHombresInscritos de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * calcularNumeroHombresInscritos<br>
     * <b> Casos de prueba:</b><br>
     * 1. El sistema tiene ciudadanos hombres inscritos.<br>
     */
    public void testCalcularNumeroHombresInscritos( )
    {
        setupEscenario2( );

        int hombres = inscripcionCedulas.calcularNumeroHombresInscritos( );
        assertEquals( "El n�mero de hombres no es el esperado.", 2, hombres );
    }

    /**
     * Prueba 11: Se encarga de verificar el m�todo calcularNumeroMujeresInscritas de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * calcularNumeroMujeresInscritas<br>
     * <b> Casos de prueba:</b><br>
     * 1. El sistema tiene ciudadanos mujeres inscritas.<br>
     */
    public void testCalcularNumeroMujeresInscritas( )
    {
        setupEscenario2( );

        int mujeres = inscripcionCedulas.calcularNumeroMujeresInscritas( );
        assertEquals( "El n�mero de mujeres no es el esperado.", 1, mujeres );
    }

    /**
     * Prueba 12: Se encarga de verificar el m�todo calcularPorcentajeHombresInscritos de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * calcularPorcentajeHombresInscritos<br>
     * <b> Casos de prueba:</b><br>
     * 1. El sistema tiene ciudadanos hombres inscritos.<br>
     */
    public void testCalcularPorcentajeHombresInscritos( )
    {
        setupEscenario2( );

        double hombres = inscripcionCedulas.calcularPorcentajeHombresInscritos( );
        assertEquals( "El porcentaje de hombres no es el esperado.", ( double )2 / 3, hombres, 0.0 );
    }

    /**
     * Prueba 13: Se encarga de verificar el m�todo calcularPorcentajeMujeresInscritas de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * calcularPorcentajeMujeresInscritas<br>
     * <b> Casos de prueba:</b><br>
     * 1. El sistema tiene ciudadanos mujeres inscritas.<br>
     */
    public void testCalcularPorcentajeMujeresInscritas( )
    {
        setupEscenario2( );

        double mujeres = inscripcionCedulas.calcularPorcentajeMujeresInscritas( );
        assertEquals( "El n�mero de mujeres no es el esperado.", ( double )1 / 3, mujeres, 0.0 );
    }

    /**
     * Prueba 14: Se encarga de verificar el m�todo calcularInscritosRangoEdad de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * calcularInscritosRangoEdad<br>
     * <b> Casos de prueba:</b><br>
     * 1. El sistema tiene ciudadanos de diferentes edades.<br>
     */
    public void testCalcularInscritosRangoEdad( )
    {
        setupEscenario2( );

        assertEquals( "El n�mero de inscritos en el rango 1 (18 - 25 a�os) no es el esperado.", 1, inscripcionCedulas.calcularInscritosRangoEdad( inscripcionCedulas.RANGO_1 ) );
        assertEquals( "El n�mero de inscritos en el rango 2 (26 - 29 a�os) no es el esperado.", 0, inscripcionCedulas.calcularInscritosRangoEdad( inscripcionCedulas.RANGO_2 ) );
        assertEquals( "El n�mero de inscritos en el rango 3 (30 - 37 a�os) no es el esperado.", 1, inscripcionCedulas.calcularInscritosRangoEdad( inscripcionCedulas.RANGO_3 ) );
        assertEquals( "El n�mero de inscritos en el rango 4 (38 - 49 a�os) no es el esperado.", 0, inscripcionCedulas.calcularInscritosRangoEdad( inscripcionCedulas.RANGO_4 ) );
        assertEquals( "El n�mero de inscritos en el rango 5 (50 - 66 a�os) no es el esperado.", 1, inscripcionCedulas.calcularInscritosRangoEdad( inscripcionCedulas.RANGO_5 ) );
        assertEquals( "El n�mero de inscritos en el rango 6 (67 a�os en adelante) no es el esperado.", 0, inscripcionCedulas.calcularInscritosRangoEdad( inscripcionCedulas.RANGO_6 ) );
    }

    /**
     * Prueba 15: Se encarga de verificar el m�todo importarDatos de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * importarDatos<br>
     * darDepartamentos<br>
     * darMunicipios<br>
     * darPuestosVotacion<br>
     * darNumInscritos<br>
     */
    public void testImportarDatos( )
    {
        setupEscenario1( );

        try
        {
            inscripcionCedulas.importarDatos( DATA_I );

            ArrayList departamentos = inscripcionCedulas.darDepartamentos( );
            assertEquals( "Los departamentos no son cargados correctamente", 4, departamentos.size( ) );
            for( int j = 0; j < departamentos.size( ); j++ )
            {
                Departamento d = ( Departamento )departamentos.get( j );
                assertNotNull( "El departamento no deber�a ser nulo", d );
                assertEquals( "El departamento deber�a tener un municipio", 1, d.darMunicipios( ).size( ) );

                Municipio m = ( Municipio )d.darMunicipios( ).get( 0 );
                assertNotNull( "El municipio no deber�a ser nulo", m );
                assertEquals( "El municipio deber�a tener un puesto de votaci�n", 1, m.darPuestosVotacion( ).size( ) );

                PuestoVotacion p = ( PuestoVotacion )m.darPuestosVotacion( ).get( 0 );
                assertNotNull( "El puesto de votaci�n no deber�a ser nulo", m );
                assertEquals( "El puesto de votaci�n no deber�a tener ciudadanos inscritos", 0, p.darNumInscritos( ) );
            }
        }
        catch( PersistenciaException e )
        {
            fail( "No se debe generar la excepci�n: " + e.getMessage( ) + "." );
        }
        catch( FormatoArchivoException e )
        {
            fail( "No se debe generar la excepci�n: " + e.getMessage( ) + "." );
        }
    }

    /**
     * Prueba 16: Se encarga de verificar el m�todo importarDatos de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * guardar<br>
     * darDepartamentos<br>
     * darMunicipios<br>
     * darPuestosVotacion<br>
     * darNumInscritos<br>
     * darNombre<br>
     */
    public void testGuardarCargar( )
    {
        setupEscenario2( );

        try
        {
            inscripcionCedulas.guardar( DATA );
            InscripcionCedulas temp = new InscripcionCedulas( DATA );

            ArrayList departamentos = temp.darDepartamentos( );
            assertEquals( "Los departamentos no son cargados correctamente.", 4, departamentos.size( ) );

            String[] deptos = { "ANTIOQUIA", "ATLANTICO", "BOYACA", "BOGOTA D.C." };
            String[] munic = { "MEDELLIN", "SOLEDAD", "CHIVATA", "BOGOTA, D.C." };
            String[] puestos = { "LA ESPERAZA", "DOLORES MARIA UCROS", "CABECERA MUNICIPAL", "KENNEDY" };

            for( int j = 0; j < departamentos.size( ); j++ )
            {
                Departamento d = ( Departamento )departamentos.get( j );
                assertNotNull( "El departamento no deber�a ser nulo.", d );
                assertEquals( "El nombre del departamento no es el esperado.", deptos[ j ], d.darNombre( ) );
                assertEquals( "El departamento deber�a tener un municipio.", 1, d.darMunicipios( ).size( ) );

                Municipio m = ( Municipio )d.darMunicipios( ).get( 0 );
                assertNotNull( "El municipio no deber�a ser nulo.", m );
                assertEquals( "El nombre del municipio no es el esperado.", munic[ j ], m.darNombre( ) );
                assertEquals( "El municipio deber�a tener un puesto de votaci�n.", 1, m.darPuestosVotacion( ).size( ) );

                PuestoVotacion p = ( PuestoVotacion )m.darPuestosVotacion( ).get( 0 );
                assertNotNull( "El puesto de votaci�n no deber�a ser nulo.", m );
                assertEquals( "El nombre del puesto de votaci�n no es el esperado.", puestos[ j ], p.darNombre( ) );
            }
            assertEquals( "El n�mero de ciudadanos inscritos no es el esperado.", 3, temp.darNumInscritos( ) );
        }
        catch( PersistenciaException e )
        {
            fail( "No se deber�a generar la excepci�n:" + e.getMessage( ) + "." );
        }
    }
}