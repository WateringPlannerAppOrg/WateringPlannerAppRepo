package pl.sda2.wateringplanner.wateringplanner.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda2.wateringplanner.wateringplanner.model.Plant;
import pl.sda2.wateringplanner.wateringplanner.service.PlantService;
import pl.sda2.wateringplanner.wateringplanner.service.PlantServiceInMemory;


@Slf4j
@Controller
public class PlantController {
    private final PlantService plantService;

    public PlantController() {
        this.plantService = new PlantServiceInMemory();
    }

    @GetMapping("/plants/list")
    public String plantList(ModelMap modelMap) {
        modelMap.addAttribute("plants", plantService.getAll());
        return "plant-list";
    }

    @GetMapping("/plants/create")
    public String showCreatePlantForm (ModelMap modelMap ) {
     modelMap.addAttribute("empty Plant", new Plant());
    return "plant-create";
    }
    @PostMapping(path = "/plants/save")
    public String handleNewPlant (@ModelAttribute ("empty Plant") Plant plant) {
        log.info("Handle new plant" + plant);

        plantService.save(plant);
        return "redirect:/plants/list";
    }
    public String plantDetails(@PathVariable String flowerName, ModelMap modelMap) {
        modelMap.addAttribute("plant", plantService.getByName(flowerName));
        return "plant-details";
    }
}
