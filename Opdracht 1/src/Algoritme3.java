import java.util.Random;


/**
 * @author Daan Roeterink
 *
 */
public class Algoritme3 extends Algoritme{

	/**
	 * @param n
	 * 		de meegegeven n word als grootte gebruik van de te genereren array
	 */
	public Algoritme3(int n)
	{
		startTimer();
		Random random = new Random();
		int array[] = new int[n];
		
		for(int i = 0; i < n; i++ )
		{
			array[i] = i;
		}
		for(int j = 0; j < n; j++ )
		{
			int randomPosition = random.nextInt(n);
			int current = array[j];
			array[j] = array[randomPosition];
			array[randomPosition] = current;
		}
		stopAndPrintTimer();
	}
}
