package nl.saxion.tomendaan;

/**
 * @author Daan
 * 
 */
public class TomEnDaanHeapDeadSpace {

	public static final int mSize = 8;
	private int heapSize, deadspaceSize;
	private int[] memory = new int[mSize];
	private int[] randomNumbers;
	private Application app;
	private int runs = 1;
	private int lastPOP;

	public TomEnDaanHeapDeadSpace(int[] randomNumbers, Application app) {
		this.app = app;
		this.randomNumbers = randomNumbers;
		heapSize = mSize;
		buildHeap();
		printArray();
		for(int i = 0; i < 100; i++) {
			push();
			//printArray();
		}
		app.closeFile();
	}

	public void buildHeap() {
		System.out.println("buildheap");
		for (int i = 0; i < heapSize; i++) {
			memory[i] = randomNumbers[i];
			percolateUp(i);
		}
	}

	public void percolateUp(int location) {
		// percolate up
		while (memory[location] > memory[(location - 1) / 2]) {
			int temp = memory[location];
			memory[location] = memory[(location - 1) / 2];
			memory[(location - 1) / 2] = temp;
			// ask parent to percolate up too
			location = (location - 1) / 2;
		}
	}

	public int popHeap() {
		int returnValue = memory[0];
		lastPOP = returnValue;
		
		return returnValue;
	}

	public void add() {
		int nextNumber = app.getNextNumber();
		if (nextNumber != -1) {
			if (nextNumber > lastPOP) {
				heapSize--;
				deadspaceSize++;
				if(heapSize > 0)
				{
					memory[0] = memory[heapSize];
					percolateDown();
				}
				memory[heapSize] = nextNumber;
				System.out.println("out deadspace: " + nextNumber);
			} else {
				memory[0] = nextNumber;
				System.out.println("out heap: " + nextNumber);
			}
		}
	}

	public void push() {
		int writeValue = popHeap();
		System.out.println("Write to run writevalue: " + writeValue);
		this.app.writeToFile(writeValue);
		//buildHeap();
		//System.out.println("Heapsize :" + heapSize);
		//System.out.println("deadSpaceSize: " + deadspaceSize);
		if (heapSize == 0) {
			heapSize = mSize;
			deadspaceSize = 0;
			buildHeap();
			runs++;
			this.app.newRun();
			System.out.println("runs: " + runs);
		}
		add();
		percolateDown();
	}

	public void percolateDown() {
		int position = 0;
		boolean hasLeftChild = (position * 2) + 1 < mSize;
		boolean hasRightChild = (position * 2) + 2 < mSize;

		while (hasLeftChild || hasRightChild) {
			if (hasLeftChild && hasRightChild) {
				if (memory[(position * 2) + 1] < memory[position * 2 + 2]) {
					// right
					if (memory[position] < memory[(position * 2) + 2]) {
						int temp = memory[position];
						memory[position] = memory[(position * 2) + 2];
						memory[(position * 2) + 2] = temp;
					}
					position = (position * 2) + 2;
				} else {
					// left
					if (memory[position] < memory[(position * 2) + 1]) {
						int temp = memory[position];
						memory[position] = memory[(position * 2) + 1];
						memory[(position * 2) + 1] = temp;
					}
					position = (position * 2) + 1;
				}
			} else {
				// left
				if (memory[position] < memory[(position * 2) + 1]) {
					int temp = memory[position];
					memory[position] = memory[(position * 2) + 1];
					memory[(position * 2) + 1] = temp;
				}
				position = (position * 2) + 1;
			}
			hasLeftChild = (position * 2) + 1 < mSize;
			hasRightChild = (position * 2) + 2 < mSize;
		}
	}

	public void printArray() {
		for (int i = 0; i < memory.length; i++) {
			System.out.print(memory[i] + "|");
		}
		System.out.print("\r\n");
	}
}