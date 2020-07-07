package com.ecobike.service;

import com.ecobike.EcoBikeApplication;
import com.ecobike.model.DomainObject;
import com.ecobike.model.ElectricBike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.repository.CollectionBike;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class ViewServiceTest {

    private static final String FILE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator") +
            "files" + System.getProperty("file.separator");
    public static final String FILE_NAME = FILE_PATH + "EcoBikeTest.txt";

    static {
        FileManagerService.fillCollectionsFromFile(ViewServiceTest.FILE_NAME);
    }


      static   Set<DomainObject> foldingBikes = Collections.synchronizedSet(new HashSet<>());
     static    Set<DomainObject> electricBikes = Collections.synchronizedSet(new HashSet<>());
      static   Set<DomainObject> speedelecs = Collections.synchronizedSet(new HashSet<>());


    @Test
    void showAllCatalog() {
        assertFalse(CollectionBike.speedelecs.isEmpty());
        assertFalse(CollectionBike.foldingBikes.isEmpty());
        assertFalse(CollectionBike.electricBikes.isEmpty());
    }

    @Test
    void addNewFoldingBike() {
        String bike = "FOLDING BIKE TestBike; 24; 6; 9400; true; silver; 1195";
        String[] subStr;
        String str = bike;
        String delimeter = ";";
        int befor = foldingBikes.size();
        subStr = str.split(delimeter);
        if (subStr[0].startsWith("FOLDING") &&   //startWith
                Integer.parseInt(subStr[1].trim()) > 0 &&
                Integer.parseInt(subStr[2].trim()) > 0 &&
                Integer.parseInt(subStr[3].trim()) > 0 &&
                subStr[4] != null &&
                !(subStr[5].trim()).isEmpty() &&
                Integer.parseInt(subStr[6].trim()) > 0) {
            FoldingBike foldingBike = new FoldingBike();
            foldingBike.setBrand(subStr[0]);
            foldingBike.setWheelSize(Integer.parseInt(subStr[1].trim()));
            foldingBike.setNumberOfSpeeds(Integer.parseInt(subStr[2].trim()));
            foldingBike.setWeight(new BigDecimal(subStr[3].trim()));
            foldingBike.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[4].trim()));
            foldingBike.setColor(subStr[5].trim());
            foldingBike.setPrice(new BigDecimal(subStr[6].trim()));
            foldingBikes.add(foldingBike);

        }
        int after = foldingBikes.size();
        assertTrue(after>befor);
        foldingBikes.removeIf(value -> value.toString().equals(bike));
    }

    @Test
    void addNewSpeedelec() {
        String bike = "SPEEDELEC E-Test; 60; 15300; false; 14800; marine; 309";
        String[] subStr;
        String str = bike;
        int befor = speedelecs.size();
        String delimeter = ";";
        subStr = str.split(delimeter);
        if (subStr[0].startsWith("SPEEDELEC") &&    //startWith
                Integer.parseInt(subStr[1].trim()) > 0 &&
                Integer.parseInt(subStr[2].trim()) > 0 &&
                subStr[3] != null &&
                Integer.parseInt(subStr[4].trim()) > 0 &&
                !(subStr[5].trim()).isEmpty() &&
                Integer.parseInt(subStr[6].trim()) > 0) {
            Speedelec speedelec = new Speedelec();
            speedelec.setBrand(subStr[0]);
            speedelec.setMaximumSpeed(Integer.parseInt(subStr[1].trim()));
            speedelec.setWeight(new BigDecimal(subStr[2].trim()));
            speedelec.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[3].trim()));
            speedelec.setBatteryCapacity(Integer.parseInt(subStr[4].trim()));
            speedelec.setColor(subStr[5].trim());
            speedelec.setPrice(new BigDecimal(subStr[6].trim()));
            speedelecs.add(speedelec);
        }
        int after = speedelecs.size();
        assertTrue(after>befor);
        speedelecs.removeIf(value -> value.toString().equals(bike));
    }

    @Test
    void addNewElectricBike() {
        String bike = "SPEEDELEC E-Test; 60; 15300; false; 14800; marine; 309";
        int befor = electricBikes.size();
        String[] subStr;
        String str = bike;
        String delimeter = ";";
        subStr = str.split(delimeter);
        if (subStr[0].startsWith("SPEEDELEC") &&    //startWith
                Integer.parseInt(subStr[1].trim()) > 0 &&
                Integer.parseInt(subStr[2].trim()) > 0 &&
                subStr[3] != null &&
                Integer.parseInt(subStr[4].trim()) > 0 &&
                !(subStr[5].trim()).isEmpty() &&
                Integer.parseInt(subStr[6].trim()) > 0) {
            ElectricBike electricBike = new ElectricBike();
            electricBike.setBrand(subStr[0]);
            electricBike.setMaximumSpeed(Integer.parseInt(subStr[1].trim()));
            electricBike.setWeight(new BigDecimal(subStr[2].trim()));
            electricBike.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[3].trim()));
            electricBike.setBatteryCapacity(Integer.parseInt(subStr[4].trim()));
            electricBike.setColor(subStr[5].trim());
            electricBike.setPrice(new BigDecimal(subStr[6].trim()));
            electricBikes.add(electricBike);
        }
        int after = electricBikes.size();
        assertTrue(after>befor);
        electricBikes.removeIf(value -> value.toString().equals(bike));
    }

    @Test
    void showFindTheFirstItemOfBrand() {
        TreeSet<DomainObject> treeSet = new TreeSet<>();
        treeSet.addAll(getFilteredeSpeedelecs(CollectionBike.speedelecs, filter));
        treeSet.addAll(getFilteredeElectroBikes(CollectionBike.electricBikes, filter));
        treeSet.addAll(getFilteredeFoldingBike(CollectionBike.foldingBikes, filter));
        CollectionBike.filtered.addAll(treeSet);
    }

    @Test
    void writeToFile() {
    }
}