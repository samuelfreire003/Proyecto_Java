
package uniandes.dpoo.procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.modelo.Fecha;
import uniandes.dpoo.modelo.Hora;
import uniandes.dpoo.modelo.Participante;
import uniandes.dpoo.modelo.Proyecto;
import uniandes.dpoo.modelo.Registro;


public class ManejadorProyecto 
{
	
	private static Proyecto ProyectoEnCurso;
	private static Registro RegistroEnCurso;
	
	private static List<String> ProyectosCargados;
	
	public static void IniciarProyecto(String nombreProyecto,String descripcionProyecto,int diaInicio,int mesInicio,int añoInicio, String nombreCreador,String correoCreador,int diaFinal,int mesFinal,int añoFinal,String tipos)
	{
		Fecha fechaInicioProyecto = new Fecha(diaInicio,mesInicio,añoInicio);
		Fecha fechaFinalProyecto = new Fecha(diaFinal,mesFinal,añoFinal);
		Participante particpanteInicial = new Participante(nombreCreador,correoCreador);
		Proyecto Proyectocreado = new Proyecto(nombreProyecto,descripcionProyecto,fechaInicioProyecto,fechaFinalProyecto,particpanteInicial,tipos);
		ProyectoEnCurso = Proyectocreado;
	}
	
	public void AgregarParticpante(String nombreParticpante,String correoParticpante)
	{
		Participante particpanteAgregar = new Participante(nombreParticpante,correoParticpante);
		ProyectoEnCurso.agregarParticpante(particpanteAgregar);
	}
	
	public static void CrearRegistro(String ptitulo, String pdescripcion,String ptipo,int diaInicio,int mesInicio,int añoInicio,int HoraInicio,int MinutoInicio, int HoraFinal,int MinutFinal,String nombreCreador,String correoCreador)
	{
		Fecha fechaInicioActividad = new Fecha(diaInicio,mesInicio,añoInicio);
		Hora HoraInicioActividad = new Hora(HoraInicio,MinutoInicio);
		Hora HoraFinalActividad = new Hora(HoraFinal,MinutFinal);
		Participante particpanteRealizador = new Participante(nombreCreador,correoCreador);
		Registro RegistroActividad = new Registro(ptitulo,pdescripcion,ptipo,fechaInicioActividad,HoraInicioActividad,HoraFinalActividad,particpanteRealizador);
		RegistroEnCurso = RegistroActividad;
	}
	
	public static List<String> CargarProyectos() throws FileNotFoundException, IOException
	{
		List<String> ProyectosCargados = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader("./Archivos_Proyecto/Proyectos.txt"));
		String linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrÃ¡ el valor null
		{
			// Separar los valores que estaban en una lÃ­nea
			String[] partes = linea.split(",");
			String nombreProyecto = partes[0];
			
			ProyectosCargados.add(nombreProyecto);
			linea = br.readLine(); // Leer la siguiente lÃ­nea
		}
	
		br.close();
		
		return ProyectosCargados;
		
	}
	
	public static List<String> getProyectos()
	{
		return ProyectosCargados;
	}
	
	public static  void AgregarProyecto() throws IOException
	{
		ProyectoEnCurso.AgregarProyecto();
	}
	
	public static  void CrearArchivoReporte() throws IOException
	{
		ProyectoEnCurso.CrearArchivoReporte();
	}
	
	public static  void GuardarReporte(String opcionproyecto) throws IOException
	{
		RegistroEnCurso.AgregarRegistro(opcionproyecto);
	}
	
	public String getProyectocursoNombre()
	{
		String titulo = ProyectoEnCurso.getNombre();
		return titulo;
	}
	
	public static  void AgregarParticpanteNuevo(String nombreParticpante, String correoParticpante) throws IOException
	{
		Participante particpanteagregar = new Participante(nombreParticpante,correoParticpante);
		ProyectoEnCurso.agregarParticpante(particpanteagregar);
	}
	
	public static List<String> CargarProyectosconTipos() throws FileNotFoundException, IOException
	{
		List<String> ProyectosCargadosTipo = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader("./Archivos_Proyecto/Proyectos.txt"));
		String linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrÃ¡ el valor null
		{
			// Separar los valores que estaban en una lÃ­nea
			String[] partes = linea.split(",");
			String nombreProyecto = partes[0] + "," + partes[5];
			
			ProyectosCargadosTipo.add(nombreProyecto);
			linea = br.readLine(); // Leer la siguiente lÃ­nea
		}
	
		br.close();
		
		return ProyectosCargadosTipo;
		
	}
	
}
