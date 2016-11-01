import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.UpdatableResultSet;

import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.Font;

public class Student extends JPanel {
	private JTextField tSName;
	private JTextField tUoB;
	private JTextField tSDepartment;
	private JTextField tSEmail;
	private JTextField tSContactNo;
	private JTextField tYear;
	private JTable table;
	private JTable studentsTable;
	private DefaultTableModel dtm;
	private String patID;
	private String patName;
	JLabel lListOfStudents;
	ArrayList<ArrayList<String>> PAT_Data=new ArrayList<ArrayList<String>>();
	Object[][] student_Table_data=null;
	JScrollPane scrollPaneStudent,scrollPaneStudent1;
	JPanel panel ;
	JCheckBox cbSEnableEditing;
	JButton btnChangePAT;
	JButton btnSRemoveEntry;
	JButton save;
	String beforeEditContact,afterEditContact;
	String Year,depart;
	
	/**
	 * Create the panel.
	 */
	public Student() {
		setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 36, 266, 330);
		add(panel);
		Object colm[]={"UoB","Name"};

		dtm = new DefaultTableModel(student_Table_data,colm);
		table = new JTable(dtm);
		table.setBounds(10, 15, 246, 331);
//		studentsTable = new JTable(dtm);
		scrollPaneStudent = new JScrollPane(table);
		scrollPaneStudent.setBounds(0, 0, 266, 330);
		panel.add(scrollPaneStudent);

		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(276, 36, 448, 330);
		add(panel_1);

		JLabel lSNmae = new JLabel("Name");
		lSNmae.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lSNmae.setBounds(140, 17, 66, 17);
		panel_1.add(lSNmae);

		JLabel lUoB = new JLabel("UoB");
		lUoB.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lUoB.setBounds(140, 51, 46, 27);
		panel_1.add(lUoB);

		JLabel lSDepartment = new JLabel("Department");
		lSDepartment.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lSDepartment.setBounds(140, 89, 116, 33);
		panel_1.add(lSDepartment);

		JLabel lStEmail = new JLabel("Email");
		lStEmail.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lStEmail.setBounds(140, 140, 76, 27);
		panel_1.add(lStEmail);

		JLabel lSContactNo = new JLabel("Contact#");
		lSContactNo.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lSContactNo.setBounds(140, 179, 94, 23);
		panel_1.add(lSContactNo);

		tSName = new JTextField();
		tSName.setEditable(false);
		tSName.setColumns(10);
		tSName.setBounds(255, 8, 180, 29);
		panel_1.add(tSName);

		JLabel lSPat = new JLabel("Year");
		lSPat.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lSPat.setBounds(140, 228, 46, 23);
		panel_1.add(lSPat);

