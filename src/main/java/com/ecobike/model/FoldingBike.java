package com.ecobike.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FoldingBike extends DomainObject{

    private Integer wheelSize;
    private Integer numberOfSpeeds;

    @Override
    public String toString() {
        return String.format("%s with %d gear(s) and %s head/tail light.\n" +
                "Price: %d euros.", getBrand(), numberOfSpeeds, getLightsAtFrontAndBack()?"":"no", getPrice());
    }
}
