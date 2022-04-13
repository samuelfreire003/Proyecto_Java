package uniandes.dpoo.interfaz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.dpoo.procesamiento.ManejadorProyecto;

public class PanelInfoProyectos extends JPanel

{
	
	private JLabel lblPanelPrincipal;
	
	private static JList<String> ListaProyecto;
	
	public PanelInfoProyectos () throws FileNotFoundException, IOException 
	{
		setBorder( new TitledBorder ( "Informacion Proyectos lista" ));
		
		List<String> ProyectoCreados = ManejadorProyecto.CargarProyectosconTipos();
		
		ListaProyecto =new JList();
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		
		
		for (String proyecto : ProyectoCreados)
		{
			String ProyectoLista = String.valueOf(proyecto);
			modelo.addElement(ProyectoLista);
			
		}
		
		ListaProyecto.setModel(modelo);
		
		add(ListaProyecto);
		
	}
	
	public static int Obteneropcion()
	{
		int proyecto = ListaProyecto.getSelectedIndex();
		return proyecto;
	}


}
