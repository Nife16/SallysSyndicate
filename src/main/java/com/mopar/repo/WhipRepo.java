package com.mopar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mopar.entity.Whip;

@Repository
public interface WhipRepo extends JpaRepository<Whip, Integer> {
    
    @Query(value = "select * from whips where sapp_id is null and vin = ?1", nativeQuery = true)
    public Whip getWhipByVin(String vin);

    @Query(value = "select * from whips where vin = ?1", nativeQuery = true)
    public Whip getWhipByVinReport(String vin);
    
    @Query(value = "select * from whips where sapp_id is null", nativeQuery = true)
    public List<Whip> getWhipsOnLot();
    
    @Query(value = "select * from whips where sapp_id is not null", nativeQuery = true)
    public List<Whip> getAllBoughtWhips();

    @Query(value = "select * from whips where sapp_id is null and year > ?1", nativeQuery = true)
    public List<Whip> getWhipsOnLotByYear(Integer year);
    
    @Query(value = "select * from whips where sapp_id is null and make = ?1", nativeQuery = true)
    public List<Whip> getWhipsOnLotByMake(String make);
    
    @Query(value = "select * from whips where sapp_id is null and make = ?1 and model = ?2", nativeQuery = true)
    public List<Whip> getWhipsOnLotByModel(String make, String model);
    
    @Query(value = "select * from whips where sapp_id is null and price < ?1", nativeQuery = true)
    public List<Whip> getWhipsOnLotByPriceLessThan(Double price);
    
    @Query(value = "select * from whips where sapp_id is null and price > ?1", nativeQuery = true)
    public List<Whip> getWhipsOnLotByPriceGreaterThan(Double price);
}
