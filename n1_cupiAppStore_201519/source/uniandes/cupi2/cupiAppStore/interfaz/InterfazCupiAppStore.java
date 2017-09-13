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

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.cupiAppStore.mundo.*;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazCupiAppStore extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para identificar los juegos de categoría rompecabezas.
     */
    public static final String ROMPECABEZAS = "Rompecabezas";

    /**
     * Constante para identificar los juegos de categoría acción.
     */
    public static final String ACCION = "Acción";

    /**
     * Constante para identificar los juegos de categoría deporte.
     */
    public static final String DEPORTE = "Deporte";

    /**
     * Nombre del juego 1.
     */
    public static final String NOMBRE_JUEGO_1 = "Candy Crush";

    /**
     * Nombre del juego 2.
     */
    public static final String NOMBRE_JUEGO_2 = "Clash Of Clans";

    /**
     * Nombre del juego 3.
     */
    public static final String NOMBRE_JUEGO_3 = "Fifa 15";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private AppStore appStore;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen del encabezado.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con las opciones.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel para visualizar la información de los juegos.
     */
    private PanelJuegos panelJuegos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana principal de la aplicación.<br>
     */
    public InterfazCupiAppStore( )
    {
        // Crea la clase principal
        appStore = new AppStore( );
        appStore.inicializar( );

        // Construye la forma
        setLayout( new BorderLayout( ) );
        setSize( 750, 530 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        setTitle( "Cupi App Store" );
        setResizable( false );

        // Creacion de los paneles aquí

        // --Creación del panel Imagen
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        // --Creación del panel de las opciones
        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.SOUTH );

        // --Creación del panel de Juegos
        ArrayList nombresJuegos = new ArrayList( );
        nombresJuegos.add( NOMBRE_JUEGO_1 );
        nombresJuegos.add( NOMBRE_JUEGO_2 );
        nombresJuegos.add( NOMBRE_JUEGO_3 );
        panelJuegos = new PanelJuegos( this, nombresJuegos );
        add( panelJuegos, BorderLayout.CENTER );
        cambiarJuegoSeleccionado( ( ( String )nombresJuegos.get( 0 ) ) );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de juegos que hay en la empresa de acuerdo al nombre del juego. <br>
     * @param pNombreJuego Nombre del juego.
     * @return Cantidad de unidades del juego.
     */
    public int darCantidadJuego( String pNombreJuego )
    {

        int cantidadActual = 0;
        if( appStore.darJuego1( ).darNombre( ).equals( pNombreJuego ) )
        {
            cantidadActual = appStore.darCantidadActualJuego1( );
        }
        else if( appStore.darJuego2( ).darNombre( ).equals( pNombreJuego ) )
        {
            cantidadActual = appStore.darCantidadActualJuego2( );
        }
        else if( appStore.darJuego3( ).darNombre( ).equals( pNombreJuego ) )
        {
            cantidadActual = appStore.darCantidadActualJuego3( );
        }
        return cantidadActual;
    }

    /**
     * Cantidad promedio de dinero recaudado por los juegos vendidos. <br>
     */
    public void darDineroPromedio( )
    {

        String resultado = "El dinero promedio recaudado por los juegos es: " + formatearValorPesos( appStore.darDineroPromedio( ) ) + ".";
        JOptionPane.showMessageDialog( this, resultado, "Dinero promedio", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Devuelve el valor de la constante que define el nombre del juego 1.
     * @return nombre del juego 1.
     */
    public String darNombreJuego1( )
    {
        return NOMBRE_JUEGO_1;
    }

    /**
     * Devuelve el valor de la constante que define el nombre del juego 2.
     * @return nombre del juego 2.
     */
    public String darNombreJuego2( )
    {
        return NOMBRE_JUEGO_2;
    }

    /**
     * Devuelve el valor de la constante que define el nombre del juego 3.
     * @return nombre del juego 3.
     */
    public String darNombreJuego3( )
    {
        return NOMBRE_JUEGO_3;
    }

    /**
     * Cambia el juego seleccionado en el panel de detalles del juego.<br>
     * @param pNombreJuego Nombre del juego a mostrar los detalles.
     */
    public void cambiarJuegoSeleccionado( String pNombreJuego )
    {

        if( appStore.darJuego1( ).darNombre( ).equals( pNombreJuego ) )
        {
            panelJuegos.cambiarJuego( appStore.darJuego1( ).darNombre( ), appStore.darJuego1( ).darCategoria( ), appStore.darJuego1( ).darTamanio( ), appStore.darJuego1( ).darCantidadActual( ), appStore.darJuego1( ).darPrecio( ) );
        }
        else if( appStore.darJuego2( ).darNombre( ).equals( pNombreJuego ) )
        {
            panelJuegos.cambiarJuego( appStore.darJuego2( ).darNombre( ), appStore.darJuego2( ).darCategoria( ), appStore.darJuego2( ).darTamanio( ), appStore.darJuego2( ).darCantidadActual( ), appStore.darJuego2( ).darPrecio( ) );
        }
        else if( appStore.darJuego3( ).darNombre( ).equals( pNombreJuego ) )
        {
            panelJuegos.cambiarJuego( appStore.darJuego3( ).darNombre( ), appStore.darJuego3( ).darCategoria( ), appStore.darJuego3( ).darTamanio( ), appStore.darJuego3( ).darCantidadActual( ), appStore.darJuego3( ).darPrecio( ) );
        }

    }

    /**
     * Calcula el porcentaje de descuento para una compra en volumen.
     * @param pCantidadJuego1 cantidad de unidades que se comprarían del juego 1.
     * @param pCantidadJuego2 cantidad de unidades que se comprarían del juego 2.
     * @param pCantidadJuego3 cantidad de unidades que se comprarían del juego 3.
     */
    public void consultarDescuento( int pCantidadJuego1, int pCantidadJuego2, int pCantidadJuego3 )
    {
        // Total venta
        double totalVenta = 0;

        totalVenta += appStore.darJuego1( ).darPrecio( ) * pCantidadJuego1;
        totalVenta += appStore.darJuego2( ).darPrecio( ) * pCantidadJuego2;
        totalVenta += appStore.darJuego3( ).darPrecio( ) * pCantidadJuego3;

        double descuentoTotal = totalVenta * .3;
        String mensaje = "El valor total de la venta es: $" + totalVenta + ".\n" + "El descuento por la compra es de: $" + descuentoTotal + ".\n" + "El valor total de la compra con descuento es: $"
                + appStore.calcularDescuento( pCantidadJuego1, pCantidadJuego2, pCantidadJuego3 ) + ".";
        JOptionPane.showMessageDialog( this, mensaje, "Resultados", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Vende en la empresa de juegos la cantidad especificada<br>
     * del juego que coincide con el nombre especificado.
     * @param pNombreJuego Nombre del juego que se quiere vender.
     * @param pCantidad Cantidad de juegos que se quieren vender.
     */
    public void venderUnidadesJuego( String pNombreJuego, int pCantidad )
    {

        if( appStore.darJuego1( ).darNombre( ).equals( pNombreJuego ) && appStore.darJuego1( ).darCantidadActual( ) >= pCantidad )
        {
            appStore.venderUnidadesJuego1( pCantidad );

            panelJuegos.cambiarJuego( appStore.darJuego1( ).darNombre( ), appStore.darJuego1( ).darCategoria( ), appStore.darJuego1( ).darTamanio( ), appStore.darJuego1( ).darCantidadActual( ), appStore.darJuego1( ).darPrecio( ) );
        }
        else if( appStore.darJuego2( ).darNombre( ).equals( pNombreJuego ) && appStore.darJuego2( ).darCantidadActual( ) >= pCantidad )
        {
            appStore.venderUnidadesJuego2( pCantidad );

            panelJuegos.cambiarJuego( appStore.darJuego2( ).darNombre( ), appStore.darJuego2( ).darCategoria( ), appStore.darJuego2( ).darTamanio( ), appStore.darJuego2( ).darCantidadActual( ), appStore.darJuego2( ).darPrecio( ) );
        }
        else if( appStore.darJuego3( ).darNombre( ).equals( pNombreJuego ) && appStore.darJuego3( ).darCantidadActual( ) >= pCantidad )
        {
            appStore.venderUnidadesJuego3( pCantidad );

            panelJuegos.cambiarJuego( appStore.darJuego3( ).darNombre( ), appStore.darJuego3( ).darCategoria( ), appStore.darJuego3( ).darTamanio( ), appStore.darJuego3( ).darCantidadActual( ), appStore.darJuego3( ).darPrecio( ) );
        }

    }

    /**
     * Compra para la empresa de juegos la cantidad especificada<br>
     * del juego que coincide con el nombre especificado.
     * @param pNombreJuego Nombre del juego que se quiere comprar.
     * @param pCantidad Cantidad de juegos que se quieren comprar.
     */
    public void comprarUnidadesJuego( String pNombreJuego, int pCantidad )
    {

        if( appStore.darJuego1( ).darNombre( ).equals( pNombreJuego ) )
        {
            appStore.comprarUnidadesJuego1( pCantidad );
            panelJuegos.cambiarJuego( appStore.darJuego1( ).darNombre( ), appStore.darJuego1( ).darCategoria( ), appStore.darJuego1( ).darTamanio( ), appStore.darJuego1( ).darCantidadActual( ), appStore.darJuego1( ).darPrecio( ) );
        }
        else if( appStore.darJuego2( ).darNombre( ).equals( pNombreJuego ) )
        {
            appStore.comprarUnidadesJuego2( pCantidad );
            panelJuegos.cambiarJuego( appStore.darJuego2( ).darNombre( ), appStore.darJuego2( ).darCategoria( ), appStore.darJuego2( ).darTamanio( ), appStore.darJuego2( ).darCantidadActual( ), appStore.darJuego2( ).darPrecio( ) );
        }
        else if( appStore.darJuego3( ).darNombre( ).equals( pNombreJuego ) )
        {
            appStore.comprarUnidadesJuego3( pCantidad );
            panelJuegos.cambiarJuego( appStore.darJuego3( ).darNombre( ), appStore.darJuego3( ).darCategoria( ), appStore.darJuego3( ).darTamanio( ), appStore.darJuego3( ).darCantidadActual( ), appStore.darJuego3( ).darPrecio( ) );
        }
    }

    /**
     * Muestra el dialogo para seleccionar la cantidad de juegos para<br>
     * una posible venta en volumen y poder calcular un descuento.
     */
    public void mostrarDialogoDescuentos( )
    {
        DialogoVentaVolumen dialogo = new DialogoVentaVolumen( this );
        dialogo.setVisible( true );
    }

    /**
     * Formatea un valor numérico para presentar en la interfaz con el formato en pesos.<br>
     * @param pValor Valor numérico a ser formateado. pValor > 0.<br>
     * @return Cadena con el valor formateado con comas y signos.
     */
    private String formatearValorPesos( double pValor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###" );
        df.setMinimumFractionDigits( 0 );
        return df.format( pValor );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = appStore.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 1", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = appStore.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 2", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * @param pArgs Argumentos para la ejecución de la aplicación. En este caso no son necesarios.
     */
    public static void main( String[] pArgs )
    {

        InterfazCupiAppStore interfaz = new InterfazCupiAppStore( );
        interfaz.setVisible( true );

    }

}