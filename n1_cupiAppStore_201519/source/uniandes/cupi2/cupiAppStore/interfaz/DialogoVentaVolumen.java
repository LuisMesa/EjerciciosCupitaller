/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_cupiAppStore
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupiAppStore.interfaz;

import javax.swing.JDialog;

/**
 * Dialogo que se muestra cuando se quiere obtener descuentos por volumen.
 */
public class DialogoVentaVolumen extends JDialog
{

    
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel donde se seleccionan las cantidades a comprar de celulares.
     */
    private PanelVentaVolumen panelVentaVolumen;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Instancia de la ventana principal del programa.
     */
    private InterfazCupiAppStore principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Instancia y coloca el panel donde se seleccionan las cantidades de juegos a comprar.
     * @param ventanaPrincipal Instancia de la ventana principal de la aplicación. 
     */
    public DialogoVentaVolumen( InterfazCupiAppStore ventanaPrincipal )
    {
        principal = ventanaPrincipal;
        panelVentaVolumen = new PanelVentaVolumen( this );
        setTitle( "Consultar descuento" );
        setLocationRelativeTo( ventanaPrincipal );
        add( panelVentaVolumen );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        pack( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método que se llama cuando el usuario hace click en el botón cancelar.
     */
    public void cancelar( )
    {
        dispose( );
    }

    /**
     * Método que se llama cuando el usuario hace click en el botón aceptar.
     * @param pCantidadJuego1 Datos de entrada para cotizar. Cantidad del juego 1.
     * @param pCantidadJuego2 Datos de entrada para cotizar. Cantidad del juego 2.
     * @param pCantidadJuego3 Datos de entrada para cotizar. Cantidad del juego 3.
     */
    public void aceptar( int pCantidadJuego1, int pCantidadJuego2, int pCantidadJuego3 )
    {
        principal.consultarDescuento( pCantidadJuego1, pCantidadJuego2, pCantidadJuego3 );
        dispose( );
    }

    /**
     * Devuelve el nombre del juego 1.
     * @return String con el nombre del juego 1.
     */
    public String obtenerNombreJuego1( )
    {
        return principal.darNombreJuego1( );
    }

    /**
     * Devuelve el nombre del juego 2.
     * @return String con el nombre del juego 2.
     */
    public String obtenerNombreJuego2( )
    {
        return principal.darNombreJuego2( );
    }

    /**
     * Devuelve el nombre del juego 3.
     * @return String con el nombre del juego 3.
     */
    public String obtenerNombreJuego3( )
    {
        return principal.darNombreJuego3( );
    }

}
