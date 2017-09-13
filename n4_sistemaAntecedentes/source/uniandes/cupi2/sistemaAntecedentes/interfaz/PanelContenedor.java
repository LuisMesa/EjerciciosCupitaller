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
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Panel que contiene la informaci�n del procesado y sus antecedentes.
 */
public class PanelContenedor extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazSistemaAntecedentes principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la informaci�n de un procesado.
     */
    private PanelProcesado panelProcesado;

    /**
     * Panel con la los antecedentes de un procesado.
     */
    private PanelAntecedentes panelAntecedentes;

    // -----------------------------------------------------------------
    // Contructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel contenedor de los paneles que muestran la informaci�n del procesado y sus antecedentes.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelContenedor( InterfazSistemaAntecedentes pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );
        setPreferredSize( new Dimension( 532, 194 ) );

        panelProcesado = new PanelProcesado( principal );
        add( panelProcesado, BorderLayout.WEST );

        panelAntecedentes = new PanelAntecedentes( principal );
        add( panelAntecedentes, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la informaci�n de un procesado y sus antecedentes.
     * @param pNombre Nombre del procesado. pNombre != "" && pNombre != null.
     * @param pApellido Apellido del procesado. pApellido != "" && pApellido != null.
     * @param pIdentificacion N�mero de identificaci�n del procesado. pIdentificacion != "" && pIdentificacion != null.
     * @param pSexo Sexo del procesado. pSexo != "" && pSexo != null.
     * @param pEdad Edad del procesado. pEdad >= 5.
     * @param pAntecedentes los antecedentes del reportado. pAntecedentes != null.
     * @param pAnhosCondena A�os de condena del procesado. pAnhosCondena >= 0.
     */
    public void actualizar( String pNombre, String pApellido, String pIdentificacion, String pSexo, int pEdad, ArrayList pAntecedentes, int pAnhosCondena )
    {
        panelProcesado.actualizar( pNombre, pApellido, pIdentificacion, pSexo, pEdad, pAnhosCondena );
        panelAntecedentes.actualizar( pAntecedentes );
    }
}
