/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_parqueDiversiones
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.parqueDiversiones.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.parqueDiversiones.mundo.Atraccion;
import uniandes.cupi2.parqueDiversiones.mundo.ParqueDiversiones;

/**
 * Ventana principal de la aplicaci�n.
 */
public class InterfazParqueDiversiones extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private ParqueDiversiones parqueDiversiones;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las extensiones.
     */
    private PanelExtension panelExtension;

    /**
     * Panel con la lista de pasaportes.
     */
    private PanelPasaportes panelPasaportes;

    /**
     * Panel con la imagen de la aplicaci�n.
     */
    private PanelImagen panelImagen;

    /**
     * Panel para el manejo de las atracciones.
     */
    private PanelManejoAtracciones panelManejoAtracciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la aplicaci�n principal.
     */
    public InterfazParqueDiversiones( )
    {
        parqueDiversiones = new ParqueDiversiones( );

        setLayout( new BorderLayout( ) );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        setTitle( "Parque de diversiones" );

        panelImagen = new PanelImagen( );
        panelExtension = new PanelExtension( this );
        panelPasaportes = new PanelPasaportes( this );
        panelManejoAtracciones = new PanelManejoAtracciones( this );

        add( panelImagen, BorderLayout.NORTH );
        add( panelPasaportes, BorderLayout.CENTER );
        add( panelManejoAtracciones, BorderLayout.EAST );
        add( panelExtension, BorderLayout.SOUTH );
        setPreferredSize( new Dimension( 900, 600 ) );
        setResizable( false );
        pack( );
        try
        {
            cargarAtracciones( "data/atracciones.properties" );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }

        setLocationRelativeTo( null );
        panelManejoAtracciones.refrescarLista( darAtraccionesParque( ) );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna la lista de atracciones del parque de diversiones.
     * @return Lista de atracciones del parque de diversiones.
     */
    public ArrayList darAtraccionesParque( )
    {
        return parqueDiversiones.darAtracciones( );
    }

    /**
     * Retorna las atracciones incluidas en un pasaporte dada la c�dula del cliente.
     * @param pCedula C�dula del due�o del pasaporte. pCedula > 0.
     * @return Lista de atracciones del pasaporte con la c�dula dada.
     */
    public ArrayList darAtraccionesIncluidasPasaporte( int pCedula )
    {
        return parqueDiversiones.buscarPasaporte( pCedula ).darAtraccionesIncluidas( );
    }

    /**
     * Muestra el dinero en caja.
     */
    public void mostrarDineroCaja( )
    {
        JOptionPane.showMessageDialog( this, "El parque tiene " + parqueDiversiones.darDineroCaja( ) + " en caja.", "Dinero en caja", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Muestra todos los pasaportes del parque en PanelPasaportes.
     */
    public void mostrarTodosLosPasaportes( )
    {
        panelPasaportes.modificarTitulo( "Todos los pasaportes" );
        panelPasaportes.repaint( );
        panelPasaportes.actualizarPasaportes( parqueDiversiones.darPasaportes( ) );
    }

    /**
     * Muestra todos los pasaportes en elaboraci�n del parque en PanelPasaportes.
     */
    public void mostrarPasaportesEnElaboracion( )
    {
        panelPasaportes.modificarTitulo( "Pasaportes en elaboraci�n" );
        panelPasaportes.repaint( );
        panelPasaportes.actualizarPasaportes( parqueDiversiones.darPasaportesEnElaboracion( ) );
    }

    /**
     * Muestra todos los pasaportes vendidos del parque en PanelPasaportes.
     */
    public void mostrarPasaportesVendidos( )
    {
        panelPasaportes.modificarTitulo( "Pasaportes vendidos" );
        panelPasaportes.repaint( );
        panelPasaportes.actualizarPasaportes( parqueDiversiones.darPasaportesVendidos( ) );
    }

    /**
     * Muestra un di�logo que permite agregar una atracci�n al parque
     */
    public void mostrarDialogoAgregarAtraccion( )
    {
        DialogoAgregarAtraccion dialogo = new DialogoAgregarAtraccion( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el di�logo que permite agregar un pasaporte.
     */
    public void mostrarDialogoAgregarPasaporte( )
    {
        DialogoAgregarPasaporte dialogo = new DialogoAgregarPasaporte( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el di�logo para agregar o eliminar atracciones a un pasaporte.
     * @param pCedula C�dula del cliente del parque due�o del pasaporte. pCedula > 0.
     */
    public void mostrarDialogoAtraccionesPasaporte( int pCedula )
    {
        DialogoAtraccionesPasaporte dialogo = new DialogoAtraccionesPasaporte( this, pCedula );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Carga de un archivo de propiedades las atracciones del parque. <br>
     * <b>pre:</b> La lista de atracciones est� inicializada. <br>
     * @param pArchivo Ruta y nombre del archivo que se quiere cargar. pArchivo != null && pArchivo != "".
     * @throws Exception Si hay errores en el formato del archivo.
     */
    private void cargarAtracciones( String pArchivo ) throws Exception
    {
        try
        {
            Properties datos = new Properties( );
            FileInputStream input = new FileInputStream( pArchivo );
            datos.load( input );

            // Obtiene el n�mero de atracciones
            int nAtracciones = Integer.parseInt( datos.getProperty( "total.atracciones" ) );

            for( int i = 1; i <= nAtracciones; i++ )
            {
                String nombre = datos.getProperty( "atraccion" + i + ".nombre" );
                String precioStr = datos.getProperty( "atraccion" + i + ".precio" );
                String tipo = datos.getProperty( "atraccion" + i + ".tipo" );

                if( nombre == null )
                {
                    throw new Exception( "Falta definir la propiedad " + "atraccion" + i + ".nombre" );
                }
                if( precioStr == null )
                {
                    throw new Exception( "Falta definir la propiedad " + "atraccion" + i + ".precio" );
                }
                if( tipo == null )
                {
                    throw new Exception( "Falta definir la propiedad " + "atraccion" + i + ".tipo" );
                }

                if( nombre.equals( "" ) )
                {
                    throw new Exception( "El nombre no puede estar vac�o." );
                }
                if( precioStr.equals( "" ) )
                {
                    throw new Exception( "El precio no puede estar vac�o." );
                }
                if( tipo.equals( "" ) )
                {
                    throw new Exception( "El tipo no puede estar vac�o." );
                }
                try
                {
                    double precio = Double.parseDouble( precioStr );
                    if( precio <= 0 )
                    {
                        throw new Exception( "El precio debe estar positivo." );
                    }
                    parqueDiversiones.agregarAtraccion( nombre, precio, tipo );
                }
                catch( NumberFormatException ex )
                {
                    throw new Exception( "El precio debe ser un n�mero" );
                }

            }
        }
        catch( Exception e )
        {
            throw new Exception( "Error al cargar los datos almacenados de las atracciones" );
        }
    }

    /**
     * Agrega un pasaporte nuevo a la lista. <br>
     * <b>pre:</b> La lista de pasaportes est� inicializada. <br>
     * <b>post:</b> La lista tiene un pasaporte nuevo.
     * @param pNombre Nombre del due�o del pasaporte. pNombre != null && pNombre != "".
     * @param pCedula C�dula del due�o del pasaporte. pCedula > 0.
     * @param pCategoria Categor�a a la que pertenece el pasaporte. pCategoria != null && pCategoria != "" && (pCategoria == ORO || pCategoria == PLATA || pCategoria ==
     *        BRONCE).
     */
    public void agregarPasaporte( String pNombre, int pCedula, String pCategoria )
    {
        try
        {
            parqueDiversiones.agregarPasaporte( pNombre, pCedula, pCategoria );
            mostrarTodosLosPasaportes( );
            mostrarDialogoAtraccionesPasaporte( pCedula );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Agregar pasaporte", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Agrega una atracci�n al parque con los valores dados por par�metro.
     * @param pNombre Nombre de la atracci�n. pNombre != null && pNombre != "".
     * @param pPrecio Precio de la atracci�n. Puede ser negativo.
     * @param pTipo Tipo de la atracci�n. pTipo != null && pTipo != "" && (pTipo == INFANTIL || pTipo == TERROR || pTipo == ACUATICA || pTipo == VELOCIDAD).
     */
    public void agregarAtraccion( String pNombre, double pPrecio, String pTipo )
    {
        try
        {
            parqueDiversiones.agregarAtraccion( pNombre, pPrecio, pTipo );
            panelManejoAtracciones.refrescarLista( darAtraccionesParque( ) );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Agregar atracci�n", JOptionPane.ERROR_MESSAGE );
            panelManejoAtracciones.refrescarLista( darAtraccionesParque( ) );
        }
    }

    /**
     * Agrega una atracci�n al pasaporte dado.
     * @param pNombreAtraccion Nombre de la atracci�n. pNombreAtraccion != null && pNombreAtraccion != null.
     * @param pCedula C�dula del due�o del pasaporte. pCedula > 0.
     */
    public void agregarAtraccionAPasaporte( String pNombreAtraccion, int pCedula )
    {
        try
        {
            parqueDiversiones.agregarAtraccionAPasaporte( pNombreAtraccion, pCedula );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Agregar atracci�n pasaporte", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra el di�logo para modificar atracciones del pasaporte seleccionado.
     */
    public void modificarAtraccionesPasaporte( )
    {
        int seleccionado = panelPasaportes.darIndicePasaporteSeleccionado( );
        if( seleccionado != -1 )
        {
            mostrarDialogoAtraccionesPasaporte( seleccionado );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un pasaporte de la lista.", "Modificar atracciones pasaporte", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Elimina un pasaporte del parque.<br>
     * <b>pre:</b> La lista de pasaportes est� inicializada. <br>
     * <b>post:</b> La lista tiene un pasaporte menos.
     */
    public void eliminarPasaporte( )
    {
        String cedulaStr = ( String )JOptionPane.showInputDialog( this, "Ingrese la c�dula del due�o del pasaporte:", "Eliminar pasaporte", JOptionPane.INFORMATION_MESSAGE );

        if( cedulaStr != null )
        {
            try
            {
                int cedula = Integer.parseInt( cedulaStr );
                if(cedula <= 0)
                {
                    JOptionPane.showMessageDialog( this, "La c�dula deber�a ser un n�mero positivo.", "Eliminar pasaporte", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    parqueDiversiones.eliminarPasaporte( cedula );
                    JOptionPane.showMessageDialog( this, "Se elimin� el pasaporte correctamente.", "Eliminar pasaporte", JOptionPane.INFORMATION_MESSAGE );
                    mostrarTodosLosPasaportes( );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "La c�dula deber�a ser un n�mero.", "Eliminar pasaporte", JOptionPane.ERROR_MESSAGE );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Eliminar pasaporte", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Elimina una atracci�n del parque.
     */
    public void eliminarAtraccion( )
    {

        String nombreAtraccion = ( String )JOptionPane.showInputDialog( this, "Ingrese el nombre de la atracci�n:", "Eliminar atracci�n", JOptionPane.INFORMATION_MESSAGE );

        if( nombreAtraccion != null )
        {
            try
            {
                parqueDiversiones.eliminarAtraccion( nombreAtraccion );
                JOptionPane.showMessageDialog( this, "Se elimin� la atracci�n correctamente.", "Eliminar atracci�n", JOptionPane.INFORMATION_MESSAGE );
                panelManejoAtracciones.refrescarLista( darAtraccionesParque( ) );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Eliminar atracci�n", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    /**
     * Elimina la atracci�n al pasaporte.
     * @param pNombreAtraccion Nombre de la atracci�n. pNombreAtraccion != null && pNombreAtraccion != null.
     * @param pCedula C�dula del due�o del pasaporte. pCedula > 0.
     */
    public void eliminarAtraccionDePasaporte( String pNombreAtraccion, int pCedula )
    {
        try
        {
            parqueDiversiones.eliminarAtraccionDePasaporte( pNombreAtraccion, pCedula );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Elimina atracci�n pasaporte", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Vende el pasaporte seleccionado.
     */
    public void venderPasaporte( )
    {
        int seleccionado = panelPasaportes.darIndicePasaporteSeleccionado( );
        if( seleccionado != -1 )
        {
            try
            {
                double precioVendido = parqueDiversiones.venderPasaporte( seleccionado );
                JOptionPane.showMessageDialog( this, "El pasaporte fue vendido por " + precioVendido + ".", "Vender pasaporte", JOptionPane.INFORMATION_MESSAGE );
                mostrarTodosLosPasaportes( );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Vender pasaporte", JOptionPane.ERROR_MESSAGE );
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un pasaporte de la lista.", "Vender pasaporte", JOptionPane.ERROR_MESSAGE );
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
        String resultado = parqueDiversiones.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = parqueDiversiones.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz.
     * @param args No son necesarios.
     */
    public static void main( String[] args )
    {
        InterfazParqueDiversiones interfaz = new InterfazParqueDiversiones( );
        interfaz.setVisible( true );
    }

}