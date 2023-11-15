/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import ednl.Grafo;
import ednl.GrafoEstMat;

/**
 *
 * @author edavi
 */
public class SantaMarta {
    
    Grafo<Barrio, Integer> c;

    public SantaMarta() {
        this.c = new GrafoEstMat<>(99999);
    }
    
}
