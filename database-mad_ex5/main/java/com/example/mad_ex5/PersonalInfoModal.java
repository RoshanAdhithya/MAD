package com.example.mad_ex5;

public class PersonalInfoModal {
    private String name, address, phone, email;
    private int id;

    public PersonalInfoModal(int id1, String name1, String address1, String phone1, String email1) {
        id = id1;
        name = name1;
        address = address1;
        phone = phone1;
        email = email1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}