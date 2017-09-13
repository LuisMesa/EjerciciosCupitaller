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
import java.util.Date;

/**
 * Clase que representa un ciudadano inscrito en un puesto de votación.<br>
 * <b>inv:</b><br>
 * //TODO Parte1 PuntoA Defina el invariante de la clase y documéntelo.
 */
public class Ciudadano implements Serializable
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constante que representa el sexo femenino.
     */
    public static final String FEMENINO = "FEM";

    /**
     * Constante que representa el sexo masculino.
     */
    public static final String MASCULINO = "MASC";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Cédula del ciudadano.
     */
    private String cedula;

    /**
     * Apellidos del ciudadano.
     */
    private String apellidos;

    /**
     * Nombres del ciudadano.
     */
    private String nombres;

    /**
     * Fecha de nacimiento del ciudadano.
     */
    private Date fechaNacimiento;

    /**
     * Lugar de nacimiento del ciudadano.
     */
    private String lugarNacimiento;

    /**
     * Sexo del ciudadano.
     */
    private String sexo;

    /**
     * Fecha de expedición de la cédula del ciudadano.
     */
    private Date fechaExpedicion;

    /**
     * Lugar de expedición de la cédula del ciudadano.
     */
    private String lugarExpedicion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el ciudadano con la información dada por parámetro. <br>
     * <b>post: </b>El ciudadano se inicializó con el valor nombre dado por parámetro.<br>
     * @param pCedula Cédula del ciudadano. pCedula != null && pCedula != "".
     * @param pApellidos Apellidos del ciudadano. pApellidos != null && pApellidos != "".
     * @param pNombres Nombres del ciudadano. pNombres != null && pNombres != "".
     * @param pFechaNacimiento Fecha de nacimiento del ciudadano. pFechaNacimiento != null.
     * @param pLugarNacimiento Lugar de nacimiento del ciudadano. pLugarNacimiento != null && pLugarNacimiento != "".
     * @param pSexo Sexo del ciudadano. pSexo != null && (pSexo == FEMENINO || pSexo == MASCULINO ).
     * @param pFechaExpedicion Fecha de expedición de la cédula del ciudadano. pFechaExpedicion != null.
     * @param pLugarExpedicion Lugar de expedición de la cédula del ciudadano. pLugarExpedicion != null && pLugarExpedicion != "".
     */
    public Ciudadano( String pCedula, String pApellidos, String pNombres, Date pFechaNacimiento, String pLugarNacimiento, String pSexo, Date pFechaExpedicion, String pLugarExpedicion )
    {
        cedula = pCedula;
        apellidos = pApellidos;
        nombres = pNombres;
        fechaNacimiento = pFechaNacimiento;
        lugarNacimiento = pLugarNacimiento;
        sexo = pSexo;
        fechaExpedicion = pFechaExpedicion;
        lugarExpedicion = pLugarExpedicion;

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la cédula del ciudadano.
     * @return Cédula del ciudadano.
     */
    public String darCedula( )
    {
        return cedula;
    }

    /**
     * Retorna los apellidos del ciudadano.
     * @return Apellidos del ciudadano.
     */
    public String darApellidos( )
    {
        return apellidos;
    }

    /**
     * Retorna los nombres del ciudadano.
     * @return Nombres del ciudadano.
     */
    public String darNombres( )
    {
        return nombres;
    }

    /**
     * Retorna la fecha de nacimiento del ciudadano.
     * @return Fecha de nacimiento del ciudadano.
     */
    public Date darFechaNacimiento( )
    {
        return fechaNacimiento;
    }

    /**
     * Retorna el lugar de nacimiento del ciudadano.
     * @return Lugar de nacimiento del ciudadano.
     */
    public String darLugarNacimiento( )
    {
        return lugarNacimiento;
    }

    /**
     * Retorna la edad en años del ciudadano.
     * @return Edad del ciudadano.
     */
    public int darEdad( )
    {
        Date actual = new Date( );
        int edad = actual.getYear( ) - fechaNacimiento.getYear( );
        if( actual.getMonth( ) <= fechaNacimiento.getMonth( ) && actual.getDate( ) < fechaNacimiento.getDate( ) )
        {
            edad -= 1;
        }

        return edad;
    }

    /**
     * Retorna el sexo del ciudadano.
     * @return Sexo del ciudadano.
     */
    public String darSexo( )
    {
        return sexo;
    }

    /**
     * Retorna la fecha de expedición de la cédula del ciudadano.
     * @return Fecha de expedición de la cédula del ciudadano.
     */
    public Date darFechaExpedicion( )
    {
        return fechaExpedicion;
    }

    /**
     * Retorna el lugar de expedición de la cédula del ciudadano.
     * @return Lugar de expedición de la cédula del ciudadano.
     */
    public String darLugarExpedicion( )
    {
        return lugarExpedicion;
    }

    /**
     * Retorna la representación en String del ciudadano.
     * @return Una cadena con los nombres, apellidos y cédula con el siguiente formato: <nombres> <apellidos> - <cédula>.
     */
    public String toString( )
    {
        return nombres + " " + apellidos + " - " + cedula;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    // TODO Parte1 PuntoB Cree e implemente el método private void verificarInvariante para validar el invariante definido en Parte1 PuntoA.
    public void verificarInvariante()
    {
    	
    }
}