package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.seller.IceCreamCar;
import be.intecbrussel.seller.IceCreamSalon;
import be.intecbrussel.seller.PriceList;
import be.intecbrussel.seller.Stock;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class IceCreamApp {

    public static void main(String[] args) {

        //store various ice cream
        Eatable[] eatable = new Eatable[8];

        PriceList priceList = new PriceList(1, 2, 4);

        Stock stock = new Stock();
        stock.setBalls(2);
        stock.setIceRockets(1);
        stock.setMagni(2);

        IceCreamCar iceCreamCar = new IceCreamCar(priceList, stock);

        //Order ice cream directly
        List<Eatable> orderedIceCream = Arrays.asList(
                iceCreamCar.orderCone(null),
                iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY, Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE, Cone.Flavor.VANILLA}),
                iceCreamCar.orderCone(new Cone.Flavor[]{Cone.Flavor.PISTACHE, Cone.Flavor.BANANA, Cone.Flavor.BANANA, Cone.Flavor.STRAWBERRY, Cone.Flavor.CHOCOLATE, Cone.Flavor.PISTACHE}),
                iceCreamCar.orderIceRocket(),
                iceCreamCar.orderIceRocket(),
                iceCreamCar.orderMagnum(Magnum.MagnumType.APLINENUTS),
                iceCreamCar.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES),
                iceCreamCar.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE)
        );


        eatable=orderedIceCream.toArray(new Eatable[0]);

        Arrays.stream(eatable)
                .filter(e-> e != null)
                .forEach(Eatable::eat);

    }
}

















  
