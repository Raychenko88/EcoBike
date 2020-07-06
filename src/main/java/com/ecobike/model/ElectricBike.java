package com.ecobike.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ElectricBike extends DomainObject{


    private Integer maximumSpeed;
    private Integer batteryCapacity;

    @Override
    public String toString() {
        return String.format("%s with %d mAh battery and %s head/tail light.\n" +
                "Price: %s euros.", getBrand(), batteryCapacity, getLightsAtFrontAndBack()?"":"no", getPrice().toString());
    }

    @Override
    public String toStringToWrite() {
        return getBrand() + "; " + getMaximumSpeed() + "; " + getWeight() + "; " + getLightsAtFrontAndBack() + "; " +
                getBatteryCapacity() + "; " + getColor() + "; " + getPrice();
    }
}
