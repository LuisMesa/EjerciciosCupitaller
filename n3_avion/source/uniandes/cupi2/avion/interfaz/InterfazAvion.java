/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n3_avion
 * Autor: Equipo Cupi2.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.avion.interfaz;

import java.awt.*;
import java.text.*;
import java.util.ArrayList;

import javax.swing.*;

import uniandes.cupi2.avion.mundo.*;

/**
 * Clase que representa la ventana principal de la aplicaci�n.
 */
public class InterfazAvion extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Avion avion;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Panel que contiene el avi�n.
     */
    private PanelAvion panelAvion;

    /**
     * Panel con los botones.
     */
    private PanelBotonesAvion panelBotones;

    /**
     * Dialogo de nuevo pasajero.
     */
    private DialogoAsignacion dialogoAsignacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana principal de la aplicaci�n.<br>
     */
    public InterfazAvion( )
    {
        // Crea al avi�n
        avion = new Avion( );

        // Configura la interfaz
        setLayout( new BorderLayout( ) );

        // Panel de botones
        panelBotones = new PanelBotonesAvion( this );
        add( panelBotones, BorderLayout.NORTH );

        // Panel del avi�n
        panelAvion = new PanelAvion( this );
        add( panelAvion, BorderLayout.CENTER );

        String titulo = "Avi�n";
        setTitle( titulo );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo(null);
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el peso total de todos los equipajes que posee el avi�n.
     */
    public void darPesoTotalEquipajes( )
    {
        int pesoTotal = avion.darPesoTotalEquipajes( );
        String respuesta = "El peso total de los equipajes del avi�n es: " + pesoTotal + " (kg).";
        JOptionPane.showMessageDialog( this, respuesta, "Peso total equipajes", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Retorna el equipaje m�s pesado que posee el avi�n.
     */
    public void darEquipajeMasPesado( )
    {
        Equipaje darEquipajeMasPesado = avion.darEquipajeMasPesado( );
        if( darEquipajeMasPesado != null )
        {

            String rta = "El equipaje m�s pesado del avi�n es de " + darEquipajeMasPesado.darPeso( ) + " (kg.)";
            JOptionPane.showMessageDialog( this, rta, "Equipaje m�s pesado", JOptionPane.INFORMATION_MESSAGE );

        }
        else
        {
            JOptionPane.showMessageDialog( this, "El avi�n no posee equipajes.", "Equipaje m�s pesado", JOptionPane.ERROR_MESSAGE );

        }
    }

    /**
     * Retorna las sillas ejecutivas del avi�n.
     * @return Sillas ejecutivas del avi�n.
     */
    public Silla[] darSillasEjecutivas( )
    {
        return avion.darSillasEjecutivas( );
    }

    /**
     * Retorna las sillas econ�micas del avi�n.
     * @return Sillas econ�micas del avi�n.
     */
    public Silla[] darSillasEconomicas( )
    {
        return avion.darSillasEconomicas( );
    }

    /**
     * Busca la silla de un pasajero.
     */
    public void buscarSillaPasajero( )
    {
        // Pregunta el numero de c�dula
        int cedula;
        String sCedula = JOptionPane.showInputDialog( this, "Ingrese el n�mero de c�dula" );
        try
        {
            cedula = Integer.parseInt( sCedula );
        }
        catch( NumberFormatException e )
        {
            JOptionPane.showMessageDialog( this, "Error en el n�mero de c�dula.", "B�squeda pasajero", JOptionPane.ERROR_MESSAGE );
            return;
        }

        Silla silla = avion.buscarSillaPasajero( cedula );

        if( silla != null )
        {
            VentanaDatosPasajero vDatos = new VentanaDatosPasajero( silla.darPasajero( ).darNombre( ), silla.darPasajero( ).darCedula( ), silla.darClase( ), silla.darNumero( ), silla.darUbicacion( ) );
            vDatos.setLocation( calculaPosicionCentral( this, vDatos ) );
            vDatos.setVisible( true );

        }
        else
        {
            JOptionPane.showMessageDialog( this, "El pasajero no se encuentra registrado.", "B�squeda pasajero", JOptionPane.INFORMATION_MESSAGE );
            return;
        }
    }

    /**
     * Busca equipajes de un pasajero.
     */
    public void buscarEquipajes( )
    {
        String cedula = JOptionPane.showInputDialog( this, "Ingrese la c�dula del pasajero:", "C�dula pasajero", JOptionPane.QUESTION_MESSAGE );
        try
        {
            int ced = Integer.parseInt( cedula );
            ArrayList lista = avion.darEquipajesPasajero( ced );
            Silla silla = avion.buscarSillaPasajero( ced );
            if( silla != null )
            {
                if( lista != null )
                {

                    String respuesta = "Los equipajes que posee el pasajero son:\n";
                    for( int i = 0; i < lista.size( ); i++ )
                    {
                        Equipaje act = ( Equipaje )lista.get( i );
                        respuesta += act.toString( );
                        respuesta += "\n";
                    }
                    JOptionPane.showMessageDialog( this, respuesta, "Buscar equipajes", JOptionPane.INFORMATION_MESSAGE );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "El pasajero no tiene equipajes.", "Buscar equipajes", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No existe pasajero con la c�dula dada.", "Buscar equipajes", JOptionPane.INFORMATION_MESSAGE );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar un valor v�lido para la c�dula.", "Buscar equipajes", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Procesa el registro un pasajero.
     */
    public void registrarPasajero( )
    {
        dialogoAsignacion = new DialogoAsignacion( this );
        dialogoAsignacion.setLocation( calculaPosicionCentral( this, dialogoAsignacion ) );
        dialogoAsignacion.setModal( true );
        dialogoAsignacion.setVisible( true );
        actualizar( );
    }

    /**
     * Agrega un equipaje a un pasajero.
     * @param pCedula C�dula del pasajero.
     * @param pCategoria Categor�a del equipaje del pasajero. pCategoria != null && pCategoria != "" && (pCategoria == EQUIPAJE_MUSICAL || pCategoria == EQUIPAJE_DE_MANO ||
     *        pCategoria == EQUIPAJE_DEPORTIVO || pCategoria == EQUIPAJE_ESPECIAL).
     * @param pPeso Peso del equipaje del pasajero. pPeso > 0.
     * @param pCiudadDestino Ciudad destino del equipaje del pasajero. pCiudadDestino != null && pCiudadDestino != "".
     * @param pAncho Ancho del equipaje del pasajero. pAncho > 0.
     * @param pLargo Largo del equipaje del pasajero. pAncho > 0.
     * @param pAlto Alto del equipaje del pasajero. pAncho > 0.
     */
    public void agregarEquipaje( int pCedula, String pCategoria, double pPeso, String pCiudadDestino, double pAncho, double pLargo, double pAlto )
    {
        Silla silla = avion.buscarSillaPasajero( pCedula );
        if( silla != null )
        {
            silla.darPasajero( ).agregarEquipaje( pCategoria, pPeso, pCiudadDestino, pAncho, pLargo, pAlto );
            JOptionPane.showMessageDialog( this, "El equipaje fue agregado exitosamente.", "Agregar equipaje", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existe pasajero con la c�dula dada.", "Agregar equipaje", JOptionPane.INFORMATION_MESSAGE );
        }
    }
    /**
     * Asigna la silla a un pasajero, seg�n sus preferencias de clase y ubicaci�n <br>
     * @param pClase Clase elegida por el pasajero. (pClase == CLASE_EJECUTIVA || pClase == CLASE_ECONOMICA).
     * @param pUbicacion Ubicaci�n elegida por el pasajero. (pUbicacion == VENTANA || pUbicacion == CENTRAL || pUbicacion == PASILLO).
     * @param pCedulaPasajero C�dula del pasajero.
     * @param pNombrePasajero Nombre del pasajero. pNombre != null && pNombre != "" .
     */
    public void asignarSilla( int pClase, int pUbicacion, int pCedulaPasajero, String pNombrePasajero )
    {

        Silla silla = avion.buscarSillaPasajero( pCedulaPasajero );

        if( silla != null )
        {
            JOptionPane.showMessageDialog( this, "El pasajero ya tiene una silla asignada", "Asignar silla", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            if( avion.darNumeroDeSillas( ) != ( avion.contarSillasEconomicasOcupadas( ) + avion.contarSillasEjecutivasOcupadas( ) ) )
            {
                avion.asignarSilla( pClase, pUbicacion, pCedulaPasajero, pNombrePasajero );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No hay sillas disponibles con dichas caracter�sticas", "Asignar silla", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    /**
     * Desasigna la silla de un pasajero.
     */
    public void desasignarSilla( )
    {
        // Pregunta el numero de c�dula
        int cedula;
        String sCedula = JOptionPane.showInputDialog( this, "Ingrese el n�mero de c�dula" );
        try
        {
            cedula = Integer.parseInt( sCedula );
            if( !avion.desasignarSilla( cedula ) )
            {
                JOptionPane.showMessageDialog( this, "El pasajero no ten�a silla asignada.", "Desasignar silla", JOptionPane.ERROR_MESSAGE );
            }
        }
        catch( NumberFormatException e )
        {
            JOptionPane.showMessageDialog( this, "Error en el n�mero de c�dula.", "Desasignar silla", JOptionPane.ERROR_MESSAGE );
        }
        actualizar( );
    }

    /**
     * Muestra en un di�logo los equipajes que pertenecen a una determinada categor�a.
     * @param pCedula C�dula del pasajero.
     * @param pCategoria Categor�a al cual pertenece el equipaje. pCategoria != null && pCategoria != "" && (pCategoria == EQUIPAJE_MUSICAL || pCategoria == EQUIPAJE_DE_MANO
     *        || pCategoria == EQUIPAJE_DEPORTIVO || pCategoria == EQUIPAJE_ESPECIAL).
     */
    public void categoriaEquipajes( int pCedula, String pCategoria )
    {
        Silla silla = avion.buscarSillaPasajero( pCedula );

        if( silla != null )
        {
            ArrayList lista = avion.darEquipajesCategoriaPasajero( pCedula, pCategoria );
            String rta = "Los equipajes de la categor�a \"" + pCategoria + "\" que posee el pasajero son:\n";
            if( lista != null )
            {

                double pesoTotal = 0;
                for( int i = 0; i < lista.size( ); i++ )
                {
                    Equipaje act = ( Equipaje )lista.get( i );
                    rta += ( i + 1 ) + ". " + act.darCategoria( ) + " - Peso equipaje: " + act.darPeso( ) + " (Kg.)";
                    pesoTotal += act.darPeso( );
                    rta += "\n";
                }
                rta += ( "Peso total: " + pesoTotal + " (Kg.)" );
            }
            else
            {
                rta = "El pasajero no tiene equipajes de esa categor�a.";
            }
            JOptionPane.showMessageDialog( this, rta, "Equipajes pasajero", JOptionPane.INFORMATION_MESSAGE );

        }
        else
        {
            JOptionPane.showMessageDialog( this, "No existe un pasajero con esa c�dula.", "Equipajes pasajero", JOptionPane.ERROR_MESSAGE );

        }
    }

    /**
     * Muestra el di�logo que da todas los equipajes de una categor�a para un pasajero determinado.
     */
    public void mostrarDialogoCategoriaEquipaje( )
    {
        DialogoEquipajeCategoria dialogo = new DialogoEquipajeCategoria( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el porcentaje de ocupaci�n que tiene el avi�n
     */
    public void mostrarPorcentajeOcupacion( )
    {
        double porcentaje;
        porcentaje = avion.calcularPorcentajeOcupacion( );
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###.##" );
        JOptionPane.showMessageDialog( this, "El porcentaje de ocupaci�n es " + df.format( porcentaje ) + "%.", "Ocupaci�n del avi�n", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Muestra el di�logo para agregar un equipaje.
     */
    public void mostrarDialogoAgregarEquipaje( )
    {
        DialogoAgregarEquipaje dialogo = new DialogoAgregarEquipaje( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Calcula el punto central entre dos componentes.
     * @param pComponentePadre Componente padre sobre el que se calcula el centro. pComponentePadre != null.
     * @param pComponenteHijo Componente hijo que se centra sobre el padre. pComponenteHijo != null.
     * @return Punto central para ubicar al componente hijo
     */
    private Point calculaPosicionCentral( Component pComponentePadre, Component pComponenteHijo )
    {

        // Centra la ventana y asegura que no sea mayor que la resoluci�n actual
        Dimension tamanhoPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int maxY = tamanhoPantalla.height;
        int minY = 0;

        // Tama�o de la resoluci�n de la pantalla
        Dimension tamanhoPadre = pComponentePadre.getSize( );
        Point locacionPadre = pComponentePadre.getLocation( );
        Dimension tamanhoHijo = pComponenteHijo.getSize( );
        int x = ( tamanhoPadre.width - tamanhoHijo.width ) / 2 + locacionPadre.x;
        int y = ( tamanhoPadre.height - tamanhoHijo.height ) / 2 + locacionPadre.y;

        // Ajuste para abajo
        if( y + tamanhoHijo.height > maxY )
        {
            y = maxY - tamanhoHijo.height;
        }

        // Ajuste para arriba
        if( y < minY )
        {
            y = 0;
        }
        return new Point( x, y );
    }

    /**
     * Repinta la gr�fica del avi�n.
     */
    public void actualizar( )
    {
        remove( panelAvion );
        // Panel del avi�n
        panelAvion = new PanelAvion( this );
        add( panelAvion, BorderLayout.CENTER );
        validate( );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = avion.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2.
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = avion.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz.
     * @param pArgs Argumentos para la ejecuci�n de la aplicaci�n. En este caso no son necesarios.
     */
    public static void main( String[] pArgs )
    {
        InterfazAvion interfaz = new InterfazAvion( );
        interfaz.setVisible( true );
    }
}