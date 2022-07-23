package pl.sda2.wateringplanner.wateringplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda2.wateringplanner.wateringplanner.model.Plant;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
    Plant findByName(String flowerName);
}
