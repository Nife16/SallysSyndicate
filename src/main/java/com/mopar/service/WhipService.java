package com.mopar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mopar.entity.Whip;
import com.mopar.repo.WhipRepo;

@Service
public class WhipService {

    @Autowired
    WhipRepo whipRepo;

    public Whip save(Whip whip) {
        return whipRepo.save(whip);
    }

    public List<Whip> getWhipsOnLot() {
        return whipRepo.getWhipsOnLot();
    }

    public Whip findWhipById(Integer id) {
        return whipRepo.findById(id).get();
    }
    
}
