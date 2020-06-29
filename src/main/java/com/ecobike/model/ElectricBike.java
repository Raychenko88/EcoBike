package com.ecobike.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ElectricBike extends DomainObject{

    public String brand;
    public Integer maximumSpeed;
    public Integer weight;
    public boolean lightsAtFrontAndBack;
    public Integer batteryCapacity;
    public String color;
    public Integer price;
}
