import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class student extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private DefaultTableModel dtm;

	/**
	 * Create the panel.
	 */
	public student() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 36, 266, 330);
		add(panel);
		
		
		Object colm[]={"UoB","Name"};
		Object row[][]={{"14031246","Saleem Khan"},{"14031279","Nisar Ali"}};
		
		dtm = new DefaultTableModel(row,colm);	
		
		table = new JTable(dtm);
		table.setBounds(10, 15, 246, 331);
		
		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 266, 329);
		panel.add(scrollPane);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(276, 36, 448, 330);
		add(panel_1);
		
		JLabel label = new JLabel("Image_Icon");
		label.setBounds(10, 11, 101, 103);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(121, 11, 46, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("UoB");
		label_2.setBounds(121, 55, 46, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Department");
		label_3.setBounds(121, 91, 66, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Email:");
		label_4.setBounds(121, 126, 46, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Contact#");
		label_5.setBounds(121, 167, 46, 14);
		panel_1.add(label_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(219, 11, 86, 20);
		panel_1.add(textField);
		
		JLabel label_6 = new JLabel("PAT");
		label_6.setBounds(121, 207, 46, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Address");
		label_7.setBounds(121, 243, 46, 14);
		panel_1.add(label_7);
		
		JButton button = new JButton("Change PAT");
		button.setBounds(34, 299, 107, 23);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Remove Entery");
		button_1.setBounds(151, 299, 116, 23);
		panel_1.add(button_1);
		
		JCheckBox checkBox = new JCheckBox("Enable Editing");
		checkBox.setBounds(273, 299, 97, 23);
		panel_1.add(checkBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(219, 52, 86, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(219, 88, 86, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(219, 123, 86, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(219, 167, 86, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(219, 204, 86, 20);
		panel_1.add(textField_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(219, 243, 182, 44);
		panel_1.add(textArea);
		
		JLabel lblStudent = new JLabel("Student ");
		lblStudent.setBounds(10, 11, 46, 14);
		add(lblStudent);

	}

}
