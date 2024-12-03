package com.jsfcourse.calc;

import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped

public class WypozyczalniaK implements Serializable {


    public String CWypozyczalnia() {
        return "/site/wypozyczalnia/create?faces-redirect=true";
    }
    
    public String EWypozyczalnia() {
        return "/site/wypozyczalnia/edit?faces-redirect=true";
    }

}