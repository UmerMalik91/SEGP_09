

import javax.swing.JFileChooser;

public class FileChooser {
	public String getPath(){
		JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Student Data file");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          String s=chooser.getSelectedFile().toString().substring(chooser.getSelectedFile().toString().length()-4);
          if(s.equals(".csv")){
        	  return chooser.getSelectedFile().toString();
        	  
          }
          
        } else {
        	return "NotValid"; 
        }
        
        return null;
        

		
	}

}
