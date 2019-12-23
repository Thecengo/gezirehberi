package com.uniyaz.service;

import com.uniyaz.domain.Place;

import java.util.List;

public interface PlaceService {

    public Place savePlace(Place place);
    public List<Place> getAllPlaces();
    public List<Place> getPlacesByName(String name);
    public List<Place> getTreePlacesOrderByMaxPoint();
}
