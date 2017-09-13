/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: sistemaAntecedentes
 * Autor: Equipo Cupi2 2015.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sistemaAntecedentes.mundo;

import java.util.ArrayList;

/**
 * Clase que representa un procesado.
 */
public class Procesado
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Constante que representa el g�nero masculino.
     */
    public final static String MASCULINO = "Masculino";

    /**
     * Constante que representa el g�nero femenino.
     */
    public final static String FEMENINO = "Femenino";

    /**
     * Constante que representa la mayor�a de edad.
     */
    public final static int MAYOR_EDAD = 18;

    /**
     * Constante que representa la edad m�nima de un procesado.
     */
    public final static int EDAD_MINIMA = 5;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Los antecedentes del procesado.
     */
    // TODO Parte2 PuntoA: Declare el atributo antecedentes como un vector.
    private ArrayList<Antecedente>  antecedentes;
    /**
     * Nombre del procesado.
     */
    // TODO Parte2 PuntoB: Declare el atributo nombre como una cadena de caracteres.
    private String nombre;
    /**
     * Apellido del procesado.
     */
    // TODO Parte2 PuntoC: Declare el atributo apellido como una cadena de caracteres.
    private String apellido;
    /**
     * N�mero de identificaci�n del procesado.
     */
    // TODO Parte2 PuntoD: Declare el atributo identificacion como una cadena de caracteres.
    private String identificacion;
    /**
     * Sexo del procesado.
     */
    // TODO Parte2 PuntoE: Declare el atributo sexo como una cadena de caracteres.
    private String sexo;
    
    
    /**
     * Edad del procesado.
     */
    // TODO Parte2 PuntoF: Declare el atributo edad como un entero.
    private int edad;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Inicializa un procesado con la informaci�n dada por par�metro. <br>
     * <b>post: </b> El procesado se inicializ� con los valores de nombre, apellido, n�mero de identificaci�n, sexo y edad dados por par�metro. <br>
     * Se inicializ� el vector de antecedentes vac�o. <br>
     * @param pNombre Nombre del procesado. pNombre != null && pNombre != "".
     * @param pApellido Apellido del procesado. pApellido != null && pApellido != "".
     * @param pIdentificacion N�mero de identificaci�n del procesado. pIdentificacion != null && pIdentificacion != "".
     * @param pSexo Sexo del procesado. pSexo != null && pSexo != "".
     * @param pEdad Edad del procesado.
     * @throws Exception Si la edad del procesado dada por par�metro es menor a la edad m�nima permitida.
     */
    public Procesado( String pNombre, String pApellido, String pIdentificacion, String pSexo, int pEdad ) throws Exception
    {
        // TODO Parte2 PuntoG: Complete el m�todo constructor de la clase.

        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:

        // Error si la edad dada por par�metro es menor a la edad m�nima.
        // Mensaje de error: La edad m�nima del procesado es de <EDAD_MINIMA> a�os.
    	if (pEdad < EDAD_MINIMA)
    	{
    		throw new Exception("La edad m�nima del procesado es de "+EDAD_MINIMA+" a�os.");
    	}
    	antecedentes = new ArrayList<Antecedente>() ; 
    	
    	nombre = pNombre;
    	apellido = pApellido;
    	identificacion = pIdentificacion;
    	sexo = pSexo;
    	edad = pEdad;
    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna el nombre del procesado.
     * @return Nombre del procesado.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el apellido del procesado.
     * @return Apellido del procesado.
     */
    public String darApellido( )
    {
        return apellido;
    }

    /**
     * Retorna el n�mero de identificaci�n del procesado.
     * @return N�mero de identificaci�n del procesado.
     */
    public String darIdentificacion( )
    {
        return identificacion;
    }

    /**
     * Retorna el sexo del procesado.
     * @return Sexo del procesado.
     */
    public String darSexo( )
    {
        return sexo;
    }

    /**
     * Retorna la edad del procesado.
     * @return Edad del procesado.
     */
    public int darEdad( )
    {
        return edad;
    }

    /**
     * Retorna los antecedentes del procesado.
     * @return lista de antecedentes.
     */
    public ArrayList darAntecedentes( )
    {
        return antecedentes;
    }

    /**
     * Retorna el n�mero de antecedentes que tiene el procesado.
     * @return El n�mero de antecedentes que tiene el procesado.
     */
    public int darNumeroAntecedentes( )
    {
    	
        return antecedentes.size( );
    }

    /**
     * Retorna los a�os de condena que debe cumplir el procesado por sus antecedentes.
     * @return A�os de condena que debe cumplir el procesado.
     */
    public int darAnhosCondena( )
    {
        int anhosCondena = 0;
        Antecedente actual = null;

        for( int i = 0; i < antecedentes.size( ); i++ )
        {
            actual = ( Antecedente )antecedentes.get( i );
            anhosCondena += actual.darAnhosCondena( );
        }

        return anhosCondena;
    }

    /**
     * Indica si el procesado es mayor de edad o no.
     * @return true si el procesado es mayor de edad. False de lo contrario.
     */
    public boolean esMayorDeEdad( )
    {
        boolean esMayorEdad = false;

        if( edad >= MAYOR_EDAD )
        {
            esMayorEdad = true;
        }

        return esMayorEdad;
    }

    /**
     * Crea un antecedente dada la informaci�n por par�metro y lo agrega a la lista de antecedentes del procesado. <br>
     * <b> pre: </b> La lista de antecedentes est� inicializada. <br>
     * <b> post: </b> Se agreg� un nuevo antecedente a la lista de antecedentes. <br>
     * @param pIdentificadorAntecedente El n�mero de identificaci�n del procesado. pIdentificadorAntecedente >= 0.
     * @param pTipoAntecedente Tipo del antecedente. pTipoAntecedente != null && pTipoAntecedente != "".
     * @param pDescripcionAntecedente Descripci�n del antecedente. pDescripcionAntecedente != null && pDescripcionAntecedente != "".
     */
    public void agregarAntecedente( int pIdentificadorAntecedente, String pTipoAntecedente, String pDescripcionAntecedente )
    {
        Antecedente nuevo = new Antecedente( pIdentificadorAntecedente, pTipoAntecedente, pDescripcionAntecedente );
        antecedentes.add( nuevo );
    }

    // TODO Parte2 PuntoH: Escriba el contrato del m�todo de acuerdo a la funcionalidad implementada.
    public Antecedente buscarAntecedente( int pIdentificadorAntecedente )
    {
        Antecedente respuesta = null;
        Antecedente actual = null;
        boolean encontroAntecente = false;

        for( int i = 0; i < antecedentes.size( ) && !encontroAntecente; i++ )
        {
            actual = ( Antecedente )antecedentes.get( i );

            if( actual.darIdentificador( ) == pIdentificadorAntecedente )
            {
                respuesta = actual;
                encontroAntecente = true;
            }
        }
        return respuesta;
    }

    /**
     * Condena al procesado por el antecedente con identificador dado por par�metro con los a�os de condena dados por par�metro. <br>
     * <b> pre: </b> El antecedente con el tipo e identificador dados existe. <br>
     * @param pAnhosCondena Los a�os de condena por el antecedente dado. pAnhosCondena >= 0.
     * @param pIdentificadorAntecedente El identificador del antecedente por el que se va a condenar. pIdentificadorAntecedente >= 0.
     * @throws Exception Si el procesado es menor de edad y se trata de condenar.
     * @throws Exception Si la gravedad del antecedente es LEVE y la condena dada por par�metro es menor o igual a 0 o mayor a MAXIMO_ANHOS_CONDENA_LEVE.
     * @throws Exception Si la gravedad del antecedente es GRAVE y la condena dada por par�metro es menor o igual a MAXIMO_ANHOS_CONDENA_LEVE o mayor a MAXIMO_ANHOS_CONDENA_GRAVE.
     * @throws Exception Si la gravedad del antecedente es MUY_GRAVE y la condena dada por par�metro es menor a MINIMO_ANHOS_CONDENA_MUY_GRAVE.
     */
    public void condenarProcesado( int pAnhosCondena, int pIdentificadorAntecedente ) throws Exception
    {
        // TODO Parte2 PuntoI: Complete el m�todo seg�n la documentaci�n.
        
        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:
        
        // Error si se condena a un procesado menor de edad.
        // Mensaje de error: No se puede condenar a un procesado menor de edad.
    	
    	if (pAnhosCondena < MAYOR_EDAD)
    	{
    		throw new Exception ("No se puede condenar a un procesado menor de edad.");
    	}
    	boolean encontrado = false;
    	for (int i = 0; i < antecedentes.size() && !encontrado; i ++)
    	{
    		if (pIdentificadorAntecedente == antecedentes.get(i).darIdentificador() )
    		{
    			encontrado = true;
    			antecedentes.get(i).cambiarCondena(pAnhosCondena);
    		}
    		
    	}
    }

    /**
     * Elimina el antecedente con identificador dado por par�metro.<br>
     * <b> pre: </b> La lista de antecedentes est� inicializada.<br>
     * El antecedente a eliminar se encuentra en la lista de antecedentes. <br>
     * <b> post: </b> Se elimin� el antecedente de la lista de antecedentes. <br>
     * @param pIdentificadorAntecedente Identificador del antecedente a eliminar. pIdentificadorAntecedente >= 0.
     * @throws Exception Si la gravedad del antecedente es MUY_GRAVE o GRAVE.
     */
    public void eliminarAntecedente( int pIdentificadorAntecedente ) throws Exception
    { 
        // TODO Parte2 PuntoJ: Complete el m�todo seg�n la documentaci�n.
        
        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:
        
        // Error si se trata de eliminar un antecedente con gravedad GRAVE o MUY_GRAVE.
        // Mensaje de error: No se puede eliminar un antecedente <MUY_GRAVE> o <GRAVE>.
    }

    /**
     * Indica si un procesado tiene un antecedente del tipo dado por par�metro. <br>
     * <b> pre: </b> La lista de antecedentes est� inicializada. <br>
     * @param pTipoAntecedente Tipo de antecedente a buscar. pTipoAntecedente != null && pTipoAntecedente != "".
     * @return true si el procesado tiene un antecedente del tipo dado por par�metro, false en caso contrario.
     */
    public boolean tieneAntecedenteTipo( String pTipoAntecedente )
    {
        Antecedente actual = null;
        boolean tieneAntecedente = false;
        for( int i = 0; i < antecedentes.size( ) && !tieneAntecedente; i++ )
        {
            actual = ( Antecedente )antecedentes.get( i );

            if( actual.darTipo( ).equals( pTipoAntecedente ) )
            {
                tieneAntecedente = true;
            }
        }
        return tieneAntecedente;
    }
}