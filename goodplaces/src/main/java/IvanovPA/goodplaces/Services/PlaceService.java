package IvanovPA.goodplaces.Services;

import IvanovPA.goodplaces.Entities.Place;

import java.util.List;

public interface PlaceService {
    Place addPlace(Place place);
    List<Place> getAllPlaces();
    Place getPlace (Long id);
}
