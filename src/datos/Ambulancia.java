/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import ednl.Grafo;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author edavi
 */
public class Ambulancia {
    private int dx;
    private int dy;
    
    private int x;
    private int y;
    
    private String ambulancia = "../GUI/ambulancia.gif";
    private Image imagen;
    
    public Ambulancia(int x, int y){
        this.x = x;
        this.y = y;
        ImageIcon img = new ImageIcon(this.getClass().getResource(ambulancia));
        imagen = img.getImage().getScaledInstance(20, 20, 0);
    }
    
    public void mover(){
        x += dx;
        y += dy;
    }
    
    public void movimiento(Barrio vf){
        //Barrio vi = g.obtVertice(vInicio);
        //Barrio //vf = g.obtVertivFinal;
        //int x0 = vi.getX(), y0 = vi.getY();
        
        int x = vf.getX(), y = vf.getY();
        
        if(getX() < x){
            this.x++;
            //dx = 1;
        }else if(getX() > x){
            this.x--;
            //dx = -1;
        }
        if(getY() < y){
            this.y++;
            //dy = 1;
        }else
            if(getX() > y){
            this.y--;
            //dy = -1;
        }
        
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
            dx = -3;
        }
        if(key == KeyEvent.VK_RIGHT){
            dx = 3;
        }
        if(key == KeyEvent.VK_UP){
            dy = -3;
        }
        if(key == KeyEvent.VK_DOWN){
            dy = 3;
        }
    }

     /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the imagen
     */
    public Image getImagen() {
        return imagen;
    }
    
}
