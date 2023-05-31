package IvanovPA.goodplaces.Services.impl;

import IvanovPA.goodplaces.Entities.Place;
import IvanovPA.goodplaces.Repositories.PlaceRepository;
import IvanovPA.goodplaces.Services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceRepository placeRepository;
    @Override
    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public Place getPlace(Long id) {
        return placeRepository.findAllById(id);
    }
}
