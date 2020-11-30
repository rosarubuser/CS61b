public class SLList {
	private class IntNode {
		public int item;
		public IntNode next;
		public IntNode(int item, IntNode next) {
			this.item = item;
			this.next = next;
		}
	}

	private IntNode first;

	public void addFirst(int x) {
		first = new IntNode(x, first);
	}

	// IMPORTANT: recursive method
	public void reverse() {
		first = revserseRecursiveHelper(first);
	}

	public IntNode revserseRecursiveHelper(IntNode front) {
		if (front == null || front.next == null) {
			return front;
		} else {
			// head of reversed list, unchanged throughout the way
			IntNode reversed = revserseRecursiveHelper(front.next);
			front.next.next = front;
			front.next = null;
			return reversed;
		}
	}

	public void printList() {
		IntNode ptrNode = first;
		while (ptrNode != null) {
			System.out.println(ptrNode.item);
			ptrNode = ptrNode.next;
		}
	}

	public static void main(String[] args) {
		// testing
		SLList testing = new SLList();
		testing.addFirst(2);
		testing.addFirst(6);
		testing.addFirst(10);
		testing.addFirst(9);
		testing.printList();
		testing.reverse();
		testing.printList();
	}

/*--------------------disc03 1.2 sol--------------------
	public void reverse() {
		IntNode frontOfReversed = null;
		IntNode nextNodeToAdd = first;
		while (nextNodeToAdd != null) {
			IntNode reminderOfOriginal = nextNodeToAdd.next;
			nextNodeToAdd.next = frontOfReversed;
			frontOfReversed = nextNodeToAdd;
			nextNodeToAdd = reminderOfOriginal;
		}
		first = frontOfReversed;
	}

	public void printList() {
		IntNode ptrNode = first;
		while (ptrNode != null) {
			System.out.println(ptrNode.item);
			ptrNode = ptrNode.next;
		}
	}

	public static void main(String[] args) {
		// testing
		SLList testing = new SLList();
		testing.addFirst(2);
		testing.addFirst(6);
		testing.addFirst(10);
		testing.addFirst(9);
		testing.printList();
		testing.reverse();
		testing.printList();
	}*/

/*--------------------disc03 1.2 v1--------------------
	public void reverse() {
		// 3->1->4->5  ==> 5->4->1->3
		IntNode ptrNode = first;
		int size = 0;
		if (first == null) {
			return;
		} else {
			size = 1;
			while (ptrNode.next != null) {
				size++;
				ptrNode = ptrNode.next;
			}
		}
		int count;
		IntNode leadNode;
		IntNode endNode;
		while (size > 1){
			count = size;
			leadNode = first;
			endNode = first;
			while (count > 2) {
				// find two nodes connected to the same arrow
				leadNode = leadNode.next;
				endNode = endNode.next;
				count--;
			}
			leadNode = leadNode.next;
			leadNode.next = endNode;
			endNode.next = null;
			size--;
		}
		// change the head
		first = ptrNode;
	}

	public void printList() {
		IntNode ptrNode = first;
		while (ptrNode != null) {
			System.out.println(ptrNode.item);
			ptrNode = ptrNode.next;
		}
	}

	public static void main(String[] args) {
		// testing
		SLList testing = new SLList();
		testing.addFirst(2);
		testing.addFirst(6);
		testing.addFirst(10);
		testing.addFirst(8);
		testing.printList();
		testing.reverse();
		testing.printList();
	}
	*/



/*--------------------disc03 1.1 v1--------------------

	public void insert(int x, int position) {
		int size = calSize();
		IntNode preNode;
		if (position > size) {
			// insertion beyond the last node
			preNode = findNode(position);
			preNode.next = new IntNode(x, null);
		} else if (position == 0){
			first = new IntNode(x, first);
		} else if (position > 0){
			preNode = findNode(position - 1);
			preNode.next = new IntNode(x, preNode.next);
		}
	}

	private int calSize() {
		int size = 0;
		IntNode ptr = first;
		while (ptr != null) {
			size ++;
			ptr = ptr.next;
		}
		return size;
	}

	private IntNode findNode(int position) {
		IntNode ptr = first;
		int size = calSize();
		if (position <= size) {
			while (position > 0) {
				ptr = ptr.next;
				position--; 
			}
		} else {
			// if the position is beyond the size, return the last Node
			while (ptr.next != null) {
				ptr = ptr.next;
			}
		}
		return ptr;
	}

	public void printList() {
		IntNode ptrNode = first;
		while (ptrNode != null) {
			System.out.println(ptrNode.item);
			ptrNode = ptrNode.next;
		}
	}

	public static void main(String[] args) {
		// testing
		SLList testing = new SLList();
		testing.addFirst(2);
		testing.addFirst(6);
		testing.addFirst(10);
		testing.insert(5,4);
		testing.printList();
	}

	---------------------------------------------------------*/


/*--------------------disc03 1.1 sol--------------------
	public void insert(int x, int position) {
		// the previous node is null 
		if (first == null || position == 0) {
			first = new IntNode(x, first);
			return;
		} 

		IntNode preNode = first;
		// to ensure the IntNode pointer points to the position before the desired && 
		// not to beyound the size
		while (position > 1 && preNode.next != null) {
			position--;
			preNode = preNode.next;
		}
		preNode.next = new IntNode(x, preNode.next);
	}

	public void printList() {
		IntNode ptrNode = first;
		while (ptrNode != null) {
			System.out.println(ptrNode.item);
			ptrNode = ptrNode.next;
		}
	}

	public static void main(String[] args) {
		// testing
		SLList testing = new SLList();
		testing.addFirst(2);
		testing.addFirst(6);
		testing.addFirst(10);
		testing.insert(5,5);
		testing.printList();
	}
	*/
}