package com.kachalova.calculator.dto;

import java.math.BigDecimal;

public class VacationPayResponse {
    private String string;
    private BigDecimal vacationPay;

    public VacationPayResponse(String string, BigDecimal vacationPay) {
        this.string = string;
        this.vacationPay = vacationPay;
    }

    public String getString() {
        return string;
    }

    public BigDecimal getVacationPay() {
        return vacationPay;
    }
}
