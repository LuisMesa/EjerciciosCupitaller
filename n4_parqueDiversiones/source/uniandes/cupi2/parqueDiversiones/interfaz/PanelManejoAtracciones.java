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
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Panel para el manejo de las atracciones.
 */
public class PanelManejoAtracciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para agregar una atracción.
     */
    public final static String AGREGAR = "Agregar atracción";

    /**
     * Comando para eliminar una atracción.
     */
    public final static String ELIMINAR = "Eliminar atracción";

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
     * Botón para agregar una atracción.
     */
    private JButton btnAgregarAtraccion;

    /**
     * Botón para eliminar una atracción.
     */
    private JButton btnEliminarAtraccion;

    /**
     * Lista para ver las atracciones del parque.
     */
    private JList listaAtracciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel para mostrar las opciones de manejo de atracciones.
     * @param pPrincipal Ventana principal de la aplicación.
     */
    public PanelManejoAtracciones( InterfazParqueDiversiones pPrincipal )
    {
        principal = pPrincipal;
        setBorder( BorderFactory.createTitledBorder( "Atracciones" ) );

        setLayout( new BorderLayout( ) );

        listaAtracciones = new JList( );
        listaAtracciones.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        
        JScrollPane scroll = new JScrollPane( listaAtracciones );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );

        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new GridLayout( 2, 1 ) );

        btnAgregarAtraccion = new JButton( "Agregar atracción" );
        btnAgregarAtraccion.setActionCommand( AGREGAR );
        btnAgregarAtraccion.addActionListener( this );
        panelSur.add( btnAgregarAtraccion );

        btnEliminarAtraccion = new JButton( "Eliminar atracción" );
        btnEliminarAtraccion.setActionCommand( ELIMINAR );
        btnEliminarAtraccion.addActionListener( this );
        panelSur.add( btnEliminarAtraccion );

        add( scroll, BorderLayout.CENTER );
        add( panelSur, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de atracciones que se está mostrando.
     * @param pListaAtracciones Lista con las atracciones que deben mostrarse. pListaAtracciones != null.
     */
    public void refrescarLista( ArrayList pListaAtracciones )
    {
        listaAtracciones.setListData( pListaAtracciones.toArray( ) );
        listaAtracciones.setSelectedIndex( 0 );
    }
    
    /**
     * Método que recoge las acciones sobre los objetos que está escuchando.
     * @param pEvento Evento que se realizó. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( AGREGAR.equals( comando ) )
        {
            principal.mostrarDialogoAgregarAtraccion( );
        }
        else if( ELIMINAR.equals( comando ) )
        {
            principal.eliminarAtraccion( );
        }

    }
}
