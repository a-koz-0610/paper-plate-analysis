package org.wecancodeit.paperplateanalysis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.annotation.Resource;

@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Resource
    private CoatingTypeRepository coatingTypeRepo;

    @Test
    public void paperPlateCoatingTypeShouldReturnAListOfPaperPlates(){
        CoatingType coated = new CoatingType("coated");
        coatingTypeRepo.save(coated);

        PaperPlate plate1 = new PaperPlate("glad", "very happy product", coated);
        PaperPlate plate2 = new PaperPlate("hefty", "mucho mucho macho", coated);
    }


}
