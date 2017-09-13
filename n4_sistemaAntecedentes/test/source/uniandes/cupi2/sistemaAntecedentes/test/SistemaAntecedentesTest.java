/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Clase usada para verificar la correcta implementaci�n de SistemaAntecedentes.
 */
public class SistemaAntecedentesTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private SistemaAntecedentes sistemaAntecedentes;

    // -------------------------------------------------------------
    // M�todos
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
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre1", "Apellido1", "C�dula1", Procesado.FEMENINO, 20, 1, Antecedente.ECOLOGICO, "Descripci�n1" );

            // Procesado 2. Menor de edad. Antecedente GRAVE.
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre2", "Apellido2", "TarjetaIdentidad1", Procesado.MASCULINO, 15, 2, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripci�n2" );

            // Procesado 3. Mayor de edad. Antecedente MUY_GRAVE.
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre3", "Apellido3", "C�dula2", Procesado.MASCULINO, 35, 3, Antecedente.HOMICIDIO, "Descripci�n2" );

        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
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
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre1", "Apellido1", "C�dula1", Procesado.FEMENINO, 20, 1, Antecedente.ECOLOGICO, "Descripci�n1" );

            // Procesado 2. Menor de edad. Antecedente GRAVE.
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre2", "Apellido2", "TarjetaIdentidad1", Procesado.MASCULINO, 15, 2, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripci�n2" );

            // Procesado 3. Mayor de edad. Antecedente MUY_GRAVE.
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre3", "Apellido3", "C�dula2", Procesado.MASCULINO, 35, 3, Antecedente.HOMICIDIO, "Descripci�n2" );

            sistemaAntecedentes.agregarAntecedenteAProcesado( "C�dula1", 4, Antecedente.SECUESTRO, "Descripcion1" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "TarjetaIdentidad1", 5, Antecedente.CONSUMO_DE_DROGAS, "Descripcion2" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "TarjetaIdentidad1", 6, Antecedente.HOMICIDIO, "Descripcion2" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "C�dula2", 7, Antecedente.TRANSITO, "Descripcion3" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "C�dula2", 8, Antecedente.TRAFICO_DE_DROGAS, "Descripcion3" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "C�dula2", 9, Antecedente.ROBO, "Descripcion3" );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }
    }

    /**
     * Prueba 1: Se encarga de verificar el m�todo constructor de la clase. <br>
     * <b> M�todos a probar: </b> <br>
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
        assertEquals( "No deber�a haber procesados en el sistema.", 0, sistemaAntecedentes.darProcesados( ).size( ) );

        // Caso de prueba 2.
        setupEscenario2( );
        assertEquals( "Deber�an haber 3 procesados en el sistema.", 3, sistemaAntecedentes.darProcesados( ).size( ) );
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo darProcesado de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * darProcesado <br>
     * <b> Caso de prueba:</b><br>
     * 1. Retorna correctamente el procesado en la posici�n dada de la lista.
     */
    public void testDarProcesado( )
    {
        setupEscenario2( );

        try
        {
            Procesado procesado1 = sistemaAntecedentes.darProcesado( 0 );
            assertNotNull( "El procesado deber�a existir.", procesado1 );
            assertEquals( "El procesado 1 debe tener como n�mero de identficaci�n: C�dula1.", "C�dula1", procesado1.darIdentificacion( ) );

            Procesado procesado2 = sistemaAntecedentes.darProcesado( 1 );
            assertNotNull( "El procesado deber�a existir.", procesado2 );
            assertEquals( "El procesado 2 debe tener como n�mero de identificaci�n: TarjetaIdentidad1.", "TarjetaIdentidad1", procesado2.darIdentificacion( ) );

            Procesado procesado3 = sistemaAntecedentes.darProcesado( 2 );
            assertNotNull( "El procesado deber�a existir.", procesado3 );
            assertEquals( "El procesado 3 debe tener como n�mero de identificaci�n: C�dula2.", "C�dula2", procesado3.darIdentificacion( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }
    }

    /**
     * Prueba 2: Se encarga de verificar el m�todo agregarProcesadoYAntecedente de la clase. <br>
     * <b> M�todos a probar: </b> <br>
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
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre1", "Apellido1", "C�dula1", Procesado.MASCULINO, 20, 1, Antecedente.CONSUMO_DE_DROGAS, "Descripci�n1" );
            assertEquals( "Deber�a haber un procesado en el sistema.", 1, sistemaAntecedentes.darProcesados( ).size( ) );
            Procesado procesado1 = sistemaAntecedentes.darProcesado( 0 );
            assertEquals( "No se retorn� correctamente el procesado creado.", "C�dula1", procesado1.darIdentificacion( ) );

            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre2", "Apellido2", "TarjetaIdentidad1", Procesado.FEMENINO, 17, 2, Antecedente.ECOLOGICO, "Descripci�n2" );
            assertEquals( "Deber�a haber 2 procesados en el sistema.", 2, sistemaAntecedentes.darProcesados( ).size( ) );
            Procesado procesado2 = sistemaAntecedentes.darProcesado( 1 );
            assertEquals( "No se retorn� correctamente el procesado creado.", "TarjetaIdentidad1", procesado2.darIdentificacion( ) );

            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre3", "Apellido3", "C�dula2", Procesado.MASCULINO, 30, 3, Antecedente.HOMICIDIO, "Descripci�n3" );
            assertEquals( "Deberia haber 3 procesados en el sistema.", 3, sistemaAntecedentes.darProcesados( ).size( ) );
            Procesado procesado3 = sistemaAntecedentes.darProcesado( 2 );
            assertEquals( "No se retorn� correctamente el procesado creado.", "C�dula2", procesado3.darIdentificacion( ) );

            for( int i = 1; i <= sistemaAntecedentes.darProcesados( ).size( ); i++ )
            {
                assertEquals( "El nombre del procesado no es correcto.", "Nombre" + i, ( ( Procesado )sistemaAntecedentes.darProcesados( ).get( i - 1 ) ).darNombre( ) );
                assertEquals( "El procesado debe tener un antecedente.", 1, ( ( Procesado )sistemaAntecedentes.darProcesados( ).get( i - 1 ) ).darAntecedentes( ).size( ) );
            }
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }
    }

    /**
     * Prueba 3: Se encarga de verificar el m�todo agregarProcesadoYAntecedente de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarProcesadoYAntecedente <br>
     * <b> Caso de prueba:</b><br>
     * 1. Trata de crear un procesado que ya existe en el sistema. <br>
     * 2. Trata de crear un procesado que no existe en el sistema con un antecedente que ya existe. <br>
     * 3. Trata de crear un procesado con edad menor a la edad m�nima. Se cambia la edad, se agrega el procesado y se genera la excepci�n.
     */
    public void testAgregarProcesadoYAntecedente2( )
    {
        setupEscenario2( );

        // Caso de prueba 1.
        try
        {
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre1", "Apellido1", "C�dula1", Procesado.FEMENINO, 20, 4, Antecedente.ECOLOGICO, "Descripci�n1" );
            fail( "Deber�a generar excepci�n. Ya existe un procesado con el n�mero de identificaci�n dado." );
        }
        catch( Exception e )
        {
            assertEquals( "El mensaje de error es incorrecto.", "Ya existe un procesado con el n�mero de identificaci�n: C�dula1.", e.getMessage( ) );
            assertTrue( "Solo deben haber 3 procesados.", sistemaAntecedentes.darProcesados( ).size( ) == 3 );
        }

        // Caso de prueba 2.
        try
        {
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre4", "Apellido4", "C�dula4", Procesado.FEMENINO, 20, 1, Antecedente.ECOLOGICO, "Descripci�n1" );
            fail( "Deber�a generar excepci�n. Ya existe un antecedente con el identificador dado." );
        }
        catch( Exception e )
        {
            assertEquals( "El mensaje de error es incorrecto.", "El antecedente con identificador 1 ya existe en el sistema.", e.getMessage( ) );
            assertTrue( "Solo deben haber 3 procesados.", sistemaAntecedentes.darProcesados( ).size( ) == 3 );
        }
        
        // Caso de prueba 3.
        try
        {
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre5", "Apellido5", "C�dula5", Procesado.FEMENINO, 2, 5, Antecedente.ECOLOGICO, "Descripci�n1" );
            fail( "Deber�a generar excepci�n. No se puede agregar un procesado menor de " + Procesado.EDAD_MINIMA + " a�os." );
        }
        catch( Exception e )
        {
            assertTrue( "El mensaje de excepci�n no es correcto.", e.getMessage( ).contains( "Se cambi� la edad del procesado por la edad m�nima permitida." ) );
            int posProcesado = sistemaAntecedentes.buscarProcesado( "C�dula5" );
            Procesado procesado = sistemaAntecedentes.darProcesado( posProcesado );
            assertNotNull( "El procesado se debi� haber agregado a la lista de procesados.", procesado );
            assertEquals( "La edad del procesado debe ser " + Procesado.EDAD_MINIMA, Procesado.EDAD_MINIMA, procesado.darEdad( ) );
        }
    }

    /**
     * Prueba 4: Se encarga de verificar el m�todo agregarAntecedenteAProcesado de la clase. <br>
     * <b> M�todos a probar: </b> <br>
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
            sistemaAntecedentes.agregarAntecedenteAProcesado( "C�dula1", 4, Antecedente.ESTAFA, "Descripci�n2" );
            assertTrue( "El procesado deber�a tener 2 antecedentes.", sistemaAntecedentes.darProcesado( sistemaAntecedentes.buscarProcesado( "C�dula1" ) ).darAntecedentes( ).size( ) == 2 );

            sistemaAntecedentes.agregarAntecedenteAProcesado( "TarjetaIdentidad1", 5, Antecedente.CONSUMO_DE_DROGAS, "Descripcion2" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "TarjetaIdentidad1", 6, Antecedente.HOMICIDIO, "Descripcion3" );
            assertTrue( "El procesado deber�a tener 3 antecedentes.", sistemaAntecedentes.darProcesado( sistemaAntecedentes.buscarProcesado( "TarjetaIdentidad1" ) ).darAntecedentes( ).size( ) == 3 );

            sistemaAntecedentes.agregarAntecedenteAProcesado( "C�dula2", 7, Antecedente.TRANSITO, "Descripcion3" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "C�dula2", 8, Antecedente.TRAFICO_DE_DROGAS, "Descripcion3" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "C�dula2", 9, Antecedente.VIOLENCIA, "Descripcion3" );
            assertTrue( "El procesado deber�a tener 4 antecedentes.", sistemaAntecedentes.darProcesado( sistemaAntecedentes.buscarProcesado( "C�dula2" ) ).darAntecedentes( ).size( ) == 4 );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }
    }

    /**
     * Prueba 5: Se encarga de verificar el m�todo agregarAntecedenteAProcesado de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarAntecedenteAProcesado <br>
     * <b> Casos de prueba:</b><br>
     * 1. Trata de agregar un antecedente que ya existe en el sistema.
     */
    public void testAgregarAntecedenteAProcesado2( )
    {
        setupEscenario3( );
        try
        {
            sistemaAntecedentes.agregarAntecedenteAProcesado( "C�dula2", 6, Antecedente.VIOLENCIA, "Descripcion3" );
            fail( "Deber�a generar excepci�n. Ya existe un antecedente con ese identificador en el sistema." );
        }
        catch( Exception e )
        {
            // Debe generar excepci�n.
            assertEquals( "El mensaje de error no es correcto.", "El antecedente con identificador 6 ya existe en el sistema.", e.getMessage( ) );
        }
    }


    /**
     * Prueba 6: Se encarga de verificar el m�todo buscarAntecedente de la clase. <br>
     * <b> M�todos a probar: </b> <br>
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
        assertNotNull( "El antecedente con identificador 1 s� existe en el sistema.", antecedente );
        assertEquals( "El antecedente deber�a ser de tipo Ecol�gico.", Antecedente.ECOLOGICO, antecedente.darTipo( ) );
        
        antecedente = sistemaAntecedentes.buscarAntecedente( 8 );
        assertNotNull( "El antecedente con identificador 8 s� existe en el sistema.", antecedente );
        assertEquals( "El antecedente deber�a ser de tipo Tr�fico de Drogas.", Antecedente.TRAFICO_DE_DROGAS, antecedente.darTipo( ) );
        
        // Caso de prueba 2.
        antecedente = sistemaAntecedentes.buscarAntecedente( 10 );
        assertNull( "El antecedente con identidicador 10 no existe en el sistema.", antecedente );

    }

    /**
     * Prueba 7: Se encarga de verificar el m�todo buscarProcesado de la clase. <br>
     * <b> M�todos a probar: </b> <br>
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
        int posProcesado1 = sistemaAntecedentes.buscarProcesado( "C�dula1" );
        Procesado procesado1 = sistemaAntecedentes.darProcesado( posProcesado1 );
        assertNotNull( "El procesado con n�mero de identificaci�n: C�dula1, s� existe en el sistema.", procesado1 );
        assertEquals( "El n�mero de identificaci�n del procesado buscado debe ser: C�dula1", "C�dula1", procesado1.darIdentificacion( ) );

        int posProcesado2 = sistemaAntecedentes.buscarProcesado( "TarjetaIdentidad1" );
        Procesado procesado2 = sistemaAntecedentes.darProcesado( posProcesado2 );
        assertNotNull( "El procesado con n�mero de identificaci�n: TarjetaIdentidad1, s� existe en el sistema.", procesado2 );
        assertEquals( "El n�mero de identificaci�n del procesado buscado debe ser: TarjetaIdentidad1", "TarjetaIdentidad1", procesado2.darIdentificacion( ) );

        // Caso de prueba 2.
        int posProcesado3 = sistemaAntecedentes.buscarProcesado( "TarjetaIdentidad2" );
        assertEquals( "No existe un procesado con n�mero de identidad: TarjetaIdentidad2. El m�todo debe retornar -1.", -1, posProcesado3 );

        int posProcesado4 = sistemaAntecedentes.buscarProcesado( "C�dula3" );
        assertEquals( "No existe un procesado con n�mero de identidad: C�dula3. El m�todo debe retornar -1.", -1, posProcesado4 );

    }

    /**
     * Prueba 8: Se encarga de verificar el m�todo buscarProcesadosPorAntecedente de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarProcesadosPorAntecedente <br>
     * tieneAntecedenteTipo <br>
     * <b> Casos de prueba:</b><br>
     * 1. Retorna el n�mero correcto de procesados con el antecedente dado.
     */
    public void testBuscarProcesadosPorAntecedente1( )
    {
        setupEscenario3( );

        try
        {
            sistemaAntecedentes.agregarAntecedenteAProcesado( "C�dula2", 10, Antecedente.SECUESTRO, "Descripci�n2" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "TarjetaIdentidad1", 11, Antecedente.HOMICIDIO, "Descripci�n4" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "TarjetaIdentidad1", 12, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripci�n5" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "C�dula2", 13, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripci�n6" );
            sistemaAntecedentes.agregarAntecedenteAProcesado( "C�dula1", 14, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripci�n7" );


            ArrayList resultado = sistemaAntecedentes.buscarProcesadosPorAntecedente( Antecedente.ECOLOGICO );
            assertEquals( "Hay un procesado con antecedentes de tipo Ecol�gico.", 1, resultado.size( ) );
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
            fail( "No deber�a generar excepci�n." );
        }
    }

    /**
     * Prueba 9: Se encarga de verificar el m�todo buscarProcesadosPorAntecedente de la clase. <br>
     * <b> M�todos a probar: </b> <br>
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
            fail( "Deber�a generar excepci�n. No hay procesados con antecedentes de tipo Estafa." );
        }
        catch( Exception e )
        {
            // Debe generar excepci�n.
            assertEquals( "El mensaje de excepci�n no es correcto.", "No hay procesados con antecedentes de tipo Estafa.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 10: Se encarga de verificar el m�todo buscarProcesadoConMasAntecedentes de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarProcesadoConMasAntecedentes <br>
     * darProcesado.
     * <b> Casos de prueba:</b><br>
     * 1. Encuentra correctamente el procesado con m�s antecedentes.
     */
    public void testBuscarProcesadoConMasAntecedentes1( )
    {
        setupEscenario3( );

        try
        {
            int posProcesado = sistemaAntecedentes.buscarProcesadoConMasAntecedentes( );
            Procesado procesado = sistemaAntecedentes.darProcesado( posProcesado );
            assertEquals( "El procesado con m�s antecedentes es el que tiene n�mero de identificaci�n: C�dula2", "C�dula2", procesado.darIdentificacion( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }
    }

    /**
     * Prueba 11: Se encarga de verificar el m�todo buscarProcesadoConMasAntecedentes de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarProcesadoConMasAntecedentes <br>
     * <b> Casos de prueba:</b><br>
     * 1. Busca el procesado con m�s antecedentes cuando no hay procesados en el sistema.
     */
    public void testBuscarProcesadoConMasAntecedentes2( )
    {
        setupEscenario1( );

        try
        {
            sistemaAntecedentes.buscarProcesadoConMasAntecedentes( );
            fail( "Deber�a generar excepci�n. No hay procesados en el sistema." );
        }
        catch( Exception e )
        {
            // Debe generar excepci�n.
            assertEquals( "El mensaje de excepci�n no es correcto.", "No hay procesados en el sistema.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 12: Se encarga de verificar el m�todo buscarProcesadoConMenosAntecedentes de la clase. <br>
     * <b> M�todos a probar: </b> <br>
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
            assertEquals( "El procesado con menos antecedentes es el que tiene n�mero de identificaci�n: C�dula1", "C�dula1", procesado.darIdentificacion( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }
    }

    /**
     * Prueba 13: Se encarga de verificar el m�todo buscarProcesadoConMenosAntecedentes de la clase. <br>
     * <b> M�todos a probar: </b> <br>
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
            fail( "Deber�a generar excepci�n. No hay procesados en el sistema." );
        }
        catch( Exception e )
        {
            // Debe generar excepci�n.
            assertEquals( "El mensaje de excepci�n no es correcto.", "No hay procesados en el sistema.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 14: Se encarga de verificar el m�todo buscarProcesadoConMasAnhosCondena de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarProcesadoConMasAnhosCondena <br>
     * <b> Casos de prueba:</b><br>
     * 1. Busca el procesado mayor de edad con m�s a�os de condena.
     */
    public void testBuscarProcesadoConMasAnhosCondena1( )
    {
        setupEscenario2( );
        try
        {
            sistemaAntecedentes.condenarProcesado( "C�dula1", 1, 4 );
            sistemaAntecedentes.condenarProcesado( "C�dula2", 3, 17 );

            int posProcesado = sistemaAntecedentes.buscarProcesadoConMasAnhosCondena( );
            Procesado procesado = sistemaAntecedentes.darProcesado( posProcesado );
            assertEquals( "El procesado con m�s a�os de condena es el que tiene n�mero de identificaci�n: C�dula2", "C�dula2", procesado.darIdentificacion( ) );
            assertEquals( "El procesado debe tener 17 a�os de condena.", 17, procesado.darAnhosCondena( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }
    }

    /**
     * Prueba 15: Se encarga de verificar el m�todo buscarProcesadoConMasAnhosCondena de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarProcesadoYAntecedente <br>
     * buscarProcesadoConMasAnhosCondena <br>
     * <b> Casos de prueba:</b><br>
     * 1. Trata de buscar el procesado con m�s a�os de condena cuando solamente hay procesados menores de edad. <br>
     * 2. Trata de buscar el procesado con m�s a�os de condena cuando no hay procesados en el sistema.
     */
    public void testBuscarProcesadoConMasAnhosCondena2( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        try
        {
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre2", "Apellido2", "TarjetaIdentidad1", Procesado.MASCULINO, 15, 1, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripci�n2" );
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre3", "Apellido3", "TaerjetaIdentidad2", Procesado.MASCULINO, 14, 2, Antecedente.HOMICIDIO, "Descripci�n2" );

            sistemaAntecedentes.buscarProcesadoConMasAnhosCondena( );
            fail( "Deber�a generar excepci�n. Solamente hay procesados menores de edad." );

        }
        catch( Exception e )
        {
            // Debe generar excepci�n.
            assertEquals( "El mensaje de excepci�n no es correcto.", "Todos los procesados son menores de edad.", e.getMessage( ) );
        }

        // Caso de prueba 2.
        setupEscenario1( );
        try
        {
            sistemaAntecedentes.buscarProcesadoConMasAnhosCondena( );
            fail( "Deber�a generar excepci�n. No hay procesados en el sistema." );
        }
        catch( Exception e )
        {
            // Debe generar excepci�n.
            assertEquals( "El mensaje de excepci�n no es correcto.", "No hay procesados en el sistema.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 16: Se encarga de verificar el m�todo buscarProcesadoConMenosAnhosCondena de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * condenarProcesado <br>
     * buscarProcesadoConMenosAnhosCondena <br>
     * <b> Casos de prueba:</b><br>
     * 1. Busca el procesado mayor de edad con menos a�os de condena.
     */
    public void testBuscarProcesadoConMenosAnhosCondena1( )
    {
        setupEscenario2( );
        try
        {
            sistemaAntecedentes.condenarProcesado( "C�dula1", 1, 4 );
            sistemaAntecedentes.condenarProcesado( "C�dula2", 3, 17 );

            int posProcesado = sistemaAntecedentes.buscarProcesadoConMenosAnhosCondena( );
            Procesado procesado = sistemaAntecedentes.darProcesado( posProcesado );
            assertEquals( "El procesado con menos a�os de condena es el que tiene n�mero de identificaci�n: C�dula1", "C�dula1", procesado.darIdentificacion( ) );
            assertEquals( "El procesado debe tener 4 a�os de condena.", 4, procesado.darAnhosCondena( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }
    }

    /**
     * Prueba 17: Se encarga de verificar el m�todo buscarProcesadoConMenosAnhosCondena de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarProcesadoYAntecedente <br>
     * buscarProcesadoConMenosAnhosCondena <br>
     * <b> Casos de prueba:</b><br>
     * 1. Trata de buscar el procesado con menos a�os de condena cuando solamente hay procesados menores de edad. <br>
     * 2. Trata de buscar el procesado con menos a�os de condena cuando no hay procesados en el sistema.
     */
    public void testBuscarProcesadoConMenosAnhosCondena2( )
    {
        // Caso de prueba 1.
        setupEscenario1( );
        try
        {
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre2", "Apellido2", "TarjetaIdentidad1", Procesado.MASCULINO, 15, 1, Antecedente.ALLANAMIENTO_DE_MORADA, "Descripci�n2" );
            sistemaAntecedentes.agregarProcesadoYAntecedente( "Nombre3", "Apellido3", "TaerjetaIdentidad2", Procesado.MASCULINO, 14, 2, Antecedente.HOMICIDIO, "Descripci�n2" );

            sistemaAntecedentes.buscarProcesadoConMenosAnhosCondena( );
            fail( "Deber�a generar excepci�n. Solamente hay procesados menores de edad." );
        }
        catch( Exception e )
        {
            // Debe generar excepci�n.
            assertEquals( "El mensaje de excepci�n no es correcto.", "Todos los procesados son menores de edad.", e.getMessage( ) );
        }

        // Caso de prueba 2.
        setupEscenario1( );
        try
        {
            sistemaAntecedentes.buscarProcesadoConMasAnhosCondena( );
            fail( "Deber�a generar excepci�n. No hay procesados en el sistema." );
        }
        catch( Exception e )
        {
            // Debe generar excepci�n.
            assertEquals( "El mensaje de excepci�n no es correcto.", "No hay procesados en el sistema.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 18: Se encarga de verificar el m�todo condenarProcesado de la clase. <br>
     * <b> M�todos a probar: </b> <br>
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
            sistemaAntecedentes.condenarProcesado( "C�dula1", 1, 4 );
            int posProcesado = sistemaAntecedentes.buscarProcesado( "C�dula1" );
            Procesado procesado = sistemaAntecedentes.darProcesado( posProcesado );
            assertEquals( "El procesado deber�a tener 4 a�os de condena.", 4, procesado.darAnhosCondena( ) );

            // Caso de prueba 2.
            int posProcesado2 = sistemaAntecedentes.buscarProcesado( "C�dula2" );
            Procesado procesado2 = sistemaAntecedentes.darProcesado( posProcesado2 );
            sistemaAntecedentes.condenarProcesado( "C�dula2", 3, 20 );
            assertEquals( "El procesado deber�a tener 20 a�os de condena.", 20, procesado2.darAnhosCondena( ) );

            // Caso de prueba 3.
            sistemaAntecedentes.condenarProcesado( "C�dula2", 9, 14 );
            assertEquals( "El procesado deber�a tener 34 a�os de condena", 34, procesado2.darAnhosCondena( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }
    }

    /**
     * Prueba 19: Se encarga de verificar el m�todo condenarProcesado de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarProcesadoConMenosAnhosCondena <br>
     * buscarProcesado <br>
     * darProcesado <br>
     * <b> Casos de prueba:</b><br>
     * 1. Trata de condena a un procesado menor de edad. <br>
     * 2. Se trata de condenar a un mayor de edad con menos de 0 a�os por una condena LEVE. <br>
     * 3. Se trata de condenar a un mayor de edad con m�s de 5 a�os por una condena LEVE. <br>
     * 4. Se trata de condenar a un mayor de edad con menos de 6 a�os por una condena GRAVE. <br>
     * 5. Se trata de condenar a un mayor de edad con m�s de 15 a�os por una condena GRAVE. <br>
     * 6. Se trata de condenar a un mayor de edad con menos de 16 a�os por una condena MUY_GRAVE.
     */
    public void testCondenarProcesado2( )
    {
        setupEscenario3( );

        // Caso de prueba 1.
        try
        {
            sistemaAntecedentes.condenarProcesado( "TarjetaIdentidad1", 2, 4 );
            fail( "Deber�a generar excepci�n. Est� tratando de condenar a un procesado menor de edad." );
        }
        catch( Exception e )
        {
            // Deber�a generar excepci�n.
        }

        // Caso de prueba 2.
        try
        {
            sistemaAntecedentes.condenarProcesado( "C�dula1", 1, -2 );
            fail( "Deber�a generar excepci�n. No se puede condenar a un procesado con menos de 0 a�os." );
        }
        catch( Exception e )
        {
            // Deber�a generar excepci�n.
        }

        // Caso de prueba 3.
        try
        {
            sistemaAntecedentes.condenarProcesado( "C�dula1", 1, 6 );
            fail( "Deber�a generar excepci�n. No se puede condenar a un procesado por m�s de 5 a�os por un delito leve." );
        }
        catch( Exception e )
        {
            // Deber�a generar excepci�n.
        }

        // Caso de prueba 4.
        try
        {
            sistemaAntecedentes.condenarProcesado( "C�dula2", 9, 5 );
            fail( "Deber�a generar excepci�n. No se puede condenar a un procesado por menos de 6 a�os por un delito grave." );
        }
        catch( Exception e )
        {
            // Deber�a generar excepci�n.
        }

        // Caso de prueba 5.
        try
        {
            sistemaAntecedentes.condenarProcesado( "C�dula2", 9, 16 );
            fail( "Deber�a generar excepci�n. No se puede condenar a un procesado por m�s de 15 a�os por un delito grave." );
        }
        catch( Exception e )
        {
            // Deber�a generar excepci�n.
        }

        // Caso de prueba 6.
        try
        {
            sistemaAntecedentes.condenarProcesado( "C�dula2", 3, 15 );
            fail( "Deber�a generar excepci�n. No se puede condenar a un procesado por menos de 16 a�os por un delito muy grave." );
        }
        catch( Exception e )
        {
            // Deber�a generar excepci�n.
        }
    }

    /**
     * Prueba 20: Se encarga de verificar el m�todo eliminarProcesado de la clase. <br>
     * <b> M�todos a probar: </b> <br>
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
            sistemaAntecedentes.eliminarProcesado( "C�dula1" );
            sistemaAntecedentes.eliminarProcesado( "C�dula2" );

            assertTrue( "Tiene que haber 1 procesado en el sistema.", sistemaAntecedentes.darProcesados( ).size( ) == 1 );
            assertEquals( "Debe quedar un procesado con n�mero de identificaci�n: TarjetaIdentidad1", "TarjetaIdentidad1", ( ( Procesado )sistemaAntecedentes.darProcesados( ).get( 0 ) ).darIdentificacion( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }
    }

    /**
     * Prueba 21: Se encarga de verificar el m�todo eliminarProcesado de la clase. <br>
     * <b> M�todos a probar: </b> <br>
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
            sistemaAntecedentes.eliminarProcesado( "C�dula3" );
            fail( "El procesado con n�mero de identificaci�n: C�dula3, no existe." );
        }
        catch( Exception e )
        {
            // Debe generar excepci�n.
            assertEquals( "El mensaje de excepci�n no es correcto.", "El procesado con el n�mero de identificaci�n: C�dula3, no se encuentra en el sistema.", e.getMessage( ) );
        }
    }

    /**
     * Prueba 22: Se encarga de verificar el m�todo eliminarAntecedenteProcesado de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * eliminarAntecedenteProcesado <br>
     * darProcesado <br>
     * <b> Caso de prueba:</b><br>
     * 1. Elimina correctamente el antecedente del procesado. <br>
     * 2. Elimina el �nico antecedente de un procesado. Elimina correctamente el procesado. <br>
     */
    public void testEliminarAntecedente1( )
    {
        try
        {
            // Caso de prueba 1.
            setupEscenario3( );

            sistemaAntecedentes.eliminarAntecedenteProcesado( "C�dula1", 1 );
            assertTrue( "El procesado con n�mero de identidad: C�dula1, debe tener 1 antecedente.", sistemaAntecedentes.darProcesado( sistemaAntecedentes.buscarProcesado( "C�dula1" ) ).darAntecedentes( ).size( ) == 1 );

            sistemaAntecedentes.eliminarAntecedenteProcesado( "TarjetaIdentidad1", 5 );
            assertTrue( "El procesado con n�mero de identidad: TarjetaIdentidad1, debe tener 2 antecedentes.", sistemaAntecedentes.darProcesado( sistemaAntecedentes.buscarProcesado( "TarjetaIdentidad1" ) ).darAntecedentes( ).size( ) == 2 );

            sistemaAntecedentes.eliminarAntecedenteProcesado( "C�dula2", 7 );
            assertTrue( "El procesado con n�mero de identidad: C�dula2, debe tener 3 antecedentes.", sistemaAntecedentes.darProcesado( sistemaAntecedentes.buscarProcesado( "C�dula2" ) ).darAntecedentes( ).size( ) == 3 );

            // Caso de prueba 2.
            setupEscenario2( );

            sistemaAntecedentes.eliminarAntecedenteProcesado( "C�dula1", 1 );
            assertTrue( "Deber�a haber 2 procesados en el sistema.", sistemaAntecedentes.darProcesados( ).size( ) == 2 );
            assertEquals( "No se elimin� correctamente el procesado.", "TarjetaIdentidad1", ( ( Procesado )sistemaAntecedentes.darProcesados( ).get( 0 ) ).darIdentificacion( ) );
            assertEquals( "No se elimin� correctamente el procesado.", "C�dula2", ( ( Procesado )sistemaAntecedentes.darProcesados( ).get( 1 ) ).darIdentificacion( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a generar excepci�n." );
        }
    }

    /**
     * Prueba 23: Se encarga de verificar el m�todo eliminarAntecedenteProcesado de la clase. <br>
     * <b> M�todos a probar: </b> <br>
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
            sistemaAntecedentes.eliminarAntecedenteProcesado( "C�dula2", 3 );
            fail( "Deber�a generar excepci�n. No se puede eliminar un antecedente con gravedad MUY_GRAVE." );
        }
        catch( Exception e )
        {
            assertEquals( "Deber�an haber 3 procesados en el sistema.", 3, sistemaAntecedentes.darProcesados( ).size( ) );
        }

        try
        {
            setupEscenario3( );

            sistemaAntecedentes.eliminarAntecedenteProcesado( "TarjetaIdentidad1", 2 );
            fail( "Deber�a generar excepci�n. No se puede eliminar un antecedente con gravedad GRAVE." );
        }
        catch( Exception e )
        {
            assertEquals( "Deber�an haber 3 procesados en el sistema.", 3, sistemaAntecedentes.darProcesados( ).size( ) );
        }
    }

    /**
     * Prueba 24: Se encarga de verificar el m�todo existeProcesado de la clase. <br>
     * <b> M�todos a probar: </b> <br>
     * existeProcesado <br>
     * <b> Casos de prueba:</b><br>
     * 1. Busca un procesado que existe en la lista de procesados. <br>
     * 2. Busca un procesado que no existe en la lista de procesados.
     */
    public void testExisteProcesado( )
    {
        setupEscenario3( );

        // Caso de prueba 1.
        assertTrue( "El procesado con n�mero de identidad: \"C�dula1\", s� existe.", sistemaAntecedentes.existeProcesado( "C�dula1" ) );
        assertTrue( "El procesado con n�mero de identidad: \"C�dula2\", s� existe.", sistemaAntecedentes.existeProcesado( "C�dula2" ) );
        assertTrue( "El procesado con n�mero de identidad: \"TarjetaIdentidad1\" s� existe.", sistemaAntecedentes.existeProcesado( "TarjetaIdentidad1" ) );

        // Caso de prueba 2.
        assertFalse( "El procesado con n�mero de identidad: \"C�dula4\", no existe.", sistemaAntecedentes.existeProcesado( "C�dula4" ) );
        assertFalse( "El procesado con n�mero de identidad: \"C�dula5\", no existe.", sistemaAntecedentes.existeProcesado( "C�dula5" ) );
        assertFalse( "El procesado con n�mero de identidad: \"C�dula6\", no existe.", sistemaAntecedentes.existeProcesado( "C�dula6" ) );
    }
}