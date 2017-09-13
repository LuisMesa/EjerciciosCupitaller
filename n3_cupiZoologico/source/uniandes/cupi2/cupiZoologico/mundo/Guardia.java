/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_cupiZoologico
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiZoologico.mundo;

/**
 * Clase que representa a un guardia.
 */
public class Guardia
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del guardia.
     */
    private String nombre;

    /**
     * A�os de experiencia como guardia.
     */
    private int anhosExperiencia;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa un guardia con los valores dados por par�metro. <br>
     * <b> post: </b> El guardia se inicializ� con los valores nombre y anhosExperiencia dados por par�metro.<br>
     * @param pNombre Nombre del guardia. pNombre != null && pNombre != "".
     * @param pAnhosExperiencia A�os de experiencia de guardia. pAnhosExperiencia >= 0.
     */
    public Guardia( String pNombre, int pAnhosExperiencia )
    {
        nombre = pNombre;
        anhosExperiencia = pAnhosExperiencia;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del guardia.
     * @return Nombre del guardia.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el n�mero de a�os de experiencia como guardia.
     * @return N�mero de a�os como experiencia.
     */
    public int darAnhosExperiencia( )
    {
        return anhosExperiencia;
    }

}
