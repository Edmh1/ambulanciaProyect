/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author edavi
 */
public class Ambulancia {
    
    private String ambulancia = "ambulancia.gif";
    
    private int dx;
    private int dy;
    private int x;
    private int y;
    
    private Image imagen;
    
    public Ambulancia(){
        x = 40;
        y = 60;
        ImageIcon img = new ImageIcon(this.getClass().getResource(ambulancia));
        imagen = img.getImage().getScaledInstance(20, 20, 0);
    }
    public void mover(){
        x += dx;
        y += dy;
    }
    public int tenerX(){
        return x;
    }
    public int tenerY(){
        return y;
    }
    public Image tenerImagen(){
        return imagen;
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            dx = 0;
        }
        if(key == KeyEvent.VK_RIGHT){
            dx = 0;
        }
        if(key == KeyEvent.VK_UP){
            dy = 0;
        }
        if(key == KeyEvent.VK_DOWN){
            dy = 0;
        }
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            dx = -5;
        }
        if(key == KeyEvent.VK_RIGHT){
            dx = 5;
        }
        if(key == KeyEvent.VK_UP){
            dy = -5;
        }
        if(key == KeyEvent.VK_DOWN){
            dy = 5;
        }
    }

    
    
    
    
}
