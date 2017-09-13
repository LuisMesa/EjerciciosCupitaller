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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel que se muestra con el dialogo para venta de unidades por volumen.
 */
public class PanelVentaVolumen extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la acción de aceptar.
     */
    public static final String ACEPTAR = "ACEPTAR";

    /**
     * Constante para la acción de cancelar.
     */
    public static final String CANCELAR = "CANCELAR";

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta donde se muestra el nombre del Juego 1.
     */
    private JLabel lblJuego1;

    /**
     * Etiqueta donde se muestra el nombre del Juego 2.
     */
    private JLabel lblJuego2;

    /**
     * Etiqueta donde se muestra el nombre del Juego 3.
     */
    private JLabel lblJuego3;


    /**
     * Etiqueta donde se muestra el título.
     */
    private JLabel lblTitulo;

    /**
     * Cuadro de texto donde se coloca la cantidad de unidades a comprar del juego 1.
     */
    private JTextField txtJuego1;

    /**
     * Cuadro de texto donde se coloca la cantidad de unidades a comprar del juego 2.
     */
    private JTextField txtJuego2;

    /**
     * Cuadro de texto donde se coloca la cantidad de unidades a comprar del juego 3.
     */
    private JTextField txtJuego3;


    /**
     * Botón para aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón para cancelar.
     */
    private JButton btnCancelar;

    /**
     * Ventana principal del diálogo.
     */
    private DialogoVentaVolumen dialogo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye y coloca los elementos gráficos en el panel.
     * @param pDialogo Dialogo que contiene este panel. pDialogo != null.
     */
    public PanelVentaVolumen( DialogoVentaVolumen pDialogo )
    {
        dialogo = pDialogo;
        lblJuego1 = new JLabel( dialogo.obtenerNombreJuego1( ) );
        lblJuego2 = new JLabel( dialogo.obtenerNombreJuego2( ) );
        lblJuego3 = new JLabel( dialogo.obtenerNombreJuego3( ) );
        lblTitulo = new JLabel( "Escriba la cantidad de unidades a comprar de cada juego" );
        txtJuego1 = new JTextField( );
        txtJuego2 = new JTextField( );
        txtJuego3 = new JTextField( );
        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.addActionListener( this );
        btnAceptar.setActionCommand( ACEPTAR );
        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.addActionListener( this );
        btnCancelar.setActionCommand( CANCELAR );

        setLayout( new BorderLayout( ) );
        JPanel panelTitulo = new JPanel( );
        panelTitulo.setLayout( new BorderLayout( ) );
        panelTitulo.add( lblTitulo, BorderLayout.NORTH );
        panelTitulo.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "" ) ) );
        add( panelTitulo, BorderLayout.NORTH );

        JPanel panelDatos = new JPanel( );
        panelDatos.setLayout( new GridLayout( 4, 2, 5, 10 ) );
        panelDatos.add( lblJuego1 );
        panelDatos.add( txtJuego1 );
        panelDatos.add( lblJuego2 );
        panelDatos.add( txtJuego2 );
        panelDatos.add( lblJuego3 );
        panelDatos.add( txtJuego3 );
        panelDatos.add( btnAceptar );
        panelDatos.add( btnCancelar );
        panelDatos.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "" ) ) );

        add( panelDatos, BorderLayout.CENTER );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ACEPTAR ) )
        {
            try
            {
                String strCantidadJuego1 = txtJuego1.getText( );

                if( strCantidadJuego1.equals( "" ) )
                    strCantidadJuego1 = "0";

                int cantidadJuego1 = Integer.parseInt( strCantidadJuego1 );
                if( cantidadJuego1 < 0 )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    String strCantidadJuego2 = txtJuego2.getText( );

                    if( strCantidadJuego2.equals( "" ) )
                        strCantidadJuego2 = "0";

                    int cantidadJuego2 = Integer.parseInt( strCantidadJuego2 );
                    if( cantidadJuego2 < 0 )
                    {
                        JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad válida..", "Error", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        String strCantidadJuego3 = txtJuego3.getText( );

                        if( strCantidadJuego3.equals( "" ) )
                            strCantidadJuego3 = "0";

                        int cantidadJuego3 = Integer.parseInt( strCantidadJuego3 );
                        if( cantidadJuego3 < 0 )
                        {
                            JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE );
                        }
                        else
                        {
                            dialogo.aceptar( cantidadJuego1, cantidadJuego2, cantidadJuego3 );
                        }
                    }
                }
            }
            catch( NumberFormatException e1 )
            {
                JOptionPane.showMessageDialog( this, "Ha ocurrido un error con los datos ingresados,\ndebe ingresar datos válidos.", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dialogo.cancelar( );
        }
    }

}
