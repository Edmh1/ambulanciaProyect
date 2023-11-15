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
public interface Grafo<V,A> {
    void insVertice(V x);
    V obtVertice(int pos);
    void insArista(int vi, int vf, A costo);
    void elimArista(int vi, int vf);
    A obtArista(int vi, int vf);
    int orden();
    ArrayList<V> sucesores(int v);
    A infinito();
    
}
