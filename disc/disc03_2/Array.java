public class Array {

	public static int[] replicate(int[] arr) {
		int total = 0;
		for (int item : arr) {
			total += item;
		}

		int[] result = new int[total];

		int count = 0;
		for (int item : arr) {
			for (int i = 0; i < item; i++) {
				result[count] = item;
				count++;
			}
		}
		return result;
	}

	public static void printArr(int[] arr){
		for (int item : arr) {
			System.out.println(item);
		}
	}

	public static void main (String[] args) {
		int[] origin = new int[]{0};
		int[] result = replicate(origin);
		printArr(result);
	} 

	/* q 2.3 wrong solution..didn't consider 0
	public static int[] replicate(int[] arr) {
		int pos = 0;
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int[] origin = result;
			result = new int[origin.length + arr[i] - 1];
			System.arraycopy(origin, 0, result, 0, origin.length);
			for (int j = 0; j < arr[i]; j++){
				result[pos] = arr[i];
				pos++;
			}
		}
		return result;
	}

	public static void printArr(int[] arr){
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void main (String[] args) {
		int[] origin = new int[]{3, 5};
		int[] result = replicate(origin);
		printArr(result);
	} 
	*/

	/* q2.2
	public static void reverse(int[] arr) {
		int buff;
		for (int i = 0; i < arr.length/2; i++) {
			buff = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = buff;
		}
	}

	public static void printArr(int[] arr){
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void main (String[] args) {
		int[] arr = new int[]{};
		printArr(arr);
		System.out.println();
		reverse(arr);
		printArr(arr);
	} 
	*/

	/* sol 2.1
	public static int[] insert(int[]arr, int item, int position) {
		int[] result = new int[arr.length + 1];
		position = Math.min(arr.length, position);
		for (int i = 0; i < position; i++) {
			result[i] = arr[i];
		}
		result[position] = item;
		for (int i = position; i < arr.length; i++) {
			result[i + 1] = arr[i];
		}
		return result;
	}

	public static void printArr(int[] arr){
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void main (String[] args) {
		int[] arr = new int[]{5, 9, 14, 15};
		printArr(arr);
		int[] updatedArr = insert(arr, 6, 8);
		printArr(updatedArr);
	} 
	*/

	/* v1
	public static int[] insert(int[]arr, int item, int position) {
		int capacity = arr.length + 1;
		int[] updatedArr = new int[capacity];
		int i = 0;
		if (position >= capacity) {
			System.arraycopy(arr, 0, updatedArr, 0, capacity - 1);
			updatedArr[capacity - 1] = item;
		} else {
			for (; i < capacity; i++) {
				if (i < position)
					updatedArr[i] = arr[i];
				else if (i == position)
					updatedArr[i] = item;
				else
					updatedArr[i] = arr[i - 1];
			}
		}
		return updatedArr;
	}

	public static void printArr(int[] arr){
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void main (String[] args) {
		int[] arr = new int[]{5, 9, 14, 15};
		printArr(arr);
		int[] updatedArr = insert(arr, 6, 8);
		printArr(updatedArr);
	} 

	*/

}