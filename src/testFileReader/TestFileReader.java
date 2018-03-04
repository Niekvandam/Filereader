package testFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Using this class to throw test calls at, debugging and testing
 * 
 * @author Niek
 *
 */
public class TestFileReader {

	boolean fileMode = true;
	BufferedReader bufferedReader = null;
	FileReader fileReader = null;

	public File ChooseFile() {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt only", "txt");
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			return selectedFile;
		}
		return null;
	}

	/**
	 * Gets the contents of the file, at this point this is just the text in the
	 * file
	 * 
	 * @return Contents of File
	 */
	public String getFileContents() {
		/**
		 * Calls the method choosefile to open the filechooser and select a file on your
		 * pc, then it will read the file by initializing a filereader and print the
		 * text
		 */
		File fileChosen = ChooseFile();
		if (fileChosen != null) {
			/**
			 * Tries to read the file that was selected in {@link #ChooseFile()} if it
			 * succeeds it prints every line
			 */
			try {
				String CurrentLine;
				fileReader = new FileReader(fileChosen);
				bufferedReader = new BufferedReader(fileReader);
				while ((CurrentLine = bufferedReader.readLine()) != null) {
					System.out.println(CurrentLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				/**
				 * Tries to close the buffered and filereader
				 */
				try {
					if (bufferedReader != null)
						bufferedReader.close();

					if (fileReader != null)
						fileReader.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			return "No file was submitted, therefore nothing can be returned";
		}
		return null;
	}

	public void createNewFile() {

	}
}
