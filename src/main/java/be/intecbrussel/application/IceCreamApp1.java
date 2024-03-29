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

        while (true) {
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
                    Cone.Flavor[] chosenFlavors = new Cone.Flavor[5];
                    int chosenFlavorsIndex = 0;

                    while (chosenFlavorsIndex<5) {
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
                            break;

                        }
                        Cone.Flavor flavor=Cone.Flavor.getFlavor(chooseFlavour);

                        if (flavor != null) {
                            System.out.println("You choose " + flavor);
                            chosenFlavors[chosenFlavorsIndex++] = flavor;
                        } else {
                            System.out.println("Please choose a correct flavor");
                        }
                    }
     
                    Cone finalOrderdCone = iceCreamSeller.orderCone(chosenFlavors);
                    printAndEat(finalOrderdCone,iceCreamSeller,eatables,eatableIndex);
                    break;
            
                case 2:
                    boolean iceRocketOrder = true;
                    while (iceRocketOrder) {
                        System.out.println("You choose Ice Rocket");
                        IceRocket iceRocket = iceCreamSeller.orderIceRocket();
                        printAndEat(iceRocket,iceCreamSeller,eatables,eatableIndex);

                        System.out.println("Do you want another Ice Rocket? YES or NO");
                        String choose = scanner.nextLine().toUpperCase();

                        if (choose.equals("NO")) {
                            iceRocketOrder = false;
                        }
                    }
                    break;
                    
                case 3:
                    boolean magnumOrder = true;
                    while (magnumOrder) {
                        System.out.println("Which flavor of Magnum do you want (Type EXIT to finish): ");

                        System.out.println("Type Flavor without chocolate: ");
                        String magnumType = scanner.nextLine().toUpperCase();
                        if (magnumType.equals("EXIT")) {
                            magnumOrder = false;
                        } else {
                            Magnum magnum = iceCreamSeller.orderMagnum(Magnum.MagnumType.getMagnumType(magnumType));

                            if (magnum != null) {
                                printAndEat(magnum, iceCreamSeller, eatables, eatableIndex);
                            } else {
                                System.out.println("Please choose a correct flavor");
                            }
                        }
                    }
        
                    break;
                    
                case 4:
                    System.out.print("Do you want another Ice Cream ? Yes or No");
                    String choose = scanner.nextLine().toUpperCase();
                    if (choose.equals("NO")) {
                        return;
                    }
                    break;
                default:
                    System.out.println("Please choose between 1 and 4");
            }
        }
    }

    private static void printAndEat(Eatable eatable, IceCreamSalon iceCreamSeller, Eatable[] eatables, int eatableIndex) {
        if (eatable != null) {
            eatable.eat();
            eatables[eatableIndex++] = eatable;
            System.out.printf("Profit is: %.2f%n", iceCreamSeller.getProfit());
        }
    }
}


