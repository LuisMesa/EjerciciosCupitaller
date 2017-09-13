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

import java.util.ArrayList;

/**
 * Clase que representa la tienda de venta de libros.
 */
public class TiendaLibros
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Catálogo de libros.
     */
    // TODO Parte3 PuntoA: Declare el atributo catalogo como un vector.
	private ArrayList catalogo;

    /**
     * Lista de carros de compra de libros.
     */
    // TODO Parte3 PuntoB: Declare el atributo carros como un vector.
	private ArrayList carros;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea la tienda de libros. <br>
     * <b> post: </b> El catálogo de libros y la lista de carros de compra se inicializaron como listas vacías.
     */
    public TiendaLibros( )
    {
        catalogo = new ArrayList( );
        carros = new ArrayList( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el catálogo de la tienda. <br>
     * @return El catálogo de la tienda.
     */
    public ArrayList darCatalogo( )
    {
        return catalogo;
    }

    /**
     * Retorna los carros de compra.
     * @return Lista de carros de compra.
     */
    public ArrayList darCarrosCompras( )
    {
        return carros;
    }

    /**
     * Retorna los carros de compra que tienen estado en elaboración.
     * @return Lista de carros de compra en elaboración.
     */
    public ArrayList darCarrosComprasEnElaboracion( )
    {
        ArrayList rta = new ArrayList( );
        for( int i = 0; i < carros.size( ); i++ )
        {
            CarroCompras carroActual = ( CarroCompras )carros.get( i );
            if( carroActual.darEstado( ) == CarroCompras.ELABORACION )
            {
                rta.add( carroActual );
            }
        }
        return rta;
    }

    /**
     * Retorna los carros de compra que tienen estado vendido.
     * @return Lista de carros de compra vendidos.
     */
    public ArrayList darCarrosComprasVendidos( )
    {
        ArrayList rta = new ArrayList( );
        for( int i = 0; i < carros.size( ); i++ )
        {
            CarroCompras carroActual = ( CarroCompras )carros.get( i );
            if( carroActual.darEstado( ) == CarroCompras.VENDIDO )
            {
                rta.add( carroActual );
            }
        }
        return rta;
    }

    /**
     * Retorna un libro del catálogo dado su ISBN. <br>
     * @param pISBN ISBN del libro. pISBN != null && pISBN != "".
     * @return Libro que tiene el ISBN dado, null si no lo encuentra.
     */
    public Libro buscarLibro( String pISBN )
    {
        Libro buscado = null;
        boolean encontrado = false;

        for( int i = 0; i < catalogo.size( ) && !encontrado; i++ )
        {
            Libro actual = ( Libro )catalogo.get( i );

            if( actual.darISBN( ).equals( pISBN ) )
            {
                buscado = actual;
                encontrado = true;
            }
        }

        return buscado;
    }

    /**
     * Retorna un carro de compras dada la cédula del dueño.
     * @param pCedulaDuenio Cédula del dueño del carro de compras. pCedulaDuenio != null && pCedulaDuenio != "".
     * @return Carro de compras que tiene la cédula del dueño dada, null en caso de no encontrarla.
     */
    public CarroCompras buscarCarroCompras( String pCedulaDuenio )
    {
        // TODO Parte3 PuntoC: Complete el método según la documentación.
    	for(int i = 0;i<carros.size();i++)
    	{
    		if(((CarroCompras)carros.get(i)).darCedulaDuenio()==pCedulaDuenio)
    			return ((CarroCompras)carros.get(i));
    	}
    	return null;
    }

    /**
     * Determina si en alguno de los carros de compra existe un libro con el ISBN dado.
     * @param pISBN ISBN del libro a buscar. pISBN != null && pISBN != "".
     * @return True si existe un libro en algún carro de compras, false de lo contrario.
     */
    public boolean existeLibroCarrosCompras( String pISBN )
    {
        boolean existe = false;
        for( int i = 0; i < carros.size( ) && !existe; i++ )
        {
            CarroCompras carroActual = ( CarroCompras )carros.get( i );
            if( carroActual.buscarItemCompra( pISBN ) != null )
            {
                existe = true;
            }
        }
        return existe;
    }

    /**
     * Agrega un nuevo libro al catálogo de la tienda. <br>
     * <b>post: </b> Se agregó un libro al catálogo. <br>
     * @param pTitulo Título del libro. pTitulo != null && pTitulo != "".
     * @param pISBN ISBN del libro. pISBN != null && pISBN != "".
     * @param pPrecio Precio del libro.
     * @throws Exception Si ya existe un libro con el ISBN dado.
     * @throws Exception Si el precio del libro es negativo, se captura la excepción, <br>
     *         se cambia el número a positivo, se agrega el libro y se lanza nuevamente la excepción con el mensaje correspondiente.
     */
    public void agregarLibroACatalogo( String pTitulo, String pISBN, int pPrecio ) throws Exception
    {
        // TODO Parte3 PuntoD: Complete el método según la documentación.

        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:

        // Error si ya existe un libro con el ISBN dado.
        // Mensaje de error: Ya existe un libro con el ISBN dado.

        // Si se genera una excepción porque el precio es negativo, usted debe:
        // 1) Capturar la excepción.
        // 2) Cambiar el precio a positivo.
        // 3) Crear el libro y agregarlo al vector.
        // 4) Lanzar una excepción con el siguiente mensaje: El precio del libro fue cambiado automáticamente a positivo para ser agregado.
    	
    	try
    	{
    		Libro libro = new Libro(pTitulo, pISBN, pPrecio);
    		catalogo.add(libro);
    	}
    	catch(Exception e)
    	{
    		Libro libro = new Libro(pTitulo, pISBN, pPrecio*-1);
    		catalogo.add(libro);
    		throw new Exception("El precio del libro fue cambiado automáticamente a positivo para ser agregado.");
    	}
    }

    /**
     * Agrega un carro de compras a la tienda.<br>
     * <b>post: </b> Se agregó un carro de compras a la tienda. <br>
     * @param pNombreDuenio Nombre del dueño del carro de compras. pNombreDuenio != null && pNombreDuenio != "".
     * @param pCedulaDuenio Cédula del dueño del carro de compras. pCedulaDuenio != null && pCedulaDuenio != "".
     * @throws Exception Si ya existe un carro de compras con la cédula del dueño dada.
     */
    public void agregarCarroCompras( String pNombreDuenio, String pCedulaDuenio ) throws Exception
    {
        // TODO Parte3 PuntoE: Complete el método según la documentación.

        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:

        // Error si ya existe un carro de compras con la cédula dada.
        // Mensaje de error: Ya existe un carro de compras con cédula dada.
    	if(buscarCarroCompras(pCedulaDuenio)!=null)
    		throw new Exception("Ya existe un carro de compras con cédula dada.");
    	carros.add(new CarroCompras(pNombreDuenio, pCedulaDuenio));
    }

    /**
     * Agrega un item de compra a un carro de compras.<br>
     * <b> post: </b> Se agregó el ítem de compra al carro dado.<br>
     * @param pCedulaDuenio Cédula del dueño del carro de compras. pCedulaDuenio != null && pCedulaDuenio != "".
     * @param pISBN ISBN del libro. pISBN != null && pISBN != "".
     * @param pCantidadSolicitada Cantidad solicitada del libro. pCantidadSolicitada > 0.
     * @throws Exception Si no existe un libro con el ISBN dado.
     * @throws Exception Si no existe un carro de compras con la cédula dada.
     * @throws Exception Si en el carro de compras ya existe un item compra con un libro con el ISBN dado.
     * @throws Exception Si el carro de compras tiene estado VENDIDO.
     */
    public void agregarItemCompraACarro( String pCedulaDuenio, String pISBN, int pCantidadSolicitada ) throws Exception
    {
        Libro libroActual = buscarLibro( pISBN );
        if( libroActual == null )
        {
            throw new Exception( "No existe un libro con el ISBN dado." );
        }
        else
        {
            CarroCompras carroActual = buscarCarroCompras( pCedulaDuenio );
            if( carroActual == null )
            {
                throw new Exception( "No existe un carro de compras con la cédula dada." );
            }
            else
            {
                carroActual.agregarItemCompra( libroActual, pCantidadSolicitada );
            }
        }
    }

    /**
     * Elimina un libro del catálogo dado su ISBN.<br>
     * <b>post: </b> Se eliminó el libro del catálogo. <br>
     * @param pISBN ISBN del libro a eliminar. pISBN != null && pISBN != "".
     * @throws Exception Si no existe un libro con el ISBN dado.
     * @throws Exception Si el libro que se quiere eliminar está presente en algún carro de compras.
     */
    public void eliminarLibroDeCatalogo( String pISBN ) throws Exception
    {
        // TODO Parte3 PuntoF: Complete el método según la documentación.

        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:

        // Error si el libro está presente en algún carro de compras.
        // Mensaje de error: No se puede eliminar el libro del catálogo dado que está presente en algún carro de compras.

        // Error si no existe un libro con el ISBN dado.
        // Mensaje de error: No existe un libro con el ISBN dado.
    	if(existeLibroCarrosCompras(pISBN))
    		throw new Exception("No se puede eliminar el libro del catálogo dado que está presente en algún carro de compras.");
    	if(buscarLibro(pISBN)==null)
    		throw new Exception("No existe un libro con el ISBN dado.");
    	
    	catalogo.remove(buscarLibro(pISBN));
    }

    /**
     * Elimina un carro de compras de la lista.<br>
     * <b>post: </b> Se eliminó el carro de compras. <br>
     * @param pCedulaDuenio Cédula del dueño del carro de compras. pCedulaDuenio != null && pCedulaDuenio != "".
     * @throws Exception Si no existe un carro de compras con la cédula dada.
     * @throws Exception Si el carro que se desea eliminar tiene estado vendido.
     */
    public void eliminarCarroCompras( String pCedulaDuenio ) throws Exception
    {
        // TODO Parte3 PuntoG: Complete el método según la documentación.

        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:

        // Error si el estado del carro de compras es vendido.
        // Mensaje de error: El carro no puede ser eliminado porque tiene estado vendido.

        // Error si no existe un carro de compras con la cédula dada.
        // Mensaje de error: No existe un carro con la cédula dada.
    	if(buscarCarroCompras(pCedulaDuenio)==null)
    		throw new Exception("No existe un carro con la cédula dada.");
    	if(buscarCarroCompras(pCedulaDuenio).darEstado()==CarroCompras.VENDIDO)
    		throw new Exception("El carro no puede ser eliminado porque tiene estado vendido.");
    	carros.remove(buscarCarroCompras(pCedulaDuenio));
    }

    /**
     * Elimina un item de compras de un carro de compras. <br>
     * <b> post: </b> Se eliminó el ítem de compra del carro dado.<br>
     * @param pCedulaDuenio Cédula del dueño del carro de compras. pCedulaDuenio != null && pCedulaDuenio != "".
     * @param pISBN ISBN del libro. pISBN != null && pISBN != "".
     * @throws Exception Si no existe un libro con el ISBN dado.
     * @throws Exception Si no existe un carro de compras con la cédula dada.
     * @throws Exception Si el carro de compras tiene estado VENDIDO.
     */
    public void eliminarItemCompraDeCarro( String pCedulaDuenio, String pISBN ) throws Exception
    {
        Libro libroActual = buscarLibro( pISBN );
        if( libroActual == null )
        {
            throw new Exception( "No existe un libro con el ISBN dado." );
        }
        else
        {
            CarroCompras carroActual = buscarCarroCompras( pCedulaDuenio );
            if( carroActual == null )
            {
                throw new Exception( "No existe un carro de compras con la cédula dada." );
            }
            else
            {
                carroActual.eliminarItemCompra( pISBN );
            }
        }
    }

    // TODO Parte3 PuntoH: Escriba el contrato del método de acuerdo a la funcionalidad implementada.
    public int venderCarroCompras( String pCedulaDuenio ) throws Exception
    {
        int rta = 0;
        CarroCompras buscado = buscarCarroCompras( pCedulaDuenio );
        if( buscado == null )
        {
            throw new Exception( "No existe un carro de compras con la cédula dada." );
        }
        else
        {
            rta = buscado.vender( );
        }
        return rta;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método 1 de extensión.
     * @return respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método 2 de extensión.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}