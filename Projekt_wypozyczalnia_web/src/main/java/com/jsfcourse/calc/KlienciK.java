package com.jsfcourse.calc;

import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped

public class KlienciK implements Serializable {

    public String CKlienci() {
        return "site/klienci/create?faces-redirect=true";
    }

    public String EKlienci() {
        return "site/klienci/edit?faces-redirect=true";
    }
}