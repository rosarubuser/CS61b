public class SLList {

    private static class IntList {
        int item;
        IntList next;

        public IntList(int i, IntList n) {
            item = i;
            next = n;
        }
    }

    private IntList sentinel;
    private int size;

    public SLList() {
        sentinel = new IntList(999, null);
        size = 0;
    }
    public SLList(int x) {
        sentinel = new IntList(999, null);
        sentinel.next = new IntList(x, null);
        size = 1;
    }

    /** add an item in front of a list */
    public void addFirst(int x) {
        sentinel.next = new IntList(x, sentinel.next);
        size += 1;
    }

    /** get the first item in a list */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** return the size of list */
    public int size() {
        return size;
    }

    /** Add an item to the end of a list */
    public void addLast(int x) {
        size += 1;
        IntList p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntList(x, null);
    }

    public static void main(String[] args) {
        SLList testingL = new SLList(15);
        testingL.addFirst(10);
        testingL.addFirst(5);
        testingL.addLast(1);
        System.out.println(testingL.getFirst());
        System.out.println(testingL.size());
    }
}


/** return the size of list by iteration */
    /*public int size() {
        IntList p = this.first;
        int size = 0;
        while (p != null) {
            size += 1;
            p = p.next;
        }
        return size;
    }*/

/** helper method for size */
    /*private int size(IntList p) {
        if (p.next == null){
            return 1;
        }
        return 1 + size(p.next);
    }*/

/** return the size of list by recursion */
/*    public int size() {
        return size(first);
    }*/