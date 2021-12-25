package com.sharibekoff.smartcity.service;

import com.sharibekoff.smartcity.model.Hotel;
import com.sharibekoff.smartcity.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Transactional
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Transactional
    public Hotel findById(Long id) {
        return hotelRepository.findById(id)
                .orElse(new Hotel());
    }

    @Transactional
    public void delete(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

}
