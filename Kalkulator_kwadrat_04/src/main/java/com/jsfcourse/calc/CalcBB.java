package com.jsfcourse.calc;

import java.io.Serializable;
import java.util.ResourceBundle;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped

public class CalcBB implements Serializable{
	private Double a;
	private Double b;
	private Double c;
	private Double result;
	private Double result2;

	// Resource injected
	@Inject
	@ManagedProperty("#{txtCalcErr}")
	private ResourceBundle txtCalcErr;

	// Resource injected
	@Inject
	@ManagedProperty("#{txtMain}")
	private ResourceBundle txtMain;
	
	@Inject
	FacesContext ctx;
	


	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public Double getC() {
		return c;
	}

	public void setC(Double c) {
		this.c = c;
	}

	public Double getResult() {
		return result;
	}

	public Double getResult2() {
		return result2;
	}

	public String calc() {
		try {
			result = (b * b) - (4 * a * c);
			if (result < 0) {
				throw new Exception();
			} else {
				if (result == 0) {
					result = (-b) / (2 * a);
					ctx.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("calcComputationOkInfo"), null));
					return "showresult";
				} else {
					result = Math.pow(result, (1 / 2));
					result2 = (-b + result) / (2 * a);
					result = (-b - result) / (2 * a);
					ctx.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("calcComputationOkInfo"), null));
					return "showresult2";
				}
			}
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, txtCalcErr.getString("calcZero"), null));
			return null;
		}

	}

	public String info() {
		return "info";
	}
}
