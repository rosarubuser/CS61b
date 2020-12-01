/** use circular implementation */
public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int nextFirst;  // pointer to the next added item
    private int nextLast;


    /** initial array of size 8 */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    /** deep copy of other array deque */
    public ArrayDeque(ArrayDeque<T> other) {
        items = (T[]) new Object[other.size()]; // TODO: testing for size()
        size = other.size;
        for (int i = nextFirst + 1; i < nextLast; i += 1) {
           if (i > items.length - 1) {
               i = 0;
           }
           items[i] = other.items[i];
        }
    }

    /** upsize the array by 2 times */
    private void upsize() {
        T[] tmp = (T[]) new Object[size() * 2]; // use a factor of 2;
        System.arraycopy(items, 0, tmp, 0, items.length);
        items = tmp;
    }

    /** downsize the array */
    private void downsize() {
        T[] tmp = (T[]) new Object[size() / 2]; // use a factor of 2;
        System.arraycopy(items, 0, tmp, 0, items.length);
        items = tmp;
    }

    /** add an item in the beginning of array */
    public void addFirst(T item) {
        if (size() == items.length) {
            upsize();
        }
        items[nextFirst] = item;
        size += 1;
        if (nextFirst != 0)
            nextFirst -= 1;
        else
            nextFirst = items.length - 1;
    }

    /** add an item at the end of array */
    public void addLast(T item) {
        if (size() == items.length) {
            upsize();
        }
        items[nextLast] = item;
        size += 1;
        if (nextLast != items.length - 1)
            nextLast += 1;
        else
            nextFirst = 0;
    }

    /** Judge whether an array is empty or not */
    public boolean isEmpty() {
       if (size == 0) return true;
       else return false;
    }

    /** return the size of the array */
    public int size() {
        return size;
    }

    /** print each item in an array */
    public void printDeque() {
        if (size() == 0) return;
        if (nextFirst + 1 <= nextLast - 1) {
            for (int i = 0; i < size(); i += 1) {
                System.out.print(items[nextFirst + 1 + i] + " ");
            }
        } else {
            for (int i = nextFirst + 1; i < items.length - 1; i += 1) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < nextLast - 1; i += 1) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }

    /** remove the first item in an array */
    public T removeFirst() {
        if (nextFirst == size() - 1) {
            nextFirst = 0;
        } else {
            nextFirst += 1;
        }
        T tmp = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;

        if (items.length / size() >= 4) {
            downsize();
        }

        return tmp;
    }

    /** remove the last item in a list */
    public T removeLast() {
        if (items.length / size() >= 4) {
            downsize();
        }

        if (nextLast == 0) {
            nextLast = size() - 1;
        } else {
            nextLast += nextLast - 1;
        }
        T tmp = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return tmp;
    }

    /**
     * get the item at a given index in a list
     * if the items doesn't exist, return null
     */
    public T get(int index) {
        if (isEmpty() || index < 0 || index > size() - 1) {
            return null;
        }
        int pos = nextFirst + 1 + index;
        if (pos > items.length) {
            pos -= items.length;
        }
        return items[pos];
    }
}
