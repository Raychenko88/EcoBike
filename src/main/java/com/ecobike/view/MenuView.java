package com.ecobike.view;

import com.ecobike.service.ViewService;

import java.util.Scanner;


public class MenuView {
    static Scanner scanner = new Scanner(System.in);

    private static String showChoice = "Please make your choice:\n" +
            "1 - Show the entire EcoBike catalog\n" +
            "2 – Add a new folding bike\n" +
            "3 – Add a new speedelec\n" +
            "4 – Add a new e-bike\n" +
            "5 – Find the first item of a particular brand\n" +
            "6 – Write to file\n" +
            "7 – Stop the program";

    public static void mainMenu() {
        System.out.println(showChoice);
        while (scanner.hasNextLine()) {
            String intChoice = scanner.nextLine();
            System.out.println("Enter the number of the menu item");
            if (intChoice.equals("1")){
                if (checkChoice(intChoice)){
                    System.out.println("Press enter to get to the menu.");
                    scanner.next();
                }else {
                    System.out.println("Unable to show directory");
                }
                mainMenu();
            }
            else if (intChoice.equals("2") || intChoice.equals("3") || intChoice.equals("4")) {
                if (checkChoice(intChoice)) {
                    System.out.println("Press enter to get to the menu.");
                    scanner.next();
                    mainMenu();
                } else if (!(checkChoice(intChoice))) {
                    System.out.println("You entered incorrect data. Enter the menu number again, and then enter the data");
                    mainMenu();
                }
            }else if (intChoice.equals("5")){

            }

            else if (intChoice.equals("7")) {
                scanner.close();
                System.out.println("You have left the program");
                break;
            } else {
                System.out.println("Please enter the number of the menu item again");
                mainMenu();
            }
        }

    }

    private static boolean checkChoice(String choice) {
        if (choice.equals("1")) {
            ViewService.showAllCatalog();
            return true;
        } else if (choice.equals("2")) {
            Scanner scanner = new Scanner(System.in);
            viewNewСonditionToFoldingBike();
            String optionsBike = scanner.nextLine();
            if (ViewService.addNewFoldingBike(optionsBike)) {
                System.out.println("add item to FoldingBike");
                scanner.close();
                return true;
            } else {
                scanner.close();
                return false;
            }

        } else if (choice.equals("3")) {
            Scanner scanner = new Scanner(System.in);
            viewNewСonditionToSpeedelecBike();
            String optionsBike = scanner.nextLine();
            if (ViewService.addNewSpeedelec(optionsBike)) {
                System.out.println("add item to SpeedelecBike");
                scanner.close();
                return true;
            } else {
                scanner.close();
                return false;
            }

        } else if (choice.equals("4")) {
            Scanner scanner = new Scanner(System.in);
            viewNewConditionElectricBike();
            String optionsBike = scanner.nextLine();
            if (ViewService.addNewElectricBike(optionsBike)) {
                System.out.println("add item to ElectroBike");
                scanner.close();
                return true;
            } else {
                scanner.close();
                return false;
            }

        } else if (choice.equals("5")) {


        } else if (choice.equals("6")) {

        } else if (choice.equals("7")) {

        }
        // тут должна быть рекурсия на этот же метод
        return false;
    }

    private static void viewNewСonditionToFoldingBike() {
        System.out.println("Enter the data as shown in the example below");
        System.out.println("FOLDING BIKE Benetti; 24; 27; 11400; false; rose; 1009");
        System.out.println("Where: FOLDING BIKE Benetti - A brand; 24 - The size of the wheels (in inch); 27 - The number of gears" + "\n" +
                "11400 - The weight of the bike (in grams); true or false - The availability of lights at front and back; rose - A color; 1009 - The price");
    }


    private static void viewNewСonditionToSpeedelecBike(){
        System.out.println("Enter the data as shown in the example below");
        System.out.println("SPEEDELEC Peugeot; 45; 5426; TRUE; 8000; blue; 875");
        System.out.println("Where: SPEEDELEC Peugeot - is the name of the product and brand; 45 - The maximum speed (in km/h); 5426 - The weight of the bike (in grams); " +
                "true or false - The availability of lights at front and back; 8000 - The battery capacity (in mAh); blue - A color; 875 - The price ");
    }


    private static void viewNewConditionElectricBike(){
        System.out.println("Enter the data as shown in the example below");
        System.out.println("E-BIKE Gazelle; 49; 16455; TRUE; 16000; red; 1499");
        System.out.println("Where: E-BIKE Gazelle - is the name of the product and brand; 49 - The maximum speed (in km/h); 16455 - The weight of the bike (in grams); " +
                "true or false - The availability of lights at front and back; 16000 - The battery capacity (in mAh); red - A color; 1499 - The price ");
    }

}
