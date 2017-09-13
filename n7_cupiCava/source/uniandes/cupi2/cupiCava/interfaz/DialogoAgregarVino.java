/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import uniandes.cupi2.cupiCava.mundo.Vino;

/**
 * Di�logo que permite agregar un nuevo vino a la cava.
 */
public class DialogoAgregarVino extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando de agregar.
     */
    private final static String AGREGAR = "Agregar";

    /**
     * Constante que representa el comando para seleccionar una imagen.
     */
    private final static String SELECCIONAR = "Seleccionar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfazCupiCava principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto con el nombre del vino.
     */
    private JTextField txtNombre;

    /**
     * Combo box con las presentaciones del vino.
     */
    private JComboBox comboPresentacion;

    /**
     * Campo de texto con el a�o de elaboraci�n del vino.
     */
    private JTextField txtAnhoElaboracion;

    /**
     * Campo de texto con el contenido en az�car del vino.
     */
    private JTextField txtContenidoAzucar;

    /**
     * Campo de texto con el lugar de origen del vino.
     */
    private JTextField txtLugarOrigen;

    /**
     * Campo de texto con la imagen del vino.
     */
    private JTextField txtImagen;

    /**
     * Combo box con los tipos de vino.
     */
    private JComboBox comboTipo;

    /**
     * Combo box con los colores del vino.
     */
    private JComboBox comboColor;

    /**
     * Bot�n para agregar.
     */
    private JButton btnAgregar;

    /**
     * Bot�n para seleccionar.
     */
    private JButton btnSeleccionar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del di�logo.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public DialogoAgregarVino( InterfazCupiCava pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );
        setSize( 450, 280 );
        setModal( true );
        setLocationRelativeTo( null );
        setTitle( "Agregar vino" );

        JPanel panelInfo1 = new JPanel( );
        panelInfo1.setLayout( new GridLayout( 8, 2 ) );
        panelInfo1.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        panelInfo1.add( new JLabel( "Nombre:" ) );
        txtNombre = new JTextField( );
        panelInfo1.add( txtNombre );

        panelInfo1.add( new JLabel( "Presentaci�n:" ) );
        comboPresentacion = new JComboBox( );
        comboPresentacion.addItem( Vino.BARRIL );
        comboPresentacion.addItem( Vino.BOTELLA );
        panelInfo1.add( comboPresentacion );

        panelInfo1.add( new JLabel( "A�o de elaboraci�n:" ) );
        txtAnhoElaboracion = new JTextField( );
        panelInfo1.add( txtAnhoElaboracion );

        panelInfo1.add( new JLabel( "Contenido en az�car (g/l):" ) );
        txtContenidoAzucar = new JTextField( );
        panelInfo1.add( txtContenidoAzucar );

        panelInfo1.add( new JLabel( "Tipo:" ) );
        comboTipo = new JComboBox( );
        comboTipo.addItem( Vino.SECO );
        comboTipo.addItem( Vino.ABOCADO );
        comboTipo.addItem( Vino.SEMI_SECO );
        comboTipo.addItem( Vino.SEMI_DULCE );
        comboTipo.addItem( Vino.DULCE );
        panelInfo1.add( comboTipo );

        panelInfo1.add( new JLabel( "Lugar de origen:" ) );
        txtLugarOrigen = new JTextField( );
        panelInfo1.add( txtLugarOrigen );

        panelInfo1.add( new JLabel( "Color:" ) );
        comboColor = new JComboBox( );
        comboColor.addItem( Vino.BLANCO );
        comboColor.addItem( Vino.TINTO );
        comboColor.addItem( Vino.ROSADO );
        panelInfo1.add( comboColor );

        add( panelInfo1, BorderLayout.CENTER );

        panelInfo1.add( new JLabel( "Imagen:" ) );

        JPanel panelAuxiliar = new JPanel( );
        panelAuxiliar.setLayout( new GridLayout( 1, 2 ) );
        txtImagen = new JTextField( );
        txtImagen.setEditable( false );
        btnSeleccionar = new JButton( "Seleccionar" );
        btnSeleccionar.addActionListener( this );
        btnSeleccionar.setActionCommand( SELECCIONAR );
        panelAuxiliar.add( txtImagen );
        panelAuxiliar.add( btnSeleccionar );

        panelInfo1.add( panelAuxiliar );

        btnAgregar = new JButton( AGREGAR );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );

        add( btnAgregar, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( SELECCIONAR ) )
        {
            JFileChooser jf = new JFileChooser( "./data/imagenes" );
            jf.setDialogTitle( "Seleccionar archivo" );
            jf.setFileSelectionMode( JFileChooser.FILES_ONLY );
            jf.setVisible( true );

            if( jf.showOpenDialog( this ) == JFileChooser.APPROVE_OPTION )
            {
                String nombre = jf.getSelectedFile( ).getName( );
                if( nombre.endsWith( ".jpg" ) )
                {
                    txtImagen.setText( nombre );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Debe seleccionar un archivo en formato .jpg.", "Seleccionar imagen", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        else if( comando.equals( AGREGAR ) )
        {
            String nombre = txtNombre.getText( );
            String anhoS = txtAnhoElaboracion.getText( );
            String azucarS = txtContenidoAzucar.getText( );
            String lugar = txtLugarOrigen.getText( );
            String imagen = txtImagen.getText( );

            String tipo = ( String )comboTipo.getSelectedItem( );
            String presentacion = ( String )comboPresentacion.getSelectedItem( );
            String color = ( String )comboColor.getSelectedItem( );

            if( nombre != null && !nombre.isEmpty( ) && anhoS != null && !anhoS.isEmpty( ) && azucarS != null && !azucarS.isEmpty( ) && lugar != null && !lugar.isEmpty( ) && imagen != null && !imagen.isEmpty( ) )
            {
                try
                {
                    int anho = Integer.parseInt( anhoS );
                    double azucar = Double.parseDouble( azucarS );
                    String imagen2 = "./data/imagenes/" + imagen;

                    if( anho > 0 )
                    {
                        if( azucar >= 0 )
                        {
                            if( tipo.equals( Vino.SECO ) && azucar > 5 )
                            {
                                JOptionPane.showMessageDialog( this, "El contenido en az�car debe estar entre 0 y 5 si el tipo es seco.", "Agregar vino", JOptionPane.ERROR_MESSAGE );
                            }
                            else if( tipo.equals( Vino.ABOCADO ) && ( azucar < 5 || azucar > 15 ) )
                            {
                                JOptionPane.showMessageDialog( this, "El contenido en az�car debe estar entre 5 y 15 si el tipo es abocado.", "Agregar vino", JOptionPane.ERROR_MESSAGE );
                            }
                            else if( tipo.equals( Vino.SEMI_SECO ) && ( azucar < 15 || azucar > 30 ) )
                            {
                                JOptionPane.showMessageDialog( this, "El contenido en az�car debe estar entre 15 y 30 si el tipo es semi seco.", "Agregar vino", JOptionPane.ERROR_MESSAGE );
                            }
                            else if( tipo.equals( Vino.SEMI_DULCE ) && ( azucar < 30 || azucar > 50 ) )
                            {
                                JOptionPane.showMessageDialog( this, "El contenido en az�car debe estar entre 30 y 50 si el tipo es semi dulce.", "Agregar vino", JOptionPane.ERROR_MESSAGE );
                            }
                            else if( tipo.equals( Vino.DULCE ) && azucar < 50 )
                            {
                                JOptionPane.showMessageDialog( this, "El contenido en az�car debe ser mayor a 50 si el tipo es dulce.", "Agregar vino", JOptionPane.ERROR_MESSAGE );
                            }
                            else
                            {
                                principal.agregarVino( nombre, presentacion, anho, azucar, tipo, color, lugar, imagen2 );
                                this.dispose( );
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog( this, "El contenido en az�car debe ser mayor o igual a cero.", "Agregar vino", JOptionPane.ERROR_MESSAGE );
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "El a�o de elaboraci�n debe ser mayor a cero.", "Agregar vino", JOptionPane.ERROR_MESSAGE );
                    }
                }
                catch( NumberFormatException ex )
                {
                    JOptionPane.showMessageDialog( this, "El a�o de elaboraci�n y el contenido en az�car del vino deben ser valores num�ricos.", "Agregar vino", JOptionPane.ERROR_MESSAGE );
                }
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Por favor ingrese la informaci�n completa del vino.", "Agregar vino", JOptionPane.ERROR_MESSAGE );
            }
        }
    }
}