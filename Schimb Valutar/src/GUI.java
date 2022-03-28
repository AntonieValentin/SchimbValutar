import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	
	private char x;
	private final String monede[] = {"USD","EUR","CLF","GBP","MXN"};
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField textfield = new JTextField();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel("<html>Comisionul de conversie este de: <font color='red'> 1%</font></html>");
	JComboBox combobox =new JComboBox(monede);  
	JButton button = new JButton("Calculeaza Rata");
	
	public GUI() {
		
		label1.setText("Valoarea in lei:");
		label2.setText("Moneda dorita:");
		label1.setBounds(40,37,200,20);
		label2.setBounds(40,80,200,20);
		textfield.setBounds(150,40,200,20);
		combobox.setBounds(150,81,200,20);
		button.setBounds(135, 150, 150, 30);
		label3.setBounds(40,220,2000,20);
		
		panel.add(textfield);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(combobox);
		panel.add(button);
		panel.setLayout(null);
		
		frame.setSize(500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Schimb Valutar");
		frame.add(panel);
		frame.setVisible(true);
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ok = false;
				for(int i=0;i<textfield.getText().length();i++) {
					x = textfield.getText().charAt(i);
					if(!(x >= '0' && x <= '9')) {
						ok = true;
						break;
					}
					if(i == 0 && x == '0') {
						ok = true;
						break;
					}
				}
				if(textfield.getText().length() >= 15 || textfield.getText().length() == 0) {
					ok = true;
				}
				if(ok) {
					JOptionPane.showMessageDialog(frame, "Suma invalida!");
				}
				else {
					BigDecimal big = new BigDecimal(textfield.getText());
					String y = combobox.getSelectedItem().toString();
					new Schimb(big,y);
				}
			}
		
		});
	}
	
	
}
