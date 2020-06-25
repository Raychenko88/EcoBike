package ecobike.com.resources;

import ecobike.com.service.BikeService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WorkWitFile {

    private static String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "ecobike";
    private static String fileName = "ecobike.txt";

    public static boolean checkPathAndFile(String filePath) {
        File pathTofile = new File(filePath);
        return pathTofile.exists() != false;
    }

    public static void writeFile() {
        File file = new File(filePath, fileName);
        Scanner scanner = new Scanner(System.in);
        try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(String.valueOf(scanner.nextLine()));
                scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile() {
        File file = new File(filePath, fileName);
        StringBuilder stringBuilder = new StringBuilder();
        String allElements;
        try (FileReader reader = new FileReader(file)) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        allElements = stringBuilder.toString();
        return allElements;
    }
}

