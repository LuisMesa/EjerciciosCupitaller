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
import java.util.Date;

/**
 * Clase que representa un ciudadano inscrito en un puesto de votaci�n.<br>
 * <b>inv:</b><br>
 * //TODO Parte1 PuntoA Defina el invariante de la clase y docum�ntelo.
 */
public class Ciudadano implements Serializable
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa la serializaci�n.
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
     * C�dula del ciudadano.
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
     * Fecha de expedici�n de la c�dula del ciudadano.
     */
    private Date fechaExpedicion;

    /**
     * Lugar de expedici�n de la c�dula del ciudadano.
     */
    private String lugarExpedicion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el ciudadano con la informaci�n dada por par�metro. <br>
     * <b>post: </b>El ciudadano se inicializ� con el valor nombre dado por par�metro.<br>
     * @param pCedula C�dula del ciudadano. pCedula != null && pCedula != "".
     * @param pApellidos Apellidos del ciudadano. pApellidos != null && pApellidos != "".
     * @param pNombres Nombres del ciudadano. pNombres != null && pNombres != "".
     * @param pFechaNacimiento Fecha de nacimiento del ciudadano. pFechaNacimiento != null.
     * @param pLugarNacimiento Lugar de nacimiento del ciudadano. pLugarNacimiento != null && pLugarNacimiento != "".
     * @param pSexo Sexo del ciudadano. pSexo != null && (pSexo == FEMENINO || pSexo == MASCULINO ).
     * @param pFechaExpedicion Fecha de expedici�n de la c�dula del ciudadano. pFechaExpedicion != null.
     * @param pLugarExpedicion Lugar de expedici�n de la c�dula del ciudadano. pLugarExpedicion != null && pLugarExpedicion != "".
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
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna la c�dula del ciudadano.
     * @return C�dula del ciudadano.
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
     * Retorna la edad en a�os del ciudadano.
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
     * Retorna la fecha de expedici�n de la c�dula del ciudadano.
     * @return Fecha de expedici�n de la c�dula del ciudadano.
     */
    public Date darFechaExpedicion( )
    {
        return fechaExpedicion;
    }

    /**
     * Retorna el lugar de expedici�n de la c�dula del ciudadano.
     * @return Lugar de expedici�n de la c�dula del ciudadano.
     */
    public String darLugarExpedicion( )
    {
        return lugarExpedicion;
    }

    /**
     * Retorna la representaci�n en String del ciudadano.
     * @return Una cadena con los nombres, apellidos y c�dula con el siguiente formato: <nombres> <apellidos> - <c�dula>.
     */
    public String toString( )
    {
        return nombres + " " + apellidos + " - " + cedula;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    // TODO Parte1 PuntoB Cree e implemente el m�todo private void verificarInvariante para validar el invariante definido en Parte1 PuntoA.
    public void verificarInvariante()
    {
    	
    }
}