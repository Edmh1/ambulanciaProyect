/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cminimos;

import datos.Barrio;
import ednl.Grafo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author edavi
 */
public class Floyd {
    Grafo<Barrio, Double> grafo;
    public double f[][]; //FLOYD
    int r[][]; // rutA
    
    Stack<Integer> ruta;

    public Floyd(Grafo<Barrio, Double> grafo) {
        this.grafo = grafo;
        int n= grafo.orden();
        f=new double [n][n];
        r=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j]= grafo.obtArista(i, j);
                r[i][j]=-1; // ruta que guarda las k
            }
        }
        ruta = new Stack<>();
        cminimo();
    }

    public  void cminimo() {
        int n=grafo.orden();
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n ; j++) {
                    double costo= f[i][k]+f[k][j];
                    if(costo< f[i][j]){
                        f[i][j]=costo;
                        r[i][j]=k;
                    }
                }
            }
        }
    }
    public Stack<Integer> ruta(int i, int j){
        ruta.clear();
        ruta2(i, j);
        return ruta;
    }
    
    //para hallar la menor ruta de un punto a otro 
    private void ruta2(int i, int j){
        int k = r[i][j];
        if(k!=-1){
            ruta(i,k);
            ruta.push(k);
            ruta(k, j);
        }
    }
    
    public String solucion(){
        String lis="";
        for (int i = 0; i < grafo.orden(); i++) {
            for (int j = 0; j < grafo.orden(); j++) {
                lis+=" "+f[i][j];
            }
            lis+="\n";
        }
        return lis;
    }
    
    
}
