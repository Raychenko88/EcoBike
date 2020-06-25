package ecobike.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
public class ElectricBike {

    public Integer id;
    public String brand;
    public Integer maximumSpeed;
    public Integer weight;
    public boolean lightsAtFrontAndBack;
    public Integer batteryCapacity;
    public String color;
    public BigDecimal price;
}
