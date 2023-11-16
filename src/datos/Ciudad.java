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
    
    private Grafo<Barrio, Double> c;
    private int nBarrios;
    private int nAmbulancias;

    public Ciudad(int nBarrios, int nAmbulancias) {
        this.c = new GrafoEstMat<>(99999.9);
        this.nAmbulancias = nAmbulancias;
        this.nBarrios = nBarrios;
        
        //coloca los vertices
        int radius = 300;
        for (int i = 0; i < nBarrios; i++) {
            double angle = 2 * Math.PI * i / nBarrios;
            int x = (int) (radius * Math.cos(angle));
            int y = (int) (radius * Math.sin(angle));
            c.insVertice(new Barrio(x, y));
        }
        // Coloca las aristas
        ArrayList<Barrio> barrios = obtenerBarrios();
        for (int i = 0; i < nBarrios; i++) {
            Barrio barrio = barrios.get(i);
            
            Random random = new Random();
            boolean asignar;
            for (int j = i + 1; j < nBarrios; j++) {
                asignar = random.nextBoolean();
                if (asignar) {
                    Barrio otroBarrio = barrios.get(j);

                    // Calcula la distancia euclidiana entre los barrios
                    double distancia = Math.sqrt(Math.pow(otroBarrio.getX() - barrio.getX(), 2) +
                            Math.pow(otroBarrio.getY() - barrio.getY(), 2));

                    c.insArista(i, j, distancia);
                }
            }
            
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
    
    public void agregarDistancia(int vi, int vf, double costo){
        c.insArista(vi ,vf ,costo);
    }
    
    public double obtenerDistancia(int vi, int vf){
        return c.obtArista(vi, vf);
    }
    
    public double noHayCamino(int vi, int vf){
        return c.infinito();
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
        boolean asignar;
        for (int i = 0; i < c.orden(); i++) {
            asignar = random.nextBoolean();
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
