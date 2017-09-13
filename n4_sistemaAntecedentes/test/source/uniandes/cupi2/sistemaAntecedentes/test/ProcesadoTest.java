/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: sistemaAntecedentes
 * Autor: Equipo Cupi2 2015.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sistemaAntecedentes.test;

import junit.framework.TestCase;
import uniandes.cupi2.sistemaAntecedentes.mundo.Antecedente;
import uniandes.cupi2.sistemaAntecedentes.mundo.Procesado;

/**
 * Clase usada para verificar la correcta implementación de Procesado.
 */
public class ProcesadoTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Procesado procesado;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea un procesado mayor de edad sin antecedentes.
     */
    public void setupEscenario1( )
    {
        try
        {
            procesado = new Procesado( "Nombre1", "Apellido1", "Cédula1", Procesado.MASCULINO, 20 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Escenario 2: Crea un procesado menor de edad sin antecedentes.
     */
    public void setupEscenario2( )
    {
        try
        {
            procesado = new Procesado( "Nombre2", "Apellido2", "TarjetaIdentidad2", Procesado.FEMENINO, 15 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Escenario 3: Crea un procesado mayor de edad con antecedentes.
     */
    public void setupEscenario3( )
    {
        try
        {
            procesado = new Procesado( "Nombre1", "Apellido1", "Cédula1", Procesado.MASCULINO, 20 );
            procesado.agregarAntecedente( 1, Antecedente.CONSUMO_DE_DROGAS, "Descripción1" );
            procesado.agregarAntecedente( 2, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripción2" );
            procesado.agregarAntecedente( 3, Antecedente.VIOLENCIA, "Descripción3" );
        }
        catch( Exception e )
        {
            fail( "No debería generar Excepción." );
        }
    }

    /**
     * Escenario 4: Crea un procesado menor de edad con antecedentes.
     */
    public void setupEscenario4( )
    {
        try
        {
            procesado = new Procesado( "Nombre2", "Apellido2", "Cédula2", Procesado.FEMENINO, 15 );
            procesado.agregarAntecedente( 1, Antecedente.CONSUMO_DE_DROGAS, "Descripción1" );
            procesado.agregarAntecedente( 2, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripción2" );
            procesado.agregarAntecedente( 3, Antecedente.VIOLENCIA, "Descripción3" );
        }
        catch( Exception e )
        {
            fail( "No debería generar Excepción." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * Procesado<br>
     * darNombre<br>
     * darapellido <br>
     * darIdentificacion<br>
     * darSexo<br>
     * darAntecedentes<br>
     * esMayorDeEdad <br>
     * <b> Caso de prueba:</b><br>
     * 1. Construye correctamente los procesados con los valores indicados. <br>
     * 2. Trata de construir un procesado con edad menor a EDAD_MINIMA. 
     */
    public void testProcesado( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        assertEquals( "El nombre del procesado es Nombre1.", "Nombre1", procesado.darNombre( ) );
        assertEquals( "El apellido del procesado es Apellido1.", "Apellido1", procesado.darApellido( ) );
        assertEquals( "El número de identificación del procesado es Cédula1.", "Cédula1", procesado.darIdentificacion( ) );
        assertEquals( "El sexo del procesado es Masculino.", Procesado.MASCULINO, procesado.darSexo( ) );
        assertEquals( "El procesado no debería tener antecedentes.", 0, procesado.darAntecedentes( ).size( ) );
        assertEquals( "El procesado es mayor de edad.", true, procesado.esMayorDeEdad( ) );

        setupEscenario2( );
        assertEquals( "El nombre del procesado es Nombre2.", "Nombre2", procesado.darNombre( ) );
        assertEquals( "El apellido del procesado es Apellido2.", "Apellido2", procesado.darApellido( ) );
        assertEquals( "El número de identificación del procesado es TarjetaIdentidad2.", "TarjetaIdentidad2", procesado.darIdentificacion( ) );
        assertEquals( "El sexo del procesado es Femenino.", Procesado.FEMENINO, procesado.darSexo( ) );
        assertEquals( "El procesado no debería tener antecedentes.", 0, procesado.darAntecedentes( ).size( ) );
        assertEquals( "El procesado es menor de edad.", false, procesado.esMayorDeEdad( ) );
        
        // Caso de prueba 2.
        try
        {
            procesado = new Procesado( "Nombre1", "Apellido1", "12345", Procesado.FEMENINO, 2 );
            fail( "Debería generar excepción. El procesado tiene una edad menor a la mínima permitida." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "La edad mínima del procesado es de " + Procesado.EDAD_MINIMA + " años.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 2: Se encarga de verificar el método agregarAntecedente de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarAntecedente <br>
     * <b> Caso de prueba:</b><br>
     * 1. Agrega correctamente los antecedente de un procesado.
     */
    public void testAgregarAntecedente( )
    {
        setupEscenario1( );
        procesado.agregarAntecedente( 1, Antecedente.CONSUMO_DE_DROGAS, "Descripción1" );
        procesado.agregarAntecedente( 2, Antecedente.ECOLOGICO, "Descripción2" );
        procesado.agregarAntecedente( 3, Antecedente.ESTAFA, "Descripción3" );

        assertTrue( "El procesado debe tener 3 antecedentes.", procesado.darAntecedentes( ).size( ) == 3 );
        assertEquals( "El identificador del primer antecedente debe ser 1.", 1, ( ( Antecedente )procesado.darAntecedentes( ).get( 0 ) ).darIdentificador( ) );
        assertEquals( "El primer antecedente debe ser de tipo: consumo de drogas.", Antecedente.CONSUMO_DE_DROGAS, ( ( Antecedente )procesado.darAntecedentes( ).get( 0 ) ).darTipo( ) );

        assertEquals( "El identificador del primer antecedente debe ser 2.", 2, ( ( Antecedente )procesado.darAntecedentes( ).get( 1 ) ).darIdentificador( ) );
        assertEquals( "El segundo antecedente debe ser de tipo: ecológico.", Antecedente.ECOLOGICO, ( ( Antecedente )procesado.darAntecedentes( ).get( 1 ) ).darTipo( ) );

        assertEquals( "El identificador del primer antecedente debe ser 3.", 3, ( ( Antecedente )procesado.darAntecedentes( ).get( 2 ) ).darIdentificador( ) );
        assertEquals( "El tercer antecedente debe ser de tipo: estafa.", Antecedente.ESTAFA, ( ( Antecedente )procesado.darAntecedentes( ).get( 2 ) ).darTipo( ) );

    }

    /**
     * Prueba 3: Se encarga de verificar el método buscarAntecedente de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarAntecedente <br>
     * <b> Casos de prueba:</b><br>
     * 1. Encuentra correctamente el antecedente del procesado.<br>
     * 2. Busca un antecedente que no existe en la lista de antecedentes del procesado.
     */
    public void testBuscarAntecedente( )
    {
        setupEscenario3( );

        // Caso de prueba 1.
        Antecedente antecedente = procesado.buscarAntecedente( 1 );
        assertNotNull( "Debe existir un antecedente con identificador 1.", antecedente );
        assertEquals( "El antecedente debe ser de tipo Consumo de drogas.", Antecedente.CONSUMO_DE_DROGAS, antecedente.darTipo( ) );
        assertEquals( "El antecedente tiene identificador 1.", 1, antecedente.darIdentificador( ) );

        // Caso de prueba 2.
        antecedente = procesado.buscarAntecedente( 4 );
        assertNull( "No existe un antecedente con identificador 4.", antecedente );
    }

    /**
     * Prueba 4: Se encarga de verificar el método condenarProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * condenarProcesado <br>
     * darAnhosCondena <br>
     * <b> Casos de prueba:</b><br>
     * 1. Condena correctamente a un procesado mayor de edad por un delito LEVE. <br>
     * 2. Condena correctamente a un procesado mayor de edad por un delito GRAVE. <br>
     * 3. Condena correctamente a un procesado mayor de edad por un delito MUY_GRAVE. <br>
     */
    public void testCondenarProcesado1( )
    {
        try
        {
            setupEscenario3( );

            // Caso de prueba 1.
            Antecedente antecedente1 = ( Antecedente )procesado.darAntecedentes( ).get( 0 );
            procesado.condenarProcesado( 5, antecedente1.darIdentificador( ) );
            assertEquals( "El procesado debería tener 5 años de condena.", 5, procesado.darAnhosCondena( ) );

            // Caso de prueba 2.
            antecedente1 = ( Antecedente )procesado.darAntecedentes( ).get( 1 );
            procesado.condenarProcesado( 10, antecedente1.darIdentificador( ) );
            assertEquals( "El procesado debería tener 15 años de condena.", 15, procesado.darAnhosCondena( ) );

            // Caso de prueba 3.
            antecedente1 = ( Antecedente )procesado.darAntecedentes( ).get( 2 );
            procesado.condenarProcesado( 16, antecedente1.darIdentificador( ) );
            assertEquals( "El procesado debería tener 21 años de condena.", 31, procesado.darAnhosCondena( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 5: Se encarga de verificar el método condenarProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * condenarProcesado <br>
     * <b> Casos de prueba:</b><br>
     * 1. Trata de condenar a un menor de edad. <br>
     * 2. Se trata de condenar a un mayor de edad con menos de 0 años por una condena LEVE. <br>
     * 3. Se trata de condenar a un mayor de edad con más de 5 años por una condena LEVE. <br>
     * 4. Se trata de condenar a un mayor de edad con menos de 6 años por una condena GRAVE. <br>
     * 5. Se trata de condenar a un mayor de edad con más de 15 años por una condena GRAVE. <br>
     * 6. Se trata de condenar a un mayor de edad con menos de 16 años por una condena MUY_GRAVE.
     */
    public void testCondenarProcesado2( )
    {
        // Caso de prueba 1.
        setupEscenario4( );
        try
        {
            Antecedente antecedente1 = ( Antecedente )procesado.darAntecedentes( ).get( 0 );
            procesado.condenarProcesado( 5, antecedente1.darIdentificador( ) );
            fail( "Debería generar excepción. No se puede condenar a un menor de edad" );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "No se puede condenar a un procesado menor de edad.", e.getMessage( ) );
        }
        
        // Caso de prueba 2.
        setupEscenario3( );
        try
        {
            Antecedente antecedente = ( Antecedente )procesado.darAntecedentes( ).get( 0 );
            procesado.condenarProcesado( -1, antecedente.darIdentificador( ) );
            fail( "Debería generar excepción. No se puede condenar a un procesado con menos de 0 años." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "Por ser un antecedente de gravedad leve, la condena debe ser mayor a 0 años y menor o igual a " + Antecedente.MAXIMO_ANHOS_CONDENA_LEVE + " años.", e.getMessage( ) );
        }
        
        // Caso de prueba 3.
        try
        {
            Antecedente antecedente = ( Antecedente )procesado.darAntecedentes( ).get( 0 );
            procesado.condenarProcesado( 6, antecedente.darIdentificador( ) );
            fail( "Debería generar excepción. No se puede condenar a un procesado por más de 5 años por un delito leve." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "Por ser un antecedente de gravedad leve, la condena debe ser mayor a 0 años y menor o igual a " + Antecedente.MAXIMO_ANHOS_CONDENA_LEVE + " años.", e.getMessage( ) );
        }
        
        // Caso de prueba 4.
        try
        {
            Antecedente antecedente = ( Antecedente )procesado.darAntecedentes( ).get( 1 );
            procesado.condenarProcesado( 5, antecedente.darIdentificador( ) );
            fail( "Debería generar excepción. No se puede condenar a un procesado por menos de 6 años por un delito grave." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "Por ser un antecedente grave, la condena debe ser mayor a " + Antecedente.MAXIMO_ANHOS_CONDENA_LEVE + " años y menor o igual a " + Antecedente.MAXIMO_ANHOS_CONDENA_GRAVE + " años.", e.getMessage( ) );
        }
        
        // Caso de prueba 5.
        try
        {
            Antecedente antecedente = ( Antecedente )procesado.darAntecedentes( ).get( 1 );
            procesado.condenarProcesado( 16, antecedente.darIdentificador( ) );
            fail( "Debería generar excepción. No se puede condenar a un procesado por más de 15 años por un delito grave." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "Por ser un antecedente grave, la condena debe ser mayor a " + Antecedente.MAXIMO_ANHOS_CONDENA_LEVE + " años y menor o igual a " + Antecedente.MAXIMO_ANHOS_CONDENA_GRAVE + " años.", e.getMessage( ) );
        }
        
        // Caso de prueba 6.
        try
        {
            Antecedente antecedente = ( Antecedente )procesado.darAntecedentes( ).get( 2 );
            procesado.condenarProcesado( 15, antecedente.darIdentificador( ) );
            fail( "Debería generar excepción. No se puede condenar a un procesado por menos de 16 años por un delito muy grave." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "Por ser un antecedente muy grave, la condena debe ser mayor o igual a " + Antecedente.MINIMO_ANHOS_CONDENA_MUY_GRAVE + " años.", e.getMessage( ) );
        }
    }
    /**
     * Prueba 6: Se encarga de verificar el método eliminarAntecedente de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarAntecedente <br>
     * eliminarAntecedente <br>
     * darNumeroAntecedentes <br>
     * <b> Casos de prueba:</b><br>
     * 1. Elimina correctamente antecedentes de un procesado.
     */
    public void testEliminarAntecedente1( )
    {

        setupEscenario3( );
        try
        {
            procesado.agregarAntecedente( 4, Antecedente.ECOLOGICO, "Descripción4" );
        }
        catch( Exception e1 )
        {
            fail( "No debería generar excepción." );
        }

        try
        {
            procesado.eliminarAntecedente( 4 );
            assertTrue( "Deben haber 3 antecedentes.", procesado.darNumeroAntecedentes( ) == 3 );

            procesado.eliminarAntecedente( 1 );
            assertTrue( "Deben haber 2 antecedentes", procesado.darNumeroAntecedentes( ) == 2 );
            assertEquals( "El antecedente que queda en la posición 0 debe ser de tipo allanamiento de morada.", Antecedente.ALLANAMIENTO_DE_MORADA, ( ( Antecedente )procesado.darAntecedentes( ).get( 0 ) ).darTipo( ) );
            assertEquals( "El antecedente que queda en la posición 1 debe ser de tipo violencia", Antecedente.VIOLENCIA, ( ( Antecedente )procesado.darAntecedentes( ).get( 1 ) ).darTipo( ) );

        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 7: Se encarga de verificar el método eliminarAntecedente de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAntecedente <br>
     * <b> Casos de prueba:</b><br>
     * 1. Trata de eliminar un antecedente con gravedad GRAVE o MUY_GRAVE.
     */
    public void testEliminarAntecedente2( )
    {
        setupEscenario3( );

        try
        {
            procesado.eliminarAntecedente( 3 );
            fail( "No se debería poder eliminar antecedentes de gravedad" + Antecedente.MUY_GRAVE + "." );
        }
        catch( Exception e )
        {
            assertEquals( "El mensaje de excepción no es correcto.", "No se puede eliminar un antecedente "+ Antecedente.MUY_GRAVE + " o " + Antecedente.GRAVE + "." , e.getMessage( ) );
            assertTrue( "Deben haber 3 antecedentes.", procesado.darAntecedentes( ).size( ) == 3 );
        }
    }

    /**
     * Prueba 8: Se encarga de verificar el método tieneAntecedenteTipo de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * tieneAntecedenteTipo <br>
     * <b> Casos de prueba:</b><br>
     * 1. Tiene los antecedentes buscados. <br>
     * 2. No tiene los antecedentes buscados. <br>
     */
    public void testTieneAntecedenteTipo( )
    {
        setupEscenario3( );
        // Caso de prueba 1.
        assertTrue( "El procesado sí tiene un antecedente de tipo CONSUMO_DE_DROGAS", procesado.tieneAntecedenteTipo( Antecedente.CONSUMO_DE_DROGAS ) );
        assertTrue( "El procesado sí tiene un antecedente de tipo ALLANAMIENTO_DE_MORADA", procesado.tieneAntecedenteTipo( Antecedente.ALLANAMIENTO_DE_MORADA ) );
        assertTrue( "El procesado sí tiene un antecedente de tipo VIOLENCIA", procesado.tieneAntecedenteTipo( Antecedente.VIOLENCIA ) );

        // Caso de prueba 2.
        assertFalse( "El procesado NO tiene un antecedente de tipo ECOLOGICO", procesado.tieneAntecedenteTipo( Antecedente.ECOLOGICO ) );
        assertFalse( "El procesado NO tiene un antecedente de tipo ESTAFA", procesado.tieneAntecedenteTipo( Antecedente.ESTAFA ) );
        assertFalse( "El procesado NO tiene un antecedente de tipo HOMICIDIO", procesado.tieneAntecedenteTipo( Antecedente.HOMICIDIO ) );
        assertFalse( "El procesado NO tiene un antecedente de tipo SECUESTRO", procesado.tieneAntecedenteTipo( Antecedente.SECUESTRO ) );
        assertFalse( "El procesado NO tiene un antecedente de tipo TRAFICO_DE_DROGAS", procesado.tieneAntecedenteTipo( Antecedente.TRAFICO_DE_DROGAS ) );

    }
}