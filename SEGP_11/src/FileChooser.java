

import javax.swing.JFileChooser;

public class FileChooser {
	public String isFileSelected(){
		JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Student Data file");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//          System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
//          System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
//          System.out.println(chooser.getSelectedFile().length());
//          System.out.println();
          String s=chooser.getSelectedFile().toString().substring(chooser.getSelectedFile().toString().length()-4);
          if(s.equals(".csv")){
        	  return chooser.getSelectedFile().toString();
        	  
          }
//          else 
//        	  System.out.println("Not valid Extension");
//        } else {
//        	return "NotValid"; 
//        }
        }
        return"Not Valid";
        

		
	}

}
