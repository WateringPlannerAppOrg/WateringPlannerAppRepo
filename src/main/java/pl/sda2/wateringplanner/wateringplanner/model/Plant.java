package pl.sda2.wateringplanner.wateringplanner.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@Entity

public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer id;

    private String flowerSpecies;

    private String flowerName;

    private String caringFlowerDescription;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate bringHomeTime;

}



