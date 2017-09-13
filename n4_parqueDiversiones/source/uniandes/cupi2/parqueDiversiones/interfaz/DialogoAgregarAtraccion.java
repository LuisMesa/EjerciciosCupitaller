/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_parqueDiversiones
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.parqueDiversiones.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.cupi2.parqueDiversiones.mundo.Atraccion;

/**
 * Diálogo para agregar una nueva atracción.
 */
public class DialogoAgregarAtraccion extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para aceptar al agregar una nueva atracción.
     */
    private static final String ACEPTAR = "Aceptar";

    /**
     * Constante para cancelar al agregar una nueva atracción.
     */
    private static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazParqueDiversiones principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta del nombre.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta del precio.
     */
    private JLabel lblPrecio;

    /**
     * Etiqueta del tipo.
     */
    private JLabel lblTipo;

    /**
     * Campo de texto del nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto del precio.
     */
    private JTextField txtPrecio;

    /**
     * Lista desplegable del tipo.
     */
    private JComboBox cbTipo;

    /**
     * Botón para aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón para cancelar.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea el diálogo para agregar una atracción.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoAgregarAtraccion( InterfazParqueDiversiones pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setTitle( "Agregar atracción" );
        JPanel panelNorte = new JPanel( );
        panelNorte.setPreferredSize( new Dimension( 10, 10 ) );
        add( panelNorte, BorderLayout.NORTH );
        JPanel panelSur = new JPanel( );
        panelSur.setPreferredSize( new Dimension( 10, 10 ) );
        add( panelSur, BorderLayout.SOUTH );
        JPanel panelEste = new JPanel( );
        panelEste.setPreferredSize( new Dimension( 20, 20 ) );
        add( panelEste, BorderLayout.EAST );
        JPanel panelOeste = new JPanel( );
        panelOeste.setPreferredSize( new Dimension( 20, 20 ) );
        add( panelOeste, BorderLayout.WEST );

        JPanel panelCentral = new JPanel( );
        panelCentral.setLayout( new BorderLayout( ) );
        panelCentral.setPreferredSize( new Dimension( 250, 120 ) );

        JPanel panelDatos = new JPanel( );
        panelDatos.setLayout( new GridLayout( 3, 2 ) );
        lblNombre = new JLabel( "Nombre:" );
        lblPrecio = new JLabel( "Precio:" );
        lblTipo = new JLabel( "Tipo:" );

        txtNombre = new JTextField( );
        txtPrecio = new JTextField( );
        cbTipo = new JComboBox( );
        cbTipo.addItem( Atraccion.ACUATICA );
        cbTipo.addItem( Atraccion.INFANTIL );
        cbTipo.addItem( Atraccion.TERROR );
        cbTipo.addItem( Atraccion.VELOCIDAD );
        panelDatos.add( lblNombre );
        panelDatos.add( txtNombre );

        panelDatos.add( lblPrecio );
        panelDatos.add( txtPrecio );

        panelDatos.add( lblTipo );
        panelDatos.add( cbTipo );
        panelCentral.add( panelDatos, BorderLayout.CENTER );
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

        panelCentral.add( panelBotones, BorderLayout.SOUTH );
        add( panelCentral, BorderLayout.CENTER );
        pack( );
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
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ACEPTAR ) )
        {
            String nombre = txtNombre.getText( );
            String precioStr = txtPrecio.getText( );
            if( nombre.equals( "" ) || precioStr.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Los campos nombre y precio no pueden estar vacíos.", "Agregar atracción", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                try
                {
                    double precio = Double.parseDouble( precioStr );
                    String tipo = ( String )cbTipo.getSelectedItem( );
                    principal.agregarAtraccion( nombre, precio, tipo );
                    dispose( );
                }
                catch( NumberFormatException e )
                {
                    JOptionPane.showMessageDialog( this, "El precio debe ser un número.", "Agregar atracción", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }

}
