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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import uniandes.cupi2.sistemaAntecedentes.mundo.Antecedente;
import uniandes.cupi2.sistemaAntecedentes.mundo.Procesado;

/**
 * Diálogo de creación de un procesado.
 */
public class DialogoAgregarProcesado extends JDialog implements ActionListener
{
    // -------------------------------------------------------------
    // COnstantes
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

    // -------------------------------------------------------------
    // Atributos de la interfaz
    // -------------------------------------------------------------

    /**
     * Pestañas de navegación entre el procesado y el antecedente.
     */
    private JTabbedPane tabs;

    /**
     * Etiqueta para indicar el nombre del procesado.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta para indicar el apellido del procesado.
     */
    private JLabel lblApellido;

    /**
     * Etiqueta para indicar el número de identificación del procesado.
     */
    private JLabel lblIdentificacion;

    /**
     * Etiqueta para indicar el sexo del procesado.
     */
    private JLabel lblSexo;

    /**
     * Etiqueta para indicar la edad del procesado.
     */
    private JLabel lblEdad;

    /**
     * Campo de texto para el nombre del procesado.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para el apellido del procesado.
     */
    private JTextField txtApellido;

    /**
     * Campo de texto para el número de identificación del procesado.
     */
    private JTextField txtIdentificacion;

    /**
     * Campo de texto para la edad del procesado.
     */
    private JTextField txtEdad;

    /**
     * Botón de selección para el sexo masculino.
     */
    private JRadioButton rbtMasculino;

    /**
     * Botón de selección para el sexo femenino.
     */
    private JRadioButton rbtFemenino;

    /**
     * Grupo para los botones de selección.
     */
    private ButtonGroup grupo;

    /**
     * Etiqueta del identificador del antecedente.
     */
    private JLabel lblIdentificador;

    /**
     * Etiqueta del antecedente.
     */
    private JLabel lblAntecedente;

    /**
     * Etiqueta de la descripción.
     */
    private JLabel lblDescripcion;

    /**
     * ComboBox con los tipos de antecedentes.
     */
    private JComboBox cbbAntecedentes;

    /**
     * Campo de texto para el identificador.
     */
    private JTextField txtIdentificador;

    /**
     * Área de texto de la descripción.
     */
    private JTextArea areaDescripcion;

    /**
     * Scroll vertical.
     */
    private JScrollPane scroll;

