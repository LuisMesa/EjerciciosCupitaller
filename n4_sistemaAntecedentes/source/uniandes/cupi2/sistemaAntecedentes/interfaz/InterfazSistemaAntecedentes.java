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

package uniandes.cupi2.sistemaAntecedentes.interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.sistemaAntecedentes.mundo.Procesado;
import uniandes.cupi2.sistemaAntecedentes.mundo.SistemaAntecedentes;

/**
 * Ventana principal de la aplicaci�n.
 */
public class InterfazSistemaAntecedentes extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private SistemaAntecedentes sistemaAntecedentes;

    /**
     * Posici�n del procesado actual en la lista de procesados.
     */
    private int posicionProcesadoActual;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen del encabezado.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con la informaci�n del procesado y de sus antecedentes.
     */
    private PanelContenedor panelContenedor;

    /**
     * Panel con las extensiones.
     */
    private PanelAcciones panelAcciones;

    /**
     * Di�logo para agregar un procesado.
     */
    private DialogoAgregarProcesado dialogoAgregarProcesado;

    /**
     * Di�logo para agregar un antecedente.
     */
    private DialogoAgregarAntecedente dialogoAgregarAntecedente;

    /**
     * Di�logo para buscar por antecedente.
     */
    private DialogoBuscarPorAntecedente dialogoBuscarPorAntecedente;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva interfaz. <br>
     * <b>post: </b> El objeto InterfazSistemaAntecedentes est� inicializado.
     */
    public InterfazSistemaAntecedentes( )
    {
        sistemaAntecedentes = new SistemaAntecedentes( );

        setTitle( "Sistema Antecedentes Penales" );
        setSize( 660, 525 );
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        setLayout( new BorderLayout( ) );

        JPanel aux = new JPanel( );
        aux.setLayout( new BorderLayout( ) );

        panelImagen = new PanelImagen( );
        aux.add( panelImagen, BorderLayout.NORTH );

        panelContenedor = new PanelContenedor( this );
        aux.add( panelContenedor, BorderLayout.CENTER );

        add( aux, BorderLayout.CENTER );

        panelAcciones = new PanelAcciones( this );
        add( panelAcciones, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Abre el di�logo para agregar un nuevo procesado.
     */
    public void abrirDialogoAgregarProcesado( )
    {
        dialogoAgregarProcesado = new DialogoAgregarProcesado( this );
        dialogoAgregarProcesado.setVisible( true );
    }

    /**
     * Abre el di�logo para agregar un antecedente a un procesado.
     */
    public void abrirDialogoAgregarAntecedente( )
    {
        dialogoAgregarAntecedente = new DialogoAgregarAntecedente( this );
        dialogoAgregarAntecedente.setVisible( true );
    }

    /**
     * Abre el di�logo para buscar por antecedente.
     */
    public void abrirDialogoBuscarPorAntecedente( )
    {
        dialogoBuscarPorAntecedente = new DialogoBuscarPorAntecedente( this );
        dialogoBuscarPorAntecedente.setVisible( true );
    }

    /**
     * Agrega un nuevo procesado con un antecedente y lo muestra. <br>
     * <b> post: </b> Se agreg� el nuevo procesado con su antecedente al sistema. <br>
     * @param pNombre Nombre del procesado. pNombre != null && pNombre != "".
     * @param pApellido Apellido del procesado. pApellido != null && pApellido != "".
     * @param pIdentificacion N�mero de identificaci�n del procesado. pIdentificacion != null && pIdentificacion != "".
     * @param pSexo Sexo del procesado. pSexo != null && pSexo != "".
     * @param pEdad Edad del procesado.
     * @param pIdentificadorAntecedente Identificador del antecedente. pIdentificadorAntecedente >= 0.
     * @param pTipoAntecedente Tipo del antecedente. pTipoAntecedente != null && pTipoAntecedente != "".
     * @param pDescripcionAntecedente Descripci�n del antecedente. pDescripcionAntecedente != null && pDescripcionAntecedente != "".
     */
    public void agregarProcesadoYAntecedente( String pNombre, String pApellido, String pIdentificacion, String pSexo, int pEdad, int pIdentificadorAntecedente, String pTipoAntecedente, String pDescripcionAntecedente )
    {

        try
        {
            sistemaAntecedentes.agregarProcesadoYAntecedente( pNombre, pApellido, pIdentificacion, pSexo, pEdad, pIdentificadorAntecedente, pTipoAntecedente, pDescripcionAntecedente );
            dialogoAgregarProcesado.dispose( );
            posicionProcesadoActual = sistemaAntecedentes.buscarProcesado( pIdentificacion );
            Procesado procesadoActual = sistemaAntecedentes.darProcesado( posicionProcesadoActual );
            actualizar( procesadoActual );
        }
        catch( Exception e )
        {
            String mensajeError = e.getMessage( ).replace( " ", "" );
            if( mensajeError.equals( "Laedadm�nimadelprocesadoesde" + Procesado.EDAD_MINIMA + "a�os.Secambi�laedaddelprocesadoporlaedadm�nimapermitida." ) )
            {
                JOptionPane.showMessageDialog( dialogoAgregarProcesado, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
                dialogoAgregarProcesado.dispose( );
                posicionProcesadoActual = sistemaAntecedentes.buscarProcesado( pIdentificacion );
                Procesado procesadoActual = sistemaAntecedentes.darProcesado( posicionProcesadoActual );
                actualizar( procesadoActual );
            }
            else
            {
                JOptionPane.showMessageDialog( dialogoAgregarProcesado, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    /**
     * Agrega un antecedente al procesado actual.
     * @param pIdentificadorAntecedente Identificador del antecedente a agregar. pIdentificadorAntecedente >= 0.
     * @param pTipoAntecedente Tipo del antecedente a agregar. pTipoAntecedente != "" && pTipoAntecedente != null.
     * @param pDescripcionAntecedente Descripci�n del antecedente a agrear. pDescripcionAntecedente != "" && pDescripcionAntecedente != null.
     * @throws Exception Si el procesado no existe.
     * @throws Exception Si el procesado ya tiene registrado un antecedente con el tipo y descripci�n dada.
     */
    public void agregarAntecedente( int pIdentificadorAntecedente, String pTipoAntecedente, String pDescripcionAntecedente ) throws Exception
    {
        Procesado actual = sistemaAntecedentes.darProcesado( posicionProcesadoActual );
        sistemaAntecedentes.agregarAntecedenteAProcesado( actual.darIdentificacion( ), pIdentificadorAntecedente, pTipoAntecedente, pDescripcionAntecedente );
        actualizar( actual );
    }

    /**
     * Busca el procesado con el n�mero de identificaci�n dado en el sistema. <br>
     * Si el procesado se encuentra, se visualiza, si no, se genera el mensaje de error.
     */
    public void buscarProcesado( )
    {
        try
        {
            String identificacion = JOptionPane.showInputDialog( this, "N� identificaci�n" );
            if( identificacion != null )
            {
                if( !identificacion.equals( "" ) )
                {
                    int procesadoActualPos = sistemaAntecedentes.buscarProcesado( identificacion );

                    if( procesadoActualPos != -1 )
                    {
                        posicionProcesadoActual = procesadoActualPos;
                        actualizar( sistemaAntecedentes.darProcesado( posicionProcesadoActual ) );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "Ese procesado no est� registrado en el sistema.", "Informaci�n", JOptionPane.INFORMATION_MESSAGE );
                    }
                }
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Informaci�n", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Busca todos los procesados que tengan los antecedentes del tipo dado.
     * @param pTipoAntecedente El tipo del antecedente por el que se quiere hacer la b�squeda. pTipoAntecedente != null && pTipoAntecedente != "".
     * @throws Exception Si ning�n procesado tiene antecedentes del tipo dado.
     * @return La cadena de texto con los procesados que tienen el antecedente del tipo dado.
     */
    public String buscarPorAntecedente( String pTipoAntecedente ) throws Exception
    {
        ArrayList resultado = sistemaAntecedentes.buscarProcesadosPorAntecedente( pTipoAntecedente );
        String cadena = "";

        for( int i = 0; i < resultado.size( ); i++ )
        {
            Procesado actual = ( Procesado )resultado.get( i );
            cadena += actual.darNombre( ) + " " + actual.darApellido( ) + " - " + actual.darIdentificacion( ) + "\n";
        }

        return cadena;
    }

    /**
     * Busca el procesado con m�s antecedentes.
     */
    public void buscarProcesadoMasAntecedentes( )
    {
        try
        {
            posicionProcesadoActual = sistemaAntecedentes.buscarProcesadoConMasAntecedentes( );
            actualizar( sistemaAntecedentes.darProcesado( posicionProcesadoActual ) );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Informaci�n", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el procesado con menos antecedentes.
     */
    public void buscarProcesadoMenosAntecedentes( )
    {
        try
        {
            posicionProcesadoActual = sistemaAntecedentes.buscarProcesadoConMenosAntecedentes( );
            actualizar( sistemaAntecedentes.darProcesado( posicionProcesadoActual ) );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Informaci�n", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el procesado mayor de edad con mayor cantidad de a�os de condena por sus antecedentes.
     */
    public void buscarProcesadoConMasAnhosCondena( )
    {
        try
        {
            posicionProcesadoActual = sistemaAntecedentes.buscarProcesadoConMasAnhosCondena( );
            Procesado procesadoActual = sistemaAntecedentes.darProcesado( posicionProcesadoActual );
            actualizar( procesadoActual );
        }
        catch( Exception pExcepcion )
        {
            JOptionPane.showMessageDialog( this, pExcepcion.getMessage( ), "Procesado con m�s a�os de condena", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el procesado mayor de edad con la menor cantidad de a�os de condena por sus antecedentes.
     */
    public void buscarProcesadoConMenosAnhosCondena( )
    {
        try
        {
            posicionProcesadoActual = sistemaAntecedentes.buscarProcesadoConMenosAnhosCondena( );
            Procesado procesadoActual = sistemaAntecedentes.darProcesado( posicionProcesadoActual );
            actualizar( procesadoActual );
        }
        catch( Exception pExcepcion )
        {
            JOptionPane.showMessageDialog( this, pExcepcion.getMessage( ), "Procesado con menos a�os de condena", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Actualiza el procesado actual con su anterior.<br>
     */
    public void cambiarProcesadoAnterior( )
    {
        if( sistemaAntecedentes.darProcesados( ).isEmpty( ) )
        {
            JOptionPane.showMessageDialog( this, "No hay procesados en el sistema.", "Informaci�n", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            posicionProcesadoActual--;
            if( posicionProcesadoActual < 0 )
            {
                JOptionPane.showMessageDialog( this, "Se encuentra en el primer procesado.", "Informaci�n", JOptionPane.INFORMATION_MESSAGE );
                posicionProcesadoActual++;
            }
            actualizar( sistemaAntecedentes.darProcesado( posicionProcesadoActual ) );
        }
    }

    /**
     * Actualiza el procesado actual con su siguiente.
     */
    public void cambiarProcesadoSiguiente( )
    {
        if( sistemaAntecedentes.darProcesados( ).isEmpty( ) )
        {
            JOptionPane.showMessageDialog( this, "No hay procesados en el sistema.", "Informaci�n", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            posicionProcesadoActual++;
            if( posicionProcesadoActual >= sistemaAntecedentes.darProcesados( ).size( ) )
            {
                JOptionPane.showMessageDialog( this, "Se encuentra en el �ltimo procesado.", "Informaci�n", JOptionPane.INFORMATION_MESSAGE );
                posicionProcesadoActual--;
            }
            actualizar( sistemaAntecedentes.darProcesado( posicionProcesadoActual ) );
        }
    }

    /**
     * Condena al procesado actual por el antecedente con tipo e identificador dados.
     * @param pAnhosCondena A�os de condena por el antecedente dado. pAnhosCondena >= 0.
     * @param pIdentificador Identificador del antecedente por el que se va a condenar. pIdentificador >= 0.
     * @throws Exception Si el procesado es menor de edad y se trata de condenar.
     * @throws Exception Si el antecedente es LEVE y la condena es menor o igual a SIN_CONDENA o mayor a CONDENA_LEVE.
     * @throws Exception Si el antecedente es GRAVE y la condena es menor o igual a CONDENA_LEVE o mayor a CONDENA_GRAVE.
     * @throws Exception Si el antecedente es MUY_GRAVE y la condena es menor a CONDENA_MUY_GRAVE.
     */
    public void condenarProcesado( int pAnhosCondena, int pIdentificador ) throws Exception
    {
        Procesado actual = sistemaAntecedentes.darProcesado( posicionProcesadoActual );
        actual.condenarProcesado( pAnhosCondena, pIdentificador );
        actualizar( actual );
    }

    /**
     * Elimina un procesado del sistema.
     */
    public void eliminarProcesado( )
    {
        try
        {
            String cedula = JOptionPane.showInputDialog( this, "C�dula:" );
            if( cedula != null )
            {
                if( !cedula.equals( "" ) )
                {
                    sistemaAntecedentes.eliminarProcesado( cedula );
                    posicionProcesadoActual = 0;

                    if( !sistemaAntecedentes.darProcesados( ).isEmpty( ) )
                    {
                        actualizar( sistemaAntecedentes.darProcesado( posicionProcesadoActual ) );
                    }
                    else
                    {
                        actualizar( null );
                    }
                }
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Informaci�n", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Elimina un antecedente a un procesado.
     * @param pIdentificadorAntecedente tipo del antecedente. pIdentificadorAntecedente >= 0.
     */
    public void eliminarAntecedente( int pIdentificadorAntecedente )
    {
        try
        {
            int numProcesados = sistemaAntecedentes.darProcesados( ).size( );
            Procesado procesado = sistemaAntecedentes.darProcesado( posicionProcesadoActual );
            sistemaAntecedentes.eliminarAntecedenteProcesado( procesado.darIdentificacion( ), pIdentificadorAntecedente );

            if( sistemaAntecedentes.darProcesados( ).size( ) < numProcesados )
            {
                posicionProcesadoActual = 0;

                if( !sistemaAntecedentes.darProcesados( ).isEmpty( ) )
                {
                    actualizar( sistemaAntecedentes.darProcesado( posicionProcesadoActual ) );
                }
                else
                {
                    actualizar( null );
                }
            }
            else
            {
                actualizar( sistemaAntecedentes.darProcesado( posicionProcesadoActual ) );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Eliminar antecedente", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Actualiza la informaci�n del procesado y sus antecedentes. Si el procesado es nulo se deja la informaci�n y los antecedentes vac�os.
     * @param pProcesado el procesado. pProcesado != null.
     */
    private void actualizar( Procesado pProcesado )
    {
        if( pProcesado != null )
        {
            panelContenedor.actualizar( pProcesado.darNombre( ), pProcesado.darApellido( ), pProcesado.darIdentificacion( ), pProcesado.darSexo( ), pProcesado.darEdad( ), pProcesado.darAntecedentes( ), pProcesado.darAnhosCondena( ) );
        }
        else
        {
            panelContenedor.actualizar( "", "", "", "", 0, null, 0 );
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = sistemaAntecedentes.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = sistemaAntecedentes.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz.
     * @param pArgs Argumentos del programa. pArgs != null.
     */
    public static void main( String[] pArgs )
    {
        // Unifica la interfaz para Mac y para Windows.
        try
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }

        InterfazSistemaAntecedentes interfaz = new InterfazSistemaAntecedentes( );
        interfaz.setVisible( true );
    }
}
