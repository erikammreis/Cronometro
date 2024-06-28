/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nexxto.cronometro.mvc;

/**
 *
 * @author Erika Macedo
 */
import com.nexxto.cronometro.observer.Observer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class CronometroView extends JFrame implements Observer {

    private JLabel labelHoraMinutoSegundo;
    private JButton buttonStart;
    private JButton buttonStop;
    private JButton buttonReset;
    CronometroController cronometro = new CronometroController(this);

    public CronometroView() {
        super("Cronômetro");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelHoraMinutoSegundo = new JLabel("00:00:00", SwingConstants.CENTER);
        labelHoraMinutoSegundo.setFont(new Font("Arial", Font.BOLD, 24));

        buttonStart = new JButton("▶ Start");
        buttonStop = new JButton("⏸ Stop");
        buttonReset = new JButton("🔄 Reset");
        buttonStop.setEnabled(false);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cronometro.iniciarCronometro();
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cronometro.pausarCronometro();
            }
        });

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cronometro.zerarCronometro();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout()); // Use FlowLayout para organizar os botões
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
        buttonPanel.add(buttonReset);

        add(labelHoraMinutoSegundo, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

        // Adiciona um ouvinte para fechar a aplicação corretamente
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                cronometro.zerarCronometro();
                System.exit(0);
            }
        });
    }

    @Override
    public void update(int hora, int minuto, int segundo) {
        SwingUtilities.invokeLater(() -> {
            String horaFormatada = String.format("%02d:%02d:%02d", hora, minuto, segundo);
            labelHoraMinutoSegundo.setText(horaFormatada);
        });
    }
 
    
    public  void styleStart() {
        buttonReset.setEnabled(false);
        buttonStop.setEnabled(true);
        buttonStart.setEnabled(false);
        buttonReset.setEnabled(true);
    }

    public void styleStop() {
        buttonStop.setEnabled(false);
        buttonStart.setEnabled(true);
        buttonReset.setEnabled(true);
    }

    public void styleRest() {
        buttonStart.setEnabled(true);
        buttonStop.setEnabled(false);
        buttonReset.setEnabled(false);
    }

}
