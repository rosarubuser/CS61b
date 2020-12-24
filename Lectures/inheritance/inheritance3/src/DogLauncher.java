public class DogLauncher {
    public static void main(String[] args) {
        Dog d1 = new Dog("Elyse", 3);
        Dog d2 = new Dog("Sture", 9);
        Dog d3 = new Dog("Benjamin", 15);
        Dog[] dogs = new Dog[]{d1, d2, d3};

        // Dog d = (Dog) Maximizer.max(dogs);
        // System.out.println(d.name);

        Comparator<Dog> nc= Dog.getNameComparator();
        int maxIndex = 0;
        for (int i = 1; i < dogs.length; i++) {
            int cmp = nc.compare(dogs[maxIndex], dogs[i]);
        }
        dogs[maxIndex].bark();
    }
}