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
package uniandes.cupi2.inscripcionCedulas.mundo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa un municipio.<br>
 * <b>inv:</b><br>
 * nombre != null && nombre != "". <br>
 * puestosVotacion != null. <br>
 */
public class Municipio implements Serializable
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa la serialización.
     */
    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del municipio.
     */
    private String nombre;

    /**
     * Lista de puestos de votación en el municipio.
     */
    private ArrayList puestosVotacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el municipio con la información dada por parámetro.<br>
     * <b>post: </b>El municipio se inicializó con el valor nombre dado por parámetro.<br>
     * La lista de puestos de votación quedó inicializada.
     * @param pNombre Nombre del municipio. pNombre != null && pNombre != "".
     */
    public Municipio( String pNombre )
    {
        nombre = pNombre;
        puestosVotacion = new ArrayList( );

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del municipio.
     * @return Nombre del municipio.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la lista de puestos de votación del municipio.
     * @return Puesto de votación del municipio.
     */
    public ArrayList darPuestosVotacion( )
    {
        return puestosVotacion;
    }

    /**
     * Retorna el número de ciudadanos inscritos en el municipio.
     * @return Número de ciudadanos inscritos en el municipio.
     */
    public int darNumInscritos( )
    {
        int inscritos = 0;
        for( int i = 0; i < puestosVotacion.size( ); i++ )
        {
            PuestoVotacion p = ( PuestoVotacion )puestosVotacion.get( i );
            inscritos += p.darNumInscritos( );
        }

        return inscritos;
    }

    /**
     * Agrega un nuevo puesto de votación del municipio.
     * @param pNombre Puesto de votación a agregar. pNombre != null && pNombre != "".
     * @param pDireccion Puesto de votación a agregar. pDireccion != null && pDireccion != "".
     */
    public void agregarPuestoVotacion( String pNombre, String pDireccion )
    {
        PuestoVotacion p = new PuestoVotacion( pNombre, pDireccion );
        puestosVotacion.add( p );
        verificarInvariante( );
    }

    /**
     * Inscribe a un ciudadano en el puesto de votación del municipio dado por parámetro.
     * @param pPuesto Nombre del puesto de votación al que se va a inscribir el ciudadano. pPuesto != null && pPuesto != "".
     * @param pCiudadano Ciudadano a inscribir en el municipio. pCiudadano != null.
     */
    public void inscribirCiudadano( String pPuesto, Ciudadano pCiudadano )
    {
        PuestoVotacion p = buscarPuestoVotacion( pPuesto );
        p.inscribirCiudadano( pCiudadano );

        verificarInvariante( );
    }

    /**
     * Busca el puesto de votación cuyo nombre es dado por parámetro.
     * @param pNombrePuestoVotacion Nombre del puesto de votación. pNombrePuestoVotacion != null && pNombrePuestoVotacion != "".
     * @return Puesto de votación con el nombre dado, null en caso de no encontrarlo.
     */
    public PuestoVotacion buscarPuestoVotacion( String pNombrePuestoVotacion )
    {
        PuestoVotacion puestoBuscado = null;
        for( int i = 0; i < puestosVotacion.size( ); i++ )
        {
            PuestoVotacion p = ( PuestoVotacion )puestosVotacion.get( i );
            if( p.darNombre( ).equals( pNombrePuestoVotacion ) )
            {
                puestoBuscado = p;
            }
        }
        return puestoBuscado;
    }

    /**
     * Calcula el número de hombres inscritos en el municipio.
     * @return Número de hombres inscritos.
     */
    public int calcularNumeroHombresInscritos( )
    {
        int numHombre = 0;
        for( int i = 0; i < puestosVotacion.size( ); i++ )
        {
            PuestoVotacion p = ( PuestoVotacion )puestosVotacion.get( i );
            numHombre += p.calcularNumeroHombresInscritos( );
        }

        return numHombre;
    }

    /**
     * Calcula el número de mujeres inscritas en el municipio.
     * @return Número de mujeres inscritas.
     */
    public int calcularNumeroMujeresInscritas( )
    {
        int numMujeres = 0;
        for( int i = 0; i < puestosVotacion.size( ); i++ )
        {
            PuestoVotacion p = ( PuestoVotacion )puestosVotacion.get( i );
            numMujeres += p.calcularNumeroMujeresInscritas( );
        }

        return numMujeres;
    }

    /**
     * Verifica si está inscrito o no un ciudadano en el municipio.<br>
     * @param pCedulaCiudadano Cédula del ciudadano que se desea saber si está inscrito o no en el puesto de votación. pCedulaCiudadano != null && pCedulaCiudadano != "".
     * @return True si el ciudadano se encuentra inscrito en algún puesto de votación del municipio o false de lo contrario.
     */
    public boolean existeCiudadano( String pCedulaCiudadano )
    {

        boolean seEncuentra = false;
        for( int i = 0; i < puestosVotacion.size( ); i++ )
        {
            PuestoVotacion p = ( PuestoVotacion )puestosVotacion.get( i );
            if( p.existeCiudadano( pCedulaCiudadano ) )
            {
                seEncuentra = true;
            }
        }
        return seEncuentra;
    }

    /**
     * Retorna la representación en String del municipio.
     * @return Una cadena con los nombres con el siguiente formato: <nombre>.
     */
    public String toString( )
    {
        return nombre;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase: <br>
     * <b>inv:</b><br>
     * nombre != null && nombre != "". <br>
     * puestosVotacion != null. <br>
     */
    private void verificarInvariante( )
    {
        assert nombre != null && !nombre.equals( "" ) : "El nombre del municipio no puede ser nulo o vacío.";
        assert puestosVotacion != null : "La lista de puestos de votación no puede ser nula.";
    }

}
