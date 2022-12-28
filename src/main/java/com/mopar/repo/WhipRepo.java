package com.mopar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mopar.entity.Whip;

@Repository
public interface WhipRepo extends JpaRepository<Whip, Integer> {
    
    @Query(value = "select * from whips where user_id is null", nativeQuery = true)
    public List<Whip> getWhipsOnLot();

    @Query(value = "select * from whips where make = ?1", nativeQuery = true)
    public List<Whip> getWhipsByYear(Integer year);
    
    @Query(value = "select * from whips where make = ?1", nativeQuery = true)
    public List<Whip> getWhipsByMake(String make);
    
    @Query(value = "select * from whips where model = ?1", nativeQuery = true)
    public List<Whip> getWhipsByModel(String model);
    
    @Query(value = "select * from whips where price < ?1", nativeQuery = true)
    public List<Whip> getWhipsByPriceLessThan(Double price);
    
    @Query(value = "select * from whips where price > ?1", nativeQuery = true)
    public List<Whip> getWhipsByPriceGreaterThan(Double price);
}
