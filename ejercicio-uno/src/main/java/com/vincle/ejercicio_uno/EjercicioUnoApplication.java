package com.vincle.ejercicio_uno;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjercicioUnoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EjercicioUnoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 1; i <= 100; i++) {

            boolean isMultipleThree = false;
            boolean isMultipleFive = false;
            String outputText = null;

            outputText = i + "";

            if (((i) % 3) == 0) {
                isMultipleThree = true;
                outputText = "VIN";
            }

            if (((i) % 5) == 0) {
                isMultipleFive = true;
                outputText = "CLE";
            }

            if (isMultipleThree && isMultipleFive) {
                outputText = "VINCLE";
            }

            System.out.println(outputText);
        }

    }
}
