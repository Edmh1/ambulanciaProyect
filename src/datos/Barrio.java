/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author edavi
 */
public class Barrio {
    private String nombre;
    private Ambulancia ambulancia;
    private int nAccidentes;
    
    private int x;
    private int y;
    
    private String barrio = "../GUI/Barrio.jpg";
    private Image imagen;
    
    public Barrio(int x, int y){
        this.x = x;
        this.y = y;
        ImageIcon img = new ImageIcon(this.getClass().getResource(getBarrio()));
        imagen = img.getImage().getScaledInstance(30, 30, 0);
    }
    
    public void asignarAmbulancia(Ambulancia ambulancia){
        this.ambulancia = ambulancia;
    }
    
    public void retirarAmbulancia(){
        this.ambulancia = null;
    }
     
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the ambulancia
     */
    public Ambulancia getAmbulancia() {
        return ambulancia;
    }

    /**
     * @return the nAccidentes
     */
    public int getnAccidentes() {
        return nAccidentes;
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
     * @return the barrio
     */
    public String getBarrio() {
        return barrio;
    }

    /**
     * @return the imagen
     */
    public Image getImagen() {
        return imagen;
    }
}
