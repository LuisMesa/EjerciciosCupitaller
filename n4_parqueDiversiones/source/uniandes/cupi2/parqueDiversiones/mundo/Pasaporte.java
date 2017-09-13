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
 * Clase que representa un pasaporte de un cliente del parque de diversiones.
 */
public class Pasaporte
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Categoría oro para el pasaporte.
     */
    public final static String ORO = "Oro";

    /**
     * Categoría plata para el pasaporte.
     */
    public final static String PLATA = "Plata";

    /**
     * Categoría bronce para el pasaporte.
     */
    public final static String BRONCE = "Bronce";

    /**
     * Valor del porcentaje de descuento para la categoría oro.
     */
    // TODO Parte2 PuntoA: Declare la constante VALOR_ORO con valor 0.15
    public static final double VALOR_ORO=0.15;

    /**
     * Valor del porcentaje de descuento para la categoría plata.
     */
    // TODO Parte2 PuntoB: Declare la constante VALOR_PLATA con valor 0.10
    public static final double VALOR_PLATA=0.10;

    /**
     * Valor del porcentaje de descuento para la categoría bronce.
     */
    // TODO Parte2 PuntoC: Declare la constante VALOR_BRONCE con valor 0.05
    public static final double VALOR_BRONCE=0.05;

    /**
     * Estado del pasaporte en elaboración.
     */
    // TODO Parte2 PuntoD: Declare la constante ELABORACION con valor 0
    public static final int ELABORACION=0;

    /**
     * Estado del pasaporte vendido.
     */
    // TODO Parte2 PuntoE: Declare la constante VENDIDO con valor 1
    public static final int VENDIDO=1;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del dueño del pasaporte.
     */
    private String nombreDuenio;

    /**
     * Cédula del dueño del pasaporte.
     */
    private int cedulaDuenio;

    /**
     * Estado del pasaporte.
     */
    private int estado;

    /**
     * Categoría del pasaporte.
     */
    private String categoria;

    /**
     * Lista de atracciones incluidas en el pasaporte.
     */
    private ArrayList atraccionesIncluidas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo pasaporte.<br>
     * <b>post: </b> Se inicializaron los atributos nombre, cédula y categoría con los valores dados por parámetro.<br>
     * Se inicializó estado con valor ELABORACION. Se inicializó atracciones incluidas como una lista vacía.<br>
     * @param pNombreDuenio Nombre del dueño del pasaporte. pNombreDuenio != null && pNombreDuenio != "".
     * @param pCedulaDuenio Cédula del dueño del pasaporte. pCedulaDuenio > 0.
     * @param pCategoria Categoría del pasaporte. pCategoria != null && pCategoria != "" && (pCategoria == ORO || pCategoria == PLATA || pCategoria == BRONCE).
     */
    public Pasaporte( String pNombreDuenio, int pCedulaDuenio, String pCategoria )
    {
        // TODO Parte2 PuntoF: Complete el método constructor de la clase.
    	estado=ELABORACION;
    	atraccionesIncluidas=new ArrayList();
    	nombreDuenio=pNombreDuenio;
    	cedulaDuenio=pCedulaDuenio;
    	categoria=pCategoria;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del dueño del pasaporte.
     * @return Nombre del dueño del pasaporte.
     */
    public String darNombreDuenio( )
    {
        return nombreDuenio;
    }

    /**
     * Retorna la cédula del dueño del pasaporte.
     * @return La cédula del dueño del pasaporte.
     */
    public int darCedulaDuenio( )
    {
        return cedulaDuenio;
    }

    /**
     * Retorna el estado del pasaporte.
     * @return Estado del pasaporte.
     */
    public int darEstado( )
    {
        return estado;
    }

    /**
     * Retorna la categoría del pasaporte.
     * @return Categoría del pasaporte.
     */
    public String darCategoria( )
    {
        return categoria;
    }

    /**
     * Retorna la lista de atracciones incluidas en el pasaporte. <br>
     * @return Lista de atracciones incluidas en el pasaporte.
     */
    public ArrayList darAtraccionesIncluidas( )
    {
        return atraccionesIncluidas;
    }

    // TODO Parte2 PuntoJ: Escriba el contrato del método de acuerdo a la funcionalidad implementada.
    public boolean existeAtraccion( String pNombreAtraccion )
    {
        boolean hay = false;
        for( int i = 0; i < atraccionesIncluidas.size( ) && !hay; i++ )
        {
            Atraccion atraccionActual = ( Atraccion )atraccionesIncluidas.get( i );
            if( atraccionActual.darNombre( ).equals( pNombreAtraccion ) )
            {
                hay = true;
            }
        }
        return hay;
    }

    /**
     * Retorna la cantidad de atracciones incluidas en el pasaporte, que tienen el tipo dado por parámetro. <br>
     * <b>pre: </b> La lista de atracciones incluidas está inicializada.
     * @param pTipo Tipo de atracción que se desea contar. pTipo != null && pTipo != "".
     * @return Cantidad de atracciones incluidas del tipo pTipo.
     */
    public int cuantasAtraccionesTipo( String pTipo )
    {
        int cuantasAtracciones = 0;
        for( int i = 0; i < atraccionesIncluidas.size( ); i++ )
        {
            Atraccion atraccionActual = ( Atraccion )atraccionesIncluidas.get( i );
            if( atraccionActual.darTipo( ).equals( pTipo ) )
            {
                cuantasAtracciones++;
            }
        }
        return cuantasAtracciones;
    }

    /**
     * Calcula el precio total del pasaporte teniendo en cuenta el descuento según la categoría del pasaporte. <br>
     * <b>pre: </b> La lista de atracciones incluidas está inicializada.<br>
     * @return Precio del pasaporte con descuento. Retorna 0 en caso que no haya atracciones.
     */
    public double calcularPrecio( )
    {
        double precio = 0;

        for( int i = 0; i < atraccionesIncluidas.size( ); i++ )
        {
            Atraccion atraccionActual = ( Atraccion )atraccionesIncluidas.get( i );
            precio += atraccionActual.darPrecio( );
        }

        if( categoria.equals( ORO ) )
        {
            precio = precio * ( 1 - VALOR_ORO );
        }
        else if( categoria.equals( PLATA ) )
        {
            precio = precio * ( 1 - VALOR_PLATA );
        }
        else if( categoria.equals( BRONCE ) )
        {
            precio = precio * ( 1 - VALOR_BRONCE );
        }
        return precio;
    }

    /**
     * Agrega una atracción a la lista de atracciones incluidas en el pasaporte.<br>
     * <b>pre: </b> La lista de atracciones incluidas está inicializada.<br>
     * <b> post: </b> Se agregó la atracción al pasaporte.
     * @param pAtraccion Atracción que se va a agregar. pAtraccion != null.
     * @throws Exception Si se intenta agregar una atracción tipo VELOCIDAD y ya hay otras 2 atracciones tipo VELOCIDAD en la lista de atracciones incluidas.
     * @throws Exception Si se intenta agregar una atracción tipo TERROR y ya hay una atracción tipo INFANTIL en la lista de atracciones incluidas.
     * @throws Exception Si se intenta agregar una atracción tipo INFANTIL y ya hay una atracción tipo TERROR en la lista de atracciones incluidas.
     * @throws Exception Si el pasaporte tiene estado VENDIDO.
     */
    public void agregarAtraccion( Atraccion pAtraccion ) throws Exception
    {

        // TODO Parte2 PuntoG: Complete el método según la documentación.

        // AYUDA: Estrategia de solución sugerida.
        // 1) Verifique si el estado del pasaporte es vendido.
        // 2) Utilice el método cuantasAtraccionesTipo para contar las atracciones de tipo VELOCIDAD.
        // 3) Utilice el método cuantasAtraccionesTipo para saber si hay alguna atracción de tipo INFANTIL.
        // 4) Utilice el método cuantasAtraccionesTipo para saber si hay alguna atracción de tipo TERROR.
        // 5) Si no se generó ningún error, agregue la atracción.

        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:

        // Error si el estado del pasaporte es vendido.
        // Mensaje de error: No se puede agregar la atracción porque el pasaporte ya fue vendido.

        // Error si intenta agregar atracción tipo velocidad y ya hay 2 atracciones de velocidad.
        // Mensaje de error: No se puede agregar la atracción porque ya hay 2 atracciones de tipo velocidad.

        // Error si intenta agregar atracción tipo terror y ya hay atracción tipo infantil.
        // Mensaje de error: No se puede agregar la atracción porque ya hay una atracción de tipo infantil.

        // Error si intenta agregar atracción tipo infantil y ya hay atracción tipo terror.
        // Mensaje de error: No se puede agregar la atracción porque ya hay una atracción de tipo terror.
    	Atraccion a=pAtraccion;
    	if(estado==VENDIDO)
    		throw new Exception("No se puede agregar la atracción porque el pasaporte ya fue vendido.");
    	else if(cuantasAtraccionesTipo(pAtraccion.darTipo())>=2&&pAtraccion.darTipo().equals(pAtraccion.VELOCIDAD))
    		throw new Exception("No se puede agregar la atracción porque ya hay 2 atracciones de tipo velocidad.");
    	else if(pAtraccion.darTipo().equals(a.TERROR)&&cuantasAtraccionesTipo(a.INFANTIL)>0)
    		throw new Exception("No se puede agregar la atracción porque ya hay una atracción de tipo infantil.");
    	else if(a.darTipo().equals(a.INFANTIL)&&cuantasAtraccionesTipo(a.TERROR)>0)
    		throw new Exception("No se puede agregar la atracción porque ya hay una atracción de tipo terror.");
    	
    	atraccionesIncluidas.add(a);
    }

    /**
     * Elimina la atracción que tiene el nombre dado por parámetro.<br>
     * <b>pre: </b> La lista de atracciones incluidas está inicializada.<br>
     * <b> post: </b> Se eliminó la atracción con el nombre dado de la lista de atracciones incluidas.
     * @param pNombreAtraccion Nombre de la atracción a eliminar. pNombreAtraccion != null && pNombreAtraccion != "".
     * @throws Exception Si no encuentra una atracción con el nombre dado.
     * @throws Exception Si el pasaporte tiene estado VENDIDO.
     */
    public void eliminarAtraccion( String pNombreAtraccion ) throws Exception
    {
        // TODO Parte2 PuntoH: Complete el método según la documentación.

        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:

        // Error si intenta eliminar la atracción de un pasaporte vendido.
        // Mensaje de error: No se puede eliminar la atracción porque el pasaporte ya fue vendido.

        // Error si no existe una atracción con el nombre dado.
        // Mensaje de error: No se puede eliminar la atracción porque no existe.
    	if(estado==VENDIDO)
    		throw new Exception("No se puede eliminar la atracción porque el pasaporte ya fue vendido.");
    	else if(!existeAtraccion(pNombreAtraccion))
    		throw new Exception ("No se puede elminar la atracción porque no existe");
    	for(int i =0;i<atraccionesIncluidas.size();i++)
    	{
    		Atraccion a =(Atraccion)atraccionesIncluidas.get(i);
    		if(a.darNombre().equals(pNombreAtraccion))
    			atraccionesIncluidas.remove(a);
    	}
    	
   }

    /**
     * Cambia el estado del pasaporte a vendido si tiene por lo menos 5 atracciones incluidas.<br>
     * <b>pre: </b> La lista de atracciones incluidas está inicializada.<br>
     * <b>post: </b> El estado del pasaporte cambió a VENDIDO.
     * @throws Exception Si el pasaporte no tiene por lo menos 5 atracciones.
     * @throws Exception Si el estado del pasaporte ya es vendido.
     */
    public void vender( ) throws Exception
    {
        // TODO Parte2 PuntoI: Complete el método según la documentación.
        
        // Tenga en cuenta los posibles errores que se pueden generar en este método y que se describen a continuación:
        
        // Error si intenta vender el pasaporte con menos de 5 atracciones.
        // Mensaje de error: El pasaporte debería tener por lo menos 5 atracciones para ser vendido.
        
        // Error si el estado del pasaporte ya es vendido.
        // Mensaje de error: El pasaporte ya ha sido vendido.
    	if(atraccionesIncluidas.size()<5)
    		throw new Exception("El pasaporte debería tener por lo menos 5 atracciones para ser vendido.");
    	else if(estado==VENDIDO)
    		throw new Exception("El pasaporte ya ha sido vendido.");
    	estado=VENDIDO;
    }

}