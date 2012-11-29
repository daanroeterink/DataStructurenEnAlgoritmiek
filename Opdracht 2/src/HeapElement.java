public class HeapElement
{

	/**
	 * 
	 */
	private int data;

	/**
	 * 
	 */
	private HeapElement left;

	/**
	 * 
	 */
	private HeapElement right;

	public int getData()
	{
		return data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	public HeapElement getLeft()
	{
		return left;
	}

	public void setLeft(HeapElement left)
	{
		this.left = left;
	}

	public HeapElement getRight()
	{
		return right;
	}

	public void setRight(HeapElement right)
	{
		this.right = right;
	}

	public boolean hasEmptySpot()
	{
		if (left == null || right == null)
		{
			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	public HeapElement()
	{
	}

	public HeapElement(int data)
	{
		this.data = data;
	}

	public void println()
	{
		System.out.println(" | " + data + " | ");
	}

	public void print()
	{
		System.out.print(" | " + data + " | ");
	}

	public boolean isSmaller(int data)
	{
		boolean result = true;
		if (left != null)
		{
			if (left.getData() > data)
			{
				result = true;
			}
			else
			{
				return false;
			}
		}

		if (right != null)
		{
			if (right.getData() > data)
			{
				result = true;
			}
			else
			{
				return false;
			}
		}

		return result;
	}
}
