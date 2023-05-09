package com.greenjourneys.controller;

import com.greenjourneys.entities.Accomodation;
import com.greenjourneys.entities.HotelAmenity;
import com.greenjourneys.generic.GenericController;
import com.greenjourneys.services.IAccomodationService;
import com.greenjourneys.services.IHotelAmenityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/Amenity")
@RequiredArgsConstructor
public class HotelAmenityCont extends GenericController<HotelAmenity,Long> {
    private final IHotelAmenityService iHotelAmenityService;
}
