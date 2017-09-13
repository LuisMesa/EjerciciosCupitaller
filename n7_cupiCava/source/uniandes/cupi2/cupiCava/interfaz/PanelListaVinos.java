/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.cupiCava.mundo.Vino;


/**
 * Panel con la lista de vinos de la cava.
 */
public class PanelListaVinos extends JPanel implements ListSelectionListener, ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando de agregar un vino.
     */
    private final static String AGREGAR = "Agregar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazCupiCava principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Lista de los vinos.
     */
    //TODO Parte5 PuntoA Declare el atributo listaVinos de tipo JList.
    private JList listaVinos;

    /**
     * Panel con un scroll que contiene a listaVinos.
     */
    private JScrollPane scroll;

    /**
     * Bot�n para agregar un nuevo vino.
     */
    private JButton botonAgregar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelListaVinos( InterfazCupiCava pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 5, 0, 5 ), new TitledBorder( "Lista de vinos" ) ) );
        setPreferredSize( new Dimension( 250, 0 ) );

        //TODO Parte5 PuntoB Inicialice la listaVinos.
        listaVinos=new JList();
        listaVinos.addListSelectionListener(this);

        //TODO Parte5 PuntoC Inicialice el scroll.
        scroll = new JScrollPane(listaVinos);
        scroll.setHorizontalScrollBarPolicy(                 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy(                 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        

        botonAgregar = new JButton( AGREGAR );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        

        add( scroll, BorderLayout.CENTER );
        //add(listaVinos, BorderLayout.CENTER);
        add( botonAgregar, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de vinos con la lista recibida por par�metro.
     * @param pListaVinos Lista de los vinos. pListaVinos != null.
     */
    public void refrescarLista( ArrayList pListaVinos )
    {
        //TODO Parte5 PuntoD Complete el m�todo seg�n la documentaci�n dada. El vino seleccionado debe ser el 0 de la lista.
    	listaVinos.clearSelection();
    	listaVinos.setListData( pListaVinos.toArray( ) );
    	listaVinos.setSelectedIndex(0);
    }

    /**
     * Actualiza el vino seleccionado.
     * @param pNombreVino Nombre del vino seleccionado. pNombreVino != null && pNombreVino != "".
     */
    public void seleccionar( String pNombreVino )
    {
        int indice = -1;
        ListModel model = listaVinos.getModel( );
        for( int i = 0; i < model.getSize( ); i++ )
        {
            String vinoActual = ( String )model.getElementAt( i );
            if( vinoActual.equals( pNombreVino ) )
            {
                indice = i;
            }
        }

        listaVinos.setSelectedIndex( indice );
        listaVinos.ensureIndexIsVisible( indice );
    }

    /**
     * Atiende el evento cuando el usuario selecciona un vino de la lista.
     * @param pEvento Evento de selecci�n de un elemento de la lista de vinos. pEvento != null.
     */
    public void valueChanged( ListSelectionEvent pEvento )
    {
        //TODO Parte5 PuntoE Complete el m�todo seg�n la documentaci�n dada.
    	if(listaVinos.getSelectedValue()!=null)
    	{
    		String vino = (String)listaVinos.getSelectedValue();
    		principal.actualizarInfoVino(vino);
    	}
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AGREGAR ) )
        {
            DialogoAgregarVino dialogoAgregar = new DialogoAgregarVino( principal );
            dialogoAgregar.setVisible( true );
        }
    }

}