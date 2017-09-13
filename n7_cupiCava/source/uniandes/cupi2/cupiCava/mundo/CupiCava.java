/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.mundo;

import java.util.ArrayList;





/**
 * Clase que representa la Cupi-Cava. <br>
 * <b>inv: </b> <br>
 * //TODO Parte1 PuntoC Defina el invariante de la clase y docum�ntelo.
 */
public class CupiCava
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Lista de vinos en la cava.
     */
    private ArrayList vinos;

    // -------------------------------------------------------------
    // M�todo Constructor
    // -------------------------------------------------------------

    /**
     * Construye una nueva cava sin vinos. <br>
     * <b>post:</b> La lista de vinos ha sido inicializada.
     */
    public CupiCava( )
    {
        vinos = new ArrayList( );
    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna la lista de vinos.
     * @return Lista de vinos.
     */
    public ArrayList darVinos( )
    {
        return vinos;
    }

    /**
     * Busca un vino con el nombre dado por par�metro. <br>
     * <b>pre:</b> La lista de vinos est� inicializada.
     * @param pNombre Nombre del vino. pNombre != null && pNombre != ""
     * @return Vino con el nombre dado, null en caso de no encontrarlo.
     */
    public Vino buscarVino( String pNombre )
    {
        Vino buscado = null;
        boolean encontre = false;

        for( int i = 0; i < vinos.size( ) && !encontre; i++ )
        {
            Vino vinoActual = ( Vino )vinos.get( i );
            if( vinoActual.darNombre( ).equalsIgnoreCase( pNombre ) )
            {
                buscado = vinoActual;
                encontre = true;
            }
        }

        return buscado;
    }

    /**
     * Busca un vino utilizando una b�squeda binaria. <br>
     * <b>pre: </b> La lista de vinos est� inicializada y se encuentra ordenada por nombre.
     * @param pNombre Nombre del vino que se va a buscar. pNombre != null && pNombre != "".
     * @return Vino con el nombre dado, null en caso de no encontrarlo.
     */
    public Vino buscarBinarioPorNombre( String pNombre )
    {
        //TODO Parte4 PuntoA Complete el m�todo seg�n la documentaci�n dada.
    	//Trae el elemento de la mitad del conjunto y lo compara con el valor buscado, si es menor realiza el mismo proceso con la mitad apropiada
    	ordenarVinosPorNombre();
    	boolean encontro = false;
    	int posicion = -1;
    	int inicio = 0;
    	int fin = vinos.size()-1;
    	while(inicio<=fin&&!encontro)
    	{
    		int medio = (inicio+ fin)/2;
    		Vino vinoMedio = (Vino)vinos.get(medio);
    		if(vinoMedio.darNombre().compareToIgnoreCase(pNombre)==0)
    		{
    			posicion = medio;
    			encontro = true;
    		}
    		else if(vinoMedio.darNombre().compareToIgnoreCase(pNombre)>0)
    		{
    			fin = medio-1;
    		}
    		else
    			inicio = medio+1;
    	}
    	
    	return (posicion>=0)?(Vino)vinos.get(posicion):null;
    }

    /**
     * Busca el vino m�s dulce (con mayor contenido en az�car) de la cava. <br>
     * <b>pre:</b> La lista de vinos est� inicializada.
     * @return Vino m�s dulce de la cava. Si la cava no tiene vinos se retorna null. Si existen varios vinos con el contenido en az�car m�s alto, se retorna el primer vino
     *         encontrado.
     */
    public Vino buscarVinoMasDulce( )
    {
        //TODO Parte4 PuntoB Complete el m�todo seg�n la documentaci�n dada.
    	if(vinos.size()==0)
    		return null;
    	int posicion = -1;
    	int i =0;
    	
    		Vino vinoMayor = (Vino)vinos.get(i);
    		for(int k = 0;k<vinos.size();k++)
    		{
    			Vino vinoMenor = (Vino)vinos.get(k);
    			if(vinoMayor.darContenidoAzucar()<vinoMenor.darContenidoAzucar())
    			{
    				vinoMayor = vinoMenor;
    				posicion = k;
    			}
    		}
    	
    	return (Vino)vinos.get(posicion);
    }

    /**
     * Busca el vino m�s seco (con menor contenido en az�car) de la cava. <br>
     * <b>pre:</b> La lista de vinos est� inicializada.
     * @return Vino m�s seco de la cava. Si la cava no tiene vinos se retorna null. Si existen varios vinos con el contenido en az�car m�s bajo, se retorna el primer vino
     *         encontrado.
     */
    public Vino buscarVinoMasSeco( )
    {
        //TODO Parte4 PuntoC Complete el m�todo seg�n la documentaci�n dada.
    	if(vinos.size()==0)
    		return null;
    	int posicion = -1;
    	int i =0;
    	
    		Vino vinoMenor = (Vino)vinos.get(i);
    		for(int k = 0;k<vinos.size();k++)
    		{
    			Vino vinoMayor = (Vino)vinos.get(k);
    			if(vinoMenor.darContenidoAzucar()>vinoMenor.darContenidoAzucar())
    			{
    				vinoMenor = vinoMayor;
    				posicion = k;
    			}
    		}
    	
    	return (Vino)vinos.get(posicion);    
    	}

    /**
     * Busca los vinos del tipo dado por par�metro. <br>
     * <b>pre:</b> La lista de vinos est� inicializada.
     * @param pTipo Tipo de vino de acuerdo a su contenido en az�car.pTipo != null && pTipo != "" && (pTipo == SECO || pTipo == ABOCADO || pTipo == SEMI_SECO || pTipo ==
     *        SEMI_DULCE || pTipo == DULCE).
     * @return Lista de vinos del tipo dado. Si no hay vinos del tipo buscado, se retorna una lista vac�a.
     */
    public ArrayList buscarVinosDeTipo( String pTipo )
    {
        //TODO Parte4 PuntoD Complete el m�todo seg�n la documentaci�n dada.
    	ArrayList rta = new ArrayList();
    	if(vinos.size()==0)
    		return rta;
    	int posicion = -1;
    	int i =0;
    	
    		Vino vinoActual = (Vino)vinos.get(i);
    		for(int k = 0;k<vinos.size();k++)
    		{
    			//Vino vinoMayor = (Vino)vinos.get(k);
    			if(vinoActual.darTipo().equalsIgnoreCase(pTipo))
    			{
    				rta.add(vinoActual);
    			}
    		}
    	
    	return rta;    
    }

    /**
     * Agrega un nuevo vino a la cava si no existe actualmente un vino en la cava con el mismo nombre.<br>
     * <b>pre:</b> La lista de vinos est� inicializada.<br>
     * <b>post:</b> Se agreg� un nuevo vino a la lista de vinos.<br>
     * @param pNombre Nombre del vino. pNombre != null && pNombre != "".
     * @param pPresentacion Presentaci�n del vino. pPresentacion != null && pPresentacion != "" && (pPresentacion == BOTELLA || pPresentacion == BARRIL).
     * @param pAnhoElaboracion A�o de elaboraci�n del vino. pAnhoElaboracion > 0.
     * @param pContenidoAzucar Contenido en az�car del vino. pContenidoAzucar >= 0
     * @param pTipo Tipo de vino de acuerdo a su contenido en az�car. pTipo != null && pTipo != "" && (pTipo == SECO || pTipo == ABOCADO || pTipo == SEMI_SECO || pTipo ==
     *        SEMI_DULCE || pTipo == DULCE).
     * @param pColor Color del vino. pColor != null && pColor != "" && (pColor == TINTO || pColor == ROSADO || pColor == BLANCO).
     * @param pLugarOrigen Lugar de origen del vino. lugarElaboracion != null y lugarElaboracion != "".
     * @param pImagen Imagen del vino. pImagen != null && pImagen != "".
     * @return True si el vino es agregado, false de lo contrario.
     */
    public boolean agregarVino( String pNombre, String pPresentacion, int pAnhoElaboracion, double pContenidoAzucar, String pTipo, String pColor, String pLugarOrigen, String pImagen )
    {
        Vino buscado = buscarVino( pNombre );
        boolean agregada = false;

        if( buscado == null )
        {
            Vino vino = new Vino( pNombre, pPresentacion, pAnhoElaboracion, pContenidoAzucar, pTipo, pColor, pLugarOrigen, pImagen );
            vinos.add( vino );
            agregada = true;
            verificarInvariante( );
        }

        return agregada;
    }

    /**
     * Ordena ascendentemente la lista de vinos por nombre usando el algoritmo de burbuja. <br>
     * <b>pre:</b> La lista de vinos est� inicializada. <br>
     * <b>post:</b> La lista de vinos est� ordenada por nombre (orden ascendente).
     */
    public void ordenarVinosPorNombre( )
    {
        //TODO Parte3 PuntoA Complete el m�todo seg�n la documentaci�n dada.
    	//Compara parejas y envia el menor a la izquierda 0321=>0213
    	ArrayList vectorV = vinos;
    	
    	for(int i =vectorV.size();i>0;i--)
    	{
    		for(int k =0;k<i-1;k++)
    		{
    			Vino vino1 = (Vino)vectorV.get(k);
    			Vino vino2 = (Vino)vectorV.get(k+1);
    			
    			if(vino1.darNombre().compareToIgnoreCase(vino2.darNombre())>0)
    			{
    				Vino temporal = vino1;
    				vectorV.set(k, vino2);
    				vectorV.set(k+1, temporal);
    				
    			}
    		}
    	}
    	verificarInvariante();
    	vinos = vectorV;
    }

    /**
     * Ordena descendentemente la lista de vinos por a�o de elaboraci�n usando el algoritmo de selecci�n. <br>
     * <b>pre:</b> La lista de vinos est� inicializada. <br>
     * <b>post:</b> La lista de vinos est� ordenada por a�o de elaboraci�n (orden descendente).
     */
    public void ordenarVinosPorAnhoElaboracion( )
    {
        //TODO Parte3 PuntoB Complete el m�todo seg�n la documentaci�n dada.
    	//Escoge al elemento menor y lo pone en la primer posici�n 3210=>0321
    	ArrayList vectorVinos = darVinos();
    	
    	for(int i =0;i<vectorVinos.size()-1;i++)
    	{
    		Vino vino1 = (Vino)vectorVinos.get(i);
    		int posicionMenor = i;
    		for(int k=i+1;k<vectorVinos.size();k++)
    		{
    			Vino vino2 = (Vino)vectorVinos.get(k);
    			if(vino2.darAnhoElaboracion()<vino2.darAnhoElaboracion())
    			{
    				vino1 = vino2;
    				posicionMenor = k;
    			}
    		}
    		Vino temporal = (Vino)vectorVinos.get(i);
    		vectorVinos.set(i, vino1);
    		vectorVinos.set(posicionMenor,temporal);
    	}
    	verificarInvariante();
    	vinos = vectorVinos;
    }

    /**
     * Ordena ascendentemente la lista de vinos por lugar de origen usando el algoritmo de inserci�n. <br>
     * <b>pre:</b> La lista de vinos est� inicializada.<br>
     * <b> post: </b>La lista de vinos est� ordenada por lugar de origen (orden ascendente).
     */
    public void ordenarVinosPorLugarOrigen( )
    {
        //TODO Parte3 PuntoC Complete el m�todo seg�n la documentaci�n dada.
    	//Elige el siguiente elemento del conjunto desordenado y lo ubica en la posici�n correcta en el conjunto ordenado 0321=>0321=>0231
    	ArrayList vectorV = vinos;
    	for(int i = 1;i<vectorV.size();i++)
    	{
    		
    		for(int k = i;k>0;k--)
    		{
    			Vino vino1 = (Vino)vectorV.get(k);
        		Vino vino2 = (Vino)vectorV.get(k-1);
        		if(vino2.compararPorLugarOrigen(vino1)==1)
        		{
        			Vino temporal = vino1;
        			vectorV.set(k,vino2);
        			vectorV.set(k-1,temporal);
        		}
    			
    		}
    	}
    	verificarInvariante();
    	vinos = vectorV;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    // TODO Parte1 PuntoD Cree e implemente el m�todo private void verificarInvariante para validar el invariante definido en Parte1 PuntoC. De ser necesario puede crear
    // m�todos privados auxiliares.
    public void verificarInvariante()
    {
    	
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * M�todo para la extensi�n 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }
}