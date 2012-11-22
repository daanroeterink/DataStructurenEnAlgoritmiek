import java.text.DecimalFormat;


public class Algoritme {

	private long startTime;
	
	public void printResult(int array[])
	{
		//print results
		for(int in = 0; in < array.length; in++)
		{
			System.out.println(array[in]);
		}
	}
	
	public void startTimer()
	{
		startTime = System.nanoTime();
	}
	
	public void stopAndPrintTimer()
	{
		long stopTime = System.nanoTime();
		long difference = stopTime-startTime;
		double differenceSeconds = difference / 1000000000.0;
		System.out.println("----------------------------------");
		System.out.println("Starttime in ns:" + startTime);
		System.out.println("StopTime in ns:" + stopTime);
		System.out.println("Elapsed in ns:" + difference);
		System.out.println("Elapsed in s:" + differenceSeconds);
		System.out.println("----------------------------------");
	}
}
