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
 * Di�logo para agregar un nuevo libro.
 */
public class DialogoAgregarLibro extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para aceptar al agregar una nuevo libro.
     */
    private static final String ACEPTAR = "Aceptar";

    /**
     * Constante para cancelar al agregar un nuevo libro.
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
     * Etiqueta del t�tulo.
     */
    private JLabel lblTitulo;

    /**
     * Etiqueta del ISBN.
     */
    private JLabel lblISBN;

    /**
     * Etiqueta del precio.
     */
    private JLabel lblPrecio;

    /**
     * Campo de texto del t�tulo.
     */
    private JTextField txtTitulo;

    /**
     * Campo de texto del ISBN.
     */
    private JTextField txtISBN;

    /**
     * Campo de texto del precio.
     */
    private JTextField txtPrecio;

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
     * Crea el di�logo para agregar un libro.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public DialogoAgregarLibro( InterfazTiendaLibros pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setTitle( "Agregar libro" );
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
        lblTitulo = new JLabel( "T�tulo:" );
        lblPrecio = new JLabel( "Precio:" );
        lblISBN = new JLabel( "ISBN:" );

        txtTitulo = new JTextField( );
        txtPrecio = new JTextField( );
        txtISBN = new JTextField( );

        panelDatos.add( lblTitulo );
        panelDatos.add( txtTitulo );
        panelDatos.add( lblISBN );
        panelDatos.add( txtISBN );
        panelDatos.add( lblPrecio );
        panelDatos.add( txtPrecio );

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
            String titulo = txtTitulo.getText( );
            String isbn = txtISBN.getText( );
            String precioStr = txtPrecio.getText( );

            if( titulo.equals( "" ) || precioStr.equals( "" ) || isbn.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Los campos t�tulo, IBSN y precio no pueden estar vac�os.", "Agregar libro", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                try
                {
                    int precio = Integer.parseInt( precioStr );
                    principal.agregarLibro( titulo, isbn, precio );
                    dispose( );
                }
                catch( NumberFormatException e )
                {
                    JOptionPane.showMessageDialog( this, "El precio debe ser un n�mero.", "Agregar libro", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }

}
