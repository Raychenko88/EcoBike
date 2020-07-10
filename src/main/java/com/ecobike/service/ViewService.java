package com.ecobike.service;

import com.ecobike.EcoBikeApplication;
import com.ecobike.model.*;
import com.ecobike.repository.CollectionBike;
import lombok.EqualsAndHashCode;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class ViewService {


    static {
        FileManagerService.fillCollectionsFromFile(EcoBikeApplication.FILE_NAME);
    }

    public static void showAllCatalog() {
        CollectionBike.electricBikes.forEach(it -> System.out.println(it));
        CollectionBike.foldingBikes.forEach(it -> System.out.println(it));
        CollectionBike.speedelecs.forEach(it -> System.out.println(it));

    }

    public static boolean addNewFoldingBike(String optionsBike) {
        String[] subStr;
        String str = optionsBike;
        String delimeter = ";";
        subStr = str.split(delimeter);
        if (subStr[0].startsWith("FOLDING") &&   //startWith
                Integer.parseInt(subStr[1].trim()) > 0 &&
                Integer.parseInt(subStr[2].trim()) > 0 &&
                Integer.parseInt(subStr[3].trim()) > 0 &&
                subStr[4] != null &&
                !(subStr[5].trim()).isEmpty() &&
                Integer.parseInt(subStr[6].trim()) > 0) {
//            FoldingBike foldingBike = new FoldingBike();
//            foldingBike.setBrand(subStr[0]);
//            foldingBike.setWheelSize(Integer.parseInt(subStr[1].trim()));
//            foldingBike.setNumberOfSpeeds(Integer.parseInt(subStr[2].trim()));
//            foldingBike.setWeight(new BigDecimal(subStr[3].trim()));
//            foldingBike.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[4].trim()));
//            foldingBike.setColor(subStr[5].trim());
//            foldingBike.setPrice(new BigDecimal(subStr[6].trim()));
//            CollectionBike.foldingBikes.add(foldingBike);
            FileManagerService.addToCollectionFoldingBike(optionsBike);

            return true;
        }
        return false;
    }

    public static boolean addNewSpeedelec(String optionsBike) {
        String[] subStr;
        String str = optionsBike;
        String delimeter = ";";
        subStr = str.split(delimeter);
        if (subStr[0].startsWith("SPEEDELEC") &&    //startWith
                Integer.parseInt(subStr[1].trim()) > 0 &&
                Integer.parseInt(subStr[2].trim()) > 0 &&
                subStr[3] != null &&
                Integer.parseInt(subStr[4].trim()) > 0 &&
                !(subStr[5].trim()).isEmpty() &&
                Integer.parseInt(subStr[6].trim()) > 0) {
//            Speedelec speedelec = new Speedelec();
//            speedelec.setBrand(subStr[0]);
//            speedelec.setMaximumSpeed(Integer.parseInt(subStr[1].trim()));
//            speedelec.setWeight(new BigDecimal(subStr[2].trim()));
//            speedelec.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[3].trim()));
//            speedelec.setBatteryCapacity(Integer.parseInt(subStr[4].trim()));
//            speedelec.setColor(subStr[5].trim());
//            speedelec.setPrice(new BigDecimal(subStr[6].trim()));
//            CollectionBike.speedelecs.add(speedelec);
            FileManagerService.addToCollectionSpeedelec(optionsBike);
            return true;
        }
        return false;
    }

    public static boolean addNewElectricBike(String optionsBike) {
        String[] subStr;
        String str = optionsBike;
        String delimeter = ";";
        subStr = str.split(delimeter);
        if (subStr[0].startsWith("E-BIKE") &&    //startWith
                Integer.parseInt(subStr[1].trim()) > 0 &&
                Integer.parseInt(subStr[2].trim()) > 0 &&
                subStr[3] != null &&
                Integer.parseInt(subStr[4].trim()) > 0 &&
                !(subStr[5].trim()).isEmpty() &&
                Integer.parseInt(subStr[6].trim()) > 0) {
//            ElectricBike electricBike = new ElectricBike();
//            electricBike.setBrand(subStr[0]);
//            electricBike.setMaximumSpeed(Integer.parseInt(subStr[1].trim()));
//            electricBike.setWeight(new BigDecimal(subStr[2].trim()));
//            electricBike.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[3].trim()));
//            electricBike.setBatteryCapacity(Integer.parseInt(subStr[4].trim()));
//            electricBike.setColor(subStr[5].trim());
//            electricBike.setPrice(new BigDecimal(subStr[6].trim()));
//            CollectionBike.electricBikes.add(electricBike);
            FileManagerService.addToCollectionElectricBike(optionsBike);
            return true;
        }
        return false;
    }

    public static TreeSet<DomainObject> showFindTheFirstItemOfBrand(Map<FilterName, String> filter) {
        CollectionBike.filtered.clear();
        TreeSet<DomainObject> treeSet = new TreeSet<>();
        treeSet.addAll(getFilteredeSpeedelecs(CollectionBike.speedelecs, filter));
        treeSet.addAll(getFilteredeElectroBikes(CollectionBike.electricBikes, filter));
        treeSet.addAll(getFilteredeFoldingBike(CollectionBike.foldingBikes, filter));
        CollectionBike.filtered.addAll(treeSet);
        return treeSet;
    }

    private static Set<DomainObject> getFilteredeFoldingBike(Set<DomainObject> foldingBikes, Map<FilterName, String> filter) {
        return foldingBikes
                .stream()
                .filter(it -> isAcceptable(it, filter))
                .collect(Collectors.toSet());
    }


    private static Set<DomainObject> getFilteredeElectroBikes(Set<DomainObject> electricBikes, Map<FilterName, String> filter) {
        return electricBikes
                .stream()
                .filter(it -> isAcceptable(it, filter))
                .collect(Collectors.toSet());
    }


    private static Set<DomainObject> getFilteredeSpeedelecs(Set<DomainObject> speedelecs, Map<FilterName, String> filter) {
        return speedelecs
                .stream()
                .filter(it -> isAcceptable(it, filter))
                .collect(Collectors.toSet());
    }


    private static boolean isAcceptable(DomainObject domainObject, Map<FilterName, String> filter) {
        boolean result = false;
        if (filter.get(FilterName.BRAND) != null && !(filter.get(FilterName.BRAND).isEmpty())) {
            if (domainObject.getBrand().equals(filter.get(FilterName.BRAND))) {
                result = true;
            } else {
                return false;
            }
        }
        if (filter.get(FilterName.COLOR) != null && !(filter.get(FilterName.COLOR).isEmpty())) {
            if (domainObject.getColor().equals(filter.get(FilterName.COLOR))) {
                result = true;
            } else {
                return false;
            }
        }
        if (filter.get(FilterName.PRICE) != null && !(filter.get(FilterName.PRICE).isEmpty())) {
            if (domainObject.getPrice().toString().equals(filter.get(FilterName.PRICE))) {
                result = true;
            } else {
                return false;
            }
        }
        if (filter.get(FilterName.LIGHTS) != null && !(filter.get(FilterName.LIGHTS).isEmpty())) {
            if (domainObject.getLightsAtFrontAndBack().toString().equals(filter.get(FilterName.LIGHTS))) {
                result = true;
            } else {
                return false;
            }
        }
        if (filter.get(FilterName.WEIGHT) != null && !(filter.get(FilterName.WEIGHT).isEmpty())) {
            if (domainObject.getWeight().toString().equals(filter.get(FilterName.WEIGHT))) {
                result = true;
            } else {
                return false;
            }
        }


        if (domainObject instanceof Speedelec) {
            Speedelec speedelec = (Speedelec) domainObject;
            if (filter.get(FilterName.MAXIMUM_SPEED) != null && !(filter.get(FilterName.MAXIMUM_SPEED).isEmpty())) {
                if (speedelec.getMaximumSpeed().toString().equals(filter.get(FilterName.MAXIMUM_SPEED))) {
                    result = true;
                } else {
                    return false;
                }
            }
            if (filter.get(FilterName.BATTERY) != null && !(filter.get(FilterName.BATTERY).isEmpty())) {
                if (speedelec.getBatteryCapacity().toString().equals(filter.get(FilterName.BATTERY))) {
                    result = true;
                } else {
                    return false;
                }
            }
        }

        if (domainObject instanceof ElectricBike) {
            ElectricBike electricBike = (ElectricBike) domainObject;
            if (filter.get(FilterName.MAXIMUM_SPEED) != null && !(filter.get(FilterName.MAXIMUM_SPEED).isEmpty())) {
                if (electricBike.getMaximumSpeed().toString().equals(filter.get(FilterName.MAXIMUM_SPEED))) {
                    result = true;
                } else {
                    return false;
                }
            }
            if (filter.get(FilterName.BATTERY) != null && !(filter.get(FilterName.BATTERY).isEmpty())) {
                if (electricBike.getBatteryCapacity().toString().equals(filter.get(FilterName.BATTERY))) {
                    result = true;
                } else {
                    return false;
                }
            }
        }

        if (domainObject instanceof FoldingBike) {
            FoldingBike foldingBike = (FoldingBike) domainObject;
            if (filter.get(FilterName.WHEEL_SIZE) != null && !(filter.get(FilterName.WHEEL_SIZE).isEmpty())) {
                if (foldingBike.getWheelSize().toString().equals(filter.get(FilterName.WHEEL_SIZE))) {
                    result = true;
                } else {
                    return false;
                }
            }
            if (filter.get(FilterName.NUMBER_SPEEDS) != null && !(filter.get(FilterName.NUMBER_SPEEDS).isEmpty())) {
                if (foldingBike.getNumberOfSpeeds().toString().equals(filter.get(FilterName.NUMBER_SPEEDS))) {
                    result = true;
                } else {
                    return false;
                }
            }
        }
        return result;
    }


    public static boolean writeToFile(String fileName, Set<DomainObject> set) {
        if (FileManagerService.checkPathAndFile(fileName)) {
            if (FileManagerService.writeFile(fileName, set)) {
                return true;
            }
        }
        return false;
    }
}
