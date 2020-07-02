package com.ecobike.repository;

import com.ecobike.model.DomainObject;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
public class CollectionBike {

    public static Set<DomainObject> foldingBikes = Collections.synchronizedSet(new HashSet<>());
    public static Set<DomainObject> electricBikes = Collections.synchronizedSet(new HashSet<>());
    public static Set<DomainObject> speedelecs = Collections.synchronizedSet(new HashSet<>());

    public static Set<DomainObject> filtered = Collections.synchronizedSet(new HashSet<>());

}
