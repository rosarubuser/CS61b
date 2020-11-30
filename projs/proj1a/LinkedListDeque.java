/** implement LLDeque by circular sentinel approach */
public class LinkedListDeque<T> {

    /** create a elementary list with two end pointers */
    private static class EleList<T> {
        T item;
        EleList next;
        EleList prev;

        public EleList(T i, EleList p, EleList n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private EleList sentinel;
    int size;

    /** create an empty list of a sentinel with two end pointers to sentinel*/
    public LinkedListDeque() {
        sentinel = new EleList<>(999, null, null);
        // cannot write
        // sentinel = new EleList<>(999, sentinel, sentinel);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
        // TODO: should I change 999 to type T?
    }

    /** make a deep copy of other deque of the same type */
    public LinkedListDeque(LinkedListDeque<T> other) {
        LinkedListDeque<T> newDeque = new LinkedListDeque<>();
        sentinel = new EleList<>(999, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast(other.get(i));
        }
    }

    /** add an element at the front of a list */
    public void addFirst(T item){
        EleList<T> newL = new EleList<>(item, sentinel, sentinel.next);
        sentinel.next = newL;
        newL.next.prev = newL;
        size += 1;
    }

    /** add an element at the end of a list */
    public void addLast(T item) {
        EleList<T> newL = new EleList<>(item, sentinel.prev, sentinel);
        sentinel.prev = newL;
        sentinel.prev.next = newL;
        size += 1;
    }

    /** return whether a list is empty */
    public boolean isEmpty(){
        if (sentinel.next == sentinel)
            return true;
        else
            return false;
    }
    public int size() {
        return size;
    }

    /** print the items in deque from first to last, separated by a space;
     * when all is printed, ended with a new line */
    public void printDeque() {
        if (!isEmpty()) {
            EleList<T> p = sentinel.next;
            while (p != sentinel) {
               System.out.print(p.item + " ");
               p = p.next;
            }
            System.out.println();
        }
    }

    /** remove the first item in deque */
    public T removeFirst() {
        if (isEmpty()) return null;
        EleList<T> tmp = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return tmp.item;
    }

    /** remove the last item in deque */
    public T removeLast() {
        if (isEmpty()) return null;
        EleList<T> tmp = sentinel.prev;
        sentinel.prev = tmp.prev;
        tmp.prev.next = sentinel;
        size -= 1;
        return tmp.item;
    }

    /** get the item at the given index
     * if no such item, return null
     * use iteration
     */
    public T get(int index) {
        if (!(0 <= index && index <= size() - 1))
            return null;
        EleList<T> p = sentinel.next;
        while (index != 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    /** get the item at the index by recursion */
    public T getRecursive(int index) {
        if (!(0 <= index && index <= size() - 1))
            return null;
        EleList<T> p = sentinel.next;
        return getHelper(index, p);
    }

    private T getHelper(int index, EleList<T> pList) {
        if (index == 0) return pList.item;
        else {
            index -= 1;
            return getHelper(index, pList.next)
        }
    }

}
