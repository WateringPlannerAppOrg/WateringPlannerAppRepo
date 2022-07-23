package pl.sda2.wateringplanner.wateringplanner.service.impl;

import org.springframework.stereotype.Service;
import pl.sda2.wateringplanner.wateringplanner.model.Plant;
import pl.sda2.wateringplanner.wateringplanner.repository.PlantRepository;
import pl.sda2.wateringplanner.wateringplanner.service.PlantService;

import java.util.List;
@Service
public class PlantServiceImpl implements PlantService {


        private final PlantRepository plantRepository;

        public PlantServiceImpl(PlantRepository plantRepository){
            this.plantRepository= plantRepository;

        }

        @Override
        public void save(Plant plant){
            plantRepository.save(plant);

        }
        @Override
        public List<Plant> getAll() {
            return plantRepository.findAll();
        }


    @Override
        public void deleteByName(String flowerName) {
            Plant plant = getByFlowerName(flowerName);
            plantRepository.deleteById(plant.getId());

        }

        @Override
        public void deleteById(Integer Id) {

        }

        @Override
        public void update(Plant plant) {
            plantRepository.save(plant);

        }



        @Override
        public Plant getById(Integer id) {
            return plantRepository.findById(id).orElse(null);
        }

    @Override
    public Plant getByName(String flowerName) {
        return null;
    }


    @Override
        public Plant getByFlowerName(String flowerName) {
            return plantRepository.findByName(flowerName);
        }
    }


