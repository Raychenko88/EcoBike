package com.ecobike;

import com.ecobike.service.FileManagerService;

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
        FileManagerService.getDataFromFile(fileName);


    }
}

