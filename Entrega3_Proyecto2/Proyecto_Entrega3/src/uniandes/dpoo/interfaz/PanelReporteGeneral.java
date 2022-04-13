package uniandes.dpoo.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import uniandes.dpoo.consola.AplicacionProyecto;
import uniandes.dpoo.procesamiento.ManejadorProyecto;
import uniandes.dpoo.procesamiento.ManejadorRegistro;

public class PanelReporteGeneral extends JPanel
{
	
	private JList<String> ListaProyecto;
	
	private JTextPane texto;
	
	public PanelReporteGeneral () throws FileNotFoundException, IOException 
	{
		setBorder( new TitledBorder ( "Informacion Proyectos lista" ));
		setLayout( new BorderLayout());
		
		List<String> ProyectoCreados = ManejadorProyecto.CargarProyectos();
		
		texto = new JTextPane();
		
		int opcion = PanelInfoProyectos.Obteneropcion();
		String proyecto = ProyectoCreados.get(opcion);
		Map<String, String> registros = ManejadorRegistro.CargarRegistrosTiempoTotal(proyecto);
		Map<String, Map<String, String>> registrosDia = ManejadorRegistro.CargarRegistrosTiempoDia(proyecto);
		Map<String, Map<String, String>> registrosTipo = ManejadorRegistro.CargarRegistrosTiempoTipo(proyecto);
		Map<String, Map<String, String>> registrosTipoCantidad = ManejadorRegistro.CargarRegistrosCantidadTipo(proyecto);
		Map<String, Map<String, String>> registrosActividadCantidad = ManejadorRegistro.CargarRegistrosCantidadActividad(proyecto);
		
		String textofinal = "";
		
		String reportetotal = textoRegistrototal(registros,registrosActividadCantidad);
		String reportedia = textoRegistrodia(registrosDia);
		String reportetipo = textoRegistrotipo(registrosTipoCantidad,registrosTipo);
		
		textofinal += reportetotal;
		textofinal += reportedia;
		textofinal += reportetipo;
		
		texto.setText(textofinal);
		
		texto.setEditable(false);
		
		JScrollPane sampleScrollPane = new JScrollPane (texto);
		sampleScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		add(sampleScrollPane);
		
	}
	
	private String textoRegistrototal (Map<String,String> registroTotal, Map<String, Map<String, String>> Actividadcantidad)
	{
		String texto = ("\n" + "***********************************Reporte tiempo total de cada participante del proyecto (que realizo actividades)***********************************" + "\n");
		
		Set<String> llavesmapa = registroTotal.keySet();
		
		for (String llave : llavesmapa)
		{
			texto += ("\n" + "------------------------------------ Nombre: " +  llave + "------------------------------------" + "\n");
			
			String Total = registroTotal.get(llave);
			
			texto += ("\n" + " tiempo Total invertido : " + Total + "\n");
			
			Map<String, String> Activadadesmapa = Actividadcantidad.get(llave);
			
			Set<String> CantidadMapa = Activadadesmapa.keySet();
			
			String cantidadactividades = String.valueOf(CantidadMapa.size());
			
			texto += ("\n" + " Realizo la siguiente cantidad de actividades diferentes : " + cantidadactividades + "\n");
			
			texto += ("\n" + " Entre las actividades qeu realizo estan las siguientes : " + "\n");
			
			for (String llaveActividades : CantidadMapa)
			{
				String Tiempo = Activadadesmapa.get(llaveActividades);
				
				texto += ("\n" + "  Nombre Actividad: " + llaveActividades + " =====  tiempo total: " + Tiempo + "\n");
			}
		}
		
		return texto;
	}
	
	private String textoRegistrodia (Map<String, Map<String, String>> registroDia)
	{
		
		String texto = ("\n" + "***********************************Reporte por Dia (activo) de cada participante del proyecto (que realizo actividades)***********************************" + "\n");
		
		Set<String> llavesmapa = registroDia.keySet();
		
		for (String llave : llavesmapa)
		{
			texto += ("\n" + "------------------------------------ Nombre: " +  llave + "------------------------------------" + "\n");
			
			Map<String, String> MapaDia = registroDia.get(llave);
			
			Set<String> llavesmapaTipo = MapaDia.keySet();
			
			for (String llaveDia : llavesmapaTipo)
			{
				String Tiempo = MapaDia.get(llaveDia);
				
				texto += ("\n" + "  Dia: " + llaveDia + " =====  tiempo: " + Tiempo + "\n");
			}
		}
		
		return texto;
	}
	
	private String textoRegistrotipo (Map<String, Map<String, String>> registroCantidad, Map<String, Map<String, String>> registrotiempotipo)
	{
		
		String texto = ("\n" + "***********************************Reporte por Tipo de actividdad de cada participante del proyecto (que realizo actividades)***********************************" + "\n");
		
		Set<String> llavesmapa = registroCantidad.keySet();
		
		for (String llave : llavesmapa)
		{
			texto += ("\n" + "------------------------------------ Nombre: " +  llave + "------------------------------------" + "\n");
			
			Map<String, String> MapaCantidad = registroCantidad.get(llave);
			
			Map<String, String> MapaTipos = registrotiempotipo.get(llave);
			
			Set<String> llavesmapaTipo = MapaCantidad.keySet();
			
			for (String llaveCantidad : llavesmapaTipo)
			{
				String Cantidad = MapaCantidad.get(llaveCantidad);
				String Tiempo = MapaTipos.get(llaveCantidad);
				
				String Promedio = String.valueOf(Integer.valueOf(Tiempo)/Integer.valueOf(Cantidad));
				
				texto += ("\n" + "  Tipo: " + llaveCantidad + " =====  tiempo promedio: " + Promedio + "\n");
			}
		}
		
		return texto;
	}
	
}
