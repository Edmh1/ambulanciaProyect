/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import datos.Ciudad;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import persistencia.Serializar;

/**
 *
 * @author edavi
 */
public class test {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        Serializar persi = new Serializar();
        if(new File("ciudad.data").exists()){
            Ciudad recuperar = persi.toGet();
            System.out.println(" " + recuperar.getnBarrios());
        }
    }
}
