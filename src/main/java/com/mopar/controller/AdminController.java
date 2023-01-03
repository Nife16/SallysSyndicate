package com.mopar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mopar.entity.Sapp;
import com.mopar.entity.Whip;
import com.mopar.service.SappService;
import com.mopar.service.WhipService;

@Controller
public class AdminController {
    
    @Autowired
    SappService sappService;

    @Autowired
    WhipService whipService;


    @GetMapping("/admin-tool")
    public String adminTool(Model model, HttpSession session) {

        Integer adminId = (Integer) session.getAttribute("loggedInSappId");

        if(adminId != null) {
            Sapp admin = sappService.findSappById(adminId);

            if(!admin.getRole().equals("ROLE_ADMIN")) {
                return "redirect:signIn";
            }

            model.addAttribute("admin", admin);
        }

        return "sallys-tool";
    }

    @GetMapping("/reports")
    public String reports(Model model, HttpSession session) {

        Integer adminId = (Integer) session.getAttribute("loggedInSappId");

        if(adminId != null) {
            Sapp admin = sappService.findSappById(adminId);

            if(!admin.getRole().equals("ROLE_ADMIN")) {
                return "redirect:signIn";
            }

            model.addAttribute("admin", admin);

            List<Sapp> whipPurchasers = sappService.getSappPurchasers();

            model.addAttribute("sappList", whipPurchasers);

            List<Whip> whips = whipService.getAllBoughtWhips();

            model.addAttribute("purchasedWhips", whips);
        }

        return "reports";
    }
    

    @GetMapping("/reports/{sappId}")
    public String reports(Model model, HttpSession session, @PathVariable Integer sappId) {

        Integer adminId = (Integer) session.getAttribute("loggedInSappId");

        if(adminId != null) {
            Sapp admin = sappService.findSappById(adminId);

            if(!admin.getRole().equals("ROLE_ADMIN")) {
                return "redirect:signIn";
            }

            model.addAttribute("admin", admin);

            List<Sapp> whipPurchasers = sappService.getSappPurchasers();

            model.addAttribute("sappList", whipPurchasers);

            Sapp focusSapp = sappService.findSappById(sappId);

            model.addAttribute("focusSapp", focusSapp);

            model.addAttribute("purchasedWhips", focusSapp.getGarage());
        }

        return "reports";
    }

    @GetMapping("/addWhips")
    public String addWhips(Model model, HttpSession session) {

        Integer adminId = (Integer) session.getAttribute("loggedInSappId");

        if(adminId != null) {
            Sapp admin = sappService.findSappById(adminId);

            if(!admin.getRole().equals("ROLE_ADMIN")) {
                return "redirect:signIn";
            }

            model.addAttribute("admin", admin);
        }

        model.addAttribute("whip", new Whip());

        return "addWhips";
    }

    @PostMapping("/addWhips")
    public String addWhips(@ModelAttribute Whip newWhipForLot, Model model) {

        try {
            whipService.createWhip(newWhipForLot);
            model.addAttribute("whip", new Whip());
            model.addAttribute("createdMessage", "A new whip has appeared on the lot!");
            return "addWhips";
        } catch(Exception e) {
            model.addAttribute("whip", new Whip());
            model.addAttribute("message", "An error has occured.");
            return "addWhips";
        } catch(Error e) {
            model.addAttribute("whip", new Whip());
            model.addAttribute("message", "An error has occured.");
            return "addWhips";
        }

    }
}
