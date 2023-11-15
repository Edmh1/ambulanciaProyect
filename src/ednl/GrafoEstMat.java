/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ednl;

import java.util.ArrayList;

/**
 *
 * @author ESTUDIANTE
 */
public class GrafoEstMat<V,A> implements Grafo<V, A>{
    private ArrayList<V> vertices;
    private Object aristas[][];
    private A inf;

    public GrafoEstMat(A inf) {
        this.inf = inf;
        vertices= new ArrayList<>();
        aristas= new Object[1000][1000];
        for (int i = 0; i < aristas.length; i++) {
            for (int j = 0; j < aristas.length; j++) {
                if(i==j)
                    aristas[i][j]=0;
                else
                    aristas[i][j]=inf;
                
            }
            
        }
        
    }
    
    @Override
    public void insVertice(V x) {
        vertices.add(x);
    }

    @Override
    public V obtVertice(int pos) {
        return vertices.get(pos);
    }

    @Override
    public void insArista(int vi, int vf, A costo) {
        aristas[vi][vf]=costo;
    }

    @Override
    public void elimArista(int vi, int vf) {
        aristas[vi][vf]=inf;
    }

    @Override
    public A obtArista(int vi, int vf) {
        return (A) aristas[vi][vf];
    }

    @Override
    public int orden() {
        return vertices.size(); //numero de vertices
    }

    @Override
    public ArrayList<V> sucesores(int v) {
        ArrayList<V> suc=new ArrayList<>();
        for (int i = 0; i < orden(); i++) {
            A costo= (A) aristas[v][i];
            if(i!=v && costo!=inf){
                suc.add(obtVertice(i));
            }
        }
        return suc;
    }

    @Override
    public A infinito() {
        return inf;
    }

    @Override
    public String toString() {
        return "GrafoEstMat{" + "vertices=" + vertices + ", aristas=" + mostrar() + ", inf=" + inf + '}';
    }

    private String mostrar() {
        String lis="\n";
        for (int i = 0; i < orden(); i++) {
            for (int j = 0; j < orden(); j++) {
                lis+=" "+aristas[i][j]+" ";
            }
            lis+="\n";
        }
        return lis;
    }

   
    
    
    
    
}
