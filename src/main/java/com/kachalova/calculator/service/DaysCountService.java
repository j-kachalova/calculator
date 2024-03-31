package com.kachalova.calculator.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DaysCountService {
    private final static int CURRENT_YEAR = LocalDate.now().getYear();
    /**
     * дни каникул
     **/
    private List<LocalDate> holidays = List.of(
            LocalDate.of(CURRENT_YEAR, 1, 1),
            LocalDate.of(CURRENT_YEAR, 1, 2),
            LocalDate.of(CURRENT_YEAR, 1, 3),
            LocalDate.of(CURRENT_YEAR, 1, 4),
            LocalDate.of(CURRENT_YEAR, 1, 5),
            LocalDate.of(CURRENT_YEAR, 1, 6),
            LocalDate.of(CURRENT_YEAR, 1, 7),
            LocalDate.of(CURRENT_YEAR, 1, 8),
            LocalDate.of(CURRENT_YEAR, 2, 23),
            LocalDate.of(CURRENT_YEAR, 3, 8),
            LocalDate.of(CURRENT_YEAR, 5, 1),
            LocalDate.of(CURRENT_YEAR, 5, 9),
            LocalDate.of(CURRENT_YEAR, 6, 12),
            LocalDate.of(CURRENT_YEAR, 11, 4)
    );

    /**
     * Метод для подсчета количества оплачиваемых дней
     *
     * @param startVacationDate - дата первого дня отпуска
     * @param endVacationDate   - дата последнего дня отпуска
     * @return возвращает количество оплачиваемых дней
     **/
    public int countPaidDays(LocalDate startVacationDate, LocalDate endVacationDate) {

        List<LocalDate> vacationDates = new ArrayList<>();

        for (LocalDate date = startVacationDate; !date.isAfter(endVacationDate); date = date.plusDays(1)) {
            //проверка на выходной или праздник
            if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY && !holidays.contains(date)) {
                vacationDates.add(date);
            }
        }

        return vacationDates.size();
    }
}
