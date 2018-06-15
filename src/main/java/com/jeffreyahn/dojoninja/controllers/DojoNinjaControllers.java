package com.jeffreyahn.dojoninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeffreyahn.dojoninja.models.Dojo;
import com.jeffreyahn.dojoninja.models.Ninja;
import com.jeffreyahn.dojoninja.services.DojoNinjaService;

@Controller
public class DojoNinjaControllers {
	private final DojoNinjaService dojoNinjaService;
	public DojoNinjaControllers(DojoNinjaService dojoNinjaService) {
		this.dojoNinjaService = dojoNinjaService;
	}
	@RequestMapping("/dojos/new")
	public String dojos(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojoNinja/dojoNew.jsp";
	}
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojoNinja/dojoNew.jsp";
		}
		dojoNinjaService.createDojo(dojo);
		return "redirect:/dojos/new";

	}
	@RequestMapping("/ninjas/new")
	public String ninjas(@ModelAttribute("ninja") Ninja thisNinja, Model model) {
		model.addAttribute("dojos", dojoNinjaService.findDojo());
		return "/dojoNinja/ninjaNew.jsp";
	}
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojoNinja/ninjaNew.jsp";
		}
		Long dojo_id = ninja.getDojo().getId();
		dojoNinjaService.createNinja(ninja);
		return "redirect:/dojos/"+ Long.toString(dojo_id);
	}
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model ) {
		Dojo dojo = dojoNinjaService.findDojoById(id);
		List<Ninja> ninjas = dojoNinjaService.findByDojo(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", ninjas);
		return "/dojoNinja/show.jsp";
	}
}
