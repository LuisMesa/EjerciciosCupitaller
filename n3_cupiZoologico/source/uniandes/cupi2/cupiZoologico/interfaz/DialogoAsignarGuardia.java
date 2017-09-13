/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_cupiZoologico
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.cupiZoologico.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


/**
 * Dialogo de para asignar un guardia a la jaula.
 */
public class DialogoAsignarGuardia extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para aceptar.
     */
    public static final String ACEPTAR = "Aceptar";

    /**
     * Constante que representa el comando para cancelar.
     */
    public static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCupiZoologico principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de ingreso de la información.
     */
    public JPanel panelIngreso;

    /**
     * Panel de ingreso de la imagen.
     */
    public JPanel panelImagen;

    /**
     * Campo de texto del nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto de los años de experiencia de los guardias.
     */
    private JTextField txtAnhosExperiencia;

    /**
     * Botón para aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón para cancelar.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoAsignarGuardia( InterfazCupiZoologico pPrincipal )
    {
        super( pPrincipal, "Ingrese datos del guardia" );
        principal = pPrincipal;

        panelIngreso = new JPanel( );
        panelIngreso.setBorder( new TitledBorder( "Ingreso datos del guardia" ) );
        panelIngreso.setLayout( new GridLayout( 3, 2 ) );

        panelIngreso.add( new JLabel( "Nombre:" ) );
        txtNombre = new JTextField( );
        panelIngreso.add( txtNombre );

        panelIngreso.add( new JLabel( "Años de experiencia:" ) );
        txtAnhosExperiencia = new JTextField( );
        panelIngreso.add( txtAnhosExperiencia );

        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        panelIngreso.add( btnAceptar );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelIngreso.add( btnCancelar );

        add( panelIngreso );

        pack( );
        setLocationRelativeTo( null );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( pEvento.getActionCommand( ).equals( ACEPTAR ) )
        {
            String nombre = txtNombre.getText( );
            String anhosExperiencia = txtAnhosExperiencia.getText( );
            try
            {
                if( !nombre.equals( "" ) && !anhosExperiencia.equals( "" ) )
                {
                    if( Integer.parseInt( anhosExperiencia ) >= 0 )
                    {
                        principal.asignarGuardia( nombre, Integer.parseInt( anhosExperiencia ) );
                        setVisible( false );
                        dispose( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "El año de experiencia debe ser mayor a cero.", "Asignar guardia", JOptionPane.ERROR_MESSAGE );

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Debe llenar todos los campos.", "Asignar guardia", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar valores numéricos para el año de experiencia.", "Asignar guardia", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( pEvento.getActionCommand( ).equals( CANCELAR ) )
        {
            setVisible( false );
            dispose( );
        }

    }

}