package com.ecobike.service;

import com.ecobike.model.ElectricBike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.repository.CollectionBike;
import com.sun.deploy.util.StringUtils;
import lombok.EqualsAndHashCode;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@EqualsAndHashCode
public class FileManagerService extends Thread{

    private static String fileName = "EcoBike.txt";

    @Override
    public void run() {
        addAllCollections(fileName);
    }

    public static void addAllCollections(String fileName) {
        if (checkPathAndFile(fileName)) {
            FileManagerService.getDataFromFile(fileName);
            FileManagerService.addToCollectionFoldingBike(FileManagerService.getDataFromFile(fileName));
            FileManagerService.addToCollectionSpeedelec(FileManagerService.getDataFromFile(fileName));
            FileManagerService.addToCollectionElectricBike(FileManagerService.getDataFromFile(fileName));
        }
        System.out.println("Check data fail");
    }

    public static boolean checkPathAndFile(String fileName) {
        File isFile = new File(fileName);
        return isFile.exists() != false;
    }

    public static void writeFile(String fileName) {
        File file = new File(fileName);
        Scanner scanner = new Scanner(System.in);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(String.valueOf(scanner.nextLine()));
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized  List<Object> getDataFromFile(String fileName) {
        List<Object> items = new ArrayList<>();

        try {
            FileExtractor fileExtractor = new FileExtractor();

            File file = fileExtractor.getFileFromResources(fileName);
            FileReader fileReader = new FileReader(decode(file.getAbsolutePath()));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                items.add(temp);
            }
            addToCollectionSpeedelec(items);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    private static String decode(String path) {
        try {
            return URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static synchronized  Set<Speedelec> addToCollectionSpeedelec(List<Object> items) {
        String[] subStr;
        for (Object item : items) {
            String str = item.toString();
            String delimeter = ";";
            if (item.toString().startsWith("SPEEDELEC")) {
                subStr = str.split(delimeter);
                Speedelec speedelec = new Speedelec();
                speedelec.setBrand(subStr[0]);
                speedelec.setMaximumSpeed(Integer.parseInt(subStr[1].trim()));
                speedelec.setWeight(Integer.parseInt(subStr[2].trim()));
                speedelec.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[3].trim()));
                speedelec.setBatteryCapacity(Integer.parseInt(subStr[4].trim()));
                speedelec.setColor(subStr[5].trim());
                speedelec.setPrice(Integer.parseInt(subStr[6].trim()));
                CollectionBike.speedelecs.add(speedelec);
            }
        }
        return CollectionBike.speedelecs;
    }

    public static synchronized  Set<ElectricBike> addToCollectionElectricBike(List<Object> items) {
        String[] subStr;
        for (Object item : items) {
            String str = item.toString();
            String delimeter = ";";
            if (item.toString().startsWith("E-BIKE")) {
                subStr = str.split(delimeter);
                ElectricBike electricBike = new ElectricBike();
                electricBike.setBrand(subStr[0]);
                electricBike.setMaximumSpeed(Integer.parseInt(subStr[1].trim()));
                electricBike.setWeight(Integer.parseInt(subStr[2].trim()));
                electricBike.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[3].trim()));
                electricBike.setBatteryCapacity(Integer.parseInt(subStr[4].trim()));
                electricBike.setColor(subStr[5].trim());
                electricBike.setPrice(Integer.parseInt(subStr[6].trim()));
                CollectionBike.electricBikes.add(electricBike);
            }
        }
        return CollectionBike.electricBikes;
    }

    public static synchronized  Set<FoldingBike> addToCollectionFoldingBike(List<Object> items) {
        String[] subStr;
        for (Object item : items) {
            String str = item.toString();
            String delimeter = ";";
            if (item.toString().startsWith("FOLDING")) {
                subStr = str.split(delimeter);
                FoldingBike foldingBike = new FoldingBike();
                foldingBike.setBrand(subStr[0]);
                foldingBike.setWheelSize(Integer.parseInt(subStr[1].trim()));
                foldingBike.setNumberOfSpeeds(Integer.parseInt(subStr[2].trim()));
                foldingBike.setWeight(Integer.parseInt(subStr[3].trim()));
                foldingBike.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[4].trim()));
                foldingBike.setColor(subStr[5].trim());
                foldingBike.setPrice(Integer.parseInt(subStr[6].trim()));
                CollectionBike.foldingBikes.add(foldingBike);
            }
        }
        return CollectionBike.foldingBikes;
    }

}

