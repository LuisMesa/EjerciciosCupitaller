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

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.sistemaAntecedentes.mundo.Antecedente;
import uniandes.cupi2.sistemaAntecedentes.mundo.Procesado;
import uniandes.cupi2.sistemaAntecedentes.mundo.SistemaAntecedentes;

/**
 * 
 * Clase usada para verificar la correcta implementación de SistemaAntecedentes.
 */
public class SistemaAntecedentesTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private SistemaAntecedentes sistemaAntecedentes;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Crea el sistema de antecedentes sin procesados.
     */
    public void setupEscenario1( )
    {
        sistemaAntecedentes = new SistemaAntecedentes( );
    }

    /**
     * Escenario 2: Crea el sistema de antecedentes con tres procesados.
     */
    public void setupEscenario2( )
    {
        sistemaAntecedentes = new SistemaAntecedentes( );

        try
        {
            // Procesado 1. Mayor de edad. Antecedente LEVE.
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre1", "Apellido1", "Cédula1", Procesado.FEMENINO, 20, 1, Antecedente.ECOLOGICO, "Descripción1" );

            // Procesado 2. Menor de edad. Antecedente GRAVE.
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre2", "Apellido2", "TarjetaIdentidad1", Procesado.MASCULINO, 15, 2, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripción2" );

            // Procesado 3. Mayor de edad. Antecedente MUY_GRAVE.
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre3", "Apellido3", "Cédula2", Procesado.MASCULINO, 35, 3, Antecedente.HOMICIDIO, "Descripción2" );

        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Escenario 3: Crea el sistema de antecedente con tres procesados y varios antecedentes.
     */
    public void setupEscenario3( )
    {
        sistemaAntecedentes = new SistemaAntecedentes( );

        try
        {
            // Procesado 1. Mayor de edad. Antecedente LEVE.
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre1", "Apellido1", "Cédula1", Procesado.FEMENINO, 20, 1, Antecedente.ECOLOGICO, "Descripción1" );

            // Procesado 2. Menor de edad. Antecedente GRAVE.
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre2", "Apellido2", "TarjetaIdentidad1", Procesado.MASCULINO, 15, 2, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripción2" );

            // Procesado 3. Mayor de edad. Antecedente MUY_GRAVE.
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre3", "Apellido3", "Cédula2", Procesado.MASCULINO, 35, 3, Antecedente.HOMICIDIO, "Descripción2" );

            sistemaAntecedentes.agregarAntecedenteAProcesado( "Cédula1", 4, Antecedente.SECUESTRO, "Descripcion1" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "TarjetaIdentidad1", 5, Antecedente.CONSUMO_DE_DROGAS, "Descripcion2" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "TarjetaIdentidad1", 6, Antecedente.HOMICIDIO, "Descripcion2" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "Cédula2", 7, Antecedente.TRANSITO, "Descripcion3" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "Cédula2", 8, Antecedente.TRAFICO_DE_DROGAS, "Descripcion3" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "Cédula2", 9, Antecedente.ROBO, "Descripcion3" );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el método constructor de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * SistemaAntecedentes <br>
     * darProcesados <br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye correctamente el sistema de antecedentes sin procesados. <br>
     * 2. Construye correctamente el sistema de antecedentes con procesados.
     */
    public void testSistemaAntecedentes( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        assertEquals( "No debería haber procesados en el sistema.", 0, sistemaAntecedentes.darProcesados( ).size( ) );

        // Caso de prueba 2.
        setupEscenario2( );
        assertEquals( "Deberían haber 3 procesados en el sistema.", 3, sistemaAntecedentes.darProcesados( ).size( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el método darProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * darProcesado <br>
     * <b> Caso de prueba:</b><br>
     * 1. Retorna correctamente el procesado en la posición dada de la lista.
     */
    public void testDarProcesado( )
    {
        setupEscenario2( );

        try
        {
            Procesado procesado1 = sistemaAntecedentes.darProcesado( 0 );
            assertNotNull( "El procesado debería existir.", procesado1 );
            assertEquals( "El procesado 1 debe tener como número de identficación: Cédula1.", "Cédula1", procesado1.darIdentificacion( ) );

            Procesado procesado2 = sistemaAntecedentes.darProcesado( 1 );
            assertNotNull( "El procesado debería existir.", procesado2 );
            assertEquals( "El procesado 2 debe tener como número de identificación: TarjetaIdentidad1.", "TarjetaIdentidad1", procesado2.darIdentificacion( ) );

            Procesado procesado3 = sistemaAntecedentes.darProcesado( 2 );
            assertNotNull( "El procesado debería existir.", procesado3 );
            assertEquals( "El procesado 3 debe tener como número de identificación: Cédula2.", "Cédula2", procesado3.darIdentificacion( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 2: Se encarga de verificar el método agregarProcesadoYAntecedente de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarProcesadoYAntecedente <br>
     * darProcesados <br>
     * darProcesado <br>
     * <b> Caso de prueba:</b><br>
     * 1. Crea el procesado y su antecedente correctamente.
     */
    public void testAgregarProcesadoYAntecedente1( )
    {
        setupEscenario1( );

        try
        {
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre1", "Apellido1", "Cédula1", Procesado.MASCULINO, 20, 1, Antecedente.CONSUMO_DE_DROGAS, "Descripción1" );
            assertEquals( "Debería haber un procesado en el sistema.", 1, sistemaAntecedentes.darProcesados( ).size( ) );
            Procesado procesado1 = sistemaAntecedentes.darProcesado( 0 );
            assertEquals( "No se retornó correctamente el procesado creado.", "Cédula1", procesado1.darIdentificacion( ) );

            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre2", "Apellido2", "TarjetaIdentidad1", Procesado.FEMENINO, 17, 2, Antecedente.ECOLOGICO, "Descripción2" );
            assertEquals( "Debería haber 2 procesados en el sistema.", 2, sistemaAntecedentes.darProcesados( ).size( ) );
            Procesado procesado2 = sistemaAntecedentes.darProcesado( 1 );
            assertEquals( "No se retornó correctamente el procesado creado.", "TarjetaIdentidad1", procesado2.darIdentificacion( ) );

            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre3", "Apellido3", "Cédula2", Procesado.MASCULINO, 30, 3, Antecedente.HOMICIDIO, "Descripción3" );
            assertEquals( "Deberia haber 3 procesados en el sistema.", 3, sistemaAntecedentes.darProcesados( ).size( ) );
            Procesado procesado3 = sistemaAntecedentes.darProcesado( 2 );
            assertEquals( "No se retornó correctamente el procesado creado.", "Cédula2", procesado3.darIdentificacion( ) );

            for( int i = 1; i <= sistemaAntecedentes.darProcesados( ).size( ); i++ )
            {
                assertEquals( "El nombre del procesado no es correcto.", "Nombre" + i, ( ( Procesado )sistemaAntecedentes.darProcesados( ).get( i - 1 ) ).darNombre( ) );
                assertEquals( "El procesado debe tener un antecedente.", 1, ( ( Procesado )sistemaAntecedentes.darProcesados( ).get( i - 1 ) ).darAntecedentes( ).size( ) );
            }
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 3: Se encarga de verificar el método agregarProcesadoYAntecedente de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarProcesadoYAntecedente <br>
     * <b> Caso de prueba:</b><br>
     * 1. Trata de crear un procesado que ya existe en el sistema. <br>
     * 2. Trata de crear un procesado que no existe en el sistema con un antecedente que ya existe. <br>
     * 3. Trata de crear un procesado con edad menor a la edad mínima. Se cambia la edad, se agrega el procesado y se genera la excepción.
     */
    public void testAgregarProcesadoYAntecedente2( )
    {
        setupEscenario2( );

        // Caso de prueba 1.
        try
        {
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre1", "Apellido1", "Cédula1", Procesado.FEMENINO, 20, 4, Antecedente.ECOLOGICO, "Descripción1" );
            fail( "Debería generar excepción. Ya existe un procesado con el número de identificación dado." );
        }
        catch( Exception e )
        {
            assertEquals( "El mensaje de error es incorrecto.", "Ya existe un procesado con el número de identificación: Cédula1.", e.getMessage( ) );
            assertTrue( "Solo deben haber 3 procesados.", sistemaAntecedentes.darProcesados( ).size( ) == 3 );
        }

        // Caso de prueba 2.
        try
        {
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre4", "Apellido4", "Cédula4", Procesado.FEMENINO, 20, 1, Antecedente.ECOLOGICO, "Descripción1" );
            fail( "Debería generar excepción. Ya existe un antecedente con el identificador dado." );
        }
        catch( Exception e )
        {
            assertEquals( "El mensaje de error es incorrecto.", "El antecedente con identificador 1 ya existe en el sistema.", e.getMessage( ) );
            assertTrue( "Solo deben haber 3 procesados.", sistemaAntecedentes.darProcesados( ).size( ) == 3 );
        }
        
        // Caso de prueba 3.
        try
        {
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre5", "Apellido5", "Cédula5", Procesado.FEMENINO, 2, 5, Antecedente.ECOLOGICO, "Descripción1" );
            fail( "Debería generar excepción. No se puede agregar un procesado menor de " + Procesado.EDAD_MINIMA + " años." );
        }
        catch( Exception e )
        {
            assertTrue( "El mensaje de excepción no es correcto.", e.getMessage( ).contains( "Se cambió la edad del procesado por la edad mínima permitida." ) );
            int posProcesado = sistemaAntecedentes.buscarProcesado( "Cédula5" );
            Procesado procesado = sistemaAntecedentes.darProcesado( posProcesado );
            assertNotNull( "El procesado se debió haber agregado a la lista de procesados.", procesado );
            assertEquals( "La edad del procesado debe ser " + Procesado.EDAD_MINIMA, Procesado.EDAD_MINIMA, procesado.darEdad( ) );
        }
    }

    /**
     * Prueba 4: Se encarga de verificar el método agregarAntecedenteAProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarAntecedenteAProcesado <br>
     * buscarProcesado <br>
     * <b> Caso de prueba:</b><br>
     * 1. Agrega correctamente el antecedente al procesado. <br>
     */
    public void testAgregarAntecedenteAProcesado1( )
    {
        setupEscenario2( );

        try
        {
            sistemaAntecedentes.agregarAntecedenteAProcesado( "Cédula1", 4, Antecedente.ESTAFA, "Descripción2" );
            assertTrue( "El procesado debería tener 2 antecedentes.", sistemaAntecedentes.darProcesado( sistemaAntecedentes.buscarProcesado( "Cédula1" ) ).darAntecedentes( ).size( ) == 2 );

            sistemaAntecedentes.agregarAntecedenteAProcesado( "TarjetaIdentidad1", 5, Antecedente.CONSUMO_DE_DROGAS, "Descripcion2" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "TarjetaIdentidad1", 6, Antecedente.HOMICIDIO, "Descripcion3" );
            assertTrue( "El procesado debería tener 3 antecedentes.", sistemaAntecedentes.darProcesado( sistemaAntecedentes.buscarProcesado( "TarjetaIdentidad1" ) ).darAntecedentes( ).size( ) == 3 );

            sistemaAntecedentes.agregarAntecedenteAProcesado( "Cédula2", 7, Antecedente.TRANSITO, "Descripcion3" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "Cédula2", 8, Antecedente.TRAFICO_DE_DROGAS, "Descripcion3" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "Cédula2", 9, Antecedente.VIOLENCIA, "Descripcion3" );
            assertTrue( "El procesado debería tener 4 antecedentes.", sistemaAntecedentes.darProcesado( sistemaAntecedentes.buscarProcesado( "Cédula2" ) ).darAntecedentes( ).size( ) == 4 );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 5: Se encarga de verificar el método agregarAntecedenteAProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarAntecedenteAProcesado <br>
     * <b> Casos de prueba:</b><br>
     * 1. Trata de agregar un antecedente que ya existe en el sistema.
     */
    public void testAgregarAntecedenteAProcesado2( )
    {
        setupEscenario3( );
        try
        {
            sistemaAntecedentes.agregarAntecedenteAProcesado( "Cédula2", 6, Antecedente.VIOLENCIA, "Descripcion3" );
            fail( "Debería generar excepción. Ya existe un antecedente con ese identificador en el sistema." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de error no es correcto.", "El antecedente con identificador 6 ya existe en el sistema.", e.getMessage( ) );
        }
    }


    /**
     * Prueba 6: Se encarga de verificar el método buscarAntecedente de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarAntecedente <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Busca un antecedente que se encuentra en el sistema. <br>
     * 2. Busca un antecedente que no se encuentra en el sistema.
     */
    public void testBuscarAntecedente( )
    {
        setupEscenario3( );
        
        // Caso de prueba 1.
        Antecedente antecedente = sistemaAntecedentes.buscarAntecedente( 1 );
        assertNotNull( "El antecedente con identificador 1 sí existe en el sistema.", antecedente );
        assertEquals( "El antecedente debería ser de tipo Ecológico.", Antecedente.ECOLOGICO, antecedente.darTipo( ) );
        
        antecedente = sistemaAntecedentes.buscarAntecedente( 8 );
        assertNotNull( "El antecedente con identificador 8 sí existe en el sistema.", antecedente );
        assertEquals( "El antecedente debería ser de tipo Tráfico de Drogas.", Antecedente.TRAFICO_DE_DROGAS, antecedente.darTipo( ) );
        
        // Caso de prueba 2.
        antecedente = sistemaAntecedentes.buscarAntecedente( 10 );
        assertNull( "El antecedente con identidicador 10 no existe en el sistema.", antecedente );

    }

    /**
     * Prueba 7: Se encarga de verificar el método buscarProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarProcesado <br>
     * darProcesado <br>
     * <b> Casos de prueba:</b><br>
     * 1. Busca un procesado que se encuentra en el sistema. <br>
     * 2. Busca un procesado que no se encuentra en el sistema.
     */
    public void testBuscarProcesado( )
    {
        setupEscenario2( );

        // Caso de prueba 1.
        int posProcesado1 = sistemaAntecedentes.buscarProcesado( "Cédula1" );
        Procesado procesado1 = sistemaAntecedentes.darProcesado( posProcesado1 );
        assertNotNull( "El procesado con número de identificación: Cédula1, sí existe en el sistema.", procesado1 );
        assertEquals( "El número de identificación del procesado buscado debe ser: Cédula1", "Cédula1", procesado1.darIdentificacion( ) );

        int posProcesado2 = sistemaAntecedentes.buscarProcesado( "TarjetaIdentidad1" );
        Procesado procesado2 = sistemaAntecedentes.darProcesado( posProcesado2 );
        assertNotNull( "El procesado con número de identificación: TarjetaIdentidad1, sí existe en el sistema.", procesado2 );
        assertEquals( "El número de identificación del procesado buscado debe ser: TarjetaIdentidad1", "TarjetaIdentidad1", procesado2.darIdentificacion( ) );

        // Caso de prueba 2.
        int posProcesado3 = sistemaAntecedentes.buscarProcesado( "TarjetaIdentidad2" );
        assertEquals( "No existe un procesado con número de identidad: TarjetaIdentidad2. El método debe retornar -1.", -1, posProcesado3 );

        int posProcesado4 = sistemaAntecedentes.buscarProcesado( "Cédula3" );
        assertEquals( "No existe un procesado con número de identidad: Cédula3. El método debe retornar -1.", -1, posProcesado4 );

    }

    /**
     * Prueba 8: Se encarga de verificar el método buscarProcesadosPorAntecedente de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarProcesadosPorAntecedente <br>
     * tieneAntecedenteTipo <br>
     * <b> Casos de prueba:</b><br>
     * 1. Retorna el número correcto de procesados con el antecedente dado.
     */
    public void testBuscarProcesadosPorAntecedente1( )
    {
        setupEscenario3( );

        try
        {
            sistemaAntecedentes.agregarAntecedenteAProcesado( "Cédula2", 10, Antecedente.SECUESTRO, "Descripción2" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "TarjetaIdentidad1", 11, Antecedente.HOMICIDIO, "Descripción4" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "TarjetaIdentidad1", 12, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripción5" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "Cédula2", 13, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripción6" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "Cédula1", 14, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripción7" );


            ArrayList resultado = sistemaAntecedentes.buscarProcesadosPorAntecedente( Antecedente.ECOLOGICO );
            assertEquals( "Hay un procesado con antecedentes de tipo Ecológico.", 1, resultado.size( ) );
            for( int i = 0; i < resultado.size( ); i++ )
            {
                Procesado c = ( Procesado )resultado.get( i );
                assertTrue( "El procesado no tiene antecedentes de tipo ECOLOGICO.", c.tieneAntecedenteTipo( Antecedente.ECOLOGICO ) );
            }

            resultado = sistemaAntecedentes.buscarProcesadosPorAntecedente( Antecedente.SECUESTRO );
            assertEquals( "Hay dos procesados con antecedentes de tipo Secuestro.", 2, resultado.size( ) );
            for( int i = 0; i < resultado.size( ); i++ )
            {
                Procesado c = ( Procesado )resultado.get( i );
                assertTrue( "El procesado no tiene antecedentes de tipo Secuestro.", c.tieneAntecedenteTipo( Antecedente.SECUESTRO ) );
            }

            resultado = sistemaAntecedentes.buscarProcesadosPorAntecedente( Antecedente.HOMICIDIO );
            assertEquals( "Hay dos procesados con antecedentes de tipo Homicidio.", 2, resultado.size( ) );
            for( int i = 0; i < resultado.size( ); i++ )
            {
                Procesado c = ( Procesado )resultado.get( i );
                assertTrue( "El procesado no tiene antecedentes de tipo Homicidio.", c.tieneAntecedenteTipo( Antecedente.HOMICIDIO ) );
            }

            resultado = sistemaAntecedentes.buscarProcesadosPorAntecedente( Antecedente.ALLANAMIENTO_DE_MORADA );
            assertEquals( "Hay tres procesados con antecedentes de tipo Allanamiento de morada.", 3, resultado.size( ) );
            for( int i = 0; i < resultado.size( ); i++ )
            {
                Procesado c = ( Procesado )resultado.get( i );
                assertTrue( "El procesado no tiene antecedentes de tipo Allanamiento de morada.", c.tieneAntecedenteTipo( Antecedente.ALLANAMIENTO_DE_MORADA ) );
            }
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el método buscarProcesadosPorAntecedente de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarProcesadosPorAntecedente <br>
     * <b> Casos de prueba:</b><br>
     * 1. Busca procesados por un antecedente que no existe.
     */
    public void testBuscarProcesadosPorAntecdente2( )
    {
        setupEscenario3( );

        try
        {
            sistemaAntecedentes.buscarProcesadosPorAntecedente( Antecedente.ESTAFA );
            fail( "Debería generar excepción. No hay procesados con antecedentes de tipo Estafa." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "No hay procesados con antecedentes de tipo Estafa.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 10: Se encarga de verificar el método buscarProcesadoConMasAntecedentes de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarProcesadoConMasAntecedentes <br>
     * darProcesado.
     * <b> Casos de prueba:</b><br>
     * 1. Encuentra correctamente el procesado con más antecedentes.
     */
    public void testBuscarProcesadoConMasAntecedentes1( )
    {
        setupEscenario3( );

        try
        {
            int posProcesado = sistemaAntecedentes.buscarProcesadoConMasAntecedentes( );
            Procesado procesado = sistemaAntecedentes.darProcesado( posProcesado );
            assertEquals( "El procesado con más antecedentes es el que tiene número de identificación: Cédula2", "Cédula2", procesado.darIdentificacion( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 11: Se encarga de verificar el método buscarProcesadoConMasAntecedentes de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarProcesadoConMasAntecedentes <br>
     * <b> Casos de prueba:</b><br>
     * 1. Busca el procesado con más antecedentes cuando no hay procesados en el sistema.
     */
    public void testBuscarProcesadoConMasAntecedentes2( )
    {
        setupEscenario1( );

        try
        {
            sistemaAntecedentes.buscarProcesadoConMasAntecedentes( );
            fail( "Debería generar excepción. No hay procesados en el sistema." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "No hay procesados en el sistema.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 12: Se encarga de verificar el método buscarProcesadoConMenosAntecedentes de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarProcesadoConMenosAntecedentes <br>
     * darProcesado <br>
     * <b> Casos de prueba:</b><br>
     * 1. Encuentra correctamente el procesado con menos antecedentes.
     */
    public void testBuscarProcesadoConMenosAntecedentes1( )
    {
        setupEscenario3( );

        try
        {
            int posProcesado = sistemaAntecedentes.buscarProcesadoConMenosAntecedentes( );
            Procesado procesado = sistemaAntecedentes.darProcesado( posProcesado );
            assertEquals( "El procesado con menos antecedentes es el que tiene número de identificación: Cédula1", "Cédula1", procesado.darIdentificacion( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 13: Se encarga de verificar el método buscarProcesadoConMenosAntecedentes de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarProcesadoConMenosAntecedentes <br>
     * <b> Casos de prueba:</b><br>
     * 1. Busca el procesado con menos antecedentes cuando no hay procesados en el sistema.
     */
    public void testBuscarProcesadoConMenosAntecedentes2( )
    {
        setupEscenario1( );

        try
        {
            sistemaAntecedentes.buscarProcesadoConMenosAntecedentes( );
            fail( "Debería generar excepción. No hay procesados en el sistema." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "No hay procesados en el sistema.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 14: Se encarga de verificar el método buscarProcesadoConMasAnhosCondena de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarProcesadoConMasAnhosCondena <br>
     * <b> Casos de prueba:</b><br>
     * 1. Busca el procesado mayor de edad con más años de condena.
     */
    public void testBuscarProcesadoConMasAnhosCondena1( )
    {
        setupEscenario2( );
        try
        {
            sistemaAntecedentes.condenarProcesado( "Cédula1", 1, 4 );
            sistemaAntecedentes.condenarProcesado( "Cédula2", 3, 17 );

            int posProcesado = sistemaAntecedentes.buscarProcesadoConMasAnhosCondena( );
            Procesado procesado = sistemaAntecedentes.darProcesado( posProcesado );
            assertEquals( "El procesado con más años de condena es el que tiene número de identificación: Cédula2", "Cédula2", procesado.darIdentificacion( ) );
            assertEquals( "El procesado debe tener 17 años de condena.", 17, procesado.darAnhosCondena( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 15: Se encarga de verificar el método buscarProcesadoConMasAnhosCondena de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarProcesadoYAntecedente <br>
     * buscarProcesadoConMasAnhosCondena <br>
     * <b> Casos de prueba:</b><br>
     * 1. Trata de buscar el procesado con más años de condena cuando solamente hay procesados menores de edad. <br>
     * 2. Trata de buscar el procesado con más años de condena cuando no hay procesados en el sistema.
     */
    public void testBuscarProcesadoConMasAnhosCondena2( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        try
        {
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre2", "Apellido2", "TarjetaIdentidad1", Procesado.MASCULINO, 15, 1, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripción2" );
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre3", "Apellido3", "TaerjetaIdentidad2", Procesado.MASCULINO, 14, 2, Antecedente.HOMICIDIO, "Descripción2" );

            sistemaAntecedentes.buscarProcesadoConMasAnhosCondena( );
            fail( "Debería generar excepción. Solamente hay procesados menores de edad." );

        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "Todos los procesados son menores de edad.", e.getMessage( ) );
        }

        // Caso de prueba 2.
        setupEscenario1( );
        try
        {
            sistemaAntecedentes.buscarProcesadoConMasAnhosCondena( );
            fail( "Debería generar excepción. No hay procesados en el sistema." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "No hay procesados en el sistema.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 16: Se encarga de verificar el método buscarProcesadoConMenosAnhosCondena de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * condenarProcesado <br>
     * buscarProcesadoConMenosAnhosCondena <br>
     * <b> Casos de prueba:</b><br>
     * 1. Busca el procesado mayor de edad con menos años de condena.
     */
    public void testBuscarProcesadoConMenosAnhosCondena1( )
    {
        setupEscenario2( );
        try
        {
            sistemaAntecedentes.condenarProcesado( "Cédula1", 1, 4 );
            sistemaAntecedentes.condenarProcesado( "Cédula2", 3, 17 );

            int posProcesado = sistemaAntecedentes.buscarProcesadoConMenosAnhosCondena( );
            Procesado procesado = sistemaAntecedentes.darProcesado( posProcesado );
            assertEquals( "El procesado con menos años de condena es el que tiene número de identificación: Cédula1", "Cédula1", procesado.darIdentificacion( ) );
            assertEquals( "El procesado debe tener 4 años de condena.", 4, procesado.darAnhosCondena( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 17: Se encarga de verificar el método buscarProcesadoConMenosAnhosCondena de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarProcesadoYAntecedente <br>
     * buscarProcesadoConMenosAnhosCondena <br>
     * <b> Casos de prueba:</b><br>
     * 1. Trata de buscar el procesado con menos años de condena cuando solamente hay procesados menores de edad. <br>
     * 2. Trata de buscar el procesado con menos años de condena cuando no hay procesados en el sistema.
     */
    public void testBuscarProcesadoConMenosAnhosCondena2( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        try
        {
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre2", "Apellido2", "TarjetaIdentidad1", Procesado.MASCULINO, 15, 1, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripción2" );
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre3", "Apellido3", "TaerjetaIdentidad2", Procesado.MASCULINO, 14, 2, Antecedente.HOMICIDIO, "Descripción2" );

            sistemaAntecedentes.buscarProcesadoConMenosAnhosCondena( );
            fail( "Debería generar excepción. Solamente hay procesados menores de edad." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "Todos los procesados son menores de edad.", e.getMessage( ) );
        }

        // Caso de prueba 2.
        setupEscenario1( );
        try
        {
            sistemaAntecedentes.buscarProcesadoConMasAnhosCondena( );
            fail( "Debería generar excepción. No hay procesados en el sistema." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "No hay procesados en el sistema.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 18: Se encarga de verificar el método condenarProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarProcesadoConMenosAnhosCondena <br>
     * buscarProcesado <br>
     * darProcesado <br>
     * <b> Casos de prueba:</b><br>
     * 1. Condena correctamente a un procesado mayor de edad por un delito LEVE. <br>
     * 2. Condena correctamente a un procesado mayor de edad por un delito GRAVE. <br>
     * 3. Condena correctamente a un procesado mayor de edad por un delito MUY_GRAVE. <br>
     */
    public void testCondenarProcesado1( )
    {
        setupEscenario3( );
        try
        {
            // Caso de prueba 1.
            sistemaAntecedentes.condenarProcesado( "Cédula1", 1, 4 );
            int posProcesado = sistemaAntecedentes.buscarProcesado( "Cédula1" );
            Procesado procesado = sistemaAntecedentes.darProcesado( posProcesado );
            assertEquals( "El procesado debería tener 4 años de condena.", 4, procesado.darAnhosCondena( ) );

            // Caso de prueba 2.
            int posProcesado2 = sistemaAntecedentes.buscarProcesado( "Cédula2" );
            Procesado procesado2 = sistemaAntecedentes.darProcesado( posProcesado2 );
            sistemaAntecedentes.condenarProcesado( "Cédula2", 3, 20 );
            assertEquals( "El procesado debería tener 20 años de condena.", 20, procesado2.darAnhosCondena( ) );

            // Caso de prueba 3.
            sistemaAntecedentes.condenarProcesado( "Cédula2", 9, 14 );
            assertEquals( "El procesado debería tener 34 años de condena", 34, procesado2.darAnhosCondena( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 19: Se encarga de verificar el método condenarProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarProcesadoConMenosAnhosCondena <br>
     * buscarProcesado <br>
     * darProcesado <br>
     * <b> Casos de prueba:</b><br>
     * 1. Trata de condena a un procesado menor de edad. <br>
     * 2. Se trata de condenar a un mayor de edad con menos de 0 años por una condena LEVE. <br>
     * 3. Se trata de condenar a un mayor de edad con más de 5 años por una condena LEVE. <br>
     * 4. Se trata de condenar a un mayor de edad con menos de 6 años por una condena GRAVE. <br>
     * 5. Se trata de condenar a un mayor de edad con más de 15 años por una condena GRAVE. <br>
     * 6. Se trata de condenar a un mayor de edad con menos de 16 años por una condena MUY_GRAVE.
     */
    public void testCondenarProcesado2( )
    {
        setupEscenario3( );

        // Caso de prueba 1.
        try
        {
            sistemaAntecedentes.condenarProcesado( "TarjetaIdentidad1", 2, 4 );
            fail( "Debería generar excepción. Está tratando de condenar a un procesado menor de edad." );
        }
        catch( Exception e )
        {
            // Debería generar excepción.
        }

        // Caso de prueba 2.
        try
        {
            sistemaAntecedentes.condenarProcesado( "Cédula1", 1, -2 );
            fail( "Debería generar excepción. No se puede condenar a un procesado con menos de 0 años." );
        }
        catch( Exception e )
        {
            // Debería generar excepción.
        }

        // Caso de prueba 3.
        try
        {
            sistemaAntecedentes.condenarProcesado( "Cédula1", 1, 6 );
            fail( "Debería generar excepción. No se puede condenar a un procesado por más de 5 años por un delito leve." );
        }
        catch( Exception e )
        {
            // Debería generar excepción.
        }

        // Caso de prueba 4.
        try
        {
            sistemaAntecedentes.condenarProcesado( "Cédula2", 9, 5 );
            fail( "Debería generar excepción. No se puede condenar a un procesado por menos de 6 años por un delito grave." );
        }
        catch( Exception e )
        {
            // Debería generar excepción.
        }

        // Caso de prueba 5.
        try
        {
            sistemaAntecedentes.condenarProcesado( "Cédula2", 9, 16 );
            fail( "Debería generar excepción. No se puede condenar a un procesado por más de 15 años por un delito grave." );
        }
        catch( Exception e )
        {
            // Debería generar excepción.
        }

        // Caso de prueba 6.
        try
        {
            sistemaAntecedentes.condenarProcesado( "Cédula2", 3, 15 );
            fail( "Debería generar excepción. No se puede condenar a un procesado por menos de 16 años por un delito muy grave." );
        }
        catch( Exception e )
        {
            // Debería generar excepción.
        }
    }

    /**
     * Prueba 20: Se encarga de verificar el método eliminarProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarProcesado <br>
     * darProcesados <br>
     * <b> Caso de prueba:</b><br>
     * 1. Elimina correctamente un procesado que existe en la lista de procesados. <br>
     */
    public void testEliminarProcesado1( )
    {
        setupEscenario2( );

        try
        {
            sistemaAntecedentes.eliminarProcesado( "Cédula1" );
            sistemaAntecedentes.eliminarProcesado( "Cédula2" );

            assertTrue( "Tiene que haber 1 procesado en el sistema.", sistemaAntecedentes.darProcesados( ).size( ) == 1 );
            assertEquals( "Debe quedar un procesado con número de identificación: TarjetaIdentidad1", "TarjetaIdentidad1", ( ( Procesado )sistemaAntecedentes.darProcesados( ).get( 0 ) ).darIdentificacion( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 21: Se encarga de verificar el método eliminarProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarProcesado <br>
     * darProcesados <br>
     * <b> Caso de prueba:</b><br>
     * 1. Trata de eliminar un procesado que no se encuentra en la lista de procesados. <br>
     */
    public void testEliminarProcesado2( )
    {
        setupEscenario2( );

        try
        {
            sistemaAntecedentes.eliminarProcesado( "Cédula3" );
            fail( "El procesado con número de identificación: Cédula3, no existe." );
        }
        catch( Exception e )
        {
            // Debe generar excepción.
            assertEquals( "El mensaje de excepción no es correcto.", "El procesado con el número de identificación: Cédula3, no se encuentra en el sistema.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 22: Se encarga de verificar el método eliminarAntecedenteProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAntecedenteProcesado <br>
     * darProcesado <br>
     * <b> Caso de prueba:</b><br>
     * 1. Elimina correctamente el antecedente del procesado. <br>
     * 2. Elimina el único antecedente de un procesado. Elimina correctamente el procesado. <br>
     */
    public void testEliminarAntecedente1( )
    {
        try
        {
            // Caso de prueba 1.
            setupEscenario3( );

            sistemaAntecedentes.eliminarAntecedenteProcesado( "Cédula1", 1 );
            assertTrue( "El procesado con número de identidad: Cédula1, debe tener 1 antecedente.", sistemaAntecedentes.darProcesado( sistemaAntecedentes.buscarProcesado( "Cédula1" ) ).darAntecedentes( ).size( ) == 1 );

            sistemaAntecedentes.eliminarAntecedenteProcesado( "TarjetaIdentidad1", 5 );
            assertTrue( "El procesado con número de identidad: TarjetaIdentidad1, debe tener 2 antecedentes.", sistemaAntecedentes.darProcesado( sistemaAntecedentes.buscarProcesado( "TarjetaIdentidad1" ) ).darAntecedentes( ).size( ) == 2 );

            sistemaAntecedentes.eliminarAntecedenteProcesado( "Cédula2", 7 );
            assertTrue( "El procesado con número de identidad: Cédula2, debe tener 3 antecedentes.", sistemaAntecedentes.darProcesado( sistemaAntecedentes.buscarProcesado( "Cédula2" ) ).darAntecedentes( ).size( ) == 3 );

            // Caso de prueba 2.
            setupEscenario2( );

            sistemaAntecedentes.eliminarAntecedenteProcesado( "Cédula1", 1 );
            assertTrue( "Debería haber 2 procesados en el sistema.", sistemaAntecedentes.darProcesados( ).size( ) == 2 );
            assertEquals( "No se eliminó correctamente el procesado.", "TarjetaIdentidad1", ( ( Procesado )sistemaAntecedentes.darProcesados( ).get( 0 ) ).darIdentificacion( ) );
            assertEquals( "No se eliminó correctamente el procesado.", "Cédula2", ( ( Procesado )sistemaAntecedentes.darProcesados( ).get( 1 ) ).darIdentificacion( ) );
        }
        catch( Exception e )
        {
            fail( "No debería generar excepción." );
        }
    }

    /**
     * Prueba 23: Se encarga de verificar el método eliminarAntecedenteProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * eliminarAntecedenteProcesado <br>
     * darProcesados <br>
     * <b> Caso de prueba:</b><br>
     * 1. Trata de eliminar un antecedente de gravedad GRAVE o MUY_GRAVE.
     */
    public void testEliminarAntecedente2( )
    {
        try
        {
            setupEscenario3( );
            sistemaAntecedentes.eliminarAntecedenteProcesado( "Cédula2", 3 );
            fail( "Debería generar excepción. No se puede eliminar un antecedente con gravedad MUY_GRAVE." );
        }
        catch( Exception e )
        {
            assertEquals( "Deberían haber 3 procesados en el sistema.", 3, sistemaAntecedentes.darProcesados( ).size( ) );
        }

        try
        {
            setupEscenario3( );

            sistemaAntecedentes.eliminarAntecedenteProcesado( "TarjetaIdentidad1", 2 );
            fail( "Debería generar excepción. No se puede eliminar un antecedente con gravedad GRAVE." );
        }
        catch( Exception e )
        {
            assertEquals( "Deberían haber 3 procesados en el sistema.", 3, sistemaAntecedentes.darProcesados( ).size( ) );
        }
    }

    /**
     * Prueba 24: Se encarga de verificar el método existeProcesado de la clase. <br>
     * <b> Métodos a probar: </b> <br>
     * existeProcesado <br>
     * <b> Casos de prueba:</b><br>
     * 1. Busca un procesado que existe en la lista de procesados. <br>
     * 2. Busca un procesado que no existe en la lista de procesados.
     */
    public void testExisteProcesado( )
    {
        setupEscenario3( );

        // Caso de prueba 1.
        assertTrue( "El procesado con número de identidad: \"Cédula1\", sí existe.", sistemaAntecedentes.existeProcesado( "Cédula1" ) );
        assertTrue( "El procesado con número de identidad: \"Cédula2\", sí existe.", sistemaAntecedentes.existeProcesado( "Cédula2" ) );
        assertTrue( "El procesado con número de identidad: \"TarjetaIdentidad1\" sí existe.", sistemaAntecedentes.existeProcesado( "TarjetaIdentidad1" ) );

        // Caso de prueba 2.
        assertFalse( "El procesado con número de identidad: \"Cédula4\", no existe.", sistemaAntecedentes.existeProcesado( "Cédula4" ) );
        assertFalse( "El procesado con número de identidad: \"Cédula5\", no existe.", sistemaAntecedentes.existeProcesado( "Cédula5" ) );
        assertFalse( "El procesado con número de identidad: \"Cédula6\", no existe.", sistemaAntecedentes.existeProcesado( "Cédula6" ) );
    }
}