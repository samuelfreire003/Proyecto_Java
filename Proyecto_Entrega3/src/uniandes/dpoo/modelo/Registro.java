package uniandes.dpoo.modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Registro 
{
	
	private String titulo;
	
	private String descripcion;
	
	private String tipo;
	
	private Fecha fechaInicio;
	
	private Hora horaInicio;
	
	private Hora horaFinal;
	
	private Participante particpanteEncargado;
	
	public Registro(String ptitulo, String pdescripcion,String ptipo,Fecha pfechaInicio,Hora phoraInicio, Hora phoraFinal,Participante pparticpanteEncargado)
	{
		this.titulo = ptitulo;
		this.descripcion = pdescripcion;
		this.tipo = ptipo;
		this.fechaInicio = pfechaInicio;
		this.horaInicio = phoraInicio;
		this.horaFinal = phoraFinal;
		this.particpanteEncargado = pparticpanteEncargado;
	}
	
	public String getTitulo()
	{
		return titulo;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public String generarReferenciaArchivo()
	{
		String TextoArchivo = "\n" + titulo + "," + descripcion + "," + tipo + "," + fechaInicio + "," + horaInicio + ","  + horaFinal + "," + particpanteEncargado;
		return TextoArchivo;
	}
	
	public String toString()
	{
		return titulo + "," + descripcion + "," + tipo + "," + fechaInicio + "," + horaInicio + "," + "," + horaFinal;
	}
	
	public  void AgregarRegistro(String Archivo) throws IOException
	{
		
		String TextoArchivo = generarReferenciaArchivo();

		String filePath = "./Archivos_Proyecto/" + Archivo +".txt";
        FileWriter fw = new FileWriter(filePath, true); 
		BufferedWriter writer = new BufferedWriter(fw);
		writer.write(TextoArchivo);
		writer.close();
		
	}
}
