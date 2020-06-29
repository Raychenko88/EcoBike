package com.ecobike;

import com.ecobike.repository.CollectionBike;
import com.ecobike.service.FileManagerService;
import com.ecobike.service.ViewService;

import java.io.IOException;

public class EcoBikeApplication {

    //    private static String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "ecobike";
    public static final String FILE_NAME = "EcoBike.txt";

    public static void main(String[] args) throws IOException {

//        WorkWitFile.writeFile();
//        System.out.println(FileManagerService.readFile());
//        FileManagerService.getDataFromFile(fileName);
//        MenuView.mainMenu();

//        ViewService.showAllCatalog();
        ViewService viewService = new ViewService();
        viewService.showAllCatalog();

//        System.out.println(CollectionBike.speedelecs.size() + " CollectionBike.speedelecs.size");
//        System.out.println(CollectionBike.electricBikes.size() + " CollectionBike.electricBikes.size");
//        System.out.println(CollectionBike.foldingBikes.size() + " CollectionBike.foldingBikes.size");
//
//        System.out.println(FileManagerService.addToCollectionFoldingBike(FileManagerService.fillCollectionsFromFile(fileName)).size() + " FileManagerService.addToCollectionFoldingBike(FileManagerService.getDataFromFile(fileName)).size");
//        System.out.println(FileManagerService.addToCollectionSpeedelec(FileManagerService.fillCollectionsFromFile(fileName)).size() + " FileManagerService.addToCollectionSpeedelec(FileManagerService.getDataFromFile(fileName)).size");
//        System.out.println(FileManagerService.addToCollectionElectricBike(FileManagerService.fillCollectionsFromFile(fileName)).size() + " FileManagerService.addToCollectionElectricBike(FileManagerService.getDataFromFile(fileName))");

    }
}

