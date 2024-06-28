package com.nexxto.cronometro.mvc;

import com.nexxto.cronometro.observer.Subject;
import java.util.Timer;
import java.util.TimerTask;

public class CronometroModel extends Subject {
    private int hora;
    private int minuto;
    private int segundo;
    private Timer timer;

    public CronometroModel() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }

    public void start() {
        if (timer != null) {
            timer.cancel(); 
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                contarSegundo();
                notifyObservers(hora, minuto, segundo);
            }
        }, 1000, 1000);
    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public void reset() {
        stop(); 
        hora = 0;
        minuto = 0;
        segundo = 0;
        notifyObservers(hora, minuto, segundo);
    }

    private void contarSegundo() {
        segundo++;
        if (segundo == 60) {
            segundo = 0;
            incrementarMinuto();
        }
    }

    private void incrementarMinuto() {
        minuto++;
        if (minuto == 60) {
            minuto = 0;
            incrementarHora();
        }
    }

    private void incrementarHora() {
        hora++;
    }
}
