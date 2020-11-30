/*  V1 naked recursive List
public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r) {
       first = f;
       rest = r;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);
    }
} */

/*
public class IntList {
    int item;
    IntList next;

    public IntList(int i, IntList n) {
        item = i;
        next = n;
    }

    public void addFirst(int x) {
        IntList tmp = new IntList(item, next);
        item = x;
        next = tmp;
    }

    public int getFirst() {
       return item;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.addFirst(10);
        L.addFirst(15);
        System.out.println(L.getFirst());
    }
}
 */
