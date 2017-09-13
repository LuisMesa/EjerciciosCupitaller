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

/**
 * Clase que representa un vino almacenado en la Cupi-Cava.<br>
 * <b>inv: </b> <br>
 * //TODO Parte1 PuntoA Defina el invariante de la clase y docum�ntelo.
 */
public class Vino
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa la presentaci�n barril.
     */
    public final static String BARRIL = "Barril";

    /**
     * Constante que representa la presentaci�n botella.
     */
    public final static String BOTELLA = "Botella";

    /**
     * Constante que representa el color tinto.
     */
    public final static String TINTO = "Tinto";

    /**
     * Constante que representa el color rosado.
     */
    public final static String ROSADO = "Rosado";

    /**
     * Constante que representa el color blanco.
     */
    public final static String BLANCO = "Blanco";

    /**
     * Constante que representa el tipo de vino seco.
     */
    public final static String SECO = "Seco";

    /**
     * Constante que representa el tipo de vino abocado.
     */
    public static final String ABOCADO = "Abocado";

    /**
     * Constante que representa el tipo de vino semi-seco.
     */
    public static final String SEMI_SECO = "Semi-seco";

    /**
     * Constante que representa el tipo de vino semi-dulce.
     */
    public static final String SEMI_DULCE = "Semi-dulce";

    /**
     * Constante que representa el tipo de vino dulce.
     */
    public static final String DULCE = "Dulce";

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Nombre del vino.
     */
    private String nombre;

    /**
     * Presentaci�n del vino.
     */
    private String presentacion;

    /**
     * A�o de elaboraci�n del vino.
     */
    private int anhoElaboracion;

    /**
     * Contenido en az�car del vino (gramos/litro).
     */
    private double contenidoAzucar;

    /**
     * Tipo del vino.
     */
    private String tipo;

    /**
     * Color del vino.
     */
    private String color;

    /**
     * Lugar de origen del vino.
     */
    private String lugarOrigen;

    /**
     * Ruta donde se encuentra la imagen del vino.
     */
    private String imagen;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Inicializa el vino con la informaci�n dada por par�metro. <br>
     * <b>post: </b> El vino se inicializ� con los valores de nombre, presentaci�n, a�o elaboraci�n, contenido en az�car, tipo, color, lugar de origen e imagen dados por
     * par�metro.
     * @param pNombre Nombre del vino. pNombre != null && pNombre != "".
     * @param pPresentacion Presentaci�n del vino. pPresentacion != null && pPresentacion != "" && (pPresentacion == BOTELLA || pPresentacion == BARRIL).
     * @param pAnhoElaboracion A�o de elaboraci�n del vino. pAnhoElaboracion > 0.
     * @param pContenidoAzucar Contenido en az�car del vino. pContenidoAzucar >= 0
     * @param pTipo Tipo de vino de acuerdo a su contenido en az�car. pTipo != null && pTipo != "" && (pTipo == SECO || pTipo == ABOCADO || pTipo == SEMI_SECO || pTipo ==
     *        SEMI_DULCE || pTipo == DULCE).
     * @param pColor Color del vino. pColor != null && pColor != "" && (pColor == TINTO || pColor == ROSADO || pColor == BLANCO).
     * @param pLugarOrigen Lugar de origen del vino. lugarElaboracion != null y lugarElaboracion != "".
     * @param pImagen Imagen del vino. pImagen != null && pImagen != "".
     */
    public Vino( String pNombre, String pPresentacion, int pAnhoElaboracion, double pContenidoAzucar, String pTipo, String pColor, String pLugarOrigen, String pImagen )
    {
        nombre = pNombre;
        presentacion = pPresentacion;
        anhoElaboracion = pAnhoElaboracion;
        contenidoAzucar = pContenidoAzucar;
        tipo = pTipo;
        color = pColor;
        lugarOrigen = pLugarOrigen;
        imagen = pImagen;

        verificarInvariante( );
    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna el nombre del vino.
     * @return Nombre del vino.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la presentaci�n del vino.
     * @return Presentaci�n del vino.
     */
    public String darPresentacion( )
    {
        return presentacion;
    }

    /**
     * Retorna el a�o de elaboraci�n del vino.
     * @return A�o de elaboraci�n del vino.
     */
    public int darAnhoElaboracion( )
    {
        return anhoElaboracion;
    }

    /**
     * Retorna el contenido en az�car del vino.
     * @return Contenido en az�car del vino.
     */
    public double darContenidoAzucar( )
    {
        return contenidoAzucar;
    }

    /**
     * Retorna el tipo del vino.
     * @return Tipo del vino.
     */
    public String darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna el color del vino.
     * @return Color del vino.
     */
    public String darColor( )
    {
        return color;
    }

    /**
     * Retorna el lugar de origen del vino.
     * @return Lugar de origen del vino.
     */
    public String darLugarOrigen( )
    {
        return lugarOrigen;
    }

    /**
     * Retorna la imagen del vino.
     * @return Imagen del vino.
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Compara dos vinos seg�n el nombre. <br>
     * @param pVino Vino contra el cual se est� comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo nombre. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el nombre. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el nombre. <br>
     */
    public int compararPorNombre( Vino pVino )
    {
        //TODO Parte2 PuntoA Complete el m�todo seg�n la documentaci�n dada.
    	if((pVino.darNombre()).equalsIgnoreCase(darNombre()))
			return 0;
	
		return (pVino.darNombre()).compareToIgnoreCase(darNombre())>0?-1:1;
    }

    /**
     * Compara dos vinos seg�n el a�o de elaboraci�n. <br>
     * @param pVino Vino contra el cual se est� comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo a�o de elaboraci�n. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el a�o de elaboraci�n. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el a�o de elaboraci�n. <br>
     */
    public int compararPorAnhoElaboracion( Vino pVino )
    {
        //TODO Parte2 PuntoB Complete el m�todo seg�n la documentaci�n dada.
    	if(pVino.darAnhoElaboracion()==darAnhoElaboracion())
    		return 0;
    	else if(pVino.darAnhoElaboracion()>darAnhoElaboracion())
    		return -1;
    	return 1;
    }

    /**
     * Compara dos vinos seg�n el lugar de origen. <br>
     * @param pVino Vino contra el cual se est� comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo lugar de origen. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el lugar de origen. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el lugar de origen. <br>
     */
    public int compararPorLugarOrigen( Vino pVino )
    {
        //TODO Parte2 PuntoC Complete el m�todo seg�n la documentaci�n dada.
    	if((pVino.darLugarOrigen()).equalsIgnoreCase(darLugarOrigen()))
    			return 0;
    	
    		return (pVino.darLugarOrigen()).compareToIgnoreCase(darLugarOrigen())>0?-1:1;
    	
    }

    /**
     * Compara dos vinos seg�n el contenido en az�car. <br>
     * @param pVino Vino contra el cual se est� comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo contenido en az�car. <br>
     *         Retorna -1 si el vino pVino tiene un mayor contenido en az�car. <br>
     *         Retorna 1 si el vino pVino tiene un menor contenido en az�car. <br>
     */
    public int compararPorContenidoAzucar( Vino pVino )
    {
        //TODO Parte2 PuntoD Complete el m�todo seg�n la documentaci�n dada.
    	if(pVino.darContenidoAzucar()==darContenidoAzucar())
    		return 0;
    	else if(pVino.darContenidoAzucar()>darContenidoAzucar())
    		return -1;
    	return 1;
    }

    /**
     * Retorna una cadena con el nombre del vino.
     * @return Representaci�n del vino en una cadena de caracteres.
     */
    public String toString( )
    {
        //TODO Parte2 PuntoE Complete el m�todo seg�n la documentaci�n dada.
    	return darNombre();
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    //TODO Parte1 PuntoB Cree e implemente el m�todo private void verificarInvariante para validar el invariante definido en Parte1 PuntoA.
    private boolean nombreValido()
    {
    	if(nombre.equals("")||nombre==null)
    		return false;
    	else
    		return true;
    }
    private boolean azucarValida()
    {
    	return contenidoAzucar>=0;
    }
    private boolean presentacionValida()
    {
    	if(presentacion.equals("")||presentacion==null)
    		return false;
    	else
    		return true;
    }
    private boolean anhoValido()
    {
    	return (anhoElaboracion>=0);
    }
    private boolean lugarValido()
    {
    	if(lugarOrigen.equals("")||lugarOrigen==null)
    		return false;
    	else
    		return true;
    }
    
    private void verificarInvariante()
    {
    	assert nombreValido(): "El nombre es invalido.";
    	assert presentacionValida(): "La categoria es invalida.";
    	assert azucarValida() : "El Azucar es invalido.";
    	assert anhoValido() : "El costo Estimado de da�os es invalido.";
    	assert lugarValido(): "El Lugar es invalido";
    }
}