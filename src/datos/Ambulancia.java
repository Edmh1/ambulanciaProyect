/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.awt.event.KeyEvent;

/**
 *
 * @author edavi
 */
public class Ambulancia {
    
    private boolean estado;
    private int nCasos;
    
    private int x;
    private int y;
    
    public Ambulancia(int x, int y){
        this.x = x;
        this.y = y;
        
        estado = true;
        nCasos = 0;
    }
    
    public void movimiento(Barrio vf){
        //Barrio vi = g.obtVertice(vInicio);
        //Barrio //vf = g.obtVertivFinal;
        //int x0 = vi.getX(), y0 = vi.getY();
        
        int x = vf.getX(), y = vf.getY();
        
        if(getX() < x){
            this.x++;
           
           
        }else if(getX() > x){
            this.x--;
           
        }
        if(getY() < y){
            this.y++;
         
        }else
            if(getX() > y){
            this.y--;
          
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
    
}
