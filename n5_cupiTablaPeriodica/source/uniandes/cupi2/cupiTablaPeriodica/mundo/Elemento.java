/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_cupiTablaPeriodica
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupiTablaPeriodica.mundo;

/**
 * Clase que representa el elemento.
 */
public class Elemento
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del elemento.
     */
    private String nombre;

    /**
     * Símbolo químico del elemento.
     */
    private String simboloQuimico;

    /**
     * Masa del elemento.
     */
    private double masa;

    /**
     * Número atómico del elemento.
     */
    private int numeroAtomico;

    /**
     * Boolean que representa si el elemento pertenece al grupo de los metales.
     */
    private boolean esMetal;

    /**
     * Período al que pertenece el elemento.
     */
    private int periodo;

    /**
     * Grupo al que pertenece el elemento.
     */
    private int grupo;

    /**
     * Energía de ionización.
     */
    private double energiaDeIonizacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo elemento. <br>
     * <b> post: </b> Se inicializaron los atributos nombre, simbolo, masa, numeroAtomico, esMetal, periodo, grupo y energiaDeIonizacion con los valores dados por parámetro.
     * @param pNombre Nombre del elemento. pNombre != null && pNombre != "".
     * @param pSimboloQuimico Símbolo químico del elemento. pSimboloQuimico != null && pSimboloQuimico != "".
     * @param pMasa Masa del elemento. pMasa > 0.
     * @param pNumeroAtomico Número atómico del elemento. pNumeroAtomico > 0.
     * @param pEsMetal Si es metal o no metal.
     * @param pPeriodo Período del elemento. pPeriodo > 0.
     * @param pGrupo Grupo del elemento. pGrupo > 0.
     * @param pEnergiaDeIonizacion Energía de ionización del elemento. pEnergiaDeIonizacion > 0.
     */
    public Elemento( String pNombre, String pSimboloQuimico, double pMasa, int pNumeroAtomico, boolean pEsMetal, int pPeriodo, int pGrupo, double pEnergiaDeIonizacion )
    {
        nombre = pNombre;
        simboloQuimico = pSimboloQuimico;
        masa = pMasa;
        numeroAtomico = pNumeroAtomico;
        esMetal = pEsMetal;
        periodo = pPeriodo;
        grupo = pGrupo;
        energiaDeIonizacion = pEnergiaDeIonizacion;

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del elemento.
     * @return Nombre del elemento.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el símbolo químico del elemento.
     * @return Símbolo químico del elemento.
     */
    public String darSimboloQuimico( )
    {
        return simboloQuimico;
    }

    /**
     * Retorna la masa del elemento.
     * @return Masa del elemento.
     */
    public double darMasa( )
    {
        return masa;
    }

    /**
     * Retorna el número atómico del elemento.
     * @return Número atómico del elemento.
     */
    public int darNumeroAtomico( )
    {
        return numeroAtomico;
    }

    /**
     * Retorna el período al cual pertenece el elemento.
     * @return Período al cual pertenece el elemento.
     */
    public int darPeriodo( )
    {
        return periodo;
    }

    /**
     * Retorna el grupo al cual pertenece el elemento.
     * @return Grupo al cual pertenece el elemento.
     */
    public int darGrupo( )
    {
        return grupo;
    }

    /**
     * Retorna la energía de ionización en KJ/mol del elemento.
     * @return Energía de ionización del elemento.
     */
    public double darEnergiaDeIonizacion( )
    {
        return energiaDeIonizacion;
    }

    /**
     * Verifica si el elemento pertenece al grupo de los metales.
     * @return True si pertenece al grupo del los metales, false de lo contrario.
     */
    public boolean esMetal( )
    {
        return esMetal;
    }
}
