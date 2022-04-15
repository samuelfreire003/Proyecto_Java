package uniandes.dpoo.procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ManejadorRegistro 

{
	
	private static Map<String, String> RegistrosTiempoTotal;
	
	private static Map<String, Map<String, String>> RegistrosMiembroDia;
	
	private static Map<String, Map<String, String>> RegistrosMiembroTipo;
	
	private static Map<String, Map<String, String>> RegistrosMiembroTipoCantidad;
	
	private static Map<String, Map<String, String>> RegistrosMiembroCantidad;
	
	public static Map<String, String> CargarRegistrosTiempoTotal(String Titulo) throws FileNotFoundException, IOException
	{
		RegistrosTiempoTotal = new HashMap<String, String>();
		
		BufferedReader br = new BufferedReader(new FileReader("./Archivos_Proyecto/" + Titulo +".txt"));
		String linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			if (false == linea.equals("titulo,descripcion,tipo,fechaInicio,horaInicio,horaFinal,particpanteEncargado"))
			{
				String[] partes = linea.split(",");
				String nombreParticpante = partes[6];
				String[] valores = partes[4].split(":");
				String[] valoresfinal = partes[5].split(":");
				String Tiempo = String.valueOf(((Integer.valueOf(valoresfinal[0])*3600) + (Integer.valueOf(valoresfinal[1])*60)) - ((Integer.valueOf(valores[0])*3600) + (Integer.valueOf(valores[1])*60)));
				
				String registro = RegistrosTiempoTotal.get(nombreParticpante);
				
				if (registro == null)
				{
					RegistrosTiempoTotal.put(nombreParticpante,Tiempo);
				}
				else if  (registro != null)
				{
					String nuevoTiempo = String.valueOf(Integer.valueOf(Tiempo) + Integer.valueOf(registro));
					RegistrosTiempoTotal.put(nombreParticpante,nuevoTiempo);
				}
			}
			linea = br.readLine(); // Leer la siguiente línea
		}
	
		br.close();
		
		return RegistrosTiempoTotal;
		
	}
	
	public static Map<String, Map<String, String>> CargarRegistrosTiempoDia(String Titulo) throws FileNotFoundException, IOException
	{
		RegistrosMiembroDia = new HashMap<String,Map<String, String>>();
		
		BufferedReader br = new BufferedReader(new FileReader("./Archivos_Proyecto/" + Titulo +".txt"));
		String linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			if (false == linea.equals("titulo,descripcion,tipo,fechaInicio,horaInicio,horaFinal,particpanteEncargado"))
			{
				String[] partes = linea.split(",");
				String nombreParticpante = partes[6];
				String[] valores = partes[4].split(":");
				String[] valoresfinal = partes[5].split(":");
				String Fecha = partes[3];
				String Tiempo = String.valueOf(((Integer.valueOf(valoresfinal[0])*3600) + (Integer.valueOf(valoresfinal[1])*60)) - ((Integer.valueOf(valores[0])*3600) + (Integer.valueOf(valores[1])*60)));
				
				Map<String, String> registro= RegistrosMiembroDia.get(nombreParticpante);
				
				if (registro == null)
				{
					Map<String, String> DiasconTiempo = new HashMap<String, String>();
					DiasconTiempo.put(Fecha, Tiempo);
					RegistrosMiembroDia.put(nombreParticpante,DiasconTiempo);
				}
				else if  (registro != null)
				{
					String TiempoDia= registro.get(Fecha);
					
					if (TiempoDia == null)
					{
						registro.put(Fecha,Tiempo);
					}
					else if  (TiempoDia != null)
					{
						String nuevoTiempo = String.valueOf(Integer.valueOf(TiempoDia) + Integer.valueOf(Tiempo));
						registro.put(Fecha,nuevoTiempo);
					}
					RegistrosMiembroDia.put(nombreParticpante,registro);
				}
			}
			linea = br.readLine(); // Leer la siguiente línea
		}
	
		br.close();
		
		return RegistrosMiembroDia;
		
	}
	
	public static Map<String, Map<String, String>> CargarRegistrosTiempoTipo(String Titulo) throws FileNotFoundException, IOException
	{
		RegistrosMiembroTipo = new HashMap<String,Map<String, String>>();
		
		BufferedReader br = new BufferedReader(new FileReader("./Archivos_Proyecto/" + Titulo +".txt"));
		String linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			if (false == linea.equals("titulo,descripcion,tipo,fechaInicio,horaInicio,horaFinal,particpanteEncargado"))
			{
				String[] partes = linea.split(",");
				String nombreParticpante = partes[6];
				String[] valores = partes[4].split(":");
				String[] valoresfinal = partes[5].split(":");
				String Tipo = partes[2];
				String Tiempo = String.valueOf(((Integer.valueOf(valoresfinal[0])*3600) + (Integer.valueOf(valoresfinal[1])*60)) - ((Integer.valueOf(valores[0])*3600) + (Integer.valueOf(valores[1])*60)));
				
				Map<String, String> registro= RegistrosMiembroTipo.get(nombreParticpante);
				
				if (registro == null)
				{
					Map<String, String> TipoconTiempo = new HashMap<String, String>();
					TipoconTiempo.put(Tipo, Tiempo);
					RegistrosMiembroTipo.put(nombreParticpante,TipoconTiempo);
				}
				else if  (registro != null)
				{
					String TiempoTipo= registro.get(Tipo);
					
					if (TiempoTipo == null)
					{
						registro.put(Tipo,Tiempo);
					}
					else if  (TiempoTipo != null)
					{
						String nuevoTiempo = String.valueOf(Integer.valueOf(TiempoTipo) + Integer.valueOf(Tiempo));
						registro.put(Tipo,nuevoTiempo);
					}
					RegistrosMiembroTipo.put(nombreParticpante,registro);
				}
			}
			linea = br.readLine(); // Leer la siguiente línea
		}
	
		br.close();
		
		return RegistrosMiembroTipo;
		
	}
	
	public static Map<String, Map<String, String>> CargarRegistrosCantidadTipo(String Titulo) throws FileNotFoundException, IOException
	{
		RegistrosMiembroTipoCantidad = new HashMap<String,Map<String, String>>();
		
		BufferedReader br = new BufferedReader(new FileReader("./Archivos_Proyecto/" + Titulo +".txt"));
		String linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			if (false == linea.equals("titulo,descripcion,tipo,fechaInicio,horaInicio,horaFinal,particpanteEncargado"))
			{
				String[] partes = linea.split(",");
				String nombreParticpante = partes[6];;
				String Tipo = partes[2];
				
				Map<String, String> registro= RegistrosMiembroTipoCantidad.get(nombreParticpante);
				
				if (registro == null)
				{
					Map<String, String> TipoconTiempo = new HashMap<String, String>();
					String cantidad = String.valueOf(1);
					TipoconTiempo.put(Tipo, cantidad);
					RegistrosMiembroTipoCantidad.put(nombreParticpante,TipoconTiempo);
				}
				else if  (registro != null)
				{
					String CantidadTipo= registro.get(Tipo);
					
					if (CantidadTipo == null)
					{
						String cantidad = String.valueOf(1);
						registro.put(Tipo,cantidad);
					}
					else if  (CantidadTipo != null)
					{
						String nuevoCantidad = String.valueOf(Integer.valueOf(CantidadTipo) + 1);
						registro.put(Tipo,nuevoCantidad);
					}
					RegistrosMiembroTipoCantidad.put(nombreParticpante,registro);
				}
			}
			linea = br.readLine(); // Leer la siguiente línea
		}
	
		br.close();
		
		return RegistrosMiembroTipoCantidad;
		
	}
	
	public static Map<String, Map<String, String>> CargarRegistrosCantidadActividad(String Titulo) throws FileNotFoundException, IOException
	{
		RegistrosMiembroCantidad = new HashMap<String,Map<String, String>>();
		
		BufferedReader br = new BufferedReader(new FileReader("./Archivos_Proyecto/" + Titulo +".txt"));
		String linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			if (false == linea.equals("titulo,descripcion,tipo,fechaInicio,horaInicio,horaFinal,particpanteEncargado"))
			{
				String[] partes = linea.split(",");
				String nombreParticpante = partes[6];
				String[] valores = partes[4].split(":");
				String[] valoresfinal = partes[5].split(":");
				String titulo = partes[0];
				String Tiempo = String.valueOf(((Integer.valueOf(valoresfinal[0])*3600) + (Integer.valueOf(valoresfinal[1])*60)) - ((Integer.valueOf(valores[0])*3600) + (Integer.valueOf(valores[1])*60)));
				
				Map<String, String> registro= RegistrosMiembroCantidad.get(nombreParticpante);
				
				if (registro == null)
				{
					Map<String, String> TipoconTiempo = new HashMap<String, String>();
					TipoconTiempo.put(titulo, Tiempo);
					RegistrosMiembroCantidad.put(nombreParticpante,TipoconTiempo);
				}
				else if  (registro != null)
				{
					String TiempoTipo= registro.get(titulo);
					
					if (TiempoTipo == null)
					{
						registro.put(titulo,Tiempo);
					}
					else if  (TiempoTipo != null)
					{
						String nuevoTiempo = String.valueOf(Integer.valueOf(TiempoTipo) + Integer.valueOf(Tiempo));
						registro.put(titulo,nuevoTiempo);
					}
					RegistrosMiembroCantidad.put(nombreParticpante,registro);
				}
			}
			linea = br.readLine(); // Leer la siguiente línea
		}
	
		br.close();
		
		return RegistrosMiembroCantidad;
		
	}
	
	public static String BuscarPorNombreRegistroTotal (String proyecto, String Nombre) throws FileNotFoundException, IOException
	{
		
		Map<String, String> registros = CargarRegistrosTiempoTotal(proyecto);
		String TiempoTotal = registros.get(Nombre);
		
		return TiempoTotal;
	}
	
	public static String BuscarPorNombreRegistroDia (String proyecto, String Nombre) throws FileNotFoundException, IOException
	{
		
		Map<String, Map<String, String>> registrosDia = CargarRegistrosTiempoDia(proyecto);
		Map<String, String> registrotiempodia = registrosDia.get(Nombre);
		
		String finalpalabra = "";
		
		for (String llavedia: registrotiempodia.keySet())
		{
			finalpalabra += ("/n" + llavedia  + "tiempo: " + registrotiempodia.get(llavedia));
		}
		
		return finalpalabra;
	}
	
	public static String BuscarPorNombreRegistroTipo (String proyecto, String Nombre) throws FileNotFoundException, IOException
	{
		
		Map<String, Map<String, String>> registrosTipo = CargarRegistrosTiempoTipo(proyecto);
		Map<String, String> registrotiempoTipo = registrosTipo.get(Nombre);
		
		String finalpalabra = "";
		
		for (String llavedia: registrosTipo.keySet())
		{
			finalpalabra += ("/n" + llavedia  + "tiempo: " + registrosTipo.get(llavedia));
		}
		
		return finalpalabra;
	}

}
