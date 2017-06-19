package me.example.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

	public static void main(String[] args) {
		FileUtil fileUtil = new FileUtil();
		fileUtil.writeTofile("333");
		int readInt = fileUtil.readFromFile();
		System.out.println(readInt);
	}

	public FileUtil() {
		this.writeTofile("0");
	}

	public void writeTofile(String value) {
		try {
			FileWriter fileWriter = new FileWriter(new File("dataFile.txt"));
			fileWriter.write(value);
			fileWriter.flush();
			fileWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int readFromFile() {
		int readInt = 0;
		try {
			FileReader fileReader = new FileReader(new File("dataFile.txt"));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			readInt = Integer.parseInt(bufferedReader.readLine());
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return readInt;
	}

}
