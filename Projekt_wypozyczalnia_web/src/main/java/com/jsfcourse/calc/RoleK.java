package com.jsfcourse.calc;

import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped

public class RoleK implements Serializable {

    public String CRole() {
        return "/site/role/create?faces-redirect=true";
    }

    public String ERole() {
        return "/site/role/edit?faces-redirect=true";
    }
}