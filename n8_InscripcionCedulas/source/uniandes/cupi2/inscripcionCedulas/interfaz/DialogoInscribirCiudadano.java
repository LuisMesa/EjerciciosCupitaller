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
package uniandes.cupi2.inscripcionCedulas.interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.inscripcionCedulas.mundo.Ciudadano;

import com.toedter.calendar.JDateChooser;

/**
 * Dialogo para inscribir a un ciudadano.
 */
public class DialogoInscribirCiudadano extends JDialog implements ActionListener
{
    // -----------------------------------------------
    // Constantes
    // -----------------------------------------------

    /**
     * Constante que representa el botón inscribir.
     */
    private final static String INSCRIBIR = "Inscribir";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazInscripcionCedulas principal;

    // -----------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------

    /**
     * Campo de texto del número de cédula del ciudadano.
     */
    private JTextField txtCedula;

    /**
     * Campo de texto de los apellidos del ciudadano.
     */
    private JTextField txtApellidos;

    /**
     * Campo de texto con los nombres del ciudadano.
     */
    private JTextField txtNombres;

    /**
     * Calendario con la fecha de nacimiento del ciudadano.
     */
    private JDateChooser calendarioNacimiento;

    /**
     * Campo de texto con el lugar de nacimiento del ciudadano.
     */
    private JTextField txtLugarNacimiento;

    /**
     * ComboBox con el sexo del ciudadano.
     */
    private JComboBox comboSexo;

    /**
     * Calendario con la fecha de expedición de la cédula del ciudadano.
     */
    private JDateChooser calendarExpedicion;

    /**
     * Campo de texto con el lugar de expedición de la cédula del ciudadano.
     */
    private JTextField txtLugarExpedicion;

    /**
     * Botón para inscribir a un ciudadano.
     */
    private JButton btnInscribir;

    // -----------------------------------------------
    // Métodos
    // -----------------------------------------------

    /**
     * Crea el dialogo para inscribir a un ciudadano.
     * @param pPrincipal Ventana principal de la aplicación.
     */
    public DialogoInscribirCiudadano( InterfazInscripcionCedulas pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new GridBagLayout( ) );
        setSize( 380, 385 );
        setTitle( "Inscribir ciudadano" );
        setLocationRelativeTo( null );
        setModal( true );

        JPanel aux1 = new JPanel( );
        aux1.setBorder( new TitledBorder( " Información cédula: " ) );
        aux1.setLayout( new GridBagLayout( ) );

        GridBagConstraints gridBagConstraints = new GridBagConstraints( );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets( 5, 5, 5, 5 );
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel cedula = new JLabel( "Cédula: " );
        aux1.add( cedula, gridBagConstraints );

        gridBagConstraints.gridx = 1;
        txtCedula = new JTextField( );
        aux1.add( txtCedula, gridBagConstraints );

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        JLabel expedicion = new JLabel( "Fecha de expedición: " );
        aux1.add( expedicion, gridBagConstraints );

        gridBagConstraints.gridx = 1;
        calendarExpedicion = new JDateChooser( );
        aux1.add( calendarExpedicion, gridBagConstraints );

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        JLabel lugarExpedicion = new JLabel( "Lugar de expedición: " );
        aux1.add( lugarExpedicion, gridBagConstraints );

        gridBagConstraints.gridx = 1;
        txtLugarExpedicion = new JTextField( );
        aux1.add( txtLugarExpedicion, gridBagConstraints );

        JPanel aux2 = new JPanel( );
        aux2.setBorder( new TitledBorder( "Información personal: " ) );
        aux2.setLayout( new GridBagLayout( ) );

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        JLabel apellidos = new JLabel( "Apellidos: " );
        aux2.add( apellidos, gridBagConstraints );

        gridBagConstraints.gridx = 1;
        txtApellidos = new JTextField( );
        aux2.add( txtApellidos, gridBagConstraints );

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        JLabel nombres = new JLabel( "Nombres: " );
        aux2.add( nombres, gridBagConstraints );

        gridBagConstraints.gridx = 1;
        txtNombres = new JTextField( );
        aux2.add( txtNombres, gridBagConstraints );

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        JLabel nacimiento = new JLabel( "Fecha de nacimiento: " );
        aux2.add( nacimiento, gridBagConstraints );

        gridBagConstraints.gridx = 1;
        calendarioNacimiento = new JDateChooser( );
        calendarioNacimiento.setSize( 75, 75 );
        aux2.add( calendarioNacimiento, gridBagConstraints );

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        JLabel lugarNacimiento = new JLabel( "Lugar de nacimiento: " );
        aux2.add( lugarNacimiento, gridBagConstraints );

