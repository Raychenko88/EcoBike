package ecobike.com;

import ecobike.com.resources.WorkWitFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppEcoBike {

    private static String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "ecobike";
    private static String fileName = "ecobike.txt";

    public static void main(String[] args) throws IOException {
//        WorkWitFile.writeFile();
        System.out.println(WorkWitFile.readFile());
    }
}
