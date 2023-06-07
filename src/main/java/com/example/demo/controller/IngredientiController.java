package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.pojo.Ingredienti;
import com.example.demo.pojo.Pizza;
import com.example.demo.service.IngredientiService;

import jakarta.validation.Valid;

@Controller
public class IngredientiController {

	@Autowired
	IngredientiService ingredientiService;
	
	
	@GetMapping("/admin/ingredienti")
	public String index(Model model) {
		
		List<Ingredienti> ingredienti = ingredientiService.findAll();
		
		model.addAttribute("ingredienti", ingredienti);
		
		return "ingredientiIndex";
	}
	
	@GetMapping("/admin/ingredienti/create")
	public String createIngredienti(Model model) {
		
		model.addAttribute("ingredienti",new Ingredienti());
		
		return "createFormIngredienti";
	}
	
	@PostMapping("/admin/ingredienti/create")
	public String storeIngredienti(@Valid @ModelAttribute Ingredienti ingredienti, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			
//			for(ObjectError err : bindingResult.getAllErrors()) {
//				System.out.println(err.getDefaultMessage());
//			}
			
			model.addAttribute("ingredienti",ingredienti);
			model.addAttribute("errori",bindingResult);
			
			return "createFormIngredienti";
		}
		
		
		ingredientiService.save(ingredienti);
		
		return "redirect:/user/pizza";
	}
	
	
	@GetMapping("/admin/ingredienti/delete/{id}")
	public String deleteIngredienti(
			@PathVariable int id
		) {
		
		Optional<Ingredienti> ingredientiOpt = ingredientiService.findById(id);
		Ingredienti ingredienti = ingredientiOpt.get();
		
		if(ingredienti.getPizze().size() != 0) {
			
			for(Pizza p : ingredienti.getPizze()) {
				
				p.getIngredienti().remove(ingredienti);
				
			}
			
		}
		
		ingredientiService.deleteIngredienti(ingredienti);
		
		return "redirect:/user/pizza";
	}
	

	@GetMapping("/admin/ingredienti/update/{id}")
	public String editIngredienti(
			Model model,
			@PathVariable int id
		) {
		
		Optional<Ingredienti> ingredientiOpt = ingredientiService.findById(id);
		Ingredienti ingredienti = ingredientiOpt.get();
		model.addAttribute("ingredienti", ingredienti);
		
		return "updateFormIngredienti";
	}
	@PostMapping("/admin/ingredienti/update/{id}")
	public String updateIngredienti(
			  @Valid
		      @ModelAttribute Ingredienti ingredienti,
		      BindingResult bindingResult,
		      @PathVariable int id,
		      Model model
			
			
		) {
		
		
		if(bindingResult.hasErrors()) {
			
			
			
			model.addAttribute("ingredienti",ingredienti);
			model.addAttribute("errori",bindingResult);
			
			return "updateFormIngredienti";
		}
		
		
		
		ingredientiService.save(ingredienti);
		
		return "redirect:/user/pizza";
	}
	
	
}