        gridBagConstraints.gridx = 1;
        txtLugarNacimiento = new JTextField( );
        aux2.add( txtLugarNacimiento, gridBagConstraints );

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        JLabel sexo = new JLabel( "Sexo: " );
        aux2.add( sexo, gridBagConstraints );

        gridBagConstraints.gridx = 1;
        comboSexo = new JComboBox( new String[]{ Ciudadano.FEMENINO, Ciudadano.MASCULINO } );
        aux2.add( comboSexo, gridBagConstraints );

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add( aux1, gridBagConstraints );

        gridBagConstraints.gridy = 1;
        add( aux2, gridBagConstraints );

        gridBagConstraints.gridy = 2;
        btnInscribir = new JButton( INSCRIBIR );
        btnInscribir.setActionCommand( INSCRIBIR );
        btnInscribir.addActionListener( this );
        add( btnInscribir, gridBagConstraints );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Valida que la fecha de expedición de la cédula del ciudadano sea correcta.<br>
     * La fecha de expedición es correcta si es al menos 18 años posterior a la fecha de nacimiento.
     * @param fechaExpedicion Fecha de expedición de la cédula. fechaExpedicion != null.
     * @param fechaNacimiento Fecha de nacimiento del ciudadano. fechaNacimiento != null.
     * @return True si la fecha de expedición es válida, false de lo contrario.
     */
    private boolean validarExpedicion( Date fechaExpedicion, Date fechaNacimiento )
    {
        int posterioridad = fechaExpedicion.getYear( ) - fechaNacimiento.getYear( );

        if( fechaExpedicion.getMonth( ) <= fechaNacimiento.getMonth( ) && fechaExpedicion.getDate( ) < fechaNacimiento.getDate( ) )
        {
            posterioridad -= 1;
        }

        return ( posterioridad >= 18 ) ? true : false;
    }

    /**
     * Valida que la fecha de nacimiento del ciudadano sea correcta. <br>
     * El ciudadano debe tener al menos 18 años.<br>
     * @param fechaNacimiento Fecha de nacimiento del ciudadano. fechaNacimiento != null.
     * @return True si la fecha de nacimiento es válida, false de los contrario.
     */
    private boolean validarEdad( Date fechaNacimiento )
    {
        Date actual = new Date( );
        int edad = actual.getYear( ) - fechaNacimiento.getYear( );

        if( actual.getMonth( ) <= fechaNacimiento.getMonth( ) && actual.getDate( ) < fechaNacimiento.getDate( ) )
        {
            edad -= 1;
        }

        return ( edad >= 18 ) ? true : false;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( INSCRIBIR ) )
        {
            String cedulaS = txtCedula.getText( );
            try
            {
                int cedula = Integer.parseInt( cedulaS );
                String apellidos = txtApellidos.getText( );
                String nombres = txtNombres.getText( );
                Date fechaNacimiento = calendarioNacimiento.getDate( );
                String lugarNacimiento = txtLugarNacimiento.getText( );
                String sexo = ( String )comboSexo.getSelectedItem( );
                Date fechaExpedicion = calendarExpedicion.getDate( );
                String lugarExpedicion = txtLugarExpedicion.getText( );

                if( cedula > 0 )
                {
                    if( apellidos != null && !apellidos.equals( "" ) && nombres != null && !nombres.equals( "" ) && lugarNacimiento != null && !lugarNacimiento.equals( "" ) && fechaExpedicion != null && fechaNacimiento != null
                            && lugarExpedicion != null && !lugarExpedicion.equals( "" ) )
                    {

                        boolean edadValida = validarEdad( fechaNacimiento );

                        if( !edadValida )
                        {
                            JOptionPane.showMessageDialog( this, "Fecha de nacimiento inválida. El ciudadano debe tener al menos 18 años.", "Inscribir Ciudadano", JOptionPane.ERROR_MESSAGE );
                        }
                        else
                        {
                            boolean expedicionValida = validarExpedicion( fechaExpedicion, fechaNacimiento );

                            if( !expedicionValida )
                            {
                                JOptionPane.showMessageDialog( this, "Fecha de expedición de la cédula inválida. Debe ser al menos 18 años posterior a la fecha de nacimiento.", "Inscribir Ciudadano", JOptionPane.ERROR_MESSAGE );
                            }
                            else
                            {
                                principal.inscribir( cedulaS, apellidos, nombres, fechaNacimiento, lugarNacimiento, sexo, fechaExpedicion, lugarExpedicion );
                                super.dispose( );
                            }
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "Debe ingresar todos los campos.", "Inscribir ciudadano", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La cédula debe ser un valor numérico mayor a cero.", "Inscribir ciudadano", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( NumberFormatException ex )
            {
                JOptionPane.showMessageDialog( this, "La cédula debe ser un valor numérico.", "Inscribir ciudadano", JOptionPane.ERROR_MESSAGE );
            }
        }
    }
}
