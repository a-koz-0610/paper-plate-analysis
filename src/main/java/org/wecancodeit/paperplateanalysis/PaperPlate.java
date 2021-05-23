package org.wecancodeit.paperplateanalysis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class PaperPlate {

    @Id
    @GeneratedValue
    private Long id;

    private String brand;
    private String description;

    @ManyToOne
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperPlate that = (PaperPlate) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
