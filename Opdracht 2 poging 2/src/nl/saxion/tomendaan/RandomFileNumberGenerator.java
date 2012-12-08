package nl.saxion.tomendaan;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomFileNumberGenerator
{

	public static final int RANDOMNUMBERDISTANCE = 10000;

	public RandomFileNumberGenerator()
	{
		int[] randomArray = generateRandomNumbers(RANDOMNUMBERDISTANCE);
		try
		{
			FileWriter writer = new FileWriter(Application.FILENAME);
			for (int i = 0; i < randomArray.length; i++)
			{
				writer.write(randomArray[i] + " ");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Algorith 3 of Exercise uno
	 * 
	 * @param n
	 *            ammount of numbers to generate
	 */
	public int[] generateRandomNumbers(int n)
	{
		Random random = new Random();
		int[] array = new int[n];

		for (int i = 0; i < n; i++)
		{
			array[i] = i;
		}
		for (int j = 0; j < n; j++)
		{
			int randomPosition = random.nextInt(n);
			int current = array[j];
			array[j] = array[randomPosition];
			array[randomPosition] = current;
		}
		return array;
	}
}
