/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n3_avion
 * Autor: Equipo Cupi2.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.avion.mundo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Clase que representa un avión.
 */
public class Avion
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para el número de sillas ejecutivas.
     */
    public final static int SILLAS_EJECUTIVAS = 8;
    /**
     * Constante para el número de sillas económicas.
     */
    public final static int SILLAS_ECONOMICAS = 42;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Sillas de la clase ejecutiva del avión.
     */
    private Silla[] sillasEjecutivas;
    /**
     * Sillas de la clase económica del avión.
     */
    private Silla[] sillasEconomicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un avión con sus respectivas sillas.<br>
     * <b>post: </b> Los atributos: sillasEjecutivas y sillasEconomicas quedaron inicializados con las constantes.<br>
     * El arreglo de sillasEjecutivas y el arreglo sillasEconomicas están inicializados y todas las sillas están creadas.<br>
     * Las sillas ejecutivas se crean de la siguiente manera: <br>
     * Dos filas de <ventana> <pasillo><pasillo> <ventana>. <br> 
     * Las sillas económicas se crean de la siguiente manera: <br>
     * Siete filas de <ventana><pasillo><central> <central><pasillo><ventana>. <br>
     */
    public Avion( )
    {
        int ubicacion;

        // Crea las sillas ejecutivas
        sillasEjecutivas = new Silla[SILLAS_EJECUTIVAS];

        // crea las sillas económicas
        sillasEconomicas = new Silla[SILLAS_ECONOMICAS];

        sillasEjecutivas[ 0 ] = new Silla( 1, Silla.CLASE_EJECUTIVA, Silla.VENTANA );
        sillasEjecutivas[ 1 ] = new Silla( 2, Silla.CLASE_EJECUTIVA, Silla.PASILLO );
        sillasEjecutivas[ 2 ] = new Silla( 3, Silla.CLASE_EJECUTIVA, Silla.PASILLO );
        sillasEjecutivas[ 3 ] = new Silla( 4, Silla.CLASE_EJECUTIVA, Silla.VENTANA );
        sillasEjecutivas[ 4 ] = new Silla( 5, Silla.CLASE_EJECUTIVA, Silla.VENTANA );
        sillasEjecutivas[ 5 ] = new Silla( 6, Silla.CLASE_EJECUTIVA, Silla.PASILLO );
        sillasEjecutivas[ 6 ] = new Silla( 7, Silla.CLASE_EJECUTIVA, Silla.PASILLO );
        sillasEjecutivas[ 7 ] = new Silla( 8, Silla.CLASE_EJECUTIVA, Silla.VENTANA );

        for( int numSilla = 1 + SILLAS_EJECUTIVAS, j = 1; j <= SILLAS_ECONOMICAS; numSilla++, j++ )
        {
            // Sillas ventana
            if( j % 6 == 1 || j % 6 == 0 )
            {
                ubicacion = Silla.VENTANA;
            }
            // Sillas centrales
            else if( j % 6 == 2 || j % 6 == 5 )
            {
                ubicacion = Silla.CENTRAL;
            }
            // Sillas pasillo
            else
            {
                ubicacion = Silla.PASILLO;
            }

            sillasEconomicas[ j - 1 ] = new Silla( numSilla, Silla.CLASE_ECONOMICA, ubicacion );
        }
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna en número de sillas del avión.
     * @return Número de sillas del avión.
     */
    public int darNumeroDeSillas( )
    {
        int numeroSillas = 0;
        numeroSillas = SILLAS_EJECUTIVAS + SILLAS_ECONOMICAS;
        return numeroSillas;
    }

    /**
     * Retorna las sillas ejecutivas del avión.
     * @return Sillas ejecutivas del avión.
     */
    public Silla[] darSillasEjecutivas( )
    {
        return sillasEjecutivas;
    }

    /**
     * Retorna las sillas económicas del avión.
     * @return sillas económicas del avión.
     */
    public Silla[] darSillasEconomicas( )
    {
        return sillasEconomicas;
    }

    /**
     * Retorna el peso total del avión.
     * @return Peso total de los equipajes del avión.
     */
    public int darPesoTotalEquipajes( )
    {
    	  // TODO Parte2 PuntoA: Complete el método darPesoTotalEquipajes según la documentación del método.
    	int peso=0;
    	for(int i = 0; i<sillasEconomicas.length;i++)
    	{
    		if((sillasEconomicas[i]).darPasajero()!=null)
    		peso+=(sillasEconomicas[i]).darPasajero().darPesoTotalEquipajes();
    	}
    	for(int i = 0; i<sillasEjecutivas.length;i++)
    	{
    		if((sillasEjecutivas[i]).darPasajero()!=null)
    		peso+=(sillasEjecutivas[i]).darPasajero().darPesoTotalEquipajes();
    	}
    	return peso;
    }

    /**
     * Retorna el equipaje más pesado del avión.
     * @return Equipaje más pesado del avión.
     */
    public Equipaje darEquipajeMasPesado( )
    {

    	  // TODO Parte3 PuntoB: Complete el método darEquipajeMasPesado según la documentación del método.
    	Equipaje rta = null;
    	double peso = 0;
    	for(int i=0;i<sillasEconomicas.length;i++)
    	{
    		if((sillasEconomicas[i]).darPasajero()!=null)
    		{
    			Equipaje temp =sillasEconomicas[i].darPasajero().darEquipajeMasPesado();
    			double peso2=temp.darPeso();
    			if(peso2>peso)
    			{
    				peso=peso2;rta=temp;
    			}
    		}
    	}
    	for(int i=0;i<sillasEjecutivas.length;i++)
    	{
    		if((sillasEjecutivas[i]).darPasajero()!=null)
    		{
    			Equipaje temp =sillasEjecutivas[i].darPasajero().darEquipajeMasPesado();
    			double peso2=temp.darPeso();
    			if(peso2>peso)
    			{
    				peso=peso2;rta=temp;
    			}
    		}
    	}
    	return rta;

    }
    /**
     * Retorna los equipajes del pasajero.
     * @param pCedulaPasajero Cédula del pasajero a buscar.
     * @return Equipajes del pasajero. En caso de que el pasajero no tenga equipajes, se retorna null.
     */
    public ArrayList darEquipajesPasajero( int pCedulaPasajero )
    {
    	// TODO Parte3 PuntoC: Complete el método darEquipajesPasajero según la documentación del método.
    	ArrayList rta = new ArrayList();
    	for(int i=0;i<sillasEconomicas.length;i++)
    	{
    		Pasajero temp =sillasEconomicas[i].darPasajero();
    		if(temp!=null&&temp.darCedula()==pCedulaPasajero)
    			rta= temp.darEquipajes();
    	}
    	for(int i=0;i<sillasEjecutivas.length;i++)
    	{
    		Pasajero temp =sillasEjecutivas[i].darPasajero();
    		if(temp!=null&&temp.darCedula()==pCedulaPasajero)
    			rta= temp.darEquipajes();
    	}
    	
    	return rta!=null?rta:null;
    }

    /**
     * Retorna los equipajes del pasajero de una categoría específica.
     * @param pCedulaPasajero Cédula del pasajero a buscar.
     * @param pCategoria Categoría al cual pertenece el equipaje. pCategoria != null && pCategoria != "" && (pCategoria == EQUIPAJE_MUSICAL || pCategoria == EQUIPAJE_DE_MANO
     * @return Equipajes del pasajero de una categoría específica.. En caso de que el pasajero no tenga equipajes, se retorna null.
     */
    public ArrayList darEquipajesCategoriaPasajero( int pCedulaPasajero, String pCategoria )
    {
    	// TODO Parte3 PuntoD: Complete el método darEquipajesCategoriaPasajero según la documentación del método.
    	ArrayList rta = null;
    	Pasajero pasajero=buscarSillaPasajero(pCedulaPasajero).darPasajero();
    	if(pasajero!=null)
    	{
    		rta=pasajero.darEquipajesCategoria(pCategoria);
    	}
    	return rta;
    }

    /**
     * Busca la siguiente silla ejecutiva que este libre y tenga la ubicación indicada.
     * @param pUbicacion Ubicación en donde buscar la silla. (pUbicacion == VENTANA || pUbicacion == CENTRAL || pUbicacion == PASILLO).
     * @return Silla libre encontrada. Si no encuentra retorna null.
     */
    public Silla buscarSillaEjecutivaLibre( int pUbicacion )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_EJECUTIVAS && !encontrado; i++ )
        {
            silla = sillasEjecutivas[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.darUbicacion( ) == pUbicacion )
            {
                encontrado = true;
            }
        }
        if( encontrado == false )
        {
            silla = null;
        }

        return silla;

    }

    /**
     * Busca la siguiente silla económica que este libre y tenga la ubicación indicada.
     * @param pUbicacion Ubicación en donde buscar la silla. (pUbicacion == VENTANA || pUbicacion == CENTRAL || pUbicacion == PASILLO).
     * @return Silla encontrada libre. Si no encuentra retorna null.
     */
    public Silla buscarSillaEconomicaLibre( int pUbicacion )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.darUbicacion( ) == pUbicacion )
            {
                encontrado = true;
            }
        }
        if( encontrado == false )
        {
            silla = null;
        }

        return silla;

    }

    /**
     * Busca un pasajero en el avión.
     * @param pCedulaPasajero Cédula del pasajero a buscar.
     * @return Silla en la que se encontró el pasajero. Si no lo encuentra retorna null.
     */
    public Silla buscarSillaPasajero( int pCedulaPasajero )
    {

        Silla silla = buscarSillaDePasajeroEjecutivo( pCedulaPasajero );

        if( null == silla )
        {
            silla = buscarSillaDePasajeroEconomico( pCedulaPasajero );
        }
        return silla;

    }

    /**
     * Busca un pasajero en las sillas ejecutivas.
     * @param pCedulaPasajero Cédula del pasajero a buscar.
     * @return Silla en la que se encontró el pasajero. Si no lo encuentra retorna null.
     */
    public Silla buscarSillaDePasajeroEjecutivo( int pCedulaPasajero )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_EJECUTIVAS && !encontrado; i++ )
        {
            silla = sillasEjecutivas[ i ];
            if( silla.sillaAsignada( ) && silla.darPasajero( ).darCedula( ) == ( pCedulaPasajero ) )
            {
                encontrado = true;
            }
        }
        if( encontrado == false )
        {
            silla = null;
        }
        return silla;
    }

    /**
     * Busca un pasajero en las sillas económicas.
     * @param pCedulaPasajero Cédula del pasajero a buscar.
     * @return Silla en la que se encontró el pasajero. Si no lo encuentra retorna null.
     */
    public Silla buscarSillaDePasajeroEconomico( int pCedulaPasajero )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( silla.sillaAsignada( ) && silla.darPasajero( ).darCedula( ) == ( pCedulaPasajero ) )
            {
                encontrado = true;
            }
        }
        if( encontrado == false )
        {
            silla = null;
        }
        return silla;

    }

    /**
     * Asigna la silla a un pasajero, según sus preferencias de clase y ubicación <br>
     * <b>post: </b> Si existe una silla con la clase y la ubicación dada, el pasajero queda asignado en la primera de ellas según el orden numérico.
     * @param pClase Clase elegida por el pasajero. (pClase == CLASE_EJECUTIVA || pClase == CLASE_ECONOMICA).
     * @param pUbicacion Ubicación elegida por el pasajero. (pUbicacion == VENTANA || pUbicacion == CENTRAL || pUbicacion == PASILLO).
     * @param pCedulaPasajero Cédula del pasajero.
     * @param pNombrePasajero Nombre del pasajero. pNombre != null && pNombre != "" .
     * @return Silla asignada. Si no se asigna una silla retorna null.
     */
    public Silla asignarSilla( int pClase, int pUbicacion, int pCedulaPasajero, String pNombrePasajero )
    {
        // busca una silla libre
        Silla silla = null;
        if( pClase == Silla.CLASE_EJECUTIVA )
        {
            silla = buscarSillaEjecutivaLibre( pUbicacion );
        }
        else if( pClase == Silla.CLASE_ECONOMICA )
        {
            silla = buscarSillaEconomicaLibre( pUbicacion );
        }
        if( silla != null )
        {
            silla.asignarAPasajero( pCedulaPasajero, pNombrePasajero );
        }
        return silla;
    }

    /**
     * Desasigna la silla de un pasajero. <br>
     * <b>post: </b> Si se encuentra una silla con el pasajero, se retorna falseN
     * @param pCedulaPasajero Cédula del pasajero.
     * @return True si encontró el pasajero y desasignó la silla, false en caso contrario.
     */
    public boolean desasignarSilla( int pCedulaPasajero )
    {
        Silla silla = buscarSillaPasajero( pCedulaPasajero );
        boolean sillaDesasignada = false;

        if( silla != null )
        {
            silla.desasignarSilla( );
            sillaDesasignada = true;
        }
        return sillaDesasignada;
    }

    /**
     * Retorna el número de sillas ejecutivas ocupadas.
     * @return Número de sillas ejecutivas ocupadas.
     */
    public int contarSillasEjecutivasOcupadas( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_EJECUTIVAS; i++ )
        {
            if( sillasEjecutivas[ i ].sillaAsignada( ) )
            {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Retorna el número de sillas económicas ocupadas.
     * @return Número de sillas económicas ocupadas.
     */
    public int contarSillasEconomicasOcupadas( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_ECONOMICAS; i++ )
        {
            if( sillasEconomicas[ i ].sillaAsignada( ) )
            {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Calcula el porcentaje de ocupación del avión.
     * @return Porcentaje total de ocupación.
     */
    public double calcularPorcentajeOcupacion( )
    {
        double porcentaje;
        int totalSillas = SILLAS_ECONOMICAS + SILLAS_EJECUTIVAS;
        int sillasOcupadas = contarSillasEconomicasOcupadas( ) + contarSillasEjecutivasOcupadas( );
        porcentaje = ( double )sillasOcupadas / totalSillas * 100;
        return porcentaje;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método de extensión 1.
     * @return Resultado de la operación.
     */
    public String metodo1( )
    {
        return "respuesta 1";
    }

    /**
     * Método de extensión 2.
     * @return Resultado de la operación.
     */
    public String metodo2( )
    {
        return "respuesta 2";
    }
}