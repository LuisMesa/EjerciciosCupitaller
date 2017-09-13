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
package uniandes.cupi2.tiendaLibros.mundo;

/**
 * Clase que representa un ítem del carro de compras.
 */
public class ItemCompra
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Libro solicitado como ítem de compra.
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
     * Crea un ítem de compra con el libro a comprar y la cantidad deseada.
     * @param pLibro Libro que se va a comprar. pLibro != null.
     * @param pCantidad Cantidad de libros a comprar. pCantidad > 0.
     */
    public ItemCompra( Libro pLibro, int pCantidad )
    {
        libro = pLibro;
        cantidad = pCantidad;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el libro solicitado como ítem de compra.
     * @return Libro solicitado como ítem de compra.
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
     * Retorna el subtotal de compra del ítem.
     * @return Subtotal de compra del ítem.
     */
    public int calcularSubtotalItem( )
    {
        int subtotal = libro.darPrecio( ) * cantidad;
        return subtotal;
    }
}