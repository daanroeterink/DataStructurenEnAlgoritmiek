package nl.saxion.tomendaan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application {

	public static final String FILENAME = "input.txt";
	public static final String OUTFILENAME = "output.txt";
	private Scanner scanner ;
	private TomEnDaanHeapDeadSpace hpd;
	BufferedWriter writer;

	public Application() {
		try {
			scanner = new Scanner(new File(Application.FILENAME));
			writer =  new BufferedWriter(new FileWriter(OUTFILENAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RandomFileNumberGenerator file = new RandomFileNumberGenerator();
		initialReadFile();
	}

	public void initialReadFile() {
		int counter = 0;
		int[] buffer = new int[TomEnDaanHeapDeadSpace.mSize];
		while (scanner.hasNext()) {
			buffer[counter] = Integer.parseInt(scanner.next());
			counter++;
			if (counter == buffer.length) {
				hpd = new TomEnDaanHeapDeadSpace(buffer, this);
				break;
			}
		}
	}

	public int getNextNumber() {
		if (scanner.hasNext()) {
			String t = scanner.next();
			System.out.println("in: " + t);
			return Integer.parseInt(t);
		}
		return -1;
	}
	
	public void writeToFile(int toWrite) {
		try {
			writer.write(toWrite + " ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void newRun() {
		try {
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeFile() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		new Application();
	}
}
