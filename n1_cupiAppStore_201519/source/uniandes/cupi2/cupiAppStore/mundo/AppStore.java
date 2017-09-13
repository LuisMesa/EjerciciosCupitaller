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
package uniandes.cupi2.cupiAppStore.mundo;

/**
 * Clase que representa el AppStore.
 */
public class AppStore
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Juego 1 de la AppStore.
     */
    private Juego juego1;

    /**
     * Juego 2 de la AppStore.
     */
    // TODO Parte1 PuntoA: Declarar el atributo para modelar el juego número 2.
    private Juego juego2;

    /**
     * Juego 3 de la AppStore.
     */
    // TODO Parte1 PuntoB: Declarar el atributo para modelar el juego número 3.
    private Juego juego3;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa los tres juegos del AppStore. <br>
     * <b>post: </b> Se inicializaron los tres juegos con los valores por parámetro nombre, categoría, precio, tamaño y cantidadActual.<br>
     * Juego 1 - Nombre: Candy Crush, Categoría: Rompecabezas, Precio: 30000, Tamaño (Kb): 300, Cantidad inicial: 50.<br>
     * Juego 2 - Nombre: Clash Of Clans, Categoría: Acción, Precio: 55000, Tamaño (Kb): 2500, Cantidad inicial: 15. <br>
     * Juego 3 - Nombre: Fifa 15, Categoría: Deporte, Precio: 15000, Tamaño (Kb): 150, Cantidad inicial: 22.
     */
    public void inicializar( )
    {
        juego1 = new Juego( );
        juego1.inicializar( "Candy Crush", "Rompecabezas", 30000, 300, 50 );
        
        // TODO Parte1 PuntoC: Crear e inicializar el juego número 2.
        juego2 = new Juego();
        juego2.inicializar("Clash Of Clans", "Acción", 55000, 2500, 15);

        // TODO Parte1 PuntoD: Crear e inicializar el juego número 3.
        juego3 = new Juego();
        juego3.inicializar("Fifa 15", "Deporte", 15000, 150, 22);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Devuelve el juego 1.
     * @return Juego 1.
     */
    public Juego darJuego1( )
    {
        return juego1;
    }

    /**
     * Devuelve el juego 2.
     * @return Juego 2.
     */
    public Juego darJuego2( )
    {
        // TODO Parte1 PuntoE: Completar el método según la documentación.
    	return juego2;
    }

    /**
     * Devuelve el juego 3.
     * @return Juego 3.
     */
    public Juego darJuego3( )
    {

        // TODO Parte1 PuntoF: Completar el método según la documentación.
    	return juego3;
    }

    /**
     * Retorna la cantidad de unidades del juego 1. <br>
     * @return Cantidad de unidades disponibles del juego 1.
     */
    public int darCantidadActualJuego1( )
    {
        return juego1.darCantidadActual( );
    }

    /**
     * Retorna la cantidad de unidades del juego 2. <br>
     * @return Cantidad de unidades disponibles del juego 2.
     */
    public int darCantidadActualJuego2( )
    {
        // TODO Parte1 PuntoG: Completar el método según la documentación.
    	return juego2.darCantidadActual();
    }

    /**
     * Retorna la cantidad de unidades del juego 3. <br>
     * @return Cantidad de unidades disponibles del juego 3.
     */
    public int darCantidadActualJuego3( )
    {
        // TODO Parte1 PuntoH: Completar el método según la documentación.
    	return juego3.darCantidadActual();
    }

    /**
     * Retorna la cantidad promedio de dinero recaudado por las unidades de juegos vendidos. <br>
     * @return Dinero promedio recaudado por los juegos vendidos.
     */
    public double darDineroPromedio( )
    {
        double dineroPromedioRecaudado = 0;

        double totalRecaudadoJuego1 = darJuego1( ).darCantidadVendidas( ) * darJuego1( ).darPrecio( );
        double totalRecaudadoJuego2 = darJuego2( ).darCantidadVendidas( ) * darJuego2( ).darPrecio( );
        double totalRecaudadoJuego3 = darJuego3( ).darCantidadVendidas( ) * darJuego3( ).darPrecio( );

        dineroPromedioRecaudado = ( totalRecaudadoJuego1 + totalRecaudadoJuego2 + totalRecaudadoJuego3 ) / ( darJuego1( ).darCantidadVendidas( ) + darJuego2( ).darCantidadVendidas( ) + darJuego3( ).darCantidadVendidas( ) );

        return dineroPromedioRecaudado;
    }

    /**
     * Retorna el total del costo de la cantidad de unidades ingresadas por parámetro con un descuento del 30%.<br>
     * @param pCantidadJuego1 Cantidad de unidades que se pretenden vender del juego1. pCantidadJuego1 >= 0.<br>
     * @param pCantidadJuego2 Cantidad de unidades que se pretenden vender del juego2. pCantidadJuego2 >= 0.<br>
     * @param pCantidadJuego3 Cantidad de unidades que se pretenden vender del juego3. pCantidadJuego3 >= 0.<br>
     * @return Total del costo de la cantidad de unidades con descuento del 30%.
     */
    public double calcularDescuento( int pCantidadJuego1, int pCantidadJuego2, int pCantidadJuego3 )
    {

        // Total venta
        double totalVenta = 0;

        totalVenta += juego1.darPrecio( ) * pCantidadJuego1;
        // TODO Parte1 PuntoI: Sumar el precio total de las ventas de licencias que se pretenden vender del juego número 2.
        totalVenta += juego2.darPrecio( ) * pCantidadJuego2;
        // TODO Parte1 PuntoJ: Sumar el precio total de las ventas de licencias que se pretenden vender del juego número 3.
        totalVenta += juego3.darPrecio( ) * pCantidadJuego3;
        double descuentoTotal = totalVenta * .3;
        double totalConDescuento = totalVenta - descuentoTotal;

        return totalConDescuento;

    }

    /**
     * Registra la venta de una cantidad dada de unidades del juego 1.<br>
     * @param pCantidad Cantidad de unidades del juego 1. pCantidad > 0.
     */
    public void venderUnidadesJuego1( int pCantidad )
    {
        juego1.venderUnidades( pCantidad );
    }

    /**
     * Registra la venta de una cantidad dada de unidades del juego 2.<br>
     * @param pCantidad Cantidad de unidades del juego 2. pCantidad > 0.
     */
    public void venderUnidadesJuego2( int pCantidad )
    {
        // TODO Parte1 PuntoK: Completar el método según la documentación.
    	juego2.venderUnidades( pCantidad );
    }

    /**
     * Registra la venta de una cantidad dada de unidades del juego 3.<br>
     * @param pCantidad Cantidad de unidades del juego 3. pCantidad > 0.
     */
    public void venderUnidadesJuego3( int pCantidad )
    {
        // TODO Parte1 PuntoL: Completar el método según la documentación.
    	juego3.venderUnidades( pCantidad );
    }

    /**
     * Registra la compra de una cantidad dada de unidades del juego 1.<br>
     * @param pCantidad Cantidad de unidades del juego 1. pCantidad > 0.
     */
    public void comprarUnidadesJuego1( int pCantidad )
    {
        juego1.comprarUnidades( pCantidad );
    }

    /**
     * Registra la compra de una cantidad dada de unidades del juego 2.<br>
     * @param pCantidad Cantidad de unidades del juego 2. pCantidad > 0.
     */
    public void comprarUnidadesJuego2( int pCantidad )
    {
        // TODO Parte1 PuntoM: Completar el método según la documentación.
    	juego2.comprarUnidades( pCantidad );
    }

    /**
     * Registra la compra de una cantidad dada de unidades del juego 3.<br>
     * @param pCantidad Cantidad de unidades del juego 3. pCantidad > 0.
     */
    public void comprarUnidadesJuego3( int pCantidad )
    {
        // TODO Parte1 PuntoN: Completar el método según la documentación.
    	juego3.comprarUnidades( pCantidad );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * Método para la extensión 2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }
}