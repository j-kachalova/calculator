package com.kachalova.calculator.controller;
import com.kachalova.calculator.service.VacationPayCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VacationPayController {
    @Autowired
    private VacationPayCalcService vacationPayCalcService;
    float vacationPay;
    @GetMapping("/calculate")
    public String getVacationPay(@RequestParam(value = "salary", defaultValue = "0") Float salary, @RequestParam(value = "days", defaultValue = "0") Integer days,Model model){
        System.out.println("salary "+salary);
        System.out.println("days "+days);
        vacationPay=vacationPayCalcService.getVacatonPay(salary,days);

        model.addAttribute("pay", vacationPay);
        return "index";
    }
}
