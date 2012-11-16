import java.util.Random;


public class Opdracht2 {

	int n = 10000000;
	Random random = new Random();
	int array[] = new int[n];
	boolean used[] = new boolean[n];

	public Opdracht2() {
		for (int i = 0; i < n; i++) {
			int randomNumber = random.nextInt(n);
			used[randomNumber]=true;
			while(used[randomNumber]==true) {
				randomNumber = random.nextInt(n);
			}
			array[i] = randomNumber;
		}
				
		for (int i : array) {
			System.out.print(i + "|");
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new Opdracht2();
	}
}
