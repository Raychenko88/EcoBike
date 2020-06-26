package com.ecobike.service;

import com.ecobike.model.ElectricBike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.repository.CollectionBike;
import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManagerService {

//    private static String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "ecobike";
//    private static String fileName = "ecobike.txt";

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


    public static List<Object> getDataFromFile(String fileName){
        List<Object> items = new ArrayList<>();

        try {
            FileExtractor fileExtractor = new FileExtractor();

            File file = fileExtractor.getFileFromResources(fileName);
            FileReader fileReader = new FileReader(decode(file.getAbsolutePath()));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp;
            while ((temp = bufferedReader.readLine()) != null){
                items.add(temp);
            }
            String[] subStr;
            for (Object item : items) {
                String str = item.toString();
                String delimeter = ";"; // Разделитель
                if (item.toString().startsWith("SPEEDELEC")){
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
                    System.out.println("ADD wit SPEEDELEC");
                }else if (item.toString().startsWith("E-BIKE")){
                    subStr = str.split(delimeter);
                    ElectricBike electricBike = new ElectricBike(
                            subStr[0],
                            Integer.parseInt(subStr[1].trim()),
                            Integer.parseInt(subStr[2].trim()),
                            Boolean.parseBoolean(subStr[3].trim()),
                            Integer.parseInt(subStr[4].trim()),
                            subStr[5].trim(),
                            Integer.parseInt(subStr[6].trim()));
                    CollectionBike.electricBikes.add(electricBike);
                    System.out.println("ADD wit E-BIKE");
                }else if (item.toString().startsWith("FOLDING")){
                    subStr = str.split(delimeter);
                    FoldingBike foldingBike = new FoldingBike(
                            subStr[0],
                            Integer.parseInt(subStr[1].trim()),
                            Integer.parseInt(subStr[2].trim()),
                            Integer.parseInt(subStr[3].trim()),
                            Boolean.parseBoolean(subStr[4].trim()),
                            subStr[5].trim(),
                            Integer.parseInt(subStr[6].trim()));
                    CollectionBike.foldingBikes.add(foldingBike);
                    System.out.println("ADD wit FOLDING");
                    System.out.println(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String decode(String path){
        try {
            return URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}

