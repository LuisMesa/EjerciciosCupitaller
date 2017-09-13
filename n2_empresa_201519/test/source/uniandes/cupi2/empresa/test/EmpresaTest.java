/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
import uniandes.cupi2.empresa.mundo.Empresa;


/**
 * Clase usada para verificar que los m�todos de la clase Empresa est�n correctamente implementados.
 */
public class EmpresaTest extends TestCase
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Clase de pruebas.
     */
    private Empresa empresa;
    
    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------
    
    /**
     * Escenario 1: Construye una nueva empresa con 4 empleados.
     */
    private void setupEscenario1( )
    {
        empresa = new Empresa( );
    }
    
    /**
     * Prueba 1: M�todo que se encarga de verificar el m�todo constructor.
     * <b> M�todos a probar: </b> <br>
     * Empresa<br>
     * darEmpleado1<br>
     * darEmpleado2<br>
     * darEmpleado3<br>
     * darEmpleado4<br>
     * <b> Caso de prueba 1: </b> <br>
     * Los cuatro empleados son creados correctamente.
     */
    public void testEmpresa( )
    {
        setupEscenario1( );
        assertNotNull( "El empleado 1 no deber�a ser nulo.", empresa.darEmpleado1( ) );
        assertNotNull( "El empleado 2 no deber�a ser nulo.", empresa.darEmpleado2( ) );
        assertNotNull( "El empleado 3 no deber�a ser nulo.", empresa.darEmpleado3( ) );
        assertNotNull( "El empleado 4 no deber�a ser nulo.", empresa.darEmpleado4( ) );
        
        // Empleado 1
        assertEquals( "El nombre del empleado 1 no corresponde.", "Germ�n", empresa.darEmpleado1( ).darNombre( ) );
        assertEquals( "La edad del empleado 1 no corresponde.", 24, empresa.darEmpleado1( ).darEdad( ) );
        assertEquals( "La antig�edad del empleado 1 no corresponde.", 2, empresa.darEmpleado1( ).darAntiguedad( ) );
        assertEquals( "El salario del empleado 1 no corresponde.", 9000, empresa.darEmpleado1( ).darSalario( ) );
        assertEquals( "El �rea del empleado 1 no corresponde.", Empleado.SEGURIDAD, empresa.darEmpleado1( ).darArea( ) );
        assertEquals( "La imagen del empleado 1 no corresponde.", "empleado1.png", empresa.darEmpleado1( ).darImagen( ) );
        
        // Empleado 2
        assertEquals( "El nombre del empleado 2 no corresponde.", "Jaime", empresa.darEmpleado2( ).darNombre( ) );
        assertEquals( "La edad del empleado 2 no corresponde.", 25, empresa.darEmpleado2( ).darEdad( ) );
        assertEquals( "La antig�edad del empleado 2 no corresponde.", 3, empresa.darEmpleado2( ).darAntiguedad( ) );
        assertEquals( "El salario del empleado 2 no corresponde.", 12000, empresa.darEmpleado2( ).darSalario( ) );
        assertEquals( "El �rea del empleado 2 no corresponde.", Empleado.TECNOLOGICA, empresa.darEmpleado2( ).darArea( ) );
        assertEquals( "La imagen del empleado 2 no corresponde.", "empleado2.png", empresa.darEmpleado2( ).darImagen( ) );
        
        // Empleado 3
        assertEquals( "El nombre del empleado 3 no corresponde.", "Rafael", empresa.darEmpleado3( ).darNombre( ) );
        assertEquals( "La edad del empleado 3 no corresponde.", 22, empresa.darEmpleado3( ).darEdad( ) );
        assertEquals( "La antig�edad del empleado 3 no corresponde.", 0, empresa.darEmpleado3( ).darAntiguedad( ) );
        assertEquals( "El salario del empleado 3 no corresponde.", 8000, empresa.darEmpleado3( ).darSalario( ) );
        assertEquals( "El �rea del empleado 3 no corresponde.", Empleado.TECNOLOGICA, empresa.darEmpleado3( ).darArea( ) );
        assertEquals( "La imagen del empleado 3 no corresponde.", "empleado3.png", empresa.darEmpleado3( ).darImagen( ) );
        
        // Empleado 4
        assertEquals( "El nombre del empleado 4 no corresponde.", "Vanessa", empresa.darEmpleado4( ).darNombre( ) );
        assertEquals( "La edad del empleado 4 no corresponde.", 28, empresa.darEmpleado4( ).darEdad( ) );
        assertEquals( "La antig�edad del empleado 4 no corresponde.", 6, empresa.darEmpleado4( ).darAntiguedad( ) );
        assertEquals( "El salario del empleado 4 no corresponde.", 16000, empresa.darEmpleado4( ).darSalario( ) );
        assertEquals( "El �rea del empleado 4 no corresponde.", Empleado.ADMINISTRATIVA, empresa.darEmpleado4( ).darArea( ) );
        assertEquals( "La imagen del empleado 4 no corresponde.", "empleado4.png", empresa.darEmpleado4( ).darImagen( ) );
        
    }
    
    /**
     * Prueba 2: M�todo que se encarga de verificar el m�todo buscarEmpleado.
     * <b> M�todos a probar: </b> <br>
     * buscarEmpleado<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El empleado existe.<br>
     * 2. El empleado no existe.<br>
     */
    public void testBuscarEmpleado( )
    {
        setupEscenario1( );
         // 1
        assertNotNull( "El empleado deber�a existir.", empresa.buscarEmpleado( "Rafael" ) );
        
        // 2
        assertNull( "El empleado no deber�a existir.", empresa.buscarEmpleado( "Juan" ) );
    }
    
    /**
     * Prueba 3: M�todo que se encarga de verificar el m�todo calcularPrestacionesEmpleado.
     * <b> M�todos a probar: </b> <br>
     * calcularPrestacionesEmpleado<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El empleado existe para cada una de las �reas.<br>
     * 2. El empleado no existe.<br>
     */
    public void testCalcularPrestacionesEmpleado( )
    {
        setupEscenario1( );
        // 1
        assertEquals( "La prestaciones del empleado con �rea seguridad no coinciden.", 1350.0, empresa.calcularPrestacionesEmpleado( "Germ�n" ) );
        assertEquals( "La prestaciones del empleado con �rea tecnol�gica no coinciden.", 1500.0, empresa.calcularPrestacionesEmpleado( "Jaime" ) );
        assertEquals( "La prestaciones del empleado con �rea administrativa no coinciden.", 5600.0, empresa.calcularPrestacionesEmpleado( "Vanessa" ) );
        
        // 2
        assertEquals( "Las prestaciones de un empleado que no existe deber�an ser -1.", -1.0, empresa.calcularPrestacionesEmpleado( "Juan" ) );
    }
    
    /**
     * Prueba 4: M�todo que se encarga de verificar el m�todo calcularEdadPromedio.
     * <b> M�todos a probar: </b> <br>
     * calcularEdadPromedio<br>
     * <b> Caso de prueba: </b> <br>
     * La edad promedio se calcula como un n�mero real.
     */
    public void testCalcularEdadPromedio( )
    {
        setupEscenario1( );
        assertEquals( "La edad promedio no est� bien calculada.", 24.75, empresa.calcularEdadPromedio( ) );
    }
    
    /**
     * Prueba 5: M�todo que se encarga de verificar el m�todo salariosSuperanCotaMinima.
     * <b> M�todos a probar: </b> <br>
     * salariosSuperanCotaMinima<br>
     * cambiarSalarioEmpleado<br>
     * <b> Caso de prueba: </b> <br>
     * 1. Los salarios no superan la cota m�nima.
     * 2. Los salarios superan la cota m�nima.
     */
    public void testSalariosSuperanCotaMinima( )
    {
        setupEscenario1( );
        // 1
        assertFalse( "Los salarios no deber�an superar la cota m�nima.", empresa.salariosSuperanCotaMinima( ) );
        
        // 2
        empresa.cambiarSalarioEmpleado( "Vanessa", 71000 );
        assertTrue( "Los salarios deber�an superar la cota m�nima.", empresa.salariosSuperanCotaMinima( ) );
    }
    
    /**
     * Prueba 6: M�todo que se encarga de verificar el m�todo cambiarSalarioEmpleado.
     * <b> M�todos a probar: </b> <br>
     * cambiarSalarioEmpleado<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El empleado existe.<br>
     * 2. El empleado no existe.<br>
     */
    public void testCambiarSalarioEmpleado( )
    {
        setupEscenario1( );
        // 1
        assertTrue( "Los salarios deber�an superar la cota m�nima.", empresa.cambiarSalarioEmpleado( "Vanessa", 71000 ) );
        assertEquals( "El salario no corresponde al nuevo.", 71000, empresa.darEmpleado4( ).darSalario( ) );
        
        // 2
        assertFalse( "No deber�a cambiar ning�n salario.", empresa.cambiarSalarioEmpleado( "Juan", 10000 ) );
    }
    
}
