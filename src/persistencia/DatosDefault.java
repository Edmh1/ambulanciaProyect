/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import datos.Ciudad;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author edavi
 */
public class DatosDefault {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Ciudad santaMarta = new Ciudad(20,5);
        
         // Serializar y guardar los jugadores
        Serializar persi = new Serializar();
        persi.save(santaMarta);

        // Recuperar y mostrar los jugadores
        if(new File("ciudad.data").exists()){
            Ciudad recuperar = persi.toGet();
            System.out.println(" " + recuperar.getnBarrios());
        }
        
    }
}
