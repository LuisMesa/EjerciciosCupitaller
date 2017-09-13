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

/**
 * Clase que represente el antecedente de un procesado.
 */
public class Antecedente
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa el tipo de antecedente de homicidio.
     */
    public final static String HOMICIDIO = "Homicidio";

    /**
     * Constante que representa el tipo de antecedente de violencia f�sica.
     */
    public final static String VIOLENCIA = "Violencia";

    /**
     * Constante que representa el tipo de antecedente de robo.
     */
    public final static String ROBO = "Robo";

    /**
     * Constante que representa el tipo de antecedente de delito ecol�gico.
     */
    public final static String ECOLOGICO = "Ecol�gico";

    /**
     * Constante que representa el tipo de antecedente de delito de tr�nsito.
     */
    public final static String TRANSITO = "Tr�nsito";

    /**
     * Constante que representa el tipo de antecedente de secuestro.
     */
    public final static String SECUESTRO = "Secuestro";

    /**
     * Constante que representa el tipo de antecedente de delito de allanamiento de morada.
     */
    public final static String ALLANAMIENTO_DE_MORADA = "Allanamiento de morada";

    /**
     * Constante que representa el tipo de antecedente de estafa.
     */
    public final static String ESTAFA = "Estafa";

    /**
     * Constante que representa el tipo de antecedente de consumo de drogas.
     */
    public final static String CONSUMO_DE_DROGAS = "Consumo de drogas";

    /**
     * Constante que representa el tipo de antecedente de tr�fico de drogas.
     */
    public final static String TRAFICO_DE_DROGAS = "Tr�fico de drogas";

    /**
     * Constante que representa un antecedente muy grave.
     */
    // TODO Parte1 PuntoA: Declare la constante MUY_GRAVE con valor "Muy grave".
    public final static String MUY_GRAVE = "Muy grave";

    /**
     * Constante que representa un antecedente grave.
     */
    // TODO Parte1 PuntoB: Declare la constante GRAVE con valor "Grave".
    public final static String GRAVE = "Grave";

    /**
     * Constante que representa un antecedente leve.
     */
    // TODO Parte1 PuntoC: Declare la constante LEVE con valor "Leve".
    public final static String LEVE = "Leve";

    /**
     * Constante que representa el m�ximo de a�os de condena por un antecedente leve.
     */
    // TODO Parte1 PuntoD: Declare la constante MAXIMO_ANHOS_CONDENA_LEVE con valor 5.
    public final static int MAXIMO_ANHOS_CONDENA_LEVE = 5;
    /**
     * Constante que representa el m�ximo de a�os de condena por un antecedente grave.
     */
    // TODO Parte1 PuntoE: Declare la constante MAXIMO_ANHOS_CONDENA_GRAVE con valor 15.
    public final static int MAXIMO_ANHOS_CONDENA_GRAVE =15;
    /**
     * Constante que representa el m�nimo de a�os de condena por un antecedente muy grave.
     */
    // TODO Parte1 PuntoF: Declare la constante MINIMO_ANHOS_CONDENA_MUY_GRAVE con valor 16.
    public final static int MINIMO_ANHOS_CONDENA_MUY_GRAVE =16;
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Identificador del antecedente.
     */
    private int identificador;
    
    /**
     * Tipo del antecedente.
     */
    private String tipo;

    /**
     * Descripci�n del antecedente.
     */
    private String descripcion;

    /**
     * Gravedad del antecedente.
     */
    private String gravedad;

    /**
     * A�os de condena por este antecedente.
     */
    private int anhosCondena;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Inicializa el antecedente con la informaci�n dada por par�metro. <br>
     * <b> post: </b> El antecedente se inicializ� con los atributos de tipo, descripci�n y condena dados por par�metro. <br>
     *                La gravedad del antecedente qued� inicializada.
     * @param pIdentificador Identificador del antecedente. pIdentificador >= 0.
     * @param pTipo Tipo del antecedente. pTipo != null && pTipo != "" && pTipo pertenece { HOMICIDO, VIOLENCIA, ROBO, ECOLOGICO, TRANSITO, SECUESTRO, ALLANAMIENTO_DE_MORADA,
     *        ESTAFA, CONSUMO_DE_DROGRAS, TR�FICO_DE_DROGRAS }.
     * @param pDescripcion Descripci�n del antecedente. pDescripcion != null && pDescripcion != "".
     */
    public Antecedente( int pIdentificador, String pTipo, String pDescripcion )
    {
        identificador = pIdentificador;
        tipo = pTipo;
        descripcion = pDescripcion;
        anhosCondena = 0;
        
        determinarGravedad( );
        
    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna el identificador del antecedente.
     * @return Identificador del antecedente.
     */
    public int darIdentificador( )
    {
        return identificador;        
    }
    
    /**
     * Retorna el tipo del antecedente.
     * @return Tipo del antecedente.
     */
    public String darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna la descripci�n del antecedente.
     * @return Descripci�n del antecedente.
     */
    public String darDescripcion( )
    {
        return descripcion;
    }

    /**
     * Retorna la gravedad del antecedente.
     * @return Gravedad del antecedente.
     */
    public String darGravedad( )
    {
        return gravedad;
    }

    /**
     * Retorna la condena del antecedente.
     * @return Condena del antecedente.
     */
    public int darAnhosCondena( )
    {
        return anhosCondena;
    }
    
    /**
     * Cambia los a�os de condena por el valor dado por par�metro. <br>
     * <b> pre: </b> La gravedad est� inicializada. <br>
     * @param pAnhosCondena La nueva condena. pAnhosCondena >= 0.
     * @throws Exception Si la gravedad del antecedente es LEVE y la condena dada por par�metro es menor o igual a 0 o mayor a MAXIMO_ANHOS_CONDENA_LEVE.
     * @throws Exception Si la gravedad del antecedente es GRAVE y la condena dada por par�metro es menor o igual a MAXIMO_ANHOS_CONDENA_LEVE o mayor a MAXIMO_ANHOS_CONDENA_GRAVE.
     * @throws Exception Si la gravedad del antecedente es MUY_GRAVE y la condena dada por par�metro es menor a MINIMO_ANHOS_CONDENA_MUY_GRAVE.
     */
    public void cambiarCondena( int pAnhosCondena ) throws Exception
    {
        // TODO Parte1 PuntoG: Complete el m�todo seg�n la documentaci�n.
        
        // Tenga en cuenta los posibles errores que se pueden generar en este m�todo y que se describen a continuaci�n:
        
        // Error si la gravedad del antecedente es leve y la condena dada por par�metro es menor o igual a 0 o mayor al m�ximo de a�os de condena por un antecedente leve.
        // Mensaje de error: Por ser un antecedente de gravedad leve, la condena debe ser mayor a 0 a�os y menor o igual a <MAXIMO_ANHOS_CONDENA_LEVE> a�os.
        
        // Error si la gravedad del antecedente es grave y la condena dada por par�metro es menor o igual al m�ximo de a�os de condena por un antecedente leve o mayor al m�ximo de a�os de condena por un antecedente grave.
        // Mensaje de error: Por ser un antecedente grave, la condena debe ser mayor a <MAXIMO_ANHOS_CONDENA_LEVE> a�os y menor o igual a <MAXIMO_ANHOS_CONDENA_GRAVE> a�os.
        
        // Error si la gravedad del antecedente es muy grave y la condena dada por par�metro es menor al m�nimo de a�os de condena por un antecedente muy grave.
        // Mensaje de error: Por ser un antecedente muy grave, la condena debe ser mayor o igual a <MINIMO_ANHOS_CONDENA_MUY_GRAVE> a�os.
        
    	if (gravedad.equals(LEVE) && (pAnhosCondena <= 0 || pAnhosCondena > MAXIMO_ANHOS_CONDENA_LEVE))
    	{
    		Exception e = new Exception("Por ser un antecedente de gravedad leve, la condena debe ser mayor a 0 a�os y menor o igual a "  +MAXIMO_ANHOS_CONDENA_LEVE + "" + " a�os.");
    		throw e;
    	}
    	else if(gravedad.equals(GRAVE) && (pAnhosCondena <= MAXIMO_ANHOS_CONDENA_LEVE || pAnhosCondena > MAXIMO_ANHOS_CONDENA_GRAVE))
    	{  
    		throw new Exception("Por ser un antecedente grave, la condena debe ser mayor a " + MAXIMO_ANHOS_CONDENA_LEVE + " a�os y menor o igual a " + MAXIMO_ANHOS_CONDENA_GRAVE+ " a�os.");
    	}
    	else if (gravedad.equals(MUY_GRAVE) && ( pAnhosCondena < MINIMO_ANHOS_CONDENA_MUY_GRAVE))
    	{
    		throw new Exception ("Por ser un antecedente muy grave, la condena debe ser mayor o igual a " + MINIMO_ANHOS_CONDENA_MUY_GRAVE + " a�os.");
    	}
    	else
    	{
    		anhosCondena = pAnhosCondena;
    	}
    }

    /**
     * Cambia la gravedad de un antecedente teniendo en cuenta el tipo del antecedente de la siguiente manera: <br>
     * La gravedad del antecedente es MUY_GRAVE si el tipo del antecedente pertenece a { HOMICIDIO, VIOLENCIA, SECUESTRO, TRAFICO_DE_DROGAS }. <br>
     * La gravedad del antecedente es GRAVE si el tipo del antecedente pertenece a { ALLANAMIENTO_DE_MORADA, ROBO, ESTAFA }. <br>
     * La gravedad del antecedente es LEVE si el tipo del antecedente pertenece a { ECOLOGICO, TRANSITO, CONSUMO_DE_DROGAS }. <br>
     * <b> pre: </b> El tipo del antecedente ya est� inicializado. <br>
     * <b> post: </b> La gravedad del antecedente fue asignado.
     */
    public void determinarGravedad( )
    {
        if( tipo.equals( HOMICIDIO ) || tipo.equals( VIOLENCIA ) || tipo.equals( SECUESTRO ) || tipo.equals( TRAFICO_DE_DROGAS ) )
        {
            gravedad = MUY_GRAVE;
        }
        else if( tipo.equals( ALLANAMIENTO_DE_MORADA ) || tipo.equals( ROBO ) || tipo.equals( ESTAFA ) )
        {
            gravedad = GRAVE;
        }
        else
        {
            gravedad = LEVE;
        }
    }

    /**
     * Retorna una cadena con el identificador, tipo y gravedad del antecedente.
     * @return La representaci�n del antecedente en String. Tiene el siguiente formato: <identificador> - <tipo> (<gravedad>).
     */
    public String toString( )
    {
        return identificador + " - " + tipo + " (" + gravedad + ").";
    }
}