/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n4_tiendaLibros
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.tiendaLibros.mundo;

/**
 * Clase que representa un �tem del carro de compras.
 */
public class ItemCompra
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Libro solicitado como �tem de compra.
     */
    private Libro libro;

    /**
     * Cantidad del libro a comprar.
     */
    private int cantidad;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un �tem de compra con el libro a comprar y la cantidad deseada.
     * @param pLibro Libro que se va a comprar. pLibro != null.
     * @param pCantidad Cantidad de libros a comprar. pCantidad > 0.
     */
    public ItemCompra( Libro pLibro, int pCantidad )
    {
        libro = pLibro;
        cantidad = pCantidad;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el libro solicitado como �tem de compra.
     * @return Libro solicitado como �tem de compra.
     */
    public Libro darLibro( )
    {
        return libro;
    }

    /**
     * Retorna la cantidad solicitada de libros.
     * @return Cantidad solicitada.
     */
    public int darCantidadSolicitada( )
    {
        return cantidad;
    }

    /**
     * Retorna el subtotal de compra del �tem.
     * @return Subtotal de compra del �tem.
     */
    public int calcularSubtotalItem( )
    {
        int subtotal = libro.darPrecio( ) * cantidad;
        return subtotal;
    }
}