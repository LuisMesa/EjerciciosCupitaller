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
 * Clase que representa un puesto de votaci�n.<br>
 * <b>inv:</b><br>
 * //TODO Parte1 PuntoC Defina el invariante de la clase y docum�ntelo.
 */
public class PuestoVotacion implements Serializable
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
     * Nombre del puesto de votaci�n.
     */
    private String nombre;

    /**
     * Direcci�n del puesto de votaci�n.
     */
    private String direccion;

    /**
     * Lista de ciudadanos inscritos en el puesto de votaci�n.
     */
    private ArrayList inscritos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el puesto de votaci�n con la informaci�n dada por par�metro. <br>
     * <b>post: </b>El puesto de votaci�n se inicializ� con los valores de nombre y direcci�n dados por par�metro.<br>
     * La lista de inscritos qued� inicializada.
     * @param pNombre Nombre del puesto de votaci�n. pNombre != null && pNombre != "".
     * @param pDireccion Direcci�n del puesto de votaci�n. pDireccion != null && pDireccion != "".
     */
    public PuestoVotacion( String pNombre, String pDireccion )
    {
        nombre = pNombre;
        direccion = pDireccion;
        inscritos = new ArrayList( );

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del puesto de votaci�n.
     * @return Nombre del puesto de votaci�n.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la lista de ciudadanos inscritos en el puesto de votaci�n.
     * @return Lista de ciudadanos inscritos.
     */
    public ArrayList darInscritos( )
    {
        return inscritos;
    }

    /**
     * Retorna la direcci�n del puesto de votaci�n.
     * @return Direcci�n del puesto de votaci�n.
     */
    public String darDireccion( )
    {
        return direccion;
    }

    /**
     * Retorna el n�mero de ciudadanos inscritos en el puesto de votaci�n.
     * @return N�mero de ciudadanos inscritos en el puesto de votaci�n.
     */
    public int darNumInscritos( )
    {
        return inscritos.size( );
    }

    /**
     * Agrega un ciudadano a la lista de inscritos del puesto de votaci�n.
     * @param pCiudadano Ciudadano a inscribir en el puesto de votaci�n. pCiudadano != null.
     */
    public void inscribirCiudadano( Ciudadano pCiudadano )
    {
        inscritos.add( pCiudadano );
        verificarInvariante( );
    }

    /**
     * Calcula el n�mero de hombres inscritos hasta el momento en el puesto de votaci�n.
     * @return N�mero de hombres inscritos.
     */
    public int calcularNumeroHombresInscritos( )
    {
        int numHombres = 0;
        for( int i = 0; i < inscritos.size( ); i++ )
        {
            Ciudadano temp = ( Ciudadano )inscritos.get( i );
            if( temp.darSexo( ).equals( Ciudadano.MASCULINO ) )
            {
                numHombres++;
            }
        }

        return numHombres;
    }

    /**
     * Calcula el n�mero de mujeres inscritas hasta el momento en el puesto de votaci�n.
     * @return N�mero de mujeres inscritas.
     */
    public int calcularNumeroMujeresInscritas( )
    {
        int numMujeres = 0;
        for( int i = 0; i < inscritos.size( ); i++ )
        {
            Ciudadano temp = ( Ciudadano )inscritos.get( i );
            if( temp.darSexo( ).equals( Ciudadano.FEMENINO ) )
            {
                numMujeres++;
            }
        }

        return numMujeres;
    }

    /**
     * Verifica si est� inscrito o no un ciudadano en el puesto de votaci�n.<br>
     * @param pCedulaCiudadano C�dula del ciudadano que se desea saber si est� inscrito o no en el puesto de votaci�n. pCedulaCiudadano != null && pCedulaCiudadano != "".
     * @return Retorna true si el ciudadano se encuentra en la lista de inscrito o false de lo contrario.
     */
    public boolean existeCiudadano( String pCedulaCiudadano )
    {

        boolean seEncuentra = false;
        for( int i = 0; i < inscritos.size( ); i++ )
        {
            Ciudadano temp = ( Ciudadano )inscritos.get( i );
            if( temp.darCedula( ).equals( pCedulaCiudadano ) )
            {
                seEncuentra = true;
            }
        }
        return seEncuentra;
    }

    /**
     * Devuelve la representaci�n en String del puesto de votaci�n. <br>
     * @return Una cadena con los nombres con el siguiente formato: <nombre>.
     */
    public String toString( )
    {
        return nombre;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    // TODO Parte1 PuntoB Cree e implemente el m�todo private void verificarInvariante para validar el invariante definido en Parte1 PuntoC.
    public void verificarInvariante()
    {
    	
    }

}
