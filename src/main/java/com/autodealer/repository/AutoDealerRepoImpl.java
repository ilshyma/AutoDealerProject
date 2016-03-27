package com.autodealer.repository;

import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.autodealer.AutoDealerRepo;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

import static com.autodealer.repository.Util.castList;

/**
 * Created by user on 24.03.2016.
 */
@Repository
@Transactional
public class AutoDealerRepoImpl implements AutoDealerRepo {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public void addDealer(AutoDealer autoDealer) {
        sessionFactory.getCurrentSession().save(autoDealer);
    }

    @Override
    public void updateDealerInfo(AutoDealer autoDealer) {
        sessionFactory.getCurrentSession().update(autoDealer);

    }

    @Override
    public AutoDealer findAutoDealerById(Long id) {
        return (sessionFactory.getCurrentSession().get(AutoDealer.class, id));
    }

    @Override
    public List<AutoDealer> findAutoDealerByDealerName(String dealerName) {

        return castList(
                sessionFactory.getCurrentSession()
                       .createCriteria(AutoDealer.class)
                       .add(Restrictions.ilike("autoDealerInfo.pointName", "%"+ dealerName +"%"))
                .list()
        ); }

    @Override
    public void deleteDealer(AutoDealer autoDealer) {
        sessionFactory.getCurrentSession().delete(autoDealer);

    }
}
