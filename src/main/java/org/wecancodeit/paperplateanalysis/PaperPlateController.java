package org.wecancodeit.paperplateanalysis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class PaperPlateController {

    @Resource
    private CoatingTypeRepository coatingTypeRepo;

    @Resource
    private PaperPlateRepository paperPlateRepo;

    @RequestMapping("/paper-plates")
    public String displayPaperPlates(Model model){
        model.addAttribute("paperPlatesModel", paperPlateRepo.findAll());
        return "paperPlatesView";
    }

    @PostMapping("/add-plate")
    public String addPaperPlate(@RequestParam String brand , @RequestParam String description, @RequestParam String materialType){
    CoatingType coatingTypeToAdd;
    Optional<CoatingType> coatingTypeToAddOpt = coatingTypeRepo.findByMaterialType(materialType);

    //if the coating type doesnt exist lets add it to the database
    if(coatingTypeToAddOpt.isEmpty()){
        coatingTypeToAdd = new CoatingType(materialType);
        coatingTypeRepo.save(coatingTypeToAdd);
    //if the coating type already exists grab it from the database
    } else {
        coatingTypeToAdd = coatingTypeToAddOpt.get();
    }

    Optional<PaperPlate> paperPlateToAddOpt = paperPlateRepo.findByBrand(brand);

    if(paperPlateToAddOpt.isEmpty()){
        PaperPlate plateToAdd = new PaperPlate(brand, description, coatingTypeToAdd);
        paperPlateRepo.save(plateToAdd);
    }
        return "redirect:/paper-plates/";
    }


    @GetMapping("/coating-types/{materialType}")
    public String displaySingleCoatingType(@PathVariable String materialType, Model model){
        Optional<CoatingType> retrievedCoatingType = coatingTypeRepo.findByMaterialType(materialType);
        model.addAttribute("coatingTypeModel", retrievedCoatingType.get());
        return "coatingTypeView";
    }


}
