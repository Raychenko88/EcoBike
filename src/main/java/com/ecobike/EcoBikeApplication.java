package com.ecobike;

import com.ecobike.model.DomainObject;
import com.ecobike.model.ElectricBike;
import com.ecobike.model.FilterName;
import com.ecobike.model.Speedelec;
import com.ecobike.repository.CollectionBike;
import com.ecobike.service.FileManagerService;
import com.ecobike.service.ViewService;
import com.ecobike.view.MenuView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class EcoBikeApplication {

    public static final String FILE_NAME = "EcoBike.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        MenuView menuView = new MenuView();
        menuView.mainMenu(scanner);
        scanner.close();

//        Map<FilterName, String> filterNameHashMap = new HashMap<>();
//        filterNameHashMap.put(FilterName.BRAND, "SPEEDELEC Booster");
//        filterNameHashMap.put(FilterName.MAXIMUM_SPEED, "35");
//        filterNameHashMap.put(FilterName.WEIGHT, "10900");
//        filterNameHashMap.put(FilterName.LIGHTS, "false");
//        filterNameHashMap.put(FilterName.BATTERY, "13200");
//        filterNameHashMap.put(FilterName.COLOR, "green");
//        filterNameHashMap.put(FilterName.PRICE, "1279");
//
//        Speedelec speedelec = (Speedelec) domainObject;
//
//        for (Map.Entry<FilterName, String> bike : filterNameHashMap.entrySet()) {
//            if (!(bike.getValue().equals("")) && bike.getKey() != null){
//                if (bike.getKey().equals(FilterName.BRAND)){
//
//                }
//            }
//        }
    }


    private static boolean isSpeedelecAcceptable(DomainObject domainObject, Map<FilterName, String> filter) {
        Speedelec speedelec = (Speedelec) domainObject;
        if (speedelec.getBrand().equals(filter.get(FilterName.BRAND))){
            if (filter.get(FilterName.MAXIMUM_SPEED) != null){
                if (filter.get(FilterName.MAXIMUM_SPEED).equals("")){
                    пропускаем MaximumSpeed
                    if (filter.get(FilterName.WEIGHT) != null){
                        if (filter.get(FilterName.WEIGHT).equals("")){
                            пропускаем   WEIGHT
                            if (filter.get(FilterName.LIGHTS) != null) {
                                if (filter.get(FilterName.LIGHTS).equals("")){
                                    пропускаем  LIGHTS
                                    if (filter.get(FilterName.BATTERY) != null){
                                       if (filter.get(FilterName.BATTERY).equals("")){
                                           пропускаем BATTERY
                                           if (filter.get(FilterName.COLOR) != null){
                                             if (filter.get(FilterName.COLOR).equals("")){
                                                 пропускаем COLOR!!!!
                                             }else {
                                                 сравниваем COLOR!!!!
                                             }
                                           }else {
                                               return false;
                                           }
                                       }else {
                                           сравниваем BATTERY
                                           if (speedelec.getBatteryCapacity().equals(Integer.valueOf(filter.get(FilterName.BATTERY)))){
                                               if (filter.get(FilterName.COLOR) != null){
                                                   if (filter.get(FilterName.COLOR).equals("")){
                                                       пропускаем COLOR!!!!
                                                   }else {
                                                       сравниваем COLOR!!!!
                                                   }
                                               }else {
                                                   return false;
                                               }
                                           }else {
                                               return false;
                                           }
                                       }
                                    }else {
                                        return false;
                                    }
                                }else {
                                    сравниваем LIGHTS
                                    if (speedelec.getLightsAtFrontAndBack().equals(Boolean.valueOf(filter.get(FilterName.LIGHTS)))){
                                        if (filter.get(FilterName.BATTERY) != null){
                                            if (filter.get(FilterName.BATTERY).equals("")){
                                                пропускаем BATTERY
                                                if (filter.get(FilterName.COLOR) != null){
                                                  if (filter.get(FilterName.COLOR).equals("")){
                                                      пропускаем COLOR!!!!
                                                  }else {
                                                      сравниваем COLOR!!!!
                                                  }
                                                }else {
                                                    return false;
                                                }
                                            }else {
                                                сравниваем BATTERY
                                                if (speedelec.getBatteryCapacity().equals(Integer.valueOf(filter.get(FilterName.BATTERY)))){
                                                    if (filter.get(FilterName.COLOR) != null){
                                                        if (filter.get(FilterName.COLOR).equals("")){
                                                            пропускаем COLOR!!!!
                                                        }else {
                                                            сравниваем COLOR!!!!
                                                        }
                                                    }else {
                                                        return false;
                                                    }
                                                }else {
                                                    return false;
                                                }
                                            }
                                        }else {
                                            return false;
                                        }
                                    }else {
                                        return false;
                                    }
                                }
                            }else {
                                return false;
                            }
                        }else {
                            сравниваем  WEIGHT
                            if (speedelec.getWeight().equals(Integer.valueOf(filter.get(FilterName.WEIGHT)))) {
                                if (filter.get(FilterName.LIGHTS) != null){
                                    if (filter.get(FilterName.LIGHTS).equals("")){
                                        пропусккаем LIGHTS
                                        if (filter.get(FilterName.BATTERY) != null){
                                            if (filter.get(FilterName.BATTERY).equals("")){
                                                пропускаем BATTERY
                                                if (filter.get(FilterName.COLOR) != null){
                                                  if (filter.get(FilterName.COLOR).equals("")){
                                                      пропусккаем COLOR!!!!
                                                  }else {
                                                      сравниваем COLOR!!!!
                                                  }
                                                }else {
                                                    return false;
                                                }
                                            }else {
                                                сравниваем BATTERY
                                                if (speedelec.getBatteryCapacity().equals(Integer.valueOf(filter.get(FilterName.BATTERY)))){
                                                    if (filter.get(FilterName.COLOR) != null){
                                                        if (filter.get(FilterName.COLOR).equals("")){
                                                            пропусккаем COLOR!!!!
                                                        }else {
                                                            сравниваем COLOR!!!!
                                                        }
                                                    }else {
                                                        return false;
                                                    }
                                                }else {
                                                    return false;
                                                }
                                            }
                                        }else {
                                            return false;
                                        }
                                    }else {
                                        сравниваем LIGHTS
                                        if (speedelec.getLightsAtFrontAndBack().equals(Boolean.valueOf(filter.get(FilterName.LIGHTS)))){
                                            if (filter.get(FilterName.BATTERY) != null){
                                              if (filter.get(FilterName.BATTERY).equals("")){
                                                  пропускаем BATTERY
                                                  if (filter.get(FilterName.COLOR) != null) {
                                                   if (filter.get(FilterName.COLOR).equals("")){
                                                       пропускаем COLOR!!!!
                                                   }else {
                                                       сравниваем COLOR!!!!
                                                   }
                                                  }else {
                                                      return false;
                                                  }
                                              }else {
                                                  сравниваем BATTERY
                                                  if (speedelec.getBatteryCapacity().equals(Integer.valueOf(filter.get(FilterName.BATTERY)))){
                                                      if (filter.get(FilterName.COLOR) != null){
                                                          if (filter.get(FilterName.COLOR).equals("")){
                                                              пропускаем COLOR!!!!
                                                          }else {
                                                              сравниваем COLOR!!!!
                                                          }
                                                      }else {
                                                          return false;
                                                      }
                                                  }else {
                                                      return false;
                                                  }
                                              }
                                            }else {
                                                return false;
                                            }
                                        }else {
                                            return false;
                                        }
                                    }
                                }else {
                                    return false;
                                }
                            }else {
                                return false;
                            }
                        }
                    }else {
                        return false;
                    }
                }else {
                   сравниваем MaximumSpeed
                    if (speedelec.getMaximumSpeed().equals(Integer.valueOf(filter.get(FilterName.MAXIMUM_SPEED)))){
                        if (filter.get(FilterName.WEIGHT) != null){
                            if (filter.get(FilterName.WEIGHT).equals("")){
                                пропускаем WEIGHT
                                if (filter.get(FilterName.LIGHTS) != null){
                                    if (filter.get(FilterName.LIGHTS).equals("")){
                                        пропускаем LIGHTS
                                        if (filter.get(FilterName.BATTERY) != null){
                                           if (filter.get(FilterName.BATTERY).equals("")){
                                               пропускаем BATTERY
                                               if (filter.get(FilterName.COLOR) != null){
                                                 if (filter.get(FilterName.COLOR).equals("")){
                                                     пропускаем COLOR!!!!
                                                 }else {
                                                     сравниваем COLOR!!!!
                                                 }
                                               }else {
                                                   return false;
                                               }
                                           }else {
                                               сравниваем BATTERY
                                               if (speedelec.getBatteryCapacity().equals(Integer.valueOf(filter.get(FilterName.BATTERY)))){
                                                   if (filter.get(FilterName.COLOR) != null){
                                                       if (filter.get(FilterName.COLOR).equals("")){
                                                           пропускаем COLOR!!!!
                                                       }else {
                                                           сравниваем COLOR!!!!
                                                       }
                                                   }else {
                                                       return false;
                                                   }
                                               }else {
                                                   return false;
                                               }
                                           }
                                        }else {
                                            return false;
                                        }
                                    }else {
                                        сравниваем LIGHTS
                                        if (speedelec.getLightsAtFrontAndBack().equals(Boolean.valueOf(filter.get(FilterName.LIGHTS)))){
                                            if (filter.get(FilterName.BATTERY) != null){
                                                if (filter.get(FilterName.BATTERY).equals("")){
                                                    пропускаем BATTERY
                                                    if (filter.get(FilterName.COLOR) != null){
                                                      if (filter.get(FilterName.COLOR).equals("")){
                                                          пропускаем COLOR!!!!
                                                      }else {
                                                          сравниваем COLOR!!!!
                                                      }
                                                    }else {
                                                        return false;
                                                    }
                                                }else {
                                                    сравниваем BATTERY
                                                    if (speedelec.getBatteryCapacity().equals(Integer.valueOf(filter.get(FilterName.BATTERY)))){
                                                        if (filter.get(FilterName.COLOR) != null){
                                                           if (filter.get(FilterName.COLOR).equals("")){
                                                               пропускаем COLOR!!!!
                                                           }else {
                                                               сравниваем COLOR!!!!
                                                           }
                                                        }else {
                                                            return false;
                                                        }
                                                    }else {
                                                        return false;
                                                    }
                                                }
                                            }else {
                                                return false;
                                            }
                                        }else {
                                            return false;
                                        }
                                    }
                                }else {
                                    return false;
                                }
                            }else {
                                сравниваем WEIGHT
                                if (speedelec.getWeight().equals(Integer.valueOf(filter.get(FilterName.WEIGHT)))){
                                    if (filter.get(FilterName.LIGHTS) != null){
                                        if (filter.get(FilterName.LIGHTS).equals("")){
                                            пропускаем LIGHTS
                                            if (filter.get(FilterName.BATTERY) != null){
                                              if (filter.get(FilterName.BATTERY).equals("")){
                                                  пропускаем BATTERY
                                                  if (filter.get(FilterName.COLOR) != null) {
                                                     if (filter.get(FilterName.COLOR).equals("")){
                                                         пропускаем COLOR!!!!
                                                     }else {
                                                         сравниваем COLOR!!!!
                                                     }
                                                  }else {
                                                      return false;
                                                  }
                                              }else {
                                                  сравниваем BATTERY
                                                  if (speedelec.getBatteryCapacity().equals(Integer.valueOf(filter.get(FilterName.BATTERY)))){
                                                      if (filter.get(FilterName.COLOR) != null){
                                                          if (filter.get(FilterName.COLOR).equals("")){
                                                              пропускаем COLOR!!!!
                                                          }else {
                                                              сравниваем COLOR!!!!
                                                          }
                                                      }else {
                                                          return false;
                                                      }
                                                  }else {
                                                      return false;
                                                  }
                                              }
                                            }else {
                                                return false;
                                            }
                                        }else {
                                            сравниваем LIGHTS
                                            if (speedelec.getLightsAtFrontAndBack().equals(Boolean.valueOf(filter.get(FilterName.LIGHTS)))){
                                                if (filter.get(FilterName.BATTERY) != null){
                                                    if (filter.get(FilterName.BATTERY).equals("")){
                                                        пропускаем BATTERY
                                                        if (filter.get(FilterName.COLOR) != null){
                                                          if (filter.get(FilterName.COLOR).equals("")){
                                                              пропускаем COLOR!!!!
                                                          }else {
                                                              сравниваем COLOR!!!!
                                                          }
                                                        }else {
                                                            return false;
                                                        }
                                                    }else {
                                                        сравниваем BATTERY
                                                        if (speedelec.getBatteryCapacity().equals(Integer.valueOf(filter.get(FilterName.BATTERY)))){
                                                            if (filter.get(FilterName.COLOR) != null){
                                                                if (filter.get(FilterName.COLOR).equals("")){
                                                                    пропускаем COLOR!!!!
                                                                }else {
                                                                    сравниваем COLOR!!!!
                                                                }
                                                            }else {
                                                                return false;
                                                            }
                                                        }else {
                                                            return false;
                                                        }
                                                    }
                                                }else {
                                                    return false;
                                                }
                                            }else {
                                                return false;
                                            }
                                        }
                                    }else {
                                        return false;
                                    }
                                }else {
                                    return false;
                                }
                            }
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}

