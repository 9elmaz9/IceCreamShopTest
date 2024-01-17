package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.seller.IceCreamSalon;
import be.intecbrussel.seller.PriceList;

import java.util.Scanner;

public class IceCreamApp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isOrdering = true;

        PriceList priceList = new PriceList(1, 3, 4);

        IceCreamSalon iceCreamSeller = new IceCreamSalon(priceList);


        Eatable[] eatables = new Eatable[3];
        int eatableIndex = 0;

        while (isOrdering) {
            System.out.println("""
                    Which ice Cream do you want :
                    Press 1 for Cone Ice Cream
                    Press 2 for Ice Rocket
                    Press 3 for Magnum Ice Cream
                    Press 4 for exit""");
            System.out.print("Please enter a number between 1 and 4: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1:
                    Cone.Flavor[] chosenFlavors = new Cone.Flavor[]{null, null, null, null, null};
                    int chosenFlavorsIndex = 0;
                    boolean orderFlavour = true;
                    while (orderFlavour) {
                        System.out.println("You ordered Cone Ice Cream");
                        System.out.println("""
                                Which flavor do you want :
                                    Strawberry
                                    Banana
                                    Chocolate
                                    Vanilla
                                    Lemon
                                    Straciatella
                                    Mokka
                                    Pistache
                                    Exit""");
                        System.out.print("Enter your flavor: ");
                        String chooseFlavour = scanner.nextLine().toUpperCase();
                        if (!chooseFlavour.equals("EXIT")) {
                            for (Cone.Flavor value : Cone.Flavor.values()) {
                                if (value.toString().equals(chooseFlavour)) {
                                    System.out.println("You choose " + value);
                                    if (chosenFlavorsIndex >= chosenFlavors.length) {
                                        System.out.println("You cannot add maximum bolls");
                                        break;
                                    } else {
                                        chosenFlavors[chosenFlavorsIndex++] = value;
                                        break;
                                    }
                                }
                            }
                        } else {
                            orderFlavour = false;
                        }
                        if (chosenFlavorsIndex == 5) {
                            orderFlavour = false;
                        }
                    }
                    Cone finalOrderdCone = iceCreamSeller.orderCone(chosenFlavors);
                    System.out.printf("Profit is : %.2f ", iceCreamSeller.getProfit());
                    finalOrderdCone.eat();
                    eatables[eatableIndex++] = finalOrderdCone;
                    break;
                case 2:
                    boolean iceRocketOrder = true;
                    while (iceRocketOrder) {
                        System.out.println("You choose Ice Rocket");
                        IceRocket iceRocket = iceCreamSeller.orderIceRocket();
                        System.out.printf("Profit is : %.2f ", iceCreamSeller.getProfit());
                        iceRocket.eat();
                        eatables[eatableIndex++] = iceRocket;
                        System.out.println("Do you what to another Ice Rocket ? YES or NO");
                        String choose = scanner.nextLine().toUpperCase();
                        if (choose.equals("NO")) {
                            iceRocketOrder = false;
                        }
                    }
                    break;
                case 3:
                    boolean magnumOrder = true;
                    while (magnumOrder) {
                        System.out.println("""
                                Which flavor of Magnum do you want :
                                    Milk Chocolate
                                    White Chocolate
                                    Black Chocolate
                                    Alpine Nuts
                                    Romantics Strawberries
                                    Exit""");
                        System.out.println("Type Flavor without chocolate: ");
                        String magnumType = scanner.nextLine().toUpperCase();
                        Magnum magnum = null;
                        switch (magnumType) {
                            case "EXIT":
                                magnumOrder = false;
                                break;
                            case "MILK":
                                magnum = iceCreamSeller.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);
                                break;
                            case "WHITE":
                                magnum = iceCreamSeller.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);
                                break;
                            case "BLACK":
                                magnum = iceCreamSeller.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
                                break;
                            case "ALPINE":
                                magnum = iceCreamSeller.orderMagnum(Magnum.MagnumType.APLINENUTS);
                                break;
                            case "ROMANTICS":
                                magnum = iceCreamSeller.orderMagnum(Magnum.MagnumType.ROMANTICSTRAWBERRIES);
                                break;
                            default: {
                                System.out.println("Please choose a correct flavor");
                                continue;
                            }
                        }

                        if (!magnumOrder) {
                            break;
                        }
                        eatables[eatableIndex++] = magnum;
                        magnum.eat(); // null pointer exception
                    }
                    break;
                case 4:
                    System.out.print("Do you want another Ice Cream ? Yes or No");
                    String choose = scanner.nextLine().toUpperCase();
                    if (choose.equals("NO")) {
                        isOrdering = false;
                    }
                    break;
                default:
                    System.out.println("Please choose between 1 and 4");
            }
            System.out.printf("Profit is : %.2f ", iceCreamSeller.getProfit());
        }
    }


}

