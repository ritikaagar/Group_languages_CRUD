package com.codingdojo.languages.controllers;

import java.util.ArrayList;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class Languages {
	private final LanguageService languageService;
	public Languages(LanguageService languageService) {
		this.languageService = languageService;
	}

	
	@RequestMapping("/languages")
	public String languages(Model model, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		ArrayList<Language> languages = languageService.alllanguages();
		model.addAttribute("languages", languages);
		return "languages.jsp";
	}
	
	@RequestMapping("/languages/{index}")
	public String findLanguageByIndex(Model model, @PathVariable("index") int index) {
		Language language = languageService.findLanguageByIndex(index);
		model.addAttribute("language", language);
		return "showLanguage.jsp";
	}
	
	@PostMapping("/languages/new")
	public String newLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/languages";
		}
		else {	
			//Add the language
			languageService.addLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@PostMapping("/languages/edit/{id}")
    public String updateLanguage(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "editLanguage.jsp";
        }else{
            languageService.updateLanguage(id, language);
            return "redirect:/languages";
        }
    }
	
	@RequestMapping("/languages/edit/{id}")
	  public String updated(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result){
		return "editLanguage.jsp";
	}
	
	@RequestMapping(value="/languages/delete/{id}")
    public String destroyLanguage(@PathVariable("id") int id) {
        languageService.destroyLanguage(id);
        return "redirect:/languages";
    }
	
}
