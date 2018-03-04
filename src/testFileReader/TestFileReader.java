package testFileReader;

import java.io.File;

import javax.swing.JFileChooser;

public class TestFileReader {
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
}
