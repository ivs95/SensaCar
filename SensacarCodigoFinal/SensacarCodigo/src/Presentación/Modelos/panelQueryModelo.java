/**
 * 
 */
package Presentación.Modelos;

import javax.swing.JPanel;

import Presentación.Ventana;
import Presentación.Comandos.Contexto;
import Presentación.Comandos.Evento;
import Presentación.Controlador.ApplicationController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


import Integración.Modelos.TModelo;
import Integración.Query.TQuery;
import javax.swing.SwingConstants;
import java.awt.Color;
/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author nacho710
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class panelQueryModelo extends JPanel implements Ventana {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fechaText;
	private JTextField ventasText;
	private JTextArea textArea;
	public panelQueryModelo() {
		setLayout(null);
		setOpaque(false);
		fechaText = new JTextField();
		fechaText.setHorizontalAlignment(SwingConstants.CENTER);
		fechaText.setBounds(67, 51, 265, 45);
		add(fechaText);
		fechaText.setColumns(10);
		
		ventasText = new JTextField();
		ventasText.setHorizontalAlignment(SwingConstants.CENTER);
		ventasText.setBounds(67, 145, 265, 45);
		add(ventasText);
		ventasText.setColumns(10);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBackground(Color.WHITE);
		
		btnNewButton.setBounds(518, 51, 99, 59);
		add(btnNewButton);
		
		JLabel lblFecha = new JLabel("Fecha (yyyy-mm-dd)");
		lblFecha.setBounds(369, 66, 115, 14);
		add(lblFecha);
		
		JLabel lblNDeVentas = new JLabel("N\u00BA de ventas");
		lblNDeVentas.setBounds(369, 160, 72, 14);
		add(lblNDeVentas);
		 textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setVisible(true);
	    scroll.setBounds(67, 231, 437, 178);
	    add(scroll);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				java.sql.Date d=Date.valueOf(fechaText.getText());
				TQuery query = new TQuery(Integer.valueOf(ventasText.getText()), d);
				Contexto contexto = new Contexto(Evento.QueryModeloCommand,query);
				ApplicationController.getInstance().ejecutar(contexto);
			}
		});
	}
	@Override
	public void actualizar(Contexto contexto) {
		String s ="";
		ArrayList<TModelo> array = (ArrayList<TModelo>) contexto.getDato();
		for ( TModelo m : array){
			s+= "ID:		"+ m.getID() + "\n "+ "Nombre: 		" + m.getNombre() +"\n "+ "Precio:		"+m.getPrecio() +"\nStock:		"+ m.getStock() +"\nTipo:		"+ m.getTipoVehiculo() + "\n\n";
		}
		textArea.setText(s);
		
	}
	@Override
	public void resetCamps() {
		this.fechaText.setText(null);
		this.textArea.setText(null);
		this.ventasText.setText(null);
		
	}
}