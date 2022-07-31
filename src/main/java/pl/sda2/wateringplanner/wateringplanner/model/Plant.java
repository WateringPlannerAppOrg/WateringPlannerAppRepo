package pl.sda2.wateringplanner.wateringplanner.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Plant {

    private Integer id;
    private String species;
    private String name;
    private String caringDescription;
    private LocalDate wateringDate;
    private LocalDate lastWatering;
    private LocalDate nextWatering;
    boolean wet;
    public void waterIt() { this.wet = true;
        this.wateringDate = LocalDate.now();

    }
}
