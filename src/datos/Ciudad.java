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
public class Ciudad {
    
    Grafo<Barrio, Integer> c;

    public Ciudad() {
        this.c = new GrafoEstMat<>(99999);
    }
    
}
