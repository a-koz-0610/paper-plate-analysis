package org.wecancodeit.paperplateanalysis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CoatingType {

    @Id
    @GeneratedValue
    private Long id;

    private String materialType;

    public Long getId(){
        return id;
    }

    public String getMaterialType(){
        return materialType;
    }

    public CoatingType(String materialType) {
        this.materialType = materialType;
    }
}
