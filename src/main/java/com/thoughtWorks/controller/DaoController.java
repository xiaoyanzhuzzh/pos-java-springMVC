package com.thoughtWorks.controller;

import com.thoughtWorks.service.DaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dao")
public class DaoController {
    @Autowired
    private DaoService daoService;

	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        String mess = daoService.getItem();
		model.addAttribute("message", mess);
		return "hello";
	}
}