package org.wecancodeit.paperplateanalysis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class CoatingType {

    @Id
    @GeneratedValue
    private Long id;

    private String materialType;

    //look for the name of the column of the OWNING TABLE
    @OneToMany(mappedBy = "coating")
    private Collection<PaperPlate> paperPlates;

    public Long getId(){
        return id;
    }

    public String getMaterialType(){
        return materialType;
    }

    public Collection<PaperPlate> getPaperPlates() {
        return paperPlates;
    }

    //why JPA why!!!!!!!!
    protected CoatingType(){};

    public CoatingType(String materialType) {
        this.materialType = materialType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoatingType that = (CoatingType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
