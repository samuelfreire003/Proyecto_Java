package uniandes.dpoo.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Proyecto 
{
	
	private String nombre;
	
	private String descripcion;
	
	private Fecha fechaInicio;
	
	private Fecha fechaFinal;
	
	private List<Participante> participantes;
	
	private Participante particpanteInicial;
	
	private String TiposAdmitidos;
	
	public Proyecto(String pnombre, String pdescripcion,Fecha pfechaInicio,Fecha pfechaFinal,Participante pparticpanteInicial, String TiposAdmitidos)
	{
		this.nombre = pnombre;
		this.descripcion = pdescripcion;
		this.fechaInicio = pfechaInicio;
		this.fechaFinal = pfechaFinal;
		participantes = new ArrayList<>();
		this.particpanteInicial = pparticpanteInicial;
		this.TiposAdmitidos = TiposAdmitidos;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}
	
	public String generarReferenciaArchivo()
	{
		String TextoArchivo = "\n" + nombre + "," + descripcion + "," + fechaInicio + "," + fechaFinal + "," + particpanteInicial + "," + TiposAdmitidos;
		return TextoArchivo;
	}
	
	public void agregarParticpante(Participante particpanteagregar)
	{
		
		participantes.add(particpanteagregar);

	}
	
	public  void AgregarProyecto() throws IOException
	{
		
		String TextoArchivo = generarReferenciaArchivo();

		String filePath = "./Archivos_Proyecto/Proyectos.txt";
        FileWriter fw = new FileWriter(filePath, true); 
		BufferedWriter writer = new BufferedWriter(fw);
		writer.write(TextoArchivo);
		writer.close();
		
	}
	
	public  void CrearArchivoReporte() throws IOException
	{
		String Archivo = "titulo,descripcion,tipo,fechaInicio,horaInicio,horaFinal,particpanteEncargado";
		
		File file = new File("./Archivos_Proyecto/" + nombre + ".txt"); 
		if(file.createNewFile()) System.out.println("File created: " + file.getName()); 
		else System.out.println("File already exists."); 
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("./Archivos_Proyecto/" + nombre + ".txt"));
		
		writer.write(Archivo);
		writer.close();
		
	}
	

}
