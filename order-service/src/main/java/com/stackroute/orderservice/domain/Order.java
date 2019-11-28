package com.stackroute.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Date;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@NodeEntity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private String deliveryDate;
    private String slotNumber;
    private Double orderVolume;
    private String orderStatus;
    private String retailerEmail;
    
    public Order() {
    }

    public String getRetailerEmail(){
        return retailerEmail;
    }

    public void setRetailerEmail(String retailerEmail){
        this.retailerEmail = retailerEmail;
    }

   public Long getId() {
       return id;
   }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Double getOrderVolume() {
        return orderVolume;
    }

    public void setOrderVolume(Double orderVolume) {
        this.orderVolume = orderVolume;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
