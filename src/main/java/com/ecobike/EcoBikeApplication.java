package com.ecobike;

import com.ecobike.model.DomainObject;
import com.ecobike.model.ElectricBike;
import com.ecobike.repository.CollectionBike;
import com.ecobike.service.FileManagerService;
import com.ecobike.service.ViewService;
import com.ecobike.view.MenuView;

import java.io.IOException;
import java.util.TreeSet;

public class EcoBikeApplication {

    public static final String FILE_NAME = "EcoBike.txt";

    public static void main(String[] args) throws IOException {

//        ViewService.showAllCatalog();
//        ViewService viewService = new ViewService();
//        viewService.showAllCatalog();
        MenuView menuView = new MenuView();
        menuView.mainMenu();



    }
}

