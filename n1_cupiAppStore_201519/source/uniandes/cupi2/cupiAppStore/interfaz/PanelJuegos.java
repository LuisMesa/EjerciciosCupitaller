/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_cupiAppStore
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupiAppStore.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiAppStore.mundo.Juego;

/**
 * Panel que muestra la información de los juegos.
 */
public class PanelJuegos extends JPanel implements ActionListener
{
    // ----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para el combo box con los juegos.
     */
    private static final String CAMBIAR_JUEGO = "CambiarJuego";

    /**
     * Constante para el botón de comprar.
     */
    private static final String BOTON_COMPRAR = "Comprar";

    /**
     * Constante para el botón de vender.
     */
    private static final String BOTON_VENDER = "Vender";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazCupiAppStore principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * ComboBox con la lista de Juegos.
     */
    private JComboBox comboJuegos;

    /**
     * Etiqueta "Nombre".
     */
    private JLabel lblNombreJuego;

    /**
     * Campo con el nombre del Juego.
     */
    private JTextField txtNombreJuego;

    /**
     * Etiqueta "Categoría".
     */
    private JLabel lblCategoriaJuego;

    /**
     * Campo con la categoria del Juego.
     */
    private JTextField txtCategoriaJuego;

    /**
     * Etiqueta "Precio".
     */
    private JLabel lblPrecioJuego;

    /**
     * Campo con el precio del juego.
     */
    private JTextField txtPrecioJuego;

    /**
     * Etiqueta "Tamaño KB".
     */
    private JLabel lblTamanioJuego;

    /**
     * Campo con el tamaño en KB del juego.
     */
    private JTextField txtTamanioJuego;

    /**
     * Etiqueta "Disponibles".
     */
    private JLabel lblDisponiblesJuego;

    /**
     * Campo con la cantidad de unidades disponibles del juego.
     */
    private JTextField txtDisponiblesJuego;

    /**
     * Campo que muestra la imagen del Juego.
     */
    private JLabel lblImagen;

    /**
     * Botón para Vender un juego.
     */
    private JButton btnVender;

