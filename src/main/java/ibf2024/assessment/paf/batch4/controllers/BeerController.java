package ibf2024.assessment.paf.batch4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2024.assessment.paf.batch4.repositories.BeerRepository;

@Controller
@RequestMapping
public class BeerController {

	@Autowired
	BeerRepository beerRepo;

	//TODO Task 2 - view 0
	@GetMapping(path = {"/","/index","/view0"})
	public String login(Model model) {
		model.addAttribute("styles", beerRepo.getStyles());
        return "view0";
    }
	
	//TODO Task 3 - view 1
	

	//TODO Task 4 - view 2

	
	//TODO Task 5 - view 2, place order

}
