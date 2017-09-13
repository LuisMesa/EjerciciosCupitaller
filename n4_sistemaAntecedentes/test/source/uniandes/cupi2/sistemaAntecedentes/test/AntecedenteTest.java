/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: sistemaAntecedentes
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sistemaAntecedentes.test;

import junit.framework.TestCase;
import uniandes.cupi2.sistemaAntecedentes.mundo.Antecedente;

/**
 * Clase usada para verificar la correcta implementación de Antecedente.
 */
public class AntecedenteTest extends TestCase
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Antecedente antecedente;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1. Crea un nuevo antecedente.
     */
    public void setupEscenario1( )
    {
        antecedente = new Antecedente( 1, Antecedente.ESTAFA, "Descripción1" );
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * Antecedente<br>
     * darTipo<br>
     * darDescripcion<br>
     * determinarGravedad<br>
     * darGravedad<br>
     * <b> Caso de prueba:</b><br>
     *  1. Construye correctamente el antecedente, cada uno de los valores corresponde al esperado.
     */
    public void testAntecedente( )
    {
        setupEscenario1( );

        assertEquals( "El identificador del antecedente debe ser 1.", 1, antecedente.darIdentificador( ) );
        assertEquals( "El tipo del antecedente es Estafa.", Antecedente.ESTAFA, antecedente.darTipo( ) );
        assertEquals( "La descripción del antecedente es Descripción1.", "Descripción1", antecedente.darDescripcion( ) );
        assertEquals( "La gravedad del antecedente debe ser Grave.", Antecedente.GRAVE, antecedente.darGravedad( ) );
        
        antecedente = new Antecedente( 2, Antecedente.HOMICIDIO, "Descripción2" );
        assertEquals( "El identificador del antecedente debe ser 2.", 2, antecedente.darIdentificador( ) );
        assertEquals( "El tipo del antecedente es Homicidio.", Antecedente.HOMICIDIO, antecedente.darTipo( ) );
        assertEquals( "La descripción del antecedente es Descripción2.", "Descripción2", antecedente.darDescripcion( ) );
        assertEquals( "La gravedad del antecedente debe ser Muy grave.", Antecedente.MUY_GRAVE, antecedente.darGravedad( ) );
        
        antecedente = new Antecedente( 3, Antecedente.ECOLOGICO, "Descripción3" );
        assertEquals( "El identificador del antecedente debe ser 3.", 3, antecedente.darIdentificador( ) );
        assertEquals( "El tipo del antecedente es Ecológico.", Antecedente.ECOLOGICO, antecedente.darTipo( ) );
        assertEquals( "La descripción del antecedente es Descripción3.", "Descripción3", antecedente.darDescripcion( ) );
        assertEquals( "La gravedad del antecedente debe ser Leve.", Antecedente.LEVE, antecedente.darGravedad( ) );
        
    }
    
    /**
     * Prueba 2: Se encarga de verificar el método cambiarCondena de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * cambiarCondena <br>
     * <b> Caso de prueba:</b><br>
     *  1. Para una condena GRAVE se cambia a una condena menor a 6.
     *  2. Para una condena GRAVE se cambia a una condena mayor a 15.
     *  3. Para una condena MUY_GRAVE se cambia a una condena menor a 16.
     *  4. Para una condena LEVE se cambia a una condena menor a 1.
     *  5. Para una condena LEVE se cambia a una condena mayor a 5.
     */
    public void testCambiarCondena1( )
    {
        setupEscenario1( );
        
        // Caso de prueba 1.
        try
        {
            antecedente.cambiarCondena( 4 );
            fail( "Debería generar excepción. La condena para un delito GRAVE debe estar entre 6 y 15 años." );
            
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "Por ser un antecedente grave, la condena debe ser mayor a " + Antecedente.MAXIMO_ANHOS_CONDENA_LEVE + " años y menor o igual a " + Antecedente.MAXIMO_ANHOS_CONDENA_GRAVE + " años.", e.getMessage( ) );
        }
        
        // Caso de prueba 2.
        try
        {
            antecedente.cambiarCondena( 16 );
            fail( "Debería generar excepción. La condena para un delito GRAVE debe estar entre 6 y 15 años." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "Por ser un antecedente grave, la condena debe ser mayor a " + Antecedente.MAXIMO_ANHOS_CONDENA_LEVE + " años y menor o igual a " + Antecedente.MAXIMO_ANHOS_CONDENA_GRAVE + " años.", e.getMessage( ) );
        }
        
        // Caso de prueba 3.
        antecedente = new Antecedente( 2, Antecedente.HOMICIDIO, "Descripción2" );
        try
        {
            antecedente.cambiarCondena( 15 );
            fail( "Debería generar excepción. La condena para un delito MUY_GRAVE debe ser mayor a 16 años." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "Por ser un antecedente muy grave, la condena debe ser mayor o igual a " + Antecedente.MINIMO_ANHOS_CONDENA_MUY_GRAVE + " años.", e.getMessage( ) );
        }
        
        // Caso de prueba 4.
        antecedente = new Antecedente( 3, Antecedente.ECOLOGICO, "Descripción3" );
        try
        {
            antecedente.cambiarCondena( -1 );
            fail( "Debería generar excepción. La condena para un delito LEVE debe estar entre 1 y 5 años." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "Por ser un antecedente de gravedad leve, la condena debe ser mayor a 0 años y menor o igual a " + Antecedente.MAXIMO_ANHOS_CONDENA_LEVE + " años.", e.getMessage( ) );
        }
        
        // Caso de prueba 5.
        try
        {
            antecedente.cambiarCondena( 6 );
            fail( "Debería generar excepción. La condena para un delito LEVE debe estar entre 1 y 5 años." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "Por ser un antecedente de gravedad leve, la condena debe ser mayor a 0 años y menor o igual a " + Antecedente.MAXIMO_ANHOS_CONDENA_LEVE + " años.", e.getMessage( ) );
        }
    }
    
    /**
     * Prueba 3: Se encarga de verificar el método cambiarCondena de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * cambiarCondena <br>
     * <b> Caso de prueba:</b><br>
     *  1. Para una condena GRAVE se cambia correctamente los años de condena (un valor mayor o igual a 6 y menor o igual a 15).
     *  2. Para una condena MUY_GRAVE se cambia correctamente los años de condena (un valor mayor o igual a 16).
     *  3. Para una condena LEVE se cambia correctamente los años de condena (un valor mayor o igual a 1 y menor o igual a 5).
     */
    public void testVerificarCondena2( )
    {
        setupEscenario1( );
        
        // Caso de prueba 1.
        try
        {
            antecedente.cambiarCondena( 6 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
        try
        {
            antecedente.cambiarCondena( 10 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
        try
        {
            antecedente.cambiarCondena( 15 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
        
        // Caso de prueba 2.
        antecedente = new Antecedente( 2, Antecedente.HOMICIDIO, "Descripción2" );
        try
        {
            antecedente.cambiarCondena( 16 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
        try
        {
            antecedente.cambiarCondena( 25 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
        
        // Caso de prueba 3.
        antecedente = new Antecedente( 3, Antecedente.ECOLOGICO, "Descripción3" );
        try
        {
            antecedente.cambiarCondena( 1 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
        try
        {
            antecedente.cambiarCondena( 3 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
        try
        {
            antecedente.cambiarCondena( 5 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
        
    }
}