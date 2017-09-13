/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_parqueDiversiones
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.parqueDiversiones.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel que muestra las opciones de filtro para los pasaportes.
 */
public class PanelConsultas extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para consultar todos los pasaportes.
     */
    public final static String TODOS_LOS_PASAPORTES = "Ver todos los pasaportes";

    /**
     * Constante para consultar los pasaporte en elaboraci�n.
     */
    public final static String ELABORACION = "Ver pasaportes en elaboraci�n";

    /**
     * Constante para consultar los pasaportes vendidos.
     */
    public final static String VENDIDOS = "Ver pasaportes vendidos";

    /**
     * Constante para consultar el dinero en caja.
     */
    public final static String DINERO = "Ver dinero en caja";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazParqueDiversiones principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para consultar todos los pasaportes del parque de diversiones.
     */
    private JButton btnTodosLosPasaportes;

    /**
     * Bot�n para consultar los pasaporte en elaboraci�n.
     */
    private JButton btnPasaportesElaboracion;

    /**
     * Bot�n para consultar los pasaportes vendidos.
     */
    private JButton btnPasaportesVendidos;

    /**
     * Bot�n para consultar el dinero en caja.
     */
    private JButton btnDineroCaja;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel para mostrar las opciones disponibles.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelConsultas( InterfazParqueDiversiones pPrincipal )
    {
        principal = pPrincipal;
        setBorder( new TitledBorder( "Consultas" ) );
        setLayout( new GridLayout( 1, 4 ) );

        btnTodosLosPasaportes = new JButton( "Todos los pasaportes" );
        btnTodosLosPasaportes.setActionCommand( TODOS_LOS_PASAPORTES );
        btnTodosLosPasaportes.addActionListener( this );
        add( btnTodosLosPasaportes );

        btnPasaportesElaboracion = new JButton( "Pasaportes elaboraci�n" );
        btnPasaportesElaboracion.setActionCommand( ELABORACION );
        btnPasaportesElaboracion.addActionListener( this );
        add( btnPasaportesElaboracion );

        btnPasaportesVendidos = new JButton( "Pasaportes vendidos" );
        btnPasaportesVendidos.setActionCommand( VENDIDOS );
        btnPasaportesVendidos.addActionListener( this );
        add( btnPasaportesVendidos );

        btnDineroCaja = new JButton( "Dinero en caja" );
        btnDineroCaja.setActionCommand( DINERO );
        btnDineroCaja.addActionListener( this );
        add( btnDineroCaja );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( TODOS_LOS_PASAPORTES ) )
        {
            principal.mostrarTodosLosPasaportes( );
        }
        else if( comando.equals( ELABORACION ) )
        {
            principal.mostrarPasaportesEnElaboracion( );
        }
        else if( comando.equals( VENDIDOS ) )
        {
            principal.mostrarPasaportesVendidos( );
        }
        else if( comando.equals( DINERO ) )
        {
            principal.mostrarDineroCaja( );
        }
    }

}
