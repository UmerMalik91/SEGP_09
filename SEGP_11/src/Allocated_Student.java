import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class Allocated_Student extends JPanel {
	private JTable table;
	private DefaultTableModel dtm;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public Allocated_Student() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Allocated Student of");
		lblNewLabel.setBounds(10, 11, 148, 14);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 36, 266, 330);
		add(panel);
		panel.setLayout(null);
		
		
		Object colm[]={"Uob","Name"};
		Object row[][]={{"14031246","Saleem Khan"},{"14031279","Nisar Ali"}};
		
		dtm = new DefaultTableModel(row,colm);	
		
		table = new JTable(dtm);
		table.setBounds(0, 357, 266, -353);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 357, 266, -353);
		panel.add(scrollPane);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(276, 36, 448, 330);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Image_Icon");
		lblNewLabel_1.setBounds(10, 11, 101, 103);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(121, 11, 46, 14);
		panel_1.add(lblName);
		
		JLabel lblUob = new JLabel("UoB");
		lblUob.setBounds(121, 55, 46, 14);
		panel_1.add(lblUob);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(121, 91, 66, 14);
		panel_1.add(lblDepartment);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(121, 126, 46, 14);
		panel_1.add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact#");
		lblContact.setBounds(121, 167, 66, 14);
		panel_1.add(lblContact);
		
		textField = new JTextField();
		textField.setBounds(219, 11, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblPat = new JLabel("PAT");
		lblPat.setBounds(121, 207, 46, 14);
		panel_1.add(lblPat);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(121, 243, 66, 14);
		panel_1.add(lblAddress);
		
		JButton btnChangePat = new JButton("Change PAT");
		btnChangePat.setBounds(22, 296, 107, 23);
		panel_1.add(btnChangePat);
		
		JButton btnNewButton = new JButton("Remove Entery");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(139, 296, 116, 23);
		panel_1.add(btnNewButton);
		
		JCheckBox chckbxEnableEditing = new JCheckBox("Enable Editing");
		chckbxEnableEditing.setBounds(278, 296, 109, 23);
		panel_1.add(chckbxEnableEditing);
		
		textField_1 = new JTextField();
		textField_1.setBounds(219, 52, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(219, 88, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(219, 123, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(219, 167, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(219, 204, 86, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(205, 238, 182, 48);
		panel_1.add(textArea);

	}
}
