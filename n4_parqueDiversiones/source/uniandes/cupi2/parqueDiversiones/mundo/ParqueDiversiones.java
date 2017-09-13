/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
    // TODO Parte3 PuntoC: Declare el atributo dineroCaja como un n�mero real.
	private double dineroCaja;


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo parque de diversiones. <br>
     * <b>post: </b> Inicializ� pasaportes y atracciones como listas vac�as. Inicializ� el dinero en caja en 0.<br>
     */
    public ParqueDiversiones( )
    {
        pasaportes = new ArrayList( );
        atracciones = new ArrayList( );
        dineroCaja = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
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
     * Retorna una lista con los pasaportes que est�n en elaboraci�n. <b>pre:</b> La lista de pasaportes est� inicializada. <br>
     * @return Lista con los pasaportes que est�n en elaboraci�n.
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
     * Retorna una lista con los pasaportes que han sido vendidos. <b>pre:</b> La lista de pasaportes est� inicializada. <br>
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
     * Retorna la atracci�n dado su nombre. <br>
     * <b>pre:</b> La lista de atracciones est� inicializada. <br>
     * @param pNombreAtraccion Nombre de la atracci�n que se est� buscando. pNombreAtraccion != null && pNombreAtraccion != "".
     * @return Atracci�n que se est� buscando, null en caso de no encontrarlo.
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
     * Retorna el pasaporte que pertenece a la persona que tiene la c�dula dada por par�metro.<br>
     * <b>pre:</b> La lista de pasaportes est� inicializada. <br>
     * @param pCedulaDuenio C�dula del due�o del pasaporte que se est� buscando. pCedulaDuenio > 0.
     * @return Pasaporte que se est� buscando, null en caso de no encontrarlo.
     */
    public Pasaporte buscarPasaporte( int pCedulaDuenio )
    {
        // TODO Parte3 PuntoD: Complete el m�todo seg�n la documentaci�n.
    	for(int i=0;i<pasaportes.size();i++)
    	{
    		Pasaporte p=(Pasaporte)pasaportes.get(i);
    		if(p.darCedulaDuenio()==pCedulaDuenio)
    			return p;
    	}
    	return null;
    }

    /**
     * Determina si en alguno de los pasaportes hay por lo menos una atracci�n con el nombre dado.<br>
     * <b>pre:</b> La lista de pasaportes est� inicializada. <br>
     * @param pNombreAtraccion Nombre de la atracci�n. pNombreAtraccion != null && pNombreAtraccion != "".
     * @return True si la atracci�n est� en alg�n pasaporte, false de lo contrario.
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
     * Agrega una nueva atracci�n a la lista de atracciones. <br>
     * <b>pre:</b>La lista de atracciones est� inicializada. <br>
     * <b>post:</b> Se agreg� la atracci�n al parque. <br>
     * @param pNombre Nombre de la atracci�n. pNombre != null && pNombre != "".
     * @param pPrecio Precio de la entrada a la atracci�n. pPrecio != 0.
     * @param pTipo Tipo de atracci�n. pTipo != null && pTipo != "" && (pTipo == INFANTIL || pTipo == TERROR || pTipo == ACUATICA || pTipo == VELOCIDAD).
     * @throws Exception Si ya existe una atracci�n con el nombre dado.
     * @throws Exception Si el precio de la atracci�n es negativo, se captura la excepci�n, se cambia el n�mero a positivo, se agrega la atracci�n y se lanza nuevamente la
     *         excepci�n con el mensaje correspondiente.
     */
    public void agregarAtraccion( String pNombre, double pPrecio, String pTipo ) throws Exception
    {

        // TODO Parte3 PuntoE: Complete el m�todo seg�n la documentaci�n.

        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:

        // Error si ya existe una atracci�n con el nombre dado.
        // Mensaje de error: No se puede agregar la atracci�n porque ya existe una atracci�n con ese nombre.

        // Si se genera una excepci�n porque el precio es negativo, usted debe:
        // 1) Capturar la excepci�n.
        // 2) Cambiar el precio a positivo.
        // 3) Crear la atracci�n y agregarla al vector.
        // 4) Lanzar una excepci�n con el siguiente mensaje: El precio de la atracci�n fue cambiado autom�ticamente a positivo para ser agregado.
    	if(buscarAtraccion(pNombre)!=null)
    		throw new Exception ("No se puede agregar la atracci�n porque ya existe una atracci�n con ese nombre.");
    	else if(pPrecio<0)
    	{
    		pPrecio=pPrecio*-1;
    		atracciones.add(new Atraccion(pNombre,pPrecio,pTipo));
    		throw new Exception("El precio de la atracci�n fue cambiado autom�ticamente a positivo para ser agregado.");
    	}
    		atracciones.add(new Atraccion(pNombre,pPrecio,pTipo));
    	
    }

    /**
     * Agrega un pasaporte nuevo a la lista. <br>
     * <b>pre:</b> La lista de pasaportes est� inicializada. <br>
     * <b>post:</b> Se agreg� el pasaporte al parque. <br>
     * @param pNombreDuenio Nombre del due�o del pasaporte. pNombreDuenio != null && pNombreDuenio != "".
     * @param pCedulaDuenio C�dula del due�o del pasaporte. pCedulaDuenio > 0.
     * @param pCategoria Categor�a del pasaporte. pCategoria != null && pCategoria != "" && (pCategoria == ORO || pCategoria == PLATA || pCategoria == BRONCE).
     * @throws Exception Si ya existe un pasaporte con la c�dula dada.
     */
    public void agregarPasaporte( String pNombreDuenio, int pCedulaDuenio, String pCategoria ) throws Exception
    {
        // TODO Parte3 PuntoF: Complete el m�todo seg�n la documentaci�n.

        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:

        // Error si ya existe un pasaporte con la c�dula dada.
        // Mensaje de error:Ya existe un pasaporte con la c�dula dada.
    	for(int i =0;i<pasaportes.size();i++)
    	{
    		Pasaporte p=(Pasaporte)pasaportes.get(i);
    		if(p.darCedulaDuenio()==pCedulaDuenio)
    			throw new Exception("Ya existe un pasaporte con la c�dula dada.");
    	}
    	pasaportes.add(new Pasaporte(pNombreDuenio,pCedulaDuenio,pCategoria));

    }

    /**
     * Agregar una atracci�n a un pasaporte.<br>
     * <b>pre:</b> La lista de pasaportes est� inicializada. <br>
     * La lista de atracciones est� inicializada. <br>
     * <b> post: </b> El pasaporte tiene una atracci�n adicional.
     * @param pNombreAtraccion Nombre de la atracci�n a agregar. pNombreAtraccion != null && pNombreAtraccion != null.
     * @param pCedulaDuenio C�dula del due�o del pasaporte. pCedulaDuenio > 0.
     * @throws Exception Si no encuentra la atracci�n con el nombre dado.
     * @throws Exception Si no encuentra el pasaporte con la c�dula dada.
     * @throws Exception Si la atracci�n que desea ser agregada no cumple las normas de las atracciones permitidas en un pasaporte.
     */
    public void agregarAtraccionAPasaporte( String pNombreAtraccion, int pCedulaDuenio ) throws Exception
    {
        Atraccion atraccionBuscada = buscarAtraccion( pNombreAtraccion );
        Pasaporte pasaporteBuscado = buscarPasaporte( pCedulaDuenio );
        if( atraccionBuscada == null )
        {
            throw new Exception( "No existe una atracci�n con el nombre dado." );
        }
        else if( pasaporteBuscado == null )
        {
            throw new Exception( "No existe un pasaporte con la c�dula dada." );
        }
        else
        {
            pasaporteBuscado.agregarAtraccion( atraccionBuscada );
        }
    }

    /**
     * Elimina una atracci�n de la lista dado su nombre. <br>
     * <b>pre:</b>La lista de atracciones est� inicializada. <br>
     * <b>post:</b> Se elimin� una atracci�n de la lista de atracciones.
     * @param pNombreAtraccion Nombre de la atracci�n a eliminar. pNombreAtraccion != null && pNombreAtraccion != "".
     * @throws Exception Si no existe una atracci�n con el nombre dado.
     * @throws Exception Si la atracci�n est� presente en alg�n pasaporte.
     */
    public void eliminarAtraccion( String pNombreAtraccion ) throws Exception
    {

        // TODO Parte3 PuntoG: Complete el m�todo seg�n la documentaci�n.

        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:

        // Error si la atracci�n est� presente en alg�n pasaporte.
        // Mensaje de error: No se puede eliminar la atracci�n porque est� presente en por lo menos un pasaporte.

        // Error si no existe una atracci�n con el nombre dado.
        // Mensaje de error: No existe una atracci�n con el nombre dado.
    	if(existeAtraccionPasaportes(pNombreAtraccion))
    		throw new Exception("No se puede eliminar la atracci�n porque est� presente en por lo menos un pasaporte.");
    	else if(buscarAtraccion(pNombreAtraccion)==null)
    		throw new Exception("No existe una atracci�n con el nombre dado.");
    	atracciones.remove(buscarAtraccion(pNombreAtraccion));
    	
     }

    /**
     * Elimina un pasaporte de la lista de pasaportes.<br>
     * <b>pre:</b> La lista de pasaportes est� inicializada. <br>
     * <b>post:</b> El pasaporte que tiene la c�dula dada es eliminado.<br>
     * @param pCedulaDuenio C�dula del due�o del pasaporte. pCedulaDuenio > 0.
     * @throws Exception Si no existe un pasaporte con la c�dula dada.
     * @throws Exception Si el pasaporte tiene estado VENDIDO.
     */
    public void eliminarPasaporte( int pCedulaDuenio ) throws Exception
    {

        // TODO Parte3 PuntoH: Complete el m�todo seg�n la documentaci�n.

        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:

        // Error si el estado del pasaporte es vendido.
        // Mensaje de error: No se puede eliminar un pasaporte que haya sido vendido.

        // Error si no existe un pasaporte con la c�dula dada.
        // Mensaje de error: No existe el pasaporte con la c�dula dada.
    	if(buscarPasaporte(pCedulaDuenio)==null)
    		throw new Exception("No existe el pasaporte con la c�dula dada.");
    	else if(buscarPasaporte(pCedulaDuenio).darEstado()==Pasaporte.VENDIDO)
    		throw new Exception("No se puede eliminar un pasaporte que haya sido vendido.");
    	
    	pasaportes.remove(buscarPasaporte(pCedulaDuenio));
    }

    // TODO Parte3 PuntoI: Escriba el contrato del m�todo de acuerdo a la funcionalidad implementada.
    public void eliminarAtraccionDePasaporte( String pNombreAtraccion, int pCedulaDuenio ) throws Exception
    {
        Atraccion atraccionBuscada = buscarAtraccion( pNombreAtraccion );
        Pasaporte pasaporteBuscado = buscarPasaporte( pCedulaDuenio );
        if( atraccionBuscada == null )
        {
            throw new Exception( "No existe una atracci�n con el nombre dado." );
        }
        else if( pasaporteBuscado == null )
        {
            throw new Exception( "No existe un pasaporte con la c�dula dada." );
        }
        else
        {
            pasaporteBuscado.eliminarAtraccion( pNombreAtraccion );
        }
    }

    /**
     * Vende el pasaporte que tiene la c�dula dada.<br>
     * <b>pre:</b> La lista de pasaportes est� inicializada. <br>
     * <b> post: </b> Se cambi� el estado del pasaporte a VENDIDO.<br>
     * Suma al dinero en caja del parque el valor por el que fue vendido el pasaporte.
     * @param pCedulaDuenio C�dula del due�o del pasaporte. pCedulaDuenio > 0.
     * @return El valor por el cual fue vendido el pasaporte, -1 si no se pudo realizar la venta.
     * @throws Exception Si no encuentra el pasaporte con la c�dula dada.
     * @throws Exception Si el pasaporte no cumple con la condiciones m�nimas para ser vendido.
     */
    public double venderPasaporte( int pCedulaDuenio ) throws Exception
    {
        double valorVenta = -1;
        Pasaporte pasaporteBuscado = buscarPasaporte( pCedulaDuenio );
        if( pasaporteBuscado == null )
        {
            throw new Exception( "No existe un pasaporte con la c�dula dada." );
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
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}