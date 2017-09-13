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
 * Clase que representa un pasaporte de un cliente del parque de diversiones.
 */
public class Pasaporte
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Categor�a oro para el pasaporte.
     */
    public final static String ORO = "Oro";

    /**
     * Categor�a plata para el pasaporte.
     */
    public final static String PLATA = "Plata";

    /**
     * Categor�a bronce para el pasaporte.
     */
    public final static String BRONCE = "Bronce";

    /**
     * Valor del porcentaje de descuento para la categor�a oro.
     */
    // TODO Parte2 PuntoA: Declare la constante VALOR_ORO con valor 0.15
    public static final double VALOR_ORO=0.15;

    /**
     * Valor del porcentaje de descuento para la categor�a plata.
     */
    // TODO Parte2 PuntoB: Declare la constante VALOR_PLATA con valor 0.10
    public static final double VALOR_PLATA=0.10;

    /**
     * Valor del porcentaje de descuento para la categor�a bronce.
     */
    // TODO Parte2 PuntoC: Declare la constante VALOR_BRONCE con valor 0.05
    public static final double VALOR_BRONCE=0.05;

    /**
     * Estado del pasaporte en elaboraci�n.
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
     * Nombre del due�o del pasaporte.
     */
    private String nombreDuenio;

    /**
     * C�dula del due�o del pasaporte.
     */
    private int cedulaDuenio;

    /**
     * Estado del pasaporte.
     */
    private int estado;

    /**
     * Categor�a del pasaporte.
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
     * <b>post: </b> Se inicializaron los atributos nombre, c�dula y categor�a con los valores dados por par�metro.<br>
     * Se inicializ� estado con valor ELABORACION. Se inicializ� atracciones incluidas como una lista vac�a.<br>
     * @param pNombreDuenio Nombre del due�o del pasaporte. pNombreDuenio != null && pNombreDuenio != "".
     * @param pCedulaDuenio C�dula del due�o del pasaporte. pCedulaDuenio > 0.
     * @param pCategoria Categor�a del pasaporte. pCategoria != null && pCategoria != "" && (pCategoria == ORO || pCategoria == PLATA || pCategoria == BRONCE).
     */
    public Pasaporte( String pNombreDuenio, int pCedulaDuenio, String pCategoria )
    {
        // TODO Parte2 PuntoF: Complete el m�todo constructor de la clase.
    	estado=ELABORACION;
    	atraccionesIncluidas=new ArrayList();
    	nombreDuenio=pNombreDuenio;
    	cedulaDuenio=pCedulaDuenio;
    	categoria=pCategoria;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del due�o del pasaporte.
     * @return Nombre del due�o del pasaporte.
     */
    public String darNombreDuenio( )
    {
        return nombreDuenio;
    }

    /**
     * Retorna la c�dula del due�o del pasaporte.
     * @return La c�dula del due�o del pasaporte.
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
     * Retorna la categor�a del pasaporte.
     * @return Categor�a del pasaporte.
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

    // TODO Parte2 PuntoJ: Escriba el contrato del m�todo de acuerdo a la funcionalidad implementada.
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
     * Retorna la cantidad de atracciones incluidas en el pasaporte, que tienen el tipo dado por par�metro. <br>
     * <b>pre: </b> La lista de atracciones incluidas est� inicializada.
     * @param pTipo Tipo de atracci�n que se desea contar. pTipo != null && pTipo != "".
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
     * Calcula el precio total del pasaporte teniendo en cuenta el descuento seg�n la categor�a del pasaporte. <br>
     * <b>pre: </b> La lista de atracciones incluidas est� inicializada.<br>
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
     * Agrega una atracci�n a la lista de atracciones incluidas en el pasaporte.<br>
     * <b>pre: </b> La lista de atracciones incluidas est� inicializada.<br>
     * <b> post: </b> Se agreg� la atracci�n al pasaporte.
     * @param pAtraccion Atracci�n que se va a agregar. pAtraccion != null.
     * @throws Exception Si se intenta agregar una atracci�n tipo VELOCIDAD y ya hay otras 2 atracciones tipo VELOCIDAD en la lista de atracciones incluidas.
     * @throws Exception Si se intenta agregar una atracci�n tipo TERROR y ya hay una atracci�n tipo INFANTIL en la lista de atracciones incluidas.
     * @throws Exception Si se intenta agregar una atracci�n tipo INFANTIL y ya hay una atracci�n tipo TERROR en la lista de atracciones incluidas.
     * @throws Exception Si el pasaporte tiene estado VENDIDO.
     */
    public void agregarAtraccion( Atraccion pAtraccion ) throws Exception
    {

        // TODO Parte2 PuntoG: Complete el m�todo seg�n la documentaci�n.

        // AYUDA: Estrategia de soluci�n sugerida.
        // 1) Verifique si el estado del pasaporte es vendido.
        // 2) Utilice el m�todo cuantasAtraccionesTipo para contar las atracciones de tipo VELOCIDAD.
        // 3) Utilice el m�todo cuantasAtraccionesTipo para saber si hay alguna atracci�n de tipo INFANTIL.
        // 4) Utilice el m�todo cuantasAtraccionesTipo para saber si hay alguna atracci�n de tipo TERROR.
        // 5) Si no se gener� ning�n error, agregue la atracci�n.

        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:

        // Error si el estado del pasaporte es vendido.
        // Mensaje de error: No se puede agregar la atracci�n porque el pasaporte ya fue vendido.

        // Error si intenta agregar atracci�n tipo velocidad y ya hay 2 atracciones de velocidad.
        // Mensaje de error: No se puede agregar la atracci�n porque ya hay 2 atracciones de tipo velocidad.

        // Error si intenta agregar atracci�n tipo terror y ya hay atracci�n tipo infantil.
        // Mensaje de error: No se puede agregar la atracci�n porque ya hay una atracci�n de tipo infantil.

        // Error si intenta agregar atracci�n tipo infantil y ya hay atracci�n tipo terror.
        // Mensaje de error: No se puede agregar la atracci�n porque ya hay una atracci�n de tipo terror.
    	Atraccion a=pAtraccion;
    	if(estado==VENDIDO)
    		throw new Exception("No se puede agregar la atracci�n porque el pasaporte ya fue vendido.");
    	else if(cuantasAtraccionesTipo(pAtraccion.darTipo())>=2&&pAtraccion.darTipo().equals(pAtraccion.VELOCIDAD))
    		throw new Exception("No se puede agregar la atracci�n porque ya hay 2 atracciones de tipo velocidad.");
    	else if(pAtraccion.darTipo().equals(a.TERROR)&&cuantasAtraccionesTipo(a.INFANTIL)>0)
    		throw new Exception("No se puede agregar la atracci�n porque ya hay una atracci�n de tipo infantil.");
    	else if(a.darTipo().equals(a.INFANTIL)&&cuantasAtraccionesTipo(a.TERROR)>0)
    		throw new Exception("No se puede agregar la atracci�n porque ya hay una atracci�n de tipo terror.");
    	
    	atraccionesIncluidas.add(a);
    }

    /**
     * Elimina la atracci�n que tiene el nombre dado por par�metro.<br>
     * <b>pre: </b> La lista de atracciones incluidas est� inicializada.<br>
     * <b> post: </b> Se elimin� la atracci�n con el nombre dado de la lista de atracciones incluidas.
     * @param pNombreAtraccion Nombre de la atracci�n a eliminar. pNombreAtraccion != null && pNombreAtraccion != "".
     * @throws Exception Si no encuentra una atracci�n con el nombre dado.
     * @throws Exception Si el pasaporte tiene estado VENDIDO.
     */
    public void eliminarAtraccion( String pNombreAtraccion ) throws Exception
    {
        // TODO Parte2 PuntoH: Complete el m�todo seg�n la documentaci�n.

        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:

        // Error si intenta eliminar la atracci�n de un pasaporte vendido.
        // Mensaje de error: No se puede eliminar la atracci�n porque el pasaporte ya fue vendido.

        // Error si no existe una atracci�n con el nombre dado.
        // Mensaje de error: No se puede eliminar la atracci�n porque no existe.
    	if(estado==VENDIDO)
    		throw new Exception("No se puede eliminar la atracci�n porque el pasaporte ya fue vendido.");
    	else if(!existeAtraccion(pNombreAtraccion))
    		throw new Exception ("No se puede elminar la atracci�n porque no existe");
    	for(int i =0;i<atraccionesIncluidas.size();i++)
    	{
    		Atraccion a =(Atraccion)atraccionesIncluidas.get(i);
    		if(a.darNombre().equals(pNombreAtraccion))
    			atraccionesIncluidas.remove(a);
    	}
    	
   }

    /**
     * Cambia el estado del pasaporte a vendido si tiene por lo menos 5 atracciones incluidas.<br>
     * <b>pre: </b> La lista de atracciones incluidas est� inicializada.<br>
     * <b>post: </b> El estado del pasaporte cambi� a VENDIDO.
     * @throws Exception Si el pasaporte no tiene por lo menos 5 atracciones.
     * @throws Exception Si el estado del pasaporte ya es vendido.
     */
    public void vender( ) throws Exception
    {
        // TODO Parte2 PuntoI: Complete el m�todo seg�n la documentaci�n.
        
        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:
        
        // Error si intenta vender el pasaporte con menos de 5 atracciones.
        // Mensaje de error: El pasaporte deber�a tener por lo menos 5 atracciones para ser vendido.
        
        // Error si el estado del pasaporte ya es vendido.
        // Mensaje de error: El pasaporte ya ha sido vendido.
    	if(atraccionesIncluidas.size()<5)
    		throw new Exception("El pasaporte deber�a tener por lo menos 5 atracciones para ser vendido.");
    	else if(estado==VENDIDO)
    		throw new Exception("El pasaporte ya ha sido vendido.");
    	estado=VENDIDO;
    }

}