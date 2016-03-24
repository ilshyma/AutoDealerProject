package com.autodealer.service;


import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.personal.Personal;

import java.util.List;

/**
 * Created by user on 24.03.2016.
 */
public interface DealerEditService {

    AutoDealer createDealer(String pointName, String adress, double geoPositionX, double geoPositionY, String phone, String email, String site, List<Personal> personalList);

    AutoDealer createDealer(String pointName, String adress, double geoPositionX, double geoPositionY, List<Personal> personalList);
}
