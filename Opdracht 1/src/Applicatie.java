import java.util.Random;

import javax.management.BadAttributeValueExpException;

public class Applicatie {

	int n = 100000;
	Random random = new Random();
	int array[] = new int[n];

	public Applicatie() {
		for (int i = 0; i < n; i++) {
			int randomNumber = random.nextInt(n);
			for (int j = 0; j < i; j++) {
				if (array[j] == randomNumber) {
					j = -1;
					randomNumber = random.nextInt(n);
				}
			}
			array[i] = randomNumber;
		}

//		try {
//			doubleCheck(array);
//		} catch (BadAttributeValueExpException e) {
//			e.printStackTrace();
//		}
		for (int i : array) {
			System.out.print(i + "|");
		}
	}
	
	public void doubleCheck(int[] checkArray) throws BadAttributeValueExpException {
		for(int i =0; i < checkArray.length; i++) {
			int value = checkArray[i];
			for(int j = 0; j < checkArray.length; j++) {
				if(j != i)
				if(checkArray[j] == value)
					throw new BadAttributeValueExpException(new Object());
			}
		}
	}
	

	public static void main(String args[]) {
		new Applicatie();
	}
}
