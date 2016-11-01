import java.util.ArrayList;

public class TableData {
	Object[][] Pat_Table_data;
	public Object[][] getPATData(ArrayList<ArrayList<String>> PAT_Data,String attribute1,String attribute2 ){
		Pat_Table_data=new String[PAT_Data.size()][PAT_Data.get(1).size()];
		int attribute1_colm = 0;
		int attribute2_colm=0;
		for(int i=0;i<PAT_Data.size();i++){
			for(int j=0;j<PAT_Data.get(i).size();j++){
				if(i==0){
			   if(attribute1.equals(PAT_Data.get(i).get(j))){
				   attribute1_colm=j;
			   }
			   if(attribute2.equals(PAT_Data.get(i).get(j))){
				   attribute2_colm=j;
			   }
			}
				if(j==attribute1_colm){
				Pat_Table_data[i][0]=PAT_Data.get(i).get(j);
				}
				else if(j==attribute1_colm){
					Pat_Table_data[i][1]=PAT_Data.get(i).get(j);
					
				}
				
				
			}
		}
		return Pat_Table_data;
		
	}

}
