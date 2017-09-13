/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
     * Constante que representa el comando opci�n 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Constante que representa el comando opci�n 2.
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
     * Ventana principal de la aplicaci�n.
     */
    private InterfazCupiZoologico principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para opci�n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot�n para opci�n 2.
     */
    private JButton btnOpcion2;

    /**
     * Bot�n para agregar.
     */
    private JButton btnAgregar;

    /**
     * Bot�n para eliminar.
     */
    private JButton btnEliminar;

    /**
     * Bot�n para mayor cantidad.
     */
    private JButton btnMayorCantidad;

    /**
     * Bot�n para misma cantidad.
     */
    private JButton btnMismaCantidad;

    /**
     * Bot�n para buscar animal.
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
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
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
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa el panel que contiene los botones para las consultas.
     */
    public void inicializarPanelBusquedas( )
    {
        panelBusquedas = new JPanel( );
        panelBusquedas.setLayout( new GridLayout( 1, 4 ) );

        // Bot�n Agregar Animal
        btnAgregar = new JButton( "Agregar animal" );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );
        panelBusquedas.add( btnAgregar );

        // Bot�n Eliminar Animal
        btnEliminar = new JButton( "Eliminar animal" );
        btnEliminar.setActionCommand( ELIMINAR );
        btnEliminar.addActionListener( this );
        panelBusquedas.add( btnEliminar );

        // Bot�n Buscar Animal
        btnBuscarAnimal = new JButton( "Buscar animal" );
        btnBuscarAnimal.setActionCommand( BUSCAR_ANIMAL );
        btnBuscarAnimal.addActionListener( this );
        panelBusquedas.add( btnBuscarAnimal );

        // Bot�n Mayor Cantidad
        btnMayorCantidad = new JButton( "Jaula m�s poblada" );
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

        // Bot�n Misma Cantidad
        btnMismaCantidad = new JButton( "Jaulas con misma cantidad" );
        btnMismaCantidad.setActionCommand( JAULA_MISMA_CANTIDAD );
        btnMismaCantidad.addActionListener( this );
        panelOpciones.add( btnMismaCantidad );

        // Bot�n opci�n 1
        btnOpcion1 = new JButton( "Opci�n 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        panelOpciones.add( btnOpcion1 );

        // Bot�n opci�n 2
        btnOpcion2 = new JButton( "Opci�n 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        panelOpciones.add( btnOpcion2 );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
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