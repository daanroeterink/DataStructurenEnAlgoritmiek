
/**
 * @author Tom Kostense, Daan Roeterink
 *
 */
public class Applicatie {

	public static void main(String args[]) {
		int a1[] = new int[]{ 500, 1000, 2000, 5000, 10000, 75000 };
		int a2[] = new int[]{ 1000, 5000, 10000, 50000, 100000, 75000 };
		int a3[] = new int[]{ 5000, 10000, 20000, 40000, 80000, 75000 };

		for(int t = 0; t < 10; t++)
		{
			System.out.println("Starting Algoritme 1");
			System.out.println("----------------------------------");
			for(int i = 0; i < a1.length; i++)
			{
				System.out.println("Size of n: " + a1[i]);
				new Algoritme1(a1[i]);
			}
			
			System.out.println("Starting Algoritme 2");
			System.out.println("----------------------------------");
			for(int i = 0; i < a2.length; i++)
			{
				System.out.println("Size of n: " + a2[i]);
				new Algoritme1(a2[i]);
			}
			
			System.out.println("Starting Algoritme 3");
			System.out.println("----------------------------------");
			for(int i = 0; i < a3.length; i++)
			{
				System.out.println("Size of n: " + a3[i]);
				new Algoritme1(a3[i]);
			}
		}
	}
}
