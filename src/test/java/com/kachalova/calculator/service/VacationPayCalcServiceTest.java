package com.kachalova.calculator.service;

import com.kachalova.calculator.dto.VacationPayResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


class VacationPayCalcServiceTest {

    @Test
    void calcVacationPay() {
        BigDecimal expected = BigDecimal.valueOf(13651.84);
        BigDecimal actual = new VacationPayCalcService().getVacationPay(BigDecimal.valueOf(50000), 8).getPay();
        Assert.assertEquals(expected, actual);

    }

}