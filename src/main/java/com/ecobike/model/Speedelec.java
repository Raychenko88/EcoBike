package com.ecobike.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Speedelec extends DomainObject{

    public String brand;
    public Integer maximumSpeed;
    public Integer weight;
    public boolean lightsAtFrontAndBack;
    public Integer batteryCapacity;
    public String color;
    public Integer price;

    @Override
    public String toString() {
        return String.format("%s with %d mAh battery and %s head/tail light.\n" +
                "Price: %d euros.", brand, batteryCapacity, lightsAtFrontAndBack?"":"no", price);
    }
}
