package com.ecobike;

import com.ecobike.view.MenuView;

import java.io.IOException;
import java.util.Scanner;

public class EcoBikeApplication {

    private static final String FILE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator") +
            "files" + System.getProperty("file.separator");
    public static final String FILE_NAME = FILE_PATH + "EcoBike.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        MenuView menuView = new MenuView();
        menuView.mainMenu(scanner);
        scanner.close();
    }
}
