/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
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
 * Clase que representa a un pasajero del avi�n.
 */
public class Pasajero
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * C�dula del pasajero.
     */
    private int cedula;

    /**
     * Nombre del pasajero.
     */
    private String nombre;

    /**
     * Lista de equipajes del pasajero.
     */
    // TODO Parte2 PuntoA: Declare la asociaci�n equipajes como una contenedora de tama�o variable.
    private ArrayList equipajes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea a un pasajero con los valores pasados como par�metro. <br>
     * <b>post: </b>El pasajero tiene sus datos b�sicos c�dula y nombre asignados. El equipaje se crea como una lista vac�a.
     * @param pCedula C�dula del pasajero.
     * @param pNombre Nombre del pasajero. pNombre != "" && pNombre != null.
     */
    public Pasajero( int pCedula, String pNombre )
    {
        cedula = pCedula;
        nombre = pNombre;

        // TODO Parte2 PuntoB: Complete el m�todo constructor de la clase seg�n la documentaci�n del m�todo.
        equipajes= new ArrayList();
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna la c�dula del pasajero.
     * @return C�dula del pasajero.
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
    	// TODO Parte2 PuntoC: Complete el m�todo darEquipajes seg�n la documentaci�n del m�todo.
    	return equipajes;
    }

    /**
     * Devuelve el peso total de equipajes que tiene el pasajero.
     * @return Suma el peso de cada uno de los equipajes del pasajero.
     */
    public int darPesoTotalEquipajes( )
    {
    	// TODO Parte2 PuntoD: Complete el m�todo darPesoTotalEquipajes seg�n la documentaci�n del m�todo.
    	int peso = 0;
    	for(int i =0;i<equipajes.size();i++)
    	{
    		peso +=(int)((Equipaje)equipajes.get(i)).darPeso();
    	}
    	return peso;
    }

    /**
     * Retorna el equipaje m�s pesado que posee el pasajero.
     * @return Equipaje m�s pesado. En caso de que no posea equipajes, retorna null.
     */
    public Equipaje darEquipajeMasPesado( )
    {
    	// TODO Parte2 PuntoE: Complete el m�todo darEquipajeMasPesado seg�n la documentaci�n del m�todo.
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
     * Devuelve una lista de los equipajes que pertenecen a una categor�a determinado por par�metro.
     * @param pCategoria Categor�a al que pertenecen los equipajes. pCategoria != "" && pCategoria != null.
     * @return Lista de las equipajes que pertenecen a la categor�a.
     */
    public ArrayList darEquipajesCategoria( String pCategoria )
    {
    	// TODO Parte2 PuntoF: Complete el m�todo darEquipajesCategoria seg�n la documentaci�n del m�todo.
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
     * @param pCategoria Categor�a del equipaje del pasajero. pCategoria != null && pCategoria != "" && (pCategoria == EQUIPAJE_MUSICAL || pCategoria == EQUIPAJE_DE_MANO ||
     *        pCategoria == EQUIPAJE_DEPORTIVO || pCategoria == EQUIPAJE_ESPECIAL).
     * @param pPeso Peso del equipaje del pasajero. pPeso > 0.
     * @param pCiudadDestino Ciudad destino del equipaje del pasajero. pCiudadDestino != null && pCiudadDestino != "".
     * @param pAncho Ancho del equipaje del pasajero. pAncho > 0.
     * @param pLargo Largo del equipaje del pasajero. pAncho > 0.
     * @param pAlto Alto del equipaje del pasajero. pAncho > 0.
     */
    public void agregarEquipaje( String pCategoria, double pPeso, String pCiudadDestino, double pAncho, double pLargo, double pAlto )
    {
    	// TODO Parte2 PuntoG: Complete el m�todo agregarEquipaje seg�n la documentaci�n del m�todo.
    	equipajes.add(new Equipaje(pCategoria,pPeso,pCiudadDestino,pAncho,pLargo,pAlto));

    }

}