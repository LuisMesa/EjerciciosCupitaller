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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.empresa.mundo.Empleado;

/**
 * Panel donde se muestran los datos del empleado.
 */
public class PanelDatos extends JPanel implements ActionListener
{

    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando para cambiar el salario.
     */
    private final static String CAMBIAR_SALARIO = "CambiarSalario";
    
    /**
     * Comando para seleccionar un empleado.
     */
    private final static String COMBO_EMPLEADOS = "ComboEmpleados";
    
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazEmpresa principal;
    
    //-----------------------------------------------------------------
    // Atributos de la Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiqueta del nombre.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta de la edad.
     */
    private JLabel lblEdad;

    /**
     * Etiqueta de la antigüedad.
     */
    private JLabel lblAntiguedad;

    /**
     * Etiqueta del área dentro de la empresa.
     */
    private JLabel lblArea;

    /**
     * Etiqueta del salario.
     */
    private JLabel lblSalario;

    /**
     * Campo de texto para el nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para la edad.
     */
    private JTextField txtEdad;

    /**
     * Campo de texto para la antigüedad.
     */
    private JTextField txtAntiguedad;

    /**
     * Campo de texto para el área dentro de la empresa.
     */
    private JTextField txtArea;

    /**
     * Campo de texto para el salario.
     */
    private JTextField txtSalario;

    /**
     * Etiqueta donde se muestra la imagen.
     */
    private JLabel lblImagen;
    
    /**
     * Combo para seleccionar el empleado.
     */
    private JComboBox cbEmpleados;
    
    /**
     * Botón para cambiar el salario.
     */
    private JButton btnCambiarSalario;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye el panel con la información del empleado.<br>
     * <b>post: </b> Panel quedó inicializado. <br>
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelDatos( InterfazEmpresa pPrincipal )
    {
        principal = pPrincipal;
        
        setLayout( new BorderLayout( ) );
        setBorder(new TitledBorder( "Datos empleado" ) );
        
        JPanel panelAuxiliar = new JPanel();
        panelAuxiliar.setLayout( new GridLayout( 6, 2, 15, 10 ) );
        
        
        lblNombre = new JLabel( "Nombre: " );
        panelAuxiliar.add( lblNombre );
        
        txtNombre = new JTextField( );
        txtNombre.setEditable( false );
        panelAuxiliar.add( txtNombre );
        
        lblEdad = new JLabel( "Edad: " );
        panelAuxiliar.add( lblEdad );

        txtEdad = new JTextField( );
        txtEdad.setEditable( false );
        panelAuxiliar.add( txtEdad );
        
        lblAntiguedad = new JLabel( "Antigüedad: " );
        panelAuxiliar.add( lblAntiguedad );
        
        txtAntiguedad = new JTextField( );
        txtAntiguedad.setEditable( false );
        panelAuxiliar.add( txtAntiguedad );
        

        lblArea = new JLabel( "Área de trabajo: " );
        panelAuxiliar.add( lblArea );

        txtArea = new JTextField( );
        txtArea.setEditable( false );
        panelAuxiliar.add( txtArea );

        lblSalario = new JLabel( "Salario: " );
        panelAuxiliar.add( lblSalario );

        txtSalario = new JTextField(  );
        txtSalario.setEditable( false );
        panelAuxiliar.add( txtSalario );

        panelAuxiliar.add( new JLabel( ) );
        
        btnCambiarSalario = new JButton( "Cambiar salario" );
        btnCambiarSalario.setActionCommand( CAMBIAR_SALARIO );
        btnCambiarSalario.addActionListener( this );
        panelAuxiliar.add( btnCambiarSalario );
        
        add(panelAuxiliar, BorderLayout.CENTER);
        
        lblImagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "./data/pm.jpg");
        lblImagen.setIcon( icono );
        add( lblImagen,BorderLayout.EAST );
        
        cbEmpleados = new JComboBox( );
        cbEmpleados.setActionCommand( COMBO_EMPLEADOS );
        cbEmpleados.addActionListener( this );
        add(cbEmpleados, BorderLayout.NORTH);
        
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Actualiza la información del ComboBox.
     * @param pNombreEmpleado1 Nombre del empleado1. pNombreEmpleado1 != null && pNombreEmpleado1 != "". 
     * @param pNombreEmpleado2 Nombre del empleado2. pNombreEmpleado2 != null && pNombreEmpleado2 != "".
     * @param pNombreEmpleado3 Nombre del empleado3. pNombreEmpleado3 != null && pNombreEmpleado3 != "".
     * @param pNombreEmpleado4 Nombre del empleado4. pNombreEmpleado4 != null && pNombreEmpleado4 != "".
     */
    public void actualizarComboBox( String pNombreEmpleado1, String pNombreEmpleado2, String pNombreEmpleado3, String pNombreEmpleado4 )
    {
        cbEmpleados.removeAllItems( );
        cbEmpleados.addItem( pNombreEmpleado1 );
        cbEmpleados.addItem( pNombreEmpleado2 );
        cbEmpleados.addItem( pNombreEmpleado3 );
        cbEmpleados.addItem( pNombreEmpleado4 );
        cbEmpleados.setSelectedIndex( 0 );
    }
    
    /**
     * Actualiza los datos con la información del empleado dado por parámetro.
     * @param pEmpleado Empleado con la información. pEmpleado != null.
     */
    public void actualizarDatos( Empleado pEmpleado )
    {
        txtNombre.setText( pEmpleado.darNombre( ) );
        txtEdad.setText( pEmpleado.darEdad( )+"" );
        txtAntiguedad.setText( pEmpleado.darAntiguedad( )+"" );
        txtArea.setText( pEmpleado.darArea( ) );
        txtSalario.setText( pEmpleado.darSalario( )+"" );
        ImageIcon icono = new ImageIcon( "./data/"+pEmpleado.darImagen( ) );
        lblImagen.setIcon( icono );
        boolean encontro = false;
        for( int i = 0; i < 4 && !encontro; i++ )
        {
            String empleadoCombo = (String) cbEmpleados.getItemAt( i );
            if(pEmpleado.darNombre( ).equals( empleadoCombo ))
            {
                cbEmpleados.setSelectedIndex( i );
                encontro=true;
            }
        }
    }
    
    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Evento de click sobre un botón. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if(comando.equals( COMBO_EMPLEADOS ))
        {
            String seleccionado = (String) cbEmpleados.getSelectedItem( );
            principal.actualizar( seleccionado );
        }
        else if(comando.equals( CAMBIAR_SALARIO ))
        {
            String seleccionado = (String) cbEmpleados.getSelectedItem( );
            principal.cambiarSalario( seleccionado );
        }
    }
}
