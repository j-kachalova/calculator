package com.kachalova.calculator.service;

import org.springframework.stereotype.Service;

@Service

public class VacationPayCalcService {

    public Float getVacatonPay(Float averageSalaryPerYear, Integer days){
        Float averageSalaryPerDay = (float) (averageSalaryPerYear/29.3);
        Float vacationPay = averageSalaryPerDay*days;
        return vacationPay;
    }
}
