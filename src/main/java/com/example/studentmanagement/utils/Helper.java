package com.example.studentmanagement.utils;

import com.sun.istack.NotNull;

import java.time.LocalTime;

public class Helper {

    public static String generateNewMa(String oldMa, String key) {
        if (oldMa == null || oldMa.trim().isEmpty()) {
            return key + "0001";
        }

        int newNumber = Integer.parseInt(oldMa.substring(key.length())) + 1;
        String newMa = key + String.format("%04d", newNumber);
        return newMa;
    }

    public static Boolean checkTimeOverlapping(String timeStartTime1, String timeEndTime1, String timeStartTime2, String timeEndTime2) {
        String[] partsStartTime1 = timeStartTime1.split(":");
        String[] partsEndTime1 = timeEndTime1.split(":");

        LocalTime startTime1 = LocalTime.of(Integer.parseInt(partsStartTime1[0]), Integer.parseInt(partsStartTime1[1]));
        LocalTime endTime1 = LocalTime.of(Integer.parseInt(partsEndTime1[0]), Integer.parseInt(partsEndTime1[1]));

        String[] partsStartTime2 = timeStartTime2.split(":");
        String[] partsEndTime2 = timeEndTime2.split(":");

        LocalTime startTime2 = LocalTime.of(Integer.parseInt(partsStartTime2[0]), Integer.parseInt(partsStartTime2[1]));
        LocalTime endTime2 = LocalTime.of(Integer.parseInt(partsEndTime2[0]), Integer.parseInt(partsEndTime2[1]));

        return startTime1.isBefore(endTime2) && startTime2.isBefore(endTime1);
    }
}