    /**
     * Botón para Comprar un juego
     */
    private JButton btnComprar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel para la información de un juego.
     * @param pPrincipal Referencia a la clase principal de la interfaz.
     * @param pJuegos Lista con los nombres de los discos que se tienen en la empresa de juegos.
     */
    public PanelJuegos( InterfazCupiAppStore pPrincipal, ArrayList pJuegos )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );

        comboJuegos = new JComboBox( pJuegos.toArray( ) );
        comboJuegos.setEditable( false );
        comboJuegos.addActionListener( this );
        comboJuegos.setActionCommand( CAMBIAR_JUEGO );
        add( comboJuegos, BorderLayout.NORTH );

        JPanel panelDatosJuego = new JPanel( );
        add( panelDatosJuego, BorderLayout.CENTER );

        panelDatosJuego.setLayout( new GridLayout( 6, 1, 0, 5 ) );

        lblNombreJuego = new JLabel( "Nombre: " );
        txtNombreJuego = new JTextField( 15 );
        txtNombreJuego.setEditable( false );
        txtNombreJuego.setFont( txtNombreJuego.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosJuego.add( lblNombreJuego );
        panelDatosJuego.add( txtNombreJuego );

        lblCategoriaJuego = new JLabel( "Categoría: " );
        txtCategoriaJuego = new JTextField( 15 );
        txtCategoriaJuego.setEditable( false );
        txtCategoriaJuego.setFont( txtCategoriaJuego.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosJuego.add( lblCategoriaJuego );
        panelDatosJuego.add( txtCategoriaJuego );

        lblTamanioJuego = new JLabel( "Tamaño en KB: " );
        txtTamanioJuego = new JTextField( 15 );
        txtTamanioJuego.setEditable( false );
        txtTamanioJuego.setFont( txtTamanioJuego.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosJuego.add( lblTamanioJuego );
        panelDatosJuego.add( txtTamanioJuego );

        lblPrecioJuego = new JLabel( "Precio: " );
        txtPrecioJuego = new JTextField( 15 );
        txtPrecioJuego.setEditable( false );
        txtPrecioJuego.setFont( txtPrecioJuego.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosJuego.add( lblPrecioJuego );
        panelDatosJuego.add( txtPrecioJuego );

        lblDisponiblesJuego = new JLabel( "Disponibles: " );
        txtDisponiblesJuego = new JTextField( 15 );
        txtDisponiblesJuego.setEditable( false );
        txtDisponiblesJuego.setFont( txtDisponiblesJuego.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosJuego.add( lblDisponiblesJuego );
        panelDatosJuego.add( txtDisponiblesJuego );

        // Botón comprar
        btnComprar = new JButton( "Comprar" );
        btnComprar.setActionCommand( BOTON_COMPRAR );
        btnComprar.addActionListener( this );
        panelDatosJuego.add( btnComprar );

        // Botón Vender
        btnVender = new JButton( "Vender" );
        btnVender.setActionCommand( BOTON_VENDER );
        btnVender.addActionListener( this );
        panelDatosJuego.add( btnVender );

        panelDatosJuego.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        lblImagen = new JLabel( );
        add( lblImagen, BorderLayout.EAST );

        setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Juegos" ) ) );
        setSize( 200, 530 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Cambia el juego que se muestra en el panel.
     * @param pNombreJuego a
     * @param pCategoriaJuego a
     * @param pTamanioJuego a
     * @param pCantidadActualJuego a
     * @param pPrecioJuego a
     */
    public void cambiarJuego( String pNombreJuego, String pCategoriaJuego, int pTamanioJuego, int pCantidadActualJuego, int pPrecioJuego )
    {

        NumberFormat formatter = new DecimalFormat( "#,###,###" );

        lblImagen.setIcon( new ImageIcon( cargarImagenColor( "data/imagenes/" + pNombreJuego.replace( " ", "" ) + ".jpg" ) ) );
        txtNombreJuego.setText( pNombreJuego );
        txtCategoriaJuego.setText( pCategoriaJuego );
        txtTamanioJuego.setText( formatter.format( pTamanioJuego ) );
        txtDisponiblesJuego.setText( formatter.format( pCantidadActualJuego ) );
        txtPrecioJuego.setText( formatter.format( pPrecioJuego ) );
        btnVender.setEnabled( true );

    }

    /**
     * Carga una imagen del archivo especificado.
     * @param pNombreArchivo Archivo de donde se cargará la imagen.
     * @return Objeto en java que representa la imagen en colores.
     */
    private BufferedImage cargarImagenColor( String pNombreArchivo )
    {

        File archivo = new File( pNombreArchivo );
        BufferedImage bmp;

        try
        {
            bmp = ImageIO.read( archivo );
        }
        catch( IOException e )
        {
            bmp = new BufferedImage( 1, 1, BufferedImage.TYPE_BYTE_BINARY );
        }

        return bmp;

    }

    /**
     * Carga una imagen en escala de grises desde el archivo especificado.
     * @param pNombreArchivo Archivo de donde se cargará la imagen.
     * @return Objeto en java que representa la imagen en escala de grises.
     */
    private BufferedImage cargarImagenGris( String pNombreArchivo )
    {

        File archivo = new File( pNombreArchivo );
        BufferedImage bmp;

        Color bitmap[][];
        int ancho;
        int alto;

        try
        {
            bmp = ImageIO.read( archivo );
        }
        catch( IOException e )
        {
            bmp = new BufferedImage( 1, 1, BufferedImage.TYPE_BYTE_BINARY );
        }

        ancho = bmp.getWidth( );
        alto = bmp.getHeight( );
        bitmap = new Color[alto][ancho];

        for( int i = 0; i < alto; i++ )
            for( int j = 0; j < ancho; j++ )
            {
                bitmap[ i ][ j ] = new Color( bmp.getRGB( j, i ) );
            }

        // convierte a grises
        for( int i = 0; i < alto; i++ )
            for( int j = 0; j < ancho; j++ )
            {
                int rgbGris = ( bitmap[ i ][ j ].getBlue( ) + bitmap[ i ][ j ].getGreen( ) + bitmap[ i ][ j ].getRed( ) ) / 3;
                bitmap[ i ][ j ] = new Color( rgbGris, rgbGris, rgbGris );

            }

        // convierte el bitmap a una imagen
        for( int i = 0; i < alto; i++ )
            for( int j = 0; j < ancho; j++ )
            {
                bmp.setRGB( j, i, bitmap[ i ][ j ].getRGB( ) );
            }
        return bmp;

    }

    /**
     * Se ejecuta una opción dependiendo de las acciones realizadas por el usuario.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( CAMBIAR_JUEGO ) )
        {
            String nombreJuego = ( String )comboJuegos.getSelectedItem( );
            principal.cambiarJuegoSeleccionado( nombreJuego );
        }
        if( comando.equals( BOTON_VENDER ) )
        {
            String strCantidad = JOptionPane.showInputDialog( this, "Ingrese la cantidad que desea vender.", "Venta de juegos", JOptionPane.INFORMATION_MESSAGE );
            if( strCantidad != null )
            {
                if( !strCantidad.trim( ).equals( "" ) )
                {
                    try
                    {
                        int cantidad = Integer.parseInt( strCantidad );
                        if( cantidad < 0 )
                        {
                            JOptionPane.showMessageDialog( this, "La cantidad que desea vender es inválida.", "Venta de juegos", JOptionPane.ERROR_MESSAGE );
                        }
                        else if( cantidad > principal.darCantidadJuego( ( String )comboJuegos.getSelectedItem( ) ) )
                        {
                            JOptionPane.showMessageDialog( this, "No hay suficientes unidades en la tienda para realizar la venta.", "Venta de juegos", JOptionPane.ERROR_MESSAGE );
                        }
                        else
                        {
                            principal.venderUnidadesJuego( ( String )comboJuegos.getSelectedItem( ), cantidad );
                        }
                    }
                    catch( NumberFormatException e1 )
                    {
                        JOptionPane.showMessageDialog( this, "Datos inválidos.", "Venta de juegos", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Debe especificar un valor para la cantidad.", "Venta de juegos", JOptionPane.ERROR_MESSAGE );
                }
            }

        }
        else if( comando.equals( BOTON_COMPRAR ) )
        {
            String strCantidad = JOptionPane.showInputDialog( this, "Ingrese la cantidad que desea comprar.", "Compra de Juegos", JOptionPane.INFORMATION_MESSAGE );
            if( strCantidad != null )
            {
                if( !strCantidad.trim( ).equals( "" ) )
                {
                    try
                    {
                        int cantidad = Integer.parseInt( strCantidad );
                        if( cantidad < 0 )
                        {
                            JOptionPane.showMessageDialog( this, "La cantidad que desea comprar es inválida.", "Compra de Juegos", JOptionPane.ERROR_MESSAGE );
                        }
                        else
                        {
                            principal.comprarUnidadesJuego( ( String )comboJuegos.getSelectedItem( ), cantidad );
                        }
                    }
                    catch( NumberFormatException e1 )
                    {
                        JOptionPane.showMessageDialog( this, "Datos inválidos.", "Compra de Juegos", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Debe especificar un valor para la cantidad.", "Compra de Juegos", JOptionPane.ERROR_MESSAGE );
                }
            }

        }
    }

}
