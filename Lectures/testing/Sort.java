public class Sort {
    /** sort strings destructively(in-place) */
    public static void sort(String[] x) {
        sort(x, 0);
    }

    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        int smallest = findSmallest(x, start);
        swap(x, start, smallest);
        sort(x, start + 1);
    }

    public static int findSmallest(String[] x, int start) {
        int smallest = start;
        for (int i = start; i < x.length; i += 1) {
            int cmp = x[i].compareTo(x[smallest]);
            if (cmp < 0) {
                smallest = i;
            }
        }
        return smallest;
    }

    public static void swap(String[] x, int a, int b) {
        String tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;
    }
}