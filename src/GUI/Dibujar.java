/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import datos.Ambulancia;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author edavi
 */
public class Dibujar extends JPanel implements ActionListener{

    private Ambulancia ambulancia;
    private Timer timer;
    
    public Dibujar() {
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener((KeyListener) new Teclado());  
        
        ambulancia = new Ambulancia();
        timer = new Timer(15, this);
        timer.start();
    }

    
    @Override
    protected void paintComponent(Graphics grafica) {
        super.paintComponent(grafica);
        Graphics2D g2 = (Graphics2D) grafica;
        g2.drawImage(ambulancia.tenerImagen(), ambulancia.tenerX(), ambulancia.tenerY(), null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ambulancia.mover();
        repaint();
    }
    
    private class Teclado extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            ambulancia.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            ambulancia.keyPressed(e);
        }
    }

    
}
