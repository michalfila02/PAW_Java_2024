package com.jsfcourse.calc;

import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped

public class SamochodyK implements Serializable {


    public String CSamochody() {
        return "/site/samochody/create?faces-redirect=true";
    }

    public String ESamochody() {
        return "/site/samochody/edit?faces-redirect=true";
    }
}