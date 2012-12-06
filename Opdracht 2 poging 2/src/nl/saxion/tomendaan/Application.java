package nl.saxion.tomendaan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {

	public static final String FILENAME = "input.txt";
	private Scanner scanner ;
	private TomEnDaanHeapDeadSpace hpd;

	public Application() {
		try {
			scanner = new Scanner(new File(Application.FILENAME));
		} catch (FileNotFoundException e) {
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
			return Integer.parseInt(scanner.next());
		}
		return -1;
	}

	public static void main(String[] args) {
		new Application();
	}
}
