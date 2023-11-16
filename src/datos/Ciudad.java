/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import ednl.Grafo;
import ednl.GrafoEstMat;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author edavi
 */
public class Ciudad {
    
    private Grafo<Barrio, Integer> c;
    private int nBarrios;
    private int nAmbulancias;

    public Ciudad(int nBarrios, int nAmbulancias) {
        this.c = new GrafoEstMat<>(99999);
        this.nAmbulancias = nAmbulancias;
        this.nBarrios = nBarrios;
        
        int radius = 150;
        for (int i = 0; i < nBarrios; i++) {
            double angle = 2 * Math.PI * i / nBarrios;
            int x = (int) (radius * Math.cos(angle));
            int y = (int) (radius * Math.sin(angle));
            c.insVertice(new Barrio(x, y));
        }
        situarAmbulancias(nAmbulancias);
    }
    
    public Barrio obtenerBarrio(int i){
        return c.obtVertice(i);
    }
    
    public ArrayList<Barrio> obtenerBarrios(){
        ArrayList<Barrio> barrios = new ArrayList<>();
        for (int i = 0; i < c.orden(); i++) {
            barrios.add(c.obtVertice(i));
        }
        return barrios;
    }
    public ArrayList<Ambulancia> obtenerAmbulancias() {
       ArrayList<Ambulancia> ambulancias = new ArrayList<>();
       for (int i = 0; i < c.orden(); i++) {
           Ambulancia ambulancia = c.obtVertice(i).getAmbulancia();
           if(ambulancia != null) {
               ambulancias.add(ambulancia);
           }
       }
       return ambulancias;
   }
    
    //Requerimiento funcionales
    //1
    public void agregarBarrio(Barrio barrio){
        c.insVertice(barrio);
        nBarrios++;
    }
    //2 Nota : n debe ser entre 4 - 5
    public void situarAmbulancias(int n){
        Random random = new Random();
        boolean asignar = random.nextBoolean();
        for (int i = 0; i < c.orden(); i++) {
            if(asignar && n > 0){
                c.obtVertice(i).asignarAmbulancia(new Ambulancia(c.obtVertice(i).getX(), c.obtVertice(i).getY()));
                n--;
            }
        } 
    }
    //3
    public void atenderAccidente(Barrio barrio){
        
    }
    //4
    public int cantidadDeIncidentes(){
        int incidentes = 0;
        for (int i = 0; i < c.orden(); i++) {
            incidentes+= c.obtVertice(i).getnAccidentes();
        }
        return incidentes;
    }
    //5
    public String posiblesRutasAmbulancia(){
        return "";
    }
    //6
    public void aislarBarrio(Barrio barrio){
        int pos = buscar(barrio);
        if(pos!= -1){
            for (int i = 0; i < c.orden(); i++) {
                c.elimArista(i, pos);
                c.elimArista(pos, i);
            }
        }
    }
    private int buscar(Barrio barrio){
        for (int i = 0; i < c.orden(); i++) {
            if(c.obtVertice(i).equals(barrio)){
                return i; 
            }
        }
        return -1; 
    }
    //7
    public String reporteGeneral(){
        return "";
    }
    
    /**
     * @return the nBarrios
     */
    public int getnBarrios() {
        return nBarrios;
    }

    /**
     * @return the nAmbulancias
     */
    public int getnAmbulancias() {
        return nAmbulancias;
    }

    
    
}
