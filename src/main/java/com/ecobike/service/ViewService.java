package com.ecobike.service;

import com.ecobike.EcoBikeApplication;
import com.ecobike.model.*;
import com.ecobike.repository.CollectionBike;
import lombok.EqualsAndHashCode;

import java.util.*;
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
                Boolean.parseBoolean(subStr[4].trim()) == true || false &&
                !(subStr[5].trim()).isEmpty() &&
                Integer.parseInt(subStr[6].trim()) > 0) {
            FoldingBike foldingBike = new FoldingBike();
            foldingBike.setBrand(subStr[0]);
            foldingBike.setWheelSize(Integer.parseInt(subStr[1].trim()));
            foldingBike.setNumberOfSpeeds(Integer.parseInt(subStr[2].trim()));
            foldingBike.setWeight(Integer.parseInt(subStr[3].trim()));
            foldingBike.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[4].trim()));
            foldingBike.setColor(subStr[5].trim());
            foldingBike.setPrice(Integer.parseInt(subStr[6].trim()));
            CollectionBike.foldingBikes.add(foldingBike);
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
                Boolean.parseBoolean(subStr[3].trim()) == true || false &&
                Integer.parseInt(subStr[4].trim()) > 0 &&
                !(subStr[5].trim()).isEmpty() &&
                Integer.parseInt(subStr[6].trim()) > 0) {
            Speedelec speedelec = new Speedelec();
            speedelec.setBrand(subStr[0]);
            speedelec.setMaximumSpeed(Integer.parseInt(subStr[1].trim()));
            speedelec.setWeight(Integer.parseInt(subStr[2].trim()));
            speedelec.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[3].trim()));
            speedelec.setBatteryCapacity(Integer.parseInt(subStr[4].trim()));
            speedelec.setColor(subStr[5].trim());
            speedelec.setPrice(Integer.parseInt(subStr[6].trim()));
            CollectionBike.speedelecs.add(speedelec);
            return true;
        }
        return false;
    }

    public static boolean addNewElectricBike(String optionsBike) {
        String[] subStr;
        String str = optionsBike;
        String delimeter = ";";
        subStr = str.split(delimeter);
        if (subStr[0].startsWith("SPEEDELEC") &&    //startWith
                Integer.parseInt(subStr[1].trim()) > 0 &&
                Integer.parseInt(subStr[2].trim()) > 0 &&
                Boolean.parseBoolean(subStr[3].trim()) == true || false &&
                Integer.parseInt(subStr[4].trim()) > 0 &&
                !(subStr[5].trim()).isEmpty() &&
                Integer.parseInt(subStr[6].trim()) > 0) {
            ElectricBike electricBike = new ElectricBike();
            electricBike.setBrand(subStr[0]);
            electricBike.setMaximumSpeed(Integer.parseInt(subStr[1].trim()));
            electricBike.setWeight(Integer.parseInt(subStr[2].trim()));
            electricBike.setLightsAtFrontAndBack(Boolean.parseBoolean(subStr[3].trim()));
            electricBike.setBatteryCapacity(Integer.parseInt(subStr[4].trim()));
            electricBike.setColor(subStr[5].trim());
            electricBike.setPrice(Integer.parseInt(subStr[6].trim()));
            CollectionBike.speedelecs.add(electricBike);
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
                .filter(it -> isFoldingBikeAcceptable(it, filter))
                .collect(Collectors.toSet());
    }

    private static boolean isFoldingBikeAcceptable(DomainObject domainObject, Map<FilterName, String> filter) {
        FoldingBike foldingBike = (FoldingBike) domainObject;
        if (foldingBike.getBrand().equals(filter.get(FilterName.BRAND))) {
            if (filter.get(FilterName.WEIGHT) != null) {
                if (foldingBike.getWeight().equals(Integer.valueOf(filter.get(FilterName.WEIGHT)))) {
                    if (filter.get(FilterName.LIGHTS) != null) {
                        if (foldingBike.getLightsAtFrontAndBack().equals(Boolean.valueOf(filter.get(FilterName.LIGHTS)))) {
                            if (filter.get(FilterName.COLOR) != null) {
                                if (foldingBike.getColor().equals(filter.get(FilterName.COLOR))) {
                                    if (filter.get(FilterName.PRICE) != null) {
                                        if (foldingBike.getPrice().equals(Integer.valueOf(filter.get(FilterName.PRICE)))) {
                                            if (filter.get(FilterName.WHEEL_SIZE) != null) {
                                                if (foldingBike.getWheelSize().equals(Integer.valueOf(filter.get(FilterName.WHEEL_SIZE)))) {
                                                    if (filter.get(FilterName.NUMBER_SPEEDS) != null) {
                                                        if (foldingBike.getNumberOfSpeeds().equals(Integer.valueOf(filter.get(FilterName.NUMBER_SPEEDS)))) {
                                                            return true;
                                                        } else {
                                                            return false;
                                                        }
                                                    } else {
                                                        return true;
                                                    }
                                                } else {
                                                    return false;
                                                }
                                            } else {
                                                return true;
                                            }
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return true;
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                                return true;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    private static Set<DomainObject> getFilteredeElectroBikes(Set<DomainObject> electricBikes, Map<FilterName, String> filter) {
        return electricBikes
                .stream()
                .filter(it -> isElectroBikeAcceptable(it, filter))
                .collect(Collectors.toSet());
    }

    private static boolean isElectroBikeAcceptable(DomainObject domainObject, Map<FilterName, String> filter) {
        ElectricBike electricBike = (ElectricBike) domainObject;
        if (electricBike.getBrand().equals(filter.get(FilterName.BRAND))) {
            if (filter.get(FilterName.WEIGHT) != null) {
                if (electricBike.getWeight().equals(Integer.valueOf(filter.get(FilterName.WEIGHT)))) {
                    if (filter.get(FilterName.LIGHTS) != null) {
                        if (electricBike.getLightsAtFrontAndBack().equals(Boolean.valueOf(filter.get(FilterName.LIGHTS)))) {
                            if (filter.get(FilterName.COLOR) != null) {
                                if (electricBike.getColor().equals(filter.get(FilterName.COLOR))) {
                                    if (filter.get(FilterName.PRICE) != null) {
                                        if (electricBike.getPrice().equals(Integer.valueOf(filter.get(FilterName.PRICE)))) {
                                            if (filter.get(FilterName.MAXIMUM_SPEED) != null) {
                                                if (electricBike.getMaximumSpeed().equals(Integer.valueOf(filter.get(FilterName.MAXIMUM_SPEED)))) {
                                                    if (filter.get(FilterName.BATTERY) != null) {
                                                        if (electricBike.getBatteryCapacity().equals(Integer.valueOf(filter.get(FilterName.BATTERY)))) {
                                                            return true;
                                                        } else {
                                                            return false;
                                                        }
                                                    } else {
                                                        return true;
                                                    }
                                                } else {
                                                    return false;
                                                }
                                            } else {
                                                return true;
                                            }
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return true;
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                                return true;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    private static Set<DomainObject> getFilteredeSpeedelecs(Set<DomainObject> speedelecs, Map<FilterName, String> filter) {
        return speedelecs
                .stream()
                .filter(it -> isSpeedelecAcceptable(it, filter))
                .collect(Collectors.toSet());
    }

    private static boolean isSpeedelecAcceptable(DomainObject domainObject, Map<FilterName, String> filter) {
        Speedelec speedelec = (Speedelec) domainObject;
        if (speedelec.getBrand().equals(filter.get(FilterName.BRAND))) {
            if (filter.get(FilterName.WEIGHT) != null) {
                if (speedelec.getWeight().equals(Integer.valueOf(filter.get(FilterName.WEIGHT)))) {
                    if (filter.get(FilterName.LIGHTS) != null) {
                        if (speedelec.getLightsAtFrontAndBack().equals(Boolean.valueOf(filter.get(FilterName.LIGHTS)))) {
                            if (filter.get(FilterName.COLOR) != null) {
                                if (speedelec.getColor().equals(filter.get(FilterName.COLOR))) {
                                    if (filter.get(FilterName.PRICE) != null) {
                                        if (speedelec.getPrice().equals(Integer.valueOf(filter.get(FilterName.PRICE)))) {
                                            if (filter.get(FilterName.MAXIMUM_SPEED) != null) {
                                                if (speedelec.getMaximumSpeed().equals(Integer.valueOf(filter.get(FilterName.MAXIMUM_SPEED)))) {
                                                    if (filter.get(FilterName.BATTERY) != null) {
                                                        if (speedelec.getBatteryCapacity().equals(Integer.valueOf(filter.get(FilterName.BATTERY)))) {
                                                            return true;
                                                        } else {
                                                            return false;
                                                        }
                                                    } else {
                                                        return true;
                                                    }
                                                } else {
                                                    return false;
                                                }
                                            } else {
                                                return true;
                                            }
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return true;
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                                return true;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public static boolean writeToFile(String fileName, Set<DomainObject> set) {
        if (FileManagerService.checkPathAndFile(fileName)) {
            if (FileManagerService.writeFile(fileName, set)) {
                return true;
            }
        }
        return false;
    }

    public static void stopTheProgram() {

    }
}
