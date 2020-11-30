public class Dog {
    int weightInPounds;

    void Dog (int w) {
        weightInPounds = w;
    }

    public static Dog maxDog (Dog d1, Dog d2) {
        if (weightInPounds > d2.weightInPounds) {
            return this;
        }
        return d2;
    }

    public static void main (String[] args) {
        Dog d2 = new Dog(1);
        Dog d1 = new Dog(100);
        Dog.maxDog(d1, d2);
    }

        }