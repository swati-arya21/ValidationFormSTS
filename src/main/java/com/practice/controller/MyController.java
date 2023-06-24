package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.entities.LoginData;

import jakarta.validation.Valid;

@Controller
public class MyController {
	@GetMapping("/form")
	public String openForm(Model m)
	{
		System.out.println("Form Page run");
		m.addAttribute("loginData", new LoginData());
		return "formpage";
	}
	
	//handler for proccess form
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData")LoginData loginData, BindingResult result)
	{
		System.out.println(loginData);
		if(result.hasErrors())
		{
			System.out.println(result);
			return "form";
		}
		return "success";
	}
	

}
