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
package uniandes.cupi2.cupiPortafolio.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Clase que representa el portafolio estudiantil.
 */
public class PortafolioEstudiantil
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Posici�n del estudiante actual en la lista.
     */
    private int posicionEstudianteActual;

    /**
     * Lista de los estudiantes.
     */
    private ArrayList estudiantes;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Construye un nuevo portafolio estudiantil inicializando la lista de estudiantes.<br>
     * Debe cargar toda la informaci�n del portafolio desde el archivo de propiedades.<br>
     * <b>post: </b> La posici�n del estudiante actual debe ser 0.<br>
     * @throws Exception Si se presentan problemas en la lectura del archivo que contiene la informaci�n de los estudiantes.
     */
    public PortafolioEstudiantil( ) throws Exception
    {
        posicionEstudianteActual = 0;
        estudiantes = new ArrayList( );
        File archivo = new File( "./data/cupiPortafolio.properties" );
        Properties datos = new Properties( );
        FileInputStream in = new FileInputStream( archivo );

        try
        {
            datos.load( in );
            in.close( );
        }
        catch( Exception e )
        {
            throw new Exception( "Formato inv�lido." );
        }

        int numeroEstudiante = Integer.parseInt( datos.getProperty( "cupiPortafolio.numeroEstudiantes" ) );

        for( int i = 1; i <= numeroEstudiante; i++ )
        {
            String nombreEstudiante = datos.getProperty( "cupiPortafolio.estudiante" + i + ".nombre" );
            int codigoEstudiante = Integer.parseInt( datos.getProperty( "cupiPortafolio.estudiante" + i + ".codigo" ) );
            int semestreEstudiante = Integer.parseInt( datos.getProperty( "cupiPortafolio.estudiante" + i + ".semestre" ) );
            double promedioEstudiante = Double.parseDouble( datos.getProperty( "cupiPortafolio.estudiante" + i + ".promedio" ) );
            double creditosVistosEstudiante = Double.parseDouble( datos.getProperty( "cupiPortafolio.estudiante" + i + ".creditosVistos" ) );
            boolean estadoEstudiante = Boolean.parseBoolean( datos.getProperty( "cupiPortafolio.estudiante" + i + ".estado" ) );
            String rutaImagenEstudiante = datos.getProperty( "cupiPortafolio.estudiante" + i + ".rutaImagen" );

            Estudiante nueva = buscarEstudiante( codigoEstudiante );
            if( nueva != null )
            {
                throw new Exception( "El estudiante con el c�digo " + codigoEstudiante + " ya existe." );
            }
            Estudiante nuevoEstudiante = new Estudiante( nombreEstudiante, codigoEstudiante, semestreEstudiante, promedioEstudiante, creditosVistosEstudiante, estadoEstudiante, rutaImagenEstudiante );
            estudiantes.add( nuevoEstudiante );

        }
        posicionEstudianteActual = 0;
    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna el estudiante actual.
     * @return Estudiante actual.
     */
    public Estudiante darEstudianteActual( )
    {
        Estudiante actual = ( Estudiante )estudiantes.get( posicionEstudianteActual );
        return actual;
    }

    /**
     * Retorna el primer estudiante.<br>
     * <b>pre: </b> La lista de estudiantes est� inicializada.<br>
     * <b>post: </b> Retrocede hasta el primer estudiante. La posici�n del estudiante actual corresponde al primer estudiante.
     * @return Primer estudiante.
     * @throws Exception Si el estudiante actual es el primero.
     */
    public Estudiante darPrimerEstudiante( ) throws Exception
    {
        if( posicionEstudianteActual == 0 )
        {
            throw new Exception( "Se encuentra en el primer estudiante." );

        }
        posicionEstudianteActual = 0;
        Estudiante estudiantePrimera = ( Estudiante )estudiantes.get( posicionEstudianteActual );
        return estudiantePrimera;
    }

    /**
     * Retorna el estudiante anterior.<br>
     * <b>pre: </b> La lista de estudiantes est� inicializada<br>
     * <b>post: </b> Retrocede una posici�n en la lista de estudiantes. La posici�n del estudiante actual corresponde al estudiante anterior.
     * @return Estudiante anterior.
     * @throws Exception Si el estudiante actual es el primero.
     */
    public Estudiante darEstudianteAnterior( ) throws Exception
    {

        if( posicionEstudianteActual == 0 )
        {
            throw new Exception( "Se encuentra en el primer estudiante." );

        }
        posicionEstudianteActual--;
        Estudiante estudianteAnterior = ( Estudiante )estudiantes.get( posicionEstudianteActual );
        return estudianteAnterior;
    }

    /**
     * Retorna el estudiante siguiente.<br>
     * <b>pre: </b> La lista de estudiantes est� inicializada.<br>
     * <b>post: </b> Avanza una posici�n en la lista de estudiantes. La posici�n del estudiante actual corresponde a la del estudiante siguiente.
     * @return Estudiante siguiente.
     * @throws Exception Si el estudiante actual es el �ltimo.
     */
    public Estudiante darEstudianteSiguiente( ) throws Exception
    {
        if( posicionEstudianteActual == estudiantes.size( ) - 1 )
        {
            throw new Exception( "Se encuentra en el �ltimo estudiante." );

        }
        posicionEstudianteActual++;
        Estudiante estudianteSiguiente = ( Estudiante )estudiantes.get( posicionEstudianteActual );
        return estudianteSiguiente;
    }

    /**
     * Retorna el �ltimo estudiante.<br>
     * <b>pre: </b> La lista de estudiantes est� inicializada.<br>
     * <b>post: </b> Avanza hasta la �ltima posici�n en la lista de estudiantes. La posici�n del estudiante actual corresponde a la del �ltimo estudiante.
     * @return �ltimo estudiante.
     * @throws Exception Si el estudiante actual es el �ltimo.
     */
    public Estudiante darUltimoEstudiante( ) throws Exception
    {
        if( posicionEstudianteActual == estudiantes.size( ) - 1 )
        {
            throw new Exception( "Se encuentra en el �ltimo estudiante." );

        }
        posicionEstudianteActual = estudiantes.size( ) - 1;
        Estudiante estudianteUltima = ( Estudiante )estudiantes.get( posicionEstudianteActual );
        return estudianteUltima;
    }

    /**
     * Busca un estudiante dado su c�digo por par�metro.<br>
     * <b>pre: </b> La lista de estudiantes est� inicializada.<br>
     * <b>post: </b> Se actualiza la posici�n del estudiante actual con la encontrada.
     * @param pCodigoEstudiante C�digo del estudiante. pCodigoEstudiante >= 0.
     * @return Estudiante con el c�digo dado por par�metro, null en caso de no encontrarla.
     */
    public Estudiante buscarEstudiante( int pCodigoEstudiante )
    {
        Estudiante buscado = null;
        boolean encontro = false;

        for( int i = 0; i < estudiantes.size( ) && !encontro; i++ )
        {
            Estudiante actual = ( Estudiante )estudiantes.get( i );

            if( actual.darCodigo( ) ==  pCodigoEstudiante  )
            {
                posicionEstudianteActual = i;
                encontro = true;
                buscado = actual;
            }
        }

        return buscado;
    }

    // -------------------------------------------------------------
    // Puntos de extensi�n
    // -------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n 2.
     * @return respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}