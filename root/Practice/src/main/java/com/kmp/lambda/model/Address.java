package com.kmp.lambda.model;

public class Address {

    private String city;
    private Number pinCode;
    private String state;

    public Address(String city, Number pinCode, String country) {
        this.city = city;
        this.pinCode = pinCode;
        this.state = country;
    }

    public String getCity() {
        return city;
    }

    public Number getPinCode() {
        return pinCode;
    }

    public String getState() {
        return state;
    }

    public String toString() {
        return "City: " + this.city + " State: " + this.state + " pinCode: " + pinCode;
    }
    @Override
    public boolean equals(Object obj){
        return ((Address)obj).getCity().equalsIgnoreCase(this.getCity());
    }
}
