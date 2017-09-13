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

/**
 * Clase que representa a una silla.
 */
public class Silla
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la silla ejecutiva.
     */
    public final static int CLASE_EJECUTIVA = 1;

    /**
     * Constante para la silla econ�mica.
     */
    public final static int CLASE_ECONOMICA = 2;

    /**
     * Constante para la ubicaci�n de la silla en la ventana.
     */
    public final static int VENTANA = 1;

    /**
     * Constante para la ubicaci�n de la silla en el centro.
     */
    public final static int CENTRAL = 2;

    /**
     * Constante para ubicaci�n de la silla en el pasillo.
     */
    public final static int PASILLO = 3;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * N�mero de la silla.
     */
    private int numero;

    /**
     * Clase de la silla.
     */
    private int clase;

    /**
     * Ubicaci�n de la silla.
     */
    private int ubicacion;

    /**
     * Pasajero asignado a la silla.
     */
    private Pasajero pasajero;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la silla con los valores pasados como par�metro. <br>
     * <b>post: </b> El objeto silla tiene sus datos b�sicos n�mero, clase y ubicaci�n asignados. El pasajero no est� asignado y tiene valor null.<br>
     * @param pNumero N�mero de silla. pNumero > 0
     * @param pClase Clase de silla. (pClase == CLASE_EJECUTIVA || pClase == CLASE_ECONOMICA).
     * @param pUbicacion Ubicaci�n elegida por el pasajero. (pUbicacion == VENTANA || pUbicacion == CENTRAL || pUbicacion == PASILLO).
     */
    public Silla( int pNumero, int pClase, int pUbicacion )
    {
        numero = pNumero;
        clase = pClase;
        ubicacion = pUbicacion;

        pasajero = null;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de la silla.
     * @return N�mero de silla.
     */
    public int darNumero( )
    {
        return numero;
    }

    /**
     * Retorna la clase de la silla.
     * @return Clase de la silla.
     */
    public int darClase( )
    {
        return clase;
    }

    /**
     * Retorna la ubicaci�n de la silla.
     * @return Ubicaci�n de la silla.
     */
    public int darUbicacion( )
    {
        return ubicacion;
    }

    /**
     * Retorna el pasajero asignado a la silla.
     * @return Pasajero asignado a la silla. Si no hay pasajero retorna null.
     */
    public Pasajero darPasajero( )
    {
        return pasajero;
    }

    /**
     * Asigna la silla al pasajero. <br>
     * @param pCedulaPasajero C�dula del pasajero. pCedulaPasajero != null && pCedulaPasajero != "".
     * @param pNombrePasajero Nombre del pasajero. pNombrePasajero != null && pNombrePasajero != "".
     */
    public void asignarAPasajero( int pCedulaPasajero, String pNombrePasajero )
    {
        pasajero = new Pasajero( pCedulaPasajero, pNombrePasajero );
    }

    /**
     * Desasigna la silla al pasajero. <br>
     * <b>post: </b> La silla queda nuevamente libre.
     */
    public void desasignarSilla( )
    {
        pasajero = null;
    }

    /**
     * Indica si la silla est� asignada.
     * @return True si la silla esta asignada, false en caso contrario
     */
    public boolean sillaAsignada( )
    {
        boolean asignada = false;
        if( null == pasajero )
        {
            asignada = false;
        }
        else
        {
            asignada = true;
        }

        return asignada;
    }

    /**
     * Indica si la silla est� asignada al pasajero dado.
     * @param pCedulaPasajero C�dula del pasajero. pCedulaPasajero != null && pCedulaPasajero != "".
     * @return True si el pasajero ocupa la silla, false si la silla est� vac�a o no coincide el pasajero.
     */
    public boolean sillaAsignadaPasajero( int pCedulaPasajero )
    {
        boolean asignado = false;

        if( null == pasajero )
        {
            asignado = false;
        }
        else if( pasajero.darCedula( ) == pCedulaPasajero  )
        {
            asignado = true;
        }
        else
        {
            asignado = false;
        }
        return asignado;
    }
}