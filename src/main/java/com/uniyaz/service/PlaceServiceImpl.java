package com.uniyaz.service;

import com.uniyaz.dao.PlaceDao;
import com.uniyaz.domain.Place;

import java.util.List;

public class PlaceServiceImpl implements PlaceService {

    private PlaceDao placeDao;

    public PlaceServiceImpl(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    @Override
    public Place savePlace(Place place) {
        return placeDao.savePlace(place);
    }

    @Override
    public List<Place> getAllPlaces() {
        return placeDao.getAllPlaces();
    }

    @Override
    public List<Place> getPlacesByName(String name) {
        return placeDao.getPlacesByName(name);
    }

    @Override
    public List<Place> getTreePlacesOrderByMaxPoint() {
        return placeDao.getTreePlacesOrderByMaxPoint();
    }


}
