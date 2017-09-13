/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n2_empresa
 * Autor: EquipoCupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.empresa.mundo;

/**
 * Clase representa un empleado de la empresa.
 */
public class Empleado
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para el �rea administrativa.
     */
    public final static String ADMINISTRATIVA = "Administrativa";

    /**
     * Constante para el �rea tecnol�gica.
     */
    public final static String TECNOLOGICA = "Tecnol�gica";

    /**
     * Constante para el �rea de seguridad.
     */
    //TODO Parte1 PuntoA: Declare la constante SEGURIDAD con valor inicial Seguridad.
    public static final String SEGURIDAD = "Seguridad";

    /**
     * Constante para el valor del �rea administrativa.
     */
    public final static double VALOR_ADMINISTRATIVA = 0.7;

    /**
     * Constante para el valor del �rea tecnol�gica.
     */
    //TODO Parte1 PuntoB: Declare la constante VALOR_TECNOLOGICA con valor inicial 0.5
    public static final double VALOR_TECNOLOGICA =0.5;

    /**
     * Constante para el valor del �rea de seguridad.
     */
    //TODO Parte1 PuntoC: Declare la constante VALOR_SEGURIDAD con valor inicial 0.9
    public static final double VALOR_SEGURIDAD =0.9;
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del empleado.
     */
    private String nombre;

    /**
     * Edad del empleado.
     */
    private int edad;

    /**
     * Antig�edad del empleado en la empresa.
     */
    private int antiguedad;

    /**
     * Salario del empleado.
     */
    //TODO Parte1 PuntoD: Declare el atributo salario como un n�mero entero.
    private int salario;

    /**
     * �rea de la empresa en la que se desempe�a.
     */
    //TODO Parte1 PuntoE: Declare el atributo area como cadena de texto.  
    private String area;
    /**
     * Ruta de la imagen.
     */
    private String imagen;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Inicializa un empleado con la informaci�n dada por par�metro. <br>
     * <b>post: </b> Se construy� el empleado.
     * @param pNombre Nombre del empleado. pNombre != null && pNombre != "".
     * @param pEdad Edad del empleado. pEdad > 0.
     * @param pAntiguedad Antig�edad del empleado en la empresa. pAntiguedad >= 0.
     * @param pSalario Salario del empleado. pSalario>0.
     * @param pArea �rea en la que se desempe�a el empleado. pArea != null && pArea != "" && (pArea == ADMINISTRATIVA || pArea == TECNOLOGICA || pArea == SEGURIDAD).
     * @param pImagen Imagen del empleado. pImagen != null && pImagen != "".
     */
    public Empleado( String pNombre, int pEdad, int pAntiguedad, int pSalario, String pArea, String pImagen )
    {
        //TODO Parte1 PuntoF: Complete el m�todo constructor seg�n la documentaci�n.
    	nombre=pNombre;
    	edad=pEdad;
    	antiguedad=pAntiguedad;
    	salario=pSalario;
    	area=pArea;
    	imagen=pImagen;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del empleado.
     * @return Nombre del empleado.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la edad del empleado.
     * @return Edad del empleado.
     */
    public int darEdad( )
    {
        return edad;
    }

    /**
     * Retorna la antig�edad del empleado en a�os.
     * @return Antig�edad del empleado.
     */
    public int darAntiguedad( )
    {
        return antiguedad;
    }

    /**
     * Retorna el salario del empleado.
     * @return Salario del empleado.
     */
    public int darSalario( )
    {
        //TODO Parte1 PuntoG: Complete el m�todo seg�n la documentaci�n.
    	return salario;
    }

    /**
     * Retorna el �rea del empleado.
     * @return �rea en la que se desempe�a el empleado.
     */
    public String darArea( )
    {
        //TODO Parte1 PuntoH: Complete el m�todo seg�n la documentaci�n.
    	return area;
    }

    /**
     * Retorna la ruta donde se encuentra la imagen del empleado.
     * @return Ruta de la imagen.
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Devuelve las prestaciones del empleado usando la f�rmula:<br>
     * p = (a * s * v)/12 (p: prestaciones, a: antig�edad, s: salario, v: valor del �rea). <br>
     * @return Prestaciones del empleado.
     */
    public double calcularPrestaciones( )
    {
        //TODO Parte1 PuntoI: Complete el m�todo seg�n la documentaci�n.
    	double a = antiguedad;
    	double s =salario;
    	double v =0;
    	if(area.equals(ADMINISTRATIVA))
    		v=VALOR_ADMINISTRATIVA;
    	else if(area.equals(TECNOLOGICA))
    		v=VALOR_TECNOLOGICA;
    	else
    		v=VALOR_SEGURIDAD;
    	return (a * s * v)/12;
    }

    /**
     * Cambia el salario por el dado por par�metro.<br>
     * <b> post: </b> El salario tiene el nuevo valor.
     * @param pSalario Nuevo salario. pSalario >= 0.
     */
    public void cambiarSalario( int pSalario )
    {
        //TODO Parte1 PuntoJ: Complete el m�todo seg�n la documentaci�n.
    	salario = pSalario;
    }

}