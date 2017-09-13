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
     * Constante para la silla económica.
     */
    public final static int CLASE_ECONOMICA = 2;

    /**
     * Constante para la ubicación de la silla en la ventana.
     */
    public final static int VENTANA = 1;

    /**
     * Constante para la ubicación de la silla en el centro.
     */
    public final static int CENTRAL = 2;

    /**
     * Constante para ubicación de la silla en el pasillo.
     */
    public final static int PASILLO = 3;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Número de la silla.
     */
    private int numero;

    /**
     * Clase de la silla.
     */
    private int clase;

    /**
     * Ubicación de la silla.
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
     * Crea la silla con los valores pasados como parámetro. <br>
     * <b>post: </b> El objeto silla tiene sus datos básicos número, clase y ubicación asignados. El pasajero no está asignado y tiene valor null.<br>
     * @param pNumero Número de silla. pNumero > 0
     * @param pClase Clase de silla. (pClase == CLASE_EJECUTIVA || pClase == CLASE_ECONOMICA).
     * @param pUbicacion Ubicación elegida por el pasajero. (pUbicacion == VENTANA || pUbicacion == CENTRAL || pUbicacion == PASILLO).
     */
    public Silla( int pNumero, int pClase, int pUbicacion )
    {
        numero = pNumero;
        clase = pClase;
        ubicacion = pUbicacion;

        pasajero = null;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de la silla.
     * @return Número de silla.
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
     * Retorna la ubicación de la silla.
     * @return Ubicación de la silla.
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
     * @param pCedulaPasajero Cédula del pasajero. pCedulaPasajero != null && pCedulaPasajero != "".
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
     * Indica si la silla está asignada.
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
     * Indica si la silla está asignada al pasajero dado.
     * @param pCedulaPasajero Cédula del pasajero. pCedulaPasajero != null && pCedulaPasajero != "".
     * @return True si el pasajero ocupa la silla, false si la silla está vacía o no coincide el pasajero.
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