/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n2_empresa
 * Autor: EquipoCupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.empresa.test;

import junit.framework.TestCase;
import uniandes.cupi2.empresa.mundo.Empleado;

/**
 * Clase usada para verificar que los métodos de la clase Empleado estén correctamente implementados.
 */
public class EmpleadoTest extends TestCase
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Clase de pruebas.
     */
    private Empleado empleado;
    
    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo Empleado.
     */
    private void setupEscenario1( )
    {
        empleado = new Empleado( "Germán", 24, 2, 12000, Empleado.SEGURIDAD, "imagen1" );
    }

    /**
     * Prueba 1: Método que se encarga de verificar el método constructor.
     * <b> Métodos a probar: </b> <br>
     * Empleado<br>
     * darNombre<br>
     * darEdad<br>
     * darAntiguedad<br>
     * darSalario<br>
     * darArea<br>
     * darImagen<br>
     * <b> Caso de prueba 1: </b> <br>
     * Los valores del empleado corresponden a los del constructor.
     */
    public void testEmpleado( )
    {
        setupEscenario1( );
        assertNotNull( "El empleado no debería ser nulo.", empleado );
        assertEquals( "El nombre del empleado no corresponde.", "Germán", empleado.darNombre( ) );
        assertEquals( "La edad del empleado no corresponde.", 24, empleado.darEdad( ) );
        assertEquals( "La antigüedad del empleado no corresponde.", 2, empleado.darAntiguedad( ) );
        assertEquals( "El salario del empleado no corresponde.", 12000, empleado.darSalario( ) );
        assertEquals( "El área del empleado no corresponde.", Empleado.SEGURIDAD, empleado.darArea( ) );
        assertEquals( "La imagen del empleado no corresponde.", "imagen1", empleado.darImagen( ) );
        
    }

    /**
     * Prueba 2: Método que se encarga de verificar el método calcularPrestaciones.
     * <b> Métodos a probar: </b> <br>
     * calcularPrestaciones<br>
     * <b> Caso de prueba 1: </b> <br>
     * Las prestaciones del empleado son calculadas correctamente.
     */
    public void testCalcularPrestaciones( )
    {
        setupEscenario1( );
        assertEquals( "Las prestaciones del empleado no corresponden.", 1800.0, empleado.calcularPrestaciones( ) );
    }

    /**
     * Prueba 3: Método que se encarga de verificar el método cambiarSalario.
     * <b> Métodos a probar: </b> <br>
     * cambiarSalario<br>
     * darSalario<br>
     * <b> Caso de prueba 1: </b> <br>
     * Se cambia el salario del empleado 1.
     */
    public void testCambiarSalario( )
    {
        setupEscenario1( );

        empleado.cambiarSalario( 50000 );
        assertEquals( "El salario del empleado no corresponde.", 50000, empleado.darSalario( ) );

    }
}
