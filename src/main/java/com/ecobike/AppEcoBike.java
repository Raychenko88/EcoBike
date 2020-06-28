package com.ecobike;

import com.ecobike.repository.CollectionBike;
import com.ecobike.service.FileManagerService;
import com.ecobike.service.ViewService;
import com.ecobike.view.MenuView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class AppEcoBike {

    //    private static String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "ecobike";
    private static String fileName = "EcoBike.txt";

    public static void main(String[] args) throws IOException {
//        WorkWitFile.writeFile();
//        System.out.println(FileManagerService.readFile());
//        FileManagerService.getDataFromFile(fileName);
//        MenuView.mainMenu();

        ViewService.showCatalog();

        System.out.println(CollectionBike.speedelecs.size() + " CollectionBike.speedelecs.size");
        System.out.println(CollectionBike.electricBikes.size() + " CollectionBike.electricBikes.size");
        System.out.println(CollectionBike.foldingBikes.size() + " CollectionBike.foldingBikes.size");

        System.out.println(FileManagerService.addToCollectionFoldingBike(FileManagerService.getDataFromFile(fileName)).size() + " FileManagerService.addToCollectionFoldingBike(FileManagerService.getDataFromFile(fileName)).size");
        System.out.println(FileManagerService.addToCollectionSpeedelec(FileManagerService.getDataFromFile(fileName)).size() + " FileManagerService.addToCollectionSpeedelec(FileManagerService.getDataFromFile(fileName)).size");
        System.out.println(FileManagerService.addToCollectionElectricBike(FileManagerService.getDataFromFile(fileName)).size() + " FileManagerService.addToCollectionElectricBike(FileManagerService.getDataFromFile(fileName))");

    }
}

