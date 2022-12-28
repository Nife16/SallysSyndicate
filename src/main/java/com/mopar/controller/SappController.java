package com.mopar.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mopar.entity.Sapp;
import com.mopar.service.SappService;

@Controller
public class SappController {

    @Autowired
    SappService sappService;
    
    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        
        Integer loggedInSappId = (Integer) session.getAttribute("loggedInSappId");

        if(loggedInSappId != null) {
            Sapp loggedInSapp = sappService.findSappById(loggedInSappId);
            model.addAttribute("sapp", loggedInSapp);
        }
        return "home";
    }

    @GetMapping("/signUp")
    public String signUp(Model model) {

        model.addAttribute("sapp", new Sapp());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute Sapp sapp, Model model) {

        try {
            sappService.save(sapp);
        } catch (Exception e) {
            System.out.println("error => " + e.getMessage());
            model.addAttribute("sapp", new Sapp());
            model.addAttribute("message", "error on sign up");
            return "signUp";
        } catch (Error e) {
            System.out.println("error => " + e.getMessage());
            model.addAttribute("sapp", new Sapp());
            model.addAttribute("message", "error on sign up");
            return "signUp";
        }
        model.addAttribute("sapp", new Sapp());

        return "signIn";

    }
    
    @GetMapping("/signIn")
    public String signIn(Model model) {

        model.addAttribute("sapp", new Sapp());
        return "signIn";
    }

    @PostMapping("/signIn")
    public String signIn(@ModelAttribute Sapp sapp, Model model, HttpSession session) {
        Sapp loggedInSapp = null;
        try {
            loggedInSapp = sappService.findByEmailAndPassword(sapp);
        } catch (Exception e) {
            System.out.println("error => " + e.getMessage());
            model.addAttribute("sapp", new Sapp());
            model.addAttribute("message", "error on login");
            return "signIn";
        } catch (Error e) {
            System.out.println("error => " + e.getMessage());
            model.addAttribute("sapp", new Sapp());
            model.addAttribute("message", "error on login");
            return "signIn";
        }

        session.setAttribute("loggedInSappId", loggedInSapp.getId());

        model.addAttribute("loggedInSapp", loggedInSapp);

        return "home";

    }

}
