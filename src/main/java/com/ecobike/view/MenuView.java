package com.ecobike.view;

import com.ecobike.service.ViewService;
import lombok.EqualsAndHashCode;

import java.util.Scanner;

@EqualsAndHashCode
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
        System.out.println("To exit the program, enter - off");
        while (scanner.hasNextLine()) {
            String intChoice = scanner.nextLine();
            System.out.println("Enter the number of the menu item");
            if (intChoice.equals("2") || intChoice.equals("3") || intChoice.equals("4")) {
                if (checkChoice(intChoice)) {
                    System.out.println("Press enter to get to the menu.");
                    scanner.next();
                    mainMenu();
                } else if (!(checkChoice(intChoice))) {
                    System.out.println("You entered incorrect data. Enter the menu number again, and then enter the data");
                    mainMenu();
                }
            } else if (intChoice.equals("off")) {
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
            ViewService.showCatalog();
            return true;
        } else if (choice.equals("2")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the data as shown in the example below");
            System.out.println("FOLDING BIKE Benetti; 24; 27; 11400; false; rose; 1009");
            System.out.println("Where: FOLDING BIKE Benetti - is the name of the product and brand; 24 this is wheel size; 27 this is number of speeds;" + "\n" +
                    "11400 this is weight gear (s); true or false - depending on the availability of lights; rose - this is color; 1009 - price ");
            String optionsBike = scanner.nextLine();
            if (ViewService.AddNewFoldingBike(optionsBike)) {
                System.out.println("add item to FoldingBike");
                scanner.close();
                return true;
            } else {
                scanner.close();
                return false;
            }

        } else if (choice.equals("3")) {

        } else if (choice.equals("4")) {

        } else if (choice.equals("5")) {

        } else if (choice.equals("6")) {

        } else if (choice.equals("7")) {

        }
        // тут должна быть рекурсия на этот же метод
        return false;
    }


}
