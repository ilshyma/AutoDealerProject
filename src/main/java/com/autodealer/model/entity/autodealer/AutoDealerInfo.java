package com.autodealer.model.entity.autodealer;

/**
 * Created by user on 15.03.2016.
 */

import javax.persistence.*;


@Embeddable
public class AutoDealerInfo {

    @Column(nullable = false)
    private String pointName;

    @Column(nullable = false)
    private String adress;

    @Column(precision=10, scale=6, nullable = false)
    private double geoPositionX;

    @Column(precision=10, scale=6, nullable = false)
    private double geoPositionY;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String site;

    public AutoDealerInfo() {
    }

    public AutoDealerInfo(String adress, String email, double geoPositionX, double geoPositionY, String phone, String pointName, String site) {
        this.adress = adress;
        this.email = email;
        this.geoPositionX = geoPositionX;
        this.geoPositionY = geoPositionY;
        this.phone = phone;
        this.pointName = pointName;
        this.site = site;
    }

    public AutoDealerInfo(String pointName, String adress, double geoPositionX, double geoPositionY) {
        this.pointName = pointName;
        this.adress = adress;
        this.geoPositionX = geoPositionX;
        this.geoPositionY = geoPositionY;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGeoPositionX() {
        return geoPositionX;
    }

    public void setGeoPositionX(double geoPositionX) {
        this.geoPositionX = geoPositionX;
    }

    public double getGeoPositionY() {
        return geoPositionY;
    }

    public void setGeoPositionY(double geoPositionY) {
        this.geoPositionY = geoPositionY;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
