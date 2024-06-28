/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexxto.cronometro.mvc;



/**
 *
 * @author Erika Macedo
 */


public class CronometroController {

    private CronometroModel model;
    private CronometroView view;

    public CronometroController(CronometroView view) {
        this.model = new CronometroModel();
        this.view = view;
        this.model.addObserver(view);
    }

    public void iniciarCronometro() {
        model.start();
        view.styleStart();
    }

    public void pausarCronometro() {
        model.stop();
        view.styleStop();
    }

    public void zerarCronometro() {
        model.reset();
        view.styleRest();
    }
}

