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
 * Clase que representa un puesto de votación.<br>
 * <b>inv:</b><br>
 * //TODO Parte1 PuntoC Defina el invariante de la clase y documéntelo.
 */
public class PuestoVotacion implements Serializable
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
     * Nombre del puesto de votación.
     */
    private String nombre;

    /**
     * Dirección del puesto de votación.
     */
    private String direccion;

    /**
     * Lista de ciudadanos inscritos en el puesto de votación.
     */
    private ArrayList inscritos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el puesto de votación con la información dada por parámetro. <br>
     * <b>post: </b>El puesto de votación se inicializó con los valores de nombre y dirección dados por parámetro.<br>
     * La lista de inscritos quedó inicializada.
     * @param pNombre Nombre del puesto de votación. pNombre != null && pNombre != "".
     * @param pDireccion Dirección del puesto de votación. pDireccion != null && pDireccion != "".
     */
    public PuestoVotacion( String pNombre, String pDireccion )
    {
        nombre = pNombre;
        direccion = pDireccion;
        inscritos = new ArrayList( );

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del puesto de votación.
     * @return Nombre del puesto de votación.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la lista de ciudadanos inscritos en el puesto de votación.
     * @return Lista de ciudadanos inscritos.
     */
    public ArrayList darInscritos( )
    {
        return inscritos;
    }

    /**
     * Retorna la dirección del puesto de votación.
     * @return Dirección del puesto de votación.
     */
    public String darDireccion( )
    {
        return direccion;
    }

    /**
     * Retorna el número de ciudadanos inscritos en el puesto de votación.
     * @return Número de ciudadanos inscritos en el puesto de votación.
     */
    public int darNumInscritos( )
    {
        return inscritos.size( );
    }

    /**
     * Agrega un ciudadano a la lista de inscritos del puesto de votación.
     * @param pCiudadano Ciudadano a inscribir en el puesto de votación. pCiudadano != null.
     */
    public void inscribirCiudadano( Ciudadano pCiudadano )
    {
        inscritos.add( pCiudadano );
        verificarInvariante( );
    }

    /**
     * Calcula el número de hombres inscritos hasta el momento en el puesto de votación.
     * @return Número de hombres inscritos.
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
     * Calcula el número de mujeres inscritas hasta el momento en el puesto de votación.
     * @return Número de mujeres inscritas.
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
     * Verifica si está inscrito o no un ciudadano en el puesto de votación.<br>
     * @param pCedulaCiudadano Cédula del ciudadano que se desea saber si está inscrito o no en el puesto de votación. pCedulaCiudadano != null && pCedulaCiudadano != "".
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
     * Devuelve la representación en String del puesto de votación. <br>
     * @return Una cadena con los nombres con el siguiente formato: <nombre>.
     */
    public String toString( )
    {
        return nombre;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    // TODO Parte1 PuntoB Cree e implemente el método private void verificarInvariante para validar el invariante definido en Parte1 PuntoC.
    public void verificarInvariante()
    {
    	
    }

}
