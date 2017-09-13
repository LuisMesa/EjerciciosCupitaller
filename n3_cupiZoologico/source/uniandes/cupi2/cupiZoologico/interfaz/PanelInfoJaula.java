/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_cupiZoologico
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiZoologico.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.cupiZoologico.mundo.Animal;

/**
 * Panel que contiene la información de la jaula actual.
 */
public class PanelInfoJaula extends JPanel implements ActionListener, ListSelectionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando anterior.
     */
    private static final String ANTERIOR = "<<";

    /**
     * Constante que representa el comando siguiente.
     */
    private static final String SIGUIENTE = ">>";

    /**
     * Constante que representa el comando buscar.
     */
    private static final String BUSCAR = "Buscar";

    /**
     * Constante que representa el comando asignar guardia.
     */
    private static final String ASIGNAR = "Asignar guardia";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCupiZoologico principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la información de la jaula.
     */
    private JPanel panelInfo;

    /**
     * Panel para la navegación de jaulas.
     */
    private JPanel panelNavegacion;

    /**
     * Panel para manejo de la información del guardia.
     */
    private JPanel panelGuardia;

    /**
     * Panel con la información de la jaula.
     */
    private JPanel panelJaula;

    /**
     * Panel que contiene la lista de animales.
     */
    private JScrollPane panelListaAnimales;

    /**
     * Campo de texto con el número.
     */
    private JTextField txtNumero;

    /**
     * Campo de texto con el sector.
     */
    private JTextField txtSector;

    /**
     * Campo de texto con el tamaño.
     */
    private JTextField txtTamanio;

    /**
     * Campo de texto con el nombre del guardia.
     */
    private JTextField txtNombreGuardia;

    /**
     * Campo de texto con los años de experiencia del guardia.
     */
    private JTextField txtAnhoExperienciaGuardia;

    /**
     * Botón para siguiente.
     */
    private JButton btnSiguiente;

    /**
     * Botón para anterior.
     */
    private JButton btnAnterior;

    /**
     * Botón para buscar.
     */
    private JButton btnBuscar;

    /**
     * Botón para asignar un guardia.
     */
    private JButton btnAsignarGuardia;

    /**
     * Lista de animales.
     */
    private JList listaAnimales;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelInfoJaula( InterfazCupiZoologico pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Información jaulas" ) );
        setLayout( new BorderLayout( ) );
        inicializarPanelesJaula( );
        inicializarPanelGuardia( );
        inicializarPanelNavegacion( );
        actualizar( );
        JPanel panelAuxiliar = new JPanel( );
        panelAuxiliar.setLayout( new GridLayout( 2, 1 ) );
        panelAuxiliar.setSize( new Dimension( 400, 110 ) );
        panelAuxiliar.add( panelGuardia );
        panelAuxiliar.add( panelNavegacion );
        add( panelJaula, BorderLayout.NORTH );
        add( panelListaAnimales, BorderLayout.CENTER );
        add( panelAuxiliar, BorderLayout.SOUTH);

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa los paneles con información de la jaula.
     */
    public void inicializarPanelesJaula( )
    {
        panelJaula = new JPanel( );
        panelJaula.setLayout( new BorderLayout( ) );

        panelInfo = new JPanel( );
        panelInfo.setLayout( new GridLayout( 6, 2 ) );
        

        panelInfo.add( new JLabel( " " ) );
        panelInfo.add( new JLabel( " " ) );

        panelInfo.add( new JLabel( " Numero: " ) );
        txtNumero = new JTextField( );
        txtNumero.setEditable( false );
        panelInfo.add( txtNumero );

        panelInfo.add( new JLabel( " Sector: " ) );
        txtSector = new JTextField( );
        txtSector.setEditable( false );
        panelInfo.add( txtSector );

        panelInfo.add( new JLabel( " Tamaño: " ) );
        txtTamanio = new JTextField( );
        txtTamanio.setEditable( false );
        panelInfo.add( txtTamanio );

        panelListaAnimales = new JScrollPane( );
        panelListaAnimales.setBorder( new TitledBorder( "Animales:" ) );
        listaAnimales = new JList( );
        listaAnimales.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        listaAnimales.addListSelectionListener( this );
        listaAnimales.setSelectedIndex( 1 );
        panelListaAnimales.setViewportView( listaAnimales );
        panelListaAnimales.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        panelListaAnimales.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        
        panelJaula.add( panelInfo, BorderLayout.NORTH );

 
    }

    /**
     * Inicializa el panel del guardia.
     */
    public void inicializarPanelGuardia( )
    {
        panelGuardia = new JPanel( );
        panelGuardia.setSize( new Dimension( 400, 55 ) );
        panelGuardia.setBorder( new TitledBorder( "Guardia de la jaula" ) );
        panelGuardia.setLayout( new GridLayout( 1, 3 ) );

        txtNombreGuardia = new JTextField( "Sin guardia" );
        txtNombreGuardia.setEditable( false );
        panelGuardia.add( txtNombreGuardia );

        txtAnhoExperienciaGuardia = new JTextField( "Sin guardia" );
        txtAnhoExperienciaGuardia.setEditable( false );
        panelGuardia.add( txtAnhoExperienciaGuardia );
        
        btnAsignarGuardia = new JButton( "Asignar Guardia" );
        btnAsignarGuardia.setActionCommand( ASIGNAR );
        btnAsignarGuardia.addActionListener( this );
        panelGuardia.add( btnAsignarGuardia );
    }

    /**
     * Inicializa el panel de navegación.
     */
    public void inicializarPanelNavegacion( )
    {
        panelNavegacion = new JPanel( );
        panelNavegacion.setSize( new Dimension( 400, 55 ) );
        panelNavegacion.setBorder( new TitledBorder( "Selección jaula" ) );
        panelNavegacion.setLayout( new GridLayout( 1, 3 ) );

        // Botón Anterior
        btnAnterior = new JButton( "<<" );
        btnAnterior.setActionCommand( ANTERIOR );
        btnAnterior.addActionListener( this );
        panelNavegacion.add( btnAnterior );

        // Botón Siguiente
        btnSiguiente = new JButton( ">>" );
        btnSiguiente.setActionCommand( SIGUIENTE );
        btnSiguiente.addActionListener( this );
        panelNavegacion.add( btnSiguiente );

        // Botón Buscar
        btnBuscar = new JButton( "Buscar" );
        btnBuscar.setActionCommand( BUSCAR );
        btnBuscar.addActionListener( this );
        panelNavegacion.add( btnBuscar );
    }

    /**
     * Actualiza la información del panel.
     */
    public void actualizar( )
    {
        txtNumero.setText( "" + ( principal.darNumeroJaulaActual( ) + 1 ) );
        txtSector.setText( principal.darJaulaActual( ).darSector( ) );
        txtTamanio.setText( principal.darJaulaActual( ).darTamanio( ) );
        if( principal.darJaulaActual( ).darGuardia( ) != null )
        {
            txtNombreGuardia.setText( principal.darJaulaActual( ).darGuardia( ).darNombre( ) );
            txtAnhoExperienciaGuardia.setText( principal.darJaulaActual( ).darGuardia( ).darAnhosExperiencia( ) + "" );
            btnAsignarGuardia.setEnabled( false );
        }
        else{
            txtNombreGuardia.setText( "Sin guardia" );
            txtAnhoExperienciaGuardia.setText("Sin guardia" );
            btnAsignarGuardia.setEnabled( true );
        }
        listaAnimales.setListData( principal.darJaulaActual( ).darAnimales( ).toArray( ) );
        if( listaAnimales.getSelectedIndex( ) == -1 )
        {
            listaAnimales.setSelectedIndex( 0 );
        }
    }

    /**
     * Cambia la selección de la lista a 0.
     */
    public void reiniciarSeleccionLista( )
    {
        listaAnimales.setSelectedIndex( 0 );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( pEvento.getActionCommand( ).equals( SIGUIENTE ) )
        {
            principal.siguenteJaula( );
            actualizar( );
            listaAnimales.setSelectedIndex( 0 );
        }
        else if( pEvento.getActionCommand( ).equals( ANTERIOR ) )
        {
            principal.anteriorJaula( );
            actualizar( );
            listaAnimales.setSelectedIndex( 0 );
        }
        else if( pEvento.getActionCommand( ).equals( BUSCAR ) )
        {
            principal.buscarJaula( );
        }
        else if( pEvento.getActionCommand( ).equals( ASIGNAR ) )
        {
            DialogoAsignarGuardia dialogo = new DialogoAsignarGuardia( principal );
            dialogo.setVisible( true );
        }
    }

    /**
     * Maneja los eventos de selección de la lista.
     * @param pEvento Evento de selección. pEvento != null.
     */
    public void valueChanged( ListSelectionEvent pEvento )
    {
        if( listaAnimales.getSelectedValue( ) != null )
        {
            Animal animal = ( Animal )listaAnimales.getSelectedValue( );
            principal.verDatosAnimal( animal );
        }
    }
}