		btnChangePAT = new JButton("Change PAT");
		btnChangePAT.setEnabled(false);
		btnChangePAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String patName = JOptionPane.showInputDialog(null, "Enter PAT Name");
				
				
			}
		});
		btnChangePAT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnChangePAT.setBounds(126, 290, 122, 29);
		panel_1.add(btnChangePAT);

		btnSRemoveEntry = new JButton("Remove Entry");
		btnSRemoveEntry.setEnabled(false);
		btnSRemoveEntry.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSRemoveEntry.setBounds(249, 290, 119, 29);
		panel_1.add(btnSRemoveEntry);
		btnSRemoveEntry.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				   GetData data=new GetData();
				   data.setUpdate( "delete from student_information where UoB=\""+tUoB.getText()+"\";");
				   updateTable();
				   }
			     
		          
			
		});

		cbSEnableEditing = new JCheckBox("Enable Editing");
		cbSEnableEditing.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbSEnableEditing.setBounds(10, 291, 110, 29);
		panel_1.add(cbSEnableEditing);
		cbSEnableEditing.setEnabled(false);
		cbSEnableEditing.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                	tSContactNo.setEditable(true);
                	save.setEnabled(true);
                	beforeEditContact=tSContactNo.getText();
         
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	tSDepartment.setEditable(false);
                	tSContactNo.setEditable(false);
                }

                validate();
                repaint();
            }
        });

		tUoB = new JTextField();
		tUoB.setEditable(false);
		tUoB.setColumns(10);
		tUoB.setBounds(255, 52, 180, 29);
		panel_1.add(tUoB);

		tSDepartment = new JTextField();
		tSDepartment.setEditable(false);
		tSDepartment.setColumns(10);
		tSDepartment.setBounds(255, 93, 180, 29);
		panel_1.add(tSDepartment);

		tSEmail = new JTextField();
		tSEmail.setEditable(false);
		tSEmail.setColumns(10);
		tSEmail.setBounds(255, 141, 180, 29);
		panel_1.add(tSEmail);

		tSContactNo = new JTextField();
		tSContactNo.setEditable(false);
		tSContactNo.setColumns(10);
		tSContactNo.setBounds(255, 178, 180, 29);
		panel_1.add(tSContactNo);

		tYear = new JTextField();
		tYear.setEditable(false);
		tYear.setColumns(10);
		tYear.setBounds(255, 227, 180, 29);
		panel_1.add(tYear);
		
		save = new JButton("Save");
		save.setEnabled(false);
		save.setBounds(369, 290, 66, 27);
		panel_1.add(save);
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				afterEditContact=tSContactNo.getText();
				if(afterEditContact.equals(beforeEditContact)==false){
				   GetData data=new GetData();
				   data.setUpdate( "update student_information set personal_contact=\""
				   +afterEditContact+"\" where UoB=\""+tUoB.getText()+"\";");
				   
				}
				// TODO Auto-generated method stub
				
			}
			
		});

		lListOfStudents = new JLabel("List Of ");
		lListOfStudents.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lListOfStudents.setBounds(0, 11, 224, 25);
		add(lListOfStudents);
		
		JCheckBox sort = new JCheckBox("Sort");
		sort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sort.setBounds(220, 6, 97, 23);
		add(sort);
		sort.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
            	if(patID.equals(null)==false){
            		
            		getData4DB("select * from student_information where pat_id=\""+patID+"\"order by name;");
            		studentTableData();
            	}
            	else 
            		System.out.println(Year+depart);
            	
            }
		});

	}

	public void updateTable(){
		Object colm[]={"UoB","Name"};
		dtm = new DefaultTableModel(student_Table_data,colm);
		panel.remove(scrollPaneStudent);
		table = new JTable(dtm);
		table.setBounds(10, 15, 246, 331);
		
		scrollPaneStudent1 = new JScrollPane(table);
		scrollPaneStudent1.setBounds(0, 0, 266, 329);		
		panel.remove(scrollPaneStudent);
		panel.add(scrollPaneStudent1);

		panel.revalidate();
		panel.repaint();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				btnSRemoveEntry.setEnabled(true);
				btnChangePAT.setEnabled(true);
				cbSEnableEditing.setEnabled(true);
				selectedStudentInfo(table.getValueAt(table.getSelectedRow(), 0).toString());
				 
				
			}
			
		});
		
	}
	public void selectedStudentInfo(String value){
		getData4DB("select * from student_information where UoB="+value+";");
		int i=0;
			tUoB.setText(PAT_Data.get(1).get(i));
			i++;
			tSName.setText(PAT_Data.get(1).get(i));
			i++;
			tSEmail.setText(PAT_Data.get(1).get(i));
			i++;
			tYear.setText(PAT_Data.get(1).get(i));
			i++;
			tSDepartment.setText(PAT_Data.get(1).get(i));
			i++;
			tSContactNo.setText(PAT_Data.get(1).get(i));
		
		
		
	}
	public void setPatInfo(String patID,String patName){
		this.patID=patID;
		this.patName=patName;
		lListOfStudents.setText("Allocated students of "+patName);
		getData4DB("select * from student_information where pat_id="+patID+";");
//		getData4DB("select * from student_information;");
		studentTableData();		
		

	}
	public void stdDataPerYear(String year,String department){
		
		Year=year.substring(year.length()-1);
		depart=null;
		if(department.equals("CS")){
			depart="Computer Science";
		}
		else if(department.equals("EE")){
			depart="Electrical Engineering";
		}
		lListOfStudents.setText("List of "+year+"  "+depart+" students");
		getData4DB("select * from student_information where Year=\""+Year+"\"&& Department=\""+depart+"\";");
		
		studentTableData();
		
		
	}
	public void getData4DB(String Query){
		GetData data=new GetData();
		PAT_Data=data.getData("Student_data", Query);
	}
	public void studentTableData(){
		student_Table_data=new String[PAT_Data.size()-1][2];
		
			for(int i=1;i<PAT_Data.size();i++){
				for(int j=0;j<PAT_Data.get(i).size();j++){
				
					if(j==0){
						student_Table_data[i-1][j]=PAT_Data.get(i).get(j);
					}
					else if(j==1){
						student_Table_data[i-1][j]=PAT_Data.get(i).get(j);
						
					}
					
					
					
				}
			}			
			updateTable();
	}
}
