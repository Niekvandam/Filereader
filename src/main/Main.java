package main;

import javax.swing.JFileChooser;

import fileReader.InitialFileReader;

public class Main {

	public static void main(String[] args) {

		InitialFileReader ifr = new InitialFileReader();

		ifr.createFrameWithTable();

	}
}