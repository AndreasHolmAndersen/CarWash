package com.company;

public class Pause {
    /**
     * @param sec
     * Pauses the execution of the program for the entered amount of time
     */
    public void wait(int sec) {
        try {
            Thread.currentThread().sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

