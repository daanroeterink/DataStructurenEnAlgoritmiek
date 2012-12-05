public class HeapElement<T extends Integer> {
	private T data;
	private HeapElement<T> left;
	private HeapElement<T> right;
	private HeapElement<T> parent;

	public HeapElement(T data, HeapElement<T> parent) {
		this.data = data;
		this.parent = parent;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public HeapElement<T> getLeft() {
		return left;
	}

	public void setLeft(HeapElement<T> left) {
		this.left = left;
	}

	public HeapElement<T> getRight() {
		return right;
	}

	public void setRight(HeapElement<T> right) {
		this.right = right;
	}

	public void addElement(T newElement) {
		if (left == null) {
			left = new HeapElement<T>(newElement, this);
			left.percolateUp();
		} else if (right == null) {
			right = new HeapElement<T>(newElement, this);
			right.percolateUp();
		} else {
			if (left.size() <= right.size()) {
				left.addElement(newElement);
			} else {
				right.addElement(newElement);
			}
		}
	}

	public void percolateUp() {
		if (this.parent != null) {
			if (this.data > parent.getData()) {
				T temp = this.data;
				this.data = parent.getData();
				parent.setData(temp);
				parent.percolateUp();
			}
		}
	}

	// public void PercolateDown() {
	// if (hasLandR()) {
	// while (this.data < left.getData()) {
	// swapWithLeft();
	// left.PercolateDown();
	// right.PercolateDown();
	// }
	// } else if (left != null) {
	// if (this.data < left.getData()) {
	// swapWithLeft();
	// }
	// left.PercolateDown();
	// } else if (right != null) {
	// if (this.data < right.getData()) {
	// swapWithRight();
	// }
	// right.PercolateDown();
	// }
	// }
	//
	// public void swapWithLeft() {
	// T temp = this.data;
	// this.data = left.getData();
	// left.setData(temp);
	// }
	//
	// public void swapWithRight() {
	// T temp = this.data;
	// this.data = right.getData();
	// right.setData(temp);
	// }

	/**
	 * Check if left and right are filled
	 * 
	 * @return
	 */
	private boolean hasLandR() {
		boolean ret = false;
		if (left != null && right != null) {
			ret = true;
		}
		return ret;
	}

	public int size() {
		if (left != null && right != null) {
			return left.size() + right.size() + 1;
		} else if (left != null) {
			return left.size() + 1;
		} else if (right != null) {
			return right.size() + 1;
		} else {
			return 1;
		}
	}

	public boolean hasEmptySpot() {
		if (left == null || right == null) {
			return true;
		}
		return false;
	}

	public void println() {
		System.out.println(" | " + data + " | ");
	}

	public String print() {
		return " | " + data + " | ";
	}

	public String printToConsole() {
		String printString = "";

		// add left
		if (left != null) {
			printString += left.printToConsole();
		}

		// add self
		printString += this.print();

		// right
		if (right != null) {
			printString += right.printToConsole();
		}

		return printString;
	}

	public boolean isSmaller(int data) {
		boolean result = true;
		if (left != null) {
			if (left.getData() > data) {
				result = true;
			} else {
				return false;
			}
		}

		if (right != null) {
			if (right.getData() > data) {
				result = true;
			} else {
				return false;
			}
		}

		return result;
	}
}
