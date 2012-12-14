package nl.saxion.tomendaan;

/**
 * @author Daan Roeterink
 * @author Tom Kostense
 */
public class TomEnDaanHeapDeadSpace
{
	/**
	 * Set to True when you want to use my optimization. This optimization will check by every push if the next integer
	 * can be placed in the output file.
	 */
	boolean optimisation = false;

	/**
	 * Maximum size of out memory (heap+deadspace)
	 */
	public static final int mSize = 10;

	private int heapSize, deadspaceSize;

	private int[] memory = new int[mSize];

	private Application app;

	/**
	 * Keeps track of the ammount of runs.
	 */
	private int runs = 1;

	/**
	 * LastPOP - the last integer that has been send to the output file
	 */
	private int lastPOP;

	/**
	 * @param randomNumbers
	 *            These randomnumbers will fill the memory initially
	 * @param app
	 *            This is nececary so that we can get the names for het input and output file.
	 */
	public TomEnDaanHeapDeadSpace(int[] randomNumbers, Application app)
	{
		this.app = app;
		heapSize = mSize;
		initFillMemory(randomNumbers);
		int next = app.getNextNumber();
		while (next != -1)
		{
			push(next);
			next = app.getNextNumber();
		}
		System.out.println("Heap with Deadspace - Daan Roeterink & Tom Kostense - EIN2a");
		System.out.println("Optimization is set to: " + optimisation);
		System.out.println("-----------------------------------------------------------");
		System.out.println("Amount of nececary runs: " + runs);
	}

	/**
	 * This function will fill the memory for the first time and then call buildheap
	 * 
	 * @param randomNumbers
	 *            randomnumbers to fill the memory
	 */
	public void initFillMemory(int[] randomNumbers)
	{
		for (int i = 0; i < heapSize; i++)
		{
			memory[i] = randomNumbers[i];
		}
		buildHeap();
	}

	public void buildHeap()
	{
		for (int i = 0; i < heapSize; i++)
		{
			percolateDown();
			// percolateUp(i);
		}
	}

	public void percolateUp(int location)
	{
		// percolate up
		while (memory[location] > memory[(location - 1) / 2])
		{
			int temp = memory[location];
			memory[location] = memory[(location - 1) / 2];
			memory[(location - 1) / 2] = temp;
			// ask parent to percolate up too
			location = (location - 1) / 2;
		}
	}

	/**
	 * @return Root of the current Heap
	 */
	public int popHeap()
	{
		int returnValue = memory[0];
		lastPOP = returnValue;
		return returnValue;
	}

	/**
	 * Whille add nextNumber to the memory (heap or deadspace)
	 * 
	 * @param nextNumber
	 *            The nextNumber to work with
	 */
	public void add(int nextNumber)
	{
		if (nextNumber != -1)
		{
			if (nextNumber > lastPOP)
			{
				heapSize--;
				deadspaceSize++;
				memory[0] = memory[heapSize];
				memory[heapSize] = nextNumber;
			}
			else
			{
				memory[0] = nextNumber;
				percolateDown();
			}
		}
	}

	/**
	 * @param nextNumber
	 */
	public void push(int nextNumber)
	{
		boolean inserted = false;
		if (heapSize > 0)
		{
			if (nextNumber < lastPOP && nextNumber > memory[0] && optimisation)
			{
				this.app.writeToFile(nextNumber);
				inserted = true;
			}
			int writeValue = popHeap();
			this.app.writeToFile(writeValue);
		}
		if (heapSize == 0)
		{
			heapSize = mSize;
			deadspaceSize = 0;
			buildHeap();
			runs++;
			this.app.newRun();
		}
		else if (!inserted)
		{
			add(nextNumber);
			percolateDown();
		}
	}

	public void percolateDown()
	{
		int position = 0;
		boolean hasLeftChild = (position * 2) + 1 < heapSize;
		boolean hasRightChild = (position * 2) + 2 < heapSize;

		while (hasLeftChild || hasRightChild)
		{
			if (hasLeftChild && hasRightChild)
			{
				if (memory[(position * 2) + 1] < memory[position * 2 + 2])
				{
					// right
					if (memory[position] < memory[(position * 2) + 2])
					{
						int temp = memory[position];
						memory[position] = memory[(position * 2) + 2];
						memory[(position * 2) + 2] = temp;
					}
					position = (position * 2) + 2;
				}
				else
				{
					// left
					if (memory[position] < memory[(position * 2) + 1])
					{
						int temp = memory[position];
						memory[position] = memory[(position * 2) + 1];
						memory[(position * 2) + 1] = temp;
					}
					position = (position * 2) + 1;
				}
			}
			else
			{
				// left
				if (memory[position] < memory[(position * 2) + 1])
				{
					int temp = memory[position];
					memory[position] = memory[(position * 2) + 1];
					memory[(position * 2) + 1] = temp;
				}
				position = (position * 2) + 1;
			}
			hasLeftChild = (position * 2) + 1 < heapSize;
			hasRightChild = (position * 2) + 2 < heapSize;
		}
	}

	public void printArray()
	{
		for (int i = 0; i < memory.length; i++)
		{
			System.out.print(memory[i] + "|");
		}
		System.out.print("\r\n");
	}
}
