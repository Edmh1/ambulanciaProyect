/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import datos.Ciudad;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author ESTUDIANTE
 */
public class Serializar {
    
    public void save(Ciudad ciudad) throws FileNotFoundException, IOException{
        FileOutputStream file = new FileOutputStream("ciudad.data");
        ObjectOutputStream output = new ObjectOutputStream(file);
        output.writeObject(ciudad);
        output.close();
        file.close();
    }
    
    public Ciudad toGet() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream file = new FileInputStream("ciudad.data");
        ObjectInputStream input = new ObjectInputStream(file);
        Ciudad ob = (Ciudad) input.readObject();
        
        input.close();
        file.close();
        return ob;
    }
    
}

