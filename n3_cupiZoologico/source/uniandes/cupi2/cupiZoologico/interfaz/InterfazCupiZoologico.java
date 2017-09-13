/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_cupiZoologico
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiZoologico.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.cupiZoologico.mundo.Animal;
import uniandes.cupi2.cupiZoologico.mundo.Jaula;
import uniandes.cupi2.cupiZoologico.mundo.Zoologico;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazCupiZoologico extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Zoologico zoologico;

    /**
     * Número de la jaula actual.
     */
    private int numeroJaulaActual;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen del encabezado.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con las extensiones.
     */
    private PanelExtension panelExtension;

    /**
     * Panel con la información del zoológico.
     */
    private PanelInformacion panelInformacion;

    /**
     * Panel con la información de la jaula seleccionada.
     */
    private PanelInfoJaula panelInfoJaula;

    /**
     * Panel con la información del animal seleccionado.
     */
    private PanelInfoAnimal panelInfoAnimal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Método constructor de la ventana. <br>
     * <b>post: </b> Se inicializaron los paneles con la información del sistema.
     */
    public InterfazCupiZoologico( )
    {
        // Crea la clase principal
        zoologico = new Zoologico( );

        // Construye la forma
        setLayout( new BorderLayout( ) );
        setSize( 805, 765 );
        setTitle( "CupiZoológico" );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable( false );

        // Creación de los paneles
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );

        JPanel auxPanelInformacion = new JPanel( );
        auxPanelInformacion.setLayout( new BorderLayout( ) );

        JPanel auxPanelInformacion1 = new JPanel( );
        auxPanelInformacion1.setLayout( new GridLayout( 1, 2 ) );

        panelInformacion = new PanelInformacion( );
        panelInformacion.actualizar( zoologico.CANT_JAULAS, zoologico.darCantidadJaulasNorte( ), zoologico.darCantidadJaulasSur( ), zoologico.calcularPorcentajeOcupacionJaulas( ), zoologico.darCantidadAnimales( ) );

        panelInfoJaula = new PanelInfoJaula( this );
        auxPanelInformacion1.add( panelInfoJaula );

        panelInfoAnimal = new PanelInfoAnimal( );
        auxPanelInformacion1.add( panelInfoAnimal );

        auxPanelInformacion.add( auxPanelInformacion1 );
        auxPanelInformacion.add( panelInformacion, BorderLayout.SOUTH );

        add( auxPanelInformacion, BorderLayout.CENTER );
        pack( );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Agrega el animal con las características dadas por parámetro.
     * @param pNombre Nombre del animal a agregar. pNombre != null && pNombre != "".
     * @param pEspecie Especie del animal a agregar. pEspecie != null && pEspecie != "".
     * @param pTipo Tipo del animal a agregar. pTipo != null && pTipo != "" && (pTipo == HERBIVORO || pTipo == CARNIVORO).
     * @param pHabitat Hábitat del animal a agregar. pHabitat != null && pHabitat != "" && (pHabitat == ACUATICO || pHabitat == TERRESTRE).
     * @param pImagen Imagen del animal a agregar. pImagen != null && pImagen != "".
     */
    public void agregarAnimal( String pNombre, String pEspecie, String pTipo, String pHabitat, String pImagen )
    {
        int jaula = zoologico.agregarAnimal( pNombre, pEspecie, pTipo, pHabitat, pImagen );
        if( jaula != -1 )
        {
            JOptionPane.showMessageDialog( this, "El animal fue agregado a la jaula " + ( jaula + 1 ) + ".", "Agregar animal", JOptionPane.INFORMATION_MESSAGE );
            panelInformacion.actualizar( zoologico.CANT_JAULAS, zoologico.darCantidadJaulasNorte( ), zoologico.darCantidadJaulasSur( ), zoologico.calcularPorcentajeOcupacionJaulas( ), zoologico.darCantidadAnimales( ) );
            panelInfoJaula.actualizar( );

        }
        else
        {
            JOptionPane.showMessageDialog( this, "No se pudo agregar al animal.", "Agregar animal", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Asigna un guardia a la jaula actual.
     * @param pNombreGuardia Nombre del guardia. pNombreGuardia != "" && pNombreGuardia != null.
     * @param pAnhosExperiencia Años de experiencia como guardia.
     */
    public void asignarGuardia( String pNombreGuardia, int pAnhosExperiencia )
    {
        darJaulaActual( ).asignarGuardia(  pNombreGuardia, pAnhosExperiencia );
        panelInfoJaula.actualizar( );        
    }

    /**
     * Elimina el animal ingresado por el usuario.
     */
    public void eliminarAnimal( )
    {
        String nombre = JOptionPane.showInputDialog( this, "Ingrese el nombre del animal ", "Eliminar animal", JOptionPane.PLAIN_MESSAGE );
        if( nombre != null )
        {
            if( !nombre.isEmpty( ) )
            {
                if( zoologico.eliminarAnimal( nombre ) )
                {
                    JOptionPane.showMessageDialog( this, "El animal con nombre " + nombre + " fue eliminado.", "Eliminar animal", JOptionPane.INFORMATION_MESSAGE );
                    eliminarDatosAnimal( );
                    panelInfoJaula.actualizar( );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "No se encontró el animal con nombre " + nombre + ".", "Eliminar animal", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Por favor ingrese el nombre del animal.", "Eliminar animal", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Busca el animal que tiene el nombre ingresado por el usuario y muestra la jaula donde se encuentra.
     */
    public void buscarAnimal( )
    {
        String nombreAnimal = JOptionPane.showInputDialog( this, "Ingrese el nombre del animal ", "Buscar animal", JOptionPane.PLAIN_MESSAGE );
        if( nombreAnimal != null )
        {
            if( !nombreAnimal.isEmpty( ) )
            {
                int numJaula = zoologico.buscarJaulaAnimalPorNombre( nombreAnimal );
                if( numJaula == -1 )
                {
                    JOptionPane.showMessageDialog( this, "No se encontró un animal con nombre " + nombreAnimal + ".", "Buscar animal", JOptionPane.INFORMATION_MESSAGE );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "El animal con nombre " + nombreAnimal + " se encuentra en la jaula " + ( numJaula + 1 ) + ".", "Buscar animal", JOptionPane.INFORMATION_MESSAGE );

                    numeroJaulaActual = numJaula;
                    panelInfoJaula.reiniciarSeleccionLista( );
                    panelInfoJaula.actualizar( );
                }
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Por favor ingrese el nombre del animal.", "Buscar animal", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Muestra la jaula ingresada por el usuario si ésta existe.
     */
    public void buscarJaula( )
    {
        String numJaula = JOptionPane.showInputDialog( this, "Ingrese el número de la jaula.", "Buscar jaula", JOptionPane.PLAIN_MESSAGE );
        if( numJaula != null )
        {
            try
            {
                int intNumJaula = Integer.parseInt( numJaula ) - 1;
                if( intNumJaula >= Zoologico.CANT_JAULAS )
                {
                    JOptionPane.showMessageDialog( this, "La jaula buscada no existe.", "Buscar jaula", JOptionPane.INFORMATION_MESSAGE );
                }
                else if(intNumJaula + 1 <= 0)
                {
                    JOptionPane.showMessageDialog( this, "El número debe ser mayor a cero.", "Buscar jaula", JOptionPane.INFORMATION_MESSAGE );
                }
                else
                {
                    eliminarDatosAnimal( );
                    numeroJaulaActual = intNumJaula;
                    panelInfoJaula.reiniciarSeleccionLista( );
                    panelInfoJaula.actualizar( );
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog( this, "Debe digitar un valor numérico.", "Buscar jaula", JOptionPane.ERROR_MESSAGE );
            }
        }
    }
    /**
     * Retorna la jaula actual.
     * @return Jaula actual.
     */
    public Jaula darJaulaActual( )
    {
        return zoologico.darJaula( numeroJaulaActual );
    }

    /**
     * Retorna el número de la jaula actual.
     * @return Número de la jaula actual.
     */
    public int darNumeroJaulaActual( )
    {
        return numeroJaulaActual;
    }

    /**
     * Cambia el número de la jaula actual, asignándole el número siguiente.
     */
    public void siguenteJaula( )
    {
        numeroJaulaActual++;
        eliminarDatosAnimal( );
        if( numeroJaulaActual == Zoologico.CANT_JAULAS )
        {
            numeroJaulaActual = 0;
        }
        panelInfoJaula.reiniciarSeleccionLista( );
    }

    /**
     * Cambia el número de la jaula actual, asignándole el número anterior.
     */
    public void anteriorJaula( )
    {
        numeroJaulaActual--;
        eliminarDatosAnimal( );
        if( numeroJaulaActual < 0 )
        {
            numeroJaulaActual = Zoologico.CANT_JAULAS - 1;
        }
    }

    /**
     * Muestra la jaula que tiene la mayor cantidad de animales.
     */
    public void buscarJaulaMayorCantidad( )
    {
        int mayorCantidad = zoologico.buscarJaulaMayorCantidadAnimales( );
        if( mayorCantidad >= 0 )
        {
            JOptionPane.showMessageDialog( this, "La jaula con mayor cantidad de animales es la jaula " + ( mayorCantidad + 1 ) + ".", "Buscar jaula con mayor cantidad", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Todas las jaulas están desocupadas.", "Buscar jaula con mayor cantidad", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Indica si existen dos o más jaulas con la misma cantidad de animales.
     */
    public void exitenJaulasConMismaCantidadAnimales( )
    {
        boolean existen = zoologico.existenJaulasConMismaCantidadAnimales( );
        if( existen )
        {
            JOptionPane.showMessageDialog( this, "Sí existen dos o más jaulas con la misma cantidad de animales.", "Misma cantidad", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existen dos o más jaulas con la misma cantidad de animales.", "Misma cantidad", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Muestra los datos del animal dado en el panelInfoAnimal.
     * @param pAnimal Animal que se desea visualizar. pAnimal != null.
     */
    public void verDatosAnimal( Animal pAnimal )
    {
        panelInfoAnimal.mostrarDatos( pAnimal );
    }

    /**
     * Borra los datos del animal en el panelInfoAnimal.
     */
    public void eliminarDatosAnimal( )
    {
        panelInfoAnimal.borrarDatos( );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = zoologico.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = zoologico.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * @param pArgs Argumentos para la ejecución de la aplicación. En este caso no son necesarios.
     */
    public static void main( String[] pArgs )
    {
    	// Unifica la interfaz para Mac y para Windows.
    	try 
    	{
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}
    	
        InterfazCupiZoologico interfaz = new InterfazCupiZoologico( );
        interfaz.setVisible( true );
    }

}
