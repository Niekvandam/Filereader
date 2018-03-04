package fileReader;

import java.io.BufferedReader;
import java.io.File;

import javax.swing.JFileChooser;

/**
 * 
 * @author Niek
 *
 */
public class InitialFileReader {

	InitialFileReader fr = null;
	BufferedReader br = null;
	JFileChooser fc = new JFileChooser();

	/**
	 * Calling this function will open up a JFilechooser in which only directories
	 * can be selected.
	 * 
	 * @return Selected directory
	 */
	public File SelectFolder() {
		/*
		 * running this function will set the current directory to the home of the user,
		 * will put a title above it and will set it to only read directories.
		 */
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		fc.setDialogTitle("please select a folder");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		/**
		 * Opens the JFileChooser windows in which a directory can be selected
		 */
		fc.setAcceptAllFileFilterUsed(false);
		/*
		 * checks if the ok button has been pressed
		 */
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fc.getCurrentDirectory();
		}
		return null;
	}

	/**
	 * This function mimics {@link #SelectFolder()} but this one returns a file
	 * 
	 * @return Selected file
	 */
	public File SelectFile() {
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile();
		}
		return null;
	}

	/**
	 * Calling this function will redirect to {@link #SelectFolder()} at first, and
	 * will then loop through the selected directory
	 */
	public void ReadDirectory() {
		/*
		 * calls selectfolder and loops through all the children folders of the one selected. 
		 */
		File dir = SelectFolder();
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				child.getAbsolutePath();
			}
		}
	}
}
