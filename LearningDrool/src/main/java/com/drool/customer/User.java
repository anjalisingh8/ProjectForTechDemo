package com.drool.customer;

public class User {

    private String name;
    private Integer age;
    private String isKyc;
    private String isAvailableForLoan;

    public String isAvailableForLoan() {
        return isAvailableForLoan;
    }

    public void setAvailableForLoan(String availableForLoan) {
        isAvailableForLoan = availableForLoan;
    }

    public String isKyc() {
        return isKyc;
    }

    public void setKyc(String kyc) {
        isKyc = kyc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
