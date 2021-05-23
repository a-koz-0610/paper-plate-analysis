package org.wecancodeit.paperplateanalysis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.annotation.Resource;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Resource
    private CoatingTypeRepository coatingTypeRepo;

    @Resource
    private PaperPlateRepository paperPlateRepo;

    @Test
    public void paperPlateCoatingTypeShouldReturnAListOfPaperPlates(){
        CoatingType coated = new CoatingType("coated");
        CoatingType uncoated = new CoatingType("uncoated");
        coatingTypeRepo.save(coated);
        coatingTypeRepo.save(uncoated);

        PaperPlate plate1 = new PaperPlate("glad", "very happy product", coated);
        PaperPlate plate2 = new PaperPlate("hefty", "mucho mucho macho", coated);
        PaperPlate plate3 = new PaperPlate("great value", "soggy and crumbling", uncoated);
        paperPlateRepo.save(plate1);
        paperPlateRepo.save(plate2);
        paperPlateRepo.save(plate3);

        //makes sure sql/dbs are clean and aligned
        entityManager.flush();
        entityManager.clear();

        //does object coated exist in our database?
        Optional<CoatingType> foundCoatingTypeOpt = coatingTypeRepo.findById(coated.getId());
        CoatingType foundCoatingType = foundCoatingTypeOpt.get();

        assertThat(foundCoatingType.getPaperPlates()).contains(plate1, plate2);
    }


}
