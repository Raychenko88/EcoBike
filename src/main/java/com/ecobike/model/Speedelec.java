package com.ecobike.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Speedelec extends DomainObject {

    private Integer maximumSpeed;
    private Integer batteryCapacity;

    @Override
    public String toString() {
        return String.format("%s with %d mAh battery and %s head/tail light.\n" +
                "Price: %s euros.", getBrand(), getBatteryCapacity(), getLightsAtFrontAndBack() ? "" : "no", getPrice().toString());
    }


    @Override
    public String toStringToWrite() {
        return getBrand() + "; " + getMaximumSpeed() + "; " + getWeight() + "; " + getLightsAtFrontAndBack() + "; " +
                getBatteryCapacity() + "; " + getColor() + "; " + getPrice();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getBrand().hashCode();
        result = 31 * result + this.maximumSpeed.hashCode();
        result = 31 * result + this.getWeight().hashCode();
        result = 31 * result + batteryCapacity.hashCode();
        result = 31 * result + this.getColor().hashCode();
        result = 31 * result + this.getPrice().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof FoldingBike)) {
            return false;
        }
        Speedelec speedelec = (Speedelec) obj;
        return  speedelec.getBrand().equals(this.getBrand()) &&
                speedelec.getMaximumSpeed().equals(maximumSpeed) &&
                speedelec.getWeight().equals(this.getWeight()) &&
                speedelec.getLightsAtFrontAndBack().equals(this.getLightsAtFrontAndBack()) &&
                speedelec.getBatteryCapacity().equals(batteryCapacity) &&
                speedelec.getColor().equals(this.getColor()) &&
                speedelec.getPrice().equals(this.getPrice());
    }

}
