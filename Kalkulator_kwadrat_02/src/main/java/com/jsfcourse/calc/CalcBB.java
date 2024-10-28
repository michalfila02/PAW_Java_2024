package com.jsfcourse.calc;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CalcBB {
	private String a;
	private String b;
	private String c;
	private Double result;
	private Double result2;

	@Inject
	FacesContext ctx;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
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
			double a = Double.parseDouble(this.a);
			double b = Double.parseDouble(this.b);
			double c = Double.parseDouble(this.c);

			result = (b * b) - (4 * a * c);
			if (result < 0) {
				throw new Exception();
			} else {
				if (result == 0) {
					result = (-b) / (2 * a);
					ctx.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
					return "showresult";
				} else {
					result = Math.pow(result, (1 / 2));
					result2 = (-b + result) / (2 * a);
					result = (-b - result) / (2 * a);
					ctx.addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
					return "showresult2";
				}
			}
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return null;
		}

	}

	public String info() {
		return "info";
	}
}
