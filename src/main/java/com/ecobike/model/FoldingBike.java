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

    @Override
    public String toString() {
        return String.format("%s with %d gear(s) and %s head/tail light.\n" +
                "Price: %d euros.", brand, numberOfSpeeds, lightsAtFrontAndBack?"":"no", price);
    }
}
