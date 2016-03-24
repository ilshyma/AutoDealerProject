package com.autodealer.model.entity.autodealer;

/**
 * Created by ilshyma on 18.03.2016.
 */
public interface AutoDealerRepo {

    void addDealer (AutoDealer autoDealer);

    void updateDealerInfo (AutoDealer autoDealer);

    AutoDealer findAutoDealerById(Long id);

    AutoDealer findAutoDealerByDealerName(String dealerName);

    void deleteDealer (AutoDealer autoDealer);


}
