import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Color;

public class Home extends JPanel implements ActionListener{
	private JTable tableOfTeacher;
	private DefaultTableModel dtm;
	private JTextField tTEmail;
	private JTextField tTPersonalContact;
	private JTextField tTName;
	private JTextField tTAllocationLoad;
	private JTextField tTDepartment;
	private JPanel currentSubPanel;
	ArrayList<ArrayList<String>> PAT_Data=new ArrayList<ArrayList<String>>();	
	Object[][] Pat_Table_data=null;
	private JTextField tTOfficeNo;
	private String selectedPatID;
	private String selectedPatName;
	JButton btnAllocatedStudent;
	String sDepartment;
	String sYear;
	JPanel panel_2;
	JCheckBox sort ;
	JTable currentTable=null;
	JPanel panel;
	JScrollPane scrollPaneTeacher,currentSrollPane;
	JCheckBox cbTEnableEditing;
	JButton save;
	String beforeEditContact,afterEditContact;
	/**
	 * Create the panel.
	 */
	public Home() {
		GetData data=new GetData();
		 PAT_Data=data.getData("PAT_data", "select * from pats_information;");
		Pat_Table_data=new String[PAT_Data.size()-1][2];
		
			for(int i=1;i<PAT_Data.size();i++){
				for(int j=0;j<PAT_Data.get(i).size();j++){
				
					if(j==1){
					Pat_Table_data[i-1][j-1]=PAT_Data.get(i).get(j);
					}
					else if(j==6){
						Pat_Table_data[i-1][j-5]=PAT_Data.get(i).get(j);
						
					}
					
					
				}
			}
			
	
//		      TableData tableData=new TableData();
//		      Pat_Table_data=tableData.getPATData(PAT_Data,"Name","Department");
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 736, 61);
		add(menuBar);
		
		
		JMenu mnPat = new JMenu("PAT");
		mnPat.setBackground(Color.BLACK);
		mnPat.setFont(new Font("Times New Roman", Font.BOLD, 19));
		menuBar.add(mnPat);
		mnPat.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new Home();				
				panel_2.setBounds(currentSubPanel.getBounds());
				remove(currentSubPanel);
				currentSubPanel=panel_2;
				add(panel_2);
				revalidate();
				repaint();
				

			}
		});

		
		JMenu mnStudent = new JMenu("Student");
		mnStudent.setFont(new Font("Times New Roman", Font.BOLD, 19));
		menuBar.add(mnStudent);
		
		JMenu mnYear = new JMenu("Year-4");
		mnStudent.add(mnYear);
		
		JMenuItem mntmCs = new JMenuItem("CS");
		mnYear.add(mntmCs);
		mntmCs.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JMenuItem menuItem = (JMenuItem)e.getSource();
		        JMenuItem jmi = (JMenuItem) e.getSource();
		        JPopupMenu jpm = (JPopupMenu) jmi.getParent();
		        JMenu menu = (JMenu) jpm.getInvoker();
		        sDepartment=menuItem.getText();
		        sYear=menu.getText();
		        Student std=new Student();
				changepanel(std);
				std.stdDataPerYear(sYear,sDepartment);
				
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JMenuItem mntmEe = new JMenuItem("EE");
		mnYear.add(mntmEe);
		mntmEe.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JMenuItem menuItem = (JMenuItem)e.getSource();
		        JMenuItem jmi = (JMenuItem) e.getSource();
		        JPopupMenu jpm = (JPopupMenu) jmi.getParent();
		        JMenu menu = (JMenu) jpm.getInvoker();
		        sDepartment=menuItem.getText();
		        sYear=menu.getText();
		        Student std=new Student();
				changepanel(std);
				std.stdDataPerYear(sYear,sDepartment);
				
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JMenu mnYear_1 = new JMenu("Year-3");
		mnStudent.add(mnYear_1);
		
		JMenuItem mntmCs_1 = new JMenuItem("CS");
		mnYear_1.add(mntmCs_1);
		mntmCs_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JMenuItem menuItem = (JMenuItem)e.getSource();
		        JMenuItem jmi = (JMenuItem) e.getSource();
		        JPopupMenu jpm = (JPopupMenu) jmi.getParent();
		        JMenu menu = (JMenu) jpm.getInvoker();
		        sDepartment=menuItem.getText();
		        sYear=menu.getText();
		        Student std=new Student();
				changepanel(std);
				std.stdDataPerYear(sYear,sDepartment);
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JMenuItem mntmEe_1 = new JMenuItem("EE");
		mnYear_1.add(mntmEe_1);
		mntmEe_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JMenuItem menuItem = (JMenuItem)e.getSource();
		        JMenuItem jmi = (JMenuItem) e.getSource();
		        JPopupMenu jpm = (JPopupMenu) jmi.getParent();
		        JMenu menu = (JMenu) jpm.getInvoker();
		        sDepartment=menuItem.getText();
		        sYear=menu.getText();
		        Student std=new Student();
				changepanel(std);
				std.stdDataPerYear(sYear,sDepartment);
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JMenu mnYear_2 = new JMenu("Year-2");
		mnStudent.add(mnYear_2);
		
		
		JMenuItem mntmCs_2 = new JMenuItem("CS");
		mnYear_2.add(mntmCs_2);
		mntmCs_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JMenuItem menuItem = (JMenuItem)e.getSource();
		        JMenuItem jmi = (JMenuItem) e.getSource();
		        JPopupMenu jpm = (JPopupMenu) jmi.getParent();
		        JMenu menu = (JMenu) jpm.getInvoker();
		        sDepartment=menuItem.getText();
		        sYear=menu.getText();
		        Student std=new Student();
				changepanel(std);
				std.stdDataPerYear(sYear,sDepartment);
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JMenuItem mntmEe_2 = new JMenuItem("EE");
		mnYear_2.add(mntmEe_2);
		mntmEe_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JMenuItem menuItem = (JMenuItem)e.getSource();
		        JMenuItem jmi = (JMenuItem) e.getSource();
		        JPopupMenu jpm = (JPopupMenu) jmi.getParent();
		        JMenu menu = (JMenu) jpm.getInvoker();
		        sDepartment=menuItem.getText();
		        sYear=menu.getText();
		        Student std=new Student();
				changepanel(std);
				std.stdDataPerYear(sYear,sDepartment);
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		JMenu mnImportData = new JMenu("Import Data");
		mnImportData.setFont(new Font("Times New Roman", Font.BOLD, 19));
		menuBar.add(mnImportData);
		
		JMenuItem mntmStudentData = new JMenuItem("Student Data");
		mnImportData.add(mntmStudentData);
		mntmStudentData.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	FileChooser fileChooser=new FileChooser();
		    	String path=fileChooser.getPath();
                
		    	if(path.equals("Not Valid")){
		    		JOptionPane.showMessageDialog(null, "File is not supported", "Warning",
		    		        JOptionPane.WARNING_MESSAGE);
		    	}
		    	else 
		    	{
		    		JOptionPane.showMessageDialog(null, 
		    				"All data is imported");
		    		StudentData studentData=new StudentData();
		    		try {
						studentData.enter_records(path);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    		

	    }
	});
		
		JMenuItem mntmPatData = new JMenuItem("PAT Data");
		mnImportData.add(mntmPatData);
		mntmPatData.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	FileChooser fileChooser=new FileChooser();
		    	String path=fileChooser.getPath();
                
		    	if(path.equals("Not Valid")){
		    		JOptionPane.showMessageDialog(null, "File is not supported", "Warning",
		    		        JOptionPane.WARNING_MESSAGE);
		    	}
		    	else 
		    	{
		    		JOptionPane.showMessageDialog(null, 
		    				"All data is imported");
		    		PatData patData=new PatData();
		    		try {
						patData.enter_records(path);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    		

	    }
	});
		
		JMenu mnCreatePdf = new JMenu("Create PDF");
		mnCreatePdf.setFont(new Font("Times New Roman", Font.BOLD, 19));
		menuBar.add(mnCreatePdf);
		
		JMenu mnNotification = new JMenu("Notification");
		mnNotification.setFont(new Font("Times New Roman", Font.BOLD, 19));
		menuBar.add(mnNotification);
		
		menuBar.add(Box.createHorizontalGlue());
		JMenu mnLogOut = new JMenu("LogOut");
		mnLogOut.setBackground(Color.BLACK);
		mnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 19));
		menuBar.add(mnLogOut);
		mnLogOut.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Main2 logIn=new Main2();
				
				logIn.setBounds(getBounds());
				removeAll();
				add(logIn);

				revalidate();
				repaint();
				

			}
		});
		
		JMenuItem mntmPatList = new JMenuItem("PAT List");
		mnCreatePdf.add(mntmPatList);
		mntmPatList.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GetData data=new GetData();
				CreatePDF pdf=new CreatePDF ();
				pdf.createPDF(data.getData("PAT_data", "select * from pats_information;"),"PAT.pdf");
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JMenu mnStudentList = new JMenu("Student List");
		mnCreatePdf.add(mnStudentList);
		
		JMenuItem mntmBatch = new JMenuItem("Batch 2017");
		mnStudentList.add(mntmBatch);
		mntmBatch.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GetData data=new GetData();
				CreatePDF pdf=new CreatePDF ();
				pdf.createPDF(data.getData("Student_data", "select * from student_information where year=4;"),"Year_4.pdf");
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JMenuItem mntmBatch_1 = new JMenuItem("Batch 2018");
		mnStudentList.add(mntmBatch_1);
		mntmBatch_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GetData data=new GetData();
				CreatePDF pdf=new CreatePDF ();
				pdf.createPDF(data.getData("Student_data", "select * from student_information where year=3;"),"Year_3.pdf");
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JMenuItem mntmBatch_2 = new JMenuItem("Batch 2019");
		mnStudentList.add(mntmBatch_2);
		mntmBatch_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GetData data=new GetData();
				CreatePDF pdf=new CreatePDF ();
				pdf.createPDF(data.getData("Student_data", "select * from student_information where year=2;"),"Year_2.pdf");
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JMenuItem mntmAllStudent = new JMenuItem("All Student");
		mnStudentList.add(mntmAllStudent);
		mntmAllStudent.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GetData data=new GetData();
				CreatePDF pdf=new CreatePDF ();
				pdf.createPDF(data.getData("Student_data", "select * from student_information ;"),"All_Student.pdf");
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		JMenu mnAllocatedStudentOf = new JMenu("Allocated Student of");
		mnCreatePdf.add(mnAllocatedStudentOf);
		
		JMenu mnComputerScience = new JMenu("Computer Science");
		mnAllocatedStudentOf.add(mnComputerScience);
		
		JMenuItem mntmDrmalikJahanKhan = new JMenuItem("DR.Malik Jahan Khan");
		mnComputerScience.add(mntmDrmalikJahanKhan);
		mntmDrmalikJahanKhan.addActionListener(this);
		
		JMenuItem mntmDrNomanJaved = new JMenuItem("Dr. Noman Javed");
		mnComputerScience.add(mntmDrNomanJaved);
		mnComputerScience.addActionListener(this);
		
		JMenuItem mntmDrMuhammadAdil = new JMenuItem("Dr. Muhammad Adil Raja");
		mnComputerScience.add(mntmDrMuhammadAdil);
		mntmDrMuhammadAdil.addActionListener(this);
		
		JMenuItem mntmDrjunaidAktar = new JMenuItem("Dr.Junaid Aktar");
		mnComputerScience.add(mntmDrjunaidAktar);
		mntmDrjunaidAktar.addActionListener(this);
		
		JMenuItem mntmDrAdnanIqbal = new JMenuItem("Dr. Adnan Iqbal");
		mnComputerScience.add(mntmDrAdnanIqbal);
		mntmDrAdnanIqbal.addActionListener(this);
		
		JMenuItem mntmMuhammadSarmadAli = new JMenuItem("Muhammad Sarmad Ali");
		mnComputerScience.add(mntmMuhammadSarmadAli);
		mntmMuhammadSarmadAli.addActionListener(this);
		
		JMenuItem mntmAmbreenHanif = new JMenuItem("Ambreen Hanif");
		mnComputerScience.add(mntmAmbreenHanif);
		mntmAmbreenHanif.addActionListener(this);
		
		JMenuItem mntmMuhammadSherazAnjam = new JMenuItem("Muhammad Sheraz Anjam");
		mnComputerScience.add(mntmMuhammadSherazAnjam);
		mntmMuhammadSherazAnjam.addActionListener(this);
		
		JMenuItem mntmDrSyedAsad = new JMenuItem("Dr. Syed Asad Alam");
		mnComputerScience.add(mntmDrSyedAsad);
		mntmDrSyedAsad.addActionListener(this);
		
		JMenu mnEe = new JMenu("EE");
		mnAllocatedStudentOf.add(mnEe);		
		JMenuItem mntmNewMenuItem = new JMenuItem("Dr.Muhammad Naeem Ayyaz");
		mnEe.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(this);
		
		JMenuItem mntmDr = new JMenuItem("Dr.Amir Khurrum Rashid");
		mnEe.add(mntmDr);
		mntmDr.addActionListener(this);
		
		JMenuItem mntmDrMuhammadSaqib = new JMenuItem("Dr. Muhammad Saqib Ilyas");
		mnEe.add(mntmDrMuhammadSaqib);
		mntmDrMuhammadSaqib.addActionListener(this);
		
		JMenuItem mntmDrIsrarAli = new JMenuItem("Dr. Israr Ali Khan");
		mnEe.add(mntmDrIsrarAli);
		mntmDrIsrarAli.addActionListener(this);
		
		JMenuItem mntmDrJalaluddinQureshi = new JMenuItem("Dr. Jalaluddin Qureshi");
		mnEe.add(mntmDrJalaluddinQureshi);
		mntmDrJalaluddinQureshi.addActionListener(this);
		
		JMenuItem mntmDrAishaMahmood = new JMenuItem("Dr. Aisha Mahmood");
		mnEe.add(mntmDrAishaMahmood);
		mntmDrAishaMahmood.addActionListener(this);
		
		JMenuItem mntmMuhammadHanif = new JMenuItem("Muhammad Hanif");
		mnEe.add(mntmMuhammadHanif);
		mntmMuhammadHanif.addActionListener(this);
		
		JMenuItem mntmMuhammadFayyazKashif = new JMenuItem("Muhammad Fayyaz Kashif");
		mnEe.add(mntmMuhammadFayyazKashif);
		mntmMuhammadFayyazKashif.addActionListener(this);
		
		JMenuItem mntmIramAziz = new JMenuItem("Iram Aziz");
		mnEe.add(mntmIramAziz);
		mntmIramAziz.addActionListener(this);
		
		JMenuItem mntmFaiqaAli = new JMenuItem("Faiqa Ali");
		mnEe.add(mntmFaiqaAli);
		mntmFaiqaAli.addActionListener(this);
		
		JMenuItem mntmAbberahAhmad = new JMenuItem("Abbirah Ahmed");
		mnEe.add(mntmAbberahAhmad);
		mntmAbberahAhmad.addActionListener(this);
		
		JMenu mnEnglish = new JMenu("English");
		mnAllocatedStudentOf.add(mnEnglish);
		
		
		JMenuItem mntmZameerNawaz = new JMenuItem("Muhammad Zameer Nawaz");
		mnEnglish.add(mntmZameerNawaz);
		mntmZameerNawaz.addActionListener(this);
		
		JMenuItem mntmIrfanNadeem = new JMenuItem("Muhammad Irfan Nadeem");
		mnEnglish.add(mntmIrfanNadeem);
		mntmIrfanNadeem.addActionListener(this);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 60, 750, 381);
		add(panel_2);
		currentSubPanel=panel_2;
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAT List");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 7, 150, 25);
		panel_2.add(lblNewLabel);
        
		Object colm[]={"Name","Department"};
