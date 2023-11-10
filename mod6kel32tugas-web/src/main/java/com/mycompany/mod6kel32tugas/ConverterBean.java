package com.mycompany.mod6kel32tugas;

import java.text.DecimalFormat;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

@Stateless
@LocalBean
public class ConverterBean implements ConverterBeanLocal {

    private DecimalFormat twoDigits = new DecimalFormat("0.00");

    public String ktof(double k) {
        // Corrected formula for Fahrenheit to Kelvin conversion
        double f = (k - 273.15) * 9 / 5 + 32;
        String result = twoDigits.format(f);
        return result;
    }

    public String ftok(double f) {
        // Corrected formula for Kelvin to Fahrenheit conversion
        double k = (f - 32) * 5 / 9 + 273.15;
        String result = twoDigits.format(k);
        return result;
    }
}
