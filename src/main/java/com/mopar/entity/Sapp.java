package com.mopar.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sapp")
public class Sapp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    @Column(name = "sappname", unique = true, nullable = false)
    private String sappname;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "isAdmin", nullable = false, columnDefinition = "boolean default 0")
    private Boolean isAdmin;

    @OneToMany
    @JoinColumn(name="sapp_id", referencedColumnName = "id")
    private List<Whip> garage;
    
    public Sapp() {
    }
    
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getSappname() {
        return sappname;
    }

    public void setSappname(String sappname) {
        this.sappname = sappname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public List<Whip> getGarage() {
        return garage;
    }

    public void setGarage(List<Whip> garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {
        return "Sapp [id=" + id + ", sappname=" + sappname + ", password=" + password + "]";
    }
    
}
