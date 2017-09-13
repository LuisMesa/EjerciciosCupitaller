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
     * Constante que representa la serializaci�n.
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
     * Lista de puestos de votaci�n en el municipio.
     */
    private ArrayList puestosVotacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el municipio con la informaci�n dada por par�metro.<br>
     * <b>post: </b>El municipio se inicializ� con el valor nombre dado por par�metro.<br>
     * La lista de puestos de votaci�n qued� inicializada.
     * @param pNombre Nombre del municipio. pNombre != null && pNombre != "".
     */
    public Municipio( String pNombre )
    {
        nombre = pNombre;
        puestosVotacion = new ArrayList( );

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // M�todos
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
     * Retorna la lista de puestos de votaci�n del municipio.
     * @return Puesto de votaci�n del municipio.
     */
    public ArrayList darPuestosVotacion( )
    {
        return puestosVotacion;
    }

    /**
     * Retorna el n�mero de ciudadanos inscritos en el municipio.
     * @return N�mero de ciudadanos inscritos en el municipio.
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
     * Agrega un nuevo puesto de votaci�n del municipio.
     * @param pNombre Puesto de votaci�n a agregar. pNombre != null && pNombre != "".
     * @param pDireccion Puesto de votaci�n a agregar. pDireccion != null && pDireccion != "".
     */
    public void agregarPuestoVotacion( String pNombre, String pDireccion )
    {
        PuestoVotacion p = new PuestoVotacion( pNombre, pDireccion );
        puestosVotacion.add( p );
        verificarInvariante( );
    }

    /**
     * Inscribe a un ciudadano en el puesto de votaci�n del municipio dado por par�metro.
     * @param pPuesto Nombre del puesto de votaci�n al que se va a inscribir el ciudadano. pPuesto != null && pPuesto != "".
     * @param pCiudadano Ciudadano a inscribir en el municipio. pCiudadano != null.
     */
    public void inscribirCiudadano( String pPuesto, Ciudadano pCiudadano )
    {
        PuestoVotacion p = buscarPuestoVotacion( pPuesto );
        p.inscribirCiudadano( pCiudadano );

        verificarInvariante( );
    }

    /**
     * Busca el puesto de votaci�n cuyo nombre es dado por par�metro.
     * @param pNombrePuestoVotacion Nombre del puesto de votaci�n. pNombrePuestoVotacion != null && pNombrePuestoVotacion != "".
     * @return Puesto de votaci�n con el nombre dado, null en caso de no encontrarlo.
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
     * Calcula el n�mero de hombres inscritos en el municipio.
     * @return N�mero de hombres inscritos.
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
     * Calcula el n�mero de mujeres inscritas en el municipio.
     * @return N�mero de mujeres inscritas.
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
     * Verifica si est� inscrito o no un ciudadano en el municipio.<br>
     * @param pCedulaCiudadano C�dula del ciudadano que se desea saber si est� inscrito o no en el puesto de votaci�n. pCedulaCiudadano != null && pCedulaCiudadano != "".
     * @return True si el ciudadano se encuentra inscrito en alg�n puesto de votaci�n del municipio o false de lo contrario.
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
     * Retorna la representaci�n en String del municipio.
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
        assert nombre != null && !nombre.equals( "" ) : "El nombre del municipio no puede ser nulo o vac�o.";
        assert puestosVotacion != null : "La lista de puestos de votaci�n no puede ser nula.";
    }

}
