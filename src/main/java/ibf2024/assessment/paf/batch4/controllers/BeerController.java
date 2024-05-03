package ibf2024.assessment.paf.batch4.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2024.assessment.paf.batch4.models.Brewery;
import ibf2024.assessment.paf.batch4.repositories.BeerRepository;

@Controller
@RequestMapping
public class BeerController {

	@Autowired
	BeerRepository beerRepo;

	//TODO HANDLE IF NO BREWERY/NOBEER ETC FOUND ALL

	//TODO Task 2 - view 0
	@GetMapping(path = {"/","/index","/view0"})
	public String view0(Model model) {
		model.addAttribute("styles", beerRepo.getStyles());
        return "view0";
    }
	
	//TODO Task 3 - view 1
	@GetMapping(path = "/beer/style/{id}")
	public String view1(Model model, @PathVariable("id") String id, @RequestParam String styleName) {
		model.addAttribute("beerdetaillist", beerRepo.getBreweriesByBeer(id));
		model.addAttribute("styleName", styleName);
		return "view1";
	}

	//TODO Task 4 - view 2
	@GetMapping(path = "/beer/brewery/{id}")
	public String view2(Model model, @PathVariable("id") int id, @RequestParam String breweryName) {
		Optional<Brewery> opt = beerRepo.getBeersFromBrewery(id);

		if (!opt.isPresent()) {
			return "brewerynotfound";
		}

		model.addAttribute("brewery", opt.get());
		model.addAttribute("breweryName", breweryName);
		return "view2";
	}

	
	//TODO Task 5 - view 2, place order 
	@PostMapping(path = "/brewery/{id}/order")
	public String processOrder(Model model, @RequestBody MultiValueMap<String,Integer> form) {

		System.out.println(form.size());
		for (String x : form.keySet()){
			System.out.println("key : " + x);
			System.out.println(form.get(x));
		}
		
		return "view3";
	}

}
