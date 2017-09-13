/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: sistemaAntecedentes
 * Autor: Equipo Cupi2 2015.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sistemaAntecedentes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import uniandes.cupi2.sistemaAntecedentes.mundo.Antecedente;

/**
 * Diálogo de creación de un antecedente.
 */
public class DialogoAgregarAntecedente extends JDialog implements ActionListener
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa el comando para aceptar.
     */
    private final static String ACEPTAR = "Aceptar";

    /**
     * Constante que representa el comando para cancelar.
     */
    private final static String CANCELAR = "Cancelar";

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazSistemaAntecedentes principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta para indicar el identificador del antecedente.
     */
    private JLabel lblIdentificador;
    
    /**
     * Etiqueta para inidicar el tipo de antecedente.
     */
    private JLabel lblTipo;

    /**
     * Etiqueta para indicar la descripción del antecedente.
     */
    private JLabel lblDescripcion;
    
    /**
     * Campo de texto para introducir la descripción del antecedente.
     */
    private JTextField txtIdentificador;

    /**
     * Combobox con los tipos de antecedentes.
     */
    private JComboBox cbbAntecedentes;

    /**
     * Área de texto para la descripción del antecedente.
     */
    private JTextArea areaDescripcion;

    /**
     * Scrollpane vertical.
     */
    private JScrollPane scroll;

    /**
     * Botón de aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón de cancelar.
     */
    private JButton btnCancelar;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Constructor del diálogo para agregar un antecedente a un procesado. <br>
     * <b>post: </b> Construyó el panel e inicializó el atributo principal con el valor dado por parámetro. <br>
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoAgregarAntecedente( InterfazSistemaAntecedentes pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Agregar nuevo antecedente" );
        setModal( true );
        setSize( 400, 180 );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLayout( new BorderLayout( ) );
        setLocationRelativeTo( principal );

        JPanel aux1 = new JPanel( );
        aux1.setLayout( new BorderLayout( ) );
        aux1.setPreferredSize( new Dimension( 0, 200 ) );

        JPanel aux2 = new JPanel( );
        aux2.setLayout( new GridLayout( 3, 2 ) );
        aux2.setPreferredSize( new Dimension( 0, 80 ) );

        lblIdentificador = new JLabel( "Identificador: " );
        aux2.add( lblIdentificador );
        
        txtIdentificador = new JTextField( );
        aux2.add( txtIdentificador );
        
        lblTipo = new JLabel( "Antecedente: " );
        aux2.add( lblTipo );

        cbbAntecedentes = new JComboBox( );
        cbbAntecedentes.addItem( Antecedente.HOMICIDIO );
        cbbAntecedentes.addItem( Antecedente.VIOLENCIA );
        cbbAntecedentes.addItem( Antecedente.ROBO );
        cbbAntecedentes.addItem( Antecedente.ECOLOGICO );
        cbbAntecedentes.addItem( Antecedente.TRANSITO );
        cbbAntecedentes.addItem( Antecedente.SECUESTRO );
        cbbAntecedentes.addItem( Antecedente.ALLANAMIENTO_DE_MORADA );
        cbbAntecedentes.addItem( Antecedente.ESTAFA );
        cbbAntecedentes.addItem( Antecedente.CONSUMO_DE_DROGAS );
        cbbAntecedentes.addItem( Antecedente.TRAFICO_DE_DROGAS );
        aux2.add( cbbAntecedentes, BorderLayout.WEST );

        lblDescripcion = new JLabel( "   Descripción" );
        aux2.add( lblDescripcion, BorderLayout.CENTER );

        aux1.add( aux2, BorderLayout.CENTER );

        areaDescripcion = new JTextArea( );
        areaDescripcion.setLineWrap( true );
        areaDescripcion.setWrapStyleWord( true );
        areaDescripcion.setPreferredSize( new Dimension( 0, 70 ) );

        scroll = new JScrollPane( areaDescripcion );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
        aux1.add( scroll, BorderLayout.SOUTH );
        add( aux1, BorderLayout.CENTER );

        JPanel aux3 = new JPanel( );
        aux3.setLayout( new GridLayout( 1, 2 ) );

        btnAceptar = new JButton( ACEPTAR );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        aux3.add( btnAceptar );

        btnCancelar = new JButton( CANCELAR );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        aux3.add( btnCancelar );

        add( aux3, BorderLayout.SOUTH );
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones. <br>
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( ACEPTAR ) )
        {
            int identificador = -1;
            try
            {
                identificador = Integer.parseInt( txtIdentificador.getText( ) );
                
            }
            catch( NumberFormatException pNumberFormatE )
            {
                JOptionPane.showMessageDialog( this, "El identificador del antecedente debe ser un valor numérico.", "Agregar antecedente", JOptionPane.ERROR_MESSAGE );
            }
            
            String tipo = ( String )cbbAntecedentes.getSelectedItem( );
            String descripcion = areaDescripcion.getText( );

            if( descripcion.equals( "" ) || identificador == -1)
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar todos los datos del antecedente.", "Agregar antecedente", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                try
                {
                    principal.agregarAntecedente( identificador, tipo, descripcion );                    
                    dispose( );
                }
                catch( Exception pExcepcion )
                {
                    JOptionPane.showMessageDialog( this, pExcepcion.getMessage( ) , "Agregar antecedente", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }
}
