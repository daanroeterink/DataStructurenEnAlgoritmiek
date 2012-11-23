import java.util.Random;


/**
 * @author Tom Kostense, Daan Roeterink
 *
 */
public class Algoritme1 extends Algoritme{
	

	/**
	 * @param n
	 * 		de meegegeven n word als grootte gebruik van de te genereren array
	 */
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
