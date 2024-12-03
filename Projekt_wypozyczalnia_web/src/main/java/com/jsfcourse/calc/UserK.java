package com.jsfcourse.calc;

import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped

public class UserK implements Serializable {

    public String CPracownicy() {
        return "/site/user/create?faces-redirect=true";
    }
    
    public String EPracownicy() {
        return "/site/user/edit?faces-redirect=true";
    }
}