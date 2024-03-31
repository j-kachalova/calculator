package com.kachalova.calculator.service;

import com.kachalova.calculator.dto.VacationPayResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;



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
    public VacationPayResponse getVacationPay(BigDecimal averageSalaryPerYear, Integer amountPaidDays) {
        // зарплата за день с оруглением до 2 знаком после запятой
        BigDecimal averageSalaryPerDay = averageSalaryPerYear.divide(BigDecimal.valueOf(AVERAGE_DAYS_IN_MOUNT), 2, RoundingMode.HALF_UP);
        BigDecimal vacationPay = averageSalaryPerDay.multiply(BigDecimal.valueOf(amountPaidDays));
        return new VacationPayResponse("Сумма отпускных ", vacationPay);
    }
}
