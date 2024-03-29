package Presentación.Departamento;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import javax.swing.SwingConstants;
import java.awt.Color;

public class panelCalcularNomina extends JPanel implements Ventana{
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnCalcularNmina;
/*	private JTextArea textArea;
	private JScrollPane scroll;*/
	/**
	 * Create the panel.
	 */

	public panelCalcularNomina() {
	
		initComponent();
	}
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		btnCalcularNmina = new JButton("Calcular nómina");
		btnCalcularNmina.setBackground(Color.WHITE);
		btnCalcularNmina.setBounds(434, 68, 171, 42);
		add(btnCalcularNmina);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(83, 68, 171, 42);
		add(textField);
	/*	textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 136, 522, 281);
		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false)*/

		JLabel lblIntroduceElId = new JLabel("ID del departamento");
		lblIntroduceElId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntroduceElId.setBounds(260, 80, 300, 16);
		add(lblIntroduceElId);

		btnCalcularNmina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Contexto contexto = new Contexto (Evento.CalcularNominaCommand,Integer.valueOf(textField.getText()));
					ApplicationController.getInstance().ejecutar(contexto);
				}catch(NumberFormatException x){
					JOptionPane.showMessageDialog(null, "Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}
			}
		});

	}
	@Override
	public void actualizar(Contexto contexto) {
		/*textArea.setVisible(true);
		String s = "La suma de la nomina de los empleados es de " + (int)contexto.getDato() + " al mes";
		textArea.setText(s);*/

	}
	
	public void resetCamps(){
		
		//textArea.setText(null);
		textField.setText(null);
		
	}
}
