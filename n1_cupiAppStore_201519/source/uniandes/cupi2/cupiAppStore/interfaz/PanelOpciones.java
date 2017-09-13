/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_cupiAppStore
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupiAppStore.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de las opciones.
 */
public class PanelOpciones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la Opci�n 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Constante para la Opci�n 2.
     */
    private static final String OPCION_2 = "OPCION_2";
    
    /**
     * Constante para  mostrar el descuento dependiendo de las ventas en volumen.
     */
    private static final String PROMO_VOLUMEN = "PROMOVOLUMEN";
    
    /**
     * Constante para mostrar el dinero promedio recaudado por los juegos por las ventas realizadas.
     */
    private static final String DINERO_PROMEDIO = "DINEROPROMEDIO";


    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazCupiAppStore principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n Opci�n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot�n Opci�n 2.
     */
    private JButton btnOpcion2;
    
    /**
     * Bot�n para cotizar promoci�n.
     */
    private JButton btnPromocion;
    
    /**
     * Bot�n para calcular el dinero promedio.
     */
    private JButton btnPrecioPromedio;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal.
     */
    public PanelOpciones( InterfazCupiAppStore pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 2,5,5 ) );

        // Bot�n para mostrar promociones por ventas en volumen
        btnPromocion = new JButton( "Descuentos por volumen" );
        btnPromocion.setActionCommand( PROMO_VOLUMEN );
        btnPromocion.addActionListener( this );
        add( btnPromocion );
        
        // Bot�n para mostrar promociones por ventas en volumen
        btnPrecioPromedio = new JButton( "Dinero promedio" );
        btnPrecioPromedio.setActionCommand( DINERO_PROMEDIO );
        btnPrecioPromedio.addActionListener( this );
        add( btnPrecioPromedio );
        
        
        // Bot�n opci�n 1
        btnOpcion1 = new JButton( "Opci�n 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        // Bot�n opci�n 2
        btnOpcion2 = new JButton( "Opci�n 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );

        
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( OPCION_1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( comando.equals( PROMO_VOLUMEN ) )
        {
            principal.mostrarDialogoDescuentos( );
        }
        else if( comando.equals( DINERO_PROMEDIO ) )
        {
            principal.darDineroPromedio( );
        }
    }

}
