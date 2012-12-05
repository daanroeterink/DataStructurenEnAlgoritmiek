public class Opdracht2
{

	/**
	 * De grootte van de Heap (HeapSize)
	 */
	private int H = 3;

	/**
	 * (File) met N random getallen
	 */
	private int[] N = { 15, 12, 36, 9, 2, 13, 87, 10, 5, 37, 92, 3, 63, 11, 4, 50, 48, 49 };

	private HeapElement root;

	/**
	 * Constructor van Opdracht 2
	 */
//	public Opdracht2()
//	{
//		root = new HeapElement(N[0]);
//		for (int i = 1; i < N.length; i++)
//		{
//			setNewElement(N[i]);
//		}
//		printResult();
//	}

//	public void setNewElement(int element)
//	{
//		HeapElement heapElement = root;
//		boolean done = false;
//		while (!done)
//		{
//			if (heapElement.getData() > element)
//			{
//				if (heapElement.isSmaller(element))
//				{
//
//					if (heapElement.getLeft() == null)
//					{
//						heapElement.setLeft(new HeapElement(element));
//						done = true;
//					}
//					else if (heapElement.getRight() == null)
//					{
//						heapElement.setRight(new HeapElement(element));
//						done = true;
//					}
//					else if (!heapElement.getLeft().hasEmptySpot() && heapElement.getRight().hasEmptySpot())
//					{
//						heapElement = heapElement.getRight();
//					}
//					else
//					{
//						heapElement = heapElement.getLeft();
//					}
//				}
//				else
//				{
//					if (heapElement.getRight() == null)
//					{
//						int temp = heapElement.getLeft().getData();
//						heapElement.getLeft().setData(element);
//						heapElement = heapElement.getLeft();
//						element = temp;
//					}
//					else
//					{
//						int temp = heapElement.getRight().getData();
//						heapElement.getRight().setData(element);
//						heapElement = heapElement.getRight();
//						element = temp;
//					}
//				}
//			}
//			else
//			{
//				int temp = heapElement.getData();
//				heapElement.setData(element);
//				element = temp;
//			}
//		}
//
//	}

	public void printResult()
	{
		HeapElement element = root;
		element.println();
		element.getLeft().print();
		element.getRight().println();
		element.getLeft().getLeft().print();
		element.getLeft().getRight().println();

		element.getRight().getLeft().print();
		element.getRight().getRight().println();
		// while (element.getRight() != null || (element.getLeft() != null && element.getRight() != null))
		// {
		// element.getLeft().print();
		// element.getRight().print();
		// }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new Heab(6);
	}
}
