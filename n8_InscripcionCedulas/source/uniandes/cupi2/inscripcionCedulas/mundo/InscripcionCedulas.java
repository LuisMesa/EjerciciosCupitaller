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

package uniandes.cupi2.inscripcionCedulas.mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que representa el sistema de inscripci�n de c�dulas.<br>
 * <b>inv:</b><br>
 * departamentos != null. <br>
 * ciudadanos != null. <br>
 * No existen dos o m�s ciudadanos con el mismo n�mero de c�dula. <br>
 */
public class InscripcionCedulas implements Serializable
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa la serializaci�n.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constante que representa el comando para personas con m�s de 18 a�os de edad.
     */
    public static final int RANGO_0 = 18;

    /**
     * Constante que representa el comando para personas con menos de 26 a�os de edad.
     */
    public static final int RANGO_1 = 26;

    /**
     * Constante que representa el comando para personas con m�s de 26 y menos de 30 a�os de edad.
     */
    public static final int RANGO_2 = 30;

    /**
     * Constante que representa el comando para personas con m�s de 30 y menos de 38 a�os de edad.
     */
    public static final int RANGO_3 = 38;

    /**
     * Constante que representa el comando para personas con m�s de 38 y menos de 50 a�os de edad.
     */
    public static final int RANGO_4 = 50;

    /**
     * Constante que representa el comando para personas con m�s de 50 y menos de 67 a�os de edad.
     */
    public static final int RANGO_5 = 67;

    /**
     * Constante que representa el comando para personas con m�s 67 a�os de edad.
     */
    public static final int RANGO_6 = 150;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de departamentos.
     */
    private ArrayList departamentos;

    /**
     * Lista de ciudadanos inscritos en el sistema.
     */
    private ArrayList ciudadanos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el sistema de inscripci�n de c�dulas. <br>
     * <b>post: </b>El sistema se inicializ� con el archivo dado por par�metro. Los departamentos y ciudadanos se crean vac�os.<br>
     * Si el archivo que contiene la informaci�n del sistema no existe,no se ejecuta el programa. <br>
     * Si el archivo existe, entonces se carga la informaci�n de los departamentos, municipios, puestos de votaci�n y ciudadanos inscritos.
     * @param pNombreArchivo Nombre del archivo que contiene los datos. pNombreArchivo != null && pNombreArchivo != "".
     * @throws PersistenciaException Se lanza una excepci�n si hay alg�n error cargando los datos del archivo.
     */
    public InscripcionCedulas( String pNombreArchivo ) throws PersistenciaException
    {
        departamentos = new ArrayList( );
        ciudadanos = new ArrayList( );
        try
        {
        	File archivo = new File(pNombreArchivo);
        	if(!archivo.exists())
        		throw new Exception("Error");
        	
        	//cargar(archivo);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	throw new PersistenciaException("Error al leer el archivo");
        }
        
        
        //TODO Parte3 PuntoC Complete el m�todo seg�n la documentaci�n dada.
        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de ciudadanos inscritos en el sistema.
     * <b>pre</b>: La lista de departamentos est� inicializada. <br>
     * @return N�mero de ciudadanos inscritos en el sistema.
     */
    public int darNumInscritos( )
    {
        int numInscritos = 0;
        for( int i = 0; i < departamentos.size( ); i++ )
        {
            Departamento d = ( Departamento )departamentos.get( i );
            numInscritos += d.darNumInscritos( );
        }

        return numInscritos;
    }

    /**
     * Retorna la lista de departamentos.
     * <b>pre</b>: La lista de departamentos est� inicializada. <br>
     * @return Departamentos del sistema de inscripci�n de c�dulas.
     */
    public ArrayList darDepartamentos( )
    {
        return departamentos;
    }

    /**
     * Carga el estado del sistemas de un archivo serializado.
     *  <b>post: </b> Se carg� el estado del sistema. <br>
     * @param pArchivo Archivo con la informaci�n del sistema. pArchivo != null.
     * @throws PersistenciaException Se lanza una excepci�n si hay alg�n error cargando los datos del archivo.
     */
    public void cargar( File pArchivo ) throws PersistenciaException
    {
        try
        {
            FileInputStream fis = new FileInputStream( pArchivo );
            ObjectInputStream ois = new ObjectInputStream( fis );
            departamentos = ( ArrayList )ois.readObject( );
            ciudadanos = ( ArrayList )ois.readObject( );
            ois.close( );
            fis.close( );
        }
        catch( Exception e )
        {
            throw new PersistenciaException( "Error fatal: imposible restaurar el estado del programa." );
        }
    }

    /**
     * Guarda el estado del sistema en un archivo serializado.
     * @param pRuta Ruta del archivo donde se guarda el estado del sistema. pRuta != null && pRuta != "".
     * @throws PersistenciaException Se lanza una excepci�n si hay alg�n error guardando los datos del archivo.
     */
    //TODO Parte3 PuntoA Complete el m�todo seg�n la documentaci�n dada.
    public void guardar(File pArchivo) throws PersistenciaException
    {
    	try
    	{
    		FileOutputStream archivoSalida = new FileOutputStream(pArchivo);
    		ObjectOutputStream salida = new ObjectOutputStream(archivoSalida);
    		salida.writeObject(departamentos);
    		salida.close();
    		archivoSalida.close();
    	}
    	catch (Exception e)
    	{
    		throw new PersistenciaException("Error al serializar ");
    	}
    	
    }

    /**
     * Importa datos al sistema desde un archivo de valores separados por comas (csv).<br>
     * <b>post: </b> Se importaron los datos del estado al sistema. <br>
     * @param pNombreArchivo Nombre del archivo que contiene los datos. pNombreArchivo != null && pNombreArchivo != "".
     * @throws PersistenciaException Se lanza una excepci�n si no se puede abrir o no se encuentra el archivo con los datos.
     * @throws FormatoArchivoException Se lanza una excepci�n si el archivo no cumple con el formato definido para importar los datos.
     */
    public void importarDatos( String pNombreArchivo ) throws PersistenciaException, FormatoArchivoException
    {
        //TODO Parte5 PuntoA Complete el m�todo seg�n la documentaci�n dada.
    	 File archivo = new File(pNombreArchivo);
    	 if(!archivo.exists())
    		 throw new PersistenciaException("El archivo no se encuentra (Importar datos");
    	 try
    	 {
    		 FileReader archivoLector = new FileReader(archivo);
    		 BufferedReader lector = new BufferedReader(archivoLector);
    		 boolean termino = false; 
    		 int a =0;
    		 while(!termino)
    		 {
    			 a++;
    			 String linea = lector.readLine();
    			 if(linea!=null)
    			 {
    				 String[] campos = new String[4];
    				 campos = linea.split(";");
    				 String sDepartamento = campos[0];

    				 String sMunicipio = campos[1];
    				 String sPuesto = campos[2];
    				 String sDireccion = campos[3];

    				 if(buscarDepartamento(sDepartamento)==null)
    				 {
    					 Departamento departamento =new Departamento(sDepartamento);
    					 departamento.agregarMunicipio(sMunicipio);
    					 departamento.buscarMunicipio(sMunicipio).agregarPuestoVotacion(sPuesto, sDireccion);
    					 departamentos.add(departamento);

    				 }
    				 else if((buscarDepartamento(sDepartamento)!=null)&&sDepartamento!="")
    				 {
    					 if(buscarDepartamento(sDepartamento).buscarMunicipio(sMunicipio)==null)
    					 {
    						 buscarDepartamento(sDepartamento).agregarMunicipio(sMunicipio);
    						 buscarDepartamento(sDepartamento).buscarMunicipio(sMunicipio).agregarPuestoVotacion(sPuesto, sDireccion);
    					 }
    					 else
    						 buscarDepartamento(sDepartamento).buscarMunicipio(sMunicipio).agregarPuestoVotacion(sPuesto, sDireccion);
    				 }
    				 
    			 } 
    			 else
				 {
					 termino = true;
					 
				 }
    		 }
    		 
    		 //System.out.println(a+"");
    	 }
    	 catch(IOException a )
    	 {
    		 a.printStackTrace();
    		 
    		 throw new PersistenciaException("Error al abrir el archivo (importarDatos)");
    	 }
    	 catch(Exception e )
    	 {
    		 e.printStackTrace();
    		 throw new FormatoArchivoException("El archivo no cumple con el formato definido");
    	 }
    	 
        verificarInvariante( );
    }

    /**
     * Genera el informe con los ciudadanos inscritos en el puesto de votaci�n dado.
     * @param pRuta Ruta donde se desea guardar el archivo con el reporte. pRuta != null && pRuta != "".
     * @param pNombreArchivo Nombre del archivo que contiene el reporte. pNombreArchivo != null && pNombreArchivo != "".
     * @param pPuesto Nombre del puesto de votaci�n del que se desea generar el reporte. pPuesto != null && pPuesto != "".
     * @param pMunicipio Nombre del municipio donde se encuentra el puesto de votaci�n. pMunicipio != null && pMunicipio != "".
     * @param pDepartamento Nombre del departamento donde se encuentra el municipio. pDepartamento != null && pDepartamento != "".
     * @throws PersistenciaException Se lanza una excepci�n si hay un error en la generaci�n del reporte.
     */
    public void generarReporte( String pRuta, String pNombreArchivo, String pPuesto, String pMunicipio, String pDepartamento ) throws PersistenciaException
    {
      //TODO Parte5 PuntoB Complete el m�todo seg�n la documentaci�n dada.
    	//Lugar de nacimiento:<lugar de nacimiento ciudadano k> Sexo:<Sexo ciudadano k>
    	try
    	{
    	File archivo = new File(pRuta+pNombreArchivo);
    	if(!archivo.exists())
    	{
    		if(!archivo.createNewFile())
    			throw new PersistenciaException("No se pudo crear el archivo");
    			
    	}
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		throw new PersistenciaException("Se presentaron errores generando el reporte");
    	}
    	
    	
    }

    /**
     * Inscribe a un ciudadano en el sistema.
     * <b>pre</b>: La lista de ciudadanos est� inicializada. <br>
     * <b>post: </b> Se inscribi� al ciudadano al sistema y al departamento que pertenece. <br>
     * @param pDepartamento Nombre del departamento donde se desea inscribir al ciudadano. pDepartamento != null && pDepartamento != "".
     * @param pMunicipio Nombre del municipio donde se desea inscribir al ciudadano. pMunicipio != null && pMunicipio != "".
     * @param pPuesto Nombre del puesto de votaci�n donde se desea inscribir al ciudadano. pPuesto != null && pPuesto != "".
     * @param pCedula C�dula del ciudadano. pCedula != null && pCedula != "".
     * @param pApellidos Apellidos del ciudadano. pApellidos != null && pApellidos != "".
     * @param pNombres Nombres del ciudadano. pNombres != null && pNombres != "".
     * @param pFechaNacimiento Fecha de nacimiento del ciudadano. pFechaNacimiento != null.
     * @param pLugarNacimiento Lugar de nacimiento del ciudadano. pLugarNacimiento != null && pLugarNacimiento != "".
     * @param pSexo Sexo del ciudadano. pSexo != null && (pSexo == FEMENINO || pSexo == MASCULINO ).
     * @param pFechaExpedicion Fecha de expedici�n de la c�dula del ciudadano. pFechaExpedicion != null.
     * @param pLugarExpedicion Lugar de expedici�n de la c�dula del ciudadano. pLugarExpedicion != null && pLugarExpedicion != "".
     * @throws CiudadanoRegistradoException Se lanza una excepci�n si ya existe un ciudadano registrado con el n�mero de c�dula dado.
     */
    public void inscribirCiudadano( String pDepartamento, String pMunicipio, String pPuesto, String pCedula, String pApellidos, String pNombres, Date pFechaNacimiento, String pLugarNacimiento, String pSexo, Date pFechaExpedicion,
            String pLugarExpedicion ) throws CiudadanoRegistradoException
            {
        //TODO Parte4 PuntoA Complete el m�todo seg�n la documentaci�n dada.
        //Tenga en cuenta que debe agregar al ciudadano en la lista de ciudadanos e inscribirlo en el departamento.
    	Ciudadano ciudadano = new Ciudadano(pCedula, pApellidos, pNombres, pFechaNacimiento, pLugarNacimiento, pSexo, pFechaExpedicion, pLugarExpedicion);
    	
    	if(buscarDepartamento(pDepartamento).buscarMunicipio(pMunicipio).existeCiudadano(pCedula))
    	{
    		long miliS =System.currentTimeMillis();
    		Date fecha = new Date(miliS);
    		String sFecha = fecha.toString();
    		throw new CiudadanoRegistradoException(sFecha+" : N�mero de cedula: "+pCedula);
    	}
    	else
    	{
    		buscarDepartamento(pDepartamento).inscribirCiudadano(pMunicipio, pPuesto, ciudadano);
    		ciudadanos.add(ciudadano);
    	}
    	
        verificarInvariante( );
            }

    /**
     * Busca el departamento cuyo nombre es dado por par�metro.
     * @param pNombreDepartamento Nombre del departamento. pNombreDepartamento != null && pNombreDepartamento != "".
     * @return Departamento con el nombre dado.
     */
    public Departamento buscarDepartamento( String pNombreDepartamento )
    {
        Departamento departamentoBuscado = null;
        for( int i = 0; i < departamentos.size( ); i++ )
        {
            Departamento d = ( Departamento )departamentos.get( i );
            if( d.darNombre( ).equals( pNombreDepartamento ) )
            {
                departamentoBuscado = d;
            }
        }

        return departamentoBuscado;
    }

    /**
     * Calcula el n�mero de hombres inscritos hasta el momento en el sistema.
     * <b>pre</b>: La lista de departamentos est� inicializada. <br>
     * @return N�mero de hombres inscritos.
     */
    public int calcularNumeroHombresInscritos( )
    {
        int numHombres = 0;
        for( int i = 0; i < departamentos.size( ); i++ )
        {
            Departamento d = ( Departamento )departamentos.get( i );
            numHombres += d.calcularNumeroHombresInscritos( );
        }

        return numHombres;
    }

    /**
     * Calcula el n�mero de mujeres inscritas hasta el momento en el sistema.
     * <b>pre</b>: La lista de departamentos est� inicializada. <br>
     * @return N�mero de mujeres inscritas.
     */
    public int calcularNumeroMujeresInscritas( )
    {
        int numMujeres = 0;
        for( int i = 0; i < departamentos.size( ); i++ )
        {
            Departamento d = ( Departamento )departamentos.get( i );
            numMujeres += d.calcularNumeroMujeresInscritas( );
        }

        return numMujeres;
    }

    /**
     * Calcula porcentaje de hombres inscritos en el sistema.
     * @return Porcentaje de hombres inscritos en el sistema.
     */
    public double calcularPorcentajeHombresInscritos( )
    {
        int total = darNumInscritos( );
        if( total == 0 )
        {
            return 0.0;
        }

        int hombres = calcularNumeroHombresInscritos( );
        return ( double )hombres / ( double )total;
    }

    /**
     * Calcula porcentaje de mujeres inscritas en el sistema.
     * @return Porcentaje de mujeres inscritas en el sistema.
     */
    public double calcularPorcentajeMujeresInscritas( )
    {
        int total = darNumInscritos( );
        if( total == 0 )
        {
            return 0.0;
        }

        int mujeres = calcularNumeroMujeresInscritas( );
        return ( double )mujeres / ( double )total;
    }

    /**
     * Calcula el n�mero de ciudadanos inscritos en el rango de edad dado por par�metro.<br>
     * <b>pre</b>: La lista de ciudadanos est� inicializada. <br>
     * @param pRango Rango de edad. pRango != null && (pRango == RANGO_1 || pRango == RANGO_2 || pRango == RANGO_3 || pRango == RANGO_4 || pRango == RANGO_5 || pRango ==
     *        RANGO_6 ).
     * @return Ciudadanos inscritos en el rango de edad dado.
     */
    public int calcularInscritosRangoEdad( int pRango )
    {
        int respuesta = 0;
        for( int i = 0; i < ciudadanos.size( ); i++ )
        {
            Ciudadano temp = ( Ciudadano )ciudadanos.get( i );
            int edad = temp.darEdad( );

            if( pRango == RANGO_1 )
            {
                if( edad >= RANGO_0 && edad < RANGO_1 )
                {
                    respuesta++;
                }
            }
            else if( pRango == RANGO_2 )
            {
                if( edad >= RANGO_1 && edad < RANGO_2 )
                {
                    respuesta++;
                }
            }
            else if( pRango == RANGO_3 )
            {
                if( edad >= RANGO_2 && edad < RANGO_3 )
                {
                    respuesta++;
                }
            }
            else if( pRango == RANGO_4 )
            {
                if( edad >= RANGO_3 && edad < RANGO_4 )
                {
                    respuesta++;
                }
            }
            else if( pRango == RANGO_5 )
            {
                if( edad >= RANGO_4 && edad <= RANGO_5 )
                {
                    respuesta++;
                }
            }
            else if( pRango == RANGO_6 )
            {
                if( edad >= RANGO_5 && edad <= RANGO_6 )
                {
                    respuesta++;
                }
            }

        }

        return respuesta;
    }
    /**
     * Verifica si est� inscrito o no un ciudadano en el sistema.
     * <b>pre</b>: La lista de departamentos est� inicializada. <br>
     * @param pCedulaCiudadano C�dula del ciudadano que se desea saber si est� inscrito o no en el puesto de votaci�n. pCedulaCiudadano != null && pCedulaCiudadano != "".
     * @return True si el ciudadano se encuentra inscrito en alg�n departamento o false de lo contrario.
     */
    public boolean existeCiudadano( String pCedulaCiudadano )
    {
        boolean seEncuentra = false;
        for( int i = 0; i < departamentos.size( ); i++ )
        {
            Departamento d = ( Departamento )departamentos.get( i );
            if( d.existeCiudadano( pCedulaCiudadano ) )
            {
                seEncuentra = true;
            }
        }
        return seEncuentra;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase: <br>
     * <b>inv:</b><br>
     * departamentos != null. <br>
     * ciudadanos != null. <br>
     * No existen dos o m�s ciudadanos con el mismo n�mero de c�dula. <br>
     */
    private void verificarInvariante( )
    {
    	//System.out.println("1");
    	//CiudadanoRegistradoException e = new CiudadanoRegistradoException("Error");
    	
        assert departamentos != null : "La lista de departamentos no puede ser nula.";
        assert ciudadanos != null : "La lista de ciudadanos  no puede ser nula.";
        assert existenCiudadanosConLaMismaCedula( ) == false : "No puden haber ciudadanos con el mismo n�mero de c�dula.";
    }

    /**
     * Revisa si existen dos ciudadanos con el mismo n�mero de c�dula.
     * @return True si existen dos ciudadanos con el mismo n�mero de c�dula, o false de los contrario.
     */
    private boolean existenCiudadanosConLaMismaCedula( )
    {
        boolean ciudadanoEncontrado = false;
        for( int i = 0; i < ciudadanos.size( ); i++ )
        {
            Ciudadano c1 = ( Ciudadano )ciudadanos.get( i );

            for( int j = i + 1; j < ciudadanos.size( ); j++ )
            {
                Ciudadano c2 = ( Ciudadano )ciudadanos.get( j );

                if( c1.equals( c2 ) )
                {
                    ciudadanoEncontrado = true;
                }
            }
        }

        return ciudadanoEncontrado;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}