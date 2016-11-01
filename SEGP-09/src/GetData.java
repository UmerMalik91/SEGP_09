import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetData {
	private String connectionURL = "JDBC:mysql://localhost/mydatabase"; 
	private Connection conn=null;
	private Statement st=null;
	private ResultSet rs=null;
	ArrayList<ArrayList<String>> userData=new ArrayList<ArrayList<String>>();
	public GetData(){
		try {
			conn=DriverManager.getConnection(connectionURL, "root", "");
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public ArrayList<ArrayList<String>> getData(String dataType,String userQuery ){
		int count=0;
			try{
				conn=DriverManager.getConnection(connectionURL, "root", "");
				st = conn.createStatement();
			userData.add(new ArrayList<String>());
			if(dataType.equals("Student_data")){
			rs=st.executeQuery("show columns from student_information");
			while(rs.next()){

				userData.get(count).add(rs.getString(1));
				
			}
			}
			else if(dataType.equals("PAT_data")){
				rs=st.executeQuery("show columns from pats_information");
				while(rs.next()){

					userData.get(count).add(rs.getString(1));
					
				}
				}
			count++;
			rs=st.executeQuery(userQuery);
			while(rs.next()){
				
				userData.add(new ArrayList<String>());
				for(int i=1;i<=userData.get(0).size();i++){
			      userData.get(count).add(rs.getString(i));
				}
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return userData;
	}
	public void setUpdate(String query){
		try {
			conn=DriverManager.getConnection(connectionURL, "root", "");
			st = conn.createStatement();
			st.executeUpdate(query);
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<ArrayList<String>> pat_ID(String PatName){
		String s=null;
		try {
			conn=DriverManager.getConnection(connectionURL, "root", "");
			st = conn.createStatement();
			rs=st.executeQuery("select id from pats_information where name Like '%"+PatName+"%';");
			
			while(rs.next()){
				s=rs.getString(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return genratePatQuery(s);
		
		
	}
	public boolean isUser(String Email,String password){
		try {
			String email;
			String Password;
			conn=DriverManager.getConnection(connectionURL, "root", "");
			st = conn.createStatement();
			rs=st.executeQuery("select * from patuser");
			
			while(rs.next()){
				email=rs.getString(1);
				Password=rs.getString(2);
				if(email.equals(Email)&& Password.equals(password) ){
					return true;
				}
				
			}
			return false;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public ArrayList<ArrayList<String>> genratePatQuery(String patID){
		return getData("Student_data","Select * from student_information where pat_id ="+patID+";");
		
	}
	
	

}
