package fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.util.TreeSet;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

	public TreeSet<File> ReadDirectory() {
		TreeSet<File> initialFiles = new TreeSet<File>();
		File dir = SelectFolder();
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				initialFiles.add(child);
			}
		}
		return initialFiles;
	}

	public JTable CreateTableFromData() {
		 TreeSet<File> entriesfortable = ReadDirectory();

		    // It creates and displays the table
		    JTable table = new JTable(buildTableModel(entriesfortable));

		    // Closes the Connection

		    JOptionPane.showMessageDialog(null, new JScrollPane(table));
		return table;
	}
}
