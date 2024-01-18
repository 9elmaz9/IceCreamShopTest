package be.intecbrussel.eatables;

import java.util.Arrays;

public class Cone implements Eatable {

    private Flavor[] balls;

    // default value Vanilla
    public Cone() {
        this(new Flavor[]{Flavor.VANILLA});
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }





    // all different types of balls,
    @Override
    public void eat() {
        System.out.print("You are eating Cone with: "
                + Arrays.toString(this.balls));

    }

    public enum Flavor {
        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        LEMON,
        STRACIATELLA,
        MOKKA,
        PISTACHE;

        public static Flavor getFlavor(String input) {
            for (Flavor flavor:values()) {
                if(flavor.name().toLowerCase().contains(input.toLowerCase())){
                   return flavor;
                }
            }
            return null;
        }
    }

    @Override
    public String toString() {
        return "Cone{" +
                "balls=" + Arrays.toString(this.balls) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cone cone = (Cone) o;
        return Arrays.equals(balls, cone.balls);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(balls);
    }
}
