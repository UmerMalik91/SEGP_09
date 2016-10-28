import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;

public class Home extends JPanel {
	private JTable table;
	private DefaultTableModel dtm;
	private JTextField txtAdilrajanamaledupk;
	private JTextField textField;
	private JTextField txtAdilRaja;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel currentSubPanel;

	/**
	 * Create the panel.
	 */
	public Home() {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 770, 48);
		add(menuBar);
		
		JMenu mnPat = new JMenu("PAT");
		menuBar.add(mnPat);
		
		JMenu mnStudent = new JMenu("Student");
		menuBar.add(mnStudent);
		
		JMenu menu = new JMenu("2016");
		mnStudent.add(menu);
		
		JMenuItem mntmCs = new JMenuItem("CS");
		menu.add(mntmCs);
		
		JMenuItem mntmEe = new JMenuItem("EE");
		menu.add(mntmEe);
		
		JMenu menu_1 = new JMenu("2017");
		mnStudent.add(menu_1);
		
		JMenuItem mntmCs_1 = new JMenuItem("CS");
		menu_1.add(mntmCs_1);
		
		JMenuItem mntmEe_1 = new JMenuItem("EE");
		menu_1.add(mntmEe_1);
		
		JMenu menu_2 = new JMenu("2018");
		mnStudent.add(menu_2);
		
		JMenuItem mntmCs_2 = new JMenuItem("CS");
		menu_2.add(mntmCs_2);
		
		JMenuItem mntmEe_2 = new JMenuItem("EE");
		menu_2.add(mntmEe_2);
		
		JMenu mnImportData = new JMenu("Import Data");
		menuBar.add(mnImportData);
		
		JMenuItem mntmStudentData = new JMenuItem("Student Data");
		mnImportData.add(mntmStudentData);
		mntmStudentData.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	FileChooser fileChooser=new FileChooser();
		    	if(fileChooser.isFileSelected().equals("Not Valid")){
		    		System.out.println("Not Valid Extension");
		    	}
		    	else
		    		fileChooser.isFileSelected();
		    		
//		    	JFileChooser chooser = new JFileChooser();
//		        chooser.setCurrentDirectory(new java.io.File("."));
//		        chooser.setDialogTitle("Select Student Data file");
//		        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//		        chooser.setAcceptAllFileFilterUsed(false);
//
//		        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//		          System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
//		          System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
//		          System.out.println(chooser.getSelectedFile().length());
//		          System.out.println();
//		          String s=chooser.getSelectedFile().toString().substring(chooser.getSelectedFile().toString().length()-4);
//		          if(s.equals(".csv")){
//		        	  System.out.println(" valid Extension");
//		          }
//		          else 
//		        	  System.out.println("Not valid Extension");
//		        } else {
//		          System.out.println("No Selection ");
//		        }
	    }
	});
		
		JMenuItem mntmPatData = new JMenuItem("PAT Data");
		mnImportData.add(mntmPatData);
		
		JMenu mnRemoveData = new JMenu("Remove Data");
		menuBar.add(mnRemoveData);
		
		JMenu mnStudent_1 = new JMenu("Student");
		mnRemoveData.add(mnStudent_1);
		
		JMenuItem menuItem_3 = new JMenuItem("2016");
		mnStudent_1.add(menuItem_3);
		
		JMenu mnPatData = new JMenu("PAT Data");
		mnRemoveData.add(mnPatData);
		
		JMenuItem mntmSarfarazRaza = new JMenuItem("Sarfaraz Raza");
		mnPatData.add(mntmSarfarazRaza);
		
		JMenuItem mntmAmanUllah = new JMenuItem("Aman Ullah");
		mnPatData.add(mntmAmanUllah);
		
		JMenu mnCreatePdf = new JMenu("Create PDF");
		menuBar.add(mnCreatePdf);
		
		JMenuItem mntmPatList = new JMenuItem("PAT List");
		mnCreatePdf.add(mntmPatList);
		
		JMenu mnStudentList = new JMenu("Student List");
		mnCreatePdf.add(mnStudentList);
		
		
		
		JCheckBoxMenuItem chckbxmntmBatch_1 = new JCheckBoxMenuItem("Batch 2017");
		mnStudentList.add(chckbxmntmBatch_1);
		
		JCheckBoxMenuItem chckbxmntmBatch = new JCheckBoxMenuItem("Batch 2018");
		mnStudentList.add(chckbxmntmBatch);
		
		JCheckBoxMenuItem chckbxmntmBatch_2 = new JCheckBoxMenuItem("Batch 2019");
		mnStudentList.add(chckbxmntmBatch_2);
		
		JMenu mnAllocatedStudentOf = new JMenu("Allocated Student of");
		mnCreatePdf.add(mnAllocatedStudentOf);
		
		JMenuItem mntmSarmadAli = new JMenuItem("Sarmad Ali");
		mnAllocatedStudentOf.add(mntmSarmadAli);
		
		JMenuItem mntmAdilRaja = new JMenuItem("Adil Raja");
		mnAllocatedStudentOf.add(mntmAdilRaja);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 59, 750, 382);
		add(panel_2);
		currentSubPanel=panel_2;
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAT List");
		lblNewLabel.setBounds(10, 11, 132, 14);
		panel_2.add(lblNewLabel);

		Object colm[]={"Name","Department"};
		Object row[][]={{"Adil Raja","CS"},{"Sarmad Ali","CS"}};
		
		dtm = new DefaultTableModel(row,colm);		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 36, 266, 330);
		panel_2.add(panel);
		panel.setLayout(null);
		
		
		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 266, 329);
		panel.add(scrollPane);
