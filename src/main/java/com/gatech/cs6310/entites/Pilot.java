package com.gatech.cs6310.entites;
;




public class Pilot extends User{

    private String tax;
    private String license;
    private Integer experience;
    private Drone assignDrone;

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Drone getAssignDrone() {
        return assignDrone;
    }

    public void setAssignDrone(Drone assignDrone) {
        this.assignDrone = assignDrone;
    }

    public Pilot(String account,String firstName,String lastName,String phone,String tax,String license,Integer experience){
        this.account  = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.license = license;
        this.tax = tax;
        this.experience = experience;
    }
    public void displayPilot(){
        System.out.println("name:" + this.getFirstName() + "_" + this.getLastName() + ",phone:" + this.getPhone() + ",taxID:" + this.getTax() +
                ",licenseID:" + this.getLicense() + ",experience:" + this.getExperience());
    }
}
