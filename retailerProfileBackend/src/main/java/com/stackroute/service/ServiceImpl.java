package com.stackroute.service;

import com.stackroute.domain.RetailerProfile;
import com.stackroute.repo.RetailerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements Services
{


    private RetailerProfileRepository retailerProfileRepository;


    @Autowired
    public ServiceImpl(RetailerProfileRepository retailerProfileRepository) {
        this.retailerProfileRepository = retailerProfileRepository;
    }


    // Methods ..................................

    @Override
    public void updateRetailer(RetailerProfile retailerProfile) {

        retailerProfileRepository.save(retailerProfile);

    }


    @Override
    public List<RetailerProfile> getAllUser() {
        List<RetailerProfile> list;
        list = (List<RetailerProfile>) this.retailerProfileRepository.findAll();
        return list;
    }

    @Override
    public RetailerProfile getRetailerByEmail(String email) {
        return retailerProfileRepository.findRetailerProfileByEmailId(email);
    }




}
