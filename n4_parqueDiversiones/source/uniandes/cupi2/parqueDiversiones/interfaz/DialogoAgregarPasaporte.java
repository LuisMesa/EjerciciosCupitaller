/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Di�logo para agregar un nuevo pasaporte.
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
     * Ventana principal de la aplicaci�n.
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
     * Etiqueta de la c�dula.
     */
    private JLabel lblCedula;

    /**
     * Etiqueta de la categor�a.
     */
    private JLabel lblCategoria;

    /**
     * Campo de texto para el nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para la c�dula.
     */
    private JTextField txtCedula;

    /**
     * Lista desplegable para las categor�as.
     */
    private JComboBox cbCategorias;

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
     * Crea el di�logo para agregar un pasaporte.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
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
        lblCedula = new JLabel( "C�dula:" );
        lblCategoria = new JLabel( "Categor�a:" );
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
            String cedulaStr = txtCedula.getText( );
            if( nombre.equals( "" ) || cedulaStr.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "El nombre y la c�dula no pueden estar vac�os.", "Agregar pasaporte", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                try
                {
                    int cedula = Integer.parseInt( cedulaStr );
                    if( cedula <= 0 )
                    {
                        JOptionPane.showMessageDialog( this, "La c�dula debe ser un n�mero positivo.", "Agregar pasaporte", JOptionPane.ERROR_MESSAGE );
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
                    JOptionPane.showMessageDialog( this, "La c�dula debe ser un n�mero.", "Agregar pasaporte", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }

}
