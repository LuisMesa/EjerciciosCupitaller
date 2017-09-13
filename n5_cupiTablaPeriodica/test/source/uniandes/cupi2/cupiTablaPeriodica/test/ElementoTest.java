/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_cupiTablaPeriodica
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.cupiTablaPeriodica.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import uniandes.cupi2.cupiTablaPeriodica.mundo.Elemento;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los m�todos de la clase Elemento est�n correctamente implementados.
 */
public class ElementoTest extends TestCase
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Ruta del archivo de pruebas.
     */
    private final static String RUTA = "./test/data/prueba.properties";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Elemento elemento;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo Elemento.
     */
    private void setupEscenario1( )
    {
        try
        {
            // Carga la informaci�n
            Properties persistencia = new Properties( );
            FileInputStream fis = new FileInputStream( new File( RUTA ) );
            persistencia.load( fis );
            fis.close( );
            String nombre = persistencia.getProperty( "elemento" + 1 + ".nombre" );
            String simbolo = persistencia.getProperty( "elemento" + 1 + ".simbolo" );
            double masa = Double.parseDouble( persistencia.getProperty( "elemento" + 1 + ".masa" ) );
            int numeroAtomico = Integer.parseInt( persistencia.getProperty( "elemento" + 1 + ".numeroAtomico" ) );
            boolean esMetal = Boolean.parseBoolean( persistencia.getProperty( "elemento" + 1 + ".esMetal" ) );
            int periodo = Integer.parseInt( persistencia.getProperty( "elemento" + 1 + ".periodo" ) );
            int grupo = Integer.parseInt( persistencia.getProperty( "elemento" + 1 + ".grupo" ) );
            double energiaDeIonizacion = Double.parseDouble( persistencia.getProperty( "elemento" + 1 + ".energiaIonizacion" ) );
            elemento = new Elemento( nombre, simbolo, masa, numeroAtomico, esMetal, periodo, grupo, energiaDeIonizacion );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar esta excepci�n: " + e.getMessage( ) );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * Elemento<br>
     * darNombre<br>
     * darSimbolo<br>
     * darMasa<br>
     * darNumeroAtomico<br>
     * esMetal<br>
     * darPeriodo<br>
     * darGrupo<br>
     * <b> Caso de prueba 1:</b><br>
     * Construye correctamente el elemento, cada uno de los valores corresponde al esperado.<br>
     */
    public void testElemento( )
    {
        setupEscenario1( );

        assertEquals( "Error al cargar el nombre.", "ElementoPrueba", elemento.darNombre( ) );
        assertEquals( "Error al cargar el s�mbolo.", "Ep", elemento.darSimboloQuimico( ) );
        assertEquals( "Error al cargar la masa.",14.56, elemento.darMasa( ), 0.001);
        assertEquals( "Error al cargar el n�mero at�mico.", 173, elemento.darNumeroAtomico( ) );
        assertEquals( "Error al cargar la caracter�stica es metal.", true, elemento.esMetal( ) );
        assertEquals( "Error al cargar el periodo.", 6, elemento.darPeriodo( ) );
        assertEquals( "Error al cargar el grupo.", 5, elemento.darGrupo( ) );
    }

}
