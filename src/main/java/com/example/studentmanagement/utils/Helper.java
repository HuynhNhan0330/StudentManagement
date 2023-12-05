package com.example.studentmanagement.utils;

import com.sun.istack.NotNull;

public class Helper {

    public static String generateNewMa(String oldMa, String key) {
        if (oldMa == null || oldMa.trim().isEmpty()) {
            return key + "0001";
        }

        int newNumber = Integer.parseInt(oldMa.substring(key.length())) + 1;
        String newMa = key + String.format("%04d", newNumber);
        return newMa;
    }
}
