
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;

public class StudentData {
	private String connectionURL = "JDBC:mysql://localhost/mydatabase"; 
	private Connection conn=null;
	private Statement st=null;
	public StudentData(){
		try {
			conn=DriverManager.getConnection(connectionURL, "root", "");
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void enter_records(String filePath) throws FileNotFoundException{
		try {
			st.executeUpdate("truncate student_information");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
			Scanner input=new Scanner(new File(filePath));
			while(input.hasNextLine()){
				String[] tokens=input.nextLine().trim().split(",");
				String [] year=tokens[3].trim().split("-");
				try {
					st.executeUpdate("INSERT INTO student_information VALUES('"+tokens[0]+"','"+tokens[1]+
							"','"+tokens[2]+"','"+Integer.parseInt(year[1])+"','"+tokens[4]+"','"+tokens[5]+"','"+tokens[6]+"');");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}
