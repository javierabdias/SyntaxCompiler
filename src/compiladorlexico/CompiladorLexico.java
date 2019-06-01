/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladorlexico;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author abdias
 */
public class CompiladorLexico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader f = new FileReader("/home/abdias/NetBeansProjects/CompiladorLexico/src/compiladorlexico/programa.txt");
        Lexico lexico = new Lexico(f);        
        tabla.imprimir();
        
    }
    
}
