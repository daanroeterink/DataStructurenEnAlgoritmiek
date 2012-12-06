package nl.saxion.tomendaan;

/**
 * @author Daan
 * 
 */
public class TomEnDaanHeapDeadSpace {

	public static final int mSize = 6;
	private int heapSize, deadspaceSize;
	private int[] memory = new int[mSize];
	private int[] randomNumbers;
	private Application app;
	private int runs = 0;

	public TomEnDaanHeapDeadSpace(int[] randomNumbers, Application app) {
		this.app = app;
		this.randomNumbers = randomNumbers;
		heapSize = mSize;
		buildHeap();
	}

	public void buildHeap() {
		for (int i = 0; i < heapSize; i++) {
			memory[i] = randomNumbers[i];
			percolateUp(i);
		}
	}

	public void percolateUp(int location) {
		// percolate up
		while (memory[location] < memory[(location - 1) / 2]) {
			int temp = memory[location];
			memory[location] = memory[(location - 1) / 2];
			memory[(location - 1) / 2] = temp;
			// ask parent to percolate up too
			location = (location - 1) / 2;
		}
	}

	public int popHeap() {
		int returnValue = memory[0];
		int nextNumber = app.getNextNumber();
		if (nextNumber != -1) {
			memory[0] = nextNumber;
		}
		return returnValue;
	}

	public void push() {
		popHeap();
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
}
