package com.mopar.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whips")
public class Whip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    @Column(name = "year", nullable = false)
    private Integer year;
    @Column(name = "make", nullable = false)
    private String make;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "trim", nullable = true)
    private String trim;
    @Column(name = "vin", nullable = false, unique = true, updatable = false, length = 17)
    private String vin;
    @Column(name = "price", nullable = false, scale = 2)
    private Double price;
    @Column(name = "city_mpg", nullable = true)
    private Integer cMpg;
    @Column(name = "highway_mpg", nullable = true)
    private Integer hMpg;
    @Column(name = "image", nullable = true, length = 512)
    private String image;
    @Column(name = "engine", nullable = true)
    private String engine;
    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;
    @Column(name = "mileage", nullable = false, columnDefinition = "integer default 0")
    private Integer mileage;

    public Whip() {
    }
    
    // Get the title name for the whips
    public String getTitleName() {
        return this.year + " " + this.model + " " + this.trim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getcMpg() {
        return cMpg;
    }

    public void setcMpg(Integer cMpg) {
        this.cMpg = cMpg;
    }

    public Integer gethMpg() {
        return hMpg;
    }

    public void sethMpg(Integer hMpg) {
        this.hMpg = hMpg;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Whip [id=" + id + ", year=" + year + ", make=" + make + ", model=" + model + ", trim=" + trim + ", vin="
                + vin + ", price=" + price + ", cMpg=" + cMpg + ", hMpg=" + hMpg + ", image=" + image + ", engine="
                + engine + ", createDate=" + createDate + ", mileage=" + mileage + "]";
    }

}
