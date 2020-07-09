package com.ecobike.service;

import com.ecobike.EcoBikeApplication;
import com.ecobike.model.*;
import com.ecobike.repository.CollectionBike;
import com.ecobike.view.MenuView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ViewServiceTest {

    private static final String FILE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator") +
            "files" + System.getProperty("file.separator");
    public static final String FILE_NAME = FILE_PATH + "EcoBikeTest.txt";

//    static {
//        FileManagerService.fillCollectionsFromFile(EcoBikeApplication.FILE_NAME);
//    }


    static Set<DomainObject> foldingBikes = Collections.synchronizedSet(new HashSet<>());
    static Set<DomainObject> electricBikes = Collections.synchronizedSet(new HashSet<>());
    static Set<DomainObject> speedelecs = Collections.synchronizedSet(new HashSet<>());


    @Test
    void showAllCatalog() {
        FileManagerService.fillCollectionsFromFile(EcoBikeApplication.FILE_NAME);
        assertFalse(CollectionBike.speedelecs.isEmpty());
        assertFalse(CollectionBike.foldingBikes.isEmpty());
        assertFalse(CollectionBike.electricBikes.isEmpty());
    }

    @Test
    void addNewFoldingBike() {
        String bikeOptions = "FOLDING BIKE TestBike; 24; 6; 9400; true; silver; 1195";
        assertTrue(ViewService.addNewFoldingBike(bikeOptions));
//        FileManagerService.addToCollectionFoldingBike(bikeOptions);
        FoldingBike test = null;
        for (DomainObject bike : CollectionBike.foldingBikes) {
            if (bike.getBrand().equals("FOLDING BIKE TestBike")) {
                test = (FoldingBike) bike;
            }
        }
        assertNotNull(test);
        assertEquals(test.getPrice(), new BigDecimal(1195));
        assertEquals(test.getBrand(), "FOLDING BIKE TestBike");
        CollectionBike.foldingBikes.removeIf(value -> value.getBrand().equals("FOLDING BIKE TestBike"));
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
        assertTrue(after > befor);
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
        assertTrue(after > befor);
        electricBikes.removeIf(value -> value.getBrand().equals("SPEEDELEC E-Test"));
    }

    @Test
    void showFindTheFirstItemOfBrand() {
        HashMap<FilterName, String> filterNameHashMap = new HashMap<>();
        filterNameHashMap.put(FilterName.BRAND, "SPEEDELEC E-Scooter");
        filterNameHashMap.put(FilterName.LIGHTS, "false");
        filterNameHashMap.put(FilterName.COLOR, "marine");
        filterNameHashMap.put(FilterName.PRICE, "309");

        TreeSet<DomainObject> treeSet = ViewService.showFindTheFirstItemOfBrand(filterNameHashMap);
        assertFalse(treeSet.isEmpty());
        assertEquals(treeSet.first().getPrice().toString(), "309");
        assertEquals(treeSet.first().getBrand(), "SPEEDELEC E-Scooter");
        assertEquals(treeSet.first().getLightsAtFrontAndBack(), false);
        assertEquals(treeSet.first().getColor(), "marine");
    }

    @Test
    void writeToFile() {
        String optionsNewTestBike = "SPEEDELEC TestBike; 55; 5555; true; 55555; red; 555";
        Speedelec speedelec = new Speedelec();
        speedelec.setBrand("SPEEDELEC TestBike");
        speedelec.setMaximumSpeed(55);
        speedelec.setWeight(new BigDecimal(5555));
        speedelec.setLightsAtFrontAndBack(true);
        speedelec.setBatteryCapacity(55555);
        speedelec.setColor("red");
        speedelec.setPrice(new BigDecimal(555));

        Set<DomainObject> newTestBike = new HashSet<>();
        newTestBike.add(speedelec);

        assertTrue(ViewService.writeToFile(FILE_NAME, newTestBike));
        FileManagerService.fillCollectionsFromFile(FILE_NAME);
        TreeSet<DomainObject> treeSet = new TreeSet<>(CollectionBike.speedelecs);
        Speedelec test = null;
        for (DomainObject bike : treeSet) {
            if (bike.getBrand().equals("SPEEDELEC TestBike")) {
                test = (Speedelec) bike;
            }
        }
        assertNotNull(test);
        assertEquals(test.getBrand(), "SPEEDELEC TestBike");
        assertEquals(test.getPrice(), new BigDecimal(555));
        CollectionBike.speedelecs.removeIf(value -> value.getBrand().equals("SPEEDELEC TestBike"));
        newTestBike = new HashSet<>();
        assertTrue(ViewService.writeToFile(FILE_NAME, newTestBike));
    }
}
