package main;

import java.io.File;

import fileReader.InitialFileReader;

public class Main {

	public static void main(String[] args) {
	
		InitialFileReader t = new InitialFileReader();
		
		
		File f = t.SelectFile();

		System.out.println(f.getAbsolutePath());
	}

}
