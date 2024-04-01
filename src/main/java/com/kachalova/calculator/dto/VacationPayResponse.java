package com.kachalova.calculator.dto;

import java.math.BigDecimal;

public class VacationPayResponse {
    private String string;
    private BigDecimal pay;

    public VacationPayResponse(String string, BigDecimal vacationPay) {
        this.string = string;
        this.pay = vacationPay;
    }

    public String getString() {
        return string;
    }

    public BigDecimal getPay() {
        return pay;
    }
}