//		scrollPane.setColumnHeaderView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(276, 36, 448, 330);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPATName = new JLabel("Name");
		lblPATName.setBounds(151, 28, 57, 14);
		panel_1.add(lblPATName);
		
		JLabel lblComputerScience = new JLabel("Department");
		lblComputerScience.setBounds(151, 80, 71, 14);
		panel_1.add(lblComputerScience);
		
		txtAdilrajanamaledupk = new JTextField();
		txtAdilrajanamaledupk.setEditable(false);
		txtAdilrajanamaledupk.setText("Adil.Raja@namal.edu.pk");
		txtAdilrajanamaledupk.setBounds(239, 105, 145, 20);
		panel_1.add(txtAdilrajanamaledupk);
		txtAdilrajanamaledupk.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 11, 118, 114);
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("0304-2112121");
		textField.setBounds(239, 144, 145, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblAssociateProfessor = new JLabel("Designation");
		lblAssociateProfessor.setBounds(151, 53, 71, 14);
		panel_1.add(lblAssociateProfessor);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(151, 108, 46, 14);
		panel_1.add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact #");
		lblContact.setBounds(151, 147, 64, 14);
		panel_1.add(lblContact);
		
		JLabel lblOfficeHours = new JLabel("Office hours");
		lblOfficeHours.setBounds(151, 195, 64, 14);
		panel_1.add(lblOfficeHours);
		
		JLabel lblLoaded = new JLabel("Allocation Load");
		lblLoaded.setBounds(151, 238, 91, 14);
		panel_1.add(lblLoaded);
		
		txtAdilRaja = new JTextField();
		txtAdilRaja.setEditable(false);
		txtAdilRaja.setText("Adil Raja");
		txtAdilRaja.setBounds(239, 25, 145, 20);
		panel_1.add(txtAdilRaja);
		txtAdilRaja.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Allocated Student");
		btnNewButton_1.setBounds(32, 294, 130, 23);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Allocated_Student p2=new Allocated_Student();
				p2.setBounds(currentSubPanel.getBounds());
				remove(currentSubPanel);
				currentSubPanel=p2;
				add(p2);

				revalidate();
				repaint();


				// TODO Auto-generated method stub

			}

		});
		
		JCheckBox chckbxEnableEditing = new JCheckBox("Enable Editing");
		chckbxEnableEditing.setBounds(168, 294, 97, 23);
		panel_1.add(chckbxEnableEditing);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(239, 192, 57, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setBounds(306, 195, 46, 14);
		panel_1.add(lblTo);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(328, 192, 57, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(239, 235, 146, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(239, 50, 145, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(238, 77, 146, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		
	}
}
