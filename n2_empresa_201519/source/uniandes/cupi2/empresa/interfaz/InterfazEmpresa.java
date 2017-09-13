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

package uniandes.cupi2.empresa.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.empresa.mundo.Empleado;
import uniandes.cupi2.empresa.mundo.Empresa;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazEmpresa extends JFrame
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Empresa empresa;

    //-----------------------------------------------------------------
    // Atributos de la interfaz
    //-----------------------------------------------------------------

    /**
     * Panel para mostrar los datos del empleado.
     */
    private PanelDatos panelDatos;

    /**
     * Panel para ejecutar las extensiones a la aplicación.
     */
    private PanelOpciones panelOpciones;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye una nueva interfaz inicializada con los datos de los 4 empleados de la empresa. <br>
     * <b>post: </b> La interfaz principal y sus paneles quedaron inicializados.
     */
    public InterfazEmpresa( )
    {
        empresa = new Empresa( );
        
        setTitle( "Empresa Cupi2" );
       

        // construir los paneles
        panelDatos = new PanelDatos( this );
        panelDatos.actualizarComboBox(empresa.darEmpleado1( ).darNombre( ),empresa.darEmpleado2( ).darNombre( ),empresa.darEmpleado3( ).darNombre( ),empresa.darEmpleado4( ).darNombre( ));
        panelDatos.actualizarDatos(empresa.darEmpleado1( ));
        panelOpciones = new PanelOpciones( this );

        // organizar el panel principal
        setLayout( new BorderLayout( ) );
        add( panelDatos, BorderLayout.CENTER );
        add( panelOpciones, BorderLayout.SOUTH );

        setSize( 530, 350 );
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Actualiza la información del panel de datos con el empleado que tiene el nombre dado por parámetro.
     * @param pSeleccionado Nombre del empleado seleccionado. pSeleccionado != null && pSeleccionado != "".
     */
    public void actualizar( String pSeleccionado )
    {
        Empleado buscado = empresa.buscarEmpleado( pSeleccionado );
        if(buscado!=null)
        {
            panelDatos.actualizarDatos( buscado );
        }
    }
    
    
    /**
	 * Modifica y actualiza el salario del empleado. <br>
	 * <b>post: </b> Se actualizó el salario del empleado y se presentó la información actualizada. <br>
     * @param pNombre Nombre del empleado al que se modificará el salario. pNombre != null && pNombre != "".
	 */
	public void cambiarSalario( String pNombre )
	{
	    String strSalario = JOptionPane.showInputDialog(this, "Ingrese el nuevo salario", "Cambiar salario", JOptionPane.QUESTION_MESSAGE);
	    
	    if( strSalario != null )
	    {
	        try
	        {
	            int nuevoSalario = Integer.parseInt( strSalario );
	            if(nuevoSalario>0)
	            {
	                empresa.cambiarSalarioEmpleado( pNombre, nuevoSalario );
	                panelDatos.actualizarDatos( empresa.buscarEmpleado( pNombre ) );
	            }
	            else
	            {
	                JOptionPane.showMessageDialog( this, "El salario ingresado debe ser un número mayor a 0.", "Cambiar salario", JOptionPane.ERROR_MESSAGE );
	            }
	        }
	        catch( NumberFormatException nfe )
	        {
	            JOptionPane.showMessageDialog( this, "El salario ingresado debe ser un número.", "Cambiar salario", JOptionPane.ERROR_MESSAGE );
	        }
	    }
	}

	/**
	 * Busca el empleado y en caso de encontrarlo lo muestra en la interfaz.
	 */
    public void buscarEmpleado( )
    {
        String strNombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del empleado", "Buscar empleado", JOptionPane.QUESTION_MESSAGE);
        if(strNombre!=null)
        {
            if(strNombre.equals( "" ))
            {
                JOptionPane.showMessageDialog( this, "El nombre ingresado no puede ser vacío.", "Buscar empleado", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                Empleado buscado = empresa.buscarEmpleado( strNombre );
                if(buscado==null)
                {
                    JOptionPane.showMessageDialog( this, "No existe un empleado con el nombre especificado.", "Buscar empleado", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    panelDatos.actualizarDatos( buscado );
                }
            }
        }
        
    }

    /**
     * Calcula la edad promedio de los empleados.
     */
    public void calcularPromedioEdad( )
    {
        double promedio = empresa.calcularEdadPromedio( );
        JOptionPane.showMessageDialog( this, "La edad promedio de los empleados es " + promedio + " años.", "Edad promedio", JOptionPane.INFORMATION_MESSAGE );        
    }

    /**
     * Calcula las prestaciones de un empleado dado su nombre.
     */
    public void calcularPrestacionesEmpleado( )
    {
        String strNombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del empleado", "Calcular prestaciones", JOptionPane.QUESTION_MESSAGE);
        if(strNombre!=null)
        {
            if(strNombre.equals( "" ))
            {
                JOptionPane.showMessageDialog( this, "El nombre ingresado no puede ser vacío.", "Calcular prestaciones", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                Empleado buscado = empresa.buscarEmpleado( strNombre );
                if(buscado==null)
                {
                    JOptionPane.showMessageDialog( this, "No existe un empleado con el nombre especificado.", "Calcular prestaciones", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    double prestaciones = buscado.calcularPrestaciones( );
                    JOptionPane.showMessageDialog( this, "Las prestaciones del empleado "+ strNombre + " son: "+ prestaciones, "Calcular prestaciones", JOptionPane.INFORMATION_MESSAGE );
                }
            }
        }
    }

    /**
     * Verifica que la suma de los salarios de los empleados supere una cota mínima.
     */
    public void verificarCotaMinima( )
    {
        boolean supera = empresa.salariosSuperanCotaMinima( );
        if(supera==true)
        {
            JOptionPane.showMessageDialog( this, "Los salarios de los empleados superan la cota mínima.", "Cota mínima", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Los salarios de los empleados no superan la cota mínima.", "Cota mínima", JOptionPane.INFORMATION_MESSAGE );
        }
    }
	
    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = empresa.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = empresa.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    //-----------------------------------------------------------------
    // Main
    //-----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz e inicializándola con un empleado.
     * @param pArgs Los argumentos no son utilizados.
     */
    public static void main( String[] pArgs )
    {
        InterfazEmpresa ventana = new InterfazEmpresa(  );
        ventana.setVisible( true );
    }
}