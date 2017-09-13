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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel que muestra las opciones de filtro para los carros de compras.
 */
public class PanelConsultas extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para consultar todos los carros de compras.
     */
    public final static String TODOS_LOS_CARROS = "Ver todos los carros";

    /**
     * Constante para consultar los carros de compras en elaboración.
     */
    public final static String ELABORACION = "Ver carros en elaboración";

    /**
     * Constante para consultar los carros de compras vendidos.
     */
    public final static String VENDIDOS = "Ver carros vendidos";

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
     * Botón para consultar todos los carros de compras de la tienda.
     */
    private JButton btnTodosLosCarros;

    /**
     * Botón para consultar los carros de compras en elaboración.
     */
    private JButton btnCarrosElaboracion;

    /**
     * Botón para consultar los carros de compras vendidos.
     */
    private JButton btnCarrosVendidos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel para mostrar las opciones disponibles.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelConsultas( InterfazTiendaLibros pPrincipal )
    {
        principal = pPrincipal;
        setBorder( new TitledBorder( "Consultas" ) );
        setLayout( new GridLayout( 1, 3 ) );

        btnTodosLosCarros = new JButton( "Todos los carros" );
        btnTodosLosCarros.setActionCommand( TODOS_LOS_CARROS );
        btnTodosLosCarros.addActionListener( this );
        add( btnTodosLosCarros );

        btnCarrosElaboracion = new JButton( "Carros en elaboración" );
        btnCarrosElaboracion.setActionCommand( ELABORACION );
        btnCarrosElaboracion.addActionListener( this );
        add( btnCarrosElaboracion );

        btnCarrosVendidos = new JButton( "Carros vendidos" );
        btnCarrosVendidos.setActionCommand( VENDIDOS );
        btnCarrosVendidos.addActionListener( this );
        add( btnCarrosVendidos );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( TODOS_LOS_CARROS ) )
        {
            principal.mostrarTodosLosCarrosCompras( );
        }
        else if( comando.equals( ELABORACION ) )
        {
            principal.mostrarPasaportesEnElaboracion( );
        }
        else if( comando.equals( VENDIDOS ) )
        {
            principal.mostrarPasaportesVendidos( );
        }
    }

}
