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



        //method to get MagnumType by flavor
        public static MagnumType getMagnumType(String flavor) {
            switch (flavor.toUpperCase()) {
                case "MILK":
                    return MILKCHOCOLATE;
                case "WHITE":
                    return WHITECHOCOLATE;
                case "BLACK":
                    return BLACKCHOCOLATE;
                case "ALPINE":
                    return APLINENUTS;
                case "ROMANTIC":
                    return ROMANTICSTRAWBERRIES;
                default:
                    return null;
            }
        }

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
