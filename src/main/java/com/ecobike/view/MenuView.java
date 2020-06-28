package com.ecobike.view;

import com.ecobike.service.ViewService;
import lombok.EqualsAndHashCode;

import java.util.Scanner;

@EqualsAndHashCode
public class MenuView {
    Scanner scanner = new Scanner(System.in);

    private static String showChoice = "Please make your choice:\n" +
            "1 - Show the entire EcoBike catalog\n" +
            "2 – Add a new folding bike\n" +
            "3 – Add a new speedelec\n" +
            "4 – Add a new e-bike\n" +
            "5 – Find the first item of a particular brand\n" +
            "6 – Write to file\n" +
            "7 – Stop the program";

    public static void mainMenu(){
        System.out.println(showChoice);


    }

    private static void checkChoice(String choice){
        if (choice.equals("1")){
            ViewService.showCatalog();
        }else if (choice.equals("2")){

        }else if (choice.equals("3")){

        }else if (choice.equals("4")){

        }else if (choice.equals("5")){

        }else if (choice.equals("6")){

        }else if (choice.equals("7")){

        }
        // тут должна быть рекурсия на этот же метод
    }




}
