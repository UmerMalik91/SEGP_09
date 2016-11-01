import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PatData {
	private String connectionURL = "JDBC:mysql://localhost/mydatabase"; 
	private Connection conn=null;
	private Statement st=null;
	public PatData(){
		try {
			conn=DriverManager.getConnection(connectionURL, "root", "");
			st = conn.createStatement();
		} catch (SQLException e) {
	// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void enter_records(String path) throws FileNotFoundException{
		try {
			st.executeUpdate("truncate pats_information");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			Scanner input=new Scanner(new File(path));
			while(input.hasNextLine()){
				String[] tokens=input.nextLine().trim().split(",");
				String [] year=tokens[4].trim().split("-");
				try {
					st.executeUpdate("INSERT INTO pats_information VALUES('"+tokens[0]+"','"+tokens[1]+"','"+tokens[2]+"','"+tokens[3]+"','"+tokens[4]+"','"+tokens[5]+"','"+tokens[6]+"');");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

}
