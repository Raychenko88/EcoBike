package com.ecobike.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class FilterHandler {

    private Map<FilterName, String> filter = new HashMap<>();

}
