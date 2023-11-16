/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cminimos;

import java.util.HashSet;
import ednl.Grafo;

/**
 *
 * @author edavi
 */
public class Dijkstra {
    Grafo<String, Integer> grafo;
    int origen;
    public int d[];
    HashSet<String> visitados;

    public Dijkstra(Grafo<String, Integer> grafo, int origen) {
        this.grafo = grafo;
        this.origen = origen;
        d= new int[grafo.orden()];
        for (int i = 0; i < grafo.orden(); i++) {
            d[i]= grafo.obtArista(origen, i);
        }
        visitados=new HashSet<>();
        cminimo();
    }

    private void cminimo() {
        visitados.add(grafo.obtVertice(origen));
        for (int i = 0; i < grafo.orden(); i++) {
            int v = menor();
            visitados.add(grafo.obtVertice(v));
            for (int w = 0; w < grafo.orden(); w++) {
                if(!visitados.contains(grafo.obtVertice(w))){
                   d[w]=Integer.min(d[w], d[v]+grafo.obtArista(v, w));
                   
                }
            }
        }
    }

    private int menor() {
        int menor=grafo.infinito();
        int vmenor=0;
        for (int i = 0; i < grafo.orden(); i++) {
            if(!visitados.contains(grafo.obtVertice(i))){
                int costo= d[i];
                if(costo<menor){
                    menor=costo;
                    vmenor=i;
                }
                
            }
        }
        return vmenor;
    }
    
    
}
