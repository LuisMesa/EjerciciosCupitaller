/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n2_empresa
 * Autor: EquipoCupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.empresa.mundo;

/**
 * Clase que representa la empresa.
 */
public class Empresa
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la cota mínima de salarios.
     */
    //TODO Parte2 PuntoA: Declare la constante COTA_MINIMA con valor inicial 100000
	public static final int COTA_MINIMA = 100000;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Empleado 1 de la empresa.
     */
    private Empleado empleado1;

    /**
     * Empleado 2 de la empresa.
     */
    private Empleado empleado2;

    /**
     * Empleado 3 de la empresa.
     */
    //TODO Parte2 PuntoB: Declare el atributo empleado3.
    private Empleado empleado3;

    /**
     * Empleado 4 de la empresa.
     */
    //TODO Parte2 PuntoC: Declare el atributo empleado4.
    private Empleado empleado4;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea los empleados con los siguientes valores. <br>
     * Empleado 1 - nombre: Germán, edad: 24, antigüedad: 2, salario: 9000, área: seguridad, imagen: empleado1.png. <br>
     * Empleado 2 - nombre: Jaime, edad: 25, antigüedad: 3, salario: 12000, área: tecnológica, imagen: empleado2.png. <br>
     * Empleado 3 - nombre: Rafael, edad: 22, antigüedad: 0, salario: 8000, área: tecnológica, imagen: empleado3.png. <br>
     * Empleado 4 - nombre: Vanessa, edad: 28, antigüedad: 6, salario: 16000, área: administrativa, imagen: empleado4.png.
     */
    public Empresa( )
    {
        //TODO Parte2 PuntoD: Complete el método constructor con la documentación dada.
    	
    	empleado1=new Empleado("Germán", 24, 2, 9000, "Seguridad","empleado1.png");
    	empleado2=new Empleado("Jaime", 25, 3, 12000, "Tecnológica","empleado2.png");
    	empleado3=new Empleado("Rafael", 22, 0, 8000, "Tecnológica","empleado3.png");
    	empleado4=new Empleado("Vanessa", 28, 6, 16000, "Administrativa","empleado4.png");
    	
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el empleado 1 de la empresa.
     * @return Empleado 1 de la empresa.
     */
    public Empleado darEmpleado1( )
    {
        return empleado1;
    }

    /**
     * Retorna el empleado 2 de la empresa.
     * @return Empleado 2 de la empresa.
     */
    public Empleado darEmpleado2( )
    {
        return empleado2;
    }

    /**
     * Retorna el empleado 3 de la empresa.
     * @return Empleado 3 de la empresa.
     */
    public Empleado darEmpleado3( )
    {
        return empleado3;
    }

    /**
     * Retorna el empleado 4 de la empresa.
     * @return Empleado 4 de la empresa.
     */
    public Empleado darEmpleado4( )
    {
        return empleado4;
    }

    /**
     * Retorna el empleado dado su nombre.
     * @param pNombre Nombre del empleado a buscar. pNombre != null && pNombre != "".
     * @return Empleado buscado. Null en caso de no encontrarlo.
     */
    public Empleado buscarEmpleado( String pNombre )
    {
        //TODO Parte2 PuntoE: Complete el método con la documentación dada.
    	Empleado a = null;
    	if(pNombre.equals(empleado1.darNombre()))
    		a=empleado1;
    	else if(pNombre.equals(empleado2.darNombre()))
			a=empleado2;
    	else if(pNombre.equals(empleado3.darNombre()))
    		a=empleado3;
    	else if(pNombre.equals(empleado4.darNombre()))
    		a=empleado4;
    	return a;
    }

    /**
     * Calcula las prestaciones del empleado dado por parámetro.
     * @param pNombre Nombre del empleado. pNombre != null && pNombre != "".
     * @return Prestaciones del empleado. Si no existe un empleado con el nombre dado, retorna -1.
     */
    public double calcularPrestacionesEmpleado( String pNombre )
    {
        double prestaciones = -1;

        Empleado buscado = buscarEmpleado( pNombre );

        if( buscado != null )
        {
            prestaciones = buscado.calcularPrestaciones( );
        }

        return prestaciones;
    }

    /**
     * Calcula la edad promedio de los empleados.
     * @return Edad promedio de los empleados.
     */
    public double calcularEdadPromedio( )
    {
        //TODO Parte2 PuntoF: Complete el método constructor con la documentación dada.
    	double a =(empleado1.darEdad()+empleado2.darEdad()+empleado3.darEdad()+empleado4.darEdad());
    	double b =a/4;
    	return b;
    }

    /**
     * Retorna si los salarios de los empleados superan la cota mínima.
     * @return True si la suma de los salarios de los empleados es mayor o igual a la cota mínima, false de lo contrario.
     */
    public boolean salariosSuperanCotaMinima( )
    {
        //TODO Parte2 PuntoG: Complete el método constructor con la documentación dada.
    	return (empleado1.darSalario()+empleado2.darSalario()+empleado3.darSalario()+empleado4.darSalario()>=COTA_MINIMA);
    }

    /**
     * Cambia el salario de un empleado dado su nombre.
     * @param pNombre Nombre del empleado. pNombre != null && pNombre != "".
     * @param pSalario Nuevo Salario del empleado. pSalario >= 0.
     * @return True si encontró un empleado con el nombre dado y cambió el salario. False de la contrario.
     */
    public boolean cambiarSalarioEmpleado( String pNombre, int pSalario )
    {
        //TODO Parte2 PuntoH: Complete el método constructor con la documentación dada.
    	boolean a = false;
    	if(pNombre.equals(empleado1.darNombre()))
    	{
    		a=true;empleado1.cambiarSalario(pSalario);
    	}
    	else if(pNombre.equals(empleado2.darNombre()))
    	{
    		a=true;empleado2.cambiarSalario(pSalario);
    	}
    	else if(pNombre.equals(empleado3.darNombre()))
    	{
    		a=true;empleado3.cambiarSalario(pSalario);
    	}
    	else if(pNombre.equals(empleado4.darNombre()))
    	{
    		a=true;empleado4.cambiarSalario(pSalario);
    	}
    	return a;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método de extensión 1.
     * @return Resultado de la operación.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método de extensión 2.
     * @return Resultado de la operación.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}
