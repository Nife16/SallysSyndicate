package com.mopar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mopar.entity.Sapp;
import com.mopar.entity.Whip;
import com.mopar.service.SappService;
import com.mopar.service.WhipService;

@Controller
public class WhipController {

    @Autowired
    SappService sappService;
    @Autowired
    WhipService whipService;

    @GetMapping("/whips")
    public String showLot(Model model, HttpSession session) {

        Integer loggedInSappId = (Integer) session.getAttribute("loggedInSappId");

        if (loggedInSappId != null) {

            Sapp loggedInSapp = sappService.findSappById(loggedInSappId);

            List<Whip> whipsOnLot = whipService.getWhipsOnLot();
            List<String> listOfMakes = whipService.getListOfMakes(whipsOnLot);

            model.addAttribute("loggedInSapp", loggedInSapp);
            model.addAttribute("whipsOnLot", whipsOnLot);
            model.addAttribute("filterList", listOfMakes);
            model.addAttribute("activeFilter", "Make");

            return "whips";
        }

        // redirects you to the homepage, this will change your url so it wont be on
        // whips anymore
        return "redirect:";

    }

    @GetMapping("/whipsByMake/{make}")
    public String whipsByMake(@PathVariable String make, Model model, HttpSession session) {

        Integer loggedInSappId = (Integer) session.getAttribute("loggedInSappId");

        if (loggedInSappId != null) {

            Sapp loggedInSapp = sappService.findSappById(loggedInSappId);

            List<Whip> whipsOnLot = whipService.getWhipsOnLotByMake(make);
            List<String> listOfMakes = whipService.getListOfModels(whipsOnLot);

            model.addAttribute("loggedInSapp", loggedInSapp);
            model.addAttribute("whipsOnLot", whipsOnLot);
            model.addAttribute("filterList", listOfMakes);
            model.addAttribute("activeFilter", "Model");
            model.addAttribute("activeMake", make);

            return "whips";
        }

        // redirects you to the homepage, this will change your url so it wont be on
        // whips anymore
        return "redirect:";
    }

    @GetMapping("/whipsByModel/{carMake}/{carModel}")
    public String whipsByModel(@PathVariable("carMake") String carMake, @PathVariable("carModel") String carModel, Model model, HttpSession session) {

        Integer loggedInSappId = (Integer) session.getAttribute("loggedInSappId");

        if (loggedInSappId != null) {

            Sapp loggedInSapp = sappService.findSappById(loggedInSappId);

            List<Whip> whipsOnLot = whipService.getWhipsOnLotByModel(carMake, carModel);
            List<String> listOfMakes = whipService.getListOfModels(whipsOnLot);

            model.addAttribute("loggedInSapp", loggedInSapp);
            model.addAttribute("whipsOnLot", whipsOnLot);
            model.addAttribute("filterList", listOfMakes);
            model.addAttribute("activeFilter", "Reset");

            return "whips";
        }

        // redirects you to the homepage, this will change your url so it wont be on
        // whips anymore
        return "redirect:";
    }

    @GetMapping("/whipDetailPage/{vin}")
    public String whipDetailPage(@PathVariable String vin, Model model, HttpSession session) {

        Integer loggedInSappId = (Integer) session.getAttribute("loggedInSappId");

        if (loggedInSappId != null) {

            Sapp loggedInSapp = sappService.findSappById(loggedInSappId);

            Whip whip = whipService.getWhipByVin(vin);

            model.addAttribute("loggedInSapp", loggedInSapp);
            model.addAttribute("whip", whip);

            return "whipDetailPage";
        }

        // redirects you to the homepage, this will change your url so it wont be on
        // whips anymore
        return "redirect:";
    }

    @PostMapping("/whipDetailPage/{vin}")
    public String buyVehicle(@PathVariable String vin, Model model, HttpSession session) {

        Integer loggedInSappId = (Integer) session.getAttribute("loggedInSappId");

        if (loggedInSappId != null) {

            Sapp loggedInSapp = sappService.buyWhip(loggedInSappId, vin);

            model.addAttribute("loggedInSapp", loggedInSapp);

            return "redirect:/whips";
        }

        // redirects you to the homepage, this will change your url so it wont be on
        // whips anymore
        return "redirect:";
    }
}
