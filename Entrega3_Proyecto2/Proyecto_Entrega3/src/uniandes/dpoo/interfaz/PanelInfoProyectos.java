package uniandes.dpoo.interfaz;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelInfoProyectos extends JPanel

{
	
	private JLabel lblPanelPrincipal;
	
	public PanelInfoProyectos () 
	{
		setBorder( new TitledBorder ( "Informacion Proyectos lista" ));
		lblPanelPrincipal = new JLabel( " hola como estan 2 1" );
		add(lblPanelPrincipal);
	}


}
