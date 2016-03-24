package com.autodealer;

import com.autodealer.config.Persistence;
import com.autodealer.model.entity.car.CarRepo;
import com.autodealer.service.CarService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by user on 24.03.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Persistence.class)
public class CarEditService {

    @Inject
    private CarService carService;

    @Inject
    private CarRepo carRepo;


}
