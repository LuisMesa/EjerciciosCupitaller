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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import uniandes.cupi2.parqueDiversiones.mundo.Pasaporte;

/**
 * Panel para visualizar la información de los pasaportes.
 */
public class PanelPasaportes extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para agregar un pasaporte.
     */
    private final static String AGREGAR = "Agregar pasaporte";

    /**
     * Constante para eliminar un pasaporte.
     */
    private final static String ELIMINAR = "Eliminar pasaporte";

    /**
     * Constante para vender un pasaporte.
     */
    private final static String VENDER = "Vender pasaporte";

    /**
     * Constante para modificar las atracciones de un pasaporte.
     */
    private final static String ATRACCIONES = "Modificar atracciones";

    /**
     * Constante con los nombres de las columnas de la tabla.
     */
    public static final String[] NOMBRE_COLUMNAS = { "Nombre", "Cédula", "Categoría", "Estado" };

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazParqueDiversiones principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Tabla para mostrar la información de los pasaportes.
     */
    private JTable tablaPasaportes;

    /**
     * Modelo para visualizar la información en la tabla de los pasaportes.
     */
    private DefaultTableModel model;

    /**
     * Botón para agregar un pasaporte.
     */
    private JButton btnAgregar;

    /**
     * Botón para eliminar un pasaporte.
     */
    private JButton btnEliminar;

    /**
     * Botón para vender un pasaporte.
     */
    private JButton btnVender;

    /**
     * Botón para modificar las atracciones de un pasaporte.
     */
    private JButton btnModificarAtracciones;

    /**
     * Borde del panel.
     */
    private TitledBorder borde;

    /**
     * Panel con las consultas.
     */
    private PanelConsultas panelConsultas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel para la visualización de los pasaportes.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelPasaportes( InterfazParqueDiversiones pPrincipal )
    {
        principal = pPrincipal;

        borde = new TitledBorder( "Todos los pasaportes" );
        setBorder( borde );
        setLayout( new BorderLayout( ) );

        model = new DefaultTableModel( NOMBRE_COLUMNAS, 0 );
        tablaPasaportes = new JTable( model );
        tablaPasaportes.setColumnSelectionAllowed( false );
        tablaPasaportes.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tablaPasaportes.setFont( new Font( "Arial", Font.BOLD, 12 ) );
        tablaPasaportes.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
        tablaPasaportes.getTableHeader( ).setReorderingAllowed( false );

        JScrollPane scroll = new JScrollPane( );
        scroll.setViewportView( tablaPasaportes );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        add( scroll, BorderLayout.CENTER );

        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new GridLayout( 2, 1 ) );

        JPanel panelOpcionesPasaporte = new JPanel( );
        panelOpcionesPasaporte.setLayout( new GridLayout( 1, 4 ) );
        panelOpcionesPasaporte.setBorder( new TitledBorder( "Opciones pasaporte" ) );

        btnAgregar = new JButton( "Agregar pasaporte" );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );
        panelOpcionesPasaporte.add( btnAgregar );

        btnEliminar = new JButton( "Eliminar pasaporte" );
        btnEliminar.setActionCommand( ELIMINAR );
        btnEliminar.addActionListener( this );
        panelOpcionesPasaporte.add( btnEliminar );

        btnVender = new JButton( "Vender pasaporte" );
        btnVender.setActionCommand( VENDER );
        btnVender.addActionListener( this );
        panelOpcionesPasaporte.add( btnVender );

        btnModificarAtracciones = new JButton( "Modificar pasaporte" );
        btnModificarAtracciones.setActionCommand( ATRACCIONES );
        btnModificarAtracciones.addActionListener( this );
        panelOpcionesPasaporte.add( btnModificarAtracciones );

        panelConsultas = new PanelConsultas( principal );
        
        panelSur.add( panelOpcionesPasaporte );
        panelSur.add( panelConsultas );
        
        add( panelSur, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el índice del pasaporte seleccionado en la tabla.
     * @return Índice del pasaporte seleccionado en la tabla.
     */
    public int darIndicePasaporteSeleccionado( )
    {
        int rta = -1;

        try
        {
            String numPedido = ( String )model.getValueAt( tablaPasaportes.getSelectedRow( ), 1 );
            if( numPedido != null )
            {
                rta = Integer.valueOf( numPedido ).intValue( );
            }
        }
        catch( ArrayIndexOutOfBoundsException e )
        {
            rta = -1;
        }

        return rta;
    }

    /**
     * Actualiza la información de la tabla para mostrar los pasaportes que recibe por parámetro.
     * @param pPasaportes Lista de pasaportes que se deben mostrar en la tabla. pPasaportes != null.
     */
    public void actualizarPasaportes( ArrayList pPasaportes )
    {
        model = new DefaultTableModel( NOMBRE_COLUMNAS, 0 );
        tablaPasaportes.setModel( model );
        String[] columna;

        for( int i = 0; i < pPasaportes.size( ); i++ )
        {
            columna = new String[4];
            Pasaporte pasaporteActual = ( Pasaporte )pPasaportes.get( i );
            columna[ 0 ] = pasaporteActual.darNombreDuenio( );
            columna[ 1 ] = pasaporteActual.darCedulaDuenio( ) + "";
            columna[ 2 ] = pasaporteActual.darCategoria( );
            String estadoPasaporte = "Elaboración";
            if( pasaporteActual.darEstado( ) == Pasaporte.VENDIDO )
            {
                estadoPasaporte = "Vendido";
            }
            columna[ 3 ] = estadoPasaporte;

            model.addRow( columna );
        }
    }

    /**
     * Modifica el título del panel con el dado por parámetro.
     * @param pTitulo Título nuevo del panel. pTitulo != null && pTitulo != "".
     */
    public void modificarTitulo( String pTitulo )
    {
        borde.setTitle( pTitulo );
    }

    /**
     * Recoge las acciones sobre los objetos que está escuchando.
     * @param pEvento Evento que se realizó. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( AGREGAR ) )
        {
            principal.mostrarDialogoAgregarPasaporte( );
        }
        else if( comando.equals( ELIMINAR ) )
        {
            principal.eliminarPasaporte( );
        }
        else if( comando.equals( VENDER ) )
        {
            principal.venderPasaporte( );
        }
        else if( comando.equals( ATRACCIONES ) )
        {
            principal.modificarAtraccionesPasaporte( );
        }
    }

}
