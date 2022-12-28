package com.mopar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mopar.entity.Sapp;

@Repository
public interface SappRepo extends JpaRepository<Sapp, Integer> {
   
    @Query(value="select * from sapp where sappname=?1 and password=?2", nativeQuery = true)
    public Sapp findByEmailAndPassword(String sappname, String password);
}
