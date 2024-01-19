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


    // +(price * 0.25)
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

    //  create and return a new iceRocket.
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

    //  return a new Magnum  from MagnumType.
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
