package be.intecbrussel;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.seller.IceCreamSalon;
import be.intecbrussel.seller.PriceList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IceCreamSalonTest {

    IceCreamSalon iceCreamSalon;
    PriceList priceList;

    @BeforeEach
    void setup() {
        priceList = new PriceList(0, 0, 0);
        iceCreamSalon = new IceCreamSalon(priceList);
    }

    //for ordering a Cone with different flavors
    @ParameterizedTest
    @MethodSource("returnFlavours")
    void orderConeShouldReturnNotNullAndProfitZero(Cone.Flavor coneFlavour) {

        //with a single flavor and ordering a cone
        Cone.Flavor[] flavors = {coneFlavour};
        Cone cone = iceCreamSalon.orderCone(flavors);
        //cone should not be null, and the profit should be zero
        assertNotNull(cone);

        assertEquals(0, iceCreamSalon.getProfit());
    }


    //ordering a magnum and updating profit
    @Test
    void orderMagnumShouldReturnNotNullAndUpdateProfit() {
        //non zero prises
        PriceList priceListProfit = new PriceList(1, 2, 4);
        IceCreamSalon iceCreamSalonProfit = new IceCreamSalon(priceListProfit);
        //assertNotNull(iceCreamSalonProfit);

        Magnum magnum = iceCreamSalonProfit.orderMagnum(Magnum.MagnumType.APLINENUTS);

        assertNotNull(magnum);
        // double profit = iceCreamSalonProfit.getProfit();
        //then
        assertEquals(0.06, iceCreamSalonProfit.getProfit());
    }


    // ordering IceRocket,return à when prise is 0
    @Test
    void orderIceRocketShouldReturnNull() {

        IceRocket iceRocket = iceCreamSalon.orderIceRocket();
        //  should be = 0
        assertNull(iceRocket);
    }


    //?

    @Test
    void magnumOrderShouldNotReturnNullWithPriceList(){
        //given
        PriceList priceListProfit = new PriceList(1, 2, 4);
       // assertNotNull(priceListProfit);
        IceCreamSalon iceCreamSalonProfit = new IceCreamSalon(priceListProfit);
        //assertNotNull(iceCreamSalonProfit);

        //when
        Magnum magnum = iceCreamSalonProfit.orderMagnum(Magnum.MagnumType.APLINENUTS);

        assertNotNull(magnum);


    }

 //  //?
 //   static Stream<Cone.Flavor> returnFlavours() {
 //      return Stream.of(
 //              Cone.Flavor.BANANA, Cone.Flavor.LEMON);
 //  }


    //check profit calc after ordering an IceRocket
    @Test
    void getProfitShouldReturnZero() {

        //non zero prices
        PriceList priceListProfit = new PriceList(1, 2, 4);
        IceCreamSalon iceCreamSalonProfit = new IceCreamSalon(priceListProfit);


        IceRocket iceRocket = iceCreamSalonProfit.orderIceRocket();


        // should be updated correctly
        assertEquals(0.4, iceCreamSalonProfit.getProfit());
    }


    //check the toString()
    @Test
    void toStringShouldReturnExpectedString() {

        //getting the string representation of the IceCreamSalon

        String expectedString = "IceCreamSalon{priceList=PriceList{ballPrice=0.0, " +
                "rocketPrice=0.0, magnumStandardPrice=0.0}, totalProfit=0.0}";
        // String string = iceCreamSalon.toString();

        //assertion ,  the to string result should be match the expected string

        // assertEquals("IceCreamSalon{priceList=PriceList{ballPrice=0.0, " +
        //         "rocketPrice=0.0, magnumStandardPrice=0.0}, totalProfit=0.0}", string);

        assertEquals(expectedString, iceCreamSalon.toString());
    }

    //helper method providing different Cone flavors for parameterized tests
      static Stream<Cone.Flavor> returnFlavours() {
        return Stream.of(Cone.Flavor.BANANA, Cone.Flavor.LEMON);
    }

}


