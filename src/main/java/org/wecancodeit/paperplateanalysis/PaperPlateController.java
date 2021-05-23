package org.wecancodeit.paperplateanalysis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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

}
