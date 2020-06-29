package com.ecobike.service;

import com.ecobike.model.ElectricBike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.repository.CollectionBike;
import lombok.EqualsAndHashCode;

import java.io.*;
import java.net.URLDecoder;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@EqualsAndHashCode
public class FileManagerService {

    private static final String DELIMETER = ";";


    public static void addAllCollections(String fileName) {
        if (checkPathAndFile(fileName)) {
            FileManagerService.fillCollectionsFromFile(fileName);
        }else {
            System.out.println("Check data fail");
        }
    }

    public static boolean checkPathAndFile(String fileName) {
        File isFile = new File(fileName);
        return isFile.exists();
    }

    public static void writeFile(String fileName) {
        File file = new File(fileName);
        Scanner scanner = new Scanner(System.in);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(String.valueOf(scanner.nextLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }

    public static synchronized void fillCollectionsFromFile(String fileName) {

        try {
            FileExtractor fileExtractor = new FileExtractor();

            File file = fileExtractor.getFileFromResources(fileName);
            FileReader fileReader = new FileReader(decode(file.getAbsolutePath()));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {

                if (temp.startsWith("SPEEDELEC")) {
                    addToCollectionSpeedelec(temp);
                } else if (temp.startsWith("E-BIKE")) {
                    addToCollectionElectricBike(temp);
                } else if (temp.startsWith("FOLDING")) {
                    addToCollectionFoldingBike(temp);
                } else {
                    System.out.println("Data was not extracted: " + temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    private static String decode(String path) {
        try {
            return URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static synchronized void addToCollectionSpeedelec(String item) {
        String[] subStr = item.split(DELIMETER);
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

    public static synchronized void addToCollectionElectricBike(String item) {
        String[] subStr = item.split(DELIMETER);
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

    public static synchronized void addToCollectionFoldingBike(String item) {
                String[]  subStr = item.split(DELIMETER);
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

