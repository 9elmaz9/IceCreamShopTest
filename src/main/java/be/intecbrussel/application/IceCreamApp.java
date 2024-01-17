package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.seller.IceCreamCar;
import be.intecbrussel.seller.PriceList;
import be.intecbrussel.seller.Stock;

import java.util.Objects;
import java.util.stream.Stream;

public class IceCreamApp {

    public static void main(String[] args) {

        //store various ice cream
        Eatable[] eatable = new Eatable[8];

        PriceList priceList = new PriceList(1, 2, 4);

        //
        Stock stock = new Stock();
        stock.setBalls(2);
        stock.setIceRockets(1);
        stock.setMagni(2);


        IceCreamCar iceCreamCar = new IceCreamCar(priceList, stock);

        Cone.Flavor[] balls = {null};
        Cone.Flavor[] balls2 = {
                Cone.Flavor.STRAWBERRY,
                Cone.Flavor.BANANA,
                Cone.Flavor.CHOCOLATE,
                Cone.Flavor.VANILLA
        };
        Cone.Flavor[] balls3 = {
                Cone.Flavor.PISTACHE,
                Cone.Flavor.BANANA,
                Cone.Flavor.BANANA,
                Cone.Flavor.STRAWBERRY,
                Cone.Flavor.CHOCOLATE,
                Cone.Flavor.PISTACHE

        };

        //order
        Cone cone = iceCreamCar.orderCone(balls);
        Cone cone1 = iceCreamCar.orderCone(balls2);
        Cone cone2 = iceCreamCar.orderCone(balls3);

        IceRocket iceRocket = iceCreamCar.orderIceRocket();
        IceRocket iceRocket2 = iceCreamCar.orderIceRocket();

        Magnum magnum = iceCreamCar.orderMagnum(Magnum.MagnumType.APLINENUTS);
        Magnum magnum2 = iceCreamCar.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);
        Magnum magnum3 = iceCreamCar.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);

        eatable[0] = cone;
        eatable[1] = cone1;
        eatable[2] = cone2;
        eatable[3] = iceRocket;
        eatable[4] = iceRocket2;
        eatable[5] = magnum;
        eatable[6] = magnum2;
        eatable[7] = magnum3;

        //use streams to filter out null elements and call the eat() o, each Eatable object
        Stream.of(eatable)
                .filter(Objects::nonNull)
                .forEach(Eatable::eat);

    }
}