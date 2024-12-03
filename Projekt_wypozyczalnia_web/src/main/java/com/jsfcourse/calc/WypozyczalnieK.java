package com.jsfcourse.calc;

import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped

public class WypozyczalnieK implements Serializable {


    public String CWypozyczalnie() {
        return "/site/wypozyczalnie/create?faces-redirect=true";
    }
    
    public String EWypozyczalnie() {
        return "/site/wypozyczalnie/edit?faces-redirect=true";
    }


}