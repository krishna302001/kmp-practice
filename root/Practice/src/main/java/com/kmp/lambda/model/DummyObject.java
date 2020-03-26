package com.kmp.lambda.model;

public class DummyObject {
    private String value;

    public String getValue() {
        return value;
    }

    public DummyObject setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object o){
        return this.getValue().equals(((DummyObject)o).getValue());
    }

    @Override
    public int hashCode(){
        return 1;
    }
}
