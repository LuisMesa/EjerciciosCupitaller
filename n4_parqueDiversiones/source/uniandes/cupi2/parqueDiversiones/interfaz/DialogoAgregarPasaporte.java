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

import uniandes.cupi2.parqueDiversiones.mundo.Pasaporte;

/**
 * Diálogo para agregar un nuevo pasaporte.
 */
public class DialogoAgregarPasaporte extends JDialog implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para aceptar al agregar un nuevo pasaporte.
     */
    private static final String ACEPTAR = "Aceptar";

    /**
     * Constante para cancelar al agregar un nuevo pasaporte.
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
     * Etiqueta de la cédula.
     */
    private JLabel lblCedula;

    /**
     * Etiqueta de la categoría.
     */
    private JLabel lblCategoria;

    /**
     * Campo de texto para el nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para la cédula.
     */
    private JTextField txtCedula;

    /**
     * Lista desplegable para las categorías.
     */
    private JComboBox cbCategorias;

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
     * Crea el diálogo para agregar un pasaporte.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoAgregarPasaporte( InterfazParqueDiversiones pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setTitle( "Agregar pasaporte" );
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
        lblCedula = new JLabel( "Cédula:" );
        lblCategoria = new JLabel( "Categoría:" );
        txtNombre = new JTextField( );
        txtCedula = new JTextField( );
        cbCategorias = new JComboBox( );
        cbCategorias.addItem( Pasaporte.BRONCE );
        cbCategorias.addItem( Pasaporte.PLATA );
        cbCategorias.addItem( Pasaporte.ORO );
        panelDatos.add( lblNombre );
        panelDatos.add( txtNombre );

        panelDatos.add( lblCedula );
        panelDatos.add( txtCedula );

        panelDatos.add( lblCategoria );
        panelDatos.add( cbCategorias );
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
            String cedulaStr = txtCedula.getText( );
            if( nombre.equals( "" ) || cedulaStr.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "El nombre y la cédula no pueden estar vacíos.", "Agregar pasaporte", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                try
                {
                    int cedula = Integer.parseInt( cedulaStr );
                    if( cedula <= 0 )
                    {
                        JOptionPane.showMessageDialog( this, "La cédula debe ser un número positivo.", "Agregar pasaporte", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        String categoria = ( String )cbCategorias.getSelectedItem( );
                        principal.agregarPasaporte( nombre, cedula, categoria );
                        dispose( );
                    }

                }
                catch( NumberFormatException e )
                {
                    JOptionPane.showMessageDialog( this, "La cédula debe ser un número.", "Agregar pasaporte", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }

}
