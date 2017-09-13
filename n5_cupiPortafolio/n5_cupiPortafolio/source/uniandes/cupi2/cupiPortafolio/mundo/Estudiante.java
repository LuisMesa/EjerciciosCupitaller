/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_cupiPortafolio
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiPortafolio.mundo;

/**
 * Clase que representa un estudiante.
 */
public class Estudiante
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Nombre del estudiante.
     */
    private String nombre;

    /**
     * C�digo del estudiante.
     */
    private int codigo;

    /**
     * Semestre del estudiante.
     */
    private int semestre;

    /**
     * Promedio del estudiante.
     */
    private double promedio;

    /**
     * N�mero de cr�ditos vistos por el estudiante.
     */
    private double creditosVistos;

    /**
     * Estado del estudiante (True si es graduado o False si es lo contrario).
     */
    private boolean estadoEstudiante;

    /**
     * Ruta de la imagen del estudiante.
     */
    private String rutaImagen;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Inicializa el estudiante con la informaci�n dada por par�metro.<br>
     * <b>post: </b> El estudiante se inicializ� con los valores de nombre, c�digo, semestre, promedio, n�mero de cr�ditos vistos, estado del estudiante y ruta de la imagen dados por par�metro.
     * @param pNombre Nombre del estudiante. pNombre != null && pNombre != "".
     * @param pCodigo C�digo del estudiante. pCodigo > 0.
     * @param pSemestre Semestre del estudiante. pSemestre >= 0.
     * @param pPromedio Promedio del estudiante. pPromedio >= 0 && pPromedio <= 5.
     * @param pCreditosVistos Cr�ditos vistos del estudiante. pCreditosVistos >= 0.
     * @param pEstadoEstudiante Estado del estudiante. pEstadoEstudiante != null.
     * @param pRutaImagen Ruta de la imagen del estudiante. pRutaImagen != null && pRutaImagen != "".
     */
    public Estudiante( String pNombre, int pCodigo, int pSemestre, double pPromedio, double pCreditosVistos, boolean pEstadoEstudiante, String pRutaImagen )
    {
        nombre = pNombre;
        codigo = pCodigo;
        semestre = pSemestre;
        promedio = pPromedio;
        estadoEstudiante = pEstadoEstudiante;
        creditosVistos = pCreditosVistos;
        rutaImagen = pRutaImagen;
    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna el nombre del estudiante.
     * @return Nombre del estudiante.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el c�digo del estudiante.
     * @return C�digo del estudiante.
     */
    public int darCodigo( )
    {
        return codigo;
    }

    /**
     * Retorna el semestre del estudiante.
     * @return Semestre del estudiante.
     */
    public int darSemestre( )
    {
        return semestre;
    }

    /**
     * Retorna el promedio del estudiante.
     * @return Promedio del estudiante.
     */
    public double darPromedio( )
    {
        return promedio;
    }
    
    /**
     * Retorna el n�mero de cr�ditos vistos por el estudiante.
     * @return Cr�ditos vistos por el estudiante.
     */
    public double darCreditosVistos( )
    {
        return creditosVistos;
    }
    
    /**
     * Retorna el estado del estudiante.
     * @return Estado del estudiante. True si es un estudiante graduado, false de lo contrario.
     */
    public boolean darEstadoEstudiante( )
    {
        return estadoEstudiante;
    }

    /**
     * Retorna la ruta de la imagen del estudiante.
     * @return Ruta de la imagen del estudiante.
     */
    public String darRutaImagen( )
    {
        return rutaImagen;
    }

    /**
     * Cambia el promedio actual del estudiante por el del par�metro.
     * <b>post: </b> El promedio se cambi� con el valor del nuevo promedio dado por par�metro.
     * @param pPromedioNuevo Promedio nuevo del estudiante.
     */
    public void cambiarPromedio( double pPromedioNuevo )
    {
        promedio = pPromedioNuevo;
    }

}