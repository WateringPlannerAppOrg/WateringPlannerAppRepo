package pl.sda2.wateringplanner.wateringplanner.service;

import pl.sda2.wateringplanner.wateringplanner.model.Plant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PlantServiceInMemory implements PlantService {

    private List<Plant> plants = new ArrayList<>();

    public PlantServiceInMemory() {
        plants.add(new Plant(1, "Dracena", "Moja Dracenka",
                "Podlewanie 1-2 w tyg.",
                LocalDate.now(), true
        ));
        plants.add(new Plant(2, "Dracena", "Dracena w przedpokoju",
                "Podlewanie 1-2 w tyg.",
                LocalDate.now(), false
        ));
    }

    @Override
    public void save(Plant plant) {
        plants.add(plant);
    }

    @Override
    public List<Plant> getAll() {
        return plants;
    }

    @Override
    public void deleteByName(String flowerName) {
        plants.removeIf(p-> p.getName().equals(flowerName));

        // TODO:
    }

    @Override
    public void deleteById(Integer id) {
      plants.removeIf(p-> p.getId().equals(id));


        // TODO
    }

    @Override
    public void waterIt(Integer plantId) {
      plants.stream()
              .filter(p -> p.getId().equals(plantId))
              .forEach(p-> p.waterIt());
        // TODO: 1. Przeszukać listę i znależc roślinę o id plantId
        // TODO  2. plant.waterYourself()

    }

    @Override
    public Plant getById(Integer id) {
        return plants
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public Plant getByName(String flowerName) {
        return null;
    }
}
