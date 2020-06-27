package com.ecobike.repository;

import com.ecobike.model.ElectricBike;
import com.ecobike.model.Speedelec;
import com.ecobike.model.FoldingBike;

import java.util.HashSet;
import java.util.Set;

public class CollectionBike {

    public static Set<FoldingBike> foldingBikes = new HashSet<>();
    public static Set<ElectricBike> electricBikes = new HashSet<>();
    public static Set<Speedelec> speedelecs = new HashSet<>();
}
