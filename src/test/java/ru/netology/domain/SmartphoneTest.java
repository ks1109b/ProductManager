package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    public void shouldMatchesByManufacturer() {
        Smartphone smartphone = new Smartphone(3, "X", 10000, "Samsung");
        assertEquals(true, smartphone.matches("Samsung"));
    }

    @Test
    public void shouldMatchesByName() {
        Smartphone smartphone = new Smartphone(3, "X", 10000, "Samsung");
        assertEquals(true, smartphone.matches("X"));
    }

    @Test
    public void shouldMatchesIfNone() {
        Smartphone smartphone = new Smartphone(4, "17 Pro", 150000, "Meizu");
        assertEquals(false, smartphone.matches("X"));
    }

}