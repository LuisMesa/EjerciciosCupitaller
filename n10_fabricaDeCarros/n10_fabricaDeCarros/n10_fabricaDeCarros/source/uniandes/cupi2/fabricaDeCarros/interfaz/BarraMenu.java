/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: fabricaDeCarros
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.fabricaDeCarros.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Barra que contiene los men�s de la aplicaci�n.
 */
public class BarraMenu extends JMenuBar implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante que representa Abrir.
     */
    private static final String ABRIR = "Abrir";
    /**
     * Constante que representa Guardar.
     */
    //TODO Parte10 PuntoA. Agregue la constante de Guardar.
    /**
     * Constante que representa GuardarComo.
     */
    //TODO Parte10 PuntoB. Agregue la constante de GuardarComo.
    /**
     * Constante que representa Nuevo.
     */
    //TODO Parte10 PuntoC. Agregue la constante de Nuevo.
    /**
     * Constante que representa Salir.
     */
    //TODO Parte10 PuntoD. Agregue la constante de Salir.

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazFabricaDeCarros principal;
    
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Men� Archivo.
     */
    private JMenu menuArchivo;

    /**
     * Opci�n Nuevo del men� Archivo.
     */
    //TODO Parte10 PuntoD. Agregue el atributo para el item Nuevo.

    /**
     * Opci�n Abrir del men� Archivo.
     */
    private JMenuItem itemAbrir;

    /**
     * Opci�n Guardar del men� Archivo.
     */
    //TODO Parte10 PuntoE. Agregue el atributo para el item Guardar.

    /**
     * Opci�n Guardar Como del men� Archivo.
     */
    //TODO Parte10 PuntoF. Agregue el atributo para el item GuardarComo.

    /**
     * Opci�n Salir del men� Archivo.
     */
    //TODO Parte10 PuntoG. Agregue el atributo para el item Salir.

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la barra de men�.<br>
     * <b> post: </b> Se inicializ� la barra de men� con la interfaz de fabrica de carros dada por pat�metro.
     * @param pInterfazPrincipal Es una referencia a la clase principal de la interfaz. pInterfazPrincipal !=null.
     */
    public BarraMenu( InterfazFabricaDeCarros pInterfazPrincipal )
    {
        principal = pInterfazPrincipal;

        menuArchivo = new JMenu( "Archivo" );
        menuArchivo.setMnemonic( KeyEvent.VK_A );
        add( menuArchivo );

        //TODO Parte10 PuntoH. Inicialice todos los nuevos items y agreguelos a la barra.
        //Verifique que la interfaz luzca como en el documento de descripci�n.

        itemAbrir = new JMenuItem( "Abrir" );
        itemAbrir.setActionCommand( ABRIR );
        itemAbrir.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_A, ActionEvent.CTRL_MASK ) );
        itemAbrir.setMnemonic( KeyEvent.VK_A );
        itemAbrir.addActionListener( this );
        menuArchivo.add( itemAbrir );


        menuArchivo.addSeparator( );


    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta la acci�n que corresponde a la opci�n del men� que fue seleccionada.
     * @param pEvento Es el evento de seleccionar una opci�n del men�. pEvento !=null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( ABRIR.equals( comando ) )
        {
            principal.abrir( );
        }
        //TODO Parte10 PuntoI. Agregue las modificaciones para hacer funcionar los items que cre�.
    }

}
