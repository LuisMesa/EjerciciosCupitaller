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

package uniandes.cupi2.empresa.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.empresa.mundo.Empleado;
import uniandes.cupi2.empresa.mundo.Empresa;

/**
 * Ventana principal de la aplicaci�n.
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
     * Panel para ejecutar las extensiones a la aplicaci�n.
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
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Actualiza la informaci�n del panel de datos con el empleado que tiene el nombre dado por par�metro.
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
	 * <b>post: </b> Se actualiz� el salario del empleado y se present� la informaci�n actualizada. <br>
     * @param pNombre Nombre del empleado al que se modificar� el salario. pNombre != null && pNombre != "".
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
	                JOptionPane.showMessageDialog( this, "El salario ingresado debe ser un n�mero mayor a 0.", "Cambiar salario", JOptionPane.ERROR_MESSAGE );
	            }
	        }
	        catch( NumberFormatException nfe )
	        {
	            JOptionPane.showMessageDialog( this, "El salario ingresado debe ser un n�mero.", "Cambiar salario", JOptionPane.ERROR_MESSAGE );
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
                JOptionPane.showMessageDialog( this, "El nombre ingresado no puede ser vac�o.", "Buscar empleado", JOptionPane.ERROR_MESSAGE );
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
        JOptionPane.showMessageDialog( this, "La edad promedio de los empleados es " + promedio + " a�os.", "Edad promedio", JOptionPane.INFORMATION_MESSAGE );        
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
                JOptionPane.showMessageDialog( this, "El nombre ingresado no puede ser vac�o.", "Calcular prestaciones", JOptionPane.ERROR_MESSAGE );
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
     * Verifica que la suma de los salarios de los empleados supere una cota m�nima.
     */
    public void verificarCotaMinima( )
    {
        boolean supera = empresa.salariosSuperanCotaMinima( );
        if(supera==true)
        {
            JOptionPane.showMessageDialog( this, "Los salarios de los empleados superan la cota m�nima.", "Cota m�nima", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Los salarios de los empleados no superan la cota m�nima.", "Cota m�nima", JOptionPane.INFORMATION_MESSAGE );
        }
    }
	
    //-----------------------------------------------------------------
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = empresa.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2.
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
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz e inicializ�ndola con un empleado.
     * @param pArgs Los argumentos no son utilizados.
     */
    public static void main( String[] pArgs )
    {
        InterfazEmpresa ventana = new InterfazEmpresa(  );
        ventana.setVisible( true );
    }
}