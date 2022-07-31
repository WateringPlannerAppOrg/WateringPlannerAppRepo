package pl.sda2.wateringplanner.wateringplanner.service;

import pl.sda2.wateringplanner.wateringplanner.model.Plant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PlantServiceInMemory implements PlantService {

    private List<Plant> plants = new ArrayList<>();

    public PlantServiceInMemory() {
        plants.add(new Plant(1, "Dracena", "Moja Dracenka",
                "dużo, 1 w tyg.",
                LocalDate.of(2021, 06, 10), LocalDate.of(2022,07,22),LocalDate.of(2022,07,26),true
        ));
        plants.add(new Plant(2, "Dracena", "Dracena w przedpokoju",
                "mało 2 w tyg.",
                LocalDate.of(2020, 12, 24), LocalDate.of(2022,07,22),LocalDate.of(2022,07,24),false
        ));
        plants.add(new Plant(3, "Katus", "mały Kaktus",
                "mało 1 w tyg.",
                LocalDate.of(2022,07,13), LocalDate.of(2022,07,24),LocalDate.of(2022,07,29),false
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

    }

    @Override
    public void deleteById(Integer id) {
      plants.removeIf(p-> p.getId().equals(id));



    }

    @Override
    public void waterIt(Integer plantId) {
      plants.stream()
              .filter(p -> p.getId().equals(plantId))
              .forEach(p-> p.waterIt());

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
    @Override
    public void wateringDate(Integer id) {
        plants.stream()
                .filter(p-> p.getId().equals(id))
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                .waterIt();

    }

}
