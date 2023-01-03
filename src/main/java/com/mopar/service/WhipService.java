package com.mopar.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mopar.entity.Whip;
import com.mopar.repo.WhipRepo;

@Service
public class WhipService {

    @Autowired
    WhipRepo whipRepo;

    public Whip createWhip(Whip whip) {

        whip.setCreateDate(LocalDateTime.now());

        return whipRepo.save(whip);
    }

    public Whip save(Whip whip) {
        return whipRepo.save(whip);
    }

    public List<Whip> getAllBoughtWhips() {
        return whipRepo.getAllBoughtWhips();
    }

    public List<Whip> getWhipsOnLot() {
        return whipRepo.getWhipsOnLot();
    }

    public List<Whip> getWhipsOnLotByMake(String make) {
        return whipRepo.getWhipsOnLotByMake(make);
    }

    public List<Whip> getWhipsOnLotByModel(String make, String model) {
        return whipRepo.getWhipsOnLotByModel(make, model);
    }

    public Whip getWhipByVin(String vin) {

        return whipRepo.getWhipByVin(vin);
    }

    public Whip getWhipByVinReport(String vin) {

        return whipRepo.getWhipByVinReport(vin);
    }

    public Whip findWhipById(Integer id) {
        return whipRepo.findById(id).get();
    }

    public List<String> getListOfMakes(List<Whip> carList) {

        List<String> listOfMakes = new ArrayList<String>();
        for (Whip whip : carList) {
            // add the make to the listOfMakes if its not in there already
            if(!listOfMakes.contains(whip.getMake())) {

                listOfMakes.add(whip.getMake());

            }
        }

        return listOfMakes;

    }

    public List<String> getListOfModels(List<Whip> carList) {

        List<String> listOfModels = new ArrayList<String>();
        for (Whip whip : carList) {
            // add the make to the listOfMakes if its not in there already
            if(!listOfModels.contains(whip.getModel())) {

                listOfModels.add(whip.getModel());

            }
        }

        return listOfModels;

    }
    
}
