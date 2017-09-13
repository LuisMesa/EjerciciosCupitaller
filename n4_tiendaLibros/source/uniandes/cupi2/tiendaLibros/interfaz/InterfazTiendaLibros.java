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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.tiendaLibros.mundo.Libro;
import uniandes.cupi2.tiendaLibros.mundo.TiendaLibros;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazTiendaLibros extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private TiendaLibros tiendaLibros;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las extensiones.
     */
    private PanelExtension panelExtension;

    /**
     * Panel con la lista de carros de compra.
     */
    private PanelCarrosCompra panelCarrosCompra;

    /**
     * Panel con la imagen de la aplicación.
     */
    private PanelImagen panelImagen;

    /**
     * Panel para el manejo de los libros.
     */
    private PanelManejoLibros panelManejoLibros;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la aplicación principal.
     */
    public InterfazTiendaLibros( )
    {
        tiendaLibros = new TiendaLibros( );

        setLayout( new BorderLayout( ) );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        setTitle( "Tienda de libros" );

        panelImagen = new PanelImagen( );
        panelExtension = new PanelExtension( this );
        panelCarrosCompra = new PanelCarrosCompra( this );
        panelManejoLibros = new PanelManejoLibros( this );

        add( panelImagen, BorderLayout.NORTH );
        add( panelCarrosCompra, BorderLayout.CENTER );
        add( panelManejoLibros, BorderLayout.EAST );
        add( panelExtension, BorderLayout.SOUTH );
        setPreferredSize( new Dimension( 800, 600 ) );
        setResizable( false );
        pack( );

        setLocationRelativeTo( null );
        panelManejoLibros.refrescarLista( darLibrosTienda( ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la lista de libros de la tienda de libros.
     * @return Lista de libro del catálogo de la tienda.
     */
    public ArrayList darLibrosTienda( )
    {
        return tiendaLibros.darCatalogo( );
    }

    /**
     * Retorna los libros incluidos en un carro de compras dada la cédula del cliente.
     * @param pCedula Cédula del dueño del carro de compras. pCedula != null && pCedula != "".
     * @return Lista de libros del carro de compras con la cédula dada.
     */
    public ArrayList darLibrosIncluidosCarroCompras( String pCedula )
    {
        return tiendaLibros.buscarCarroCompras( pCedula ).darItemsCompra( );
    }

    /**
     * Muestra todos los carros de compras de la tienda de libros.
     */
    public void mostrarTodosLosCarrosCompras( )
    {
        panelCarrosCompra.modificarTitulo( "Todos los carros de compras" );
        panelCarrosCompra.repaint( );
        panelCarrosCompra.actualizarPasaportes( tiendaLibros.darCarrosCompras( ) );
    }

    /**
     * Muestra todos los carros de compras en elaboración de la tienda de libros.
     */
    public void mostrarPasaportesEnElaboracion( )
    {
        panelCarrosCompra.modificarTitulo( "Carros de compras en elaboración" );
        panelCarrosCompra.repaint( );
        panelCarrosCompra.actualizarPasaportes( tiendaLibros.darCarrosComprasEnElaboracion( ) );
    }

    /**
     * Muestra todos los carros de compras vendidos de la tienda de libros.
     */
    public void mostrarPasaportesVendidos( )
    {
        panelCarrosCompra.modificarTitulo( "Carros de compras vendidos" );
        panelCarrosCompra.repaint( );
        panelCarrosCompra.actualizarPasaportes( tiendaLibros.darCarrosComprasVendidos( ) );
    }

    /**
     * Muestra un diálogo que permite agregar un libro a la tienda.
     */
    public void mostrarDialogoAgregarLibro( )
    {
        DialogoAgregarLibro dialogo = new DialogoAgregarLibro( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el diálogo que permite agregar un carro de compras a la tienda.
     */
    public void mostrarDialogoAgregarCarroCompras( )
    {
        DialogoAgregarCarroCompras dialogo = new DialogoAgregarCarroCompras( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el diálogo para agregar o eliminar libros de un carro de compras.
     * @param pCedula Cédula del cliente dueño del carro de compras. pCedula != null && pCedula != "".
     */
    public void mostrarDialogoLibrosCarroCompra( String pCedula )
    {
        DialogoLibrosCarroCompra dialogo = new DialogoLibrosCarroCompra( this, pCedula );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Agrega un carro de compras nuevo a la lista. <br>
     * <b>pre:</b> La lista de carros está inicializada. <br>
     * <b>post:</b> La lista tiene un carro de compras nuevo.
     * @param pNombre Nombre del dueño del carro. pNombre != null && pNombre != "".
     * @param pCedula Cédula del dueño del carro. pCedula != null && pCedula != "".
     */
    public void agregarCarroCompras( String pNombre, String pCedula )
    {
        try
        {
            tiendaLibros.agregarCarroCompras( pNombre, pCedula );
            mostrarTodosLosCarrosCompras( );
            mostrarDialogoLibrosCarroCompra( pCedula );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Agregar carro de compras", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Agrega una libro a la tienda con los valores dados por parámetro.
     * @param pTitulo Título del libro. pTitulo != null && pTitulo != "".
     * @param pISBN ISBN del libro. pISBN != null && pISBN != "".
     * @param pPrecio Precio del libro. Puede ser negativo.
     */
    public void agregarLibro( String pTitulo, String pISBN, int pPrecio )
    {
        try
        {
            tiendaLibros.agregarLibroACatalogo( pTitulo, pISBN, pPrecio );
            panelManejoLibros.refrescarLista( darISBNs( darLibrosTienda( ) ) );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Agregar libro", JOptionPane.ERROR_MESSAGE );
            panelManejoLibros.refrescarLista( darISBNs( darLibrosTienda( ) ) );
        }
    }

    /**
     * Agrega una libro al carro dado.
     * @param pISBN ISBN del libro. pISBN != null && pISBN != "".
     * @param pCedula Cédula del dueño del carro. pCedula != null && pCedula != "".
     * @param pCantidadSolicitada Cantidad de unidades solicitadas del libro. pCantidadSolicitada > 0.
     */
    public void agregarItemCompraACarro( String pISBN, String pCedula, int pCantidadSolicitada )
    {
        try
        {
            tiendaLibros.agregarItemCompraACarro( pCedula, pISBN, pCantidadSolicitada );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Agregar libro a carro compras", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra el diálogo para modificar libros del carro de compras seleccionado.
     */
    public void modificarLibrosCarroCompras( )
    {
        String seleccionado = panelCarrosCompra.darIndiceCarroSeleccionado( );
        if( seleccionado != null )
        {
            mostrarDialogoLibrosCarroCompra( seleccionado );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un carro de compras de la lista.", "Modificar libros carro de compras", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Elimina un carro de compras de la tienda.<br>
     * <b>post:</b> La lista tiene un carro de compras menos.
     */
    public void eliminarCarroCompras( )
    {
        String cedula = ( String )JOptionPane.showInputDialog( this, "Ingrese la cédula del dueño del carro de compras:", "Eliminar carro de compras", JOptionPane.INFORMATION_MESSAGE );

        if( cedula != null )
        {
            try
            {
                if( cedula.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "La cédula debería ser un número.", "Eliminar carro de compras", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    if( cedula.matches( "[0123456789]*" ) )
                    {
                        tiendaLibros.eliminarCarroCompras( cedula );
                        JOptionPane.showMessageDialog( this, "Se eliminó el carro de compras correctamente.", "Eliminar carro de compras", JOptionPane.INFORMATION_MESSAGE );
                        mostrarTodosLosCarrosCompras( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "La cédula debería ser un número positivo.", "Eliminar carro de compras", JOptionPane.ERROR_MESSAGE );
                    }
                }
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Eliminar carro de compras", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Elimina una libro del catálogo de la tienda.
     */
    public void eliminarLibro( )
    {

        String isbnLibro = ( String )JOptionPane.showInputDialog( this, "Ingrese el ISBN del libro:", "Eliminar libro", JOptionPane.INFORMATION_MESSAGE );

        if( isbnLibro != null )
        {
            if( isbnLibro.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "EL ISBN no puede ser cadena vacía.", "Eliminar libro", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                try
                {
                    tiendaLibros.eliminarLibroDeCatalogo( isbnLibro );
                    JOptionPane.showMessageDialog( this, "Se eliminó el libro del catálogo correctamente.", "Eliminar libro", JOptionPane.INFORMATION_MESSAGE );
                    panelManejoLibros.refrescarLista( darISBNs( darLibrosTienda( ) ) );
                }
                catch( Exception e )
                {
                    JOptionPane.showMessageDialog( this, e.getMessage( ), "Eliminar libro", JOptionPane.ERROR_MESSAGE );
                }
            }
        }

    }

    /**
     * Elimina el libro del carro de compras dado.
     * @param pISBN ISBN del libro. pISBN != null && pISBN != "".
     * @param pCedula Cédula del dueño del carro. pCedula != null && pCedula != "".
     */
    public void eliminarItemCompraDeCarro( String pCedula, String pISBN )
    {
        try
        {
            tiendaLibros.eliminarItemCompraDeCarro( pCedula, pISBN );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Elimina ítem compra de carro de compras", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Vende el carro de compras seleccionado.
     */
    public void venderCarroCompras( )
    {
        String seleccionado = panelCarrosCompra.darIndiceCarroSeleccionado( );

        if( seleccionado != null )
        {
            try
            {
                double total = tiendaLibros.venderCarroCompras( seleccionado );
                JOptionPane.showMessageDialog( this, "El carro de compras fue vendido por: " + total + ".", "Vender carro de compras", JOptionPane.INFORMATION_MESSAGE );
                mostrarTodosLosCarrosCompras( );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Vender carro de compras", JOptionPane.ERROR_MESSAGE );
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un carro de compras de la lista.", "Vender carro de compras", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Pasa una lista de libros a sus ISBNs.
     * @param pListaOriginal Lista de objetos Libro. pListaOriginal != null.
     * @return Lista con los ISBN de los libros.
     */
    private ArrayList darISBNs( ArrayList pListaOriginal )
    {
        ArrayList rta = new ArrayList( );
        for( int i = 0; i < pListaOriginal.size( ); i++ )
        {
            Libro actual = ( Libro )pListaOriginal.get( i );
            rta.add( actual.darTitulo( ) + " (" + actual.darISBN( ) + ")" );
        }
        return rta;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = tiendaLibros.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = tiendaLibros.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * @param args No son necesarios.
     */
    public static void main( String[] args )
    {
        InterfazTiendaLibros interfaz = new InterfazTiendaLibros( );
        interfaz.setVisible( true );
    }

}