/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cminimos;

import ednl.Grafo;

/**
 *
 * @author CARLOS
 */
public class Floyd {
    Grafo<String, Integer> grafo;
    public int f[][]; //FLOYD
    int r[][]; // rutA

    public Floyd(Grafo<String, Integer> grafo) {
        this.grafo = grafo;
        int n= grafo.orden();
        f=new int[n][n];
        r=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j]=grafo.obtArista(i, j);
                r[i][j]=-1; // ruta que guarda las k
            }
        }
        cminimo();
    }

    public  void cminimo() {
        int n=grafo.orden();
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n ; j++) {
                    int costo= f[i][k]+f[k][j];
                    if(costo< f[i][j]){
                        f[i][j]=costo;
                        r[i][j]=k;
                    }
                }
            }
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