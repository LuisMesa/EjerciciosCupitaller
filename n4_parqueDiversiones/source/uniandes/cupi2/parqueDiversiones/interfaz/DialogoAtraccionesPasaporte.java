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

import uniandes.cupi2.parqueDiversiones.mundo.Atraccion;

/**
 * Diálogo para agregar atracciones a un pasaporte.
 */
public class DialogoAtraccionesPasaporte extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para agregar una atracción.
     */
    private static final String AGREGAR = "Agregar";

    /**
     * Constante para eliminar una atracción.
     */
    private static final String ELIMINAR = "Eliminar";

    /**
     * Constante para finalizar la modificación del pasaporte y cerrar el diálogo.
     */
    private static final String FINALIZAR = "Finalizar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazParqueDiversiones principal;

    /**
     * Cédula del cliente dueño del pasaporte.
     */
    private int cedula;

    /**
     * Atracciones incluidas en el pasaporte.
     */
    private Vector atraccionesIncluidas;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Lista donde se muestran las atracciones existentes en el parque.
     */
    private JList listaAtracciones;

    /**
     * Botón para agregar una atracción a la lista.
     */
    private JButton btnAgregar;

    /**
     * Botón para eliminar una atracción de la lista.
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
     * Crea el diálogo para la visualización de las atracciones añadidas a un pasaporte.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null
     * @param pCedula Cédula del cliente dueño del pasaporte. pCedula > 0.
     */
    public DialogoAtraccionesPasaporte( InterfazParqueDiversiones pPrincipal, int pCedula )
    {
        principal = pPrincipal;
        cedula = pCedula;
        atraccionesIncluidas = new Vector( );

        setTitle( "Atracciones seleccionadas" );
        setLayout( new BorderLayout( ) );

        listaAtracciones = new JList( );
        JScrollPane scroll = new JScrollPane( );
        scroll.setViewportView( listaAtracciones );
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

        for( int i = 0; i < principal.darAtraccionesIncluidasPasaporte( cedula ).size( ); i++ )
        {
            Atraccion actual = ( Atraccion )principal.darAtraccionesIncluidasPasaporte( cedula ).get( i );
            atraccionesIncluidas.add( actual.darNombre( ) );
        }
        listaAtracciones.setListData( atraccionesIncluidas );

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
            Object[] possibilities = new Object[principal.darAtraccionesParque( ).size( )];
            for( int i = 0; i < principal.darAtraccionesParque( ).size( ); i++ )
            {
                possibilities[ i ] = ( ( Atraccion )principal.darAtraccionesParque( ).get( i ) ).darNombre( );
            }

            String nombreAtraccion = ( String )JOptionPane.showInputDialog( this, "Atracciones disponibles:", "Atracciones", JOptionPane.INFORMATION_MESSAGE, null, possibilities, possibilities[ 0 ] );
            if(nombreAtraccion!=null)
            {
                principal.agregarAtraccionAPasaporte( nombreAtraccion, cedula );
                atraccionesIncluidas = new Vector( );
                for( int i = 0; i < principal.darAtraccionesIncluidasPasaporte( cedula ).size( ); i++ )
                {
                    Atraccion actual = ( Atraccion )principal.darAtraccionesIncluidasPasaporte( cedula ).get( i );
                    atraccionesIncluidas.add( actual.darNombre( ) );
                }
                listaAtracciones.setListData( atraccionesIncluidas );
            }
            

        }
        else if( comando.equals( ELIMINAR ) )
        {
            if( listaAtracciones.getSelectedValue( ) != null )
            {
                String seleccionado = listaAtracciones.getSelectedValue( ).toString( );
                principal.eliminarAtraccionDePasaporte( seleccionado, cedula );
                atraccionesIncluidas.remove( seleccionado );
                listaAtracciones.setListData( atraccionesIncluidas );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Debe seleccionar una atracción de la lista.", "Eliminar atracción", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( comando.equals( FINALIZAR ) )
        {
            dispose( );
        }

    }
}
