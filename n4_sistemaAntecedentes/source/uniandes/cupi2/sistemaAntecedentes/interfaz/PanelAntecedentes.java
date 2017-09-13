/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: sistemaAntecedentes
 * Autor: Equipo Cupi2 2015.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sistemaAntecedentes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.sistemaAntecedentes.mundo.Antecedente;
import uniandes.cupi2.sistemaAntecedentes.mundo.SistemaAntecedentes;

/**
 * Panel con la información de los antecedentes de un procesado.
 */
public class PanelAntecedentes extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando agregar antecedente.
     */
    private final static String AGREGAR_ANTECEDENTE = "Agregar";

    /**
     * Constante que representa el comando eliminar antecedente.
     */
    private final static String ELIMINAR_ANTECEDENTE = "Eliminar";

    /**
     * Constante que representa el comando para ver la descripción del antecedente.
     */
    private final static String VER_DESCRIPCION = "Ver";
    
    /**
     * Constante que representa el comando para condenar al procesado por el antecedente.
     */
    private final static String CONDENAR = "Cambiar condena";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazSistemaAntecedentes principal;

    /**
     * Diálogo que muestra la descripción de un antecedente.
     */
    private DialogoDescripcionAntecedente dialogoDescripcionAntecedente;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Lista de antecedentes.
     */
    private JList listaAntecedentes;

    /**
     * Scrollpane de la lista de antecedentes.
     */
    private JScrollPane scroll;

    /**
     * Botón para agregar un antecedente.
     */
    private JButton btnAgregarAntecedente;

    /**
     * Botón para eliminar un antecedente.
     */
    private JButton btnEliminarAntecedente;

    /**
     * Botón para ver la descripción.
     */
    private JButton btnVerDescripcion;
    
    /**
     * Botón para condenar por un antecedente.
     */
    private JButton btnCondenar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel con la información de los antecedentes de un procesado.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelAntecedentes( InterfazSistemaAntecedentes pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );
        setPreferredSize( new Dimension( 200, 0 ) );

        TitledBorder border = BorderFactory.createTitledBorder( "Antecedentes" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );

        listaAntecedentes = new JList( );
        listaAntecedentes.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );

        scroll = new JScrollPane( listaAntecedentes );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );

        add( scroll, BorderLayout.CENTER );

        JPanel aux = new JPanel( );
        aux.setLayout( new GridLayout( 1, 2 ) );

        btnAgregarAntecedente = new JButton( AGREGAR_ANTECEDENTE );
        btnAgregarAntecedente.setActionCommand( AGREGAR_ANTECEDENTE );
        btnAgregarAntecedente.addActionListener( this );
        btnAgregarAntecedente.setEnabled( false );
        aux.add( btnAgregarAntecedente );

        btnEliminarAntecedente = new JButton( ELIMINAR_ANTECEDENTE );
        btnEliminarAntecedente.setActionCommand( ELIMINAR_ANTECEDENTE );
        btnEliminarAntecedente.addActionListener( this );
        btnEliminarAntecedente.setEnabled( false );
        aux.add( btnEliminarAntecedente );

        JPanel aux2 = new JPanel( );
        aux2.setLayout( new GridLayout( 1, 2 ) );
        
        btnCondenar = new JButton( CONDENAR );
        btnCondenar.setActionCommand( CONDENAR );
        btnCondenar.addActionListener( this );
        btnCondenar.setEnabled( false );
        aux2.add( btnCondenar );

        btnVerDescripcion = new JButton( VER_DESCRIPCION );
        btnVerDescripcion.setActionCommand( VER_DESCRIPCION );
        btnVerDescripcion.addActionListener( this );
        btnVerDescripcion.setEnabled( false );
        aux2.add( btnVerDescripcion );
        
        JPanel aux3 = new JPanel( );
        aux3.setLayout( new GridLayout( 2, 1 ) );
        aux3.add( aux2 );
        aux3.add( aux );

        add( aux3, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de antecedentes que se está mostrando.
     * @param pLista es una lista con los antecedentes que deben mostrarse.
     */
    public void actualizar( ArrayList pLista )
    {
        if( pLista != null )
        {
            listaAntecedentes.setListData( pLista.toArray( ) );
            listaAntecedentes.setSelectedIndex( 0 );
            btnAgregarAntecedente.setEnabled( true );
            btnEliminarAntecedente.setEnabled( true );
            btnVerDescripcion.setEnabled( true );
            btnCondenar.setEnabled( true );
        }
        else
        {
            listaAntecedentes.setListData( new ArrayList( ).toArray( ) );
            btnAgregarAntecedente.setEnabled( false );
            btnEliminarAntecedente.setEnabled( false );
            btnVerDescripcion.setEnabled( false );
            btnCondenar.setEnabled( false );
        }
    }

    /**
     * Muestra la descripción del antecedente que se está mostrando de acuerdo al nuevo antecedente seleccionado.
     */
    public void verDescripcion( )
    {
        if( listaAntecedentes.getSelectedValue( ) != null )
        {
            Antecedente antecedente = ( Antecedente )listaAntecedentes.getSelectedValue( );
            dialogoDescripcionAntecedente = new DialogoDescripcionAntecedente( principal, antecedente.darIdentificador( ), antecedente.darTipo( ), antecedente.darGravedad( ), antecedente.darAnhosCondena( ), antecedente.darDescripcion( ) );
            dialogoDescripcionAntecedente.setVisible( true );
        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AGREGAR_ANTECEDENTE ) )
        {
            principal.abrirDialogoAgregarAntecedente( );
        }
        else if( comando.equals( ELIMINAR_ANTECEDENTE ) )
        {
            if( listaAntecedentes.getSelectedValue( ) != null )
            {
                principal.eliminarAntecedente( ( ( Antecedente )listaAntecedentes.getSelectedValue( ) ).darIdentificador( ) );
            }
        }
        else if( comando.equals( VER_DESCRIPCION ) )
        {
            verDescripcion( );
        }
        else if( comando.equals( CONDENAR ) )
        {
            if( listaAntecedentes.getSelectedValue( ) != null )
            {
                Antecedente actual = ( Antecedente )listaAntecedentes.getSelectedValue( );
                String anhosCondena = JOptionPane.showInputDialog( principal, "Años de condena: " );
                if(anhosCondena != null)
                {
                    int condena = -1;
                    try
                    {
                        condena = Integer.parseInt( anhosCondena );
                    }
                    catch( NumberFormatException pNumberFormatEx )
                    {
                        JOptionPane.showMessageDialog( this, "La condena debe ser un valor numérico.", "Condenar procesado", JOptionPane.ERROR_MESSAGE );
                    }
                    
                    try
                    {
                        principal.condenarProcesado( condena, actual.darIdentificador( ) );
                    }
                    catch( Exception pExcepcion )
                    {
                        JOptionPane.showMessageDialog( this, pExcepcion.getMessage( ), "Condenar procesado", JOptionPane.ERROR_MESSAGE );
                    }
                }
            }
        }
    }
}
