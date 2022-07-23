package pl.sda2.wateringplanner.wateringplanner.service;

import pl.sda2.wateringplanner.wateringplanner.model.Plant;

import java.util.List;

public interface PlantService {

    void save(Plant plant);

    List<Plant> getAll();

    void deleteByName(String flowerName);

    void deleteById(Integer Id);

    void waterIt(Integer plantId);

    Plant getById(Integer id);

    Plant getByName(String flowerName);
}

