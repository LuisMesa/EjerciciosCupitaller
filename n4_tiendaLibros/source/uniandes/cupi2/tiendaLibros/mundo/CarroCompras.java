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

import java.util.ArrayList;

/**
 * Clase que representa un carro de compras.
 */
public class CarroCompras
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Estado del carro de compras en elaboraci�n.
     */
    // TODO Parte2 PuntoA: Declare la constante ELABORACION con valor 0
	public static final int ELABORACION =0;

    /**
     * Estado del carro de compras vendido.
     */
    // TODO Parte2 PuntoB: Declare la constante VENDIDO con valor 1
	public static final int VENDIDO=1;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del due�o del carro de compras.
     */
    private String nombreDuenio;

    /**
     * C�dula del due�o del carro de compras.
     */
    private String cedulaDuenio;

    /**
     * Estado del carro de compras.
     */
    private int estado;

    /**
     * Lista de items que ser�n comprados en el carro de compras.
     */
    private ArrayList itemsCompra;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un carro de compra vac�o. <br>
     * <b> post: </b> La lista de de items se cre� vac�a. <br>
     * El estado del carro es en elaboraci�n.<br>
     * La c�dula del due�o y el nombre del due�o tomaron los valores dados por par�metro.<br>
     * @param pNombreDuenio Nombre del due�o del carro de compras. pNombreDuenio != null && pNombreDuenio != "".
     * @param pCedulaDuenio C�dula del due�o del carro de compras. pCedulaDuenio != null && pCedulaDuenio != "".
     */
    public CarroCompras( String pNombreDuenio, String pCedulaDuenio )
    {
        // TODO Parte2 PuntoC: Complete el m�todo constructor de la clase.
    	itemsCompra=new ArrayList();
    	estado = ELABORACION;
    	cedulaDuenio=pCedulaDuenio;
    	nombreDuenio = pNombreDuenio;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del due�o del carro de compras.
     * @return Nombre del due�o del carro de compras.
     */
    public String darNombreDuenio( )
    {
        return nombreDuenio;
    }

    /**
     * Retorna la c�dula del due�o del carro de compras.
     * @return C�dula del due�o del carro de compras.
     */
    public String darCedulaDuenio( )
    {
        return cedulaDuenio;
    }

    /**
     * Retorna el estado del carro de compras.
     * @return Estado del carro de compras.
     */
    public int darEstado( )
    {
        return estado;
    }

    /**
     * Retorna la lista de los �tem de compra.
     * @return Lista de los �tem de compra.
     */
    public ArrayList darItemsCompra( )
    {
        return itemsCompra;
    }

    /**
     * Retorna un �tem de compra dado el ISBN del libro.
     * @param pISBN ISBN del libro buscado. pISBN != null && pISBN != "".
     * @return �tem de compra del libro, null en caso de no encontrarlo.
     */
    public ItemCompra buscarItemCompra( String pISBN )
    {
        boolean encontrado = false;
        ItemCompra buscado = null;

        for( int i = 0; i < itemsCompra.size( ) && !encontrado; i++ )
        {
            ItemCompra actual = ( ItemCompra )itemsCompra.get( i );
            if( actual.darLibro( ).darISBN( ).equals( pISBN ) )
            {
                encontrado = true;
                buscado = actual;
            }
        }
        return buscado;
    }


    // TODO Parte2 PuntoD: Escriba el contrato del m�todo de acuerdo a la funcionalidad implementada.
    public int calcularValorTotalCompra( )
    {
        int total = 0;
        for( int i = 0; i < itemsCompra.size( ); i++ )
        {
            ItemCompra actual = ( ItemCompra )itemsCompra.get( i );
            total += actual.calcularSubtotalItem( );
        }
        return total;
    }

    /**
     * Agrega un nuevo �tem al carro de la compras. <br>
     * <b>post: </b> Se agrega el �tem de compra al carro de compras. <br>
     * @param pLibro Libro a comprar. pLibro != null.
     * @param pCantidad Cantidad de libros a comprar. pCantidad >= 0.
     * @throws Exception Si ya existe un �tem compra en el carro de compras con el libro dado.
     * @throws Exception Si el carro de compras tiene estado VENDIDO.
     */
    public void agregarItemCompra( Libro pLibro, int pCantidad ) throws Exception
    {
        // TODO Parte2 PuntoE: Complete el m�todo seg�n la documentaci�n.
        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:

        // Error si el estado del carro de compras es vendido.
        // Mensaje de error: No se puede agregar el �tem de compra porque el carro ya fue vendido.

        // Error si intenta agregar un libro que ya est� en los items de compra.
        // Mensaje de error: El libro que se quiere agregar ya existe en el carro de compras.
    	if(estado==VENDIDO)
    		throw new Exception("No se puede agregar el �tem de compra porque el carro ya fue vendido.");
    	else if(buscarItemCompra(pLibro.darISBN())!=null)
    		throw new Exception("El libro que se quiere agregar ya existe en el carro de compras.");
    	
    	itemsCompra.add(new ItemCompra(pLibro, pCantidad));
    }

    /**
     * Elimina un �tem del carro de la compra. <br>
     * <b>post: </b> Se elimina el �tem de compra dado el ISBN del libro. <br>
     * @param pISBN ISBN del libro que es �tem de compra a eliminar. pISBN != null && pISBN != "".
     * @throws Exception Si no existe ning�n �tem de compra con un libro con el ISBN dado.
     * @throws Exception Si el carro de compras tiene estado VENDIDO.
     */
    public void eliminarItemCompra( String pISBN ) throws Exception
    {
        // TODO Parte2 PuntoF: Complete el m�todo seg�n la documentaci�n.

        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:

        // Error si intenta eliminar el �tem compra de un carro de compras vendido.
        // Mensaje de error: No se puede eliminar el �tem de compra porque el carro ya fue vendido..

        // Error si no existe un �tem compra con un libro con el ISBN dado.
        // Mensaje de error: No existe ning�n �tem de compra con un libro con el ISBN dado.
    	if(buscarItemCompra(pISBN)==null)
    		throw new Exception("No existe ning�n �tem de compra con un libro con el ISBN dado.");
    	else if(estado==VENDIDO)
    		throw new Exception("No se puede eliminar el �tem de compra porque el carro ya fue vendido.");
    	
    	itemsCompra.remove(buscarItemCompra(pISBN));
    }

    /**
     * Cambia el estado del carro de compras a vendido si tiene por lo menos 4 items de compra.<br>
     * Retorna el valor por el que fue vendido el carro.<br>
     * <b>post: </b> El estado del carro de compras cambi� a VENDIDO.<br>
     * @return Valor total del carro.
     * @throws Exception Si el estado del carro de compras ya es vendido.
     * @throws Exception Si el carro de compras no tiene por lo menos 4 items de compra.
     */
    public int vender( ) throws Exception
    {
        // TODO Parte2 PuntoG: Complete el m�todo seg�n la documentaci�n.
        
        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:
        
        // Error si intenta vender el carro de compras con menos de 4 items compra.
        // Mensaje de error: No se puede vender el carro de compras si tiene menos de 4 items de compra..
        
        // Error si el estado del carro de compras ya es vendido.
        // Mensaje de error: El carro de compras ya fue vendido.
    	if(itemsCompra.size()<4)
    		throw new Exception("No se puede vender el carro de compras si tiene menos de 4 items de compra.");
    	if(estado==VENDIDO)
    		throw new Exception("El carro de compras ya fue vendido.");
    	
    	estado = VENDIDO;
    	return calcularValorTotalCompra();
    }
}