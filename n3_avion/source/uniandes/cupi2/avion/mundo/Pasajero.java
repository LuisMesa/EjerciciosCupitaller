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

/**
 * Clase que representa a un pasajero del avión.
 */
public class Pasajero
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Cédula del pasajero.
     */
    private int cedula;

    /**
     * Nombre del pasajero.
     */
    private String nombre;

    /**
     * Lista de equipajes del pasajero.
     */
    // TODO Parte2 PuntoA: Declare la asociación equipajes como una contenedora de tamaño variable.
    private ArrayList equipajes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea a un pasajero con los valores pasados como parámetro. <br>
     * <b>post: </b>El pasajero tiene sus datos básicos cédula y nombre asignados. El equipaje se crea como una lista vacía.
     * @param pCedula Cédula del pasajero.
     * @param pNombre Nombre del pasajero. pNombre != "" && pNombre != null.
     */
    public Pasajero( int pCedula, String pNombre )
    {
        cedula = pCedula;
        nombre = pNombre;

        // TODO Parte2 PuntoB: Complete el método constructor de la clase según la documentación del método.
        equipajes= new ArrayList();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la cédula del pasajero.
     * @return Cédula del pasajero.
     */
    public int darCedula( )
    {
        return cedula;
    }

    /**
     * Retorna el nombre del pasajero.
     * @return Nombre del pasajero.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Devuelve la lista de equipajes del pasajero.
     * @return Lista de equipajes del pasajero.
     */
    public ArrayList darEquipajes( )
    {
    	// TODO Parte2 PuntoC: Complete el método darEquipajes según la documentación del método.
    	return equipajes;
    }

    /**
     * Devuelve el peso total de equipajes que tiene el pasajero.
     * @return Suma el peso de cada uno de los equipajes del pasajero.
     */
    public int darPesoTotalEquipajes( )
    {
    	// TODO Parte2 PuntoD: Complete el método darPesoTotalEquipajes según la documentación del método.
    	int peso = 0;
    	for(int i =0;i<equipajes.size();i++)
    	{
    		peso +=(int)((Equipaje)equipajes.get(i)).darPeso();
    	}
    	return peso;
    }

    /**
     * Retorna el equipaje más pesado que posee el pasajero.
     * @return Equipaje más pesado. En caso de que no posea equipajes, retorna null.
     */
    public Equipaje darEquipajeMasPesado( )
    {
    	// TODO Parte2 PuntoE: Complete el método darEquipajeMasPesado según la documentación del método.
    	double peso = 0;
    	Equipaje equipaje = null;
    	for(int i =0;i<equipajes.size();i++)
    	{
    		Equipaje temp =(Equipaje)equipajes.get(i);
    		double peso2 = temp.darPeso();
    		if(peso<peso2)
    		{
    			peso=peso2;
    			equipaje =temp;
    		}
    	}
    	return equipaje;
    }

    /**
     * Devuelve una lista de los equipajes que pertenecen a una categoría determinado por parámetro.
     * @param pCategoria Categoría al que pertenecen los equipajes. pCategoria != "" && pCategoria != null.
     * @return Lista de las equipajes que pertenecen a la categoría.
     */
    public ArrayList darEquipajesCategoria( String pCategoria )
    {
    	// TODO Parte2 PuntoF: Complete el método darEquipajesCategoria según la documentación del método.
    	ArrayList rta=new ArrayList();
    	for(int i=0;i<equipajes.size();i++)
    	{
    		Equipaje temp =(Equipaje)equipajes.get(i);
    		if(temp.darCategoria().equals(pCategoria))
    			rta.add(temp);
    	}
    	return rta;
    }

    /**
     * Indica si el pasajero es igual a otro.
     * @param pPasajero Pasajero a comparar. pPasajero != null.
     * @return True si es el mismo pasajero, false en caso contrario.
     */
    public boolean igualA( Pasajero pPasajero )
    {
    	 boolean esIgual = false;
         if( cedula == pPasajero.darCedula( ) )
         {
             esIgual = true;
         }
         else
         {
             esIgual = false;
         }

         return esIgual;
    }

    /**
     * Agrega un equipaje a un pasajero.
     * @param pCategoria Categoría del equipaje del pasajero. pCategoria != null && pCategoria != "" && (pCategoria == EQUIPAJE_MUSICAL || pCategoria == EQUIPAJE_DE_MANO ||
     *        pCategoria == EQUIPAJE_DEPORTIVO || pCategoria == EQUIPAJE_ESPECIAL).
     * @param pPeso Peso del equipaje del pasajero. pPeso > 0.
     * @param pCiudadDestino Ciudad destino del equipaje del pasajero. pCiudadDestino != null && pCiudadDestino != "".
     * @param pAncho Ancho del equipaje del pasajero. pAncho > 0.
     * @param pLargo Largo del equipaje del pasajero. pAncho > 0.
     * @param pAlto Alto del equipaje del pasajero. pAncho > 0.
     */
    public void agregarEquipaje( String pCategoria, double pPeso, String pCiudadDestino, double pAncho, double pLargo, double pAlto )
    {
    	// TODO Parte2 PuntoG: Complete el método agregarEquipaje según la documentación del método.
    	equipajes.add(new Equipaje(pCategoria,pPeso,pCiudadDestino,pAncho,pLargo,pAlto));

    }

}