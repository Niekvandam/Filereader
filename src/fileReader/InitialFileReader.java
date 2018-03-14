package fileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.TreeSet;

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
	public File SelectFileOrFolder() {
		/*
		 * running this function will set the current directory to the home of the user,
		 * will put a title above it and will set it to only read directories.
		 */
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		fc.setDialogTitle("please select a folder");
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		/**
		 * Opens the JFileChooser windows in which a directory can be selected
		 */
		fc.setAcceptAllFileFilterUsed(false);
		/*
		 * checks if the ok button has been pressed
		 */
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile();
		}
		return null;
	}

	/**
	 * Calling this function will redirect to {@link #SelectFolder()} at first, and
	 * will then loop through the selected directory
	 */
	public TreeSet<File> ReadDirectory() {
		/*
		 * calls {@link #SelectFolder()} and loops through all the children folders of
		 * the one selected.
		 */
		TreeSet<File> listedFiles = new TreeSet<File>();
		File dir = SelectFileOrFolder();
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				child.getAbsolutePath();
				listedFiles.add(child);
				return listedFiles;
			}
		}
		return null;
	}

	public void CreateTxtFile(String NameOfFile) {
		File f = SelectFileOrFolder();
		try (Writer writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(f + "\\" + NameOfFile + ".txt"), "utf-8"))) {
			writer.write("testtesteste");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void CopyFile() {
		InputStream _filesource = null;
		OutputStream _fileoutput = null;
		try {
			_filesource = new FileInputStream(SelectFileOrFolder());
			_fileoutput = new FileOutputStream(SelectFileOrFolder());
			byte[] buffer = new byte[1024];
			int length;
			while ((length = _filesource.read(buffer)) > 0) {
				_fileoutput.write(buffer, 0, length);
			}
			_filesource.close();
			_fileoutput.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
