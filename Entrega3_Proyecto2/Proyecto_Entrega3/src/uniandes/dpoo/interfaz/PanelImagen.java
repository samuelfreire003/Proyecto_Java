package uniandes.dpoo.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelImagen extends JPanel

{
	
	private JLabel lblPanelPrincipal;
	
	public PanelImagen () 
	{
		lblPanelPrincipal = new JLabel();
		add(lblPanelPrincipal);
		ImageIcon img = new ImageIcon("./ImagenesDeAplicacion/PanelPrincipal.png");
		lblPanelPrincipal.setIcon(img);
	}

}
