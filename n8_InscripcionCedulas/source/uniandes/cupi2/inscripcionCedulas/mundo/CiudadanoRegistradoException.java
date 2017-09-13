package uniandes.cupi2.inscripcionCedulas.mundo;

import java.io.File;
import java.io.FileWriter;
//import java.io.OutputStream;
import java.io.PrintWriter;

public class CiudadanoRegistradoException extends Exception
{
	public static final String RUTA = "./data/error.log";
	private String mensaje;
	public CiudadanoRegistradoException(String pMensaje)
	{
		super(pMensaje);
		mensaje = pMensaje;
		//System.out.println("2");
		registrarError();
	}
	public void registrarError()
	{
		try
		{
			FileWriter archivoEscritor = new FileWriter(new File(RUTA));
			PrintWriter escritor = new PrintWriter(archivoEscritor);
			escritor.println("Oye mi perro sucedio un error");
			escritor.println(mensaje);
			escritor.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
