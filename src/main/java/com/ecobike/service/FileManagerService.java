package com.ecobike.service;

import com.ecobike.model.DomainObject;
import com.ecobike.model.ElectricBike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.repository.CollectionBike;
import lombok.EqualsAndHashCode;

import java.io.*;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.Set;

@EqualsAndHashCode
public class FileManagerService {

    private static final String DELIMETER = ";";

    public static boolean checkPathAndFile(String fileName) {
        File isFile = new File(fileName);
        return isFile.exists();
    }

    public static boolean writeFile(String fileName, Set<DomainObject> set) {
        File file = new File(fileName);
        if (file != null) {
            try (FileWriter writer = new FileWriter(file);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer);) {

                for (DomainObject bike : set) {
                    bufferedWriter.write(bike.toStringToWrite() + "\n");
                }

                bufferedWriter.flush();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static synchronized void fillCollectionsFromFile(String fileName) {

        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
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
        speedelec.setWeight(new BigDecimal(subStr[2].trim()));
        speedelec.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[3].trim()));
        speedelec.setBatteryCapacity(Integer.parseInt(subStr[4].trim()));
        speedelec.setColor(subStr[5].trim());
        speedelec.setPrice(new BigDecimal(subStr[6].trim()));
        CollectionBike.speedelecs.add(speedelec);
    }

    public static synchronized void addToCollectionElectricBike(String item) {
        String[] subStr = item.split(DELIMETER);
        ElectricBike electricBike = new ElectricBike();
        electricBike.setBrand(subStr[0]);
        electricBike.setMaximumSpeed(Integer.parseInt(subStr[1].trim()));
        electricBike.setWeight(new BigDecimal(subStr[2].trim()));
        electricBike.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[3].trim()));
        electricBike.setBatteryCapacity(Integer.parseInt(subStr[4].trim()));
        electricBike.setColor(subStr[5].trim());
        electricBike.setPrice(new BigDecimal(subStr[6].trim()));
        CollectionBike.electricBikes.add(electricBike);
    }

    public static synchronized void addToCollectionFoldingBike(String item) {
        String[] subStr = item.split(DELIMETER);
        FoldingBike foldingBike = new FoldingBike();
        foldingBike.setBrand(subStr[0]);
        foldingBike.setWheelSize(Integer.parseInt(subStr[1].trim()));
        foldingBike.setNumberOfSpeeds(Integer.parseInt(subStr[2].trim()));
        foldingBike.setWeight(new BigDecimal(subStr[3].trim()));
        foldingBike.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[4].trim()));
        foldingBike.setColor(subStr[5].trim());
        foldingBike.setPrice(new BigDecimal(subStr[6].trim()));
        CollectionBike.foldingBikes.add(foldingBike);
    }
}
