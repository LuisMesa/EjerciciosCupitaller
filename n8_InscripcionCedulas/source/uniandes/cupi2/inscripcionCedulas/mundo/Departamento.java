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

import org.jfree.data.time.Millisecond;

/**
 * Clase que representa un departamento.<br>
 * <b>inv:</b><br>
 * nombre != null && nombre != "". <br>
 * municipios != null. <br>
 */
public class Departamento implements Serializable
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
     * Nombre del departamento.
     */
    private String nombre;

    /**
     * Lista de municipios del departamento.
     */
    private ArrayList municipios;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa un departamento con la informaci�n dada por par�metro.<br>
     * <b>post: </b>El departamento se inicializ� con el valor nombre dado por par�metro.<br>
     * La lista de municipios qued� inicializada.
     * @param pNombre Nombre del departamento. pNombre != null && pNombre != "".
     */
    public Departamento( String pNombre )
    {
        nombre = pNombre;
        municipios = new ArrayList( );

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del departamento.
     * @return Nombre del departamento.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la lista de municipios del departamento.
     * <b>pre</b>: La lista de municipios est� inicializada.
     * @return Municipios del departamento.
     */
    public ArrayList darMunicipios( )
    {
        return municipios;
    }

    /**
     * Retorna el n�mero de ciudadanos inscritos en el departamento.
     * <b>pre</b>: La lista de municipios est� inicializada.
     * @return N�mero de ciudadanos inscritos en el departamento.
     */
    public int darNumInscritos( )
    {
        int numInscritos = 0;
        for( int i = 0; i < municipios.size( ); i++ )
        {
            Municipio m = ( Municipio )municipios.get( i );
            numInscritos += m.darNumInscritos( );
        }

        return numInscritos;
    }

    /**
     * Agrega un municipio al departamento.
     * @param pMunicipio Nombre del municipio que debe ser agregado. pMunicipio != null y pMunicipio != "".
     */
    public void agregarMunicipio( String pMunicipio )
    {
        Municipio m = new Municipio( pMunicipio );
        municipios.add( m );
        verificarInvariante( );
    }

    /**
     * Inscribe a un ciudadano en el puesto de votaci�n y municipio dados por par�metro. <br>
     * <b>pre</b>: La lista de municipios est� inicializada. <br>
     * <b>post: </b> Se inscribi� al ciudadano. <br>
     * @param pMunicipio Nombre del municipio al que se va a inscribir el ciudadano. municipio != null y municipio != "".
     * @param pPuesto Nombre del puesto de votaci�n al que se va a inscribir el ciudadano. puesto != null y puesto != "".
     * @param pCiudadano Ciudadano a inscribir en el departamento. pCiudadano != null.
     */
    public void inscribirCiudadano( String pMunicipio, String pPuesto, Ciudadano pCiudadano )
    {
        //TODO Parte4 PuntoD Complete el m�todo seg�n la documentaci�n dada.
    	
    		buscarMunicipio(pMunicipio).inscribirCiudadano(pPuesto, pCiudadano);
    	
    	
        verificarInvariante( );
    }

    /**
     * Busca el municipio cuyo nombre es dado por par�metro. <br>
     * <b>pre</b>: La lista de municipios est� inicializada. <br>
     * @param pNombreMunicipio Nombre del municipio. pNombreMunicipio != null && pNombreMunicipio != "".
     * @return Municipio con el nombre dado, null en caso que no lo encuentre.
     */
    public Municipio buscarMunicipio( String pNombreMunicipio )
    {
        Municipio municipioBuscado = null;
        for( int i = 0; i < municipios.size( ); i++ )
        {
            Municipio m = ( Municipio )municipios.get( i );
            if( m.darNombre( ).equals( pNombreMunicipio ) )
            {
                municipioBuscado = m;
            }
        }
        return municipioBuscado;
    }

    /**
     * Calcula el n�mero de hombres inscritos en el departamento.
     * <b>pre</b>: La lista de municipios est� inicializada.
     * @return N�mero de hombres inscritos.
     */
    public int calcularNumeroHombresInscritos( )
    {
        int numHombres = 0;
        for( int i = 0; i < municipios.size( ); i++ )
        {
            Municipio m = ( Municipio )municipios.get( i );
            numHombres += m.calcularNumeroHombresInscritos( );
        }

        return numHombres;
    }

    /**
     * Calcula el n�mero de mujeres inscritas en el departamento.
     * <b>pre</b>: La lista de municipios est� inicializada.
     * @return N�mero de mujeres inscritas.
     */
    public int calcularNumeroMujeresInscritas( )
    {
        int numMujeres = 0;
        for( int i = 0; i < municipios.size( ); i++ )
        {
            Municipio m = ( Municipio )municipios.get( i );
            numMujeres += m.calcularNumeroMujeresInscritas( );
        }

        return numMujeres;
    }

    /**
     * Verifica si est� inscrito o no un ciudadano en el departamento. <br>
     * <b>pre</b>: La lista de municipios est� inicializada.
     * @param pCedulaCiudadano C�dula del ciudadano que se desea saber si est� inscrito o no en el puesto de votaci�n. pCedulaCiudadano != null && pCedulaCiudadano != "".
     * @return True si el ciudadano se encuentra inscrito en alg�n municipio del departamento o false de lo contrario.
     */
    public boolean existeCiudadano( String pCedulaCiudadano )
    {
        boolean seEncuentra = false;
        for( int i = 0; i < municipios.size( ); i++ )
        {
            Municipio m = ( Municipio )municipios.get( i );
            if( m.existeCiudadano( pCedulaCiudadano ) )
            {
                seEncuentra = true;
            }
        }
        return seEncuentra;
    }
    /**
     * Retorna la representaci�n en String del departamento.
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
     * municipios != null. <br>
     */
    private void verificarInvariante( )
    {
        assert nombre != null && !nombre.equals( "" ) : "El nombre del departamento no puede ser nulo o vac�o.";
        assert municipios != null : "Los municipios del departamento no pueden ser nulos.";
    }
}
