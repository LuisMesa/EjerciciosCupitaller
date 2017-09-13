/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n4_tiendaLibros
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.tiendaLibros.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Di�logo para agregar un nuevo carro de compras.
 */
public class DialogoAgregarCarroCompras extends JDialog implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para aceptar al agregar un nuevo carro de compras.
     */
    private static final String ACEPTAR = "Aceptar";

    /**
     * Constante para cancelar al agregar un nuevo carro de compras.
     */
    private static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazTiendaLibros principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta del nombre.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta de la c�dula.
     */
    private JLabel lblCedula;

    /**
     * Campo de texto para el nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para la c�dula.
     */
    private JTextField txtCedula;

    /**
     * Bot�n para aceptar.
     */
    private JButton btnAceptar;

    /**
     * Bot�n para cancelar.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea el di�logo para agregar un carro de compras.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public DialogoAgregarCarroCompras( InterfazTiendaLibros pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setTitle( "Agregar carro de compras" );

        setLayout( new BorderLayout( ) );
        setPreferredSize( new Dimension( 250, 120 ) );

        JPanel panelDatos = new JPanel( );
        panelDatos.setLayout( new GridLayout( 2, 2 ) );
        lblNombre = new JLabel( "Nombre:" );
        lblCedula = new JLabel( "C�dula:" );
        txtNombre = new JTextField( );
        txtCedula = new JTextField( );

        panelDatos.add( lblNombre );
        panelDatos.add( txtNombre );
        panelDatos.add( lblCedula );
        panelDatos.add( txtCedula );

        add( panelDatos, BorderLayout.CENTER );

        JPanel panelBotones = new JPanel( );
        panelBotones.setLayout( new GridLayout( 1, 2 ) );
        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelBotones.add( btnAceptar );
        panelBotones.add( btnCancelar );

        add( panelBotones, BorderLayout.SOUTH );
        pack( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ACEPTAR ) )
        {
            String nombre = txtNombre.getText( );
            String cedula = txtCedula.getText( );
            if( nombre.equals( "" ) || cedula.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "El nombre y la c�dula no pueden estar vac�os.", "Agregar carro de compras", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                if( cedula.matches( "[0123456789]*" ) )
                {
                    principal.agregarCarroCompras( nombre, cedula );
                    dispose( );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La c�dula debe ser un n�mero positivo.", "Agregar  carro de compras", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }

}
