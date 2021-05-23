package org.wecancodeit.paperplateanalysis;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private CoatingTypeRepository coatingTypeRepo;

    @Resource
    private PaperPlateRepository paperPlateRepo;


    @Override
    public void run(String... args) throws Exception {

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
        
    }
}
