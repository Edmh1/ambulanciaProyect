/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import cminimos.Floyd;
import ednl.Grafo;
import ednl.GrafoEstMat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author edavi
 */
public class Ciudad {
    private Grafo<Barrio, Double> c;
    private int nBarrios;
    private int nAmbulancias;
    public int nAccidentes;

    public Ciudad(int nBarrios, int nAmbulancias) {
        this.c = new GrafoEstMat<>(99999.9);
        this.nAmbulancias = nAmbulancias;
        this.nBarrios = nBarrios;
        this.nAccidentes = 0;
        
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
           
            int asignar;
            for (int j = 0; j < nBarrios; j++) {
                if(j == i){
                    c.insArista(i, j, 0.0);
                }
                else{
                    asignar = (int) (Math.random()*100);
                    if (asignar < 20) {
                        Barrio otroBarrio = barrios.get(j);

                        // Calcula la distancia euclidiana entre los barrios
                        double distancia = Math.sqrt(Math.pow(otroBarrio.getX() - barrio.getX(), 2) +
                                Math.pow(otroBarrio.getY() - barrio.getY(), 2));

                        c.insArista(i, j, distancia);
                    }
                    else{
                        c.insArista(i, j, c.infinito());
                    }  
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
    public Ambulancia ambulanciaMasCercana(int pos){
        Floyd flo = new Floyd(c);
        Ambulancia masCercana = null;
        double menor = c.infinito();
        for (int i = 0; i < c.orden(); i++) {
            if(flo.f[i][pos] < menor && c.obtVertice(pos).getAmbulancia()!= null){
                menor = flo.f[i][pos];
                masCercana = c.obtVertice(pos).getAmbulancia();
            }
        }
        return masCercana;
    }
    //4
    public String cantidadDeIncidentesTotales(){
        return "La cantidad de accidente que hubo en santamarta fue: " + nAccidentes + "\n";
    }
    
    public String cantidadDeIncidentesBarrio(int pos){
        Barrio b = c.obtVertice(pos);
        return "La cantidad de accidentes que hubo en el barrio pos fue: " + b.getnAccidentes() + "\n";
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
    
    public int buscar(Barrio barrio){
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

    /**
     * @return the nAccidentes
     */
    public int getnAccidentes() {
        return nAccidentes;
    }
}