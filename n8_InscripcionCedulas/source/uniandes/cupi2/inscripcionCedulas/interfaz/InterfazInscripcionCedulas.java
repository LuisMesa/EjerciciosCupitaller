/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_inscripcionCedulas
 * Autor: Equipo Cupi2 - 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.inscripcionCedulas.interfaz;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.inscripcionCedulas.mundo.CiudadanoRegistradoException;
import uniandes.cupi2.inscripcionCedulas.mundo.Departamento;
import uniandes.cupi2.inscripcionCedulas.mundo.FormatoArchivoException;
import uniandes.cupi2.inscripcionCedulas.mundo.InscripcionCedulas;
import uniandes.cupi2.inscripcionCedulas.mundo.Municipio;
import uniandes.cupi2.inscripcionCedulas.mundo.PersistenciaException;
import uniandes.cupi2.inscripcionCedulas.mundo.PuestoVotacion;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazInscripcionCedulas extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa la ruta del archivo donde se guarda la información del sistema.
     */
    private final static String DATA = "./data/inscripcionCedulas.data";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private InscripcionCedulas inscripcionCedulas;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las extensiones.
     */
    private PanelExtensiones panelExtension;

    /**
     * Panel con la imagen del encabezado.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con las opciones del usuario.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con la información del sistemas de inscripción.
     */
    private PanelInformacion panelInformacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la ventana de la aplicación. <br>
     * <b>post: </b> Los paneles de la ventana han sido inicializados y la clase principal del mundo ha sido creada.
     */
    public InterfazInscripcionCedulas( )
    {
        // Crea la clase principal.

        try
        {
        	
            inscripcionCedulas = new InscripcionCedulas( DATA );
            
        }
        catch( PersistenciaException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }

        // Construye la forma.
        setLayout( new BorderLayout( ) );
        setSize( 800, 500 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "Sistema de inscripción de cédulas" );
        setResizable( false );

        // Creación de los paneles aquí.
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelExtension = new PanelExtensiones( this );
        add( panelExtension, BorderLayout.SOUTH );

        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.WEST );

        panelInformacion = new PanelInformacion( this );
        add( panelInformacion, BorderLayout.CENTER );

        setLocationRelativeTo( null );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna los departamentos del sistema de inscripción de cédulas.
     * @return Lista de departamentos del sistema.
     */
    public ArrayList darDepartamentos( )
    {
        return inscripcionCedulas.darDepartamentos( );
    }

    /**
     * Retorna los municipios del departamento dado por parámetro.
     * @param pDepartamento Departamento seleccionado por el usuario. pDepartamento != null && pDepartamento != " " .
     * @return Lista de los municipios del departamento.
     */
    public ArrayList darMunicipiosDepartamento( String pDepartamento )
    {
        ArrayList municipiosDepart = null;
        Departamento depart = inscripcionCedulas.buscarDepartamento( pDepartamento );
        municipiosDepart = depart.darMunicipios( );
        return municipiosDepart;
    }

    /**
     * Retorna los puestos de votación del municipio dado por parámetro.
     * @param pDepartamento Departamento seleccionado por el usuario. pDepartamento != null && pDepartamento != " " .
     * @param pMunicipio Municipio seleccionado por el usuario. pMunicipio != null && pMunicipio != " " .
     * @return Lista de los puestos de votación del municipio.
     */
    public ArrayList darPuestosVotacionMunicipio( String pDepartamento, String pMunicipio )
    {
        ArrayList puntosVotacion = null;
        Departamento depart = inscripcionCedulas.buscarDepartamento( pDepartamento );
        Municipio munic = depart.buscarMunicipio( pMunicipio );
        puntosVotacion = munic.darPuestosVotacion( );
        return puntosVotacion;
    }

    /**
     * Retorna los inscritos de votación del puesto de votación dado por parámetro.
     * @param pDepartamento Departamento seleccionado por el usuario. pDepartamento != null && pDepartamento != " " .
     * @param pMunicipio Municipio seleccionado por el usuario. pMunicipio != null && pMunicipio != " " .
     * @param pPuestoVotacion Puesto votación seleccionado por el usuario. pPuestoVotacion != null && pPuestoVotacion != " " .
     * @return Lista de inscritos del puesto de votación.
     */
    public ArrayList darInscritosPuestoVotacion( String pDepartamento, String pMunicipio, String pPuestoVotacion )
    {
        ArrayList inscritos = null;
        Departamento depart = inscripcionCedulas.buscarDepartamento( pDepartamento );
        Municipio munic = depart.buscarMunicipio( pMunicipio );
        PuestoVotacion puestos = munic.buscarPuestoVotacion( pPuestoVotacion );
        inscritos = puestos.darInscritos( );
        return inscritos;
    }
    /**
     * Retorna el porcentaje de hombres del sistema de inscripción de cédulas.
     * @return Porcentaje de hombres.
     */
    public double darPorcentajeHombres( )
    {
        return inscripcionCedulas.calcularPorcentajeHombresInscritos( );
    }

    /**
     * Retorna el número de ciudadanos inscritos en el rango dado por parámetro.
     * @param pRango Rango de edad. pRango != null && (pRango == RANGO_1 || pRango == RANGO_2 || pRango == RANGO_3 || pRango == RANGO_4 || pRango == RANGO_5 || pRango ==
     *        RANGO_6 ).
     * @return Ciudadanos inscritos en el rango de edad dado.
     */
    public int darInscritosRangoEdad( int pRango )
    {
        return inscripcionCedulas.calcularInscritosRangoEdad( pRango );
    }

    /**
     * Retorna el porcentaje de mujeres del sistemas de inscripción de cédulas.
     * @return Porcentaje de mujeres.
     */
    public double darPorcentajeMujeres( )
    {
        return inscripcionCedulas.calcularPorcentajeMujeresInscritas( );
    }

    /**
     * Retorna el puesto de votación dado el nombre del puesto por parámetro.
     * @param pDepartamento Departamento seleccionado por el usuario. pDepartamento != null && pDepartamento != " " .
     * @param pMunicipio Municipio seleccionado por el usuario. pMunicipio != null && pMunicipio != " " .
     * @param pNombrePuestoVotacion Nombre del puesto de votación. pNombrePuestoVotacion != null && pNombrePuestoVotacion != " " .
     * @return Puesto de votación, null en caso de que no lo encuentre.
     */
    public PuestoVotacion buscarPuestoVotacionMunicipio( String pDepartamento, String pMunicipio, String pNombrePuestoVotacion )
    {
        Departamento depart = inscripcionCedulas.buscarDepartamento( pDepartamento );
        Municipio munic = depart.buscarMunicipio( pMunicipio );
        PuestoVotacion puesto = munic.buscarPuestoVotacion( pNombrePuestoVotacion );
        return puesto;
    }
    /**
     * Despliega el dialogo que inscribe un ciudadano al sistema.
     */
    public void inscribirCiudadano( )
    {
        String p = panelInformacion.darPuestoSeleccionado( );

        if( p != null )
        {
            DialogoInscribirCiudadano dialogo = new DialogoInscribirCiudadano( this );
            dialogo.setVisible( true );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No ha seleccionado un puesto de votación.", "Inscribir ciudadano", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Inscribe el ciudadano con la información dada por parámetro.
     * @param pCedula Cédula del ciudadano. pCedula != null && pCedula != "".
     * @param pApellidos Apellidos del ciudadano. pApellidos != null && pApellidos != "".
     * @param pNombres Nombres del ciudadano. pNombres != null && pNombres != "".
     * @param pFechaNacimiento Fecha de nacimiento del ciudadano. pFechaNacimiento != null.
     * @param pLugarNacimiento Lugar de nacimiento del ciudadano. pLugarNacimiento != null && pLugarNacimiento != "".
     * @param pSexo Sexo del ciudadano. pSexo != null && (pSexo == FEMENINO || pSexo == MASCULINO ).
     * @param pFechaExpedicion Fecha de expedición de la cédula del ciudadano. pExpedicion != null.
     * @param pLugarExpedicion Lugar de expedición de la cédula del ciudadano. pLugarExpedicion != null && pLugarExpedicion != "".
     */
    public void inscribir( String pCedula, String pApellidos, String pNombres, Date pFechaNacimiento, String pLugarNacimiento, String pSexo, Date pFechaExpedicion, String pLugarExpedicion )
    {
        String d = panelInformacion.darDepartamentoSeleccionado( );
        String m = panelInformacion.darMunicipioSeleccionado( );
        String p = panelInformacion.darPuestoSeleccionado( );

        try
        {
            inscripcionCedulas.inscribirCiudadano( d, m, p, pCedula, pApellidos, pNombres, pFechaNacimiento, pLugarNacimiento, pSexo, pFechaExpedicion, pLugarExpedicion );
            panelInformacion.actualizarListaInscritos( p );
        }
        catch( CiudadanoRegistradoException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Inscribir ciudadano", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Importa la información del sistema de inscripción de cédulas de un archivo seleccionado por el usuario.<br>
     * <b>post: </b> Se ha importado la información del sistema y se ha actualizado la ventana de la aplicación.
     */
    public void importar( )
    {
        JFileChooser chooser = new JFileChooser( "./data" );
        chooser.setDialogTitle( "Importar datos" );
        int returnVal = chooser.showSaveDialog( this );
        if( returnVal == JFileChooser.APPROVE_OPTION )
        {
            String ruta = chooser.getSelectedFile( ).getPath( );
            try
            {
                inscripcionCedulas.importarDatos( ruta );
                panelInformacion.actualizarDepartamentos( );
            }
            catch( PersistenciaException e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Importar datos", JOptionPane.ERROR_MESSAGE );
            }
            catch( FormatoArchivoException e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Importar datos", JOptionPane.ERROR_MESSAGE );
            }
        }
        try
        {
        inscripcionCedulas.guardar(new File( DATA));
        }
        catch(Exception e)
        {
        	
        }
    }

    /**
     * Genera un reporte de los ciudadanos inscritos en el puesto de votación seleccionado.<br>
     * El usuario debe seleccionar la carpeta destino del reporte.
     */
    public void generarReporte( )
    {
        String d = panelInformacion.darDepartamentoSeleccionado( );
        String m = panelInformacion.darMunicipioSeleccionado( );
        String p = panelInformacion.darPuestoSeleccionado( );

        if( p != null )
        {
            JFileChooser chooser = new JFileChooser( "./data" );
            chooser.setDialogTitle( "Generar reporte" );
            int returnVal = chooser.showSaveDialog( this );
            if( returnVal == JFileChooser.APPROVE_OPTION )
            {
                String ruta = chooser.getSelectedFile( ).getParent( );
                String nombreArchivo = chooser.getSelectedFile( ).getName( );
                try
                {
                    inscripcionCedulas.generarReporte( ruta, nombreArchivo, p, m, d );
                    JOptionPane.showMessageDialog( this, "Reporte generado.", "Generar reporte", JOptionPane.INFORMATION_MESSAGE );
                }
                catch( PersistenciaException e )
                {
                    JOptionPane.showMessageDialog( this, e.getMessage( ), "Generar reporte", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No ha seleccionado un puesto de votación.", "Generar reporte", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Este método se encarga de salvar la información del sistema, justo antes de cerrar la aplicación.
     */
    public void dispose( )
    {
        //TODO Parte3 PuntoB Complete el método según la documentación dada.
    	//super.dispose();
    	try
    	{
    		inscripcionCedulas.guardar(new File(DATA));
    		super.dispose();
    	}
    	catch( Exception e)
    	{
    		setVisible(true);
    		int respuesta = JOptionPane.showConfirmDialog(this, "Error: "+e.getMessage()+"\n"+"Desea cerrar sin guardar","Error",JOptionPane.YES_NO_OPTION);
    		
    		if(respuesta==JOptionPane.YES_OPTION)
    			super.dispose();
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
        String resultado = inscripcionCedulas.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = inscripcionCedulas.metodo2( );
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

        InterfazInscripcionCedulas interfaz = new InterfazInscripcionCedulas( );
        interfaz.setVisible( true );
    }

}