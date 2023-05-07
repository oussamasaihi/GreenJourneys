package com.greenjourneys.services;

import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.HotelAmenity;
import com.greenjourneys.generic.IGenericServiceImp;
import com.greenjourneys.repositories.IAccomodation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelAmenityServiceImp extends IGenericServiceImp<HotelAmenity,Long> implements IHotelAmenityService{
    private final IAccomodation iAccomodation;
}
