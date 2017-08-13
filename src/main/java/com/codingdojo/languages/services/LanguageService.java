package com.codingdojo.languages.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;

@Service
public class LanguageService {
	public ArrayList<Language> languages = new ArrayList(Arrays.asList(
			new Language("Java", "James Gosling", "1.8"),
			new Language("Python", "Guido von Rossum", "3.6"),
			new Language("JavaScript", "Brendon Eich", "1.9.5.2.3.247.2")
			));
	public ArrayList<Language> alllanguages(){
		return languages;
	}
	
	public Language findLanguageByIndex(int index) {
		if (index < languages.size()) {
			return languages.get(index);
		}
		else {
			return null;
		}
	}
	
	public void addLanguage(Language language) {
		languages.add(language);
	}
	
	public void updateLanguage(int id, Language language) {
	    if (id < languages.size()){
	         languages.set(id, language);
	    }
	}
	
	public void destroyLanguage(int id) {
        if (id < languages.size()){
           languages.remove(id);
        }
    }
	
}
