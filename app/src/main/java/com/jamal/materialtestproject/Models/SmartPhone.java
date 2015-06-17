package com.jamal.materialtestproject.Models;

/**
 * Created by yamil.marques on 6/11/15.
 */
public class SmartPhone {

    private String model;
    private Double value;
    private String operativeSystem;
    private int OS;

    public SmartPhone(String model,Double value,String operativeSystem,int OS){
        this.setModel(model);
        this.setValue(value);
        this.setOperativeSystem(operativeSystem);
        this.setOS(OS);
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getOperativeSystem() {
        return operativeSystem;
    }

    public void setOperativeSystem(String operativeSystem) {
        this.operativeSystem = operativeSystem;
    }

    public int getOS() {
        return OS;
    }

    public void setOS(int OS) {
        this.OS = OS;
    }
}
