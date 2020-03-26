package com.kmp.spring.example.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ss_Admin implements Serializable {
    @JsonProperty("a_id")
    private long a_id;
    @JsonProperty("a_username")
    private String a_username;
    @JsonProperty("a_password")
    private String a_password;

    public Ss_Admin() {}
    public long getA_id() {
        return a_id;
    }
    public void setA_id(long a_id) {
        this.a_id = a_id;
    }
    public String getA_username() {
        return a_username;
    }
    public void setA_username(String a_username) {
        this.a_username = a_username;
    }
    public String getA_password() {
        return a_password;
    }
    public void setA_password(String a_password) {
        this.a_password = a_password;
    }
    @Override
    public String toString(){
        return String.format("Id: %d\n username: %s\n",this.getA_id(),this.getA_username());
    }
}