//		Object row[][]={{"Adil Raja","CS"},{"Sarmad Ali","CS"}};
		
		dtm = new DefaultTableModel(Pat_Table_data,colm);		
		
		panel = new JPanel();
		panel.setBounds(0, 36, 266, 330);
		panel_2.add(panel);
		panel.setLayout(null);
		
		tableOfTeacher = new JTable(Pat_Table_data,colm);
		tableOfTeacher.setFont(new Font("Tahoma", Font.PLAIN, 11));
		currentTable=tableOfTeacher;
		scrollPaneTeacher = new JScrollPane(tableOfTeacher);
		currentSrollPane=scrollPaneTeacher;
		scrollPaneTeacher.setBounds(0, 0, 266, 330);
		panel.add(scrollPaneTeacher);
		tableOfTeacher.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
               
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
//				if(sort.isSelected()==true){
//					GetData data=new GetData();
//					PAT_Data=data.getData("PAT_data", "select * from pats_information order by name;");
//					Pat_Table_data=new String[PAT_Data.size()-1][2];
//					
//					for(int i=1;i<PAT_Data.size();i++){
//						for(int j=0;j<PAT_Data.get(i).size();j++){
//						
//							if(j==1){
//							Pat_Table_data[i-1][j-1]=PAT_Data.get(i).get(j);
//							}
//							else if(j==6){
//								Pat_Table_data[i-1][j-5]=PAT_Data.get(i).get(j);
//								
//							}
//							
//							
//						}
//					}
//					updateTable();
//				}
				cbTEnableEditing.setEnabled(true);
				btnAllocatedStudent.setEnabled(true);
				
				info_detail(tableOfTeacher.getValueAt(tableOfTeacher.getSelectedRow(), 0).toString());
			
				// TODO Auto-generated method stub
				
			}
			
		});
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(276, 36, 448, 330);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lTName = new JLabel("Name");
		lTName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lTName.setBounds(138, 24, 57, 21);
		panel_1.add(lTName);
		
		JLabel lTDepartment = new JLabel("Department");
		lTDepartment.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lTDepartment.setBounds(138, 61, 110, 21);
		panel_1.add(lTDepartment);
		
		tTEmail = new JTextField();
		tTEmail.setEditable(false);
		tTEmail.setBounds(259, 101, 179, 29);
		panel_1.add(tTEmail);
		tTEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 11, 118, 114);
		panel_1.add(btnNewButton);
		
		tTPersonalContact = new JTextField();
		tTPersonalContact.setEditable(false);
		tTPersonalContact.setBounds(259, 143, 179, 29);
		panel_1.add(tTPersonalContact);
		tTPersonalContact.setColumns(10);
		
		JLabel lTEmail = new JLabel("Email");
		lTEmail.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lTEmail.setBounds(138, 101, 77, 21);
		panel_1.add(lTEmail);
		
		JLabel lTContact = new JLabel("Contact #");
		lTContact.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lTContact.setBounds(138, 144, 104, 21);
		panel_1.add(lTContact);
		
		JLabel lLoaded = new JLabel("Allocated Load");
		lLoaded.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lLoaded.setBounds(138, 214, 127, 21);
		panel_1.add(lLoaded);
		
		tTName = new JTextField();
		tTName.setEditable(false);
		tTName.setBounds(259, 22, 179, 29);
		panel_1.add(tTName);
		tTName.setColumns(10);
		
		btnAllocatedStudent = new JButton("Allocated Students");
		btnAllocatedStudent.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAllocatedStudent.setBounds(152, 294, 153, 29);
		panel_1.add(btnAllocatedStudent);
		btnAllocatedStudent.setEnabled(false);
		btnAllocatedStudent.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Student p2=new Student();
				p2.setBounds(currentSubPanel.getBounds());				
				remove(currentSubPanel);
				p2.setPatInfo(selectedPatID,selectedPatName);				
				currentSubPanel=p2;
				add(p2);
				revalidate();
				repaint();


				// TODO Auto-generated method stub

			}

		});
		
		cbTEnableEditing = new JCheckBox("Enable Editing");
		cbTEnableEditing.setEnabled(false);
		cbTEnableEditing.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbTEnableEditing.setBounds(10, 294, 136, 29);
		panel_1.add(cbTEnableEditing);
		
		cbTEnableEditing.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                	tTPersonalContact.setEditable(true);
                	save.setEnabled(true);
                	beforeEditContact=tTPersonalContact.getText();
         
                }
                else if(e.getStateChange() == ItemEvent.DESELECTED){
                	tTPersonalContact.setEditable(false);
         
                }

                validate();
                repaint();
            }
        });
		
		tTAllocationLoad = new JTextField();
		tTAllocationLoad.setEditable(false);
		tTAllocationLoad.setBounds(259, 215, 179, 29);
		panel_1.add(tTAllocationLoad);
		tTAllocationLoad.setColumns(10);
		
		tTDepartment = new JTextField();
		tTDepartment.setToolTipText("");
		tTDepartment.setEditable(false);
		tTDepartment.setBounds(258, 62, 180, 29);
		panel_1.add(tTDepartment);
		tTDepartment.setColumns(10);
		
		JLabel lOfficeNo = new JLabel("Office #");
		lOfficeNo.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lOfficeNo.setBounds(138, 180, 91, 21);
		panel_1.add(lOfficeNo);
		
		tTOfficeNo = new JTextField();
		tTOfficeNo.setEditable(false);
		tTOfficeNo.setBounds(259, 179, 179, 29);
		panel_1.add(tTOfficeNo);
		tTOfficeNo.setColumns(10);
		
		save = new JButton("Save");
		save.setEnabled(false);
		save.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		save.setBounds(309, 294, 89, 28);
		panel_1.add(save);
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				afterEditContact=tTPersonalContact.getText();
				if(afterEditContact.equals(beforeEditContact)==false){
				   GetData data=new GetData();
				   data.setUpdate( "update pats_information set personal_contact=\""
				   +afterEditContact+"\" where Email_address=\""+tTEmail.getText()+"\";");
				   
				}
				// TODO Auto-generated method stub
				
			}
			
		});
		
		sort = new JCheckBox("Sort");
		sort.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sort.setBounds(187, 7, 97, 23);
		panel_2.add(sort);
		sort.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
            	GetData data=new GetData();
				PAT_Data=data.getData("PAT_data", "select * from pats_information order by name;");
				Pat_Table_data=new String[PAT_Data.size()-1][2];
				
				for(int i=1;i<PAT_Data.size();i++){
					for(int j=0;j<PAT_Data.get(i).size();j++){
					
						if(j==1){
						Pat_Table_data[i-1][j-1]=PAT_Data.get(i).get(j);
						}
						else if(j==6){
							Pat_Table_data[i-1][j-5]=PAT_Data.get(i).get(j);
							
						}
						
						
					}
				}
				updateTable();

                validate();
                repaint();
            }
        });
		
		
	}
	public void info_detail(String Name){
		for(int row=0;row<PAT_Data.size();row++){
			for(int colm=0;colm<PAT_Data.get(row).size();colm++){
				if(PAT_Data.get(row).get(colm).equals(Name)){
					   selectedPatID=PAT_Data.get(row).get(0);
					   selectedPatName=PAT_Data.get(row).get(colm);
						tTName.setText(PAT_Data.get(row).get(colm));
						colm++;
						tTEmail.setText(PAT_Data.get(row).get(colm));
						colm++;
						tTAllocationLoad.setText(PAT_Data.get(row).get(colm));
						colm++;
						tTOfficeNo.setText(PAT_Data.get(row).get(colm));
						colm++;
						tTPersonalContact.setText(PAT_Data.get(row).get(colm));
						colm++;
						tTDepartment.setText(PAT_Data.get(row).get(colm));
						beforeEditContact=tTPersonalContact.getText();
						break;
						
						
					
					
				}
				
			}
		}
	}
	public void changepanel(JPanel panelToReplace){
		
		panelToReplace.setBounds(currentSubPanel.getBounds());				
		remove(currentSubPanel);
		
		currentSubPanel=panelToReplace;
		add(panelToReplace);
		revalidate();
		repaint();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s=e.getSource().toString();		
		String PatName=s.substring(s.indexOf("text=")+5,s.length()-1);
		GetData data=new GetData();
		CreatePDF pdf=new CreatePDF ();
		pdf.createPDF(data.pat_ID(s.substring(s.length()-8,s.length()-3)),"Allocated_Student_"+PatName+".pdf");
		
		
		// TODO Auto-generated method stub
		
	}
	public void updateTable(){
		Object colm[]={"Name","Department"};
	       dtm = new DefaultTableModel(Pat_Table_data,colm);
		panel.remove(scrollPaneTeacher);
		tableOfTeacher = new JTable(Pat_Table_data,colm);
		tableOfTeacher.setBounds(currentTable.getBounds());
		
		JScrollPane scrollPaneTeacher = new JScrollPane(tableOfTeacher);
		scrollPaneTeacher.setBounds(0, 0, 266, 330);		
		panel.remove(currentSrollPane);
		panel.add(scrollPaneTeacher);
		panel.revalidate();
		panel.repaint();
		currentTable=tableOfTeacher;
		
		
	}
}
