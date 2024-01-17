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

    @ParameterizedTest
    @MethodSource("returnFlavours")
    void shouldReturnEqualsWhenNoStockOrderCone(Cone.Flavor coneFlavour) {

        // given

        //when
        Cone.Flavor[] flavors = {coneFlavour};
        Cone cone = iceCreamSalon.orderCone(flavors);
        //then
        assertNotNull(cone);

        assertEquals(0, iceCreamSalon.getProfit());
    }

    @Test
    void shouldReturnEqualsWhenPriceListIceCreamSalonAndProfit() {
        //given
        PriceList priceListProfit = new PriceList(1, 2, 4);
        assertNotNull(priceListProfit);
        IceCreamSalon iceCreamSalonProfit = new IceCreamSalon(priceListProfit);
        assertNotNull(iceCreamSalonProfit);

        //when
        Magnum magnum = iceCreamSalonProfit.orderMagnum(Magnum.MagnumType.APLINENUTS);
        assertNotNull(magnum);
        double profit = iceCreamSalonProfit.getProfit();
        //then
        assertEquals(0.06, profit);
    }


    @Test
    void shouldReturnTrueWhenPriceListZeroAndOrderIceRocket() {
        // given

        // when
        IceRocket iceRocket = iceCreamSalon.orderIceRocket();
        // then
        assertNull(iceRocket);
    }

    @Test
    void shouldReturnNotNullWhenPriceListIceCreamSalonAndOrderMagnum() {
        //given
        PriceList priceListProfit = new PriceList(1, 2, 4);
        assertNotNull(priceListProfit);
        IceCreamSalon iceCreamSalonProfit = new IceCreamSalon(priceListProfit);
        assertNotNull(iceCreamSalonProfit);

        //when
        Magnum magnum = iceCreamSalonProfit.orderMagnum(Magnum.MagnumType.APLINENUTS);
        assertNotNull(magnum);


    }

    static Stream<Cone.Flavor> returnFlavours() {
        return Stream.of(
                Cone.Flavor.BANANA, Cone.Flavor.LEMON);
    }

    @Test
    void souldReturnEqualsWhengetProfit() {

        //given
        PriceList priceListProfit = new PriceList(1, 2, 4);
        IceCreamSalon iceCreamSalonProfit = new IceCreamSalon(priceListProfit);
        IceRocket iceRocket = iceCreamSalonProfit.orderIceRocket();

        //when

        //then
        assertEquals(0.4, iceCreamSalonProfit.getProfit());
    }

    @Test
    void shouldReturnEqualWhenToString() {

        //given

        //when
        String string = iceCreamSalon.toString();
        //then
        assertEquals("IceCreamSalon{priceList=PriceList{ballPrice=0.0, " +
                "rocketPrice=0.0, magnumStandardPrice=0.0}, totalProfit=0.0}", string);
    }

}
