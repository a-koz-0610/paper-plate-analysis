package org.wecancodeit.paperplateanalysis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PaperPlate {

    @Id
    @GeneratedValue
    private Long id;

    private String brand;
    private String description;
    private CoatingType coating;

    public Long getId(){
        return id;
    }

    public String getBrand(){
        return brand;
    }

    public String getDescription(){
        return description;
    }

    public CoatingType getCoating(){
        return coating;
    }

    protected PaperPlate(){}

    public PaperPlate(String brand, String description, CoatingType coating) {
        this.brand = brand;
        this.description = description;
        this.coating = coating;
    }
}
