/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import datos.Ciudad;

/**
 *
 * @author edavi
 */
public class test {
    
    public static void main(String[] args) {
        Ciudad sanCiudad = new Ciudad(20, 5);
        System.out.println(""+sanCiudad.obtenerDistancia(5, 1));
        System.out.println(""+ sanCiudad.ambulanciaMasCercana(5));
    }
}
