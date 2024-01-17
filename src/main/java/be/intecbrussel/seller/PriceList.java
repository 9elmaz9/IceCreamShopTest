package be.intecbrussel.seller;

import be.intecbrussel.eatables.Magnum;

public class PriceList {
    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;

    public PriceList() {
        this(1,2, 2.5);
    }

    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice) {
        this.ballPrice = ballPrice;
        this.rocketPrice = rocketPrice;
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public double getBallPrice() {
        return ballPrice;
    }

    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    // will return, based on a given MagnumType and a generally specified magnumStandardPrice,
    // what the price of such a magnum will be. Eg:
    // An alpine nuts magnum will be 1.5 times the price of a standard magnum
    public double getMagnumPrice(Magnum.MagnumType magnumType) {

        double totalPrice = 0;
        switch (magnumType) {
            case MILKCHOCOLATE -> totalPrice = magnumStandardPrice * 0.25;
            case WHITECHOCOLATE -> totalPrice = magnumStandardPrice * 0.5;
            case BLACKCHOCOLATE -> totalPrice = magnumStandardPrice * 0.75;
            case ROMANTICSTRAWBERRIES -> totalPrice = magnumStandardPrice * 1.25;
            case APLINENUTS -> totalPrice = magnumStandardPrice * 1.5;
        }
        return totalPrice;
    }

    // generally specified magnumStandardPrice,
    // what the price of such a magnum will be. Eg:
    // An alpinenuts magnum will be 1.5 times the price of a standard magnum
    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }

     @Override
  public String toString() {
      return "PriceList{" +
              "ballPrice=" + ballPrice +
              ", rocketPrice=" + rocketPrice +
              ", magnumStandardPrice=" + magnumStandardPrice +
              '}';
  }
}
