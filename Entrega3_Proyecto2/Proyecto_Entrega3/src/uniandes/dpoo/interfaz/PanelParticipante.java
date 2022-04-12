package uniandes.dpoo.interfaz;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelParticipante extends JPanel 

{
	
	private JLabel lblNombreParti;
	private JTextField txtNombreParti;
	private JLabel lblTiempoTotal;
	private JTextField txtTiempoTotal;
	private JLabel lblTiempoTipo;
	private JTextField txtTiempoTipo;
	private JLabel lblTiempoActi;
	private JTextField txtTiempoActi;
	
	public PanelParticipante () 
	{
		setBorder( new TitledBorder ( "R.  Participante" ));
		setLayout( new GridLayout(4, 2));
		
		lblNombreParti = new JLabel( " Nombre Part: " );
		txtNombreParti = new JTextField( "nombre...." );
		add(lblNombreParti);
		add(txtNombreParti);
		
		lblTiempoTotal = new JLabel( " Tiempo Total: " );
		txtTiempoTotal = new JTextField( "Total...." );
		add(lblTiempoTotal);
		add(txtTiempoTotal);
		
		lblTiempoTipo = new JLabel( " Tiempo Tipo: " );
		txtTiempoTipo = new JTextField( "Tipo...." );
		add(lblTiempoTipo);
		add(txtTiempoTipo);
		
		lblTiempoActi = new JLabel( " Tiempo Acti: " );
		txtTiempoActi = new JTextField( "Acti...." );
		add(lblTiempoActi);
		add(txtTiempoActi);
	}

}
