/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_cupiTrenes
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiTrenes.mundo;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa un tren. <br>
 * <b>inv:</b><br>
 * No hay dos vagones con el mismo número.<br>
 * La lista de paradas está inicializada.<br>
 */
public class Tren implements Serializable
{

    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante de serialización de la clase.
     */
    private static final long serialVersionUID = -6154554262789086130L;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Número que identifica el tren.
     */
    private int id;

    /**
     * Siguiente tren.
     */
    // TODO Parte2 PuntoA: Declarar el atributo siguienteTren.
    // Este atributo guarda la referencia al siguiente tren en la lista.
    private Tren siguienteTren;

    /**
     * Tren anterior.
     */
    // TODO Parte2 PuntoB: Declarar el atributo anteriorTren.
    // Este atributo guarda la referencia al anterior tren en la lista.
    private Tren anteriorTren;
    /**
     * Primer vagón del tren.
     */
    // TODO Parte1 PuntoE: Declarar el atributo primerVagon.
    private Vagon primerVagon;

    /**
     * Paradas del tren.
     */
    private ArrayList paradas;

    /**
     * Cantidad de dinero recaudado en ventas de tiquetes del tren.
     */
    private double cantidadRecaudada;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Constructor de un tren.<br>
     * <b>post:</b> Se crea un tren con el id dado por parámetro. <br>
     * La cantidad recaudada fue inicializada en 0.<br>
     * La lista de paradas se crea como un vector vacío.<br>
     * El primer vagón, el tren anterior y el siguiente tren son nulos.
     * @param pId Número que identifica el tren.
     */
    public Tren( int pId )
    {
        id = pId;
        cantidadRecaudada = 0;
        // TODO Parte1 PuntoF: Inicializar el atributo primerVagon en null.
        primerVagon = null;
        anteriorTren = null;
        siguienteTren = null;
        paradas = new ArrayList( );
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna el siguiente tren.
     * @return Siguiente tren.
     */
    // TODO Parte2 PuntoC: Agregar el método darSiguiente de acuerdo a la documentación.
    public Tren darSiguiente()
    {
    	return siguienteTren;
    }

    /**
     * Retorna el tren anterior.
     * @return Tren anterior.
     */
    // TODO Parte2 PuntoD: Agregar el método darAnterior de acuerdo a la documentación.
    public Tren darAnterior()
    {
    	return anteriorTren;
    }
    /**
     * Retorna el primer vagón del tren.
     * @return Primer vagón del tren.
     */
    public Vagon darPrimerVagon( )
    {
        return primerVagon;
    }

    /**
     * Retorna el id del tren.
     * @return Id del tren.
     */
    public int darId( )
    {
        return id;
    }

    /**
     * Retorna las paradas del tren.
     * @return Lista de paradas del tren.
     */
    public ArrayList darParadas( )
    {
        return paradas;
    }

    /**
     * Retorna el origen del tren. <br>
     * Se entiende como origen la primera parada del tren.
     * @return El origen del tren.
     */
    public String darOrigen( )
    {
        Parada primera = ( Parada )paradas.get( 0 );
        return primera.darNombre( );
    }

    /**
     * Retorna el destino del tren. <br>
     * Se entiende como destino la última parada del tren.
     * @return Destino del tren.
     */
    public String darDestino( )
    {
        Parada ultima = ( Parada )paradas.get( paradas.size( ) - 1 );
        return ultima.darNombre( );
    }

    /**
     * Retorna la cantidad recaudada por la venta de tiquetes del tren.
     * @return Cantidad recaudada.
     */
    public double darCantidadRecaudada( )
    {
        return cantidadRecaudada;
    }


    /**
     * Retorna el horario de salida (primera parada) del tren.
     * @return Horario de salida.
     */
    public String darHorarioSalida( )
    {
        Parada primera = ( Parada )paradas.get( 0 );
        return primera.darHorario( );
    }

    /**
     * Retorna el horario de llegada (última parada) del tren.
     * @return Horario de llegada.
     */
    public String darHorarioLlegada( )
    {
        Parada ultima = ( Parada )paradas.get( paradas.size( ) - 1 );
        return ultima.darHorario( );
    }

    /**
     * Retorna los números de los vagones.
     * @return Una lista con los números de los vagones.
     */
    public ArrayList darNumerosVagones( )
    {
        ArrayList numeros = new ArrayList( );

        Vagon actual = primerVagon;
        while( actual != null )
        {
            numeros.add( actual.darNumero( ) );
            actual = actual.darSiguiente( );
        }

        return numeros;
    }

    /**
     * Retorna la cantidad total de sillas disponibles en el tren.
     * @return Cantidad de sillas disponibles.
     */
    public int darCantidadSillasDisponibles( )
    {
        // TODO Parte1 PuntoJ: Completar el método darCantidadSillasDisponibles según la documentación del método.
    	if(primerVagon==null)
    	{
    		return 0;
    	}
    	int sillas =0;
    	Vagon actual = primerVagon;
    	while(actual!=null)
    	{	
    		sillas += actual.darCantidadSillasDisponibles();
    		
    		actual=actual.darSiguiente();
    	}
    	
    	return sillas;
    }

    /**
     * Busca el vagón con el número dado por parámetro.<br>
     * @param pNumeroVagon Número del vagón buscado. pNumeroVagon > 0.
     * @return Vagón buscado, null en caso de no encontrarlo.
     */
    public Vagon buscarVagon( int pNumeroVagon )
    {
        // TODO Parte1 PuntoH: Completar el método buscarVagon según la documentación del método.
    	if(primerVagon==null)
    	{
    		return null;
    	}
    	
    	Vagon actual = primerVagon;
    	
    	while(actual!=null)
    	{	
    		
    		if(actual.darNumero()==pNumeroVagon)
    			return actual;
    		
    		actual=actual.darSiguiente();
    	}
    	
    	return null;
    	
    }

    /**
     * Verifica si dentro de las paradas del tren se encuentran las ciudades de origen y destino dados por parámetro y en ese orden. <br>
     * @param pOrigen Lugar desde donde se desea partir. pOrigen != null && pOrigen != "".
     * @param pDestino Lugar hacia donde se desea viajar. pDestino != null && pDestino != "".
     * @return True si las ciudades se encuentran dentro de las paradas del tren, false de lo contrario.
     */
    public boolean tieneParadas( String pOrigen, String pDestino )
    {
        boolean encontro = false;
        boolean encontroOrigen = false;
        for( int i = 0; i < paradas.size( ) && !encontro; i++ )
        {
            Parada actual = ( Parada )paradas.get( i );
            if( !encontroOrigen )
            {
                if( pOrigen.equalsIgnoreCase( actual.darNombre( ) ) )
                {
                    encontroOrigen = true;
                }
            }
            else
            {
                if( pDestino.equalsIgnoreCase( actual.darNombre( ) ) )
                {
                    encontro = true;
                }
            }
        }
        return encontro;
    }

    /**
     * Cambia el siguiente tren por el dado por parámetro.<br>
     * <b>post:</b> Se cambió el siguiente tren por el dado por parámetro.<br>
     * @param pSiguiente Siguiente tren.
     */
    // TODO Parte2 PuntoE: Agregar el método cambiarSiguiente de acuerdo a la documentación.
    public void cambiarSiguiente(Tren pSiguiente)
    {
    	siguienteTren = pSiguiente;
    }
    /**
     * Cambia el tren anterior por el dado por parámetro.<br>
     * <b>post:</b> Se cambió el tren anterior por el dado por parámetro.<br>
     * @param pAnterior Tren anterior.
     */
    // TODO Parte2 PuntoF: Agregar el método cambiarAnterior de acuerdo a la documentación.
    public void cambiarAnterior(Tren pAnterior)
    {
    	anteriorTren = pAnterior;
    }

    /**
     * Agrega una nueva parada al tren.<br>
     * <b> pre: </b> El horario de la parada es posterior a los horarios de las paradas ya existentes.
     * <b> post: </b> Se agregó una nueva parada al arreglo de paradas.
     * @param pParada Parada del tren a ser agregada. pParada != null.
     */
    public void agregarParada( Parada pParada )
    {
        paradas.add( pParada );
    }

    /**
     * Agrega un nuevo vagón con los valores dados por parámetro.<br>
     * <b>post:</b> El vagón fue agregado al final de la lista.<br>
     * @param pNumeroVagon Número del vagón. pNumeroVagon > 0.
     * @param pCantidadSillas Cantidad de sillas en el vagón. pCantidadSillasDisponibles >= 0.
     * @param pClase Clase del vagón. pClase pertenece a CLASES.
     * @param pPrecio Precio de una silla en el vagón. pPrecio >= 0
     * @throws ElementoExisteException Si ya existe un vagón con el número dado.
     */
    public void agregarVagon( int pNumeroVagon, int pCantidadSillas, String pClase, double pPrecio ) throws ElementoExisteException
    {
        // TODO Parte1 PuntoG: Completar el método agregarVagon según la documentación del método.
    	Vagon actual = primerVagon;
    	//System.out.println(primerVagon);
    	if(buscarVagon(pNumeroVagon)!=null)
    		throw new ElementoExisteException("Ya existe vagon con ese numero");
    	
    	else if(primerVagon==null)
    	{
    		primerVagon = new Vagon(pNumeroVagon, pCantidadSillas, pClase, pPrecio);
    		//return;
    	}
    	else
    	{
    		boolean entrar = true;
    		while(actual!=null&&entrar)
    		{
    			if(actual.darSiguiente()==null)
    			{
    				actual.cambiarSiguiente(new Vagon(pNumeroVagon, pCantidadSillas, pClase, pPrecio));
    				entrar = false;
    				
    				//Vagon nuevo =new Vagon(pNumeroVagon, pCantidadSillas, pClase, pPrecio); 
    				//Vagon siguiente = actual.darSiguiente();
    				//actual.cambiarSiguiente(nuevo);
    				//nuevo.cambiarSiguiente(siguiente);
    			}
    			else
    			{
    				actual = actual.darSiguiente();
    			}
    		}
    	}
    }

    /**
     * Elimina el vagón que tiene el número dado por parámetro.<br>
     * <b>post:</b> El vagón fue eliminado de la lista.<br>
     * @param pNumeroVagon Número del vagón a eliminar. pNumeroVagon > 0.
     * @throws ElementoNoExisteException Si no existe un vagón con el número dado.
     */
    public void eliminarVagon( int pNumeroVagon ) throws ElementoNoExisteException
    {
        // TODO Parte1 PuntoI: Completar el método eliminarVagon según la documentación del método.
    	//Vagon actual = primerVagon;
    	if(buscarVagon(pNumeroVagon)==null)
    		throw new ElementoNoExisteException("No exite el vagon a eliminar");
    	else if (buscarVagon(pNumeroVagon)!=null)
    	{
    		Vagon actual = primerVagon;
    		while(actual!=null)
    		{
    			if(actual.darSiguiente().darNumero()==pNumeroVagon)
    			{
    				actual.cambiarSiguiente(actual.darSiguiente().darSiguiente());
    				return;
    			}
    			if(actual==primerVagon)
    			{
    				primerVagon=actual.darSiguiente();
    				return;
    			}
    			if(actual.darSiguiente().darSiguiente()==null)
    			{
    				actual.cambiarSiguiente(null);
    			}
    			
    			actual = actual.darSiguiente();
    		}
    	}
    	
    }

    /**
     * Vende un tiquete del vagón con el número dado.<br>
     * <b>post:</b> Se aumentó la cantidad recaudada con el precio del tiquete.<br>
     * @param pNumeroVagon Número del vagón donde se quiere vender el tiquete. pNumeroVagon > 0.
     * @return True si el tiquete fue vendido, false de lo contrario.
     * @throws ElementoNoExisteException Si no existe un vagón con el número dado.
     */
    public boolean venderTiquete( int pNumeroVagon ) throws ElementoNoExisteException
    {
        Vagon buscado = buscarVagon( pNumeroVagon );
        if( buscado == null )
        {
            throw new ElementoNoExisteException( "No existe un vagón con número " + pNumeroVagon );
        }
        else
        {
            boolean vendido = buscado.venderTiquete( );
            if( vendido )
            {
                cantidadRecaudada += buscado.darPrecio( );
            }

            return vendido;
        }
    }

    /**
     * Imprime en un archivo los datos del tren.<br>
     * @param pEscritor Objeto que escribe en un archivo de reporte. pEscritor != null.
     */
    public void imprimirDetallesTren( PrintWriter pEscritor )
    {
        pEscritor.println( "______________________" );
        pEscritor.println( );
        pEscritor.println( "Id tren:  " + id );
        pEscritor.println( "Primera parada: " + darOrigen( ) + " - " + darHorarioSalida( ) );
        pEscritor.println( "Última parada: " + darDestino( ) + " - " + darHorarioLlegada( ) );
        pEscritor.println( "Cantidad de paradas: " + paradas.size( ) );
        pEscritor.println( "Cantidad recaudada: " + darCantidadRecaudada( ) );
        pEscritor.println( "Cantidad sillas disponibles: " + darCantidadSillasDisponibles( ) );
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv:</b><br>
     * No hay dos vagones con el mismo número.<br>
     * La lista de paradas está inicializada. <br>
     * */
    private void verificarInvariante( )
    {
        assert !hayNumeroVagonesRepetidos( ) : "Hay más de un vagón con el mismo id.";
        assert paradas != null : "La lista de paradas no está inicializada.";
    }

    /**
     * Verifica si hay dos vagones con el mismo número.
     * @return True si hay dos vagones con el mismo número, false de lo contrario.
     */
    private boolean hayNumeroVagonesRepetidos( )
    {
        boolean respuesta = false;
        Vagon vagon1 = primerVagon;
        while( vagon1 != null && !respuesta )
        {
            Vagon vagon2 = vagon1.darSiguiente( );
            while( vagon2 != null )
            {
                if( vagon2.darNumero( ) == vagon1.darNumero( ) )
                    respuesta = true;
                vagon2 = vagon2.darSiguiente( );
            }
            vagon1 = vagon1.darSiguiente( );
        }
        return respuesta;
    }

}