import java.util.Random;


public class Algoritme1 extends Algoritme{
	

	public Algoritme1(int n) 
	{
		startTimer();
		Random random = new Random();
		int array[] = new int[n];
		
		for(int i = 0; i < n; i++ )
		{
			int randomInt = random.nextInt(n);
			for(int j = 0; j < (n-1); j++ )
			{
				if(randomInt == array[j])
				{
					randomInt = random.nextInt(n);
					//-1 omdat j automatisch opgehoogd word en hij dus bij 1 begint in plaast van bij 0.
					j = -1;
				}
			}
			array[i] = randomInt;
		}
		stopAndPrintTimer();
	}
}
