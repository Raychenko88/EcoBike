package com.ecobike.model;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
