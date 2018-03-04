package fileReader;

import java.io.BufferedReader;
import java.io.File;

import javax.swing.JFileChooser;

public class InitialFileReader {
	InitialFileReader fr = null;
	BufferedReader br = null;
	JFileChooser fc = new JFileChooser();

	public File SelectFolder() {
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		fc.setDialogTitle("please select a folder");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setAcceptAllFileFilterUsed(false);
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fc.getCurrentDirectory();
		}
		return null;
	}

	public File SelectFile() {
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile();
		}
		return null;
	}
	
	public void ReadDirectory() {
		File dir = SelectFolder();
		File[] directoryListing = dir.listFiles();
		if(directoryListing != null) {
			for(File child: directoryListing) {
				System.out.println(child.getAbsolutePath());
			}
		}
	}
}
