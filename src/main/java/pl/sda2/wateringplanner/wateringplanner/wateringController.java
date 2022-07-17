package pl.sda2.wateringplanner.wateringplanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class wateringController {


    @GetMapping("/")
    public String index() {
        return "index";
    }
}
