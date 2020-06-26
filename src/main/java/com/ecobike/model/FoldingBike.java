package com.ecobike.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
public class FoldingBike {

//    public Integer id;
    public String brand;
    public Integer wheelSize;
    public Integer numberOfSpeeds;
    public Integer weight;
    public boolean lightsAtFrontAndBack;
    public String color;
    public Integer price;
}
