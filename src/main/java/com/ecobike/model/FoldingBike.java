package com.ecobike.model;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
