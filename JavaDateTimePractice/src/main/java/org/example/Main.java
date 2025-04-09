package org.example;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate newDate = today.minusDays(200000);
        System.out.println("Today is: " + today);
        System.out.println("New Date is: " + newDate.isLeapYear());
    }
}