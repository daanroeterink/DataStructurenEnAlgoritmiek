public class Heap {

	private HeapElement root;

	public Heap(int[] numbers) {
		fillHeap(numbers);
	}

	public void fillHeap(int[] numbers) {
		for (int c = 0; c < numbers.length; c++) {
			if (root == null) {
				root = new HeapElement(numbers[c],null);
			} else {
				root.addElement(numbers[c]);
			}
		}
		//System.out.println(root.getData());
		//System.out.println(root.printToConsole());
		BTreePrinter.printNode(root);
	}
}
