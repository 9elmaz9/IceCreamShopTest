package be.intecbrussel.seller;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

import java.util.stream.Stream;

public class IceCreamCar implements IceCReamSeller {
    private PriceList priceList;
    private Stock stock;
    private double profit;

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        // OK -> guard close
        flavors = Stream.of(flavors).filter(flavor -> flavor != null).toArray(Cone.Flavor[]::new);

        //Write with guard close
        Cone preparedCone = prepareCone(flavors);

        if (preparedCone != null) {
//            long countOrderBalls = Stream.of(flavors)
//                    .filter(elem -> elem != null)
//                    .count();
            long countOrderBalls = flavors.length;
            double priceCone = priceList.getBallPrice();
            this.profit += countOrderBalls * priceCone * 0.25;
            return preparedCone;
        } else {
            return null;
        }
    }

    // get the profit from the IceCream
    private Cone prepareCone(Cone.Flavor[] flavors) {

        Cone iceCone;

        int currentBallStock = stock.getBalls();
        int currentConeStock = stock.getCones();

        if (currentBallStock < flavors.length || currentConeStock < 1) {
            System.out.println("NO MORE CONE ICE CREAM");
            return null;
        }

        iceCone = new Cone(flavors);
        stock.setBalls(currentBallStock - flavors.length);
        stock.setCones(currentConeStock - 1);

        return iceCone;
    }

    @Override
    public IceRocket orderIceRocket() {

        IceRocket iceRocket = prepareRocket();
        if (iceRocket != null) {
            double priceIceRocket = priceList.getRocketPrice();
            this.profit += priceIceRocket * 0.2;
        } else {
            return null;
        }
        return iceRocket;
    }
    private IceRocket prepareRocket() {

        IceRocket iceRocket = new IceRocket();
        int currentStock = stock.getIceRockets();
        if (currentStock != 0) {
            currentStock = currentStock - 1;
        } else {
            System.out.println("NO MORE ROCKET ICE CREAM");
            return null;
        }
        stock.setIceRockets(currentStock);
        return iceRocket;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {

        Magnum preparedMagnum = prepareMagnum(magnumType);
        if (preparedMagnum != null) {
            double priceMagnum = priceList.getMagnumPrice(magnumType);
            this.profit += priceMagnum * 0.01;
        } else {
            return null;
        }

        return preparedMagnum;
    }

    private Magnum prepareMagnum(Magnum.MagnumType magnumType) {

        int magniStock = stock.getMagni();

        if (magniStock != 0) {
            magniStock = magniStock - 1;
        } else {
            System.out.println("NO MORE MAGNUM ICE CREAM");
            return null;
        }
        stock.setMagni(magniStock);
        // return profit for magnum
        return new Magnum(magnumType);
    }

    public double getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return "IceCreamCar{" +
                "priceList=" + priceList +
                ", stock=" + stock +
                ", profit=" + profit +
                '}';
    }
}
