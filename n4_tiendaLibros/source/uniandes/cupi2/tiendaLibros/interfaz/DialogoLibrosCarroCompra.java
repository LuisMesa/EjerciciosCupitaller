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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uniandes.cupi2.tiendaLibros.mundo.ItemCompra;
import uniandes.cupi2.tiendaLibros.mundo.Libro;

/**
 * Diálogo para agregar y eliminar libros a un carro de compras.
 */
public class DialogoLibrosCarroCompra extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para agregar un libro.
     */
    private static final String AGREGAR = "Agregar";

    /**
     * Constante para eliminar un libro.
     */
    private static final String ELIMINAR = "Eliminar";

    /**
     * Constante para finalizar la modificación del carro de compras y cerrar el diálogo.
     */
    private static final String FINALIZAR = "Finalizar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazTiendaLibros principal;

    /**
     * Cédula del dueño del carro.
     */
    private String cedula;

    /**
     * Libros incluidos en el carro de compras.
     */
    private Vector librosIncluidos;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Lista donde se muestran los libros existentes en la tienda.
     */
    private JList listaLibros;

    /**
     * Botón para agregar un libro a la lista.
     */
    private JButton btnAgregar;

    /**
     * Botón para eliminar un libro de la lista.
     */
    private JButton btnEliminar;

    /**
     * Botón para cerrar el diálogo
     */
    private JButton btnFinalizar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el diálogo para la visualización de los libros añadidos al carro.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     * @param pCedula Cédula del dueño del carro.
     */
    public DialogoLibrosCarroCompra( InterfazTiendaLibros pPrincipal, String pCedula )
    {
        principal = pPrincipal;
        cedula = pCedula;
        librosIncluidos = new Vector( );

        setTitle( "Libros seleccionados" );
        setLayout( new BorderLayout( ) );

        listaLibros = new JList( );
        JScrollPane scroll = new JScrollPane( );
        scroll.setViewportView( listaLibros );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        scroll.setPreferredSize( new Dimension( 300, 160 ) );
        add( scroll, BorderLayout.CENTER );

        btnAgregar = new JButton( "Agregar" );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );

        btnEliminar = new JButton( "Eliminar" );
        btnEliminar.setActionCommand( ELIMINAR );
        btnEliminar.addActionListener( this );

        btnFinalizar = new JButton( "Finalizar" );
        btnFinalizar.setActionCommand( FINALIZAR );
        btnFinalizar.addActionListener( this );

        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new GridLayout( 1, 3 ) );
        panelSur.add( btnAgregar );
        panelSur.add( btnEliminar );
        panelSur.add( btnFinalizar );
        add( panelSur, BorderLayout.SOUTH );

        for( int i = 0; i < principal.darLibrosIncluidosCarroCompras( cedula ).size( ); i++ )
        {
            ItemCompra actualIC = (ItemCompra) principal.darLibrosIncluidosCarroCompras( cedula ).get( i );
            Libro actual = actualIC.darLibro( );
            librosIncluidos.add( actual.darTitulo( ) + "(" + actual.darISBN( ) + ")" );
        }
        listaLibros.setListData( librosIncluidos );

        pack( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AGREGAR ) )
        {
            Object[] possibilities = new Object[principal.darLibrosTienda( ).size( )];
            for( int i = 0; i < principal.darLibrosTienda( ).size( ); i++ )
            {
                Libro actual = ( Libro )principal.darLibrosTienda( ).get( i );
                possibilities[ i ] = actual.darTitulo( ) + "-" + actual.darISBN( );
            }

            if( possibilities.length > 0 )
            {
                String nombreLibro = ( String )JOptionPane.showInputDialog( this, "Libros disponibles:", "Agregar libro a carro de compras", JOptionPane.INFORMATION_MESSAGE, null, possibilities, possibilities[ 0 ] );
                if( nombreLibro != null )
                {
                    String cantidad = JOptionPane.showInputDialog( this, "Ingrese la cantidad solicitada.", "Agregar libro a carro de compras", JOptionPane.QUESTION_MESSAGE );

                    if( cantidad != null && !cantidad.equals( "" ) )
                    {
                        try
                        {
                            String[] partes = nombreLibro.split( "-" );
                            int cantidadSolicitada = Integer.parseInt( cantidad );
                            if(cantidadSolicitada>0)
                            {
                                principal.agregarItemCompraACarro( partes[ 1 ], cedula, cantidadSolicitada );
                                librosIncluidos = new Vector( );
                                for( int i = 0; i < principal.darLibrosIncluidosCarroCompras( cedula ).size( ); i++ )
                                {
                                    ItemCompra actual = ( ItemCompra )principal.darLibrosIncluidosCarroCompras( cedula ).get( i );
                                    librosIncluidos.add( actual.darLibro( ).darISBN( ) );
                                }
                                listaLibros.setListData( librosIncluidos );
                            }
                            else
                            {
                                JOptionPane.showMessageDialog( this, "La cantidad solicitada deber ser un número positivo.", "Agregar libro a carro de compras", JOptionPane.ERROR_MESSAGE );
                            }
                        }
                        catch( Exception e )
                        {
                            e.printStackTrace( );
                            JOptionPane.showMessageDialog( this, "La cantidad solicitada deber ser un número.", "Agregar libro a carro de compras", JOptionPane.ERROR_MESSAGE );
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad.", "Agregar libro a carro de compras", JOptionPane.ERROR_MESSAGE );
                    }

                }
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No hay libros en la tienda.", "Agregar libro a carro de compras", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( comando.equals( ELIMINAR ) )
        {
            if( listaLibros.getSelectedValue( ) != null )
            {
                String seleccionado = listaLibros.getSelectedValue( ).toString( );
                principal.eliminarItemCompraDeCarro( cedula, seleccionado );
                librosIncluidos.remove( seleccionado );
                listaLibros.setListData( librosIncluidos );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Debe seleccionar una libro de la lista.", "Eliminar libro de carro de compras", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( comando.equals( FINALIZAR ) )
        {
            dispose( );
        }

    }
}
