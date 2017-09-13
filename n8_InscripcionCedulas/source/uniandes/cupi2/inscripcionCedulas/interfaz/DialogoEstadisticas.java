/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_inscripcionCedulas
 * Autor: Equipo Cupi2 - 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.inscripcionCedulas.interfaz;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import uniandes.cupi2.inscripcionCedulas.mundo.InscripcionCedulas;

/**
 * Dialogo que muestra las gr�ficas con las estad�sticas del sistema.
 */
public class DialogoEstadisticas extends JDialog
{
    // -----------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------

    /**
     * Panel con la gr�fica Hombres vs. Mujeres.
     */
    private ChartPanel panelSexos;

    /**
     * Panel con la gr�fica de rango de edades.
     */
    private ChartPanel panelEdades;

    // -----------------------------------------------
    // M�todos
    // -----------------------------------------------

    /**
     * Crea el dialogo que muestra las estad�sticas del sistema.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public DialogoEstadisticas( InterfazInscripcionCedulas pPrincipal )
    {
        setLayout( new GridLayout( 1, 2 ) );
        setSize( 700, 400 );
        setLocationRelativeTo( null );
        setModal( true );
        setTitle( "Estad�sticas del sistema" );

        // Gr�fico Hombres vs. Mujeres.
        double hombres = pPrincipal.darPorcentajeHombres( );
        double mujeres = pPrincipal.darPorcentajeMujeres( );

        DefaultPieDataset data1 = new DefaultPieDataset( );

        if( mujeres > 0.0 || hombres > 0.0 )
        {
            data1.insertValue( 0, "Hombres", hombres );
            data1.insertValue( 1, "Mujeres", mujeres );
        }

        JFreeChart grafica1 = ChartFactory.createPieChart3D( "Hombres vs. mujeres", data1, false, true, false );
        PiePlot pp = ( PiePlot )grafica1.getPlot( );
        pp.setCircular( true );
        pp.setForegroundAlpha( 0.4f );
        pp.setLabelFont( new Font( "Arial", Font.PLAIN, 11 ) );
        pp.setNoDataMessage( "No se ha registrado ning�n ciudadano." );

        panelSexos = new ChartPanel( grafica1 );
        add( panelSexos );

        // Gr�fico de rango de edades.
        DefaultPieDataset data2 = new DefaultPieDataset( );
        data2.insertValue( 0, "18 - 25 a�os", pPrincipal.darInscritosRangoEdad( InscripcionCedulas.RANGO_1 ) );
        data2.insertValue( 1, "26 - 29 a�os", pPrincipal.darInscritosRangoEdad( InscripcionCedulas.RANGO_2 ) );
        data2.insertValue( 2, "30 - 37 a�os", pPrincipal.darInscritosRangoEdad( InscripcionCedulas.RANGO_3 ) );
        data2.insertValue( 3, "38 - 49 a�os", pPrincipal.darInscritosRangoEdad( InscripcionCedulas.RANGO_4 ) );
        data2.insertValue( 4, "50 - 66 a�os", pPrincipal.darInscritosRangoEdad( InscripcionCedulas.RANGO_5 ) );
        data2.insertValue( 5, "67 a�os o m�s", pPrincipal.darInscritosRangoEdad( InscripcionCedulas.RANGO_6 ) );

        JFreeChart grafica2 = ChartFactory.createPieChart3D( "Rango de edades", data2, false, true, false );
        PiePlot pp2 = ( PiePlot )grafica2.getPlot( );
        pp2.setCircular( true );
        pp2.setForegroundAlpha( 0.4f );
        pp2.setLabelFont( new Font( "Arial", Font.PLAIN, 11 ) );
        pp2.setNoDataMessage( "No se ha registrado ning�n ciudadano." );

        panelEdades = new ChartPanel( grafica2 );
        add( panelEdades );
    }
}
