
package Presentación.Empleado;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Integración.Empleado.TEmpleado;
import Integración.Empleado.TEmpleadoCompleto;
import Integración.Empleado.TEmpleadoParcial;
import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;
import java.awt.Color;
import javax.swing.SwingConstants;


public class panelMostrarEmpleadoPorID extends JPanel implements Ventana {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton button;
	private JTextArea textArea;
	private JScrollPane scroll;



	public panelMostrarEmpleadoPorID() {
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		button = new JButton("Buscar Empleado");
		button.setBackground(Color.WHITE);
		button.setBounds(434, 68, 171, 42);
		add(button);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(83, 68, 339, 42);
		add(textField);
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 136, 522, 281);
		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);

		JLabel lblIntroduceElId = new JLabel("ID de empleado");
		lblIntroduceElId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntroduceElId.setBounds(198, 41, 110, 16);
		add(lblIntroduceElId);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Contexto contexto = new Contexto(Evento.MostrarEmpleadoCommand,
							Integer.valueOf(textField.getText()));
					ApplicationController.getInstance().ejecutar(contexto);
				} catch (NumberFormatException x) {
					JOptionPane.showMessageDialog(null,
							"Error al procesar, comprueba que los valores estan introducidos correctamente ");
				}

			}
		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		textArea.setVisible(true);
		String s = null;
		TEmpleado c = (TEmpleado) contexto.getDato();
		if (c.getActivo())
			s = "Activo";
		else
			s = "No activo";
		String text = "";
		text += "DNI: " + c.getDNI() + "\n" + "Nombre: " + c.getNombre() + "\n" + "Estado: " + s + "\n"
				+ "Departamento " + c.getDepartamento() + "\n";
		if (c instanceof TEmpleadoCompleto) {
			text += "Tipo de Contrato: Tiempo Completo\n";
			text += "Dietas : " + ((TEmpleadoCompleto) c).getDietas() + "\n";
			text += "Sueldo base : " + ((TEmpleadoCompleto) c).getDietas() + "\n";
		} else {
			text += "Tipo de Contrato: Tiempo Parcial\n";
			text += "Horas x Semana : " + ((TEmpleadoParcial) c).getHorasSemana() + "\n";
			text += "Sueldo x Hora : " + ((TEmpleadoParcial) c).getSueldoHora() + "\n";
		}
		textArea.setText(text);
	}

	public void resetCamps() {
		textArea.setText(null);
		textField.setText(null);
	}
}