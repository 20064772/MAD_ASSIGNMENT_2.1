package com.example.mad_assignment_21;

public class Person {

    private int id;
    private String name;
    private String userName;
    private String email;
    private Address address;
    private String phNumber;
    private String webSite;
    private Company company;


    public Person(int id, String name, String userName, String email, Address address, String phNumber, String webSite, Company company) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.phNumber = phNumber;
        this.webSite = webSite;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getStreet() {
        return address.getStreet();
    }

    public String getSuite() {
        return address.getSuite();
    }

    public String getCity() {
        return address.getCity();
    }

    public String getLat() {
        return address.getLat();
    }

    public String getLongi(){
        return address.getLongi();
    }

    public String getPhNumber() {return phNumber;}

    public String getWebSite() {return webSite;}

    public Company getCompany() {return company;}

    public String getCompName() {return company.getCompanyName();}

    public String getCompCatchPhrase() {return company.getCatchPhrase();}

    public String getCompBs() {return company.getBs();}
}

