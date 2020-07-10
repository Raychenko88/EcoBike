package com.ecobike.model;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoldingBike extends DomainObject {

    private Integer wheelSize;
    private Integer numberOfSpeeds;

    @Override
    public String toString() {
        return String.format("%s with %d gear(s) and %s head/tail light.\n" +
                "Price: %s euros.", getBrand(), numberOfSpeeds, getLightsAtFrontAndBack() ? "" : "no", getPrice().toString());
    }

    @Override
    public String toStringToWrite() {
        return getBrand() + "; " + getWheelSize() + "; " + getNumberOfSpeeds() + "; " + getWeight() + "; " +
                getLightsAtFrontAndBack() + "; " + getColor() + "; " + getPrice();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getBrand().hashCode();
        result = 31 * result + wheelSize.hashCode();
        result = 31 * result + numberOfSpeeds.hashCode();
        result = 31 * result + this.getWeight().hashCode();
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
                FoldingBike foldingBike = (FoldingBike) obj;
                return  foldingBike.getBrand().equals(this.getBrand()) &&
                        foldingBike.getWheelSize().equals(wheelSize) &&
                        foldingBike.getNumberOfSpeeds().equals(numberOfSpeeds) &&
                        foldingBike.getWeight().equals(this.getWeight()) &&
                        foldingBike.getLightsAtFrontAndBack().equals(this.getLightsAtFrontAndBack()) &&
                        foldingBike.getColor().equals(this.getColor()) &&
                        foldingBike.getPrice().equals(this.getPrice());
    }
}
