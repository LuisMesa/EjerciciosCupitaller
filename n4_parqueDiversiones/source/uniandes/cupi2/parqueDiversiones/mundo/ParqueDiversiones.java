/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_parqueDiversiones
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.parqueDiversiones.mundo;

import java.util.ArrayList;

/**
 * Clase que representa el parque de diversiones.
 */
public class ParqueDiversiones
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de atracciones del parque.
     */
    // TODO Parte3 PuntoA: Declare el atributo atracciones como un vector.
	private ArrayList atracciones;

    /**
     * Lista de pasaportes del parque.
     */
    // TODO Parte3 PuntoB: Declare el atributo pasaportes como un vector.
	private ArrayList pasaportes;

    /**
     * Dinero que tiene la caja.
     */
    // TODO Parte3 PuntoC: Declare el atributo dineroCaja como un número real.
	private double dineroCaja;


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo parque de diversiones. <br>
     * <b>post: </b> Inicializó pasaportes y atracciones como listas vacías. Inicializó el dinero en caja en 0.<br>
     */
    public ParqueDiversiones( )
    {
        pasaportes = new ArrayList( );
        atracciones = new ArrayList( );
        dineroCaja = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el dinero en caja del parque.<br>
     * @return Dinero en caja del parque.
     */
    public double darDineroCaja( )
    {
        return dineroCaja;
    }

    /**
     * Retorna la lista de atracciones del parque.<br>
     * @return Lista de atracciones del parque.
     */
    public ArrayList darAtracciones( )
    {
        return atracciones;
    }

    /**
     * Retorna la lista de pasaportes del parque.<br>
     * @return Lista de pasaportes del parque.
     */
    public ArrayList darPasaportes( )
    {
        return pasaportes;
    }

    /**
     * Retorna una lista con los pasaportes que están en elaboración. <b>pre:</b> La lista de pasaportes está inicializada. <br>
     * @return Lista con los pasaportes que están en elaboración.
     */
    public ArrayList darPasaportesEnElaboracion( )
    {
        ArrayList listaRespuesta = new ArrayList( );
        for( int i = 0; i < pasaportes.size( ); i++ )
        {
            Pasaporte pasaporteActual = ( Pasaporte )pasaportes.get( i );
            if( pasaporteActual.darEstado( ) == Pasaporte.ELABORACION )
            {
                listaRespuesta.add( pasaporteActual );
            }
        }
        return listaRespuesta;
    }

    /**
     * Retorna una lista con los pasaportes que han sido vendidos. <b>pre:</b> La lista de pasaportes está inicializada. <br>
     * @return Lista con los pasaportes que han sido vendidos.
     */
    public ArrayList darPasaportesVendidos( )
    {
        ArrayList listaRespuesta = new ArrayList( );
        for( int i = 0; i < pasaportes.size( ); i++ )
        {
            Pasaporte pasaporteActual = ( Pasaporte )pasaportes.get( i );
            if( pasaporteActual.darEstado( ) == Pasaporte.VENDIDO )
            {
                listaRespuesta.add( pasaporteActual );
            }
        }
        return listaRespuesta;
    }

    /**
     * Retorna la atracción dado su nombre. <br>
     * <b>pre:</b> La lista de atracciones está inicializada. <br>
     * @param pNombreAtraccion Nombre de la atracción que se está buscando. pNombreAtraccion != null && pNombreAtraccion != "".
     * @return Atracción que se está buscando, null en caso de no encontrarlo.
     */
    public Atraccion buscarAtraccion( String pNombreAtraccion )
    {
        Atraccion buscada = null;
        boolean encontro = false;
        for( int i = 0; i < atracciones.size( ) && !encontro; i++ )
        {
            Atraccion atraccionActual = ( Atraccion )atracciones.get( i );
            if( atraccionActual.darNombre( ).equals( pNombreAtraccion ) )
            {
                buscada = atraccionActual;
                encontro = true;
            }
        }
        return buscada;
    }

    /**
     * Retorna el pasaporte que pertenece a la persona que tiene la cédula dada por parámetro.<br>
     * <b>pre:</b> La lista de pasaportes está inicializada. <br>
     * @param pCedulaDuenio Cédula del dueño del pasaporte que se está buscando. pCedulaDuenio > 0.
     * @return Pasaporte que se está buscando, null en caso de no encontrarlo.
     */
    public Pasaporte buscarPasaporte( int pCedulaDuenio )
    {
        // TODO Parte3 PuntoD: Complete el método según la documentación.
    	for(int i=0;i<pasaportes.size();i++)
    	{
    		Pasaporte p=(Pasaporte)pasaportes.get(i);
    		if(p.darCedulaDuenio()==pCedulaDuenio)
    			return p;
    	}
    	return null;
    }

    /**
     * Determina si en alguno de los pasaportes hay por lo menos una atracción con el nombre dado.<br>
     * <b>pre:</b> La lista de pasaportes está inicializada. <br>
     * @param pNombreAtraccion Nombre de la atracción. pNombreAtraccion != null && pNombreAtraccion != "".
     * @return True si la atracción está en algún pasaporte, false de lo contrario.
     */
    public boolean existeAtraccionPasaportes( String pNombreAtraccion )
    {
        boolean hay = false;
        for( int i = 0; i < pasaportes.size( ) && !hay; i++ )
        {
            Pasaporte pasaporteActual = ( Pasaporte )pasaportes.get( i );
            hay = pasaporteActual.existeAtraccion( pNombreAtraccion );
        }

        return hay;
    }

    /**
     * Agrega una nueva atracción a la lista de atracciones. <br>
     * <b>pre:</b>La lista de atracciones está inicializada. <br>
     * <b>post:</b> Se agregó la atracción al parque. <br>
     * @param pNombre Nombre de la atracción. pNombre != null && pNombre != "".
     * @param pPrecio Precio de la entrada a la atracción. pPrecio != 0.
     * @param pTipo Tipo de atracción. pTipo != null && pTipo != "" && (pTipo == INFANTIL || pTipo == TERROR || pTipo == ACUATICA || pTipo == VELOCIDAD).
     * @throws Exception Si ya existe una atracción con el nombre dado.
     * @throws Exception Si el precio de la atracción es negativo, se captura la excepción, se cambia el número a positivo, se agrega la atracción y se lanza nuevamente la
     *         excepción con el mensaje correspondiente.
     */
    public void agregarAtraccion( String pNombre, double pPrecio, String pTipo ) throws Exception
    {

        // TODO Parte3 PuntoE: Complete el método según la documentación.

        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:

        // Error si ya existe una atracción con el nombre dado.
        // Mensaje de error: No se puede agregar la atracción porque ya existe una atracción con ese nombre.

        // Si se genera una excepción porque el precio es negativo, usted debe:
        // 1) Capturar la excepción.
        // 2) Cambiar el precio a positivo.
        // 3) Crear la atracción y agregarla al vector.
        // 4) Lanzar una excepción con el siguiente mensaje: El precio de la atracción fue cambiado automáticamente a positivo para ser agregado.
    	if(buscarAtraccion(pNombre)!=null)
    		throw new Exception ("No se puede agregar la atracción porque ya existe una atracción con ese nombre.");
    	else if(pPrecio<0)
    	{
    		pPrecio=pPrecio*-1;
    		atracciones.add(new Atraccion(pNombre,pPrecio,pTipo));
    		throw new Exception("El precio de la atracción fue cambiado automáticamente a positivo para ser agregado.");
    	}
    		atracciones.add(new Atraccion(pNombre,pPrecio,pTipo));
    	
    }

    /**
     * Agrega un pasaporte nuevo a la lista. <br>
     * <b>pre:</b> La lista de pasaportes está inicializada. <br>
     * <b>post:</b> Se agregó el pasaporte al parque. <br>
     * @param pNombreDuenio Nombre del dueño del pasaporte. pNombreDuenio != null && pNombreDuenio != "".
     * @param pCedulaDuenio Cédula del dueño del pasaporte. pCedulaDuenio > 0.
     * @param pCategoria Categoría del pasaporte. pCategoria != null && pCategoria != "" && (pCategoria == ORO || pCategoria == PLATA || pCategoria == BRONCE).
     * @throws Exception Si ya existe un pasaporte con la cédula dada.
     */
    public void agregarPasaporte( String pNombreDuenio, int pCedulaDuenio, String pCategoria ) throws Exception
    {
        // TODO Parte3 PuntoF: Complete el método según la documentación.

        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:

        // Error si ya existe un pasaporte con la cédula dada.
        // Mensaje de error:Ya existe un pasaporte con la cédula dada.
    	for(int i =0;i<pasaportes.size();i++)
    	{
    		Pasaporte p=(Pasaporte)pasaportes.get(i);
    		if(p.darCedulaDuenio()==pCedulaDuenio)
    			throw new Exception("Ya existe un pasaporte con la cédula dada.");
    	}
    	pasaportes.add(new Pasaporte(pNombreDuenio,pCedulaDuenio,pCategoria));

    }

    /**
     * Agregar una atracción a un pasaporte.<br>
     * <b>pre:</b> La lista de pasaportes está inicializada. <br>
     * La lista de atracciones está inicializada. <br>
     * <b> post: </b> El pasaporte tiene una atracción adicional.
     * @param pNombreAtraccion Nombre de la atracción a agregar. pNombreAtraccion != null && pNombreAtraccion != null.
     * @param pCedulaDuenio Cédula del dueño del pasaporte. pCedulaDuenio > 0.
     * @throws Exception Si no encuentra la atracción con el nombre dado.
     * @throws Exception Si no encuentra el pasaporte con la cédula dada.
     * @throws Exception Si la atracción que desea ser agregada no cumple las normas de las atracciones permitidas en un pasaporte.
     */
    public void agregarAtraccionAPasaporte( String pNombreAtraccion, int pCedulaDuenio ) throws Exception
    {
        Atraccion atraccionBuscada = buscarAtraccion( pNombreAtraccion );
        Pasaporte pasaporteBuscado = buscarPasaporte( pCedulaDuenio );
        if( atraccionBuscada == null )
        {
            throw new Exception( "No existe una atracción con el nombre dado." );
        }
        else if( pasaporteBuscado == null )
        {
            throw new Exception( "No existe un pasaporte con la cédula dada." );
        }
        else
        {
            pasaporteBuscado.agregarAtraccion( atraccionBuscada );
        }
    }

    /**
     * Elimina una atracción de la lista dado su nombre. <br>
     * <b>pre:</b>La lista de atracciones está inicializada. <br>
     * <b>post:</b> Se eliminó una atracción de la lista de atracciones.
     * @param pNombreAtraccion Nombre de la atracción a eliminar. pNombreAtraccion != null && pNombreAtraccion != "".
     * @throws Exception Si no existe una atracción con el nombre dado.
     * @throws Exception Si la atracción está presente en algún pasaporte.
     */
    public void eliminarAtraccion( String pNombreAtraccion ) throws Exception
    {

        // TODO Parte3 PuntoG: Complete el método según la documentación.

        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:

        // Error si la atracción está presente en algún pasaporte.
        // Mensaje de error: No se puede eliminar la atracción porque está presente en por lo menos un pasaporte.

        // Error si no existe una atracción con el nombre dado.
        // Mensaje de error: No existe una atracción con el nombre dado.
    	if(existeAtraccionPasaportes(pNombreAtraccion))
    		throw new Exception("No se puede eliminar la atracción porque está presente en por lo menos un pasaporte.");
    	else if(buscarAtraccion(pNombreAtraccion)==null)
    		throw new Exception("No existe una atracción con el nombre dado.");
    	atracciones.remove(buscarAtraccion(pNombreAtraccion));
    	
     }

    /**
     * Elimina un pasaporte de la lista de pasaportes.<br>
     * <b>pre:</b> La lista de pasaportes está inicializada. <br>
     * <b>post:</b> El pasaporte que tiene la cédula dada es eliminado.<br>
     * @param pCedulaDuenio Cédula del dueño del pasaporte. pCedulaDuenio > 0.
     * @throws Exception Si no existe un pasaporte con la cédula dada.
     * @throws Exception Si el pasaporte tiene estado VENDIDO.
     */
    public void eliminarPasaporte( int pCedulaDuenio ) throws Exception
    {

        // TODO Parte3 PuntoH: Complete el método según la documentación.

        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:

        // Error si el estado del pasaporte es vendido.
        // Mensaje de error: No se puede eliminar un pasaporte que haya sido vendido.

        // Error si no existe un pasaporte con la cédula dada.
        // Mensaje de error: No existe el pasaporte con la cédula dada.
    	if(buscarPasaporte(pCedulaDuenio)==null)
    		throw new Exception("No existe el pasaporte con la cédula dada.");
    	else if(buscarPasaporte(pCedulaDuenio).darEstado()==Pasaporte.VENDIDO)
    		throw new Exception("No se puede eliminar un pasaporte que haya sido vendido.");
    	
    	pasaportes.remove(buscarPasaporte(pCedulaDuenio));
    }

    // TODO Parte3 PuntoI: Escriba el contrato del método de acuerdo a la funcionalidad implementada.
    public void eliminarAtraccionDePasaporte( String pNombreAtraccion, int pCedulaDuenio ) throws Exception
    {
        Atraccion atraccionBuscada = buscarAtraccion( pNombreAtraccion );
        Pasaporte pasaporteBuscado = buscarPasaporte( pCedulaDuenio );
        if( atraccionBuscada == null )
        {
            throw new Exception( "No existe una atracción con el nombre dado." );
        }
        else if( pasaporteBuscado == null )
        {
            throw new Exception( "No existe un pasaporte con la cédula dada." );
        }
        else
        {
            pasaporteBuscado.eliminarAtraccion( pNombreAtraccion );
        }
    }

    /**
     * Vende el pasaporte que tiene la cédula dada.<br>
     * <b>pre:</b> La lista de pasaportes está inicializada. <br>
     * <b> post: </b> Se cambió el estado del pasaporte a VENDIDO.<br>
     * Suma al dinero en caja del parque el valor por el que fue vendido el pasaporte.
     * @param pCedulaDuenio Cédula del dueño del pasaporte. pCedulaDuenio > 0.
     * @return El valor por el cual fue vendido el pasaporte, -1 si no se pudo realizar la venta.
     * @throws Exception Si no encuentra el pasaporte con la cédula dada.
     * @throws Exception Si el pasaporte no cumple con la condiciones mínimas para ser vendido.
     */
    public double venderPasaporte( int pCedulaDuenio ) throws Exception
    {
        double valorVenta = -1;
        Pasaporte pasaporteBuscado = buscarPasaporte( pCedulaDuenio );
        if( pasaporteBuscado == null )
        {
            throw new Exception( "No existe un pasaporte con la cédula dada." );
        }
        else
        {
            pasaporteBuscado.vender( );
            valorVenta = pasaporteBuscado.calcularPrecio( );
            dineroCaja += valorVenta;
        }
        return valorVenta;
    }
    
    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}