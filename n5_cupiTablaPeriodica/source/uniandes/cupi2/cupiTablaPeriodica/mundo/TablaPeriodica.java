/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_cupiTablaPeriodica
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupiTablaPeriodica.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Clase que representa la tabla peri�dica.
 */
public class TablaPeriodica
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * N�mero de grupos de la tabla peri�dica.
     */
    public static final int NUMERO_GRUPOS = 8;

    /**
     * N�mero de per�odos de la tabla peri�dica.
     */
    public static final int NUMERO_PERIODOS = 7;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Elementos de la tabla peri�dica.
     */
    private ArrayList elementos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la tabla peri�dica cargando la informaci�n de los elementos.<br>
     * <b> post: </b> Se inicializ� la lista de elementos.
     * @throws Exception Si ocurre un problema al leer el archivo.
     */
    public TablaPeriodica( ) throws Exception
    {
        elementos = new ArrayList( );

        Properties datosElementos = new Properties( );
        FileInputStream fin = new FileInputStream( new File( "data/elementos.properties" ) );
        datosElementos.load( fin );
        fin.close( );

        // Lee la informaci�n y crea los elementos
        int cantidadElementos = Integer.parseInt( datosElementos.getProperty( "total.elementos" ) );

        for( int i = 1; i <= cantidadElementos; i++ )
        {

            String nombre = datosElementos.getProperty( "elemento" + i + ".nombre" );
            String simbolo = datosElementos.getProperty( "elemento" + i + ".simbolo" );
            double masa = Double.parseDouble( datosElementos.getProperty( "elemento" + i + ".masa" ) );
            int numeroAtomico = Integer.parseInt( datosElementos.getProperty( "elemento" + i + ".numeroAtomico" ) );
            boolean esMetal = Boolean.parseBoolean( datosElementos.getProperty( "elemento" + i + ".esMetal" ) );
            int periodo = Integer.parseInt( datosElementos.getProperty( "elemento" + i + ".periodo" ) );
            int grupo = Integer.parseInt( datosElementos.getProperty( "elemento" + i + ".grupo" ) );
            double energiaDeIonizacion = Double.parseDouble( datosElementos.getProperty( "elemento" + i + ".energiaIonizacion" ) );

            Elemento elemento = new Elemento( nombre, simbolo, masa, numeroAtomico, esMetal, periodo, grupo, energiaDeIonizacion );
            elementos.add( elemento );
        }
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna los elementos de la tabla peri�dica por per�odo.<br>
     * <b>pre:</b> La lista de elementos est� inicializada. <br>
     * @return Lista de elementos de la tabla peri�dica por per�odo. <br>
     *         Los elementos deben ir ordenados, los primeros elementos corresponden a los que se encuentran desde el per�odo 1 y grupo 1, hasta el per�odo 8 y grupo 8,
     *         siguiente con el siguiente per�odo hasta llegar al elemento del �ltimo per�odo y �ltimo grupo. Si no hay elemento en un per�odo y grupo dados, se inserta null
     *         en la lista.
     */
    public ArrayList darElementosPorPeriodo( )
    {
        ArrayList elementosPorPeriodo = new ArrayList( );

        for( int i = 1; i <= NUMERO_PERIODOS; i++ )
        {
            for( int j = 1; j <= NUMERO_GRUPOS; j++ )
            {
                elementosPorPeriodo.add( darElementoPorPeriodoGrupo( i, j ) );
            }
        }
        return elementosPorPeriodo;
    }

    /**
     * Retorna el elemento con el grupo y el per�odo dados.<br>
     * @param pGrupo Grupo del elemento. pGrupo > 0 && pGrupo <= NUMERO_GRUPOS. 
     * @param pPeriodo Per�odo del elemento. pPeriodo > 0 && pPeriodo <= NUMERO_PERIODOS.
     * @return Elemento con el grupo y per�odo especificados, null si no existe.
     */
    public Elemento darElementoPorPeriodoGrupo( int pPeriodo, int pGrupo )
    {
        Elemento elemento = null;
        if( pPeriodo > NUMERO_PERIODOS && pGrupo > NUMERO_GRUPOS )
        {
            return elemento;
        }

        for( int i = 0; i < elementos.size( ); i++ )
        {
            Elemento elem = ( Elemento )elementos.get( i );
            if( elem.darGrupo( ) == pGrupo && elem.darPeriodo( ) == pPeriodo )
            {
                elemento = elem;
            }

        }
        return elemento;
    }

    /**
     * Retorna un elemento dado su nombre.<br>
     * @param pNombre Nombre del elemento a buscar. pNombre != null && pNombre != "".<br>
     * @return El elemento que tiene el nombre especificado, null si no existe.
     */
    public Elemento buscarElementoPorNombre( String pNombre )
    {
        Elemento elemento = null;
        for( int i = 0; i < elementos.size( ); i++ )
        {
            Elemento elem = ( Elemento )elementos.get( i );
            if( pNombre.equals( elem.darNombre( ) ) )
            {
                elemento = elem;
            }
        }
        return elemento;
    }

    /**
     * Retorna un elemento dado su s�mbolo qu�mico.<br>
     * @param pSimboloQuimico S�mbolo qu�mico del elemento a buscar. pSimboloQuimico != null && pSimboloQuimico != "".<br>
     * @return El elemento que tiene el s�mbolo especificado, null si no existe.
     */
    public Elemento buscarElementoPorSimboloQuimico( String pSimboloQuimico )
    {
        Elemento elemento = null;
        for( int i = 0; i < elementos.size( ); i++ )
        {
            Elemento elem = ( Elemento )elementos.get( i );
            if( pSimboloQuimico.equals( elem.darSimboloQuimico( ) ) )
            {
                elemento = elem;
            }
        }
        return elemento;
    }

    /**
     * Retorna un elemento dado su n�mero at�mico.
     * @param pNumeroAtomico N�mero at�mico del elemento a buscar. pNumeroAtomico > 0
     * @return El elemento que tiene el n�mero at�mico especificado, null si no existe.
     */
    public Elemento buscarElementoPorNumeroAtomico( int pNumeroAtomico )
    {
        Elemento elemento = null;
        for( int i = 0; i < elementos.size( ); i++ )
        {
            Elemento elem = ( Elemento )elementos.get( i );
            if( elem.darNumeroAtomico( ) == pNumeroAtomico )
            {
                elemento = elem;
            }
        }
        return elemento;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.<br>
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n2.<br>
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}