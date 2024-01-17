package be.intecbrussel.seller;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

import java.util.stream.Stream;

public class IceCreamSalon  implements IceCReamSeller{
    private PriceList priceList;
    private double totalProfit;

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
        totalProfit = 0; // TODO
    }


    public double getProfit() {
        return totalProfit;
    }


    // -orderCone will create and return a new cone based on an array of flavors.
    // will also increase the total profit value based on the price list.(price * 0.25)
    @Override
    public Cone orderCone(Cone.Flavor[] flavors){

        Cone iceCone = new Cone(  flavors);

        long countOrderBalls = Stream.of(flavors)
                .filter(elem -> elem != null)
                .count();

        double priceCone = priceList.getBallPrice();
        totalProfit += countOrderBalls * priceCone * 0.25;

        return iceCone;

    }

    // orderIceRocket will create and return a new iceRocket.
    // will also increase the total profit value based on the price list.(price * 0.20)
    @Override
    public IceRocket orderIceRocket(){

        IceRocket iceRocket = new IceRocket();

        double priceRocket = priceList.getRocketPrice();
        if (priceRocket != 0){
            this.totalProfit += priceRocket * 0.2;
            return iceRocket;
        } else {
            return null;
        }
    }

    // orderMagnum will create and return a new Magnum based on a MagnumType.
    // will also increase the total profit value based on the price list.(price * 0.01)
    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {

        Magnum magnum = new Magnum(magnumType);

        double magnumPrice = priceList.getMagnumPrice(magnumType);

        this.totalProfit += magnumPrice * 0.01;

        return magnum;
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" +
                "priceList=" + priceList +
                ", totalProfit=" + totalProfit +
                '}';
    }
}
