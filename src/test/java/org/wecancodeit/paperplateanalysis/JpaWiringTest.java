package org.wecancodeit.paperplateanalysis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void paperPlateCoatingTypeShouldReturnAListOfPaperPlates(){
        CoatingType coated = new CoatingType("coated");
    }


}
