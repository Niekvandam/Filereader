package main;

import java.io.File;

import testFileReader.TestFileReader;

public class Main {

	public static void main(String[] args) {
	
		TestFileReader t = new TestFileReader();
		
		
		File f = t.SelectFile();

		System.out.println(f.getAbsolutePath());
	}

}
