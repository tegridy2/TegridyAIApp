package com.tegridyai;

public class RandyAssistant {
    public String respond(String input) {
        if (input.toLowerCase().contains("high")) {
            return "You know it, bud! Stay lifted.";
        }
        return "Randy here. Tegridy mode: always on.";
    }
}
