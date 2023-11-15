/*
Recorrid
 */
package ednl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author ESTUDIANTE
 */
public class Recorridos {
    Grafo<String, Integer> grafo; 
    int verticeInicial; 
    HashSet<String> visitados;  //para no visitar dos veces un vertice 
    
    public Recorridos() {
        visitados = new HashSet<>(); 
    }
    
    
    
    //profuncidad - dfs
    public void dfs(Grafo<String, Integer> g, int verticeInicial){
        grafo = g; 
        this.verticeInicial = verticeInicial; 
        visitados.clear();
        
        profundidad(g, verticeInicial); 
    }
    
    private void profundidad(Grafo<String, Integer> g, int verticeInicial) {
        System.out.println(" "+g.obtVertice(verticeInicial));
        visitados.add(g.obtVertice(verticeInicial)); 
        ArrayList<String> sucesores = g.sucesores(verticeInicial); 
        for (String sucesor : sucesores){
            if(!visitados.contains(sucesor)){
                profundidad(g, buscar(sucesor));   //buscar dado el vertice y nos de la posicion, se usa recursividad
            }
        }
    }
    private int buscar(String sucesores){
        for (int i = 0; i < grafo.orden(); i++) {
            if(grafo.obtVertice(i).equals(sucesores)){
                return i; 
            }
        }
        return -1; 
    }
    
    
    //anchura 
    
    public void bfs(Grafo<String, Integer> g, int verticeInicial){
        grafo = g; 
        this.verticeInicial = verticeInicial; 
        visitados.clear();
        anchura(g, verticeInicial); 
    }
    
    private void anchura(Grafo<String, Integer> g, int verticeInicial) {   //usamos na cola para trabajar con los sucesores ordenados
        LinkedList<String> cola = new LinkedList<>();   //en la cola se inserta al final, se elimina al inicio
        visitados.add(g.obtVertice(verticeInicial)); 
        cola.addLast(g.obtVertice(verticeInicial));
        
        while(!cola.isEmpty()){
            String vertice = cola.removeFirst();
            System.out.println(" "+vertice);
            ArrayList<String> sucesores = grafo.sucesores(buscar(vertice)); 
            for (String sucesor : sucesores) {
                if(!visitados.contains(sucesor)){
                    cola.addLast(sucesor);
                    visitados.add(sucesor); 
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    Grafo<String, Integer> grafo;
//    int vi;
//    HashSet<String> visitados;
//    
//    public Recorridos(){
//        visitados = new HashSet<>();
//    }
//    public void dfs(Grafo<String, Integer> g, int vi){
//        grafo = g;
//        this.vi = vi;
//        visitados.clear();
//        profundidad(g, vi);
//    }
//    //anchura
//    public void bfs(Grafo<String, Integer> g, int vi){
//        grafo = g;
//        this.vi = vi;
//        visitados.clear();
//        anchura(g, vi);
//    }
//    
//    
//    private void profundidad(Grafo<String, Integer> g, int vi){
//        System.out.println(" "+g.obtVertice(vi));
//        visitados.add(g.obtVertice(vi));
//        ArrayList<String> sucesores = g.sucesores(vi);
//        for (String sucesore : sucesores) {
//            if(!visitados.contains(sucesore)){
//                profundidad(g, posicion(sucesore));
//            }
//        }
//    }
//
//    private int posicion(String sucesore) {
//        for (int i = 0; i < grafo.orden(); i++) {
//            if(grafo.obtVertice(i).equals(sucesore)){
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    private void anchura(Grafo<String, Integer> g, int vi) {
//        LinkedList<String> cola = new LinkedList<>();
//        
//        cola.addLast(g.obtVertice(vi));
//        visitados.add(g.obtVertice(vi));
//        while(!cola.isEmpty()){ //si la cola NO esta vacia
//            String ver = cola.getFirst();
//            System.out.println(" "+ver);
//            cola.removeFirst();
//            ArrayList<String> sucesores = g.sucesores(posicion(ver));
//            for (String sucesore : sucesores) {
//                if(!visitados.contains(sucesore)){
//                    cola.addLast(sucesore);
//                    visitados.add(sucesore);
//                }
//            }
//        }
//    }

    

  

    

    
}
