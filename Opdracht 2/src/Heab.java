
/**
 * @author Daan Roeterink
 * @author Heab is a heap with buffer class.
 */
public class Heab {

	private Heap hp;
	private int[] deadspace;
	private int currentPosition = 0, heapSize = 0, maxHeapSize = 3;
	private int[] N = { 15, 12, 36, 9, 2, 13, 99, 10, 5, 37, 92, 3, 63, 11, 4,
			50, 48, 49,87,86,85,84,83,85,85,85,100 };

	public Heab(int size) {
		hp = new Heap(N);
		deadspace = new int[size];
	}

	public void readInt() {
		//setNewElement(N[currentPosition]);
		heapSize++;
	}

	public void writeToFile() {

	}

	public void closeFile() {

	}

//	public void setNewElement(int element) {
//		boolean done = false;
//		while (!done) {
//			if (hp.getData() > element) {
//				if (hp.isSmaller(element)) {
//
//					if (hp.getLeft() == null) {
//						hp.setLeft(new HeapElement(element));
//						done = true;
//					} else if (hp.getRight() == null) {
//						hp.setRight(new HeapElement(element));
//						done = true;
//					} else if (!hp.getLeft().hasEmptySpot()
//							&& hp.getRight().hasEmptySpot()) {
//						hp = hp.getRight();
//					} else {
//						hp = hp.getLeft();
//					}
//				} else {
//					if (hp.getRight() == null) {
//						int temp = hp.getLeft().getData();
//						hp.getLeft().setData(element);
//						hp = hp.getLeft();
//						element = temp;
//					} else {
//						int temp = hp.getRight().getData();
//						hp.getRight().setData(element);
//						hp = hp.getRight();
//						element = temp;
//					}
//				}
//			} else {
//				int temp = hp.getData();
//				hp.setData(element);
//				element = temp;
//			}
//		}
//
//	}

}
