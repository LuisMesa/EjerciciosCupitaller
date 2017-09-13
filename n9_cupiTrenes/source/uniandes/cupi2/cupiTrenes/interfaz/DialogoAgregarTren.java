/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_cupiTrenes
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiTrenes.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Di�logo para agregar un tren.
 */
public class DialogoAgregarTren extends JDialog implements ActionListener, ListSelectionListener
{
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa el comando para agregar.
     */
    private final static String AGREGAR = "Agregar";
    
    private final static String CANCELAR = "Cancelar";


    // Atributos
    // -------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazCupiTrenes principal;

    /**
     * Cantidad de paradas del tren.
     */
    private int cantidadParadas;


    // Atributos de la interfaz
    // -------------------------------------------------------------
    private JLabel idTren,numVagon,cantidadSillas,clase,precio;
    
    private JTextField tNumVagones, tCantidadSillas, tPrecio;
    
    private JList listaIds,listaClases;
    
    private JScrollPane scroll,scroll2 ;

    private JButton agregar, cancelar;
    // Constructores
    // -------------------------------------------------------------

    /**
     * Construye un di�logo para agregar un tren.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     * @param pCantidadParadas Cantidad de paradas. pCantidadParadas >= 2.
     */
    public DialogoAgregarTren( InterfazCupiTrenes pPrincipal, int pCantidadParadas )
    {
        principal = pPrincipal;
        cantidadParadas = pCantidadParadas;
        setTitle( "Agregar un tren" );
        setSize( 300, 250);

        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,2));

        idTren = new JLabel("Id del tren :");
        panel.add(idTren);
        
        listaIds=new JList();
        listaIds.addListSelectionListener(this);

        //TODO Parte5 PuntoC Inicialice el scroll.
        scroll = new JScrollPane(listaIds);
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        panel.add(scroll);
        
        numVagon = new JLabel("N�mero de vagon :");
        panel.add(numVagon);
        tNumVagones = new JTextField();
        panel.add(tNumVagones);
        
        clase = new JLabel("Clase :");
        panel.add(clase);
        
        listaClases=new JList();
        listaClases.addListSelectionListener(this);

        //TODO Parte5 PuntoC Inicialice el scroll.
        scroll2 = new JScrollPane(listaClases);
        scroll2.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll2.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        panel.add(scroll2);
        
        precio = new JLabel("Precio :");
        panel.add(precio);
        tPrecio = new JTextField();
        panel.add(tPrecio);
        

        agregar = new JButton("Agregar");
        agregar.setActionCommand(AGREGAR);
        agregar.addActionListener(this);
        panel.add(agregar);
        
        cancelar = new JButton("Cancelar");
        cancelar.setActionCommand(CANCELAR);
        cancelar.addActionListener(this);
        panel.add(cancelar);
        
        add( panel );
    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    public void refrescarLista( ArrayList pListaVinos )
    {
        //TODO Parte5 PuntoD Complete el m�todo seg�n la documentaci�n dada. El vino seleccionado debe ser el 0 de la lista.
    	listaIds.clearSelection();
    	listaIds.setListData( pListaVinos.toArray( ) );
    	listaIds.setSelectedIndex(0);
    }
    
    public void valueChanged( ListSelectionEvent pEvento )
    {
        //TODO Parte5 PuntoE Complete el m�todo seg�n la documentaci�n dada.
    	if(listaIds.getSelectedValue()!=null)
    	{
    		String vino = (String)listaIds.getSelectedValue();
    		
    	}
    }
    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( AGREGAR.equals( comando ) )
        {
        	
        }
        else if(CANCELAR.equals(comando))
        {
        	this.setVisible(false);
        	this.dispose();
        }
    }
}
