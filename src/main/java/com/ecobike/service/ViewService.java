package com.ecobike.service;

import com.ecobike.EcoBikeApplication;
import com.ecobike.model.DomainObject;
import com.ecobike.model.ElectricBike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.repository.CollectionBike;
import lombok.EqualsAndHashCode;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode
public class ViewService {


    static {
        FileManagerService.fillCollectionsFromFile(EcoBikeApplication.FILE_NAME);
    }

    public static void showAllCatalog() {
        CollectionBike.electricBikes.forEach(it -> System.out.println(it));
        CollectionBike.foldingBikes.forEach(it -> System.out.println(it));
        CollectionBike.speedelecs.forEach(it -> System.out.println(it));

    }

    public static boolean addNewFoldingBike(String optionsBike) {
        String[] subStr;
        String str = optionsBike;
        String delimeter = ";";
        subStr = str.split(delimeter);
        if (subStr[0].startsWith("FOLDING") &&   //startWith
                Integer.parseInt(subStr[1]) > 0 &&
                Integer.parseInt(subStr[2]) > 0 &&
                Integer.parseInt(subStr[3]) > 0 &&
                Boolean.parseBoolean(subStr[4]) == true || false &&
                !(subStr[5]).isEmpty() &&
                Integer.parseInt(subStr[6]) > 0) {
            FoldingBike foldingBike = new FoldingBike();
            foldingBike.setBrand(subStr[0]);
            foldingBike.setWheelSize(Integer.parseInt(subStr[1].trim()));
            foldingBike.setNumberOfSpeeds(Integer.parseInt(subStr[2].trim()));
            foldingBike.setWeight(Integer.parseInt(subStr[3].trim()));
            foldingBike.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[4].trim()));
            foldingBike.setColor(subStr[5].trim());
            foldingBike.setPrice(Integer.parseInt(subStr[6].trim()));
            CollectionBike.foldingBikes.add(foldingBike);
            return true;
        }
        return false;
    }

    public static boolean addNewSpeedelec(String optionsBike) {
        String[] subStr;
        String str = optionsBike;
        String delimeter = ";";
        subStr = str.split(delimeter);
        if (subStr[0].startsWith("SPEEDELEC") &&    //startWith
                Integer.parseInt(subStr[1]) > 0 &&
                Integer.parseInt(subStr[2]) > 0 &&
                Boolean.parseBoolean(subStr[3]) == true || false &&
                Integer.parseInt(subStr[4]) > 0 &&
                !(subStr[5]).isEmpty() &&
                Integer.parseInt(subStr[6]) > 0) {
            Speedelec speedelec = new Speedelec();
            speedelec.setBrand(subStr[0]);
            speedelec.setMaximumSpeed(Integer.parseInt(subStr[1].trim()));
            speedelec.setWeight(Integer.parseInt(subStr[2].trim()));
            speedelec.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[3].trim()));
            speedelec.setBatteryCapacity(Integer.parseInt(subStr[4].trim()));
            speedelec.setColor(subStr[5].trim());
            speedelec.setPrice(Integer.parseInt(subStr[6].trim()));
            CollectionBike.speedelecs.add(speedelec);
            return true;
        }
        return false;
    }

    public static boolean addNewElectricBike(String optionsBike) {
        String[] subStr;
        String str = optionsBike;
        String delimeter = ";";
        subStr = str.split(delimeter);
        if (subStr[0].startsWith("SPEEDELEC") &&    //startWith
                Integer.parseInt(subStr[1]) > 0 &&
                Integer.parseInt(subStr[2]) > 0 &&
                Boolean.parseBoolean(subStr[3]) == true || false &&
                Integer.parseInt(subStr[4]) > 0 &&
                !(subStr[5]).isEmpty() &&
                Integer.parseInt(subStr[6]) > 0) {
            ElectricBike electricBike = new ElectricBike();
            electricBike.setBrand(subStr[0]);
            electricBike.setMaximumSpeed(Integer.parseInt(subStr[1].trim()));
            electricBike.setWeight(Integer.parseInt(subStr[2].trim()));
            electricBike.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[3].trim()));
            electricBike.setBatteryCapacity(Integer.parseInt(subStr[4].trim()));
            electricBike.setColor(subStr[5].trim());
            electricBike.setPrice(Integer.parseInt(subStr[6].trim()));
            CollectionBike.speedelecs.add(electricBike);
            return true;
        }
        return false;
    }

    public static Set<DomainObject> showFindTheFirstItemOfBrand(Map<String,String> filter) {
        filter.put("brand", "SPEEDELEC")
        TreeSet<DomainObject> treeSet = new TreeSet<>();
        treeSet.addAll(CollectionBike.speedelecs);
        treeSet.addAll(CollectionBike.electricBikes);
        treeSet.addAll(CollectionBike.foldingBikes);
        Map<String, String> map = new HashMap<>();
        String toFilter = optionsBike.trim();
//        Map<String, String> map = new HashMap<>();
        if (toFilter.startsWith("SPEEDELEC")){
           for (DomainObject bike : treeSet){
//               if ()
           }

        }
        return null;
    }


    public static boolean writeToFile() {
        if (FileManagerService.checkPathAndFile(EcoBikeApplication.FILE_NAME)){
            if (FileManagerService.writeFile(EcoBikeApplication.FILE_NAME)){
                return true;
            }
        }
        return false;
    }

    public static void stopTheProgram() {

    }

    public static List<Object> checkAdd(String str) {

        return null;
    }
}
