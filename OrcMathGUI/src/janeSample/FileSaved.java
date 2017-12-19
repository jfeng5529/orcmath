package janeSample;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileSaved {

	private static ArrayList<food> foodList;
	private static String[] items;
	
	public FileSaved() {
		
	}


	public static void main(String[] args) {
		FileSaved maker = new FileSaved();
		Scanner in = new Scanner(System.in);
		System.out.println("type something");
		String s = in.nextLine();
		testSaveContent("text.txt", s);
		System.out.println("saved successfully!");
		
	}
	private static void testSaveContent(String fileName, String s) {

		try{    

			FileWriter fw=new FileWriter(fileName);    

			fw.write(s);    

			fw.close();    

			System.out.println("Success! File \""+fileName+"\" saved!");

		}catch(IOException e){

			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}



	}
	}