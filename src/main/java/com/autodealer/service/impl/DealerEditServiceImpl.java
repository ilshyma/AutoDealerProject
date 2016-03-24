package com.autodealer.service.impl;

import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.autodealer.AutoDealerInfo;
import com.autodealer.model.entity.autodealer.AutoDealerRepo;
import com.autodealer.model.entity.car.CarRepo;
import com.autodealer.model.entity.personal.Personal;
import com.autodealer.service.DealerEditService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ilshyma on 24.03.2016.
 */


@Service
@Transactional
public class DealerEditServiceImpl implements DealerEditService{

    @Inject
    private AutoDealerRepo autoDealerRepo;

    @Override
    public AutoDealer createDealer(String pointName, String adress, double geoPositionX, double geoPositionY, String phone, String email, String site, List<Personal> personalList) {
        final AutoDealer autoDealer = new AutoDealer();
        final AutoDealerInfo autoDealerInfo = new AutoDealerInfo();
        autoDealerInfo.setPointName(pointName);
        autoDealerInfo.setAdress(adress);
        autoDealerInfo.setGeoPositionX(geoPositionX);
        autoDealerInfo.setGeoPositionY(geoPositionY);
        autoDealerInfo.setPhone(phone);
        autoDealerInfo.setPhone(site);
        autoDealerInfo.setEmail(email);
        autoDealer.setAutoDealerInfo(autoDealerInfo);
        autoDealer.setPersonalList(personalList);

        autoDealerRepo.addDealer(autoDealer);
        return autoDealer;
    }


    @Override
    public AutoDealer createDealer(String pointName, String adress, double geoPositionX, double geoPositionY, List<Personal> personalList) {
        final AutoDealer autoDealer = new AutoDealer();
        final AutoDealerInfo autoDealerInfo = new AutoDealerInfo();
        autoDealerInfo.setPointName(pointName);
        autoDealerInfo.setAdress(adress);
        autoDealerInfo.setGeoPositionX(geoPositionX);
        autoDealerInfo.setGeoPositionY(geoPositionY);
        autoDealer.setAutoDealerInfo(autoDealerInfo);
        autoDealer.setPersonalList(personalList);

        autoDealerRepo.addDealer(autoDealer);
        return autoDealer;
    }

    @Override
    public AutoDealer createDealer(String pointName, String adress, double geoPositionX, double geoPositionY) {
        final AutoDealer autoDealer = new AutoDealer();
        final AutoDealerInfo autoDealerInfo = new AutoDealerInfo();
        autoDealerInfo.setPointName(pointName);
        autoDealerInfo.setAdress(adress);
        autoDealerInfo.setGeoPositionX(geoPositionX);
        autoDealerInfo.setGeoPositionY(geoPositionY);
        autoDealer.setAutoDealerInfo(autoDealerInfo);

        autoDealerRepo.addDealer(autoDealer);
        return autoDealer;
    }
}
