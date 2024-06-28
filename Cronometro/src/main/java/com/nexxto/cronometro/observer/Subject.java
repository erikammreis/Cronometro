/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexxto.cronometro.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erika Macedo
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(int hora, int minuto, int segundo) {
        for (Observer observer : observers) {
            observer.update(hora, minuto, segundo);
        }
    }
}
