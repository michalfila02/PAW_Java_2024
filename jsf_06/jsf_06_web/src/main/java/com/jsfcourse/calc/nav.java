package com.jsfcourse.calc;

import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped

public class nav implements Serializable {

    public String IKlienci() {
        return "site/klienci/index?faces-redirect=true";
    }

    public String IWypozyczalnia() {
        return "/site/wypozyczalnia/index?faces-redirect=true";
    }

    public String ISamochody() {
        return "/site/samochody/index?faces-redirect=true";
    }

    public String IWypozyczalnie() {
        return "/site/wypozyczalnie/index?faces-redirect=true";
    }

    public String IRole() {
        return "/site/role/index?faces-redirect=true";
    }

    public String IPracownicy() {
        return "/site/user/index?faces-redirect=true";
    }
}