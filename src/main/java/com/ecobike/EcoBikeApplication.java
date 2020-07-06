package com.ecobike;

import com.ecobike.model.DomainObject;
import com.ecobike.model.ElectricBike;
import com.ecobike.model.FilterName;
import com.ecobike.model.Speedelec;
import com.ecobike.repository.CollectionBike;
import com.ecobike.service.FileManagerService;
import com.ecobike.service.ViewService;
import com.ecobike.view.MenuView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class EcoBikeApplication {

    public static final String FILE_NAME = "EcoBike.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        MenuView menuView = new MenuView();
        menuView.mainMenu(scanner);
        scanner.close();
    }
}

