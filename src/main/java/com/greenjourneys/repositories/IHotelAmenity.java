package com.greenjourneys.repositories;

import com.greenjourneys.entities.HotelAmenity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelAmenity extends JpaRepository<HotelAmenity,Long> {
}
