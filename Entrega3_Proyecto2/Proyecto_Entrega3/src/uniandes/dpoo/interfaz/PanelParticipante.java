package uniandes.dpoo.interfaz;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelParticipante extends JPanel 

{
	
	private JLabel lblNombreParti;
	private JTextField txtNombreParti;
	private JLabel lblTiempoTotal;
	private JTextField txtTiempoTotal;
	private JLabel lblTiempoTipo;
	private JTextArea txtTiempoTipo;
	private JLabel lblTiempoActi;
	private JTextArea txtTiempoActi;
	
	public PanelParticipante () 
	{
		setBorder( new TitledBorder ( "R.  Participante" ));
		setLayout( new GridLayout(4, 2));
		
		lblNombreParti = new JLabel( " Nombre Part: " );
		txtNombreParti = new JTextField( "nombre...." );
		txtNombreParti.setEditable( false );
		add(lblNombreParti);
		add(txtNombreParti);
		
		lblTiempoTotal = new JLabel( " Tiempo Total: " );
		txtTiempoTotal = new JTextField( "Total...." );
		txtTiempoTotal.setEditable( false );
		add(lblTiempoTotal);
		add(txtTiempoTotal);
		
		lblTiempoTipo = new JLabel( " Tiempo por Tipo: " );
		txtTiempoTipo = new JTextArea( "Tipo...." );
		txtTiempoTipo.setEditable( false );
		add(lblTiempoTipo);
		add(txtTiempoTipo);
		
		lblTiempoActi = new JLabel( " Tiempo por Dia: " );
		txtTiempoActi = new JTextArea( "Acti...." );
		txtTiempoActi.setEditable( false );
		add(lblTiempoActi);
		add(txtTiempoActi);
	}
	
	public void actualizar(String nombre, String total, String tiempodia, String tiempotipo)
    {

		txtNombreParti.setText( nombre );
		txtTiempoTotal.setText( total );
		txtTiempoTipo.setText( tiempotipo );
		txtTiempoActi.setText( tiempodia );
    }

}
