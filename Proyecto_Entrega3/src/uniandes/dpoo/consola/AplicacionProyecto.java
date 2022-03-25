package uniandes.dpoo.consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import uniandes.dpoo.procesamiento.ManejadorProyecto;
import uniandes.dpoo.procesamiento.ManejadorRegistro;

public class AplicacionProyecto

{
	
	public void ejecutarAplicacion()
	{
		System.out.println("Aplicacion seguimiento proyectos\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opci贸n"));
				if (opcion_seleccionada == 1)
					try {
						ejecutarMostrarProyectos();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else if (opcion_seleccionada == 2)
					try {
						ejecutarCrearProyecto();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else if (opcion_seleccionada == 3)
					try {
						ejecutarAgregarParticipante();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else if (opcion_seleccionada == 4)
					try {
						ejecutarCrearReporte();
					} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				else if (opcion_seleccionada == 5)
					try {
						ejecutarGenerarReporte();
					} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicaci贸n ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opci贸n v谩lida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los n煤meros de las opciones.");
			}
		}
	}
	
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicaci贸n\n");
		System.out.println("1. Mostrar Proyectos Creados");
		System.out.println("2. Crear Proyecto");
		System.out.println("3. Agregar Participante");
		System.out.println("4. Crear Reporte");
		System.out.println("5. Reporte Proyecto");
		System.out.println("6. Cerra programa");

	}
	
	private void ejecutarMostrarProyectos() throws FileNotFoundException, IOException
	{
		
		System.out.println("\n" + "Los siguientes proyecto ya fueron creados" + "\n");
		List<String> ProyectoCreados = ManejadorProyecto.CargarProyectosconTipos();
		
		int opciones = 0;
		
		for (String proyecto : ProyectoCreados)
		{
			String ProyectoLista = String.valueOf(opciones) + " " + proyecto + "\n";
			System.out.println(ProyectoLista);
			opciones += 1;
		}
	}
	
	private void ejecutarCrearProyecto() throws FileNotFoundException, IOException
	{
		
		System.out.println("\n" + "Porfavor llene toda la informacion que se le solicita" + "\n");
		String nombreProyecto = input("Por favor ingrese el nombre del proyecto");
		String DescripcionProyecto = input("Por favor ingrese la descripcion");
		int DiaInicioProyecto = Integer.parseInt(input("Por favor coloque el dia de inicio"));
		int MesInicioProyecto = Integer.parseInt(input("Por favor coloque el mes de inicio"));
		int A駉InicioProyecto = Integer.parseInt(input("Por favor coloque el a駉 de inicio"));
		String NombreCreadorProyecto = input("Por favor ingrese el nombre del creador");
		String CorreoCreadorProyecto = input("Por favor ingrese el correo del creador");
		int DiaFinalProyecto = Integer.parseInt(input("Por favor coloque el dia de finalizacion"));
		int MesFinalProyecto = Integer.parseInt(input("Por favor coloque el mes de finalizacion"));
		int A駉FinalProyecto = Integer.parseInt(input("Por favor coloque el a駉 de finalizacion"));
		String tiposProyecto = input("Por favor escriba los tipos admitidos de actividad separados por el simbolo '/' ");
		ManejadorProyecto.IniciarProyecto(nombreProyecto,DescripcionProyecto,DiaInicioProyecto,MesInicioProyecto,A駉InicioProyecto,NombreCreadorProyecto,CorreoCreadorProyecto,DiaFinalProyecto,MesFinalProyecto,A駉FinalProyecto,tiposProyecto);
		ManejadorProyecto.AgregarProyecto();
		ManejadorProyecto.CrearArchivoReporte();
	}
	
	private void ejecutarCrearReporte() throws FileNotFoundException, IOException
	{
		
		System.out.println("\n" + "Porfavor llene toda la informacion qeu se le solicita" + "\n");
		String TituloActividad = input("Por favor ingrese el titulo de la actividad");
		String DescripcionActividad = input("Por favor ingrese la descripcion");
		String TipoActividad = input("Por favor ingrese el tipo de Actividad segun los tipos permitidos en el proyecto");
		String NombreCreadorProyecto = input("Por favor ingrese el nombre del particpante que realizo la actividad");
		String CorreoCreadorProyecto = input("Por favor ingrese el correo del particpante que realizo la actividad");
		int opcionTiempoInicio = Integer.parseInt(input("--------------------Desea definir la fecha/hora actual como inicio o desdea definirlas usted o desea cronometarr una actividad. 0 (preedefinir), 1 (modificar), 2 (cronometrar)----------"));
		if (opcionTiempoInicio == 0)
		{
			LocalDateTime locaDate = LocalDateTime.now();
			int HoraInicioActividad  = locaDate.getHour();
			int MinutoInicioActividad = locaDate.getMinute();
			
			Calendar fecha = Calendar.getInstance();
			int A駉InicioActividad = fecha.get(Calendar.YEAR);
	        int MesInicioActividad = fecha.get(Calendar.MONTH) + 1;
	        int DiaInicioActividad = fecha.get(Calendar.DAY_OF_MONTH);
			
			int HoraFinalActividad = Integer.parseInt(input("Por favor coloque la hora de finalizacion(en formato de 24 horas)"));
			int MinutoFinalActividad = Integer.parseInt(input("Por favor coloque la minuto de finalizacion"));
			ManejadorProyecto.CrearRegistro(TituloActividad,DescripcionActividad,TipoActividad,DiaInicioActividad,MesInicioActividad,A駉InicioActividad,HoraInicioActividad,MinutoInicioActividad,HoraFinalActividad,MinutoFinalActividad,NombreCreadorProyecto,CorreoCreadorProyecto);
		}
		
		else if (opcionTiempoInicio == 1)
		{
			int HoraInicioActividad = Integer.parseInt(input("Por favor coloque la hora de inicio(en formato de 24 horas)"));
			int MinutoInicioActividad = Integer.parseInt(input("Por favor coloque la minuto de inicio"));
			
			int DiaInicioActividad = Integer.parseInt(input("Por favor coloque el dia de inicio"));
			int MesInicioActividad = Integer.parseInt(input("Por favor coloque el mes de inicio"));
			int A駉InicioActividad = Integer.parseInt(input("Por favor coloque el a駉 de inicio"));
			
			int HoraFinalActividad = Integer.parseInt(input("Por favor coloque la hora de finalizacion(en formato de 24 horas)"));
			int MinutoFinalActividad = Integer.parseInt(input("Por favor coloque la minuto de finalizacion"));
			ManejadorProyecto.CrearRegistro(TituloActividad,DescripcionActividad,TipoActividad,DiaInicioActividad,MesInicioActividad,A駉InicioActividad,HoraInicioActividad,MinutoInicioActividad,HoraFinalActividad,MinutoFinalActividad,NombreCreadorProyecto,CorreoCreadorProyecto);
		}
		
		else if (opcionTiempoInicio == 2)
		{
			int HoraInicioActividad = 0;
			int MinutoInicioActividad= 0;
			int A駉InicioActividad= 0;
			int MesInicioActividad= 0;
			int DiaInicioActividad= 0;
			int HoraFinalActividad = 0;
			int MinutoFinalActividad = 0;
			int opcionTiempoCronometro = Integer.parseInt(input("Marque 0 para empezar a cronometrar la actividad"));
			if (opcionTiempoCronometro == 0)
			{
				LocalDateTime locaDate = LocalDateTime.now();
				HoraInicioActividad  = locaDate.getHour();
				MinutoInicioActividad = locaDate.getMinute();
			}
			int opcionfecha= Integer.parseInt(input("Quiere predefinir las fecha de inicio (marque 0), quiere modificar la fecha (marque 1)"));
			if (opcionfecha == 0)
			{
				Calendar fecha = Calendar.getInstance();
				A駉InicioActividad = fecha.get(Calendar.YEAR);
				MesInicioActividad = fecha.get(Calendar.MONTH) + 1;
				DiaInicioActividad = fecha.get(Calendar.DAY_OF_MONTH);
			}
			else if (opcionfecha == 1)
			{
				DiaInicioActividad = Integer.parseInt(input("Por favor coloque el dia de inicio"));
				MesInicioActividad = Integer.parseInt(input("Por favor coloque el mes de inicio"));
				A駉InicioActividad = Integer.parseInt(input("Por favor coloque el a駉 de inicio"));
			}
			int opcionTiempoCronometrofin = Integer.parseInt(input("Marque 1 para parar de cronometrar la actividad"));
			if (opcionTiempoCronometrofin == 1)	
			{
				LocalDateTime locaDatefiNAL = LocalDateTime.now();
				HoraFinalActividad  = locaDatefiNAL.getHour();
				MinutoFinalActividad = locaDatefiNAL.getMinute();
			}
			ManejadorProyecto.CrearRegistro(TituloActividad,DescripcionActividad,TipoActividad,DiaInicioActividad,MesInicioActividad,A駉InicioActividad,HoraInicioActividad,MinutoInicioActividad,HoraFinalActividad,MinutoFinalActividad,NombreCreadorProyecto,CorreoCreadorProyecto);
		}
		
		String proyecto = ejecutarSeleccionProyecto();
		ManejadorProyecto.GuardarReporte(proyecto);
	}
	
	private void ejecutarGenerarReporte() throws FileNotFoundException, IOException
	{
		
		System.out.println("\n" + "Porfavor llene toda la informacion qeu se le solicita" + "\n");
		String proyecto = ejecutarSeleccionProyecto();
		Map<String, String> registros = ManejadorRegistro.CargarRegistrosTiempoTotal(proyecto);
		Map<String, Map<String, String>> registrosDia = ManejadorRegistro.CargarRegistrosTiempoDia(proyecto);
		Map<String, Map<String, String>> registrosTipo = ManejadorRegistro.CargarRegistrosTiempoTipo(proyecto);
		Map<String, Map<String, String>> registrosTipoCantidad = ManejadorRegistro.CargarRegistrosCantidadTipo(proyecto);
		Map<String, Map<String, String>> registrosActividadCantidad = ManejadorRegistro.CargarRegistrosCantidadActividad(proyecto);
		ejecutarImprimirReporteTotal(registros,registrosActividadCantidad);
		ejecutarImprimirReporteDia(registrosDia);
		ejecutarImprimirReporteTipo(registrosTipoCantidad,registrosTipo);
	}
	
	private String ejecutarSeleccionProyecto() throws FileNotFoundException, IOException
	{
		System.out.println("\n" + "Seleccione un proyecto" + "\n");
		List<String> ProyectoCreados = ManejadorProyecto.CargarProyectos();
		
		int opciones = 0;
		
		for (String proyecto : ProyectoCreados)
		{
			String ProyectoLista = String.valueOf(opciones) + " " + proyecto + "\n";
			System.out.println(ProyectoLista);
			opciones += 1;
		}
		
		int opcion = Integer.parseInt(input("Por favor seleccione una opcion de proyecto"));
		
		String proyectoseleccionado = ProyectoCreados.get(opcion);
		
		return proyectoseleccionado;
	}
	
	private void ejecutarAgregarParticipante() throws FileNotFoundException, IOException
	{
		
		System.out.println("\n" + "Porfavor llene toda la informacion qeu se le solicita" + "\n");
		String nombreparticpanteagregar = input("Por favor ingrese el nombre del participante");
		String correoparticpanteagregar = input("Por favor ingrese el nombre del participante");
		ManejadorProyecto.AgregarParticpanteNuevo(nombreparticpanteagregar, correoparticpanteagregar);
		
	}
	
	private void ejecutarImprimirReporteTipo(Map<String, Map<String, String>> registroCantidad, Map<String, Map<String, String>> registrotiempotipo) throws FileNotFoundException, IOException
	{
		
		System.out.println("\n" + "***********************************Reporte por Tipo de actividdad de cada participante del proyecto (que realizo actividades)***********************************" + "\n");
		
		Set<String> llavesmapa = registroCantidad.keySet();
		
		for (String llave : llavesmapa)
		{
			System.out.println("\n" + "------------------------------------ Nombre: " +  llave + "------------------------------------" + "\n");
			
			Map<String, String> MapaCantidad = registroCantidad.get(llave);
			
			Map<String, String> MapaTipos = registrotiempotipo.get(llave);
			
			Set<String> llavesmapaTipo = MapaCantidad.keySet();
			
			for (String llaveCantidad : llavesmapaTipo)
			{
				String Cantidad = MapaCantidad.get(llaveCantidad);
				String Tiempo = MapaTipos.get(llaveCantidad);
				
				String Promedio = String.valueOf(Integer.valueOf(Tiempo)/Integer.valueOf(Cantidad));
				
				System.out.println("\n" + "  Tipo: " + llaveCantidad + " =====  tiempo promedio: " + Promedio + "\n");
			}
		}
		
	}
	
	private void ejecutarImprimirReporteDia(Map<String, Map<String, String>> registroDia) throws FileNotFoundException, IOException
	{
		
		System.out.println("\n" + "***********************************Reporte por Dia (activo) de cada participante del proyecto (que realizo actividades)***********************************" + "\n");
		
		Set<String> llavesmapa = registroDia.keySet();
		
		for (String llave : llavesmapa)
		{
			System.out.println("\n" + "------------------------------------ Nombre: " +  llave + "------------------------------------" + "\n");
			
			Map<String, String> MapaDia = registroDia.get(llave);
			
			Set<String> llavesmapaTipo = MapaDia.keySet();
			
			for (String llaveDia : llavesmapaTipo)
			{
				String Tiempo = MapaDia.get(llaveDia);
				
				System.out.println("\n" + "  Dia: " + llaveDia + " =====  tiempo: " + Tiempo + "\n");
			}
		}
		
	}
	
	private void ejecutarImprimirReporteTotal(Map<String,String> registroTotal, Map<String, Map<String, String>> Actividadcantidad) throws FileNotFoundException, IOException
	{
		
		System.out.println("\n" + "***********************************Reporte tiempo total de cada participante del proyecto (que realizo actividades)***********************************" + "\n");
		
		Set<String> llavesmapa = registroTotal.keySet();
		
		for (String llave : llavesmapa)
		{
			System.out.println("\n" + "------------------------------------ Nombre: " +  llave + "------------------------------------" + "\n");
			
			String Total = registroTotal.get(llave);
			
			System.out.println("\n" + " tiempo Total invertido : " + Total + "\n");
			
			Map<String, String> Activadadesmapa = Actividadcantidad.get(llave);
			
			Set<String> CantidadMapa = Activadadesmapa.keySet();
			
			String cantidadactividades = String.valueOf(CantidadMapa.size());
			
			System.out.println("\n" + " Realizo la siguiente cantidad de actividades diferentes : " + cantidadactividades + "\n");
			
			System.out.println("\n" + " Entre las actividades qeu realizo estan las siguientes : " + "\n");
			
			for (String llaveActividades : CantidadMapa)
			{
				String Tiempo = Activadadesmapa.get(llaveActividades);
				
				System.out.println("\n" + "  Nombre Actividad: " + llaveActividades + " =====  tiempo total: " + Tiempo + "\n");
			}
		}
		
	}
	
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		AplicacionProyecto consola = new AplicacionProyecto();
		consola.ejecutarAplicacion();
	}
	
}