/** Performs some basic linked list tests. */
public class ArrayDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		ArrayDeque<String> al1 = new ArrayDeque<>();

		// check isEmpty
		boolean passed = checkEmpty(true, al1.isEmpty());

		al1.addLast("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, al1.size()) && passed;
		passed = checkEmpty(false, al1.isEmpty()) && passed;

		al1.addFirst("middle");
		passed = checkSize(2, al1.size()) && passed;

		al1.addFirst("back");
		passed = checkSize(3, al1.size()) && passed;

		System.out.println("Printing out deque: ");
		al1.printDeque();

		System.out.println("to get the item[1]: " + al1.get(1));

		ArrayDeque<String> al2 = new ArrayDeque<>(al1);
		System.out.println("Printing out deque2: ");
		al2.printDeque();

		printTestStatus(passed);
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		ArrayDeque<Integer> al1 = new ArrayDeque<>();
		// should be empty 
		boolean passed = checkEmpty(true, al1.isEmpty());

		al1.addLast(10);
		// should not be empty 
		passed = checkEmpty(false, al1.isEmpty()) && passed;

		al1.removeLast();
		// should be empty 
		passed = checkEmpty(true, al1.isEmpty()) && passed;

		printTestStatus(passed);
	}

	public static void upsizeDownsizeTest() {
		System.out.println("Running upsize / downsize test.");

		ArrayDeque<Integer> al1 = new ArrayDeque<>();
		for (int i = 0; i < 32; i += 1) {
			al1.addFirst(i);
		}
		System.out.println("The capacity of al1 is: " + al1.getArrayCapacity());
		System.out.println("The array size is: " + al1.size());
		al1.printDeque();
		System.out.println();

		for (int i = 0; i < 24; i += 1) {	// FIXME downsize error
			al1.removeFirst();
		}
		System.out.println("After removing the items:");
		System.out.println("The capacity of al1 is: " + al1.getArrayCapacity());
		System.out.println("The array size is: " + al1.size());
		al1.printDeque();
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		upsizeDownsizeTest();
	}
} 