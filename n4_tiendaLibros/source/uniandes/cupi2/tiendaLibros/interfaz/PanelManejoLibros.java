/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n4_tiendaLibros
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.tiendaLibros.interfaz;

import java.awt.BorderLayout;
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

/**
 * Panel para el manejo de los libros.
 */
public class PanelManejoLibros extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para agregar un libro .
     */
    public final static String AGREGAR = "Agregar libro";

    /**
     * Comando para eliminar un libro.
     */
    public final static String ELIMINAR = "Eliminar libro";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazTiendaLibros principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para agregar un libro.
     */
    private JButton btnAgregarLibro;

    /**
     * Botón para eliminar un libro.
     */
    private JButton btnEliminarLibro;

    /**
     * Lista para ver los libros de la tienda.
     */
    private JList listaLibros;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel para mostrar las opciones de manejo de libros.
     * @param pPrincipal Ventana principal de la aplicación.
     */
    public PanelManejoLibros( InterfazTiendaLibros pPrincipal )
    {
        principal = pPrincipal;
        setBorder( BorderFactory.createTitledBorder( "Libros" ) );

        setLayout( new BorderLayout( ) );

        listaLibros = new JList( );
        listaLibros.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        
        JScrollPane scroll = new JScrollPane( listaLibros );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );

        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new GridLayout( 2, 1 ) );

        btnAgregarLibro = new JButton( "Agregar libro" );
        btnAgregarLibro.setActionCommand( AGREGAR );
        btnAgregarLibro.addActionListener( this );
        panelSur.add( btnAgregarLibro );

        btnEliminarLibro = new JButton( "Eliminar libro" );
        btnEliminarLibro.setActionCommand( ELIMINAR );
        btnEliminarLibro.addActionListener( this );
        panelSur.add( btnEliminarLibro );

        add( scroll, BorderLayout.CENTER );
        add( panelSur, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de libro que se está mostrando.
     * @param pListaLibros Lista con los libros que deben mostrarse. pListaLibros != null.
     */
    public void refrescarLista( ArrayList pListaLibros )
    {
        listaLibros.setListData( pListaLibros.toArray( ) );
        listaLibros.setSelectedIndex( 0 );
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
            principal.mostrarDialogoAgregarLibro( );
        }
        else if( ELIMINAR.equals( comando ) )
        {
            principal.eliminarLibro( );
        }

    }
}
