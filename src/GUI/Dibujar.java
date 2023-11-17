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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author edavi
 */
public class Dibujar extends JPanel implements ActionListener{

    private Ciudad santaMarta;
    private ArrayList<Barrio> barrios;
    private ArrayList<Ambulancia> ambulancias;
    private Timer timer;
    
    private String ambulancia = "../GUI/ambulancia.gif";
    private Image imagenA;
    private String barrio = "../GUI/Barrio.jpg";
    private Image imagenB;
    
    public Dibujar() {
        setBackground(Color.WHITE);
        setFocusable(true);
        
        //imagenes
        ImageIcon imgA = new ImageIcon(this.getClass().getResource(ambulancia));
        imagenA = imgA.getImage().getScaledInstance(20, 20, 0);
        ImageIcon imgB = new ImageIcon(this.getClass().getResource(barrio));
        imagenB = imgB.getImage().getScaledInstance(30, 30, 0);
         
        //cargando datos
        santaMarta = new Ciudad(20, 5);
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

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2 - 10;

        // Dibujar Barrios
        for (int i = 0; i < santaMarta.getnBarrios(); i++) {
            Barrio barrio = barrios.get(i);
            g2.drawImage(imagenB, barrio.getX() + centerX, barrio.getY() + centerY, null);

            g2.setColor(Color.BLACK);
            g2.drawString(Integer.toString(i), barrio.getX() + centerX, barrio.getY() + centerY);

            
            for (int j = i + 1; j < santaMarta.getnBarrios(); j++) {
                Barrio otroBarrio = barrios.get(j);
                double distancia = santaMarta.obtenerDistancia(i, j);
                
                if(distancia != santaMarta.noHayCamino(i, j)){
                    // Dibujar los caminos entre los barrios
                    g2.setColor(Color.BLUE);
                    g2.drawLine(barrio.getX() + centerX, barrio.getY() + centerY,
                            otroBarrio.getX() + centerX, otroBarrio.getY() + centerY);
                }     
            }
            
        }

        // Dibujar ambulancia
        for (int i = 0; i < santaMarta.getnAmbulancias(); i++) {
            Ambulancia ambulancia = ambulancias.get(i);
            g2.drawImage(imagenA, ambulancia.getX() + centerX, ambulancia.getY() + centerY, null);
        }
        
    }
    
    public Ciudad getCiudad(){
        return santaMarta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        repaint();
            
        
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
