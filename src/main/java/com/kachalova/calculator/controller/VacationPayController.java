package com.kachalova.calculator.controller;

import com.kachalova.calculator.service.DaysCountService;
import com.kachalova.calculator.service.VacationPayCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class VacationPayController {
    @Autowired
    private VacationPayCalcService vacationPayCalcService;
    @Autowired
    private DaysCountService daysCountService;

    @GetMapping("/calculate")
    public String getVacationPay(@RequestParam(value = "salary", defaultValue = "0") BigDecimal salary,
                                 @RequestParam(value = "days", defaultValue = "0") Integer days,
                                 @RequestParam("vacation-start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> startVacationDate,
                                 @RequestParam("vacation-end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> endVacationDate,
                                 Model model) {
        // количество оплаичваемых дней
        int paidDays;

        // подсчет количества дней, если указаны даты
        if (startVacationDate.isPresent() && endVacationDate.isPresent()) {
            paidDays = daysCountService.countPaidDays(startVacationDate.get(), endVacationDate.get());
            System.out.println(startVacationDate.get());
            System.out.println("daysCalc" + paidDays);
        } else paidDays = days; //задать указанное количество дней

        // рассчет суммы выплаты
        BigDecimal vacationPay = vacationPayCalcService.getVacationPay(salary, paidDays);

        // отобразить сумму выплаты
        model.addAttribute("pay", vacationPay);


        System.out.println("salary " + salary);
        System.out.println("paid days " + paidDays);

        return "index";
    }
}
