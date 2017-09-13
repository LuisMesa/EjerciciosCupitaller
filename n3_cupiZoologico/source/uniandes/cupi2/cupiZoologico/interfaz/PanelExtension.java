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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de extensiones.
 */
public class PanelExtension extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando opción 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Constante que representa el comando opción 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    /**
     * Constante que representa el comando de mayor cantidad de animales.
     */
    private static final String JAULA_MAYOR_CANTIDAD = "Mayor Cantidad de Animales";

    /**
     * Constante que representa el comando de misma cantidad de animales.
     */
    private static final String JAULA_MISMA_CANTIDAD = "Misma Cantidad de Animales";

    /**
     * Constante que representa el comando para buscar un animal.
     */
    private static final String BUSCAR_ANIMAL = "Buscar Animal";

    /**
     * Constante que representa el comando para agregar.
     */
    private static final String AGREGAR = "Agregar";

    /**
     * Constante que representa el comando para eliminar.
     */
    private static final String ELIMINAR = "Eliminar";

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
     * Botón para opción 1.
     */
    private JButton btnOpcion1;

    /**
     * Botón para opción 2.
     */
    private JButton btnOpcion2;

    /**
     * Botón para agregar.
     */
    private JButton btnAgregar;

    /**
     * Botón para eliminar.
     */
    private JButton btnEliminar;

    /**
     * Botón para mayor cantidad.
     */
    private JButton btnMayorCantidad;

    /**
     * Botón para misma cantidad.
     */
    private JButton btnMismaCantidad;

    /**
     * Botón para buscar animal.
     */
    private JButton btnBuscarAnimal;

    /**
     * Panel con los botones para la consulta.
     */
    private JPanel panelBusquedas;

    /**
     * Panel con los botones para la consulta y opciones.
     */
    private JPanel panelOpciones;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelExtension( InterfazCupiZoologico pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 2, 1 ) );

        inicializarPanelBusquedas( );
        inicializarPanelOpciones( );

        add( panelBusquedas );
        add( panelOpciones );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el panel que contiene los botones para las consultas.
     */
    public void inicializarPanelBusquedas( )
    {
        panelBusquedas = new JPanel( );
        panelBusquedas.setLayout( new GridLayout( 1, 4 ) );

        // Botón Agregar Animal
        btnAgregar = new JButton( "Agregar animal" );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );
        panelBusquedas.add( btnAgregar );

        // Botón Eliminar Animal
        btnEliminar = new JButton( "Eliminar animal" );
        btnEliminar.setActionCommand( ELIMINAR );
        btnEliminar.addActionListener( this );
        panelBusquedas.add( btnEliminar );

        // Botón Buscar Animal
        btnBuscarAnimal = new JButton( "Buscar animal" );
        btnBuscarAnimal.setActionCommand( BUSCAR_ANIMAL );
        btnBuscarAnimal.addActionListener( this );
        panelBusquedas.add( btnBuscarAnimal );

        // Botón Mayor Cantidad
        btnMayorCantidad = new JButton( "Jaula más poblada" );
        btnMayorCantidad.setActionCommand( JAULA_MAYOR_CANTIDAD );
        btnMayorCantidad.addActionListener( this );
        panelBusquedas.add( btnMayorCantidad );

    }

    /**
     * Inicializa el panel que contiene los botones con consultas y opciones.
     */
    public void inicializarPanelOpciones( )
    {
        panelOpciones = new JPanel( );
        panelOpciones.setLayout( new GridLayout( 1, 3 ) );

        // Botón Misma Cantidad
        btnMismaCantidad = new JButton( "Jaulas con misma cantidad" );
        btnMismaCantidad.setActionCommand( JAULA_MISMA_CANTIDAD );
        btnMismaCantidad.addActionListener( this );
        panelOpciones.add( btnMismaCantidad );

        // Botón opción 1
        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        panelOpciones.add( btnOpcion1 );

        // Botón opción 2
        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        panelOpciones.add( btnOpcion2 );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( OPCION_1.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( JAULA_MAYOR_CANTIDAD.equals( pEvento.getActionCommand( ) ) )
        {
            principal.buscarJaulaMayorCantidad( );
        }
        else if( BUSCAR_ANIMAL.equals( pEvento.getActionCommand( ) ) )
        {
            principal.buscarAnimal( );
        }
        else if( pEvento.getActionCommand( ).equals( AGREGAR ) )
        {
            DialogoAgregarAnimal dialogo = new DialogoAgregarAnimal( principal );
            dialogo.setVisible( true );
        }
        else if( pEvento.getActionCommand( ).equals( ELIMINAR ) )
        {
            principal.eliminarAnimal( );
        }
        else if(pEvento.getActionCommand( ).equals( JAULA_MISMA_CANTIDAD ))
        {
            principal.exitenJaulasConMismaCantidadAnimales( );
        }
    }
}