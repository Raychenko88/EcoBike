package com.ecobike.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class FileExtractor {
        ClassLoader classLoader = getClass().getClassLoader();

        File getFileFromResources(String fileName) throws FileNotFoundException {
            URL url = classLoader.getResource(fileName);
            if (url != null){
                return new File(url.getFile());
            }
            throw new FileNotFoundException("File is not found");
        }
    }

