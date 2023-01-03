package com.mopar.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mopar.entity.Sapp;
import com.mopar.entity.Whip;
import com.mopar.repo.SappRepo;

@Service
public class SappService {

    @Autowired
    SappRepo sappRepo;
    @Autowired
    WhipService whipService;

    public Sapp save(Sapp sapp) {
        return sappRepo.save(sapp);
    }
    
    public Sapp findByEmailAndPassword(Sapp sapp) throws Exception {
        Sapp loggedInSapp = sappRepo.findByEmailAndPassword(sapp.getSappname(), sapp.getPassword());
        if(loggedInSapp == null) {
            throw new Exception("User not found");
        }
        return loggedInSapp;
    }

    public Sapp findSappById(Integer sappId) {
        return sappRepo.findById(sappId).get();
    }

    public List<Sapp> findAllSapps() {
        return sappRepo.findAll();
    }

    public Sapp buyWhip(Integer sappId, String vin) {

        Sapp loggedInSapp = findSappById(sappId);

        Whip whip = whipService.getWhipByVin(vin);

        whip.setPurchaseDate(LocalDateTime.now());

        loggedInSapp.getGarage().add(whip);

        return save(loggedInSapp);
    }

    public List<Sapp> getSappPurchasers() {


        List<Sapp> allUsers = findAllSapps();

        List<Sapp> purchasers = new ArrayList<Sapp>();
        for (Sapp sapp : allUsers) {
            if(!sapp.getGarage().isEmpty()) {
                purchasers.add(sapp);
            }
        }

        return purchasers;

    }
    
}
