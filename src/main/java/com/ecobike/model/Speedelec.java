package com.ecobike.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Speedelec {

//    public Integer id;
    public String brand;
    public Integer maximumSpeed;
    public Integer weight;
    public boolean lightsAtFrontAndBack;
    public Integer batteryCapacity;
    public String color;
    public Integer price;
}
