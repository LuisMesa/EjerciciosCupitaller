/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.cupiCava.mundo.CupiCava;
import uniandes.cupi2.cupiCava.mundo.Vino;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazCupiCava extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa la ubicación del archivo con los datos de los vinos de la cava.
     */
    private final static String RUTA_ARCHIVO = "./data/cava.properties";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private CupiCava cupiCava;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las extensiones.
     */
    private PanelExtension panelExtension;

    /**
     * Panel con la imagen del encabezado.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con la lista de vinos de la cava.
     */
    private PanelListaVinos panelListaVinos;

    /**
     * Panel con la información detallada de un vino.
     */
    private PanelInformacionVino panelInformacionVino;

    /**
     * Panel con las opciones de ordenamiento y búsqueda.
     */
    private PanelOpciones panelOpciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la ventana principal.<br>
     * <b> post: </b> Construye la ventana principal de la aplicación.
     */
    public InterfazCupiCava( )
    {
        cupiCava = new CupiCava( );
        cargarVinos( );

        setLayout( new BorderLayout( ) );
        setSize( 700, 550 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "CupiCava" );
        setLocationRelativeTo( null );
        setResizable( false );

        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelListaVinos = new PanelListaVinos( this );
        add( panelListaVinos, BorderLayout.WEST );

        panelInformacionVino = new PanelInformacionVino( );
        add( panelInformacionVino, BorderLayout.CENTER );

        JPanel aux = new JPanel( );
        aux.setLayout( new GridLayout( 2, 1 ) );

        panelOpciones = new PanelOpciones( this );
        aux.add( panelOpciones );

        panelExtension = new PanelExtension( this );
        aux.add( panelExtension );

        add( aux, BorderLayout.SOUTH );

        actualizarLista( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Carga los vinos iniciales de la cava a partir de un archivo de propiedades.
     */
    private void cargarVinos( )
    {
        try
        {
            FileInputStream fis = new FileInputStream( new File( RUTA_ARCHIVO ) );
            Properties propiedades = new Properties( );
            propiedades.load( fis );

            String aux = propiedades.getProperty( "total.vinos" );
            int numVinos = Integer.parseInt( aux );

            String dato;
            String nombre;
            String presentacion;
            int anho;
            double contenidoAzucar;
            String tipo;
            String lugar;
            String color;
            String imagen;

            for( int i = 1; i < numVinos + 1; i++ )
            {
                // Carga un vino
                dato = "vino" + i + ".nombre";
                nombre = propiedades.getProperty( dato );

                dato = "vino" + i + ".presentacion";
                presentacion = propiedades.getProperty( dato );

                dato = "vino" + i + ".fecha";
                anho = Integer.parseInt( propiedades.getProperty( dato ) );

                dato = "vino" + i + ".azucar";
                contenidoAzucar = Double.parseDouble( propiedades.getProperty( dato ) );

                dato = "vino" + i + ".tipo";
                tipo = propiedades.getProperty( dato );

                dato = "vino" + i + ".lugar";
                lugar = propiedades.getProperty( dato );

                dato = "vino" + i + ".color";
                color = propiedades.getProperty( dato );

                dato = "vino" + i + ".imagen";
                imagen = propiedades.getProperty( dato );

                if( nombre != null && !nombre.isEmpty( ) && presentacion != null && !presentacion.isEmpty( ) && anho > 0 && tipo != null && !tipo.isEmpty( ) && contenidoAzucar >= 0 && lugar != null && !lugar.isEmpty( ) && color != null
                        && !color.isEmpty( ) && imagen != null && !imagen.isEmpty( ) )
                {
                    cupiCava.agregarVino( nombre, presentacion, anho, contenidoAzucar, tipo, color, lugar, imagen );
                }

            }
            fis.close( );
        }
        catch( FileNotFoundException e )
        {
            e.printStackTrace( );
        }
        catch( IOException e )
        {
            e.printStackTrace( );
        }
    }

    /**
     * Actualiza la lista de vinos mostrada.
     */
    private void actualizarLista( )
    {
        ArrayList vinos = new ArrayList( );
        for( int i = 0; i < cupiCava.darVinos( ).size( ); i++ )
        {
            Vino actual = ( Vino )cupiCava.darVinos( ).get( i );
            vinos.add( actual.darNombre( ) );
        }

        panelListaVinos.refrescarLista( vinos );
    }

    /**
     * Actualiza la información del vino seleccionado.
     * @param pNombreVino Nombre del vino seleccionado. pNombreVino != null && pNombreVino != "".
     */
    public void actualizarInfoVino( String pNombreVino )
    {
        Vino seleccionado = cupiCava.buscarVino( pNombreVino );
        panelInformacionVino.actualizarInformacion( seleccionado.darNombre( ), seleccionado.darPresentacion( ), seleccionado.darAnhoElaboracion( ), seleccionado.darContenidoAzucar( ), seleccionado.darTipo( ), seleccionado.darLugarOrigen( ),
                seleccionado.darColor( ), seleccionado.darImagen( ) );
    }

    /**
     * Ordena la lista de vinos por nombre.
     */
    public void ordenarPorNombre( )
    {
        cupiCava.ordenarVinosPorNombre( );
        actualizarLista( );
    }

    /**
     * Ordena la lista de vinos por año de elaboración.
     */
    public void ordenarPorAnhoElaboracion( )
    {
        cupiCava.ordenarVinosPorAnhoElaboracion( );
        actualizarLista( );
    }

    /**
     * Ordena la lista de vinos por lugar de origen.
     */
    public void ordenarPorLugarOrigen( )
    {
        cupiCava.ordenarVinosPorLugarOrigen( );
        actualizarLista( );
    }


    /**
     * Busca el vino por el nombre dado por el usuario.
     */
    public void buscarPorNombre( )
    {
        String nombre = JOptionPane.showInputDialog( null, "Nombre: ", "Buscar vino por nombre", JOptionPane.QUESTION_MESSAGE );
        if( nombre != null && !nombre.isEmpty( ) )
        {
            cupiCava.ordenarVinosPorNombre( );
            actualizarLista( );
            Vino vino = cupiCava.buscarBinarioPorNombre( nombre );
            if( vino != null )
            {
                panelListaVinos.seleccionar( vino.darNombre( ) );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No se encontró ningún vino con el nombre dado.", "Buscar vino por nombre", JOptionPane.INFORMATION_MESSAGE );
            }
        }
    }

    /**
     * Busca los vinos con el tipo dado por el usuario.
     */
    public void buscarPorTipo( )
    {
        String[] tipos = new String[]{ Vino.SECO, Vino.ABOCADO, Vino.SEMI_SECO, Vino.SEMI_DULCE, Vino.DULCE };
        String tipo = ( String )JOptionPane.showInputDialog( null, "Tipo: ", "Buscar vinos de un tipo", JOptionPane.QUESTION_MESSAGE, null, tipos, Vino.SECO );
        if( tipo != null )
        {

            ArrayList vinosTipo = cupiCava.buscarVinosDeTipo( tipo );
            ArrayList vinos = new ArrayList( );
            for( int i = 0; i < vinosTipo.size( ); i++ )
            {
                Vino actual = ( Vino ) vinosTipo.get( i );
                vinos.add( actual.darNombre( ) );
            }
            
            panelListaVinos.refrescarLista( vinos );
        }
    }

    /**
     * Busca el vino más dulce.
     */
    public void buscarVinoMasDulce( )
    {
        Vino vino = cupiCava.buscarVinoMasDulce( );
        if( vino != null )
        {
            actualizarLista( );
            panelListaVinos.seleccionar( vino.darNombre( ) );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "La cava no tiene vinos.", "Buscar vino más dulce", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el vino más seco.
     */
    public void buscarVinoMasSeco( )
    {
        Vino vino = cupiCava.buscarVinoMasSeco( );
        if( vino != null )
        {
            actualizarLista( );
            panelListaVinos.seleccionar( vino.darNombre( ) );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "La cava no tiene vinos.", "Buscar vino más seco", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Agrega una nuevo vino a la cava con los valores dados.
     * @param pNombre Nombre del vino. pNombre != null && pNombre != "".
     * @param pPresentacion Presentación del vino. pPresentacion != null && pPresentacion != "" && (pPresentacion == BOTELLA || pPresentacion == BARRIL).
     * @param pAnhoElaboracion Año de elaboración del vino. pAnhoElaboracion > 0.
     * @param pContenidoAzucar Contenido en azúcar del vino. pContenidoAzucar >= 0
     * @param pTipo Tipo de vino de acuerdo a su contenido en azúcar. pTipo != null && pTipo != "" && (pTipo == SECO || pTipo == ABOCADO || pTipo == SEMI_SECO || pTipo ==
     *        SEMI_DULCE || pTipo == DULCE).
     * @param pColor Color del vino. pColor != null && pColor != "" && (pColor == TINTO || pColor == ROSADO || pColor == BLANCO).
     * @param pLugarOrigen Lugar de origen del vino. lugarElaboracion != null y lugarElaboracion != "".
     * @param pImagen Imagen del vino. pImagen != null && pImagen != "".
     */
    public void agregarVino( String pNombre, String pPresentacion, int pAnhoElaboracion, double pContenidoAzucar, String pTipo, String pColor, String pLugarOrigen, String pImagen )
    {
        boolean agregada = cupiCava.agregarVino( pNombre, pPresentacion, pAnhoElaboracion, pContenidoAzucar, pTipo, pColor, pLugarOrigen, pImagen );
        if( agregada )
        {
            actualizarLista( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Ya existe en la cava un vino con el nombre dado.", "Agregar vino", JOptionPane.ERROR_MESSAGE );
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = cupiCava.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = cupiCava.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * @param pArgs Argumentos para la ejecución de la aplicación. En este caso no son necesarios. pArgs != null.
     */
    public static void main( String[] pArgs )
    {
        InterfazCupiCava interfaz = new InterfazCupiCava( );
        interfaz.setVisible( true );
    }
}