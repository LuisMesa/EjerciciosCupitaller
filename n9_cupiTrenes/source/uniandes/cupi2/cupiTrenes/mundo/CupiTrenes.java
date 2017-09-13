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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa el manejador de trenes CupiTrenes.<br>
 * <b>inv:</b><br>
 * No hay dos trenes con el mismo id.<br>
 */
public class CupiTrenes implements Serializable
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante de serialización de la clase.
     */
    private static final long serialVersionUID = 8200346310786852815L;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El primer tren CupiTrenes.
     */
    // TODO Parte2 PuntoG: Declarar el atributo que guarda la referencia al primer tren.
    private Tren primerTren;

    /**
     * Ruta donde se guarda el archivo con la información del mundo.
     */
    private String rutaArchivo;
    
    private Tren ultimo;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Constructor del manejador de los trenes.<br>
     * <b>post:</b> El archivo que está identificado con pRutaArchivo queda cargado en el sistema.<br>
     * Si existe un archivo con la información del mundo, crea la clase a partir esta información.
     * @param pRutaArchivo La ruta del archivo del cuál se carga la información de los trenes. pRutaArchivo != null && pRutaArchivo != "".
     * @throws PersistenciaException Si se presenta algún problema cargando el archivo.
     */
    public CupiTrenes( String pRutaArchivo ) throws PersistenciaException
    {
        rutaArchivo = pRutaArchivo;
        abrir( );
        verificarInvariante( );
    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna el primer tren.
     * @return Primer tren.
     */
    // TODO Parte2 PuntoH: Agregar el método darPrimerTren de acuerdo a la documentación.
    public Tren darPrimerTren()
    {
    	return primerTren;
    }

    /**
     * Retorna el total de sillas disponibles en todos los trenes.
     * @return Cantidad de sillas disponibles.
     */
    public int darTotalSillasDisponibles( )
    {
    	// TODO Parte2 PuntoI: Completar el método darTotalSillasDisponibles de acuerdo a la documentación.
        int contador =0;
        Tren actual = primerTren;
        while(actual!=null)
        {
        	contador +=actual.darCantidadSillasDisponibles();
        	actual = actual.darSiguiente();
        }
        return contador;
    }

    /**
     * Retorna el total de dinero recaudado.
     * @return Total recaudado.
     */
    public double darTotalRecaudo( )
    {
        // TODO Parte2 PuntoJ: Completar el método darTotalRecaudo de acuerdo a la documentación.
    	double contador =0;
        Tren actual = primerTren;
        while(actual!=null)
        {
        	contador +=actual.darCantidadRecaudada();
        	actual = actual.darSiguiente();
        }
        return contador;
    }

    /**
     * Retorna los identificadores de todos los trenes.
     * @return Los identificadores de los trenes.
     */
    public ArrayList darIdTrenes( )
    {
        ArrayList identificadores = new ArrayList( );

        Tren actual = primerTren;
        while( actual != null )
        {
            identificadores.add( actual.darId( ) );
            actual = actual.darSiguiente( );
        }

        return identificadores;
    }

    /**
     * Retorna los números de los vagones de un tren con un id dado.
     * @return Una lista con los números de los vagones de un tren.
     * @param pIdTren El identificador del tren. pIdTren != null && pIdTren >= 0.
     */
    public ArrayList darNumerosVagones( int pIdTren )
    {
        ArrayList numeros = new ArrayList( );
        Tren trenBuscado = buscarTrenPorId( pIdTren );

        return trenBuscado.darNumerosVagones( );
    }

    /**
     * Recupera el estado a partir del archivo serializado.<br>
     * <b>post:</b> El archivo queda cargado en el sistema.
     * @throws PersistenciaException Si se presenta algún problema al cargar la información.
     */
    public void abrir( ) throws PersistenciaException
    {
        File archivo = new File( rutaArchivo );
        if( archivo.exists( ) )
        {
            try
            {
                ObjectInputStream ois = new ObjectInputStream( new FileInputStream( archivo ) );
                primerTren = ( Tren )ois.readObject( );
                ois.close( );
            }
            catch( Exception e )
            {
                primerTren = null;
                throw new PersistenciaException( "Error fatal: imposible restaurar el estado del programa (" + e.getMessage( ) + ")." );
            }
        }
        else
        {
            primerTren = null;
        }

        verificarInvariante( );
    }

    /**
     * Busca un tren que le sirva al pasajero que desea viajar desde el lugar de origen hasta el lugar de destino dados. <br>
     * Se deben tener en cuenta las paradas que hace cada tren y el orden de las mismas. <br>
     * El origen y destino dados por parámetro no necesariamente corresponden a la primera y última parada del tren
     * @param pOrigen Ciudad desde donde se desea viajar. pRrigen != null && pRrigen != "".
     * @param pDestino . Ciudad hasta donde se desea viajar. pDestino != null && pDestino != "".
     * @return Tren que tiene dentro de sus paradas el origen y destino dados, null si no se encuentra un tren con las características dadas.
     */

    public Tren buscarTrenPorParadas( String pOrigen, String pDestino )
    {
    	// TODO Parte2 PuntoK: Completar el método buscarTrenPorParadas de acuerdo a la documentación.
    	Tren rta = null;
    	
        Tren actual =primerTren;
        
        while(actual!=null)
        {
        	ArrayList paradas = actual.darParadas();
        	boolean parada1=false;
        	boolean parada2 = false;
        	for(int i=0;i<paradas.size();i++)
        	{
        		if(((Parada)paradas.get(i)).darNombre().equals(pOrigen))
        		{
        			parada1=true;
        		}
        		else if(((Parada)paradas.get(i)).darNombre().equals(pDestino)&&parada1==true)
        		{
        			parada2=true;
        		}
        		
        	}
        	if(parada1==true&&parada2==true)
        		return actual;
        	
        	actual = actual.darSiguiente();
        }
    	
        return rta;
        
    }

    /**
     * Retorna el tren con el id dado de parámetro.
     * @param pIdTren Id del tren a buscar.
     * @return Tren buscado, null en caso de no encontrarla.
     */
    public Tren buscarTrenPorId( int pIdTren )
    {
        // TODO Parte2 PuntoL: Completar el método buscarTrenPorId de acuerdo a la documentación.
    	Tren actual = primerTren;
    	while(actual!=null)
    	{
    		if(actual.darId()==pIdTren)
    			return actual;
    		actual = actual.darSiguiente();
    	}
    	
    	return null;
    }

    /**
     * Agrega un nuevo tren con la información dada por parámetro. <br>
     * <b>pre: </b> El arreglo de nombres y el arreglo de horarios de paradas tienen el mismo tamaño y los arreglos están ordenados.
     * <b>post:</b> Se agregó el nuevo tren a la lista y ésta se encuentra ordenada ascendentemente por hora de la parada de origen.
     * @param pIdTren Id del tren a agregar.
     * @param pNombresParadas Arreglo con los nombres de las paradas del tren. pNombresParadas != null.
     * @param pHorariosParadas Arreglo con los horarios de las paradas del tren. pHorariosParadas != null.
     * @throws ElementoExisteException Si ya existe un tren con el id ingresado por parámetro.
     */
    public void agregarTren( int pIdTren, String[] pNombresParadas, Date[] pHorariosParadas ) throws ElementoExisteException
    {
        // TODO Parte2 PuntoM: Completar el método agregarTren de acuerdo a la documentación.
    	if(buscarTrenPorId(pIdTren)!=null)
    		throw new ElementoExisteException("Ya existe ese tren");
    	
    	Tren nuevo = new Tren(pIdTren);
    	for(int i = 0;i<pNombresParadas.length;i++)
    	{
    		Parada parada = new Parada(pNombresParadas[i], pHorariosParadas[i]);
    		nuevo.agregarParada(parada);
    	}
    	
    	if(primerTren==null)
    	{
    		primerTren = nuevo;
    		return;
    	}
    	else
    	{
    		Tren actual = primerTren;
    		//Minutos nuevo
    		int minutosH = Integer.parseInt((nuevo.darHorarioSalida().split(":")[0]))*60;
    		int minutosM = Integer.parseInt((nuevo.darHorarioSalida().split(":")[1]));
    		int minutosN = minutosH+minutosM;
    		//boolean entrar = true;
    		while(actual!=null)
    		{
    			//Minutos Actual/anterior
    			int minutosAH = Integer.parseInt((actual.darHorarioSalida().split(":")[0]))*60;
        		int minutosAM = Integer.parseInt((actual.darHorarioSalida().split(":")[1]));
        		int minutosAT = minutosAH+minutosAM;
        		if(actual ==primerTren&&minutosN<=minutosAT)
    			{
    				nuevo.cambiarSiguiente(actual);
    				actual.cambiarAnterior(nuevo);
    				primerTren = nuevo;
    				return;
    			}
        		
        		if(actual.darSiguiente()==null)
				{
					nuevo.cambiarAnterior(actual);
					actual.cambiarSiguiente(nuevo);
					return;
					
				}
        		//Minutos del siguiente
        		int minutosSH = Integer.parseInt((actual.darSiguiente().darHorarioSalida().split(":")[0]))*60;
        		int minutosSM = Integer.parseInt((actual.darSiguiente().darHorarioSalida().split(":")[1]));
        		int minutosST = minutosSH+minutosSM;
        		
    			if(minutosN>=minutosAT&&minutosN<=minutosST)
    			{
    				
    					Tren siguiente = actual.darSiguiente();
    					
    					siguiente.cambiarAnterior(nuevo);
    					nuevo.cambiarSiguiente(siguiente);
    					nuevo.cambiarAnterior(actual);
    					actual.cambiarSiguiente(nuevo);
    					
    					return;
    			}
    			
    			
    			actual = actual.darSiguiente();
    		}
    		
    		
    	}
    	
    	
    }
    public void agregarTrenI(int pIdTren, String[] pNombresParadas, Date[] pHorariosParadas ) throws ElementoExisteException
    {
        // TODO Parte2 PuntoM: Completar el método agregarTren de acuerdo a la documentación.
    	if(buscarTrenPorId(pIdTren)!=null)
    		throw new ElementoExisteException("Ya existe ese tren");
    	
    	Tren nuevo = new Tren(pIdTren);
    	for(int i = 0;i<pNombresParadas.length;i++)
    	{
    		Parada parada = new Parada(pNombresParadas[i], pHorariosParadas[i]);
    		nuevo.agregarParada(parada);
    	}
    
    	if(ultimo==null)
    	{
    		ultimo=nuevo;
    		primerTren = nuevo;
    		return;
    	}
    	Tren actual =ultimo;
    	while(actual!=null)
    	{
    		if(actual ==ultimo &&nuevo.darHorarioSalida().compareTo(actual.darHorarioSalida())<0)
    		{
    			
    			ultimo.cambiarSiguiente(nuevo);
    			nuevo.cambiarAnterior(ultimo);
    			ultimo=nuevo;
    			return;
    		}
    		if(actual==primerTren&&nuevo.darHorarioSalida().compareTo(actual.darHorarioSalida())>=0)
    		{
    			nuevo.cambiarSiguiente(actual);
    			actual.cambiarAnterior(nuevo);
    			primerTren = nuevo;
    			return;
    		}
    		if(nuevo.darHorarioSalida().compareTo(actual.darHorarioSalida())>0&&nuevo.darHorarioSalida().compareTo(actual.darAnterior().darHorarioSalida())<=0)
    		{
    			Tren anterior =actual.darAnterior();
    			nuevo.cambiarSiguiente(actual);
    			anterior.cambiarSiguiente(nuevo);
    			nuevo.cambiarAnterior(anterior);
    			actual.cambiarAnterior(nuevo);
    			return;
    		}
    		
    		
    		actual = actual.darAnterior();
    	}
    	
    	
    	
    	
    }

    /**
     * Agrega un nuevo vagón con las características dadas al tren con el id dado.<br>
     * <b>post:</b> Se agregó el vagón a la lista de vagones del tren indicado.
     * @param pIdTren Id del tren al cual se quiere agregar el vagón.
     * @param pNumeroVagon Número del vagón a agregar.
     * @param pCantidadSillas Cantidad de sillas en el vagón. pCantidadSillas >= 0.
     * @param pClase Clase del compartimiento. pClase != null && pClase != "" && (pClase ==PRIMERA_CLASE || pClase == SEGUNDA_CLASE).
     * @param pPrecio Precio del tiquete en el vagón. pPrecio >= 0.
     * @throws ElementoExisteException Lanza la excepción si ya existe un vagón con ese número.
     * @throws ElementoNoExisteException Lanza la excepción si no existe un tren con ese id.
     */
    public void agregarVagon( int pIdTren, int pNumeroVagon, int pCantidadSillas, String pClase, double pPrecio ) throws ElementoExisteException, ElementoNoExisteException
    {
        Tren actual = buscarTrenPorId( pIdTren );
        if( actual != null )
        {
            actual.agregarVagon( pNumeroVagon, pCantidadSillas, pClase, pPrecio );
        }
        else
        {
            throw new ElementoNoExisteException( "No existe una ruta con ID " + pIdTren + "." );
        }
    }
    

    /**
     * Elimina el tren con el id dado por parámetro.<br>
     * <b>post:</b> Se eliminó el tren de la lista de trenes.
     * @param idTren Id del tren a eliminar.
     * @throws ElementoNoExisteException Lanza una excepción si no existe ninguna tren con el id dado.
     */
    public void eliminarTren( int idTren ) throws ElementoNoExisteException
    {
        // TODO Parte2 PuntoN: Completar el método eliminarTren de acuerdo a la documentación.
    	if(buscarTrenPorId(idTren)==null)
    		throw new ElementoNoExisteException("El tren a eliminar no existe");
    	if(primerTren.darId()==idTren)
    	{
    		primerTren=primerTren.darSiguiente();
    		primerTren.cambiarAnterior(null);
    	}
    	Tren actual = primerTren;
    	while(actual!=null)
    	{
    		if(actual.darSiguiente()==null&&actual.darId()==idTren)
    		{
    			actual.darAnterior().cambiarSiguiente(null);
    		}
    		if(actual.darSiguiente()!=null&&actual.darId()==idTren)
    		{
    			Tren siguiente =actual.darSiguiente();
    			siguiente.cambiarAnterior(actual.darAnterior());
    			actual.darAnterior().cambiarSiguiente(siguiente);
    			
    		}
    		actual=actual.darSiguiente();
    	}
    	
    }

    /**
     * Elimina el vagón con el número dado que se encuentra en el tren con la id dada. <br>
     * <b>post:</b> Se eliminó el vagón de la lista de vagones del tren indicado.
     * @param pIdTren Id del tren al que pertenece el vagón a eliminar.
     * @param pNumVagon Número del vagón que se quiere eliminar.
     * @throws ElementoNoExisteException Lanza una excepción si el tren o el vagón no existe.
     */
    public void eliminarVagon( int pIdTren, int pNumVagon ) throws ElementoNoExisteException
    {
        try
        {
            buscarTrenPorId( pIdTren ).eliminarVagon( pNumVagon );
        }
        catch( NullPointerException e )
        {
            throw new ElementoNoExisteException( "No existe una ruta con id " + pIdTren + "." );
        }
    }

    /**
     * Vende un tiquete del tren con el id dado en el vagón con el número dado por parámetro. <br>
     * <b>post:</b> Se aumentó la cantidad recaudada con el precio del tiquete y se disminuyó en uno la cantidad de sillas disponibles en el vagón.<br>
     * @param pIdTren Id del tren en el que se va a vender el tiquete.
     * @param pNumVagon Número del vagón donde se quiere vender el tiquete.
     * @return True si el tiquete fue vendido, false de lo contrario.
     * @throws ElementoNoExisteException Lanza una excepción si no existe una ruta con el id dado o si no existe un vagón con el número dado
     */
    public boolean venderTiquete( int pIdTren, int pNumVagon ) throws ElementoNoExisteException
    {
        Tren ruta = buscarTrenPorId( pIdTren );
        if( ruta == null )
        {
            throw new ElementoNoExisteException( "No existe una ruta con id " + pIdTren + "." );
        }
        return ruta.venderTiquete( pNumVagon );

    }

    /**
     * Genera un reporte con la información de los trenes y el recaudo de cupiTrenes.<br>
     * <b>post:</b> El reporte fue guardado en un el archivo pNombreArchivo en la ubicación rutaArchivo.<br>
     * @param pRutaNombre Nombre de la ruta donde se va a guardar el archivo. pRutaNombre != "" && pRutaNombre != null.
     * @param pNombreArchivo Nombre del archivo a guardar. pNombreArchivo != "" && pNombreArchivo != null.
     * @throws FileNotFoundException Lanza una excepción si la ruta del archivo no existe.
     */
    public void generarReporte( String pRutaNombre, String pNombreArchivo ) throws FileNotFoundException
    {
        File directorioReporte = new File( pRutaNombre );
        if( !directorioReporte.exists( ) )
        {
            directorioReporte.mkdirs( );
        }

        File archivoReporte = new File( directorioReporte, pNombreArchivo );
        PrintWriter out = new PrintWriter( archivoReporte );

        out.println( "------- REPORTE CUPITRENES -------- " );
        out.println( );
        Date fechaActual = new Date( System.currentTimeMillis( ) );
        SimpleDateFormat sdf = new SimpleDateFormat( "dd MMM yyyy HH:mm:ss " );

        out.println( "Generado el: " + sdf.format( fechaActual ).toString( ) );
        out.println( "Total recaudado: " + darTotalRecaudo( ) );
        out.println( "Sillas disponibles: " + darTotalSillasDisponibles( ) );

        out.println( );
        out.println( "---- Reporte detallado ----" );
        out.println( );

        Tren actual = primerTren;

        while( actual != null )
        {
            actual.imprimirDetallesTren( out );
            actual = actual.darSiguiente( );
        }

        out.close( );
    }

    /**
     * Método que guarda el estado del mundo en un archivo serializado.<br>
     * <b>post:</b> El estado del mundo fue guardado en rutaArchivo.<br>
     * @param pRutaArchivo La ruta del archivo en donde se va a guardar el estado del mundo. pRutaArchivo != "" && pRutaArchivo != null.
     * @throws PersistenciaException Se lanza excepción si ocurre algún problema al guardar.
     */
    public void guardar( String pRutaArchivo ) throws PersistenciaException
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( pRutaArchivo ) );
            oos.writeObject( primerTren );
            oos.close( );
        }
        catch( IOException e )
        {
            throw new PersistenciaException( "Error al guardar el estado del mundo." );
        }
        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv:</b><br>
     * Existe una ruta de archivo. rutaArchivo != null. <br>
     * La ruta del archivo no es una cadena vacía. rutaArchivo != "". <br>
     * No hay dos trenes con el mismo id.<br>
     */
    private void verificarInvariante( )
    {
        assert rutaArchivo != null : "La ruta del archivo no puede ser null.";
        assert !rutaArchivo.equals( "" ) : "La ruta del archivo no puede ser vacía.";
        assert !hayIdsRepetidos( ) : "Hay más de un tren con el mismo id.";
    }

    /**
     * Verifica si hay dos trenes con el mismo id.
     * @return True si hay dos trenes con el mismo id, false de lo contrario.
     */
    private boolean hayIdsRepetidos( )
    {
        boolean respuesta = false;
        Tren ruta1 = primerTren;
        while( ruta1 != null && !respuesta )
        {
            Tren ruta2 = ruta1.darSiguiente( );
            while( ruta2 != null )
            {
                if( ruta2.darId( ) == ruta1.darId( ) )
                    respuesta = true;
                ruta2 = ruta2.darSiguiente( );
            }
            ruta1 = ruta1.darSiguiente( );
        }
        return respuesta;
    }

    // -------------------------------------------------------------
    // Métodos de extensión
    // -------------------------------------------------------------

    /**
     * Método para la extensión1.
     * @return repuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * Método para la extensión2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }

}