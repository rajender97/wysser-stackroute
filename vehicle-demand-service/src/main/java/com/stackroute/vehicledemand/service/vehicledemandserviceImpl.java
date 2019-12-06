package com.stackroute.vehicledemand.service;

import com.stackroute.vehicledemand.domain.acceptedRetailerRequest;
import com.stackroute.vehicledemand.domain.newRetailerDemand;
import com.stackroute.vehicledemand.domain.rejectedRetailerRequest;
import com.stackroute.vehicledemand.domain.retailerdemand;
import com.stackroute.vehicledemand.repository.AcceptedRetailerDemandRepository;
import com.stackroute.vehicledemand.repository.newRetailerDemandRepository;
import com.stackroute.vehicledemand.repository.rejectedRetailerDemand;
import com.stackroute.vehicledemand.repository.vehicledemandrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Service
public class vehicledemandserviceImpl implements vehicledemandservice {
    @Autowired
    vehicledemandrepository vehicledemandrepository;

    @Autowired
    newRetailerDemandRepository newRetailerDemandRepository;
    @Autowired
    AcceptedRetailerDemandRepository acceptedRetailerDemandRepository;
    @Autowired
    rejectedRetailerDemand rejectedRetailerDemand;
    

    @Override
    public retailerdemand savenewvehicledemand(retailerdemand retailerdemand) {
        vehicledemandrepository.save(retailerdemand);
        return retailerdemand;
    }

    @Override
    public List<newRetailerDemand> getvehicledemand() {
        return newRetailerDemandRepository.findAll();
    }

    @Override
    public newRetailerDemand savenewvehicledemandbyretailer(newRetailerDemand newRetailerDemand) {
        newRetailerDemandRepository.save(newRetailerDemand);

        return newRetailerDemand;
    }

    @Override
    public List<newRetailerDemand> getallvehicledemanded() {
        return newRetailerDemandRepository.findAll();
        
    }

    @Override
    public boolean deletebyId(BigInteger Id) {
        newRetailerDemandRepository.deleteById(Id);
        return true;
    }

    @Override
    public acceptedRetailerRequest savenewaccepetedVehicleDemand(acceptedRetailerRequest aacceptedRetailerRequest) {
        acceptedRetailerDemandRepository.save(aacceptedRetailerRequest);
        return aacceptedRetailerRequest;
    }

    @Override
    public rejectedRetailerRequest savenewrejectedVehicleDemand(rejectedRetailerRequest rejectedRetailerRequest) {
        rejectedRetailerDemand.save(rejectedRetailerRequest);
        return rejectedRetailerRequest;
    }

    @Override
    public List<newRetailerDemand> searchbyretailerId(int id) {
        return this.newRetailerDemandRepository.findByRetailerId(id);
    }

    @Override
    public List<rejectedRetailerRequest> findByRetailerIdinrejectedlist(int retailerId) {
        return this.rejectedRetailerDemand.findByRetailerId(retailerId);
    }

    @Override
    public List<acceptedRetailerRequest> findByRetailerIdinacceptedlist(int retailerId) {
        return this.acceptedRetailerDemandRepository.findByRetailerId(retailerId);
    }

    @Override
    public List<acceptedRetailerRequest> findByRetailerIdAndSlot(int retailerId, String slot) {
        return this.acceptedRetailerDemandRepository.findByRetailerIdAndSlot(retailerId, slot);
    }
//    @Override
//    public List<acceptedRetailerRequest> addordertoSlotvehicle(int retailerId, String slot,int volumebooked) {
//         List<acceptedRetailerRequest> bookedVehicles= this.acceptedRetailerDemandRepository.findByRetailerIdAndSlot(retailerId,slot);
//         List<acceptedRetailerRequest> sortedtemp;
//         List<acceptedRetailerRequest> bookedvehiclesarraylist= new ArrayList<acceptedRetailerRequest>();
//         Object[] bookedvehiclesarray= bookedvehiclesarraylist.toArray();
//        ListIterator<acceptedRetailerRequest> iterator = bookedVehicles.listIterator();


//        while (iterator1.hasNext()) {

//        }
//    }


}
