
/**
 * @author Tom Kostense, Daan Roeterink
 *
 */
public class Algoritme {

	/**
	 * De start tijd in nanosecondes.
	 */
	private long startTime;
	
	/**
	 * @param array
	 * 		Drukt de meegegeven array regel voor regel af in de console
	 */
	public void printResult(int array[])
	{
		for(int in = 0; in < array.length; in++)
		{
			System.out.println(array[in]);
		}
	}
	
	/**
	 * zet de huidige "nanoTime" als start tijd.
	 */
	public void startTimer()
	{
		startTime = System.nanoTime();
	}
	
	/**
	 * Zet de huidige "nanoTime" als stop tijd en bereken het verschil.
	 * 		De resultaten worden in de console afgedrukt
	 */
	public void stopAndPrintTimer()
	{
		long stopTime = System.nanoTime();
		long difference = stopTime-startTime;
		double differenceSeconds = difference / 1000000000.0;
		System.out.println("Elapsed in ns:" + difference);
		System.out.println("Elapsed in s:" + differenceSeconds);
		System.out.println(differenceSeconds);
		System.out.println("----------------------------------");
	}

	
	/**
	 * @param array
	 * 		controlleert of de gegeven array een geldige permutatie is
	 */
	public boolean checkValidPermutatie(int array[])
	{
		boolean sortedArray[] = new boolean[array.length];
		for(int i = 0; i < array.length; i++)
		{
			if(!sortedArray[array[i]])
			{
				sortedArray[array[i]] = true;
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}
}
