import java.util.Random;


public class Algoritme2 extends Algoritme{

	public Algoritme2(int n)
	{
		startTimer();
		Random random = new Random();
		int array[] = new int[n];
		boolean used[] = new boolean[n];
		
		for(int i = 0; i < n; i++ )
		{
			int randomInt = random.nextInt(n);
			
			while(used[randomInt] == true)
			{
				randomInt = random.nextInt(n);
			}
			used[randomInt] = true;
			array[i] = randomInt;
		}
		stopAndPrintTimer();
	}
}
