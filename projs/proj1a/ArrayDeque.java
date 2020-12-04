/** use circular implementation */
public class ArrayDeque<Item> {

    private Item[] items;
    private int size;
    private int nextFirst;  // pointer to the next added item
    private int nextLast;


    /** initial array of size 8 */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    /** deep copy of other array deque */
    public ArrayDeque(ArrayDeque<Item> other) {
        items = (Item[]) new Object[other.items.length];
        size = other.size;
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        int copyP = plusOne(nextFirst, items.length);
        for (int i = 0; i < size(); i += 1) {
            items[copyP] = other.items[copyP];
            copyP = plusOne(copyP, items.length);

        }
    }

    /** helps to find the backward pointer for either nextFirst or nextLast */
    private int minusOne(int nextPointer, int arrayCapacity) {
        if (nextPointer == 0) {
            return arrayCapacity - 1;
        } else {
            return nextPointer - 1;
        }
    }

    /** helps to find the forward pointer for nextFirst or nextLast */
    private int plusOne(int nextPointer, int arrayCapacity) {
        if (nextPointer == arrayCapacity - 1) { // FIXME length for other array
            return 0;
        } else {
            return nextPointer + 1;
        }
    }

    /** upsize the array by 2 times */
    private void upsize() {
        resize(items.length * 2);
    }

    /** downsize the array by 2. Ensure the usage factor is at least 25%*/
    private void downsize() {
        resize(items.length / 2);
    }

    /** helps to resize the array; insertion starts at the mid position*/
    private void resize(int newSize) {
        Item[] newArr = (Item[]) new Object[newSize];
        int newNextFirst = newSize / 2;
        int newP = plusOne(newNextFirst, newSize);
        int originP = plusOne(nextFirst, items.length);
        for (int i = 0; i < size(); i += 1) {
            newArr[newP] = items[originP];
            newP = plusOne(newP, newSize);
            originP = plusOne(originP, items.length);
        }

        items = newArr;
        nextFirst = newNextFirst;
        nextLast = newP;
    }

    /** add an item at the beginning of array */
    public void addFirst(Item item) {
        if (size() == items.length) {
            upsize();
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst, items.length);
    }

    /** add an item at the end of array */
    public void addLast(Item item) {
        if (size() == items.length) {
            upsize();
        }
        items[nextLast] = item;
        size += 1;
        nextLast = plusOne(nextLast, items.length);
    }

    /** Judge whether an array is empty or not */
    public boolean isEmpty() {
       if (size == 0)
           return true;
       else
           return false;
    }

    /** return the size of the array */
    public int size() {
        return size;
    }

    /** print each item in an array separated by a space. Ended with a new line */
    public void printDeque() {
        if (size() == 0) return;
        int p = plusOne(nextFirst, items.length);
        for (int i = 0; i < size(); i += 1) {
            System.out.print(items[p] + " ");
            p = plusOne(p, items.length);
        }
        System.out.println();
    }

    /** remove the first item in an array. If no such item, return null */
    public Item removeFirst() {
        if (isEmpty()) return null;

        nextFirst = plusOne(nextFirst, items.length);
        Item tmp = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;

        if (items.length >= 16 && items.length / size >= 4) {
            downsize();
        }

        return tmp;
    }

    /** remove the last item in a list. If no such item, return null */
    public Item removeLast() {
        if (isEmpty()) return null;

        nextLast = minusOne(nextLast, items.length);
        Item tmp = items[nextLast];
        items[nextLast] = null;
        size -= 1;

        if (items.length >= 16 && items.length / size >= 4) {    // based on short cut, considered size == 0
            downsize();
        }

        return tmp;
    }

    /**
     * get the item at a given index in a list
     * if the items doesn't exist, return null
     */
    public Item get(int index) {
        if (isEmpty() || index < 0 || index > size() - 1) {
            return null;
        }
        int p = plusOne(nextFirst, items.length);
        for (int i = 0; i < index; i += 1) {
            p = plusOne(p, items.length);
        }
        return items[p];
    }

    /** for testing upsize/downsize */
    public int getArrayCapacity() {
        return items.length;
    }
}
