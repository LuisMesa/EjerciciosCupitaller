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

import uniandes.cupi2.tiendaLibros.mundo.CarroCompras;

/**
 * Panel para visualizar la informaci�n de los carros de compra.
 */
public class PanelCarrosCompra extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para agregar un carro de compras.
     */
    private final static String AGREGAR = "Agregar carro de compras";

    /**
     * Constante para eliminar un carro de compras.
     */
    private final static String ELIMINAR = "Eliminar carro de compras";

    /**
     * Constante para vender un carro de compras.
     */
    private final static String VENDER = "Vender carro de compras";

    /**
     * Constante para modificar los libros de un carro de compras.
     */
    private final static String LIBROS = "Modificar libros";

    /**
     * Constante con los nombres de las columnas de la tabla.
     */
    public static final String[] NOMBRE_COLUMNAS = { "Nombre", "C�dula", "Estado", "Valor" };

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazTiendaLibros principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Tabla para mostrar la informaci�n de los carros de compras.
     */
    private JTable tablaCarrosCompra;

    /**
     * Modelo para visualizar la informaci�n en la tabla de los carros de compras.
     */
    private DefaultTableModel model;

    /**
     * Bot�n para agregar un carro de compras.
     */
    private JButton btnAgregar;

    /**
     * Bot�n para eliminar un carro de compras.
     */
    private JButton btnEliminar;

    /**
     * Bot�n para vender un carro de compras.
     */
    private JButton btnVender;

    /**
     * Bot�n para modificar los libros de un carro de compras.
     */
    private JButton btnModificarLibros;

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
     * Crea el panel para la visualizaci�n de los carros de compras.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelCarrosCompra( InterfazTiendaLibros pPrincipal )
    {
        principal = pPrincipal;

        borde = new TitledBorder( "Todos los carros de compras" );
        setBorder( borde );
        setLayout( new BorderLayout( ) );

        model = new DefaultTableModel( NOMBRE_COLUMNAS, 0 );
        tablaCarrosCompra = new JTable( model );
        tablaCarrosCompra.setColumnSelectionAllowed( false );
        tablaCarrosCompra.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tablaCarrosCompra.setFont( new Font( "Arial", Font.BOLD, 12 ) );
        tablaCarrosCompra.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
        tablaCarrosCompra.getTableHeader( ).setReorderingAllowed( false );

        JScrollPane scroll = new JScrollPane( );
        scroll.setViewportView( tablaCarrosCompra );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        add( scroll, BorderLayout.CENTER );

        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new GridLayout( 2, 1 ) );

        JPanel panelOpcionesPasaporte = new JPanel( );
        panelOpcionesPasaporte.setLayout( new GridLayout( 1, 4 ) );
        panelOpcionesPasaporte.setBorder( new TitledBorder( "Opciones carro de compras" ) );

        btnAgregar = new JButton( "Agregar carro" );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );
        panelOpcionesPasaporte.add( btnAgregar );

        btnEliminar = new JButton( "Eliminar carro" );
        btnEliminar.setActionCommand( ELIMINAR );
        btnEliminar.addActionListener( this );
        panelOpcionesPasaporte.add( btnEliminar );

        btnVender = new JButton( "Vender carro" );
        btnVender.setActionCommand( VENDER );
        btnVender.addActionListener( this );
        panelOpcionesPasaporte.add( btnVender );

        btnModificarLibros = new JButton( "Modificar carro" );
        btnModificarLibros.setActionCommand( LIBROS );
        btnModificarLibros.addActionListener( this );
        panelOpcionesPasaporte.add( btnModificarLibros );

        panelConsultas = new PanelConsultas( principal );

        panelSur.add( panelOpcionesPasaporte );
        panelSur.add( panelConsultas );

        add( panelSur, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna la c�dula del carro seleccionado en la tabla.
     * @return C�dula del carro seleccionado en la tabla, null en caso de no seleccionar nada.
     */
    public String darIndiceCarroSeleccionado( )
    {
        String rta = null;

        try
        {
            rta = ( String )model.getValueAt( tablaCarrosCompra.getSelectedRow( ), 1 );
        }
        catch( ArrayIndexOutOfBoundsException e )
        {
            rta = null;
        }

        return rta;
    }

    /**
     * Actualiza la informaci�n de la tabla para mostrar los carros de compra que recibe por par�metro.
     * @param pCarros Lista de carros que se deben mostrar en la tabla. pCarros != null.
     */
    public void actualizarPasaportes( ArrayList pCarros )
    {
        model = new DefaultTableModel( NOMBRE_COLUMNAS, 0 );
        tablaCarrosCompra.setModel( model );
        String[] columnas;

        for( int i = 0; i < pCarros.size( ); i++ )
        {
            columnas = new String[4];
            CarroCompras carroActual = ( CarroCompras )pCarros.get( i );
            columnas[ 0 ] = carroActual.darNombreDuenio( );
            columnas[ 1 ] = carroActual.darCedulaDuenio( );
            String estadoCarro = "Elaboraci�n";
            if( carroActual.darEstado( ) == CarroCompras.VENDIDO )
            {
                estadoCarro = "Vendido";
            }
            columnas[ 2 ] = estadoCarro;
            columnas[ 3 ] = carroActual.calcularValorTotalCompra( ) + "";

            model.addRow( columnas );
        }
    }

    /**
     * Modifica el t�tulo del panel con el dado por par�metro.
     * @param pTitulo T�tulo nuevo del panel. pTitulo != null && pTitulo != "".
     */
    public void modificarTitulo( String pTitulo )
    {
        borde.setTitle( pTitulo );
    }

    /**
     * Recoge las acciones sobre los objetos que est� escuchando.
     * @param pEvento Evento que se realiz�. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( AGREGAR ) )
        {
            principal.mostrarDialogoAgregarCarroCompras( );
        }
        else if( comando.equals( ELIMINAR ) )
        {
            principal.eliminarCarroCompras( );
        }
        else if( comando.equals( VENDER ) )
        {
            principal.venderCarroCompras( );
        }
        else if( comando.equals( LIBROS ) )
        {
            principal.modificarLibrosCarroCompras( );
        }
    }

}
