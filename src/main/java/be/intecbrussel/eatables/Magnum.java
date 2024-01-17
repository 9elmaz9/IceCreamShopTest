package be.intecbrussel.eatables;

public class Magnum  implements Eatable{
    private MagnumType type;

    public Magnum(){
        this(MagnumType.MILKCHOCOLATE);
    }

    public Magnum(MagnumType type) {
        this.type = type;
    }

    @Override
    public void eat() {
        System.out.print("You are eating Magnum: " + this.type);
    }

    public MagnumType getType() {
        return type;
    }

    public enum MagnumType {

        MILKCHOCOLATE,
        WHITECHOCOLATE,
        BLACKCHOCOLATE,
        APLINENUTS,
        ROMANTICSTRAWBERRIES;

        @Override
        public String toString() {
            return "MagnumType " + super.toString();
        }
    }

    @Override
    public String toString() {
        return "Magnum{" +
                "type=" + type +
                '}';
    }
}
