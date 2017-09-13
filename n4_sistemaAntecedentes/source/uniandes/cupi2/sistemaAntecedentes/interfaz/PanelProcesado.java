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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.sistemaAntecedentes.mundo.Procesado;

/**
 * Panel con la información de un procesado.
 */
public class PanelProcesado extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para agregar un procesado.
     */
    private static final String AGREGAR_PROCESADO = "Agregar";

    /**
     * Constante que representa el comando para eliminar un procesado.
     */
    private static final String ELIMINAR_PROCESADO = "Eliminar";

    /**
     * Constante que representa el comando para buscar un procesado.
     */
    private final static String BUSCAR_PROCESADO = "Buscar";

    /**
     * Constante que representa el comando para buscar el anterior procesado.
     */
    private final static String PROCESADO_ANTERIOR = "<<";

    /**
     * Constante que representa el comando para buscar el siguiente procesado.
     */
    private final static String PROCESADO_SIGUIENTE = ">>";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazSistemaAntecedentes principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta con la imagen del procesado.
     */
    private JLabel lblImagen;

    /**
     * Etiqueta con el nombre del procesado.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta con el apellido del procesado.
     */
    private JLabel lblApellido;

    /**
     * Etiqueta con la edad del procesado.
     */
    private JLabel lblEdad;
    
    /**
     * Etiqueta con el número de identificación del procesado.
     */
    private JLabel lblIdentificacion;
    
    /**
     * Etiqueta con los años de condena del procesado.
     */
    private JLabel lblAnhosCondena;

    /**
     * Botón para agregar un nuevo procesado.
     */
    private JButton btnAgregar;

    /**
     * Botón para eliminar un procesado.
     */
    private JButton btnEliminar;

    /**
     * Botón para buscar un procesado.
     */
    private JButton btnBuscar;

    /**
     * Botón para mostrar el anterior procesado.
     */
    private JButton btnProcesadoAnterior;

    /**
     * Botón para mostrar el siguiente procesado.
     */
    private JButton btnProcesadoSiguiente;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel con la información de un procesado.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelProcesado( InterfazSistemaAntecedentes pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );
        setPreferredSize( new Dimension( 350, 0 ) );

        TitledBorder border = BorderFactory.createTitledBorder( "Procesado" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );

        JPanel aux1 = new JPanel( );
        aux1.setLayout( new GridLayout( 1, 1 ) );
        aux1.setPreferredSize( new Dimension( 150, 0 ) );
        lblImagen = new JLabel( );
        aux1.add( lblImagen );

        add( aux1, BorderLayout.WEST );

        JPanel aux2 = new JPanel( );
        aux2.setLayout( new GridLayout( 5, 1 ) );
        aux2.setPreferredSize( new Dimension( 190, 0 ) );

        lblNombre = new JLabel( "Nombre: " );
        aux2.add( lblNombre );

        lblApellido = new JLabel( "Apellido: " );
        aux2.add( lblApellido );

        lblIdentificacion = new JLabel( "N° de identificación: " );
        aux2.add( lblIdentificacion );
        
        lblEdad = new JLabel( "Edad: " );
        aux2.add( lblEdad );
        
        lblAnhosCondena = new JLabel( "Años de condena: " );
        aux2.add( lblAnhosCondena );

        add( aux2, BorderLayout.CENTER );

        JPanel aux3 = new JPanel( );
        aux3.setLayout( new GridLayout( 1, 3 ) );

        btnAgregar = new JButton( AGREGAR_PROCESADO );
        btnAgregar.setActionCommand( AGREGAR_PROCESADO );
        btnAgregar.addActionListener( this );
        aux3.add( btnAgregar );

        btnEliminar = new JButton( ELIMINAR_PROCESADO );
        btnEliminar.setActionCommand( ELIMINAR_PROCESADO );
        btnEliminar.addActionListener( this );
        aux3.add( btnEliminar );

        btnBuscar = new JButton( BUSCAR_PROCESADO );
        btnBuscar.setActionCommand( BUSCAR_PROCESADO );
        btnBuscar.addActionListener( this );
        aux3.add( btnBuscar );

        JPanel aux4 = new JPanel( );
        aux4.setLayout( new GridLayout( 1, 2 ) );

        btnProcesadoAnterior = new JButton( PROCESADO_ANTERIOR );
        btnProcesadoAnterior.setActionCommand( PROCESADO_ANTERIOR );
        btnProcesadoAnterior.addActionListener( this );
        aux4.add( btnProcesadoAnterior );

        btnProcesadoSiguiente = new JButton( PROCESADO_SIGUIENTE );
        btnProcesadoSiguiente.setActionCommand( PROCESADO_SIGUIENTE );
        btnProcesadoSiguiente.addActionListener( this );
        aux4.add( btnProcesadoSiguiente );

        JPanel aux5 = new JPanel( );
        aux5.setLayout( new GridLayout( 2, 1 ) );
        aux5.add( aux3 );
        aux5.add( aux4 );

        add( aux5, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la información del procesado.
     * @param pNombre Nombre del procesado. pNombre != "" && pNombre != null.
     * @param pApellido Apellido del procesado. pApellido != "" && pApellido != null.
     * @param pIdentificacion Número de identificación del procesado. pIdentificacion != "" && pIdentificacion != null.
     * @param pSexo Sexo del procesado. pSexo != "" && pSexo != null.
     * @param pEdad Edad de procesado. pEdad >= 5.
     * @param pAnhosCondena Años de condena del procesado. pAnhosCondena >= 0.
     */
    public void actualizar( String pNombre, String pApellido, String pIdentificacion, String pSexo, int pEdad, int pAnhosCondena )
    {
        lblNombre.setText( "Nombre: " + pNombre );
        lblApellido.setText( "Apellido: " + pApellido );
        lblIdentificacion.setText( "N° de identificación: " + pIdentificacion );
        lblEdad.setText( "Edad: " +  pEdad );
        lblAnhosCondena.setText( "Años de condena: " + pAnhosCondena );

        if( pSexo.equals( Procesado.MASCULINO ) )
        {
            ImageIcon icono = new ImageIcon( "data/imagenes/sexoMasculino.png" );
            lblImagen.setIcon( icono );
        }
        else if( pSexo.equals( Procesado.FEMENINO ) )
        {
            ImageIcon icono = new ImageIcon( "data/imagenes/sexoFemenino.png" );
            lblImagen.setIcon( icono );
        }
        else
        {
            lblImagen.setIcon( null );
        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( AGREGAR_PROCESADO ) )
        {
            principal.abrirDialogoAgregarProcesado( );
        }
        else if( comando.equals( ELIMINAR_PROCESADO ) )
        {
            principal.eliminarProcesado( );
        }
        else if( comando.equals( BUSCAR_PROCESADO ) )
        {
            principal.buscarProcesado( );
        }
        else if( comando.equals( PROCESADO_ANTERIOR ) )
        {
            principal.cambiarProcesadoAnterior( );
        }
        else if( comando.equals( PROCESADO_SIGUIENTE ) )
        {
            principal.cambiarProcesadoSiguiente( );
        }
    }
}