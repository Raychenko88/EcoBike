package com.ecobike.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Speedelec extends DomainObject{

    private Integer maximumSpeed;
    private Integer batteryCapacity;

    @Override
    public String toString() {
        return String.format("%s with %d mAh battery and %s head/tail light.\n" +
                "Price: %d euros.", getBrand(), getBatteryCapacity(), getLightsAtFrontAndBack()?"":"no", getPrice());
    }
}
