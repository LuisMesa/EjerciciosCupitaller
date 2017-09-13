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
     * Posición del estudiante actual en la lista.
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
     * Debe cargar toda la información del portafolio desde el archivo de propiedades.<br>
     * <b>post: </b> La posición del estudiante actual debe ser 0.<br>
     * @throws Exception Si se presentan problemas en la lectura del archivo que contiene la información de los estudiantes.
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
            throw new Exception( "Formato inválido." );
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
                throw new Exception( "El estudiante con el código " + codigoEstudiante + " ya existe." );
            }
            Estudiante nuevoEstudiante = new Estudiante( nombreEstudiante, codigoEstudiante, semestreEstudiante, promedioEstudiante, creditosVistosEstudiante, estadoEstudiante, rutaImagenEstudiante );
            estudiantes.add( nuevoEstudiante );

        }
        posicionEstudianteActual = 0;
    }

    // -------------------------------------------------------------
    // Métodos
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
     * <b>pre: </b> La lista de estudiantes está inicializada.<br>
     * <b>post: </b> Retrocede hasta el primer estudiante. La posición del estudiante actual corresponde al primer estudiante.
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
     * <b>pre: </b> La lista de estudiantes está inicializada<br>
     * <b>post: </b> Retrocede una posición en la lista de estudiantes. La posición del estudiante actual corresponde al estudiante anterior.
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
     * <b>pre: </b> La lista de estudiantes está inicializada.<br>
     * <b>post: </b> Avanza una posición en la lista de estudiantes. La posición del estudiante actual corresponde a la del estudiante siguiente.
     * @return Estudiante siguiente.
     * @throws Exception Si el estudiante actual es el último.
     */
    public Estudiante darEstudianteSiguiente( ) throws Exception
    {
        if( posicionEstudianteActual == estudiantes.size( ) - 1 )
        {
            throw new Exception( "Se encuentra en el último estudiante." );

        }
        posicionEstudianteActual++;
        Estudiante estudianteSiguiente = ( Estudiante )estudiantes.get( posicionEstudianteActual );
        return estudianteSiguiente;
    }

    /**
     * Retorna el último estudiante.<br>
     * <b>pre: </b> La lista de estudiantes está inicializada.<br>
     * <b>post: </b> Avanza hasta la última posición en la lista de estudiantes. La posición del estudiante actual corresponde a la del último estudiante.
     * @return Último estudiante.
     * @throws Exception Si el estudiante actual es el último.
     */
    public Estudiante darUltimoEstudiante( ) throws Exception
    {
        if( posicionEstudianteActual == estudiantes.size( ) - 1 )
        {
            throw new Exception( "Se encuentra en el último estudiante." );

        }
        posicionEstudianteActual = estudiantes.size( ) - 1;
        Estudiante estudianteUltima = ( Estudiante )estudiantes.get( posicionEstudianteActual );
        return estudianteUltima;
    }

    /**
     * Busca un estudiante dado su código por parámetro.<br>
     * <b>pre: </b> La lista de estudiantes está inicializada.<br>
     * <b>post: </b> Se actualiza la posición del estudiante actual con la encontrada.
     * @param pCodigoEstudiante Código del estudiante. pCodigoEstudiante >= 0.
     * @return Estudiante con el código dado por parámetro, null en caso de no encontrarla.
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
    // Puntos de extensión
    // -------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}