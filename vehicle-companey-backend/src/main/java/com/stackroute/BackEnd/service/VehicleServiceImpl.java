package com.stackroute.BackEnd.service;

import com.stackroute.BackEnd.domain.Vehicle;
import com.stackroute.BackEnd.exception.VehicleAlreadyExistsException;
import com.stackroute.BackEnd.exception.VehicleNotFoundException;
import com.stackroute.BackEnd.repository.VehicleRepository;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Primary
@Service
public class VehicleServiceImpl implements VehicleService {


    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) throws VehicleAlreadyExistsException {
        if (vehicleRepository.existsById(vehicle.getId())) {
            throw new VehicleAlreadyExistsException("Vehicle already exists");
        }
        Vehicle vehicle1 = vehicleRepository.save(vehicle);
        if (vehicle1 == null) {
            throw new VehicleAlreadyExistsException("Vehicle is already exists");
        }

        return vehicle1;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle updateComments(Vehicle vehicle) {

        return vehicleRepository.save(vehicle);
    }

    @Override
    public boolean deleteVehicle(BigInteger vehicleId) {
        vehicleRepository.deleteById(vehicleId);

        return true;
    }

    @Override
    public Optional<Vehicle> getVehicleById(BigInteger id) throws VehicleNotFoundException {

        if (!vehicleRepository.existsById(id)) {
            throw new VehicleNotFoundException("Vehicle not found");
        }
        Vehicle list = vehicleRepository.findById(id).get();
        if (list == null) {
            throw new VehicleNotFoundException("Vehicle not found");
        }
        return vehicleRepository.findById(id);
    }

//    @Override
//    public List<Vehicle> getVehicleByVehicleNumber(String vehicleNumber) throws VehicleNotFoundException {
//        List<Vehicle> list = vehicleRepository.findByVehicleNumber(vehicleNumber);
//        if (list.isEmpty()) {
//            throw new VehicleNotFoundException("Vehicle not Found");
//        }
//        return list;
//    }

    @Override
    public List<Vehicle> getlistbyslot1anddate(int capacity, String slot1) {
        List<Vehicle> myVehicle =this.vehicleRepository.findByCapacityAndSlot1(capacity,"Available");
        return myVehicle;
    }

    @Override
    public List<Vehicle> getlistbyslot2anddate(int capacity, String slot2) {
        System.out.println("in service");
        
        // List<Vehicle> myVehicle =this.vehicleRepository.findbydateandslot2(capacity,"Available");
        List<Vehicle> myVehicle =this.vehicleRepository.findByCapacityAndSlot2(capacity,"Available");
        return myVehicle;
    }

    @Override
    public List<Vehicle> getlistbyslot3anddate(int capacity, String slot3) {
        List<Vehicle> myVehicle =this.vehicleRepository.findByCapacityAndSlot3(capacity,"Available");
        return myVehicle;
    }

    @Override
    public List<Vehicle> getVehicleForRetailerRequest(String slot, String date, String vehicleType) {

        System.out.printf(slot + " "+date+" "+vehicleType);

        if(slot.equals("slot1")){
        }
        if(slot.equals("slot2")){
        }
        if(slot.equals("slot3")){
        }


        return null;
    }
//     @Override
//     List<Vehicle> getvehiclebyDateSlotandStatus(String date,String slot,String status){
//     List<Vehicle> mylist= vehicleRepository.findBy
//     }
}

