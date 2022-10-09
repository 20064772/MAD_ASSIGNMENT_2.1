package com.example.mad_assignment_21;

public class Company {

    private String companyName;
    private String catchPhrase;
    private String bs;

    public Company(String companyName, String catchPhrase, String bs) {
        this.companyName = companyName;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}
