package com.mopar.service;

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
    
    public Sapp findByEmailAndPassword(Sapp sapp) {
        return sappRepo.findByEmailAndPassword(sapp.getSappname(), sapp.getPassword());
    }

    public Sapp findSappById(Integer sappId) {
        return sappRepo.findById(sappId).get();
    }

    public List<Sapp> findAllSapps() {
        return sappRepo.findAll();
    }

    public Sapp buyWhip(Integer sappId, Integer whipId) {

        Sapp loggedInSapp = findSappById(sappId);

        Whip whip = whipService.findWhipById(whipId);

        loggedInSapp.getGarage().add(whip);

        return save(loggedInSapp);
    }
    
}
