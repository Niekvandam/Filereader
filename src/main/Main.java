package main;

import java.io.File;

import testFileReader.FileReader;

public class Main {

	public static void main(String[] args) {
	
		FileReader t = new FileReader();
		
		
		File f = t.SelectFile();

		System.out.println(f.getAbsolutePath());
	}

}
