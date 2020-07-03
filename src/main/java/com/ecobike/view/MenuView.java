package com.ecobike.view;

import com.ecobike.EcoBikeApplication;
import com.ecobike.model.DomainObject;
import com.ecobike.model.FilterName;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.repository.CollectionBike;
import com.ecobike.service.ViewService;

import java.util.*;


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
            System.out.println("Enter the number of the menu item");
            String intChoice = scanner.nextLine();
            if (intChoice.equals("1")) {
                if (checkChoice(intChoice)) {
                    System.out.println("Press enter to get to the menu.");
                    scanner.next();
                } else {
                    System.out.println("Unable to show directory");
                }
                mainMenu();
            } else if (intChoice.equals("2") || intChoice.equals("3") || intChoice.equals("4")) {
                if (checkChoice(intChoice)) {
                    System.out.println("Press enter to get to the menu.");
                    scanner.next();
                    mainMenu();
                } else if (!(checkChoice(intChoice))) {
                    System.out.println("Failed to save this bike. Make sure you enter the correct data" + "\n" +
                            "Enter the menu number again and then enter the data");
                    scanner.next();
                    mainMenu();
                }
            } else if (intChoice.equals("5")) {
                if (checkChoice(intChoice)) {
                    System.out.println("Press enter to get to the menu.");
                    scanner.next();
                    mainMenu();
                } else {
                    System.out.println("\n" +
                            "No results were found for your request. Make sure the fields are filled in correctly." + "\n" +
                            "Enter the menu number again and then enter the data");
                    scanner.next();
                    mainMenu();
                }

            } else if (intChoice.equals("6")) {
                if (checkChoice(intChoice)) {
                    System.out.println("Press enter to get to the menu.");
                    scanner.next();
                    mainMenu();
                } else {
                    System.out.println("Unfortunately, it was not possible to save the data to a file." +
                            "Enter the menu number again and then enter the data");
                    scanner.next();
                    mainMenu();
                }

            } else if (intChoice.equals("7")) {
                scanner.close();
                System.out.println("You have left the program");
                break;
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
            Scanner scanner = new Scanner(System.in);
            viewOptionsForBike();
            String optionsForBike = scanner.nextLine();
            if (!(optionsForBike.isEmpty())) {
                HashMap<FilterName, String> hashMap = fillMapFilter(optionsForBike);
                if (hashMap.size() > 0) {
                    TreeSet<DomainObject> treeSet = ViewService.showFindTheFirstItemOfBrand(fillMapFilter(optionsForBike));
                    if (treeSet.size() != 0) {
                        System.out.println("The first item of a particular brand - " +
                                treeSet.first());
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
            scanner.close();
            return true;
        } else if (choice.equals("6")) {
            Set<DomainObject> set = new HashSet<>();
            set.addAll(CollectionBike.foldingBikes);
            set.addAll(CollectionBike.electricBikes);
            set.addAll(CollectionBike.speedelecs);
            if (ViewService.writeToFile(EcoBikeApplication.FILE_NAME, set)) {
                System.out.println("All changes are added to the file.");
            } else {
                return false;
            }

        }
        // тут должна быть рекурсия на этот же метод
        return false;
    }

    private static HashMap<FilterName, String> fillMapFilter(String string) {
        String DELIMETER = ";";
        String[] subStr = string.split(DELIMETER);
        HashMap<FilterName, String> filterNameHashMap = new HashMap<>();
        if (string.startsWith("SPEEDELEC")) {
            filterNameHashMap.put(FilterName.BRAND, subStr[0]);
            filterNameHashMap.put(FilterName.MAXIMUM_SPEED, subStr[1].trim());
            filterNameHashMap.put(FilterName.WEIGHT, subStr[2].trim());
            filterNameHashMap.put(FilterName.LIGHTS, subStr[3].trim());
            filterNameHashMap.put(FilterName.BATTERY, subStr[4].trim());
            filterNameHashMap.put(FilterName.COLOR, subStr[5].trim());
            filterNameHashMap.put(FilterName.PRICE, subStr[6].trim());
        } else if (string.startsWith("E-BIKE")) {
            filterNameHashMap.put(FilterName.BRAND, subStr[0]);
            filterNameHashMap.put(FilterName.MAXIMUM_SPEED, subStr[1].trim());
            filterNameHashMap.put(FilterName.WEIGHT, subStr[2].trim());
            filterNameHashMap.put(FilterName.LIGHTS, subStr[3].trim());
            filterNameHashMap.put(FilterName.BATTERY, subStr[4].trim());
            filterNameHashMap.put(FilterName.COLOR, subStr[5].trim());
            filterNameHashMap.put(FilterName.PRICE, subStr[6].trim());
        } else if (string.startsWith("FOLDING BIKE")) {
            filterNameHashMap.put(FilterName.BRAND, subStr[0]);
            filterNameHashMap.put(FilterName.WHEEL_SIZE, subStr[1].trim());
            filterNameHashMap.put(FilterName.NUMBER_SPEEDS, subStr[2].trim());
            filterNameHashMap.put(FilterName.WEIGHT, subStr[3].trim());
            filterNameHashMap.put(FilterName.LIGHTS, subStr[4].trim());
            filterNameHashMap.put(FilterName.COLOR, subStr[5].trim());
            filterNameHashMap.put(FilterName.PRICE, subStr[6].trim());
        }
        return filterNameHashMap;
    }

    private static void viewNewСonditionToFoldingBike() {
        System.out.println("Enter the data as shown in the example below, after each parameter you need to set ;");
        System.out.println("FOLDING BIKE Benetti; 24; 27; 11400; false; rose; 1009");
        System.out.println("Where: FOLDING BIKE Benetti - A brand; 24 - The size of the wheels (in inch); 27 - The number of gears" + "\n" +
                "11400 - The weight of the bike (in grams); true or false - The availability of lights at front and back; rose - A color; 1009 - The price");
    }

    private static void viewNewСonditionToSpeedelecBike() {
        System.out.println("Enter the data as shown in the example below, after each parameter you need to set ;");
        System.out.println("SPEEDELEC Peugeot; 45; 5426; TRUE; 8000; blue; 875");
        System.out.println("Where: SPEEDELEC Peugeot - is the name of the product and brand; 45 - The maximum speed (in km/h); 5426 - The weight of the bike (in grams); " +
                "true or false - The availability of lights at front and back; 8000 - The battery capacity (in mAh); blue - A color; 875 - The price.");
    }

    private static void viewNewConditionElectricBike() {
        System.out.println("Enter the data as shown in the example below, after each parameter you need to set ;");
        System.out.println("E-BIKE Gazelle; 49; 16455; TRUE; 16000; red; 1499");
        System.out.println("Where: E-BIKE Gazelle - is the name of the product and brand; 49 - The maximum speed (in km/h); 16455 - The weight of the bike (in grams); " +
                "true or false - The availability of lights at front and back; 16000 - The battery capacity (in mAh); red - A color; 1499 - The price.");
    }

    private static void viewOptionsForBike() {
        System.out.println("Enter the data as shown in the example below, after each parameter you need to set ;");
        System.out.println("If the parameter is not known, put a space instead.");
        System.out.println("The required input parameter is to indicate the type of bike and its brand." + "\n");
        System.out.println("E-BIKE Gazelle; 49; 16455; TRUE; 16000; red; 1499");
        System.out.println("Where: E-BIKE Gazelle - is the name of the product and brand; 49 - The maximum speed (in km/h); 16455 - The weight of the bike (in grams); " +
                "true or false - The availability of lights at front and back; 16000 - The battery capacity (in mAh); red - A color; 1499 - The price." + "\n");
        System.out.println("SPEEDELEC Peugeot; 45; 5426; TRUE; 8000; blue; 875");
        System.out.println("Where: SPEEDELEC Peugeot - is the name of the product and brand; 45 - The maximum speed (in km/h); 5426 - The weight of the bike (in grams); " +
                "true or false - The availability of lights at front and back; 8000 - The battery capacity (in mAh); blue - A color; 875 - The price." + "\n");
        System.out.println("SPEEDELEC Peugeot; 45; 5426; TRUE; 8000; blue; 875");
        System.out.println("Where: SPEEDELEC Peugeot - is the name of the product and brand; 45 - The maximum speed (in km/h); 5426 - The weight of the bike (in grams); " +
                "true or false - The availability of lights at front and back; 8000 - The battery capacity (in mAh); blue - A color; 875 - The price." + "\n");
    }

}
