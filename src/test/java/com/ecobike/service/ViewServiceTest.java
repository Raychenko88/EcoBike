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
        String bikeOptions = "SPEEDELEC SpeedelecTest; 60; 15300; false; 14800; marine; 309";
        assertTrue(ViewService.addNewSpeedelec(bikeOptions));
        Speedelec test = null;
        for (DomainObject bike : CollectionBike.speedelecs) {
            if (bike.getBrand().equals("SPEEDELEC SpeedelecTest")) {
                test = (Speedelec) bike;
            }
        }
        assertNotNull(test);
        assertEquals(test.getPrice(), new BigDecimal(309));
        assertEquals(test.getBrand(), "SPEEDELEC SpeedelecTest");
        CollectionBike.foldingBikes.removeIf(value -> value.getBrand().equals("SPEEDELEC SpeedelecTest"));
    }

    @Test
    void addNewElectricBike() {
        String bikeOptions = "E-BIKE TestBike; 60; 21200; false; 15000; brown; 1135";
        assertTrue(ViewService.addNewElectricBike(bikeOptions));
        ElectricBike test = null;
        for (DomainObject bike : CollectionBike.electricBikes) {
            if (bike.getBrand().equals("E-BIKE TestBike")) {
                test = (ElectricBike) bike;
            }
        }
        assertNotNull(test);
        assertEquals(test.getPrice(), new BigDecimal(1135));
        assertEquals(test.getBrand(), "E-BIKE TestBike");
        CollectionBike.foldingBikes.removeIf(value -> value.getBrand().equals("E-BIKE TestBike"));
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
        Speedelec test = null;
        for (DomainObject bike : CollectionBike.speedelecs) {
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
