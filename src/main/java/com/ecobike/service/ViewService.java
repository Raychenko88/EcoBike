package com.ecobike.service;

import com.ecobike.EcoBikeApplication;
import com.ecobike.model.ElectricBike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.repository.CollectionBike;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class ViewService {


     static {
        FileManagerService.fillCollectionsFromFile(EcoBikeApplication.FILE_NAME);
    }

    public void showAllCatalog() {
        CollectionBike.electricBikes.forEach(it -> System.out.println(it));
        CollectionBike.foldingBikes.forEach(it -> System.out.println(it));
        CollectionBike.speedelecs.forEach(it -> System.out.println(it));

    }

    public static boolean addNewFoldingBike(String optionsBike) {
        String[] subStr;
        String str = optionsBike;
        String delimeter = ";";
        subStr = str.split(delimeter);
        if (subStr[0] == "FOLDING" &&
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
