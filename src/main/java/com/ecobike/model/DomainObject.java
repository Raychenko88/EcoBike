package com.ecobike.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public abstract class DomainObject implements Comparable {

    private String brand;
    private String color;
    private BigDecimal price;
    private Boolean lightsAtFrontAndBack;
    private BigDecimal weight;

    @Override
    public int compareTo(Object o) {
        DomainObject domainObject = (DomainObject) o;
        int cBrand = brand.compareTo(domainObject.getBrand());
        if (cBrand == 0) {
            int cColor = color.compareTo(domainObject.getColor());
            if (cColor == 0) {
                int cPrice = price.compareTo(domainObject.price);
                if (cPrice == 0) {
                    int cLight = lightsAtFrontAndBack.compareTo(domainObject.getLightsAtFrontAndBack());
                    if (cLight == 0) {
                        return weight.compareTo(domainObject.getWeight());
                    } else {
                        return cLight;
                    }
                } else {
                    return cPrice;
                }
            } else {
                return cColor;
            }
        } else {
            return cBrand;
        }
    }

    public abstract String toStringToWrite();
}
