package com.ecobike.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FoldingBike extends DomainObject{

    public String brand;
    public Integer wheelSize;
    public Integer numberOfSpeeds;
    public Integer weight;
    public boolean lightsAtFrontAndBack;
    public String color;
    public Integer price;
}
