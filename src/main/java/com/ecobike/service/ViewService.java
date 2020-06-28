package com.ecobike.service;

import com.ecobike.model.ElectricBike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.repository.CollectionBike;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class ViewService {

    private static String fileName = "EcoBike.txt";

    public static void addAllCollectionsThread(){
        FileManagerService fileManagerService = new FileManagerService();
        fileManagerService.start();
    }

    public static void showCatalog() {
        int iteratorS = 0;
        int iteratorF = 0;
        int iteratorE = 0;
//    if (brandNameBike.equals("E-BIKE")){
//        for (ElectricBike e: CollectionBike.electricBikes) {
//            String light = e.lightsAtFrontAndBack ? "head/tail light." : "no head/tail light.";
//            System.out.println(e.getBrand() + " with " + e.getBatteryCapacity() + " mAh battery and " + light);
//            System.out.println("Price: " + e.getPrice() + " euros.");
//        }
//    }else if (brandNameBike.equals("FOLDING BIKE")){
//        for (FoldingBike f : CollectionBike.foldingBikes){
//            String light = f.lightsAtFrontAndBack ? "head/tail light." : "no head/tail light.";
//            System.out.println(f.getBrand() + " with " + f.numberOfSpeeds + " gear(s) and " + light);
//            System.out.println("Price: " + f.getPrice() + " euros.");
//        }
//    }else if (brandNameBike.equals("SPEEDELEC")){
//        for (Speedelec s : CollectionBike.speedelecs){
//            String light = s.lightsAtFrontAndBack ? "head/tail light." : "no head/tail light.";
//            System.out.println(s.getBrand() + " with " + s.getBatteryCapacity() + " mAh battery and " + light);
//            System.out.println("Price: " + s.getPrice() + " euros.");
//        }
//    }
        addAllCollectionsThread();
        List<Object> list = FileManagerService.getDataFromFile(fileName);
        List<Speedelec> s = new ArrayList<>(CollectionBike.speedelecs);
        List<ElectricBike> e = new ArrayList<>(CollectionBike.electricBikes);
        List<FoldingBike> f = new ArrayList<>(CollectionBike.foldingBikes);
        for (int i = 0; i < list.size(); i++) {
            String[] subStr;
            String str = list.get(i).toString();
            String delimeter = ";";
            if (str.startsWith("SPEEDELEC")) {
                if (iteratorS < s.size()) {
                    String light = s.get(iteratorS).lightsAtFrontAndBack ? "head/tail light." : "no head/tail light.";
                    System.out.println(s.get(iteratorS).getBrand() + " with " + s.get(iteratorS).getBatteryCapacity() + " mAh battery and " + light);
            System.out.println("Price: " + s.get(iteratorS).getPrice() + " euros.");
                    iteratorS++;
                }
            } else if (str.startsWith("E-BIKE")) {
                if (iteratorS < e.size()) {
                    String light = e.get(iteratorE).lightsAtFrontAndBack ? "head/tail light." : "no head/tail light.";
                    System.out.println(e.get(iteratorE).getBrand() + " with " + e.get(iteratorE).getBatteryCapacity() + " mAh battery and " + light);
                    System.out.println("Price: " + e.get(iteratorE).getPrice() + " euros.");
                    iteratorE++;
                }
            } else if (str.startsWith("FOLDING BIKE")) {
                if (iteratorS < f.size()) {
                    String light = f.get(iteratorF).lightsAtFrontAndBack ? "head/tail light." : "no head/tail light.";
                    System.out.println(f.get(iteratorF).getBrand() + " with " + f.get(iteratorF).numberOfSpeeds + " gear(s) and " + light);
                    System.out.println("Price: " + f.get(iteratorF).getPrice() + " euros.");
                    iteratorF++;
                }
            }
        }
    }

    public static void AddNewFoldingBike(String optopnsBike) {

    }

    public static void AddNewSpeedelec() {

    }

    public static void AddNewElectricBike() {

    }

    public static void findTheFirstItemOfBrand(List<String> optionsBike) {
        for (String str : optionsBike) {

        }
    }

    public static void writeToFile() {

    }

    public static void stopTheProgram() {

    }

    public static List<Object> checkAdd(String str) {

        return null;
    }
}
