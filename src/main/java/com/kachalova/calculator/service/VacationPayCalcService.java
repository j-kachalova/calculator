package com.kachalova.calculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.ROUND_HALF_UP;

@Service

public class VacationPayCalcService {
    /**
     * Среднее количество дней в месяце без учета праздников
     **/
    private static final double AVERAGE_DAYS_IN_MOUNT = 29.3;

    /**
     * Метод для вычисления суммы выплаты отпускных
     *
     * @param averageSalaryPerYear средняя зарплата за месяц
     * @param amountPaidDays       количество оплачиваемых дней
     * @return возвращает сумму отпускных
     */
    public BigDecimal getVacationPay(BigDecimal averageSalaryPerYear, Integer amountPaidDays) {
        // зарплата за день с оруглением до 2 знаком после запятой
        BigDecimal averageSalaryPerDay = averageSalaryPerYear.divide(BigDecimal.valueOf(AVERAGE_DAYS_IN_MOUNT), 2, RoundingMode.HALF_UP);
        BigDecimal vacationPay = averageSalaryPerDay.multiply(BigDecimal.valueOf(amountPaidDays));
        return vacationPay;
    }
}
