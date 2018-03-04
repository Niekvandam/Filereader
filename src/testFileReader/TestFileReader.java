package testFileReader;

import javax.swing.JFileChooser;

public class TestFileReader {

	public String SelectFolder() {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("."));
		fc.setDialogTitle("please select a folder");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    fc.setAcceptAllFileFilterUsed(false);
		if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("Current Directory" + fc.getCurrentDirectory());
		}
	return "test";
	}
}
