package be.intecbrussel;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.seller.IceCreamCar;
import be.intecbrussel.seller.PriceList;
import be.intecbrussel.seller.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class IceCreamCarTest {


    IceCreamCar iceCreamCar;
    Stock stock = new Stock();


    @BeforeEach   //  is used on a method to run before each test method
    void setup() {
        stock.reset(); // reset all stock values to 0
        iceCreamCar = new IceCreamCar(new PriceList(1, 2, 2.5),
                stock);
    }

    @ParameterizedTest // returt null when snock is empty
    @MethodSource("provideSingleFlavors")
    void orderConeShouldReturnNullWhenCurrentStockIsEmpty(Cone.Flavor coneFlavour) {

        assertNull(iceCreamCar.orderCone(new Cone.Flavor[]{coneFlavour}));

    }


    //Tests that orderCone returns a cone and updates profit correctly when flavors are not null and stock is available.
    @ParameterizedTest
    @MethodSource("returnFlavoursList")
    void orderConeShouldReturnProfitableConeWhenFlavorsNotNullAndStockIsAvailable(List<Cone.Flavor> flavors) {

        stock.setCones(3);
        stock.setBalls(3);
        assertEquals(0.0, iceCreamCar.getProfit());

        //Cone result = iceCreamCar.orderCone(new Cone.Flavor[] {Cone.Flavor.BANANA, Cone.Flavor.LEMON});
        Cone result = iceCreamCar.orderCone(flavors.toArray(new Cone.Flavor[]{}));


        assertNotNull(result);

        double profit=Math.round(iceCreamCar.getProfit()*100)/100.00;
    // double profit = iceCreamCar.getProfit();
    // profit = Math.round(profit * 100);
    // profit = profit / 100.00;
        assertEquals(0.5, profit);

    }



    // Tests that orderIceRocket returns null when ice rocket flavors are not specified.
    @Test
    void orderIceRocketShouldReturnNullWhenFlavorsNotSpecified() {
        assertNull(iceCreamCar.orderIceRocket());
    }


    //Tests that orderIceRocket returns an ice rocket and updates profit correctly when flavors are not null and stock is available.
    @Test
    void orderIceRocketShouldReturnProfitableIceRocketWhenFlavorsNotNullAndStockIsAvailable() {

        stock.setIceRockets(3);
        assertEquals(0.0, iceCreamCar.getProfit());

        IceRocket result = iceCreamCar.orderIceRocket();

        assertNotNull(result);

        double profit=Math.round(iceCreamCar.getProfit()*100)/100.00;
    //  double profit = iceCreamCar.getProfit();
    //  profit = Math.round(profit * 100);
    //  profit = profit / 100.00;
        assertEquals(0.4, profit);
    }




    //Tests that orderMagnum returns null when magnum type is specified, but the stock is empty.
    @Test
    void orderMagnumShouldReturnNullWhenStockIsEmpty(){

       // Magnum magnum = iceCreamCar.orderMagnum(Magnum.MagnumType.APLINENUTS);

        assertNull(iceCreamCar.orderMagnum(Magnum.MagnumType.APLINENUTS));
    }


    //Tests that orderMagnum returns a magnum and updates profit correctly when magnum type is not null and stock is available.
    @Test
    void orderMagnumShouldReturnProfitableMagnumWhenTypeNotNullAndStockIsAvailable() {

        stock.setMagni(3);
        assertEquals(0.0, iceCreamCar.getProfit());

        Magnum magnum = iceCreamCar.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);

        assertNotNull(magnum);

        double profit=Math.round(iceCreamCar.getProfit()*100)/100.00;
    //  double profit = iceCreamCar.getProfit();
    //  profit = Math.round(profit * 100);
    //  profit = profit / 100.00;

        // actual profit is 0.01875
        assertEquals(0.02, profit);
    }

    //Tests that getProfit returns the expected profit value when ice rocket is ordered.
    @Test
    void getProfitShouldReturnExpectedProfitWhenIceRocketIsOrdered(){

        stock.setIceRockets(1);

        IceRocket iceRocket = iceCreamCar.orderIceRocket();
        assertNotNull(iceRocket);


        double profit=Math.round(iceCreamCar.getProfit()*100)/100.00;
     // double profit = iceCreamCar.getProfit();
     // profit = Math.round(profit * 100);
     // profit = profit / 100.00;

        assertEquals(0.4, profit);
    }




    //Method to provide parameter values for the test for orderCone
    static Stream<Cone.Flavor> provideSingleFlavorsCone()  {
        return Stream.of(Cone.Flavor.STRAWBERRY, Cone.Flavor.VANILLA);
    }
    // Method to provide parameter values for the test with flavor lists
    static Stream<Arguments> provideFlavorListsCone() {
        return Stream.of(Arguments.arguments(List.of(Cone.Flavor.STRAWBERRY, Cone.Flavor.VANILLA)));
    }

    //Tests that toString returns the expected string representation of the IceCreamCar object.
    @Test
    void toStringShouldReturnExpectedStringRepresentation(){

        IceCreamCar newIceCream = new IceCreamCar(new PriceList(1, 2, 3),
                new Stock());

        String string = newIceCream.toString();

        assertEquals("IceCreamCar{priceList=PriceList{ballPrice=1.0, rocketPrice=2.0, magnumStandardPrice=3.0}, " +
                "stock=Stock{iceRockets=0, cones=0, balls=0, magni=0}, profit=0.0}", string);
    }
}