    /**
     * Botón para aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón para cancelar.
     */
    private JButton btnCancelar;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Constructor del diálogo para agregar un procesado y un antecedente. <br>
     * <b>post: </b> Construyó el panel e inicializó el atributo principal con el valor dado por parámetro. <br>
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoAgregarProcesado( InterfazSistemaAntecedentes pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Agregar nuevo procesado" );
        setModal( true );
        setSize( 400, 220 );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLayout( new BorderLayout( ) );
        setLocationRelativeTo( principal );

        JPanel aux1 = new JPanel( );
        aux1.setLayout( new GridLayout( 6, 2 ) );

        lblNombre = new JLabel( "Nombre: " );
        aux1.add( lblNombre );

        txtNombre = new JTextField( );
        aux1.add( txtNombre );

        lblApellido = new JLabel( "Apellido: " );
        aux1.add( lblApellido );

        txtApellido = new JTextField( );
        aux1.add( txtApellido );

        lblEdad = new JLabel( "Edad: " );
        aux1.add( lblEdad );

        txtEdad = new JTextField( );
        aux1.add( txtEdad );

        lblIdentificacion = new JLabel( "N° Identificación: " );
        aux1.add( lblIdentificacion );

        txtIdentificacion = new JTextField( );
        aux1.add( txtIdentificacion );

        lblSexo = new JLabel( "Sexo: " );
        aux1.add( lblSexo );

        rbtMasculino = new JRadioButton( Procesado.MASCULINO );
        rbtMasculino.setSelected( true );
        aux1.add( rbtMasculino );

        JLabel aux2 = new JLabel( );
        aux1.add( aux2 );

        rbtFemenino = new JRadioButton( Procesado.FEMENINO );
        aux1.add( rbtFemenino );

        grupo = new ButtonGroup( );
        grupo.add( rbtMasculino );
        grupo.add( rbtFemenino );

        JPanel aux3 = new JPanel( );
        aux3.setLayout( new BorderLayout( ) );
        aux3.setPreferredSize( new Dimension( 0, 200 ) );

        JPanel aux4 = new JPanel( );
        aux4.setLayout( new GridLayout( 3, 2 ) );
        aux4.setPreferredSize( new Dimension( 0, 80 ) );

        lblIdentificador = new JLabel( "Identificador:" );
        aux4.add( lblIdentificador );

        txtIdentificador = new JTextField( );
        aux4.add( txtIdentificador );

        lblAntecedente = new JLabel( "Tipo:" );
        aux4.add( lblAntecedente );

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
        aux4.add( cbbAntecedentes, BorderLayout.WEST );

        lblDescripcion = new JLabel( "Descripción: " );
        aux4.add( lblDescripcion, BorderLayout.CENTER );

        aux3.add( aux4, BorderLayout.CENTER );

        areaDescripcion = new JTextArea( );
        areaDescripcion.setLineWrap( true );
        areaDescripcion.setWrapStyleWord( true );
        areaDescripcion.setPreferredSize( new Dimension( 0, 70 ) );

        scroll = new JScrollPane( areaDescripcion );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
        aux3.add( scroll, BorderLayout.SOUTH );

        tabs = new JTabbedPane( );
        tabs.addTab( "Procesado", aux1 );
        tabs.addTab( "Antecedente", aux3 );

        add( tabs, BorderLayout.CENTER );

        JPanel aux5 = new JPanel( );
        aux5.setLayout( new GridLayout( 1, 2 ) );

        btnAceptar = new JButton( ACEPTAR );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        aux5.add( btnAceptar );

        btnCancelar = new JButton( CANCELAR );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        aux5.add( btnCancelar );

        add( aux5, BorderLayout.SOUTH );
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
            boolean puedeAgregar = true;

            String mensajeError = "¡Error! No se pudo agregar el antecedente por los siguientes errores: \n";

            String nombre = txtNombre.getText( );
            String apellido = txtApellido.getText( );
            String identificacion = txtIdentificacion.getText( );
            String sexo = "";
            if( rbtMasculino.isSelected( ) )
            {
                sexo = Procesado.MASCULINO;
            }
            else
            {
                sexo = Procesado.FEMENINO;
            }

            int edad = 0;
            try
            {
                edad = Integer.parseInt( txtEdad.getText( ) );
            }
            catch( NumberFormatException pNumberFormatEx )
            {
                mensajeError += "La edad debe ser un valor numérico. \n";
                puedeAgregar = false;
            }

            int identificador = -1;
            try
            {
                identificador = Integer.parseInt( txtIdentificador.getText( ) );
                if( identificador < 0 )
                {
                    mensajeError += "El identificador del antecedente debe ser mayor o igual a 0. \n";
                    puedeAgregar = false;
                }
            }
            catch( NumberFormatException pExcepcion )
            {
                mensajeError += "El identificador del antecedente debe ser un valor numérico. \n";
                puedeAgregar = false;
            }

            String tipo = ( String )cbbAntecedentes.getSelectedItem( );
            String descripcion = areaDescripcion.getText( );

            if( nombre.equals( "" ) || apellido.equals( "" ) || identificacion.equals( "" ) || descripcion.equals( "" ) || edad == 0 || identificador == -1 )
            {
                mensajeError += "Debe ingresar todos los datos del procesado y del antecedente. \n";
                JOptionPane.showMessageDialog( this, mensajeError, "Error", JOptionPane.ERROR_MESSAGE );
                puedeAgregar = false;
            }
            else
            {
                if( puedeAgregar )
                {
                    principal.agregarProcesadoYAntecedente( nombre, apellido, identificacion, sexo, edad, identificador, tipo, descripcion );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, mensajeError, "Error", JOptionPane.ERROR_MESSAGE );
                }

            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }

}
