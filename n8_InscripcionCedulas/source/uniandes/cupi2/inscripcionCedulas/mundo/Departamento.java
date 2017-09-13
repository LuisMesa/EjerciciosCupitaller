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
     * Constante que representa la serialización.
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
     * Inicializa un departamento con la información dada por parámetro.<br>
     * <b>post: </b>El departamento se inicializó con el valor nombre dado por parámetro.<br>
     * La lista de municipios quedó inicializada.
     * @param pNombre Nombre del departamento. pNombre != null && pNombre != "".
     */
    public Departamento( String pNombre )
    {
        nombre = pNombre;
        municipios = new ArrayList( );

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
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
     * <b>pre</b>: La lista de municipios está inicializada.
     * @return Municipios del departamento.
     */
    public ArrayList darMunicipios( )
    {
        return municipios;
    }

    /**
     * Retorna el número de ciudadanos inscritos en el departamento.
     * <b>pre</b>: La lista de municipios está inicializada.
     * @return Número de ciudadanos inscritos en el departamento.
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
     * Inscribe a un ciudadano en el puesto de votación y municipio dados por parámetro. <br>
     * <b>pre</b>: La lista de municipios está inicializada. <br>
     * <b>post: </b> Se inscribió al ciudadano. <br>
     * @param pMunicipio Nombre del municipio al que se va a inscribir el ciudadano. municipio != null y municipio != "".
     * @param pPuesto Nombre del puesto de votación al que se va a inscribir el ciudadano. puesto != null y puesto != "".
     * @param pCiudadano Ciudadano a inscribir en el departamento. pCiudadano != null.
     */
    public void inscribirCiudadano( String pMunicipio, String pPuesto, Ciudadano pCiudadano )
    {
        //TODO Parte4 PuntoD Complete el método según la documentación dada.
    	
    		buscarMunicipio(pMunicipio).inscribirCiudadano(pPuesto, pCiudadano);
    	
    	
        verificarInvariante( );
    }

    /**
     * Busca el municipio cuyo nombre es dado por parámetro. <br>
     * <b>pre</b>: La lista de municipios está inicializada. <br>
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
     * Calcula el número de hombres inscritos en el departamento.
     * <b>pre</b>: La lista de municipios está inicializada.
     * @return Número de hombres inscritos.
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
     * Calcula el número de mujeres inscritas en el departamento.
     * <b>pre</b>: La lista de municipios está inicializada.
     * @return Número de mujeres inscritas.
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
     * Verifica si está inscrito o no un ciudadano en el departamento. <br>
     * <b>pre</b>: La lista de municipios está inicializada.
     * @param pCedulaCiudadano Cédula del ciudadano que se desea saber si está inscrito o no en el puesto de votación. pCedulaCiudadano != null && pCedulaCiudadano != "".
     * @return True si el ciudadano se encuentra inscrito en algún municipio del departamento o false de lo contrario.
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
     * Retorna la representación en String del departamento.
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
        assert nombre != null && !nombre.equals( "" ) : "El nombre del departamento no puede ser nulo o vacío.";
        assert municipios != null : "Los municipios del departamento no pueden ser nulos.";
    }
}
