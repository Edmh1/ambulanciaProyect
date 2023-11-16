/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import datos.Ambulancia;
import datos.Barrio;
import datos.Ciudad;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author edavi
 */
public class Dibujar extends JPanel implements ActionListener{

    private Ciudad santaMarta;
    private ArrayList<Barrio> barrios;
    private ArrayList<Ambulancia> ambulancias;
    private Timer timer;

    public Dibujar() {
        setBackground(Color.WHITE);
        setFocusable(true);
        
        santaMarta = new Ciudad(7, 5);
        barrios = santaMarta.obtenerBarrios();
        ambulancias = santaMarta.obtenerAmbulancias();
        
        timer = new Timer(15, this);
        timer.start();
        
        addKeyListener(new Teclado());  // Asigna el KeyListener al panel
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics grafica) {
        super.paintComponent(grafica);
        Graphics2D g2 = (Graphics2D) grafica;
        
        int centerX = getWidth() / 2 - 100;
        int centerY = getHeight() / 2 - 20;
        
        //dibujar Barrios
        for (int i = 0; i < santaMarta.getnBarrios(); i++) {
        Barrio barrio = barrios.get(i);
        g2.drawImage(barrio.getImagen(), barrio.getX()+centerX, barrio.getY()+centerY, null);
        }
        
        //dibujar ambulancia 
        
        for (int i = 0; i < santaMarta.getnAmbulancias(); i++) {
            Ambulancia ambulancia = ambulancias.get(i);
            g2.drawImage(ambulancia.getImagen(), ambulancia.getX()+centerX, ambulancia.getY()+centerY, null);
        }

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ambulancias.isEmpty()) {
            ambulancias.get(0).mover();
            repaint();
        }
    }

    private class Teclado extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            ambulancias.get(0).keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            ambulancias.get(0).keyPressed(e);
        }
    }

    
}
